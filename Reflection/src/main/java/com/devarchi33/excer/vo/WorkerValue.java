package com.devarchi33.excer.vo;

/**
 * Created by donghoon on 2015. 12. 18..
 */
public class WorkerValue {

    private static int POSITION_MANAGER = 0;
    private static int POSITION_ASSISTANT = 1;
    private static int POSITION_EMPLOYEE = 2;

    private String name;
    private int position;

    public WorkerValue() {
        name = null;
        position = Integer.MAX_VALUE;
    }

    public WorkerValue(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WorkerValue: [name=");
        sb.append(name);
        sb.append(", position=");
        sb.append(position);
        sb.append("]");
        return sb.toString();
    }
}
