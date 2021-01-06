<%@page import="vo.MemberVO"%>
<%@page import="vo.MemberMoneyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../header.jsp" %>
<%@ include file="../footer.jsp" %>
<% 
	ArrayList<MemberMoneyVO> list = (ArrayList<MemberMoneyVO>)request.getAttribute("moneylist");
	
%>
	<h1>도서 전체 확인</h1>
	
	<table border = "1" align = "center" width = "800px">
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
<%
	if(list != null){
		for(MemberMoneyVO data : list){
%>
	<tr>
		<td><%= data.getCustno() %></td>
		<td><%= data.getCustname() %></td>
		<td><%= data.getGrade()%></td>
		<td><%= data.getPrice() %></td>
	</tr>

<%		
		}
	}
%>
	</table>