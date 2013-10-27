package org.manu.springbatch.reader;

import org.manu.springbatch.model.Employee;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

	public Employee mapFieldSet(final FieldSet fieldSet) throws BindException {
		final Employee emp = new Employee();
		emp.setId(fieldSet.readLong(0));
		emp.setName(fieldSet.readString(1));
		emp.setAge(fieldSet.readInt(2));
		return emp;
	}

}
