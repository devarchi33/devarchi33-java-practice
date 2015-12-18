package com.devarchi33.excer;

import com.devarchi33.excer.vo.WorkerValue;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class ReflectionSample04 {

    public static void main(String[] args) {
        WorkerValue wv = new WorkerValue("DHL", WorkerValue.POSITION_EMPLOYEE);
        Class clazz = wv.getClass();

        try {
            //새로운 객체를 생성하는 구문.
            Object obj = clazz.newInstance();

            if (obj instanceof WorkerValue)
                System.out.println("This is WorkerValue class object.");

            System.out.println("Variable workerVo: hashCode= " + System.identityHashCode(wv));
            System.out.println("Variable workerVo: hashCode= " + System.identityHashCode(obj));

            WorkerValue wv2 = (WorkerValue) obj;
            System.out.println("wv2 Name: " + wv2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
