package com.mark.springboot.domain;

public class Tables {
    private String name;
    private String comment;


    @Override
    public String toString() {
        return "Tables{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
