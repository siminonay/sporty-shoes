package com.sportyshoes.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;  //PK

    private String categoryname;

    @OneToMany
    @JoinColumn(name = "categoryid")
    List<Product> productList;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", categoryname='" + categoryname + '\'' +
                ", productList=" + productList +
                '}';
    }


}
