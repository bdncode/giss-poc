package bdn.code.gisspoc.repository;

import bdn.code.gisspoc.domain.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProcessRepository extends JpaRepository<Process, Long> {
}
