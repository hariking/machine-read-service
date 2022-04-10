package com.myapp.machine.read.service.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.machine.read.service.model.MessageResponse;
import com.myapp.machine.read.service.repo.MessageRepo;
import com.myapp.machine.read.service.repo.Messages;


@RestController
@RequestMapping("/machine/read/service/v1")
public class MessageController {
	private static Logger logger = LogManager.getLogger(MessageController.class);
	@Autowired
	private MessageRepo messageRepo;
	
	@GetMapping("/messages/hello/{name}")
	public ResponseEntity<String> hello(@PathVariable String name){
		return ResponseEntity.ok("Hello "+name +"!!, Welcome to Machine Read Service !! ");
	}
	@GetMapping("/messages")
	public ResponseEntity<List<MessageResponse>> getAllMessages(){
		List<Messages> messagesList = messageRepo.findAll();
		List<MessageResponse> msgResList = new ArrayList<>();
		//String messageSample ="{\"topic\":\"events\",\"ref\":null,\"payload\":{\"timestamp\":\"2022-04-10T05:37:35Z\",\"status\":\"running\",\"machine_id\":\"799819f8-6c19-47cc-9e3f-b9438b3bed4f\",\"id\":\"00590350-940d-4d88-b534-b75dacbd2b5c\"},\"join_ref\":null,\"event\":\"new\"}";
		ObjectMapper mapper = new ObjectMapper();
		messagesList.forEach(messages ->{
			try {
				MessageResponse messageResponse = mapper.readValue(messages.getMessage(), MessageResponse.class);
				msgResList.add(messageResponse);
			} catch (IOException e) {
				logger.error("Error occured in Json Reader", e);
			}
		});
		
		return ResponseEntity.ok(msgResList);
		
	}
	@PostMapping("/messages")
	public String saveMessage(@RequestBody Messages messages) {
		messageRepo.save(messages);
		return "message saved";
	}
}
