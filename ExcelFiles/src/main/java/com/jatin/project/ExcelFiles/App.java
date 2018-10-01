package com.jatin.project.ExcelFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jatin.project.ExcelFiles.model.Client;
import com.jatin.project.ExcelFiles.model.ErrorCodeMapper;


public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );
		try
		{
			FileInputStream file = new FileInputStream(new File("/Users/B0205328/Downloads/PYTHON_SAMPLE_FILE.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook wbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = wbook.getSheetAt(0);


			Iterator<Row> rowIterator = sheet.iterator();
			int j=0;


			HashMap<Client,Integer> clientList = new HashMap<Client,Integer>();
			HashSet<Client>hashSet = new HashSet<Client>();

			while (rowIterator.hasNext())
			{
				j++;
				Row row = rowIterator.next();
				if(j==1)
					continue;

				Iterator<Cell> cellIterator = row.cellIterator();
				// For Tracking date purpose
				int i=0;
				Client c = new Client();

				while (cellIterator.hasNext())
				{

					Cell cell = cellIterator.next();

					i++;
					switch (i!=2?cell.getCellType():i)
					{
					case 2:
						Long str = (long) cell.getNumericCellValue();
						c.setDate(new Date(str).toString());
						break;

					case Cell.CELL_TYPE_STRING:
						if(i==1)
							c.setClientId(cell.getStringCellValue());
						else
							c.setSymbol(cell.getStringCellValue());
						break;
					}//switch case ends

				}

				//Main Logic
				if(!hashSet.contains(c)) {
					hashSet.add(c);
					clientList.put(c, 1);
				}
				else {
					int val = clientList.get(c);
					val = val + 1;
					clientList.put(c, val);
				}
			}

			System.out.println("Length of List : " + clientList.size());

			//Iterating over all unique entries
			//clientList.entrySet().forEach( t -> {System.out.println(t.getKey() + " : " + t.getValue());});

			System.out.println("Length of List : " + clientList.size());
			System.out.println("Length of HashSet : " + hashSet.size());
			file.close();

			writeToFile(clientList);
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		chetanScript();
	}

	private static void chetanScript() {

		try {

			FileInputStream file = new FileInputStream(new File("/Users/B0205328/Desktop/Workbook1.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook wbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			
			int len = wbook.getNumberOfSheets();
			for(int k=0; k <len; k++) {
			XSSFSheet sheet = wbook.getSheetAt(k);

			Iterator<Row> rowIterator = sheet.iterator();

			
			List<ErrorCodeMapper> clientList = new ArrayList<>();

			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				
				Iterator<Cell> cellIterator = row.cellIterator();
				// For Tracking date purpose
				int i=0;
				ErrorCodeMapper c = new ErrorCodeMapper();

				while (cellIterator.hasNext())
				{

					Cell cell = cellIterator.next();

					i++;
					switch (i)
					{
					
					case 1:
							c.setId(cell.getStringCellValue());
						break;
						
					case 2:
						c.setErrorId(cell.getStringCellValue());
						break;
					
					case 3:
						c.setErrorCode(cell.getStringCellValue());
						break;
						
					case 4:
						c.setErrorMsg(cell.getStringCellValue());
						break;
						
					case 5:
						try {
						c.setOrgErrorCode(cell.getStringCellValue());
						}catch(Exception ex) {
							
							String val = cell.getNumericCellValue()  + "";
							if(val.contains(".")) {
								val = val.substring(0, val.indexOf("."));
							}
						c.setOrgErrorCode(val);
						}
						break;
						
					case 6:
						c.setOrgErrorMsg(cell.getStringCellValue());
						break;
						
					case 7:
						c.setApiName(cell.getStringCellValue());
						break;
						
					case 8:
						c.setType(cell.getStringCellValue());
					}//switch case ends

				}

				//Main Logic
				clientList.add(c);
				c = null;
			}

			writeToFileNew(clientList,k);
			}
			
			file.close();

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	private static void writeToFileNew(List<ErrorCodeMapper> clientList, int val) throws IOException {
		Iterator<ErrorCodeMapper> it = clientList.listIterator();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/B0205328/Desktop/query_" +val+"_.txt"));

		
		while(it.hasNext()) {
			ErrorCodeMapper er = (ErrorCodeMapper)it.next();
			String query = "INSERT INTO test.ErrorCodeMapper (PK, '@user_key', errorCode, errorMsg, orgErrorCode, orgErrorMsg, apiName,type) VALUES";
			bufferedWriter.write(query + er.toString());
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}

	private static void writeToFile(HashMap<Client, Integer> clientList) throws IOException {
		// TODO Auto-generated method stub

		Iterator<Entry<Client, Integer>> it = clientList.entrySet().iterator();
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/B0205328/Desktop/result.txt"));

		bufferedWriter.write("Client ID " + "Count");
		while(it.hasNext()) {
			Entry<Client,Integer>entry = it.next();
			bufferedWriter.write(entry.getKey().getClientId() + " : " + entry.getValue());
			bufferedWriter.newLine();
		}

		bufferedWriter.close();
	}

}

