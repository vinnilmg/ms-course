package com.vinnilmg.hrworker.repositories;

import com.vinnilmg.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
