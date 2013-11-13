package org.bonitasoft.poc.manage;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.bonitasoft.poc.model.Employee;

public class DeleteEmployees extends DeleteThread {

    public DeleteEmployees(final EntityManagerFactory entityManagerFactory, final AtomicInteger nbErrors, final AtomicLong errorDuration,
            final AtomicInteger nbDeletes, final AtomicLong deleteDuration,final AtomicInteger nbOptimisticLockError) {
        super(entityManagerFactory, nbErrors, errorDuration, nbDeletes, deleteDuration,nbOptimisticLockError);
    }

    @Override
    public void execute(final EntityManager entityManager) {
        final StringBuilder builder = new StringBuilder("FROM Employee WHERE name LIKE 'Matti%' ORDER BY name ");
        if (Math.random() % 2 == 0) {
            builder.append(" ASC");
        } else {
            builder.append(" DESC");
        }
        final TypedQuery<Employee> query = entityManager.createQuery(builder.toString(),Employee.class);
        query.setFirstResult(0);
        query.setMaxResults(1);
        final List<Employee> employees = query.getResultList();
        final Employee employee = employees.get(0);
        entityManager.remove(employee);
    }

}