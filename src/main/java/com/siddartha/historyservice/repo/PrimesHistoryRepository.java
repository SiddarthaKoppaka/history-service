package com.siddartha.historyservice.repo;

import java.util.List;

import com.siddartha.historyservice.model.PrimesRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrimesHistoryRepository extends CrudRepository<PrimesRecord, Integer> {

	List<PrimesRecord> findAllByCustomer(String customer);
}
