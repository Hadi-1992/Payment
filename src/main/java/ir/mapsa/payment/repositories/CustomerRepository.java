package ir.mapsa.payment.repositories;

import ir.mapsa.payment.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCardNumber(String cardNumber);
}
