<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../footer.jsp" %>
<%
		MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null){
%>
			

		<h3>회원 정보 수정</h3>

		
		<form action="/HomeMemberUpdateController.do" method="post">
			<label for = "custno">회원번호</label>
			<input type="text" name="custno" value="<%=member.getCustno() %>" readonly="readonly">
			
			<label for = "custname">회원이름</label>
			<input type="text" name="custname" value="<%=member.getCustname() %>">
			
			<label for = "phone">회원전화</label>
			<input type="text" name="phone" value="<%=member.getPhone()  %>">
			
			<label for = "address">회원주소</label>
			<input type="text" name="mail" value="<%=member.getAddress() %>">
			
			<label for = "joindate">가입일자</label>
			<input type="text" name="joindate" value="<%=member.getJoindate() %>">
			
			<label for = "grade">고객등급</label>
			<input type="text" name="grade" value="<%=member.getGrade() %>">
			
			<label for = "city">도시코드/label>
			<input type="text" name="city" value="<%=member.getCity() %>">
			
			<input type="submit">
		</form>

<%
			
			
		}
%>