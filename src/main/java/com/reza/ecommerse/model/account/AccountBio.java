package com.reza.ecommerse.model.account;

import com.reza.ecommerse.model.file.File;
import com.reza.ecommerse.model.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "account_bio")
public class AccountBio extends BaseModel {

    private String fullName;
    private String phoneNumber;
    private String address;
    private File file;

    @Column(name = "full_name", length = 255)
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    @Column(name = "phone_number", length = 12)
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Column(name = "address", length = 255)
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @ManyToOne
    @JoinColumn(name = "file_id")
    public File getFile() { return file; }
    public void setFile(File file) { this.file = file; }
}
