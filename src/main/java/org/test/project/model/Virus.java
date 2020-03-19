package org.test.project.model;

public class Virus {

    Integer id;
    String name;
    String result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String email) {
        this.result = email;
    }

    @Override
    public String toString() {
        return "Virus [id=" + id + ", name=" + name + ", result=" + result + "]";
    }

}