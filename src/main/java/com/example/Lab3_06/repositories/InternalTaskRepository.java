package com.example.Lab3_06.repositories;

import com.example.Lab3_06.models.InternalTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalTaskRepository extends JpaRepository<InternalTask,Long> {

}
