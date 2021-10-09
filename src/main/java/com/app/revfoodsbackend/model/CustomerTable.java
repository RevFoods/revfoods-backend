package com.app.revfoodsbackend.model;

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
public class CustomerTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTableId;
    private int customerTableNumber;
    private boolean customerTableStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CustomerTable that = (CustomerTable) o;
        return Objects.equals(customerTableId, that.customerTableId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
