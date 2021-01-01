package com.nkwasniak.carExchange.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 50, nullable = false)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "role", length = 50, nullable = false)
    private String role = "USER";

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ForRent> forRentList;

    public void addForRentAdvert(ForRent forRent){
        forRentList.add(forRent);
        forRent.setUser(this);
    }

    public void removeForRentAdvert(ForRent forRent){
        forRentList.remove(forRent);
        forRent.setUser(null);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public List<ForRent> getForRentList() {
        return forRentList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setForRentList(List<ForRent> forRentList) {
        this.forRentList = forRentList;
    }

    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    public static final class UserBuilder {
        private Long id;
        private String name;
        private String username;
        private String password;
        private String phone;
        private String email;
        private String role = "USER";
        private List<ForRent> forRentList;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withRole(String role) {
            this.role = role;
            return this;
        }

        public UserBuilder withForRentList(List<ForRent> forRentList) {
            this.forRentList = forRentList;
            return this;
        }

        public User build() {
            User user = new User();
            user.role = this.role;
            user.name = this.name;
            user.email = this.email;
            user.phone = this.phone;
            user.username = this.username;
            user.password = this.password;
            user.id = this.id;
            user.forRentList = this.forRentList;
            return user;
        }
    }
}
