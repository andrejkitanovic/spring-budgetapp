package com.budgetapp.budgetapp.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "incomes")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    private Integer id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Float value;
    @Column(nullable = false)
    private Date date;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("id")
    private User user;

    public Income() {
    }

    public Income(String description, Float value, Date date) {
        this.description = description;
        this.value = value;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Income{" + "id=" + id + ", description=" + description + ", value=" + value + ", date=" + date + '}';
    }
}
