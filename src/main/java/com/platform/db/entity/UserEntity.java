package com.platform.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user", schema = "platform")
public class UserEntity implements Serializable{
    private Integer id;
    private String userName;
    private AccessLevel accessLevel;
    private String password;
    private String token;
    private Timestamp lastLogin;
    private String email;
    private Timestamp dateCreated;


    private Set<PostEntity> post = new HashSet<PostEntity>();

    public UserEntity(String userName, AccessLevel accessLevel, String password, String token, Timestamp lastLogin, String email, Timestamp dateCreated) {
        this.id = id;
        this.userName = userName;
        this.accessLevel = accessLevel;
        this.password = password;
        this.token = token;
        this.lastLogin = lastLogin;
        this.email = email;
        this.dateCreated = dateCreated;
    }

    public UserEntity() {
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userId")
    @JsonIgnore
    public Set<PostEntity> getPost() {
        return post;
    }

    public void setPost(Set<PostEntity> post) {
        this.post = post;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String login) {
        this.userName = login;
    }

    @Basic
    @Column(name = "access_level")
    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "last_login")
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity entity = (UserEntity) o;

        if (accessLevel != entity.accessLevel) return false;
        if (id != null ? !id.equals(entity.id) : entity.id != null) return false;
        if (userName != null ? !userName.equals(entity.userName) : entity.userName != null) return false;
        if (password != null ? !password.equals(entity.password) : entity.password != null) return false;
        if (token != null ? !token.equals(entity.token) : entity.token != null) return false;
        if (lastLogin != null ? !lastLogin.equals(entity.lastLogin) : entity.lastLogin != null) return false;
        if (email != null ? !email.equals(entity.email) : entity.email != null) return false;
        return dateCreated != null ? dateCreated.equals(entity.dateCreated) : entity.dateCreated == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (int) accessLevel.code();
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (lastLogin != null ? lastLogin.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", accessLevel=" + accessLevel.name() +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", lastLogin=" + lastLogin +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }


}
