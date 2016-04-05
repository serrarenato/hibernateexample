package br.com.letsgoti.hibernateexample.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.letsgoti.hibernateexample.model.Employee;



@Repository("employeeDAO")
@Transactional
public class EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveEmployee(Employee employee) {
		getSession().persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}	

	
	public void updateEmployee(Employee employee){
		getSession().update(employee);
	}
	
}
