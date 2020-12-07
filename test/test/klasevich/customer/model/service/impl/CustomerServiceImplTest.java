package test.klasevich.customer.model.service.impl;

import com.klasevich.customer.exception.DaoException;
import com.klasevich.customer.exception.ServiceException;
import com.klasevich.customer.model.dao.storage.CustomerWareHouse;
import com.klasevich.customer.model.entity.Customer;
import com.klasevich.customer.model.entity.CustomerType;
import com.klasevich.customer.model.service.impl.CustomerServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class CustomerServiceImplTest {

    CustomerServiceImpl service;
    CustomerWareHouse wareHouse;

    @BeforeMethod
    public void setUp() throws DaoException {
        service = new CustomerServiceImpl();
        wareHouse = CustomerWareHouse.getInstance();
        wareHouse.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        wareHouse.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        wareHouse.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));

    }

    @Test
    public void testAdd() throws ServiceException {
        service.add(new Customer(3, "Urbanovich", "Krasnoznamennaya,7", CustomerType.valueOf("GOLD"), 2389783453674323L, "256TECHNO2452347"));
        int actual = wareHouse.size();
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testDelete() throws ServiceException {
        service.delete(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        int actual = wareHouse.size();
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testUpdate() throws ServiceException {
        int index = 0;
        service.update(index, new Customer(4, "Andreenko", "Inogorodnyaya,245", CustomerType.valueOf("CLASSIC"), 2356143671378424L, "117BBANK2362745"));
        int actual = wareHouse.getCustomer(index).getId();
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testSearchAll() {
        List<Customer> actual = service.searchAll();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        expected.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        expected.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));
        assertEquals(actual, expected);
    }

    @Test
    public void testSearchByID() {
        int id = 0;
        Optional<Customer> actual = service.searchByID(id);
        Optional<Customer> expected = Optional.of(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }

    @Test
    public void testSearchByBankAccount() {
        String bankAccount = "256TEHNO3452345";
        Optional<Customer> actual = service.searchByBankAccount(bankAccount);
        Optional<Customer> expected = Optional.of(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }

    @Test
    public void testSearchByCreditNumber() {
        long creditNumber = 2378347845344534L;
        Optional<Customer> actual = service.searchByCreditNumber(creditNumber);
        Optional<Customer> expected = Optional.of(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        assertEquals(actual, expected);
    }

    @Test
    public void testSearchBySurname() {
        String surname = "Horevich";
        Optional<Customer> actual = service.searchBySurname(surname);
        Optional<Customer> expected = Optional.of(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllBySurname() {
        List<Customer> actual = service.findAllBySurname();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        expected.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        expected.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllByCreditNumber() {
        List<Customer> actual = service.findAllByCreditNumber();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));
        expected.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        expected.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAllByBankAccount() {
        List<Customer> actual = service.findAllByBankAccount();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));
        expected.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        expected.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }
}