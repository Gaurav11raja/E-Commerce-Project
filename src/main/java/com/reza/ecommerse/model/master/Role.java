package com.reza.ecommerse.model.master;

import com.reza.ecommerse.model.common.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends BaseModel {

    @Column(name = "role_name", length = 20)
    private String name;
    @Column(name = "role_code", length = 5, unique = true)
    private String code;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
}
