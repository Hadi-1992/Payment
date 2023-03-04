package ir.mapsa.payment.repositories;

import ir.mapsa.payment.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
List<Transaction> findBySenderCardNumberAndDateBetween(String senderCardNumber, Date start, Date end);

}
