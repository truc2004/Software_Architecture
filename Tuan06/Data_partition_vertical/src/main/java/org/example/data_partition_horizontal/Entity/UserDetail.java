package org.example.data_partition_horizontal.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    private Integer id;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}