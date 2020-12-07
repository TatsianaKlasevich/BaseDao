package test.klasevich.customer.model.dao.iml;

import com.klasevich.customer.exception.DaoException;
import com.klasevich.customer.model.dao.impl.CustomerDaoImpl;
import com.klasevich.customer.model.dao.storage.CustomerWareHouse;
import com.klasevich.customer.model.entity.Customer;
import com.klasevich.customer.model.entity.CustomerType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class CustomerDaoImplTest {
    CustomerDaoImpl customerDao;
    CustomerWareHouse wareHouse;

    @BeforeMethod
    public void setUp() throws DaoException {
        customerDao = new CustomerDaoImpl();
        customerDao.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        customerDao.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        wareHouse = CustomerWareHouse.getInstance();
    }

    @Test
    public void testAdd() throws DaoException {
        customerDao.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));
        int actual = wareHouse.size();
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void testDelete() throws DaoException {
        customerDao.delete(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        int actual = wareHouse.size();
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testUpdate() throws DaoException {
        int index = 0;
        customerDao.update(index, new Customer(4, "Andreenko", "Inogorodnyaya,245", CustomerType.valueOf("CLASSIC"), 2356143671378424L, "117BBANK2362745"));
        int actual = wareHouse.getCustomer(index).getId();
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void testFindAll() {
        List<Customer> actual = customerDao.findAll();
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        expected.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByID() {
        int id = 0;
        Optional<Customer> actual = customerDao.findByID(id);
        Optional<Customer> expected = Optional.of(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindBySurname() {
        String surname = "Horevich";
        Optional<Customer> actual = customerDao.findBySurname(surname);
        Optional<Customer> expected = Optional.of(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByCreditNumber() {
        long creditNumber = 2378347845344534L;
        Optional<Customer> actual = customerDao.findByCreditNumber(creditNumber);
        Optional<Customer> expected = Optional.of(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        assertEquals(actual, expected);
    }

    @Test
    public void testFindByBankAccount() {
        String bankAccount = "256TEHNO3452345";
        Optional<Customer> actual = customerDao.findByBankAccount(bankAccount);
        Optional<Customer> expected = Optional.of(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        assertEquals(actual, expected);
    }
}