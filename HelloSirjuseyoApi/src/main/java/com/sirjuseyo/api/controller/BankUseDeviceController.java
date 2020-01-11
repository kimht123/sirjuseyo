package com.sirjuseyo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirjuseyo.api.model.BankUseDevice;
import com.sirjuseyo.api.service.IBankUseDeviceService;

@RestController
@RequestMapping("bankUseDevice")
public class BankUseDeviceController {
	@Autowired
	private IBankUseDeviceService service;
	
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<BankUseDevice>> getAllBankUseDevice(){
		List<BankUseDevice> bankUseDevices= service.findAll();
		return new ResponseEntity<List<BankUseDevice>>(bankUseDevices, HttpStatus.OK);
	}
	@GetMapping(value="/{yyyy}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BankUseDevice> getBankUseDevice(@PathVariable("yyyy") int yyyy){
		BankUseDevice b = service.findById(yyyy);
		
		return new ResponseEntity<BankUseDevice>(b, HttpStatus.OK);
	}
	@DeleteMapping(value="/{yyyy}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> deleteBankUseDevice(@PathVariable("yyyy") int yyyy){
		service.deleteById(yyyy);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> updateBankUseDevice(@RequestBody BankUseDevice bankUseDevice){
		service.save(bankUseDevice);		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
