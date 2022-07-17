<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Hammersmith+One&family=Paytone+One&display=swap');
#container { width: 1200px; margin: 0 auto;}
a { text-decoration: none; color:black; }
/*상단 네임과 서브타이틀*/
.t_title{ font-family: 'Hammersmith One', sans-serif; font-size: 2.2em; text-align: center; margin: 30px 0;}
/*중단 입력창 - 입력창*/
.f_input { width: 450px; text-align: center; border: 1px solid #ccc; padding:10px; margin: 0 auto;}
.f_input .c_id, .f_input .c_pwd { height: 45px; margin-top: 20px; padding-left: 5px;}
.f_input .f_chk { text-align: left; margin: 10px 0 0 20px; font-size: 0.9em; color: gray; }
.f_input #btn_login { width: 415px; height: 47px;  background: black; color: white;
font-size: 16px; font-weight: bold; cursor: pointer; margin-top: 25px;  margin-bottom: 10px;}
/* 하단 - 비번찾기, 아이디 찾기, 회원가입*/
.f_a { text-align: center; margin-top: 30px; font-size: 0.9em;}
.f_a a { color: gray;}
.t_line { border: 1px solid #e9ecef; margin: 30px 0;}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function() {	
		let form = document.loginForm;
		
		//로그인 버튼을 클릭했을 때 유효성 검사 (공백 유무)
		let btn_login = document.getElementById("btn_login");
		btn_login.addEventListener("click", function(){
			if(!form.id.value) {
				alert('아이디를 입력하시오!');
				form.id.focus();
				return;
			}			
			if(!form.pwd.value) {
				alert('비밀번호를 입력하시오!');
				form.pwd.focus();
				return;
			}
			form.submit();			
		})
		
		//쿠키가 생성되어 있을 때 쿠키에 저장된 값인 아이디를 아이디 입력 상자에 넣도록 하는 작업
		//쿠키 확인 - 쿠키가 존재한다면
		if(document.cookie.length > 0){
			var search = "cookieId=";
			var idx = document.cookie.indexOf(search); //쿠키 중에서 cookieId =이 나오는 위치
			if(idx != -1){ //cookieId가 존재한다면
				idx += search.length;
				var end = document.cookie.indexOf(';', idx);
				if(end == -1) {
					end = document.cookie.length;
				}
				form.id.value = document.cookie.substring(idx, end);
				form.chk.checked = true;
			}
			
		
		}
		
		//**************************cookieId=aaa1111;path=/;expires=
		
		//로그인 상태 유지 체크박스를 체크했을 때 -> 쿠키
		//http 속성: 연결상태를 유지하지 않는다.
		//cookie, session: 연결 상태를 유지함  cookie:연결 정보를 클라이언트 쪽에 저장, session:연결정보를 서버 쪽에 저장
		//escape() 함수: *, -, _, +, ., / 를 제외한 모든 문자를 16진수로 변환하는 함수
		//쉼표, 세미콜론 등과 같은 문자가 쿠키에서 사용되는 문자열과 충돌을 방지하기 위해 사용
		let chk = document.getElementById("chk");
		chk.addEventListener("click", function(){
			let now = new Date(); //오늘 날짜
			let name = "cookieId"; //쿠키 이름
			let value = form.id.value; //쿠키 값			
			
			if(form.chk.checked == true ) {  //체크박스를 체크했을 때 ->쿠키 생성, 쿠키만료시간 설정//자바스크립트는 그 자체적으로 값을 참거짓 구별가능하나 명시적으로 하기 위해 이렇게 써준것
				// 만료시간: 지금으로부터 7일 후로 설정, 만료 시간으로 사용
				now.setDate(now.getDate() + 7);
			}else{ //체크박스를 해제 했을 때 -> 쿠키 삭제
				//만료시간: 지금 시간으로 설정
				now.setDate(now.getDate() + 0);
			}
			//쿠키 생성시 필요한 정보 - 쿠키의 이름과 값, 위치, 만료시간   ;path=/가 현재 위치임
			document.cookie = name + "=" + escape(value) + ";path=/;expires=" + now.toGMTString() + ";";      //돔 객체로 쿠키만드는 법 

		})
	})
</script>
</head>
<body>
<div id="container">
	<jsp:include page="../common/shopTop.jsp"></jsp:include>
	<div class="t_title">LOGIN</div>
	<form action="memberLoginPro.jsp" method="post" name="loginForm" >
		<div class="f_input">
			<div class="f_id"><input type="text" id="id" name="id" class="c_id" placeholder="아이디" size ="55"></div>
			<div class="f_pwd"><input type ="password" id="pwd" name="pwd" class="c_pwd" placeholder="비밀번호" size ="55"></div>
			<div class="f_chk">
				<input type="checkbox" id="chk" class="c_chk" size="55">&nbsp;
				<label for="chk">아이디 저장</label>
			</div>
			<div class="f_submit"><input type="button" value="로그인" id="btn_login"></div>
		</div>
		<div class="f_a">
			<a href="#">비밀번호 찾기</a>&emsp;|&emsp;
			<a href="#">아이디 찾기</a>&emsp;|&emsp;
			<a href="../member.memberJoinForm.jsp">회원가입</a>	
		</div>
	</form>
	<hr class="t_line">
	<jsp:include page="../common/shopBottom.jsp"></jsp:include>
</div>
</body>
</html>