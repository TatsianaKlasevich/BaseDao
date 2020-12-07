package com.klasevich.customer.model.dao.impl;

import com.klasevich.customer.exception.DaoException;
import com.klasevich.customer.model.dao.CustomerDao;
import com.klasevich.customer.model.dao.storage.CustomerWareHouse;
import com.klasevich.customer.model.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {
    Logger logger = LogManager.getLogger();
    private static final CustomerWareHouse wareHouse = CustomerWareHouse.getInstance();

    @Override
    public void add(Customer customer) throws DaoException {
        if (customer == null) {
            throw new DaoException("Object doesn't exist");
        }
        if (wareHouse.contains(customer)) {
            throw new DaoException("customer " + customer.getSurname() + " exists yet");
        }
        logger.info("adding customer {}", customer);
        wareHouse.add(customer);
    }

    @Override
    public void delete(Customer customer) throws DaoException {
        if (!wareHouse.contains(customer)) {
            throw new DaoException("customer " + customer.getSurname() + " doesn't exist");
        }
        logger.info("removing customer {}", customer);
        wareHouse.remove(customer);
    }

    @Override
    public void update(int index, Customer customer) throws DaoException {
        if (!wareHouse.contains(wareHouse.getCustomer(index))) {
            throw new DaoException("Customer with index " + index + "doesn't found");
        }
        logger.info("replacing customer with index {}", index);
        wareHouse.replace(index, customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerBase = new ArrayList<>();
        int size = wareHouse.size();
        for (int i = 0; i < size; i++) {
            customerBase.add(wareHouse.getCustomer(i));
        }
        return customerBase;
    }

    @Override
    public Optional<Customer> findByID(int id) {
        Customer customer = wareHouse.getCustomer(id);
        return Optional.of(customer);
    }

    @Override
    public Optional<Customer> findBySurname(String surname) {
        Optional<Customer> result = Optional.empty();
        List<Customer> customers = findAll();
        int size = wareHouse.size();
        int i = 0;
        while (i < size) {
            if (surname.equalsIgnoreCase(wareHouse.getCustomer(i).getSurname())) {
                result = Optional.of(wareHouse.getCustomer(i));
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public Optional<Customer> findByCreditNumber(long creditNumber) {
        Optional<Customer> result = Optional.empty();
        List<Customer> customers = findAll();
        int size = wareHouse.size();
        int i = 0;
        while (i < size) {
            if (creditNumber == wareHouse.getCustomer(i).getCreditNumber()) {
                result = Optional.of(wareHouse.getCustomer(i));
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public Optional<Customer> findByBankAccount(String bankAccount) {
        Optional<Customer> result = Optional.empty();
        List<Customer> customers = findAll();
        int size = wareHouse.size();
        int i = 0;
        while (i < size) {
            if (bankAccount.equalsIgnoreCase(wareHouse.getCustomer(i).getBankAccount())) {
                result = Optional.of(wareHouse.getCustomer(i));
                break;
            }
            i++;
        }
        return result;
    }
}
