package com.wisely.ch5_2_3;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserTest {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Integer age;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserTest(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public UserTest() {
    }

    public String toStrng(){
        return "id is "+this.id+",name is "+this.name;
    }
}
