package com.stunstun.spring.repository.entity;

/**
 * @author minhyeok
 */
public class Transaction {

    private Long id;

    private String userName;

    private Integer price;

    protected Transaction() {}

    public Transaction(String userName, int price) {
        this.userName = userName;
        this.price = price;
    }

    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof User) {
            if (((User) other).getId() == this.id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (userName == null ? userName.length() : 0);
    }

    @Override
    public String toString() {
        return "id[" + id +"] userName[" + userName + "] price[" + price + "]";
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
