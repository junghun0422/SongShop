<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocket Test</title>
</head>
<script type="text/javascript" src="lib/scripts/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="lib/scripts/sockjs.js"></script>
<script type="text/javascript" src="lib/scripts/stomp.js"></script>
<script type="text/javascript">

	var ws_rc = new WebSocket("ws://192.168.1.156:15674/ws");
	var client_rc = Stomp.over(ws_rc);
	var client_id_rc;

	var on_connect_rc = function(x) {
		client_id_rc = client_rc.subscribe("/exchange/monitor-exchange", function(m) {
			var mqData;
			try
			{
				mqData = JSON.parse(JSON.parse(m.body.split("").join("")));
			}
			catch(e)
			{
				mqData = JSON.parse(m.body.split("").join(""));

				try
				{
					
				}
				catch(e)
				{
					console.log(e);
				}
				console.log(e);
			}

			if(typeof mqData != "object") mqData = JSON.parse(m.body);

			//console.log(mqData);
			$("#output").append("<div>" + JSON.stringify(mqData) + "</div>")
		});
	};

	var onReceive = function(JSON_DAT)
	{
		console.log("onReceive :: " + JSON_DATA);
	};

	var onError = function(e) 
	{
		console.log("error", e);
	};

	client_rc.connect('parking', 'parking', on_connect_rc, onError, 'internal');
	
/* 
 var wsUri = "ws://echo.websocket.org/";
	var output;

	function init()
	{
		output = document.getElementById("output");
		testWebSocket();
	}

	function testWebSocket()
	{
		websocket = new WebSocket(wsUri);
		websocket.onopen = function(evt) { onOpen(evt); }
		websocket.onclose = function(evt) { onClose(evt); }
		websocket.onmessage = function(evt) { onMessage(evt); }
		websocket.onError = function(evt) { onError(evt); }
	}

	function onOpen(evt)
	{
		writeToScreen("연결완료");
		doSend("테스트 메세지");
	}

	function onClose(evt)
	{
		writeToScreen("연결해제")
	}

	function onMessage(evt)
	{
		writeToScreen("<span style='color:blue;'>수신 :: " + evt.data + "</span>");
	}

	function onError(evt)
	{
		writeToScreen("<span style='color:red;'>에러 :: </span>" + evt.data);
	}

	function doSend(msg)
	{
		websocket.send(msg);
	}

	function writeToScreen(msg)
	{
		var pre = document.createElement("p");
		pre.style.wordWrap = "break-word";
		pre.innerHTML = msg;
		output.appendChild(pre);
	}

	window.addEventListener("load", init, this); 
*/
	
</script>
<body>
	<h2>WebScoket Test</h2>
	<div id="output"></div>
</body>
</html>