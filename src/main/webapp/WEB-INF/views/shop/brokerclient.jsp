<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>broker클라이언트</title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/paho-mqtt/1.0.1/mqttws31.min.js" 
	type="text/javascript"></script>
	
	<script>
	var dt = new Date().getTime(); //현재시간얻기, ID중복 방지용
	
	//서버주소, 포트번호, 클라이언트아이디
	var client = new Paho.MQTT.Client('211.110.165.201', 1884, '?????');

	//연결 성공시
	client.connect({onSuccess:mySuccess});
	function mySuccess(){
		client.subscribe('/dg/c801/ccc/#'); //내가 받고자 하는 토픽 설정
		$('#output').prepend('broker서버에 접속됨.'+"\n");
	}
	
	//메시지가 왔을때
	client.onMessageArrived = myMessageArrived;
	function myMessageArrived(message){
		console.log(message);
		$('#output').prepend(message.destinationName + " ] " + message.payloadString + "\n");
		$('#output1').prepend(message.payloadString+"<br />");
	}
	
	//연결 종료시
	client.onConnectionLost = myConnectionLost;
	function myConnectionLost(obj){
		$('#output').prepend('클라이언트 나감 %j', obj);
		
	}
	
	$(function(){
		$('#btn_send').click(function(){
			var topic="/dg/c801/ccc/" + ('?????');
			var payload = $('#msg').val();
			
			message = new Paho.MQTT.Message(payload); //보낼 메시지
			message.destinationName = topic; //토픽설정
			client.send(message);
		})
	});
	</script>
</head>

<body>
	<input type="text" id="msg" placeholder="메시지 입력" />
	<input type="button" id="btn_send" value="보내기" /><br />
	<textarea rows="20" style="width:500px" id="output" placeholder="메시지 출력" readonly></textarea>
	<div id="output1" style="width:500px; height:500px; border:1px solid #cccccc"></div>	
</body>
</html>