package com.bdtube.bdtube.Model;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
@Setter

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private int id_account;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user ;

    public Account() {
    }

    private String password ;
    @Override
    public String toString() {
        return "Account{" +
                "id_account=" + id_account +
                ", user=" + user +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public Account(User user, String password, String username) {
        this.user = user;
        this.password = password;
        this.username = username;
    }

    private String username ;
    public int getId_account() {
        return id_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
