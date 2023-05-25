package com.example.Student.Repository;

import com.example.Student.Model.Department;
import com.example.Student.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByRollNumber(int roll);
    List<Student> findByGradeAndName(int grade, String name);
    @Query(value="SELECT * FROM student WHERE grade= :grade",nativeQuery = true)
    List<Student> getByQuery(int grade);
}
