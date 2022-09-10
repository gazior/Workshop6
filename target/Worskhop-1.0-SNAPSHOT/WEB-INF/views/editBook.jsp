<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mateusz
  Date: 10.09.2022
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/webjars/bootstrap/5.2.0/css/bootstrap.css"/>
</head>
<body>
<div class="container-">
    <div class="row">
        <div class="col-12"><br><br></div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-3">
            <div class="list-group">
                <a href="/" class="list-group-item list-group-item-action active" aria-current="true">Menu</a>
                <a href="/show" class="list-group-item list-group-item-action">Lista książek</a>
                <a href="/add" class="list-group-item list-group-item-action">Dodaj książke</a>
            </div>
        </div>
        <div class="col-3">
            <form:form method="post"
                       modelAttribute="book" action="/edit">
                <div class="mb-1">ISBN:</div>
                <div class="mb-3"><form:input path="isbn" value="${book.isbn}" cssClass="form-control"/></div>
                <div class="mb-1">Tytuł:</div>
                <div class="mb-3"><form:input path="title" value="${book.title}" cssClass="form-control"/></div>
                <div class="mb-1">Autor:</div>
                <div class="mb-3"><form:input path="author" value="${book.author}" cssClass="form-control"/></div>
                <div class="mb-1">Wydawca:</div>
                <div class="mb-3"><form:input path="publisher" value="${book.publisher}" cssClass="form-control"/></div>
                <div class="mb-1">Typ:</div>
                <div class="mb-3"><form:input path="type" value="${book.type}" cssClass="form-control"/></div>
                <form:hidden path="id" value="${book.id}"/>
                <div class="mb-3"><input type="submit" class="btn btn-primary btn-lg" value="Zapisz"></div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>


