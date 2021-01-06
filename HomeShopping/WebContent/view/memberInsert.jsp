<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%
	MemberDAO dao = new MemberDAO();
	int n = dao.maxMemberId();
%>

<h3>회원 가입</h3>
		<br>
		<form action="/HomeMemberInsertController.do" method="post">
			<label for="custno"> 회원번호(자동발생)</label> <input type="text" name="custno" value="<%=n%>"> <br>
			<label for="custname"> 회원성명 </label> <input type="text" name="custname"> <br>
			<label for="adress"> 회원주소 </label> <input type="text" name="address"> <br>
			<label for="joindate"> 가입일자 </label> <input type="date" name="joindate"> <br>
			<label for="grade"> 고객등급 </label> <input type="text" name="grade"> <br>
			<label for="city"> 도시코드 </label> <input type="text" name="city"> <br>
			<input type="submit" value="추가"> 
			<input type="reset" value="취소"> 
		</form>

<%@ include file="../footer.jsp" %>