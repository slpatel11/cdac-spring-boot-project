package com.app.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.app.pojos.CampusDrive;
 
public interface IDriveDetailDao extends JpaRepository<CampusDrive, Integer>  {
   
	
	@Query("select s from CampusDrive s where s.company.companyId=:id")
	List<CampusDrive> findAllById(Integer id);
	@Query(nativeQuery = true, value = "select *from campus_drive where drive_id= (select drive_id from students_drive where student_id=:id)")
	List<CampusDrive> getAllByStudentId(Integer id);
	@Modifying
	@Query(nativeQuery = true, value = "INSERT INTO students_drive (`student_id`, `drive_id`)  VALUEs (:s_id,:d_id)")
	void insertIntoStudent_Drive(Integer s_id,Integer d_id);
}
