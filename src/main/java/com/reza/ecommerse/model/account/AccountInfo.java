package com.reza.ecommerse.model.account;

import com.reza.ecommerse.model.common.BaseModel;
import com.reza.ecommerse.model.master.Role;

import javax.persistence.*;

@Entity
@Table(name = "account_info")
public class AccountInfo extends BaseModel {

    private String email;
    private String password;
    private Role role;
    private AccountBio accountBio;
    private Long loginCounter;
    private Long codeRegistration;
    private String sessionId;
    private Boolean isActive;

    @Column(name = "email", length = 255)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Column(name = "pass", length = 255)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    @ManyToOne
    @JoinColumn(name = "account_bio_id")
    public AccountBio getAccountBio() { return accountBio; }
    public void setAccountBio(AccountBio accountBio) { this.accountBio = accountBio; }

    @Column(name = "login_counter")
    public Long getLoginCounter() { return loginCounter; }
    public void setLoginCounter(Long loginCounter) { this.loginCounter = loginCounter; }

    @Column(name = "code_registration", length = 8)
    public Long getCodeRegistration() { return codeRegistration; }
    public void setCodeRegistration(Long codeRegistration) { this.codeRegistration = codeRegistration; }

    @Column(name = "session_id", length = 255)
    public String getSessionId() { return sessionId; }
    public void setSessionId(String sessionId) { this.sessionId = sessionId; }

    @Column(name = "is_active")
    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }
}
