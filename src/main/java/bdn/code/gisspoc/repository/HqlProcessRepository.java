package bdn.code.gisspoc.repository;

import bdn.code.gisspoc.domain.Process;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HqlProcessRepository extends JpaRepository<Process, Long> {

    @Query("FROM Process")
    List<Process> findAllByHql();

    @Query("FROM Process WHERE id = :id")
    Optional<Process> findById(Long id);

    @Query("FROM Process WHERE name = :name")
    List<Process> findByName(String name);
}
