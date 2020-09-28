package com.altran.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.altran.app.entity.MedicalHistory;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory,Long>{

	@Query(value="SELECT m FROM MedicalHistoryRepository m ORDER BY m.componentId")
	public List<MedicalHistory> getAllHistory();
}
