package bdn.code.gisspoc.repository;

import bdn.code.gisspoc.domain.Servidor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpqlServidorRepository extends JpaRepository<Servidor, Long> {

    @Override
    @Query("INSERT INTO Servidor(name) VALUES (:name)")
    Servidor save(Servidor servidor);

    @Override
    @Query("SELECT s FROM Servidor s")
    Page<Servidor> findAll(Pageable pageable);

    @Override
    @Query("SELECT s FROM Servidor s WHERE s.id = :id")
    Optional<Servidor> findById(Long id);

    @Override
    @Query("DELETE FROM Servidor s WHERE s.id = :id")
    void deleteById(Long id);
}
