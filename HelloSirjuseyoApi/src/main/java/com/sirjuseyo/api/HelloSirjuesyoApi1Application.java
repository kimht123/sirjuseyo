package com.sirjuseyo.api;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sirjuseyo.api.model.BankUseDevice;
import com.sirjuseyo.api.repository.IBankUseDeviceRepository;

@SpringBootApplication
public class HelloSirjuesyoApi1Application implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(HelloSirjuesyoApi1Application.class, args);
	}
	@Autowired
	IBankUseDeviceRepository repository ;
	
	@Override
	public void run(String... args) throws Exception {
		List<BankUseDevice> bankUseDevices = xlsUpload("C:/Users/tiy_kim/Desktop/BankUseDevices.xls");
		for(BankUseDevice bud : bankUseDevices) {
			repository.save(bud);
		}
	}

	private List<BankUseDevice> xlsUpload(String path) {
		List<BankUseDevice> bankUseDevices = new ArrayList<BankUseDevice>();
		try {
			FileInputStream file = new FileInputStream(path);
			HSSFWorkbook  workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0); 
			int rows = sheet.getPhysicalNumberOfRows(); 
			int rowindex=0;
            int columnindex=0;
            for(rowindex=2;rowindex<rows;rowindex++){
				HSSFRow row = sheet.getRow(rowindex);
				if(row!=null) {
					int cells=row.getPhysicalNumberOfCells();
					Map<String,Object> map = new HashMap<String, Object>();
					
					for(columnindex=0; columnindex<=cells; columnindex++){
						HSSFCell cell = row.getCell(columnindex);
						String value="";
						if(cell==null){
							value="0";
                        }else{
                            switch (cell.getCellType()){
                            case HSSFCell.CELL_TYPE_FORMULA:
                                value=cell.getCellFormula();
                                break;
                            case HSSFCell.CELL_TYPE_NUMERIC:
                                value=cell.getNumericCellValue()+"";
                                break;
                            case HSSFCell.CELL_TYPE_STRING:
                                value=cell.getStringCellValue()+"";
                                break;
                            case HSSFCell.CELL_TYPE_BLANK:
                                value=cell.getBooleanCellValue()+"";
                                break;
                            case HSSFCell.CELL_TYPE_ERROR:
                                value=cell.getErrorCellValue()+"";
                                break;
                            }
                        }
						map.put(columnindex+"", value);						  
					}
					bankUseDevices.add(new BankUseDevice((int)Double.parseDouble(map.get("0").toString()), Double.parseDouble(map.get("1").toString()), Double.parseDouble(map.get("2").toString())
							, Double.parseDouble(map.get("3").toString()), Double.parseDouble(map.get("4").toString()), Double.parseDouble(map.get("5").toString()), Double.parseDouble(map.get("6").toString())));
				}
				
			}

		} catch (Exception e) {
			System.err.println(e.toString());
		}
		return bankUseDevices;
	}

}
