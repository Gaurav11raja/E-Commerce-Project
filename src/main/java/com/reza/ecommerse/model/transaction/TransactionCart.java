package com.reza.ecommerse.model.transaction;

import com.reza.ecommerse.model.account.AccountInfo;
import com.reza.ecommerse.model.common.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_cart")
public class TransactionCart extends BaseModel {
    private AccountInfo account;
    private BigDecimal totalPrice;
    private Boolean isSuccess;

    @ManyToOne
    @JoinColumn(name = "account_id")
    public AccountInfo getAccount() { return account; }
    public void setAccount(AccountInfo account) { this.account = account; }

    @Column(name = "total_price")
    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    @Column(name = "is_success")
    public Boolean getSuccess() { return isSuccess; }
    public void setSuccess(Boolean success) { isSuccess = success; }
}
