package com.string.operations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.string.operations.model.Data;
import com.string.operations.model.RequestModel;
import com.string.operations.model.ResponseModel;
import com.string.operations.service.OperationsService;

@RestController
public class OperationController {
	
	@Autowired
	OperationsService operationsService;

	@PostMapping(path = "/getLongestString", consumes = "application/json", produces = "application/json")
	public ResponseEntity getLongestString(@RequestBody RequestModel request) {
		if(null != request.getList() && request.getList().size() > 0) {	
			ResponseModel response = new ResponseModel();
			response.setStatus(HttpStatus.OK);
			response.setStatusCode(200);
			Data data = new Data();
			data.setList(operationsService.getLongestString(request.getList()));
			response.setData(data);
			response.setMessage("SUCCESS");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			ResponseModel response = new ResponseModel();
			response.setStatus(HttpStatus.OK);
			response.setStatusCode(200);
			Data data = new Data();
			data.setList(new ArrayList<String>());
			response.setData(data);
			response.setMessage("FAILURE");
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		}
	}
	
	@PostMapping(path = "/deleteStrings", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteStrings(@RequestBody RequestModel request, @RequestParam("length") int length) {
		
		if(null != request.getList() && request.getList().size() > 0) {	
			ResponseModel response = new ResponseModel();
			response.setStatus(HttpStatus.OK);
			response.setStatusCode(200);
			Data data = new Data();
			data.setList(operationsService.deleteStringsMoreThan(request.getList(), length));
			response.setData(data);
			response.setMessage("SUCCESS");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			ResponseModel response = new ResponseModel();
			response.setStatus(HttpStatus.OK);
			response.setStatusCode(200);
			Data data = new Data();
			data.setList(new ArrayList<String>());
			response.setData(data);
			response.setMessage("FAILURE");
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			//return null;
		}
	}
	
}
