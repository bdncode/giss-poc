package bdn.code.gisspoc.repository;

import bdn.code.gisspoc.domain.Servidor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NativeSqlServidorRepository extends JpaRepository<Servidor, Long> {

    @Override
    @Query(value = "INSERT INTO Servidor(name) VALUES (:name)", nativeQuery = true)
    Servidor save(Servidor servidor);

    @Override
    @Query(value = "SELECT * FROM Servidor", nativeQuery = true)
    Page<Servidor> findAll(Pageable pageable);

    @Override
    @Query(value = "SELECT * FROM Servidor WHERE id = :id", nativeQuery = true)
    Optional<Servidor> findById(Long id);

    @Override
    @Query(value = "DELETE FROM Servidor WHERE id = :id", nativeQuery = true)
    void deleteById(Long id);
}
