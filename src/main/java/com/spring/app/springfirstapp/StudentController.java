package com.spring.app.springfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    ////http://localhost:8081/student
    @GetMapping("/student")
    public Student getStudent(){
        return  new Student("china","bursar");
    }

    //http://localhost:8081/students


    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students=new ArrayList<>();
        students.add(new Student("vijay","bee-manna"));
        students.add(new Student("bhaskar","frangible"));
        students.add(new Student("swarthy","mainline"));
        return students;

    }


    // http://localhost:8081/getStudent/vijay/bee-manna

    @GetMapping("/getStudent/{firstNames}/{secondNames}")
    public Student studentPathVariable(@PathVariable("firstNames") String firstName,@PathVariable("secondNames") String secondName){
        return new Student(firstName,secondName);
    }

   //http://localhost:8081/studnet/query?firstName=1&lastName=100
    @GetMapping("/query")
    public Student studentQueryParam(@RequestParam (name = "firstName") String firstName,
                                     @RequestParam(name = "lastName") String lastName){
        return new Student(firstName,lastName);
    }

}
