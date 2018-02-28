<%@ taglib prefix = "bc" uri = "WEB-INF/tlibs/brightcove.tld"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Brightcove taglib</title>
</head>
<body>
	<bc:isBrightcoveVideoPaid brightcoveId="5436939167001" resultVar="isPaid" webpanelPortNumber="8080" />
	${ isPaid }
</body>
</html>