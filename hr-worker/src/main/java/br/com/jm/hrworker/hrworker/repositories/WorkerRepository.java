package br.com.jm.hrworker.hrworker.repositories;

import br.com.jm.hrworker.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
