package com.pensionDetail.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pensionDetail.entity.PensionDetailEntity;
import com.pensionDetail.service.IPensionDetailService;



@RestController
public class PensionDetailController {
	@Autowired
	IPensionDetailService pensionDetailService;
	
	@GetMapping("/welcomePensionBoysandGirl")
	public String Ordermanagement() {
		return "hello this is pension details";
	}
	@PostMapping("/Detail")
	Integer createOrder (@RequestBody PensionDetailEntity detail) {
		Integer id =pensionDetailService.saveDetail(detail);
		System.out.println(id);
		return id;
	}
	@GetMapping("/Detail/{id}")
	public Optional<PensionDetailEntity> getDetail(@PathVariable Integer id)
	{
		Optional<PensionDetailEntity> detail = pensionDetailService.getDetail(id);
		return detail;
	}
	
	@GetMapping("/allDetails")
	public List<PensionDetailEntity> getDetail(){
		return pensionDetailService.getALLDetails();
	}
	
	@DeleteMapping("/detail/{id}")
	public ResponseEntity<PensionDetailEntity> deleteDetail(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<PensionDetailEntity> responseEntity = new ResponseEntity<PensionDetailEntity>(HttpStatus.OK);
		try {
			pensionDetailService.deleteDetail(id);
		}
			catch (Exception e) {
				e.printStackTrace();
				responseEntity =new ResponseEntity<PensionDetailEntity>(HttpStatus.NOT_FOUND);
			}
			return responseEntity;
	}
	@PutMapping("/updateDetail/{id}")
	public ResponseEntity<PensionDetailEntity> updateDetail(@PathVariable Integer id, @RequestBody PensionDetailEntity detail  ){
	ResponseEntity<PensionDetailEntity> pensionDetailEntity = new ResponseEntity<>(HttpStatus.OK);
	try {
		pensionDetailService.updateDetail(detail, id);
	}
		catch (Exception e) {
			e.printStackTrace();
			pensionDetailEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
	 return pensionDetailEntity;
	}
	
	

}
