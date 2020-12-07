package test.klasevich.customer.model.reader;

import com.klasevich.customer.model.entity.Customer;
import com.klasevich.customer.model.entity.CustomerType;
import com.klasevich.customer.model.reader.DataReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader reader;
    final String fileName = "data/customer.txt";

    @BeforeMethod
    public void setUp() {
        reader = new DataReader();
    }

    @Test
    public void testFillCustomerBase() {
        List<Customer> actual = reader.fillCustomerBase(fileName);
        List<Customer> expected = new ArrayList<>();
        expected.add(new Customer(0, "Horevich", "Polevaya,24", CustomerType.valueOf("GOLD"), 2356788334533453L, "256TEHNO3452345"));
        expected.add(new Customer(1, "Ignatenko", "Krasnaya,15", CustomerType.valueOf("SILVER"), 2378347845344534L, "143PRIOR3421647"));
        expected.add(new Customer(2, "Petrenko", "Masherova,118", CustomerType.valueOf("CLASSIC"), 23165454344545345L, "117BBANK2533668"));
        expected.add(new Customer(3, "Urbanovich", "Krasnoznamennaya,7", CustomerType.valueOf("GOLD"), 2389783453674323L, "256TECHNO2452347"));
        expected.add(new Customer(4, "Andreenko", "Inogorodnyaya,245", CustomerType.valueOf("CLASSIC"), 2356143671378424L, "117BBANK2362745"));
        expected.add(new Customer(5, "Egorov", "Sovetskaya,56", CustomerType.valueOf("GOLD"), 2974983363572474L, "256TEHNO3452785"));
        expected.add(new Customer(6, "Korzun", "Ponamorenko,25", CustomerType.valueOf("SILVER"), 3324984482690575L, "117BBANK2362458"));
        expected.add(new Customer(7, "Golovach", "Chehova,13", CustomerType.valueOf("CLASSIC"), 2535478434794248L, "117BBANK2361966"));
        expected.add(new Customer(8, "Semenova", "Svetlaya,43", CustomerType.valueOf("SILVER"), 3392673726435799L, "143PRIOR34219754"));
        expected.add(new Customer(9, "Andreevskiy", "Birjuzovaya,213", CustomerType.valueOf("GOLD"), 2953583713267986L, "256TEHNO3455410"));
        expected.add(new Customer(10, "Skoryh", "Vesennya,32", CustomerType.valueOf("GOLD"), 3383288443479678L, "143PRIOR3422437"));
        expected.add(new Customer(11, "Golubko", "Solnechnaya,64", CustomerType.valueOf("CLASSIC"), 2594780212053257L, "256TEHNO3451236"));
        assertEquals(actual, expected);
    }
}