package com.it355pz.IT355PZV2.domain;

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
    private Date date;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy("id")
    private User user;

    public Log() {
    }

    public Log(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
