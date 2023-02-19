package com.reza.ecommerse.model.master;

import com.reza.ecommerse.model.common.BaseModel;
import com.reza.ecommerse.model.file.File;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item extends BaseModel {
    private String name;
    private Category category;
    private BigDecimal price;
    private Long quantity;
    private String description;
    private Long reputation;
    private File file;

    @Column(name = "item_name", length = 50)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Column(name = "description", length = 255)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "reputation")
    public Long getReputation() { return reputation; }
    public void setReputation(Long reputation) { this.reputation = reputation; }

    @ManyToOne
    @JoinColumn(name = "file_id")
    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
