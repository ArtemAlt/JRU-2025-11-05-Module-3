package com.example.library.entity;

public class AuthorStatDTO {
    private Integer id;
    private String name;
    private Integer totalCount;

    public AuthorStatDTO() {
    }

    public AuthorStatDTO(Integer id, String name, Integer totalCount) {
        this.id = id;
        this.name = name;
        this.totalCount = totalCount;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "AuthorStatDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalCount=" + totalCount +
                '}';
    }
}
