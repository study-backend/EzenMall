 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="manager.product.*, java.util.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정 처리</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");


//폼의 입력 정보 획득
//일반 폼이 아닌 파일 업로드 폼은 리퀘스트로 작업 못한다-> cos.jar 라이브러리의 MultipartRequest 클래스를 사용(그래서 여기선 액션태그 못쓴것)
//new MultipartRequest()의 매개변수로 request, 업로드 폴더, 업로드 될 파일의 최대 크기, encType, 파일명 중복정책을 적어야함

String realFolder = "c:/images_ezenmall";
int maxSize = 1024 * 1024 * 5; //5MB로 최대크기 잡아준것
String encType = "utf-8";
String fileName = "";

MultipartRequest multi = null;
try {
	multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
	Enumeration<?> files = multi.getFileNames();
	while(files.hasMoreElements()){
		String name = (String)files.nextElement();
		fileName = multi.getFilesystemName(name); //원본의 이름이 아니라 업로드된 이름을 찾아와야함
		//업로드 된것은 fileName 여기 있는 것이라 이렇게 얻어오는것
	}

} catch(Exception e) {
	System.out.println("productUpdatePro.jsp 파일:" + e.getMessage());
	e.printStackTrace();
}
// pageNum을 획득
String pageNum = multi.getParameter("pageNum");

//폼에서 넘어오는 11개의 필드 값을 획득 - 제외는 reg_date(수정 불가)
int product_id = Integer.parseInt(multi.getParameter("product_id"));
String product_kind = multi.getParameter("product_kind");
String product_name = multi.getParameter("product_name");
int product_price =Integer.parseInt(multi.getParameter("product_price"));
int product_count = Integer.parseInt(multi.getParameter("product_count"));
String author = multi.getParameter("author");
String publishing_com = multi.getParameter("publishing_com");
String publishing_date = multi.getParameter("publishing_date");
//String product_image = multi.getParameter("product_image");//여기선 이름을 얻어낼 수 없다
String product_content = multi.getParameter("product_content");
int discount_rate = Integer.parseInt(multi.getParameter("discount_rate"));

//ProductDTO 객체를 생성하고 setter 메소드를 사용하여 값을 설정한다
ProductDTO product = new ProductDTO();
product.setProduct_id(product_id);
product.setProduct_kind(product_kind);
product.setProduct_name(product_name);
product.setProduct_price(product_price);
product.setProduct_count(product_count);
product.setAuthor(author);
product.setPublishing_com(publishing_com);
product.setPublishing_date(publishing_date);
product.setProduct_image(fileName); //업로드한 파일의 실제 이름
product.setProduct_content(product_content);
product.setDiscount_rate(discount_rate);


//System.out.println("product 객체: " + product);

//System.out.println("product 객체:" + product.toString());
//(원래 투스트링써야되는데 안써도 자동으로 호출)

//DB 연결, product 테이블에 상품 추가 처리
ProductDAO productDAO = ProductDAO.getInstance();
productDAO.updateProduct(product);
response.sendRedirect("productList.jsp?pageNum=" +pageNum); //같은 위치의 프로덕트리스트로 보내기만 하니 간단하게 response로 쓰기
%>

</body>
</html>