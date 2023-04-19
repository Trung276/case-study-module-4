package com.codegym.casestudy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String description;

    @Lob
    private String avatar;

    private Double price;

    @Min(0)
    private int quantity;

    private boolean activated = true;

}
