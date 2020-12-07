package com.klasevich.customer.model.service;

import com.klasevich.customer.exception.ServiceException;
import com.klasevich.customer.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void add(Customer customer) throws ServiceException;
    void delete(Customer customer) throws ServiceException;
    void update(int index, Customer customer) throws ServiceException;
    List<Customer> searchAll();
    Optional<Customer> searchByID(int id);
    Optional<Customer> searchByBankAccount(String bankAccount);
    Optional<Customer> searchByCreditNumber(long creditNumber);
    Optional<Customer> searchBySurname(String surname);
    List<Customer> findAllBySurname();
    List<Customer> findAllByCreditNumber();
    List<Customer> findAllByBankAccount();
}