<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="manager.product.*" %>
<%@ page import="manager.product.*, java.util.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 삭제 처리</title>
</head>
<body>

<%
String pageNum = request.getParameter("pageNum"); //디비처리 후 삭제된페이지로 가야해서 
int product_id = Integer.parseInt(request.getParameter("product_id"));  //enctype때문에 리퀘스트로 받으면 안된다! 
ProductDAO productDAO = ProductDAO.getInstance();
productDAO.deleteProduct(product_id);
response.sendRedirect("productList.jsp?pageNum=" + pageNum);
%>
</body>
</html>