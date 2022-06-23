package com.budgetapp.budgetapp.domain;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    private Integer id;
    @Column(nullable = false)
    private Boolean success;
    @Column(nullable = false)
    private Date date;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("id")
    private User user;

    public Log() {
    }

    public Log(Boolean success, Date date) {
        this.success = success;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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
        return "Log{" + "id=" + id + ", date=" + date + '}';
    }
}
