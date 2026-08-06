package com.example.library.entity;

public class AuthorDto {
    private Integer id;
    private String name;

    public AuthorDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorDto(Author a) {
        this.id = a.getId();
        this.name = a.getName();
    }

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

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
