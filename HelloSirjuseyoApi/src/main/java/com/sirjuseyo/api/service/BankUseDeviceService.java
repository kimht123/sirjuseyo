package com.sirjuseyo.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirjuseyo.api.exception.ResourceNotFoundException;
import com.sirjuseyo.api.model.BankUseDevice;
import com.sirjuseyo.api.repository.IBankUseDeviceRepository;

@Service
public class BankUseDeviceService implements IBankUseDeviceService {

	@Autowired
	private IBankUseDeviceRepository iBankUseDeviceRepository;
	
	@Override
	public List<BankUseDevice> findAll() {
		List<BankUseDevice> bankUseDevices = new ArrayList<>();
		iBankUseDeviceRepository.findAll().forEach(e -> bankUseDevices.add(e));
		return bankUseDevices;
	}

	@Override
	public BankUseDevice findById(int yyyy) {
		BankUseDevice bankUseDevice = iBankUseDeviceRepository.findById(yyyy).orElseThrow(() -> new ResourceNotFoundException("BankUseDevice","yyyy",yyyy));
		return bankUseDevice;
	}

	@Override
	public void deleteById(int yyyy) {
		BankUseDevice bankUseDevice = iBankUseDeviceRepository.findById(yyyy).orElseThrow(() -> new ResourceNotFoundException("BankUseDevice","yyyy",yyyy));
		iBankUseDeviceRepository.deleteById(yyyy);
		
	}

	@Override
	public BankUseDevice save(BankUseDevice bankUseDevice) {
		iBankUseDeviceRepository.save(bankUseDevice);
		return bankUseDevice;
	}

	@Override
	public void updateById(BankUseDevice bankUseDevice) {
		// TODO Auto-generated method stub
		
	}

}
