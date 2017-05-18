package post.tyrone.services;

import post.tyrone.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();
    Customer getCustomerById(Integer id);
    Customer saveOrUpdateCustomer(Customer customer);
    Customer deleteCustomer(Integer id);
}
