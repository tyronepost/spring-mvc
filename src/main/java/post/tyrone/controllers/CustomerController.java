package post.tyrone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import post.tyrone.domain.Customer;
import post.tyrone.services.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String customers(Model model) {
        List<Customer> customers = customerService.listAllCustomers();
        model.addAttribute("customers", customers);
        return "customers/index";
    }

    @RequestMapping("customer/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customers/show";
    }

    public String newCustomer() {
        return "customers/new";
    }

    public String create() {
        return "customers/create";
    }

    public String edit() {
        return "customers/edit";
    }

    public String update() {
        return "customers/update";
    }

    public String destroy() {
        return "customers/destroy";
    }
}
