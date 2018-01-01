<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome!</title>
</head>
<body>
	<#list newsList as news>
		<a href="detailNews?path=${news.htmlpath}"><h3>${news.title}</h3></a>
	</#list>
</body>
</html>