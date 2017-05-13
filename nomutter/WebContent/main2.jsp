<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model2.User2, model2.Mutter2, java.util.List" %>
<%
//セッションスコープに保存されたユーザー情報を取得
User2 loginUser = (User2) session.getAttribute("loginUser");
//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter2> mutterList = (List<Mutter2>) application.getAttribute("mutterList");
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メイン画面</title>
</head>
<body>
<div class="box1">
<h1>Nomutter</h1>
<a href="/nomutter/Logout2">ログアウト</a>
</div>
<p>
<%= loginUser.getName() %>さん、ログイン中
</p>
<p><a href="/nomutter/Main2"></a></p>
<form action="/nomutter/Main2" method="post">
<input type="text" name="text">
<input type="submit" value="投稿">
</form>
<% if(errorMsg != null) { %>
<p><%= errorMsg %></p>
<% } %>
<% for(Mutter2 mutter : mutterList) { %>
	<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
<% } %>
</form>
<jsp:include page="/footer2.jsp"/>
</body>
</html>