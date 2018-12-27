package com.sample.bean;

/**
 * Person
 */
public class Person {

    public String name;
    public Integer age;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    private Person(Integer age) {
        this.age = age;
    }

    public void showAge() {
        System.out.println(this.age);
    }
}