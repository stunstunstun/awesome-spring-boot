<html>
<head>
</head>
<body>
<form action = "/sample/aestrans" method="POST" id="transform">
	변환할 값 : <input type="text" id="value" name="value" value="${value?if_exists}">
	<input type="button" onClick="javascript:transform.submit();" value="변환"><br><br>
	변환 결과 >>> <br><div id="divVal" name="divVal">${data?if_exists}</div><br><br>
	오리지널 : ${oristr?if_exists}<br>
	>> 암호화 : ${encstr?if_exists}<br>
	>> 복호화 : ${decstr?if_exists}<br>
</form>
</body>
</html>