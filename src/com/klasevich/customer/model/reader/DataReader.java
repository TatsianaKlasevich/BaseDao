package com.klasevich.customer.model.reader;

import com.klasevich.customer.exception.DaoException;
import com.klasevich.customer.model.dao.impl.CustomerDaoImpl;
import com.klasevich.customer.model.entity.Customer;
import com.klasevich.customer.model.entity.CustomerType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static Logger logger = LogManager.getLogger();
    private static final String SEPARATOR = " ";
    private final CustomerDaoImpl CustomerDao = new CustomerDaoImpl();

    public List<Customer> fillCustomerBase(String fileName) {
        List<Customer> customerBase = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String s = reader.readLine();
                String[] customerFields = s.split(SEPARATOR);
                String surname = customerFields[0];
                String address = customerFields[1];
                CustomerType customerType = CustomerType.valueOf(customerFields[2]);
                long creditNumber = Long.parseLong(customerFields[3]);
                String bankAccount = customerFields[4];

                Customer customer = new Customer(surname, address, customerType, creditNumber, bankAccount);
                customerBase.add(customer);
                CustomerDao.add(customer);
            }
        } catch (FileNotFoundException e) {
            logger.fatal("File is not found");
        } catch (IOException | DaoException e) {
            logger.error("Exception during reading file", e);
        }
        return customerBase;
    }
}
