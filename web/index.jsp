<!DOCTYPE html>
<html lang=en>
<head>
  <meta charset=utf-8>
  <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,700' rel=stylesheet type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700' rel=stylesheet type='text/css'>
  <title>Bitstamp live trades example</title>
  <style>
    body {font-family:'Roboto', sans-serif;}
    h1 {font-size:30px;width:500px;color:#666;margin:0 auto 20px auto;}
    #trades_placeholder {width:500px;margin:0 auto;}
    #trades_placeholder > div {}
  </style>
</head>
<body>
<h1>Bitstamp live trades</h1>
<div id=trades_placeholder>waiting for some trades to happen...</div>
<script src="https://d3dy5gmtp8yhk7.cloudfront.net/2.1/pusher.min.js"></script>
<script>
    var placeholder = document.getElementById('trades_placeholder'),
        pusher = new Pusher('de504dc5763aeef9ff52'),
        tradesChannel = pusher.subscribe('live_trades'),
        child = null,
        i = 0;

    tradesChannel.bind('trade', function (data) {
        if (i === 0) {
            placeholder.innerHTML = '';
        }
        child = document.createElement('div');
        child.innerHTML = '(' + data.timestamp + ') ' + data.id + ': ' + data.amount + ' BTC @ ' + data.price + ' USD ' + data.type;
        placeholder.appendChild(child);
        document.getElementById("timestamp").value=data.timestamp;
        document.getElementById("id").value=data.id;
        document.getElementById("amount").value=data.amount;
        document.getElementById("price").value=data.price;
        document.getElementById("type").value=data.type;
        i++;
        document.getElementById("liveTrades").submit();
    });
</script>
<form id="liveTrades", method="post" action="liveTrade" target="liveTrades">
  <input type="hidden" name="timestamp" id="timestamp">
  <input type="hidden" name="id" id="id">
  <input type="hidden" name="amount" id="amount">
  <input type="hidden" name="price" id="price">
  <input type="hidden" name="type" id="type">
  <iframe name="liveTrades" hidden></iframe>
</form>
<script>
  var form = document.getElementById("liveTrades");
  function showDiv() {
      alert("Form Submitted");
  }
  form.addEventListener("submit", showDiv)
</script>
</body>
</html>