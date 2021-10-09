package com.app.revfoodsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
@AllArgsConstructor
@ToString
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;
    private double foodPrice;
    private String foodName;

    @Lob
    @Column(columnDefinition = "CLOB")
    private String foodAvatar;
    private int foodPrepTime;
    private String foodType;
    private String foodStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "foodCategoryId", referencedColumnName = "foodCategoryId")
    private FoodCategory foodCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Food food = (Food) o;
        return Objects.equals(foodId, food.foodId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
