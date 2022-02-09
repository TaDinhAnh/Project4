$(document).ready(function() {

	const ws = new WebSocket('ws://localhost:9000/anbud-socket');
	ws.send(JSON.stringify({
		action: 'connection',
		payload: 'user connected'
	}));
})