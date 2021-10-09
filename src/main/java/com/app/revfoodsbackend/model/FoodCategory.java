package com.app.revfoodsbackend.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodCategoryId;

    private String foodCategoryName;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Food> foodList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FoodCategory that = (FoodCategory) o;
        return Objects.equals(foodCategoryId, that.foodCategoryId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
