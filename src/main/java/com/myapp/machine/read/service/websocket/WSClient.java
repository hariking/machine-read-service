package com.myapp.machine.read.service.websocket;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.myapp.machine.read.service.repo.Messages;

@ClientEndpoint
public class WSClient {
	private static final String WS_MACHINESTREAM_HEROKUAPP_COM_WS = "ws://machinestream.herokuapp.com/ws";
	private static Logger logger = LogManager.getLogger(WSClient.class);
	private static Object waitLock = new Object();
	


	@OnMessage
	public void onMessage(String message) {
		logger.info("Received Message from WebSoket : {}",()-> message);
		RestTemplate restApi = new RestTemplate();
		
		String saveMessageResourceUrl="http://localhost:8080/machine/read/service/v1/messages";
		Messages messages= new Messages();
		messages.setMessage(message);
		ResponseEntity<String> response =restApi.postForEntity(saveMessageResourceUrl, messages, String.class);
		logger.info("Save Message Response Status :{}" ,()-> response.getStatusCode());
	}

	private static void wait4TerminateSignal() {
		synchronized (waitLock) {
			try {
				waitLock.wait();
			} catch (InterruptedException e) {
				logger.error("Got an exception", ()->e);
			}
		}
	}

	public static void connectToServer() {
		WebSocketContainer container = null;
		Session session = null;
		try {
			container = ContainerProvider.getWebSocketContainer();
			session = container.connectToServer(WSClient.class, URI.create(WS_MACHINESTREAM_HEROKUAPP_COM_WS));
			wait4TerminateSignal();
		} catch (Exception e) {
			logger.error("Got an exception", ()->e);
		} finally {
			if (session != null) {
				try {
					session.close();
				} catch (Exception e) {
					logger.error("Got an exception", ()->e);
				}
			}
		}
	}
}
