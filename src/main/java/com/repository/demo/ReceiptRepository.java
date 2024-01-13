package com.repository.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.demo.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
	

}
