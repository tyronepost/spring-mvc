package post.tyrone.services;

import org.springframework.stereotype.Service;
import post.tyrone.domain.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Tyrone");
        customer1.setLastName("Post");
        customer1.setAddressLine1("1500 Monterey St");
        customer1.setCity("Richmond");
        customer1.setState("California");
        customer1.setZipCode("94804");
        customer1.setEmail("tp123@spring.com");
        customer1.setPhoneNumber("123-456-7890");

        customers.put(1, customer1);
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer deleteCustomer(Integer id) {
        return null;
    }
}
