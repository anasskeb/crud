package com.joseph.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.joseph.dao.MyGenericDao;
import com.joseph.dao.StudentDao;
import com.joseph.model.Student;
import com.joseph.service.StudentService;

@Service
public class StudentServiceImpl extends MyGenericServiceImpl<Student, Integer> implements StudentService {
	
	private StudentDao studentDao;
	
	public StudentServiceImpl(){
		 
    }
	
    @Autowired
    public StudentServiceImpl(
            @Qualifier("studentDaoImpl") MyGenericDao<Student, Integer> genericDao) {
        super(genericDao);
        this.studentDao = (StudentDao) genericDao;
    }
    
    
	@Override
	public Student getStudent(String userName) {
		return studentDao.getStudent(userName);
	}

	
	
}
