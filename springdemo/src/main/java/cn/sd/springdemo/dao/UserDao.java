package cn.sd.springdemo.dao;

public interface UserDao {
    public double getBalance(int uid);
    public void updateBalance(int uid,double amount);
}
