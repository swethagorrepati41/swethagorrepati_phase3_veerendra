package com.simplilearn.shoestore.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    int order_id;

    @Column(name="order_number")
    int order_number;


    @OneToOne
    @JoinColumn(name="pid")
    Product product;

    @OneToOne
    @JoinColumn(name="uid")
    User user;

    @Column(name="orderedon")
    Date orderedon;

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderedon(Date orderedon) {
        this.orderedon = orderedon;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getOrder_number() {
        return order_number;
    }

    public Product getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    public Date getOrderedon() {
        return orderedon;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", order_number=" + order_number +
                ", product=" + product +
                ", user=" + user +
                ", ordered_on=" + orderedon +
                '}';
    }
}
