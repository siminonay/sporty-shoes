package com.sportyshoes.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;  //PK

    @DateTimeFormat(pattern = "YYYY-mm-dd")
    private LocalDate odate;

    private String omail;       //FK

    private Integer productid;		//FK

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public LocalDate getOdate() {
        return odate;
    }

    public void setOdate(LocalDate odate) {
        this.odate = odate;
    }

    public String getOmail() {
        return omail;
    }

    public void setOmail(String omail) {
        this.omail = omail;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }


}
