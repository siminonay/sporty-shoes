package com.sportyshoes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;  //PK

    private String pname;

    private float price;

    private int quantity;

    private Integer categoryid;  //FK

    @OneToMany
    @JoinColumn(name = "productid")
    private List<Orders> listOfOrders;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public List<Orders> getListOfOrders() {
        return listOfOrders;
    }

    public void setListOfOrders(List<Orders> listOfOrders) {
        this.listOfOrders = listOfOrders;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categoryid=" + categoryid +
                ", listOfOrders=" + listOfOrders +
                '}';
    }
}
