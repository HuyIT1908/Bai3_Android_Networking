package com.quangcao.bai3.POST;

public class SVResponseProductsPOST {
    // POST
    private ProductsPOST products; // đặt tên giống tên bảng trong database
    private String message;
    private String result;

    public ProductsPOST getProducts() {
        return products;
    }

    public String getMessage() {
        return message;
    }

    public String getResult() {
        return result;
    }
}
