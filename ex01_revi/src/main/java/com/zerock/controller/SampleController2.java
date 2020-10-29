package com.zerock.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zerock.domain.SampleDTO;

@Controller
@RequestMapping("/sample2/*")
public class SampleController2 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	/* 리턴 타입*/

	//호출하는 url과 동일한 jsp 호출
	@GetMapping("/ex05")
	public void ex05() {
		logger.info("/ex05............");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		logger.info("/ex06............");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("allen");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		
		logger.info("/ex07............");
		
		// {"name" : "allen" }
		String msg= "{\"name\" : \"allen\" }";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(msg,header,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/exUpload", method = RequestMethod.GET)
	public String exUpload() {
		logger.info("/exUpload.... ");
		return "/sample/exUpload";
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file->{
			logger.info("----------------[출력1]--------------------------");
			logger.info("name : " + file.getOriginalFilename());
			logger.info("size : " + file.getSize());
		});
		
		logger.info("----------------[출력2]--------------------------");
		for(int i=0; i< files.size(); i++) {
			logger.info("name : " + files.get(i).getOriginalFilename());
			logger.info("size : " +files.get(i).getSize());
		}
		
	}
	
	
}
