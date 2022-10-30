package com.example.Lab3_06.repositories;

import com.example.Lab3_06.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    /*
    He creado 3 queries que necesitan realizarse con SQL nativo
     */

    @Query(value = "SELECT title, AVG(hourly_rate) FROM task JOIN billable_task ON task.id = billable_task.id GROUP BY title HAVING AVG(hourly_rate) > :money ORDER BY title DESC", nativeQuery = true)
    List<Object[]> findAverageDoubleByTitle(double money);

    @Query(value = "SELECT title FROM task WHERE title LIKE '%{:name}%'", nativeQuery = true)
    List<Task> findByTitleLike(String name);

    @Query(value = "SELECT * FROM task WHERE status=:status", nativeQuery = true)
    List<Object[]> findAllByStatus(boolean status);



}
