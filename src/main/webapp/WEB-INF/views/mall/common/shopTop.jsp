<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%-- 쇼핑몰 상단 페이지 : 쇼핑몰의 모든 페이지 상단에 포함되는 페이지  --%>
<style>
@import url('https://fonts.googleapis.com/css2? family= Hahmlet:wght@100 & family= Poor+Story & display=swap');
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Monoton&display=swap');
/* 전체 레이아웃 */
.top a { text-decoration:none; color:#000;}
.t_box1, .t_box2, .t_box3, .t_box4 {display: inline-block; padding: 2%;}
.t_box1, .t_box3 {width: 63%;}
.t_box2, .t_box4 {width: 24%;}
/* 구역1: 타이틀, 검색 */
.t_box1 .m_title {font-family: 'Monoton', cursive; font-size: 40px; text-align: center;}
.t_box1 .s_title {font-family: 'Hhamlet', serif; font-size: 20px; text-align: center; }
.t_box1 .t_search {width:360px; text-align:center; margin-top: 15px; margin-left:185px;
border: 1px solid #000; padding:7px; border-radius: 35px; }
.t_box1 .t_search #keyword { height: 38px; width:300px; border:none; font-size: 0.9em;}
.t_box1 .t_search #keyword focus { outline:none;}
.t_box1 .t_search button {border: none; background: #fff; cursor:pointer;}
/* 구역 2: 회원정보, 구매정보, 장바구니 정보 */
.t_box2 {float: right; text-align: right; line-height: 100px;}
.t_box2 .t_b2_img1:hover {content: url('../../icons/user2.png');}
.t_box2 .t_b2_img2:hover {content: url('../../icons/buy2.png');}
.t_box2 .t_b2_img3:hover {content: url('../../icons/cart2.png');}
/* 구역 3: 메인메뉴(하위메뉴) */
.t_box3 {float: left; position: relative;}
.m_menu0 {display: inline-block; width: 40px; }
.m_menu0 .m_menu_img:hover { content: url('../../icons/menu2.png'); width: 30px;}
.m_menu {display: inline-block; }
.m_menu a { font-family: 'Jua', sans-serif; font-size:20px; color: #a6615a; width:100px; padding:5px; margin:5px;}
.s_menu {display:none; top: 55px; position:absolute; width:130px; background:#e9e1f4; z-index: 10;}
.sm1 { left: 70px;}
.sm2 { left: 150px;}
.sm3 { left: 210px;}
.sm4 { left: 345px;}
.sm5 { left: 446px;}
.sm6 { left: 547px;}
.m_menu a:hover { color: purple; text-shadow: 1px 1px 1px lightgray; }
.m_menu:hover .s_menu {display:block;}
.s_menu div { padding: 10px 0;}
.s_menu div a { font-family: '고딕'; font-size: 0.9em; color: #000;}
.s_menu div a:hover { font-weight: bold; font-size: 1.0em; text-shadow: 1px 1px 1px gray;}
/* 구역 4: 로그인, 회원가입, 고객센터 */
.t_box4 {float: right; text-align: right;}
.t_box4 a { color:gray; font-size:14px; font-weight: bold;}
.top_end {clear:both;}
</style>
<%
String memberId = (String)session.getAttribute("memberId");

%>
<div class="top">
	<div class="t_box1"> <%--구역1(상단 좌측): 타이틀, 검색--%>
		<div class="m_title"><a href="../shopping/shopAll.jsp">EZENMALL</a></div>
		<div class="s_title">책과 함께 인생의 지혜를</div>
		<div class="t_search">
			<form action="" method="post" name="searchForm">
				<input type="search" name="keyword" id="keyword" placeholder="인생책을 입력하세요.">
				<button type="submit"><img src="../../icons/search.png" width="25" height="25"></button>
			</form>
		</div>
	</div>
	<div class="t_box2"> <%--구역2(상단 우측): 회원정보, 구매정보, 장바구니 정보--%>
		<a href="../member/memberInfoForm.jsp"><img src="../../icons/user1.png" width="40" title="회원정보" class="t_b2_img1"></a>&emsp;&emsp;
		<a href="#"><img src="../../icons/buy1.png" width="40" title="구매정보" class="t_b2_img2"></a>&emsp;&emsp;
		<a href="../cart/cartList.jsp"><img src="../../icons/cart1.png" width="40" title="장바구니정보" class="t_b2_img3"></a>	
	</div>	
	<div class="t_box3"> <%--구역3(하단 좌측): 메인메뉴(하위메뉴)--%>
		<div class="m_menu0"><a href="#"><img src="../../icons/menu1.png" width="25" class="m_menu_img"></a></div>	
		<div class="m_menu mm1">
			<a href="#">소설/시</a>
			<div class="s_menu sm1">
				<div><a href="shopAll.jsp?product_kind=110">소설/시</a></div>
				<div><a href="shopAll.jsp?product_kind=120">에세이</a></div>	
				</div>
			</div>
		<div class="m_menu mm2">
			<a href="#">인문</a>	
			<div class="s_menu sm2">
				<div><a href="shopAll.jsp?product_kind=210#t_kind">역사</a></div>
				<div><a href="shopAll.jsp?product_kind=220#t_kind">예술</a></div>		
				<div><a href="shopAll.jsp?product_kind=230#t_kind">종교</a></div>
				<div><a href="shopAll.jsp?product_kind=240#t_kind">사회</a></div>
				<div><a href="shopAll.jsp?product_kind=250#t_kind">과학</a></div>
			</div>
		</div>
		<div class="m_menu mm3">
			<a href="#">경제/자기계발</a>
			<div class="s_menu sm3">
				<div><a href="shopAll.jsp?product_kind=310#t_kind">경제/경영</a></div>
				<div><a href="shopAll.jsp?product_kind=320#t_kind">자기계발</a></div>		
			</div>
		</div>
		<div class="m_menu mm4">
			<a href="#">여행/잡지</a>
			<div class="s_menu sm4">
				<div><a href="shopAll.jsp?product_kind=410#t_kind">여행</a></div>
				<div><a href="shopAll.jsp?product_kind=420#t_kind">만화</a></div>
				<div><a href="shopAll.jsp?product_kind=510#t_kind">잡지</a></div>		
			</div>						
		</div>	
		<div class="m_menu mm5">
			<a href="#">가정/건강</a>
			<div class="s_menu sm5">
				<div><a href="shopAll.jsp?product_kind=610#t_kind">어린이</a></div>
				<div><a href="shopAll.jsp?product_kind=620#t_kind">육아</a></div>		
				<div><a href="shopAll.jsp?product_kind=630#t_kind">가정/살림</a></div>
				<div><a href="shopAll.jsp?product_kind=710#t_kind">건강/취미</a></div>
				<div><a href="shopAll.jsp?product_kind=720#t_kind">요리</a></div>	
			</div>
		</div>
			<div class="m_menu mm6">
				<a href="#">IT/수험서</a>
				<div class="s_menu sm6">
					<div><a href="shopAll.jsp?product_kind=810#t_kind">IT/모바일</a></div>
					<div><a href="shopAll.jsp?product_kind=820#t_kind">수험서/자격증</a></div>		
					<div><a href="shopAll.jsp?product_kind=910#t_kind">참고서</a></div>
				</div>
			</div>
		</div>
		<div class="t_box4"> <%--구역4(하단 우측): 로그인, 회원가입, 고객센터--%>
			<%if(memberId == null) {%>
			<a href="../logon/memberLoginForm.jsp"><span>로그인</span></a>&ensp;|&ensp;
			<a href="../member/memberJoinForm.jsp"><span>회원가입</span></a>&ensp;|
			<%} else {%>
			<a href="../member/memberInfoForm.jsp"><%=memberId %>님</a>&ensp;| <a href="../logon/memberLogout.jsp">로그아웃</a> |
			<%}  %>
			<a href="#"><span>고객센터</span></a>	
		</div>
	</div>
<hr class="top_end">