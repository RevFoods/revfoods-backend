package com.app.revfoodsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table
@AllArgsConstructor
@ToString
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodOrderId;

    @OneToOne
    @JoinColumn(name = "orderStatusId", referencedColumnName = "orderStatusId")
    private OrderStatus orderStatus;

    @OneToOne
    @JoinColumn(name = "cartId", referencedColumnName = "cartId")
    private Cart cart;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "chefId", referencedColumnName = "chefId")
    private Chef chef;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supervisorId", referencedColumnName = "supervisorId")
    private Supervisor supervisor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodOrder)) return false;
        FoodOrder foodOrder = (FoodOrder) o;
        return getFoodOrderId() == foodOrder.getFoodOrderId() && Objects.equals(getOrderStatus(), foodOrder.getOrderStatus()) && Objects.equals(getCart(), foodOrder.getCart()) && Objects.equals(getChef(), foodOrder.getChef()) && Objects.equals(getSupervisor(), foodOrder.getSupervisor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFoodOrderId(), getOrderStatus(), getCart(), getChef(), getSupervisor());
    }
}
