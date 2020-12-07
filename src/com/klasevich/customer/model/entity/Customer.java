package com.klasevich.customer.model.entity;

import com.klasevich.customer.util.CustomerIdGenerator;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = -4928530458363529713L;
    private int id = CustomerIdGenerator.getCurrentId();
    private String surname;
    private String address;
    private CustomerType customerType;
    private long creditNumber;
    private String bankAccount;

    public Customer() {
    }

    public Customer(String surname, String address, CustomerType customerType, long creditNumber, String bankAccount) {
        this.surname = surname;
        this.address = address;
        this.customerType = customerType;
        this.creditNumber = creditNumber;
        this.bankAccount = bankAccount;
    }

    public Customer(int id, String surname, String address, CustomerType customerType, long creditNumber, String bankAccount) {
        this.id = id;
        this.surname = surname;
        this.address = address;
        this.customerType = customerType;
        this.creditNumber = creditNumber;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String secondName) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(long creditNumber) {
        this.creditNumber = creditNumber;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (getId() != customer.getId()) return false;
        if (getCreditNumber() != customer.getCreditNumber()) return false;
        if (getSurname() != null ? !getSurname().equals(customer.getSurname()) : customer.getSurname() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(customer.getAddress()) : customer.getAddress() != null)
            return false;
        if (getCustomerType() != customer.getCustomerType()) return false;
        return getBankAccount() != null ? getBankAccount().equals(customer.getBankAccount()) : customer.getBankAccount() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getCustomerType() != null ? getCustomerType().hashCode() : 0);
        result = 31 * result + (int) (getCreditNumber() ^ (getCreditNumber() >>> 32));
        result = 31 * result + (getBankAccount() != null ? getBankAccount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", customerType=").append(customerType);
        sb.append(", creditNumber=").append(creditNumber);
        sb.append(", bankAccount='").append(bankAccount).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
