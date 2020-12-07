package com.klasevich.customer.model.dao.storage;

import com.klasevich.customer.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerWareHouse {
    private static CustomerWareHouse instance = new CustomerWareHouse();
    private List<Customer> customers = new ArrayList<>();

    public CustomerWareHouse() {
    }

    public static CustomerWareHouse getInstance() {
        return instance;
    }

    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    public void setCustomer(int index, Customer customer) {
        customers.set(index, customer);
    }

    public boolean contains(Customer customer) {
        if (customers.contains(customer)) {
            return true;
        }
        return false;
    }

    public void add(Customer customer) {
        customers.add(customer);
    }

    public void remove(Customer customer) {
        customers.remove(customer);
    }

    public void replace(int index, Customer customer) {
        customers.remove(index);
        customers.add(index, customer);
    }

    public int size() {
        return customers.size();
    }
}
