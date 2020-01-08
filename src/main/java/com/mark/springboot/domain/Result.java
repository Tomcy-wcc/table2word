package com.mark.springboot.domain;

public class Result {

    private InterfaceInfo data;

    public InterfaceInfo getData() {
        return data;
    }

    public void setData(InterfaceInfo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                '}';
    }
}
