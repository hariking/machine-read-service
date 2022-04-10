# machine-read-service
The service is to read the exposed messages from Web Socket Server using WebSocketClient and to Store it in in-memory database(H2). Also expose the stored messages as JSON via REST endpoint end  

Download the Zip Project or Clone the project

# Running project local
As the project is implemented using Spring Boot Framework. Please use the following command to run the project locally
- mvn spring-boot:run

# Server Start Up

Once the server strarts up. It invokes the pre-defined Web Socket Server exposed at "ws://machinestream.herokuapp.com/ws". 

It reads the message and stores into the in-memory database(For sample application used spring integrated H2 database. In order to change the database please change application.properties file with respective database details(MySQL, Oracle..etc))

# Server Start Up Logs

2022-04-10 11:29:01.231  INFO 15860 --- [lient-AsyncIO-1] c.m.m.read.service.websocket.WSClient    : Received Message from WebSoket : {"topic":"events","ref":null,"payload":{"timestamp":"2022-04-10T09:29:01Z","status":"running","machine_id":"15c14416-caa2-46da-a435-1c6a01e7e47f","id":"fb25d128-08d6-4381-8a71-4eca04409ef6"},"join_ref":null,"event":"new"}
2022-04-10 11:29:01.259  INFO 15860 --- [lient-AsyncIO-1] c.m.m.read.service.websocket.WSClient    : Save Message Response Status :200 OK
2022-04-10 11:29:01.260  INFO 15860 --- [lient-AsyncIO-1] c.m.m.read.service.websocket.WSClient    : Received Message from WebSoket : {"topic":"events","ref":null,"payload":{"timestamp":"2022-04-10T09:29:01Z","status":"running","machine_id":"653cab7e-03e7-47ce-b73f-4694e7093729","id":"638b8c08-70f2-46fd-bcf2-386187a16d64"},"join_ref":null,"event":"new"}
2022-04-10 11:29:01.289  INFO 15860 --- [lient-AsyncIO-1] c.m.m.read.service.websocket.WSClient    : Save Message Response Status :200 OK
2022-04-10 11:29:01.291  INFO 15860 --- [lient-AsyncIO-1] c.m.m.read.service.websocket.WSClient    : Received Message from WebSoket : {"topic":"events","ref":null,"payload":{"timestamp":"2022-04-10T09:29:01Z","status":"running","machine_id":"cad031e6-e4ed-4d9a-b10d-ff9920d32b4e","id":"0d391397-34eb-4b79-99cc-98028378b3e3"},"join_ref":null,"event":"new"}
2022-04-10 11:29:01.336  INFO 15860 --- [lient-AsyncIO-1] c.m.m.read.service.websocket.WSClient    : Save Message Response Status :200 OK

# Test Service

Hit the below REST endpoint(GET).  
http://localhost:8080/machine/read/service/v1/messages 

Response :
[{"topic":"events","ref":null,"event":"new","payload":{"id":"2d8e3ef3-ad30-4fff-8d9e-eb617f98049e","status":"running","timestamp":"2022-04-10T09:28:46Z","machine_id":"63f9d31e-18cf-4def-8887-164366d70c46"},"join_ref":null},{"topic":"events","ref":null,"event":"new","payload":{"id":"fb25d128-08d6-4381-8a71-4eca04409ef6","status":"running","timestamp":"2022-04-10T09:29:01Z","machine_id":"15c14416-caa2-46da-a435-1c6a01e7e47f"},"join_ref":null},{"topic":"events","ref":null,"event":"new","payload":{"id":"638b8c08-70f2-46fd-bcf2-386187a16d64","status":"running","timestamp":"2022-04-10T09:29:01Z","machine_id":"653cab7e-03e7-47ce-b73f-4694e7093729"},"join_ref":null},{"topic":"events","ref":null,"event":"new","payload":{"id":"0d391397-34eb-4b79-99cc-98028378b3e3","status":"running","timestamp":"2022-04-10T09:29:01Z","machine_id":"cad031e6-e4ed-4d9a-b10d-ff9920d32b4e"},"join_ref":null},{"topic":"events","ref":null,"event":"new","payload":{"id":"c312a955-87c1-4e10-97bd-7aa13158ed01","status":"finished","timestamp":"2022-04-10T09:29:06Z","machine_id":"5b3ec85c-d2ff-404f-aa6b-0a5e82537caa"},"join_ref":null},{"topic":"events","ref":null,"event":"new","payload":{"id":"40266ba7-76de-4420-a7eb-33cced5bbb67","status":"finished","timestamp":"2022-04-10T09:29:06Z","machine_id":"ce0753da-1b8e-4ffc-b346-3158eec5b9d8"},"join_ref":null},{"topic":"events","ref":null,"event":"new","payload":{"id":"dbdcfc67-0382-4b1c-a3fa-c85825e28677","status":"running","timestamp":"2022-04-10T09:29:11Z","machine_id":"e0776fcc-b8e7-4927-943b-10235df7678c"},"join_ref":null}]
