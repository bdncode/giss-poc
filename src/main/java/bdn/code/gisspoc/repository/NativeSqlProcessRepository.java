package bdn.code.gisspoc.repository;

import bdn.code.gisspoc.domain.Process;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NativeSqlProcessRepository {

    @Query(value = "SELECT * FROM Process", nativeQuery = true)
    List<Process> findAll();

    @Query(value = "SELECT * FROM Process WHERE id = :id", nativeQuery = true)
    Optional<Process> findById(Long id);

    @Query(value = "SELECT * FROM Process WHERE name = :name", nativeQuery = true)
    List<Process> findByName(String name);
}
