<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebSocket Test</title>
</head>

    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
<!--  <script type="text/javascript" src="lib/scripts/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="lib/scripts/sockjs.js"></script>
<script type="text/javascript" src="lib/scripts/stomp.js"></script> -->
<script type="text/javascript">

/* 	var ws_rc = new WebSocket("ws://192.168.1.156:15674/ws");
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

	client_rc.connect('parking', 'parking', on_connect_rc, onError, 'internal'); */
	
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
	<div id="main-content" class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="connect">WebSocket connection:</label>
                    <button id="connect" class="btn btn-default" type="submit">Connect</button>
                    <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect
                    </button>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">What is your name?</label>
                    <input type="text" id="name" class="form-control" placeholder="Your name here...">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <table id="conversation" class="table table-striped">
                <thead>
                <tr>
                    <th>Greetings</th>
                </tr>
                </thead>
                <tbody id="greetings">
                </tbody>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">

var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).name);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});
</script>
</body>
</html>