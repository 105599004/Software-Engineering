<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" import="model.*"%>
<%@ page contentType="text/html; charset=UTF-8" import="DAO.*"%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.List"%>
<%
	List<User> us1 = (List<User>)session.getAttribute("userlist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<%for (int i = 0; i < us1.size(); i++) {%>
		<li>
			<a><%=us1.get(0).getId()%></a>|<a><%=us1.get(i).getAccount()%></a>|<a><%=us1.get(i).getPassword()%></a>|<a><%=us1.get(i).getName()%></a>|<a><%=us1.get(i).getEmail()%></a>|<a><%=us1.get(i).getRole()%></a>|<a><%=us1.get(i).getEnrollment()%></a>
		</li>
	<%}%>
</body>
</html>