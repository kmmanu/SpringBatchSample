package org.manu.springbatch.reader;

import org.manu.springbatch.model.Employee;
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created with IntelliJ IDEA.
 * User: Manu.K.M
 * Date: 11/2/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeQueryProvider extends AbstractJpaQueryProvider {
    @Override
    public void afterPropertiesSet() throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Query createQuery() {
        TypedQuery<Employee> query = getEntityManager().createQuery("select e from Employee e", Employee.class);
        return query;
    }
}
