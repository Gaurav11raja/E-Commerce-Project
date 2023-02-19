package com.reza.ecommerse.model.transaction;

import com.reza.ecommerse.model.common.BaseModel;
import com.reza.ecommerse.model.master.Item;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_item")
public class TransactionItem extends BaseModel {
    private Item item;
    private Long quantity;
    private BigDecimal total;
    private TransactionCart cart;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    @Column(name = "quantity")
    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    @Column(name = "total_price")
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    @ManyToOne
    @JoinColumn(name = "cart_id")
    public TransactionCart getCart() { return cart; }
    public void setCart(TransactionCart cart) { this.cart = cart; }
}
