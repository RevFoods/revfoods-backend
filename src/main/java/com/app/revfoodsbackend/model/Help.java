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
public class Help {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int helpId;
    private String help;
    private boolean helpStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "supervisorId", referencedColumnName = "supervisorId")
    private Supervisor supervisor;

    @OneToOne(mappedBy = "help", cascade = CascadeType.ALL)
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Help help = (Help) o;
        return Objects.equals(helpId, help.helpId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
