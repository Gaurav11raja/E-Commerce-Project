package com.reza.ecommerse.model.transaction;

import com.reza.ecommerse.model.account.AccountInfo;
import com.reza.ecommerse.model.common.BaseModel;
import com.reza.ecommerse.model.master.Item;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_history")
public class TransactionHistory extends BaseModel {
    private Item item;
    private Long quantity;
    private BigDecimal totalPrice;
    private AccountInfo customer;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    @Column(name = "quantity")
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    @Column(name = "total_price")
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    @ManyToOne
    @JoinColumn(name = "cust_id")
    public AccountInfo getCustomer() { return customer; }
    public void setCustomer(AccountInfo customer) { this.customer = customer; }
}
