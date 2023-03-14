package com.alpha07.dao;

import com.alpha07.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

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

        // ---------- Modification after introduction of update feature -----------
        session.merge(customer);
    }

    @Override
    public Customer getCustomer(int customerID) {
        // Get current database session
        Session session = sessionFactory.getCurrentSession();

        // Return the customer from database
        return session.get(Customer.class, customerID);
    }

    @Override
    public void delete(int customerID) {
        // Get current database session
        Session session = sessionFactory.getCurrentSession();

        // Retrieve the customer with id = customerID
        Customer customer = session.get(Customer.class,customerID);

        // Remove the customer
        session.remove(customer);
    }
}
