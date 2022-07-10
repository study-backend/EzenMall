<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mall.member.*, mall.cart.*, java.util.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 목록</title>
<style>	
.container { width: 1200px; margin: 0 auto;}
.cart_list { width: 100%}
/* 상단1 */
.d1 { width: 90% padding: 15px; margin: }
/* 상단2 */
.d3 {width: 90%; padding: 15px; margin: 15px 45px; }
.d3 input[type=checkbox] {zoom:1.5; margin-right: 10px; float: left;}
.d3 label { font-size: 0.9em; margin-right: 20px;}
.d3 input[type=button] {width: 80px; height: 30px; border-radius: 3px; color:#fff; font-weight: bold; cursor: pointer;}
.d3 #btn_delete_select {background: #32708d; border: 1px solid #32708d;  margin-right: 5px;}
.d3 #btn_delete_select {background: #99424f; border: 1px solid #99424f;}

/* 상단3 */
.d3 {width: 90%; padding: 15px; margin: 15px 40px;}
.d3 .s1 { font-size: 1.1em; font-weight: bold; margin-right: 30px;}
.d3 .s2 , .d3 .s3 { display:inline-block; width: 150px; padding: 7px 17px; border: 1px solid #333; font-size: 0.8em; border-radius:15px; font-weight: bold;}
.d3 .s2 {background:#333; color:#fff; }
.d3 .s2 {background:#fff; color:#333; margin-left: -30px; z-index: -10; }
/* 상품정보 테이블 */

.t_cart_list { width: 90%; border: 1px solid gray; border-collapse: collapse; text-align: center; font-size:0.9em; border-right:none;}
.t_cart_list tr {height: 40px;}
.t_cart_list td, .t_cart_list th { border-top: 1px solid #dee2e6; border-bottom: 1px solid #dee2e6; border-left:none; border-right:none;}
.t_cart_list th {background:#f1f3f5;}
.t_cart_list td {}
.left { text-align: left; padding-left: 10px;}
.right { text-align: right; padding-right: 10px;}
.center { text-align: center;}
.td1 #check_cart { zoom: 1.5;}
.td3 .s1 { font-weight: bold; color: #1e94be;}
.td3 .s2 { font-size: 0.9em; color:gray;}
.td3 .s3 { font-size: 0.9em; color:gray; text-decoration: line-through;}
.td3 .s4, .td3 .s5 { font-weight: bold; color: #c84557;}
.td4 input[type="number"] { width: 45px; margin-bottom: 5px;}
.td5 { font-size: 1.1em; color: #c84557;}
/* number 화살표 항상 보이는 효과 */
.td4 input[type="number"]::-webkit-inner-spin-button,
.td4 input[type="number"]::-webkit-outer-spin-button {-webkit-appearance: "Always Show Up/Down Arrows"; opacity:1;}
.td4 input[type="button"] { width: 53px; height: 25px; border: 1px solid gray; background: #fff; border-radius:2px; font-size: 0.9em; }
.td7 input[type="button"] { width: 80px; height: 30px; border-radius: 3px; color: #fff; font-weight:bold; cursor:pointer; text-shadow }
.td7 .btn_buy_one { background: #1e94be; border: 1px solid #1e94be; margin-bottom: 5px;}
.td7 .btn_delete_select { background:#c84557; border: 1px solid #c84557;}



</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		//구매 수량 제한 효과 (1~99)
		let buy_count = document.getElementById("buy_count");
		buy_count.addEventListenner("keyup", function() {
			if(buy_count.value < 1) {
				buy_count.value = 1;
			}else if(buy_count.value > 100) {
				buy_count.value = 100;
			}
		})
	})
</script>
</head>
<body>
<%
String memberId = (String)session.getAttribute("memberId");

if(memberId == null) {
	
	out.print("<script>alert('로그인을 해주세요.');");
	out.print("location='../logon/memberLoginForm.jsp';</script>");
}

SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일");
DecimalFormat df = new DecimalFormat("#,###,###");


//회원 db연결질의 -> 주소정보활용
MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO member = memberDAO.getMember(memberId);

String address = member.getAddress();
String local = address.substring(0, 2); //주소에서 2글자만 추출
//배송날짜 계산과 포맷
// 규칙1. 서울: 다음날 배송
//규칙2. 토욜일욜제외
//현재날짜와 시간, 주소 판단, 요일판단

	int n = 0; // 추가 되는 날짜
	Calendar c = Calendar.getInstance();
	int w = c.get(Calendar.DAY_OF_WEEK); // 요일; 1(일) ~ 7(토)
	

	switch(local){
	case "서울": 
		if(w > 1 && w < 5) ++n;
		else if(w == 6 || w == 7) n += 3;
		else if(w == 1) n += 2;
		break;
	case "경기": 
		if(w > 1 && w < 4) n += 2;
		else if(w >= 5 && w <= 7) n += 4;
		else if(w == 1) n += 3;
		break;
	case "제주": 
		n += 7;
		break;
	default: // 지방
		if(w > 1 && w < 3) n += 3;
		else if(w >= 4 && w <= 7) n += 5;
		else if(w == 1) n += 4;
		break;
	}

	// 추가된 날짜를 더한 후의 날짜
	c.add(Calendar.DATE, n);
	int month = c.get(Calendar.MONTH) + 1; // 0 ~ 11까지 표현
	int date = c.get(Calendar.DATE);
	int week = c.get(Calendar.DAY_OF_WEEK);
	String[] weekday = {"", "일", "월", "화", "수", "목", "금", "토", "일"};

	// 배송일 확인
	String d_day = month + "월 " + date + "일 (" + weekday[week] + ")";

/*
for(CartDTO cart : cartList) {
	System.out.println(cart);
}
*/
%>

<div class="container">
	 <jsp:include page="../common/shopTop.jsp"></jsp:include> 
	<div class="cart_list">
		<div class="d3">
			<span></span>
		</div>
		<div class="d2">
			<input type="checkbox" name="ck_cart_all" id="ck_cart_all"><label for="ck_cart_all">전체선택</label>
			<input type="button" value="주문" id="btn_buy_select">
			<input type="button" value="삭제" id="btn_delete_select">
		</div>
		<div class="d3">
			<span class="s1">EZENMALL 배송</span>
			<span class="s2">당일/하루/일반 배송</span>
			<span class="s3">아침배송</span>
		</div>
		<table class="t_cart_list">
			<tr>
				<th colspan="3">상품정보</th>
				<th>수량</th>
				<th>상품금액</th>
				<th>배송정보</th>
				<th>주문</th>
			
			</tr>
			
			
			
			<%
			
			
			int product_price =0;
			int	discount_rate =0;
			int buy_price = 0;
			int buy_count = 0;
			int p_sum = 0;
			List<CartDTO> cartList = new ArrayList<CartDTO>();			
			
			for(CartDTO cart : cartList) {
			product_price = cart.getProduct_price();
			discount_rate = cart.getDiscount_rate();
			buy_price = cart.getBuy_price();
			buy_count = cart.getBuy_count();
			p_sum = buy_price * buy_count; //각 상품의 합계
			
			
			
			
			
			%>
<div class="container">
	<jsp:include page="../common/shopTop.jsp"></jsp:include>
	<div class="cart_list">
		<div class="d1"></div>
	
	
	</div>		
		
		
		
		
		
		
		
		
		
		 </div>
			
			
			
			
			<tr>
				<td class="center td1" width="3%"><input type="checkbox" name="check_cart" id="check_cart" ></td>
				<td class="center td2" width="8%"><img src="/images_ezenmall/<%=cart.getProduct_image()%>" width="60" height="90"></td>
				<td class="left td3" width="50%">
					<span><%=cart.getProduct_name() %></span><br>
					<Span><%=cart.getAuthor() %>  |  <%=cart.getPublishing_com() %></Span><br>
					<span><%=df.format(product_price)%>원</span> | <span><%=df.format(buy_price) %>원</span> (<span><%=discount_rate %>% 할인</span>)
				</td>
				<td class="center td4" width="8%">
					<!-- <input type="number" name="buy_count" value="<%=buy_count()%>" id="buy_count"><br>  -->
					<input type="button" name="btn_count" value="변경" id="btn_update">
				</td>
				<td id="right_td5" width="10%"><%=df.format(p_sum) %>원</td>
				<td class="center td6" width="12%"><%=d_day %><br></td>
				<td id="center td7" width="12%">
					<input type="button" name="btn_buy_one" value="주문" class="btn_buy_one"><br>
					<input type="button" name="btn_delete_one" value="삭제" class="btn_delete_one"><br>
				</td>
			</tr>
			<%} %>
		</table>
	</div>
	<jsp:include page="../common/shopBottom.jsp"></jsp:include>
</div>
</body>
</html>