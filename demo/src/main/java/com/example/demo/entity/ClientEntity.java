package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
        private int id;
    @Column(name = "name", nullable = false)
        private String name;

    @Column(name = "firstname", nullable = false)
    @NotNull(message = "First name must not be null")
    private String firstname;
    @Column(name = "lastname", nullable = false)
    @NotNull(message = "First name must not be null")
    private String lastname;
    @Column(name = "email", nullable = false)
        private String email;
    @Column(name = "phone", nullable = false)
        private String phone;
    @Column(name = "address", nullable = false)
        private String address;
    @Column(name = "status" ,nullable = false)
        private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createdAt", nullable = false)
        private LocalDate createdAt;
public ClientEntity() {

}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firtname) {
        this.firstname = firtname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
