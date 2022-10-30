# Lab 3_06 JAVA

Apartado 3)
He creado 3 queries en el repositorio de TaskRepository que cumplen con
el requisito de necesitar que sean en SQL nativo.

    @Query(value = "SELECT title, AVG(hourly_rate) FROM task JOIN billable_task ON task.id = billable_task.id GROUP BY title HAVING AVG(hourly_rate) > :money ORDER BY title DESC", nativeQuery = true)
    List<Object[]> findAverageDoubleByTitle(double money);

    @Query(value = "SELECT title FROM task WHERE title LIKE %:name%", nativeQuery = true)
    List<Object> findByTitleLike(String name);

    @Query(value = "SELECT * FROM task WHERE status=:status", nativeQuery = true)
    List<Object[]> findAllByStatus(boolean status);