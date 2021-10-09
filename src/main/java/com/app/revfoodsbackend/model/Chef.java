package com.app.revfoodsbackend.model;

import lombok.*;
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
@AllArgsConstructor
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chefId;
    private String chefName;
    private String chefUsername;
    private String chefPassword;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<FoodOrder> foodOrderList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Chef chef = (Chef) o;
        return Objects.equals(chefId, chef.chefId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
