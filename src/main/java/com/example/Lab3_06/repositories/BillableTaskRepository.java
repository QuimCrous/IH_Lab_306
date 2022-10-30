package com.example.Lab3_06.repositories;

import com.example.Lab3_06.models.BillableTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillableTaskRepository extends JpaRepository<BillableTask, Long> {
}
