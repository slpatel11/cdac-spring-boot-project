package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Student;

public interface IStudentDao extends JpaRepository<Student,Integer> {
    Student findByName(String name);
    @Query("select s from Student s where s.emailId=:email")
    public Student getStudentByEmailId(@Param("email")String email);
    

    @Query(nativeQuery = true, value = "select *from student where student_id in (select student_id from students_drive where drive_id=:id ) and status='not Placed'")
    List<Student> getAllStudentsbyDriveId(@Param("id")Integer id);
    
    @Query(nativeQuery = true, value = "select *from student where  status='not Placed'")
    List<Student> getAllStudents();
    
}
