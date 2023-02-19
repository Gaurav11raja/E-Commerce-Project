package com.reza.ecommerse.model.transaction;

import com.reza.ecommerse.model.account.AccountInfo;
import com.reza.ecommerse.model.common.BaseModel;
import com.reza.ecommerse.model.file.File;
import com.reza.ecommerse.model.master.Item;

import javax.persistence.*;

@Entity
@Table(name = "transaction_review")
public class TransactionReview extends BaseModel {
    private AccountInfo customer;
    private Item item;
    private String reviewDetail;
    private File file;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public AccountInfo getCustomer() { return customer; }
    public void setCustomer(AccountInfo customer) { this.customer = customer; }

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    @Column(name = "review_detail")
    public String getReviewDetail() { return reviewDetail; }
    public void setReviewDetail(String reviewDetail) { this.reviewDetail = reviewDetail; }

    @ManyToOne
    @JoinColumn(name = "file_id")
    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }
}
