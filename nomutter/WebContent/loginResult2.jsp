<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model2.User2" %>
<%
//セッションスコープからユーザー情報を取得
//セッションスコープに保存したインスタンスの属性名をString型で指定する。なお、取得したインスタンスは元の型にキャストする必要あり
User2 loginUser = (User2) session.getAttribute("loginUser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン結果ページ</title>
</head>
<body>
<h1>Nomutter</h1>
<% if(loginUser != null) { %>
	<p><%= loginUser.getName() %>さん</p>
	<a href="/nomutter/Main2">つぶやき投稿・閲覧へ</a>
<% } else { %>
	<p>ログインに失敗しました</p>
	<a href="/nomutter/index2.jsp">Topへ</a>
<% } %>
</form>
<jsp:include page="/footer2.jsp"/>
</body>
</html>