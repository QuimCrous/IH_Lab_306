package com.example.Lab3_06;

import com.example.Lab3_06.models.BillableTask;
import com.example.Lab3_06.models.Task;
import com.example.Lab3_06.repositories.TaskRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.relational.core.sql.Cast;

import java.util.List;

@SpringBootTest
class Lab306ApplicationTests {

    @Autowired
    TaskRepository taskRepository;


    @AfterEach
    void tearDown(){
        //taskRepository.deleteAll();
    }

    @Test
    @DisplayName("test findAllByStatus works ok")
    void findAllByStatus_worksOk(){

        Task task = taskRepository.save(new Task("Design Web Page", "22/11/2022", false));
        Task task1 = taskRepository.save(new BillableTask("Create API","30/11/2022",false,70.00));
        Task task2 = taskRepository.save(new BillableTask("Create Java App","30/09/2022",true,50.00));
        Task task3 = taskRepository.save(new BillableTask("Create FrontEnd project","14/11/2022",false,50.00));

        List<Object[]> list = taskRepository.findAllByStatus(false);
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(false,list.get(i)[2]);
        }

    }

    @Test
    @DisplayName("findByTitleLike works ok")
    void findByTitleLike(){
        List<Task> list = taskRepository.findByTitleLike("reate");
        for (Task task : list) {
            Assertions.assertTrue(task.getTitle().contains("reate"));
        }
    }
    /*No estoy  contento con este test, no se como hacer un assertTrue*/
    @Test
    @DisplayName("FindAverageDoubleByTitle works ok")
    void findAverageDoubleByTitle(){
        List<Object[]> taskList = taskRepository.findAverageDoubleByTitle(50);
        Assertions.assertEquals(70.0,taskList.get(0)[1]);
        Assertions.assertEquals("Create API",taskList.get(0)[0]);

    }

}
