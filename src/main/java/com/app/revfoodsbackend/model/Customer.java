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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerName;
    private String customerEmail;
    private long customerPhone;

    @OneToOne
    @JoinColumn(name = "customerTableId", referencedColumnName = "customerTableId")
    private CustomerTable customerTable;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Cart> cartList;

    @OneToOne
    @JoinColumn(name = "feedbackId", referencedColumnName = "feedbackId")
    private Feedback feedback;

    @OneToOne
    @JoinColumn(name = "helpId", referencedColumnName = "helpId")
    private Help help;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
