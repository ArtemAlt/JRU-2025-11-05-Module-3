package com.example.users;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "new_users")
public class NewUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private Integer age;

    @ElementCollection
    @CollectionTable(
            name = "new_users_phones",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "phone")
    @OrderColumn(name = "position")
    private List<String> phones = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "new_users_addresses",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @MapKeyColumn(name = "address_key")
    @Column(name = "address_value")
    private Map<String, String> addresses = new HashMap<>();

    @ElementCollection
    @CollectionTable(
            name = "new_users_social",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "social_handle")
    private Set<String> socialNetworks = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "user_contacts",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<ContactInfo> contacts = new ArrayList<>();

    public NewUser() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Map<String, String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, String> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getSocialNetworks() {
        return socialNetworks;
    }

    public void setSocialNetworks(Set<String> socialNetworks) {
        this.socialNetworks = socialNetworks;
    }
}
