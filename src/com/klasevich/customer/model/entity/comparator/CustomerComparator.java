package com.klasevich.customer.model.entity.comparator;

import com.klasevich.customer.model.entity.Customer;

import java.util.Comparator;

public enum CustomerComparator implements Comparator<Customer> {
    SURNAME {
        @Override
        public int compare(Customer o1, Customer o2) {
            return 0;
        }
    },
    CREDITNUMBER {
        @Override
        public int compare(Customer o1, Customer o2) {
            return 0;
        }
    },
    BANKACCOUNT {
        @Override
        public int compare(Customer o1, Customer o2) {
            return 0;
        }
    }
}
