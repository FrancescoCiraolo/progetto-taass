package com.github.neocstaass.iina.transactions.repositories;

import com.github.neocstaass.iina.models.SimpleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<SimpleModel, Long> {
}
