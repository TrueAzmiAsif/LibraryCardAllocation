package com.example.Student.Service;

import com.example.Student.Model.Card;
import com.example.Student.Model.Department;
import com.example.Student.Model.Student;
import com.example.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {
    @Autowired
    StudentRepository sr;
    public String add(Student student){
        Card newCard=new Card();
        newCard.setName(student.getName());
        newCard.setDepart(student.getDepart());
        newCard.setStudent(student);
        student.setCard(newCard);
        sr.save(student);
        return "Added successfully";
    }
    public String removeById(int id){
        Student st=sr.findById(id).get();
        sr.deleteById(id);
        return st.getName()+" Deleted";
    }
    public String removeAll(){
        sr.deleteAll();
        return "Every record Deleted";
    }
    public List<String> getAll(){
        //sr.findAll();
        List<String> ans=new ArrayList<>();
        for(Student x: sr.findAll()){
            ans.add(x.getName());
        }
        return ans;
    }
    public String getById(int id){
        return sr.findById(id).get().getName();
    }
    public String updateById(int id,String name){
        Student st=sr.findById(id).get();
        st.setName(name);
        sr.save(st);
        return "Updation Done";
    }
    public List<String> getAbove20(){
        List<String> ans=new ArrayList<>();
        List<Student> allstu=sr.findAll();
        for(Student x: allstu){
            if(x.getGrade()>6)ans.add(x.getName());
        }
        return ans;
    }
    public List<String> findByRoll(int roll){
        List<String> ans=new ArrayList<>();
        for(Student x: sr.findByRollNumber(roll)){
            ans.add(x.getName());
        }
        return ans;
    }
    public List<String> findByGradeAndName(int grade, String name){
        List<String> ans=new ArrayList<>();
        for(Student x: sr.findByGradeAndName(grade, name)){
            ans.add(x.getName());
        }
        return ans;
    }
    public List<String> getByQuery(int grade){
        List<String> ans=new ArrayList<>();
        for(Student x: sr.getByQuery(grade)){
            ans.add(x.getName());
        }
        return ans;
    }
}
