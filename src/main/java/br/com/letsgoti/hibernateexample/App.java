package br.com.letsgoti.hibernateexample;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import br.com.letsgoti.hibernateexample.configuration.AppConfig;
import br.com.letsgoti.hibernateexample.dao.EmployeeDAO;
import br.com.letsgoti.hibernateexample.model.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");

		Employee employee1 = new Employee();
		employee1.setName("Renato Serra");
		employee1.setInitialDate(new Date("04/04/1990"));		
		employee1.setSalary(new BigDecimal(4000));
		employee1.setCpf("12345678960");
		
		Employee employee2 = new Employee();
		employee2.setName("Luis Sebastiao");
		employee2.setInitialDate(new Date("04/04/1988"));
		employee2.setFinalDate(new Date("04/04/2010"));
		employee2.setSalary(new BigDecimal(7000));
		employee2.setCpf("12345278960");

		employeeDAO.saveEmployee(employee1);
		employeeDAO.saveEmployee(employee2);

		List<Employee> employees = employeeDAO.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp);
		}	
		

		context.close();
	}    	
    
}
