<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="../footer.jsp" %>
<% 
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("memberlist");
	
%>
	<h1>도서 전체 확인</h1>
	
	<table border = "1" align = "center" width = "800px">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
<%
	if(list != null){
		for(MemberVO data : list){
%>
	<tr>
		<td><a href="/HomeMemberUpdateController.do?custno=<%= data.getCustno()%>"><%= data.getCustno()%></td>
		<td><%= data.getCustname() %></td>
		<td><%= data.getPhone() %></td>
		<td><%= data.getAddress() %></td>
		<td><%= data.getJoindate() %></td>
		<td><%= data.getGrade()%></td>
		<td><%= data.getCity()%></td>
	</tr>

<%		
		}
	}
%>
	</table>
