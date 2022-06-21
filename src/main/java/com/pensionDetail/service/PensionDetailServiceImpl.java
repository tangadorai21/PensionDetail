package com.pensionDetail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionDetail.entity.PensionDetailEntity;
import com.pensionDetail.exception.ResourceNotFoundException;



@Service
public class PensionDetailServiceImpl implements IPensionDetailService {
	@Autowired
	IPensionDetailRepository pensionDetailRepository;

	@Override
	public Integer saveDetail(PensionDetailEntity detail) {
		PensionDetailEntity savedDetail =pensionDetailRepository.save(detail);
		return savedDetail.getId();
	}
	@Override
	public Optional<PensionDetailEntity> getDetail(Integer id) {
		
		return pensionDetailRepository.findById(id);
	}

	@Override
	public List<PensionDetailEntity> getALLDetails() {
		return pensionDetailRepository.findAll();
	}

	@Override
	public void deleteDetail(Integer id) {
		 pensionDetailRepository.deleteById(id);
		
	}
	@Override
	public Integer updateDetail(PensionDetailEntity detail, Integer id) {
		PensionDetailEntity existingDetail = pensionDetailRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("detail","id",id) );
		existingDetail.setDateOfBirth(detail.getDateOfBirth());
		existingDetail.setName(detail.getName());
		existingDetail.setPan(detail.getPan());
		existingDetail.setSalary(detail.getSalary());
		existingDetail.setAllowance(detail.getAllowance());
		existingDetail.setPensionType(detail.getPensionType());
		existingDetail.setBankName(detail.getBankName());
		existingDetail.setAccountNumber(detail.getAccountNumber());
		existingDetail.setBankType(detail.getBankType());
		pensionDetailRepository.save(existingDetail);
			return existingDetail.getId();
		
	}

}
