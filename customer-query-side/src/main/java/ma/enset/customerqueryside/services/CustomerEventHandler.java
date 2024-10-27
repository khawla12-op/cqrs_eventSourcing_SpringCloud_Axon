package ma.enset.customerqueryside.services;

import lombok.extern.slf4j.Slf4j;
import ma.enset.coreapi.commands.CustomerCreatedEvent;
import ma.enset.customerqueryside.CustomerRepository;
import ma.enset.customerqueryside.entities.Customer;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerEventHandler {
    private CustomerRepository customerRepository;
    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("Customer Cretead Event received");
        Customer customer= new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customerRepository.save(customer);
    }
}
