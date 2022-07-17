<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mall.cart.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 등록</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String memberId = (String)session.getAttribute("memberId");

if(memberId == null) {
	out.print("<script>alert('로그인을 해주세요.');");
	out.print("location='../logon/memberLoginForm/jsp';</script>");
}

int product_id = Integer.parseInt(request.getParameter("product_id"));
String product_name = request.getParameter("product_name");
int buy_price = Integer.parseInt(request.getParameter("buy_price"));
int buy_count = Integer.parseInt(request.getParameter("buy_count"));
String product_image = request.getParameter("product_image");

CartDTO cart = new CartDTO();
cart.setBuyer(memberId);
cart.setProduct_id(product_id);
cart.setProduct_name(product_name);
cart.setBuy_price(buy_price);
cart.setBuy_count(buy_count);
cart.setProduct_image(product_image);


//카트 정보 확인
//System.out.println(cart);



//DB 연결, 질의
CartDAO cartDAO = CartDAO.getInstance();
int check = cartDAO.insertCart(cart);


out.print("<script>");
if(check == 0) {
	out.print("alert('장바구니 추가에 실패했습니다.');history.back();");
} else {
	out.print("locaton='cartList.jsp';");
}
out.print("</script>");
%>

</body>
</html>