package com.klasevich.customer.model.dao;

import com.klasevich.customer.exception.DaoException;
import com.klasevich.customer.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    void add(Customer customer) throws DaoException;

    public void update(int index, Customer customer) throws DaoException;

    void delete(Customer customer) throws DaoException;

    List<Customer> findAll();

    Optional<Customer> findByID(int id);

    Optional<Customer> findBySurname(String surname);

    Optional<Customer> findByCreditNumber(long creditNumber);

    Optional<Customer> findByBankAccount(String bankAccount);
}

