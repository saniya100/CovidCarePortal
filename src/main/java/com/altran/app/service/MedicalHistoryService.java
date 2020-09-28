package com.altran.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.app.entity.MedicalHistory;
import com.altran.app.repository.MedicalHistoryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MedicalHistoryService {

	@Autowired
	MedicalHistoryRepository medicalrepo;

	ObjectMapper mapper=new ObjectMapper();

	public String addHistory(HashMap map, HttpServletResponse response ) {
		String responseMsg=null;
		MedicalHistory historyobj=mapper.convertValue(map, MedicalHistory.class);
		Long historyComponent=(Long)map.get("componentId");
		if(medicalrepo.existsById(historyComponent)) {
			responseMsg="Component already exists in record";
		}else {
			medicalrepo.save(historyobj);
			responseMsg="Component added successfully";

		}
		return responseMsg;
	}

	public String getAllHistory(HashMap map, HttpServletResponse response ) {
		String getData=null;
		try {
		MedicalHistory historyobj=mapper.convertValue(map, MedicalHistory.class);
		List<MedicalHistory> list=new ArrayList<>();
		list=medicalrepo.getAllHistory();
		if(list.isEmpty())
		{
			getData="No records exists";
		}else {
			 
				getData=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
			} 


		}catch (JsonProcessingException e) {
			
		}
		return getData;
	}

}
