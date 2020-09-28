package entities.dto;

import entities.Customer;

import java.util.List;

public class CustomerDTO {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customers=" + customers +
                '}';
    }
}