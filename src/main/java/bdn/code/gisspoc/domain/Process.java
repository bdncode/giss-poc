package bdn.code.gisspoc.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@SequenceGenerator(name = "ProcessIdGenerator", sequenceName = "process_seq", allocationSize = 1)
public class Process {

    @Id
    @GeneratedValue(generator = "ClientIdGenerator", strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Process process = (Process) o;
        return id != null && Objects.equals(id, process.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
