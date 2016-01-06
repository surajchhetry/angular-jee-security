package com.github.surajchhetry.angularjeesecurity.customers.control;


import com.github.surajchhetry.angularjeesecurity.customers.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author surajchhetry
 */
@Named
public class CustomerManager {
    
    private static List<Customer> customers;
    
    private static void loadCustomer() {
        customers = new ArrayList<>();
        customers.add(new Customer("Abc-123", "123-456-123"));
        customers.add(new Customer("Abc-456", "123-456-456"));
        customers.add(new Customer("Abc-789", "123-456-789"));
        customers.add(new Customer("Abc-111", "123-456-111"));
        customers.add(new Customer("Abc-222", "123-456-222"));
        customers.add(new Customer("Abc-333", "123-456-333"));
    }
    
    static {
        loadCustomer();
    }
    
    public List<Customer> findAll() {
        return customers;
    }
    
    public void add(Customer customer) {
        customer.setCid(String.valueOf(System.nanoTime()));
        customers.add(customer);
    }
    
    public Customer findById(String cid) {
        for (Customer customer : customers) {
            if (customer.getCid().equals(cid)) {
                return customer;
            }
        }
        return null;
    }
    
    public void update(Customer customer) {
        int index = customers.indexOf(customer);
        if (index >= 0) {
            customers.add(index, customer);
        }
    }
}
