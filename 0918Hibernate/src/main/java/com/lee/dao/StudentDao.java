package com.lee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lee.domain.Student;

//bean을 자동으로 만들어주는 어노테이션 
@Repository
public class StudentDao {
	// 동일한 자료형의 bean이 있는 경우 자동으로 주입받는 설정
	@Autowired
//hibernate를 사용하기 위한 인스턴스 변수 
	private SessionFactory sessionFactory;

//메소드에서 예외가 발생하면 rollback 되고
//예외가 발생하지 않으면 commit 되도록 해주는 어노테이션 
	@Transactional
//데이터를 삽입하는 메소드 
	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

	@Transactional
//데이터를 	수정 하는 메소드 
	public void updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
	}

	@Transactional
//데이터를 삭제  하는 메소드 
	public void deleteStudent(Student student) {
		sessionFactory.getCurrentSession().delete(student);
	}

	@Transactional
//전체 데이터를 조회하는 메소드 
	public List<Student> list() {
		return (List<Student>) sessionFactory.getCurrentSession().createCriteria(Student.class).list();

	}
	
	
@Transactional
//code를 가지고 데이터를 조회하는 메소드 
public Student get(int num) {
	return (Student)sessionFactory.getCurrentSession().get(Student.class, num);
	
}
}
