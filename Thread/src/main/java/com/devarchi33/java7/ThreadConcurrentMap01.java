package com.devarchi33.java7;

import java.util.*;

/**
 * Created by donghoon on 2015. 12. 30..
 * 문제: 서로 다르지만 연관된 여러 컬렉션을 동시에 수정하고 싶다. 그리고 이 수정작업을 완료하기 전에는 다른 스레드가 작업중인 컬렉션에 절대 접근하지 못하게 하고 싶다.
 */
public class ThreadConcurrentMap01 {

    Set<Thread> orderingThreads = new HashSet<>();
    final HashMap<String, Integer> inventoryMap = new LinkedHashMap<>();
    List<CustomerOrder> customerOrders = new ArrayList<>();
    Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        ThreadConcurrentMap01 tr = new ThreadConcurrentMap01();
        tr.start();
    }

    private void start() throws InterruptedException {

        // inventoryMap의 각 키에 자원할당.
        for (int i = 0; i < 100; i++) {
            inventoryMap.put("Donghoon Book #" + i, 1000);
        }

        // inventoryMap을 갱신하는 스레드 생성.
        for (int i = 0; i < 20; i++) {
            createOrderingThread();
        }

        Thread.sleep(100);

        // inventoryMap 갱신하는 스레드가 작업도중 inventoryMap 순회 시도 -> 수정중이라 접근 안됨.
        checkInventoryLevels();

        Thread.sleep(100);

        for (Thread thread :
                orderingThreads) {
            thread.interrupt();
        }

        Thread.sleep(1000);

        // inventoryMap 갱신 작업이 완료된 이후 inventoryMap 순회 시도 -> 수정완료 이후라 접근 가능.
        checkInventoryLevels();
        // CustomerOrder List에서 주문 정보 출력.
        displayOrders();
    }

    private void displayOrders() {
        synchronized (inventoryMap) {
            for (CustomerOrder order :
                    customerOrders) {
                System.out.println(order.getQuantityOrdered() + " " + order.getItemOrdered() + " for " + order.getCustomerName());
            }
        }
    }

    private void createOrderingThread() {
        Thread orderingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    createRandomOrder();
                }
            }
        });
        orderingThread.start();
        orderingThreads.add(orderingThread);
    }

    private void createRandomOrder() {
        String itemOrdered = "Donghoon Book #" + random.nextInt(100);
        int quantityOrdered = random.nextInt(3) + 1;
        String customerName = "Customer: " + UUID.randomUUID().toString();
        fullfillOrder(itemOrdered, quantityOrdered, customerName);
    }

    private boolean fullfillOrder(String itemOrdered, int quantityOrdered, String customerName) {
        synchronized (inventoryMap) {
            int currentInventory = inventoryMap.get(itemOrdered); //현재 inventoryMap의 value.
            if (currentInventory < quantityOrdered) {
                System.out.println("Couldn't fulfill order for " + customerName + " not enough " + itemOrdered + " (" + quantityOrdered + ") ");
                return false;
            }
            inventoryMap.put(itemOrdered, currentInventory - quantityOrdered); // 주문량 만큼 inventoryMap의 value 갱신.
            CustomerOrder order = new CustomerOrder(itemOrdered, quantityOrdered, customerName);
            customerOrders.add(order);
            System.out.println("Order fullfilled fo " + customerName + " of " + itemOrdered + " (" + quantityOrdered + ") ");
            return true;
        }
    }

    private void checkInventoryLevels() {
        synchronized (inventoryMap) {
            System.out.println("==========================================================================================");
            for (Map.Entry<String, Integer> entry : inventoryMap.entrySet()) {
                System.out.println("Inventory Level: " + entry.getKey() + ", Value: " + entry.getValue());
            }
            System.out.println("==========================================================================================");
        }
    }

    class CustomerOrder {
        String itemOrdered; // inventoryMap의 key.
        int quantityOrdered; // inventoryMap의 value.
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
