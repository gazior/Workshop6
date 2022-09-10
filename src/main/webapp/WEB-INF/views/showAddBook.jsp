<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="col-9">
            <table class="table">
                <tr>
                    <th>ISBN</th>
                    <th>Tytuł</th>
                    <th>Autor</th>
                    <th>Wydawca</th>
                    <th>Typ</th>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <td><c:out value="${book.isbn}"/></td>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.publisher}"/></td>
                    <td><c:out value="${book.type}"/></td>
                    <td>
                        <div class="btn btn-info"><a href="/edit/${book.id}" class="text-black">Edytuj</a></div>
                    </td>
                    <td>
                        <div class="btn btn-danger"><a href="/delete/${book.id}" class="text-black">Usuń</a></div>
                    </td>

                </tr>

            </table>
        </div>
    </div>
</div>


</body>
</html>






