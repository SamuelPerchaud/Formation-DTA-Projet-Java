<%@page import="java.util.Date"%>
<html>
<body>

<%for(int i =0;i<4;i++){ %>
<%=i %>
<h2>Hello Sam!</h2>
<%} %>
<h3>nous somme le :</h3>

<%= new Date() %>
</body>
</html>
