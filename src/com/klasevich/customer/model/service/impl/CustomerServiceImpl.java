package com.klasevich.customer.model.service.impl;

import com.klasevich.customer.exception.DaoException;
import com.klasevich.customer.exception.ServiceException;
import com.klasevich.customer.model.dao.impl.CustomerDaoImpl;
import com.klasevich.customer.model.entity.Customer;
import com.klasevich.customer.model.entity.comparator.CustomerComparator;
import com.klasevich.customer.model.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    Logger logger = LogManager.getLogger();
    private static final CustomerDaoImpl customerDao = new CustomerDaoImpl();

    @Override
    public void add(Customer customer) throws ServiceException {
        if (customer == null) {
            throw new ServiceException("customer doesn't exist");
        }
        try {
            customerDao.add(customer);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Customer customer) throws ServiceException {
        if (customer == null) {
            throw new ServiceException("customer doesn't exist");
        }
        try {
            customerDao.delete(customer);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(int index, Customer customer) throws ServiceException {
        if (index < 0) {
            throw new ServiceException("index " + index + " doesn't exist");
        }
        if (customer == null) {
            throw new ServiceException("customer doesn't exist");
        }
        try {
            customerDao.update(index, customer);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Customer> searchAll() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> searchByID(int id) {
        return customerDao.findByID(id);
    }

    @Override
    public Optional<Customer> searchByBankAccount(String bankAccount) {
        return customerDao.findByBankAccount(bankAccount);
    }

    @Override
    public Optional<Customer> searchByCreditNumber(long creditNumber) {
        return customerDao.findByCreditNumber(creditNumber);
    }

    @Override
    public Optional<Customer> searchBySurname(String surname) {
        return customerDao.findBySurname(surname);
    }

    @Override
    public List<Customer> findAllBySurname() {
        List<Customer> customers = customerDao.findAll();
        customers.sort(CustomerComparator.SURNAME);
        return customers;
    }

    @Override
    public List<Customer> findAllByCreditNumber() {
        List<Customer> customers = customerDao.findAll();
        customers.sort(CustomerComparator.CREDITNUMBER);
        logger.info("sortByCreditNumber {}",customers);
        return customers;
    }

    @Override
    public List<Customer> findAllByBankAccount() {
        List<Customer> customers = customerDao.findAll();
        customers.sort(CustomerComparator.BANKACCOUNT);
        return customers;
    }
}
