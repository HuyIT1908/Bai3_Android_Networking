package com.quangcao.bai3;

public class SvResponseProducts {
    // GET
    private Products[] products; // products không được đổi tên ( để tên giống với dữ liệu trên API )
    private String message;
    private String result;

    public Products[] getProducts() {
        return products;
    }

    public String getMessage() {
        return message;
    }

    public String getResult() {
        return result;
    }
}
