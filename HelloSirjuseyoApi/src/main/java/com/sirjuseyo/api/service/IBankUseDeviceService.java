package com.sirjuseyo.api.service;

import java.util.List;
import java.util.Optional;

import com.sirjuseyo.api.model.BankUseDevice;

public interface IBankUseDeviceService {
	/* 인터넷뱅킹 접속기기 데이터 전체 조회 */
	List<BankUseDevice> findAll();
	
	/* 인터넷뱅킹 접속기기 데이터 년도 조회 */
	BankUseDevice findById(int yyyy);
	
	/* 인터넷뱅킹 접속기기 데이터 삭제 */
	void deleteById(int yyyy);

	/* 인터넷뱅킹 접속기기 데이터 저장 */
	BankUseDevice save(BankUseDevice bankUseDevice);
	
	/* 인터넷뱅킹 접속기기 데이터 업데이트 */
	void updateById(BankUseDevice bankUseDevice);
}
