package com.alpha07.dao;

import com.alpha07.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // Get current database session
        Session session = sessionFactory.getCurrentSession();

        // Create a query to get all customers
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);

        // Return query results list
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        // Get current database session
        Session session = sessionFactory.getCurrentSession();

        // Save the customer
        session.persist(customer);
    }
}
