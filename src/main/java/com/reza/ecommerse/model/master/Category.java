package com.reza.ecommerse.model.master;

import com.reza.ecommerse.model.common.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseModel {
    private String name;
    private String code;

    @Column(name = "category_name", length = 50)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Column(name = "code", length = 5)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
