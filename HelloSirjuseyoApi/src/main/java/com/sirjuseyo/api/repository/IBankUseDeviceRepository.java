package com.sirjuseyo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirjuseyo.api.model.BankUseDevice;

public interface IBankUseDeviceRepository extends JpaRepository<BankUseDevice, Integer>  {
//	List<BankUseDevice> findBySalBetween(int y1,int y2);
	
}
