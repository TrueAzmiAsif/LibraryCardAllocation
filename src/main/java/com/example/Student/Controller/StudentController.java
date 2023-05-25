package com.example.Student.Controller;

import com.example.Student.Model.Department;
import com.example.Student.Model.Student;
import com.example.Student.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentServices st;
    @PostMapping("/add")
    public String add(@RequestBody Student student){
        return st.add(student);
        //return "Hello";
    }
    @GetMapping("/test")
    public String tes(){
        return "Yaaaaassssssss";
    }
    @DeleteMapping("/removeById")
    public String removeById(@RequestParam("id") int id){
        return st.removeById(id);
    }
    @DeleteMapping("/removeAll")
    public String removeAll(){
        return st.removeAll();
    }
    @GetMapping("/getAll")
    public List<String> getAll(){
        return st.getAll();
    }
    //not working
    @GetMapping("/getById/{id}")
    public String getById(@PathVariable("id") int id){
        return st.getById(id);
    }
    @PutMapping("/updateById")
    public String updateById(@RequestParam("id") int id, @RequestParam("name") String name){
        return st.updateById(id,name);
    }

    @GetMapping("/getAbove20")
    public List<String> getAbove20(){
        return st.getAbove20();
    }
    @GetMapping("findByRoll")
    public List<String> findByRoll(@RequestParam("roll") int roll){
        return st.findByRoll(roll);
    }
    @GetMapping("findByDepartAndName")
    public List<String> findByDepartAndName(@RequestParam("grade") int grade, @RequestParam("name") String name){
        return st.findByGradeAndName(grade, name);
    }
    @GetMapping("getByQuery")
    public List<String> getByQuery(@RequestParam("grade") int grade){
        return st.getByQuery(grade);
    }
}
