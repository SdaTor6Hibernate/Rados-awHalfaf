package model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADD_ID")
    private int addID;
    @Column(name = "ADD_STREET")
    private String street;
    @Column (name = "ADD_BUILDING_NO")
    private String buildingNo;
    @Column(name = "ADD_APARTMENT_NO")
    private String apartmentNo;
    @Column(name = "ADD_CITY")
    private String city;
    @Column(name = "ADD_POSTAL_CODE")
    private String postalCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADD_CO_ID", referencedColumnName = "CO_ID")
    private Country country;




}
