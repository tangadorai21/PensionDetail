package com.pensionDetail.service;

import java.util.List;
import java.util.Optional;

import com.pensionDetail.entity.PensionDetailEntity;


public interface IPensionDetailService {
Integer saveDetail(PensionDetailEntity detail);
Optional<PensionDetailEntity> getDetail(Integer id);

public List<PensionDetailEntity> getALLDetails();

public void deleteDetail(Integer id);

Integer updateDetail(PensionDetailEntity detail, Integer id);
}
