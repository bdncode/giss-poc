package bdn.code.gisspoc.repository;

import bdn.code.gisspoc.domain.Servidor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HqlServidorRepository extends JpaRepository<Servidor, Long> {

    @Override
    @Query("INSERT INTO Servidor(name) VALUES (:name)")
    Servidor save(Servidor servidor);

    @Override
    @Query("FROM Servidor")
    Page<Servidor> findAll(Pageable pageable);

    @Override
    @Query("FROM Servidor WHERE id = :id")
    Optional<Servidor> findById(Long id);

    @Override
    @Query("DELETE FROM Servidor WHERE id = :id")
    void deleteById(Long id);
}
