package cn.sd.springdemo.dao;

public interface ClothesDao {
    public double getPrice(int cid);
    public int getInventory(int cid);
    public void updateInventory(int cid,int amount);//amount:衣服修改的数量
}
