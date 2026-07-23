package com.example.users;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ContactInfo {
    @Column(name = "contact_type")
    private String type;  // EMAIL, PHONE, SOCIAL, etc.

    @Column(name = "contact_value")
    private String value;

    @Column(name = "priority")
    private Integer priority = 0;
}
