package com.bdtube.bdtube.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id_User;
    private  int has_account;
    @NotBlank
    private String username;

    public int getHas_account() {
        return has_account;
    }

    public void setHas_account(int has_account) {
        this.has_account = has_account;
    }

    private Role role ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @OneToMany(mappedBy = "user_acceptation",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @com.fasterxml.jackson.annotation.JsonIgnoreProperties("user_acceptation")
    private List<VideoDemander> videodemander;
    public User() {

    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public List<Chanel> getChanel() {
        return chanel;
    }

    public void setChanel(List<Chanel> chanel) {
        this.chanel = chanel;
    }
    @OneToMany(mappedBy = "owner")
    private List<Chanel> chanel;

    public User(List<VideoDemander> videodemander) {
        this.videodemander = videodemander;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_User=" + id_User +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", chanel=" + chanel +
                '}';
    }
}
