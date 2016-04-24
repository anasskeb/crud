package com.joseph.service;

import com.joseph.model.Student;

public interface StudentService extends MyGenericService<Student, Integer>{
	 public Student getStudent(String userName);

}
