package com.devarchi33.java7;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by donghoon on 2015. 12. 30..
 */
public class ThreadConcurrentMapLock {

    Set<Thread> orderingThreads = new HashSet<>();
    final Map<String, Integer> inventoryMap = new LinkedHashMap<>();
    List<CustomerOrder> customerOrders = new ArrayList<>();
    Random random = new Random();
    Lock inventoryLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ThreadConcurrentMapLock tl = new ThreadConcurrentMapLock();
        tl.start();
    }

    private void start() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            inventoryMap.put("Dong-Hoon Book #" + i, 1000);
        }

        for (int i = 0; i < 20; i++) {
            createOrderingThread();
        }

        Thread.sleep(100);

        checkInventoryLevel();

        Thread.sleep(100);

        for (Thread thread :
                orderingThreads) {
            thread.interrupt();
        }

        Thread.sleep(1000);

        checkInventoryLevel();
        displayOrders();
    }

    private void displayOrders() {
        try {
            inventoryLock.lock();
            for (CustomerOrder order :
                    customerOrders) {
                System.out.println(order.getQuantityOrdered() + " " + order.getItemOrdered() + " for " + order.getCustomerName());
            }
        } finally {
            inventoryLock.unlock();
        }
    }

    private void createOrderingThread() {
        Thread orderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    createRandomOrder();
                }
            }
        });

        orderThread.start();
        orderingThreads.add(orderThread);
    }

    private void createRandomOrder() {
        String itemOrdered = "Dong-Hoon Book #" + random.nextInt(100);
        int quantityOrdered = random.nextInt(2) + 1;
        String customerName = UUID.randomUUID().toString();
        fulfillOrder(itemOrdered, quantityOrdered, customerName);
    }

    private boolean fulfillOrder(String itemOrdered, int quantityOrdered, String customerName) {
        try {
            inventoryLock.lock();
            int currentInventory = inventoryMap.get(itemOrdered);
            if (currentInventory < quantityOrdered) {
                System.out.println("Couldn't fulfill order for " + customerName + " not enough " + itemOrdered + " (" + quantityOrdered + ")");
                return false;
            }

            inventoryMap.put(itemOrdered, currentInventory - quantityOrdered);
            CustomerOrder order = new CustomerOrder(itemOrdered, quantityOrdered, customerName);
            customerOrders.add(order);
            System.out.println("Order fulfilled for " + customerName + " of " + itemOrdered + " (" + quantityOrdered + ")");
            return true;
        } finally {
            inventoryLock.unlock();
        }
    }

    private void checkInventoryLevel() {
        try {
            inventoryLock.lock();
            System.out.println("------------------------------------");
            for (Map.Entry<String, Integer> inventoryEntry :
                    inventoryMap.entrySet()) {
                System.out.println("Inventory Level :" + inventoryEntry.getKey() + " " + inventoryEntry.getValue());
            }
            System.out.println("------------------------------------");
        } finally {
            inventoryLock.unlock();
        }
    }

    class CustomerOrder {
        String itemOrdered;
        int quantityOrdered;
        String customerName;

        public CustomerOrder(String itemOrdered, int quantityOrdered, String customerName) {
            this.itemOrdered = itemOrdered;
            this.quantityOrdered = quantityOrdered;
            this.customerName = customerName;
        }

        public String getItemOrdered() {
            return itemOrdered;
        }

        public int getQuantityOrdered() {
            return quantityOrdered;
        }

        public String getCustomerName() {
            return customerName;
        }
    }
}
