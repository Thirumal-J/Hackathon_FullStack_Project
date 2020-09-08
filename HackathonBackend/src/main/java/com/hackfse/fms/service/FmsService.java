package com.hackfse.fms.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackfse.fms.model.DistinctEvent;
import com.hackfse.fms.model.EventInfo;
import com.hackfse.fms.repository.EventInfoRepository;

@Service
public class FmsService {
	
	@Autowired
    EventInfoRepository eventInfoRepository;
    public static Vector read(String fileName)    {
        Vector cellVectorHolder = new Vector();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            //POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                //Vector cellStoreVector=new Vector();
                List list = new ArrayList();
                while(cellIter.hasNext()){
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    list.add(myCell);
                }
                cellVectorHolder.addElement(list);
            }
        }catch (Exception e){e.printStackTrace(); }
        return cellVectorHolder;
    }
    
    public void saveToDb(Vector dataHolder) {
    	String eventId = "";
    	String location = "";
    	String benefeciary = "";
    	String eventName = "";
    	String eventDate = "";
    	int empId = 0;
    	String empName = "";
    	String bu = "";
        System.out.println("vector: "+dataHolder);
        int count = 0;
        for(Iterator iterator = dataHolder.iterator(); iterator.hasNext();) {
        	List list = (List) iterator.next();
        	if(list.get(0)==null || list.get(0).toString()=="")
        		break;
        	if(count>0) {
            
            System.out.println(list);
            //id = (int) Float.parseFloat(list.get(0).toString());
            eventId = list.get(1).toString();
            location = list.get(2).toString();
            benefeciary = list.get(3).toString();
            eventName = list.get(4).toString();
            eventDate = list.get(5).toString();
            empId = (int) Float.parseFloat(list.get(6).toString());
            empName = list.get(7).toString();
            bu = list.get(8).toString();
            
            EventInfo eventInfo = new EventInfo();
            //eventInfo.setId(id);
            eventInfo.setEventId(eventId);
            eventInfo.setLocation(location);
            eventInfo.setBenefeciary(benefeciary);
            eventInfo.setEventName(eventName);
            eventInfo.setEventDate(eventDate);
            eventInfo.setEmpId(empId);
            eventInfo.setEmpName(empName);
            eventInfo.setBu(bu);
            
            
            eventInfoRepository.save(eventInfo);
        	}
            count++;
            
        }
    }

    public List<DistinctEvent> getDistinctEvent() {
    	List<DistinctEvent> listDE = new ArrayList();
    	List<String> eventList = (List<String>) eventInfoRepository.findDistinctEvent();
        for (String temp : eventList) {
        	String eventName = eventInfoRepository.findDistinctEventName(temp);
        	DistinctEvent de = new DistinctEvent();
			de.setEventId(temp);
			de.setEventName(eventName);
			listDE.add(de);
		}
        return listDE;
    }

        
 }