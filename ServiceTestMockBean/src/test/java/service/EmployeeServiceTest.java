package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import model.Employee;
import repo.EmployeeRepository;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = EmployeeServiceTestConfig.class)
@SpringJUnitConfig(EmployeeServiceTestConfig.class)
public class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void test() {
		Employee mock = mockEmployee();
		when(employeeRepository.findByName(mock.getName())).thenReturn(mock);
		Employee emp = employeeService.findByName(mock.getName());
		assertEquals(emp.getId(), mock.getId());
		assertEquals(emp.getName(), mock.getName());
	}

	public Employee mockEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("abc");
		return emp;

	}

}
