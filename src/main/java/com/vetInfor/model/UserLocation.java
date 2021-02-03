package com.vetInfor.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Setter
@Getter
@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lat;
    private double lng;
    private String place;
    private String description;

}
