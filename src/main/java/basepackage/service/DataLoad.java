package basepackage.service;

import basepackage.dao.StudentRepo;
import basepackage.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLoad {

    @Autowired
    StudentRepo stRepo;

    public void insertData(){
        Student st1 = new Student("St-Name1", "1");
        Student st2 = new Student("St-Name2", "2");
        stRepo.save(st1);
        stRepo.save(st2);
    }
}

