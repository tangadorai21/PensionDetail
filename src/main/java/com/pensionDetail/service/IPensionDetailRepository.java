package com.pensionDetail.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionDetail.entity.PensionDetailEntity;

@Repository
public interface IPensionDetailRepository extends JpaRepository<PensionDetailEntity, Integer> {

	Optional<PensionDetailEntity> findByAadhar(Integer aadhar);

	void deleteByAadhar(Integer aadhar);
	

}
