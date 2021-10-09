package com.app.revfoodsbackend.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
@AllArgsConstructor
@ToString
public class Supervisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supervisorId;
    private String supervisorUsername;
    private String supervisorPassword;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<FoodOrder> foodOrderList;

    @OneToMany(mappedBy = "supervisor", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Help> helpList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Supervisor that = (Supervisor) o;
        return Objects.equals(supervisorId, that.supervisorId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}