package com.haithem.springbootrestapi.controller;

import com.haithem.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public Student getStudent() {
        return new Student(1, "haematite", "birdhouse");

    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "haematite", "birdhouse"));
        students.add(new Student(2, "hh", "moikoo"));
        students.add(new Student(3, "ral", "tets"));
        return students;
    }


    @GetMapping("student/{id}/{name}/{last-name}")
    public Student studentPathVariable(@PathVariable int id, @PathVariable String name, @PathVariable("last-name") String last) {
        return new Student(id, name, last);
    }

    // request param  par in spring boot
    @GetMapping("students/query")
    public Student studentRequestVauable(@RequestParam int id) {
        return new Student(id, "ral", "tets");
    }
 // create Student 201 created
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public  Student createStudeny(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  student ;
    }

// handle post request in spring boot updating  existing resource
    @PutMapping("/students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id")  int studentId) {
        System.out.println(student.getLastName());
        System.out.println(student.getId());
        return  student ;

    }

 // deleting the existing resource
    @DeleteMapping("student/delete/{id}")
    public  String deleteStudent( @PathVariable String id) {
        System.out.println(id);
         return  "student deleted successfully with  ***"+id ;
    }


    @GetMapping("/auto")
    public String hell() {
        return  "hell" ;
    }
}
