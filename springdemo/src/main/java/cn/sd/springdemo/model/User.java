package cn.sd.springdemo.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private double balance;

    public User() {
        super();
    }
}


