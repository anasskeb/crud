package com.joseph.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.joseph.dao.StudentDao;
import com.joseph.model.Student;

@Repository
public class StudentDaoImpl extends MyGenericDaoImpl<Student, Integer> implements StudentDao {

	@Override
	public Student getStudent(String username) {
		 Query query = currentSession().createQuery(
	                "from Student " +
	                        "where firstname=:username");
	        query.setParameter("username", username);
	        return (Student) query.uniqueResult();
	}

}
