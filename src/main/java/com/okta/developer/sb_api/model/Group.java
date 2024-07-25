package com.okta.developer.sb_api.model;

import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data 
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_group")
public class Group {
    
    @Id
    @GeneratedValue
    private Long id; 

    @Nonnull
    private String name; 
    private String address; 
    private String city; 
    private String stateOrProvince; 
    private String country; 
    private String postalCode; 
    
    
    // one user can be a part of many groups
    @ManyToOne(cascade=CascadeType.PERSIST)       
    private User user; 

    // one group can have many events 
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Event> events; 

}
