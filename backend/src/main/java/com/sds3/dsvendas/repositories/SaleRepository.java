package com.sds3.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sds3.dsvendas.dto.SaleSumDTO;
import com.sds3.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new com.sds3.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amout)) "
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupeBySeller();
}
