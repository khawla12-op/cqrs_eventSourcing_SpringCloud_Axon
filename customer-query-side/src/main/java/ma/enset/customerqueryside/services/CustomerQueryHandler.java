package ma.enset.customerqueryside.services;

import lombok.extern.slf4j.Slf4j;
import ma.enset.coreapi.query.GetAllCustomersQuery;
import ma.enset.coreapi.query.GetCustomerByIdQuery;
import ma.enset.customerqueryside.CustomerRepository;
import ma.enset.customerqueryside.entities.Customer;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerQueryHandler {
    public CustomerRepository customerRepository;
    @QueryHandler
    public List<Customer> customerList(GetAllCustomersQuery query){
        return customerRepository.findAll();
    };
    @QueryHandler
    public Customer customerList(GetCustomerByIdQuery query){
        return customerRepository.findById(query.getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    };
}
