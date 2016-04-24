package com.joseph.dao;

import com.joseph.model.Student;

public interface StudentDao extends MyGenericDao<Student, Integer>{
	
	public Student getStudent(String username);
}
