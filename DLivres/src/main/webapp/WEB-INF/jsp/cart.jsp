<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<table id="cart">
    <tr>
        <td><spring:message code="bookName"/></td>
        <td><spring:message code="quantity"/></td>
        <td><spring:message code="unitPrice"/></td>

    </tr>
    <c:forEach items="${cart}" var="commandLine">
        <tr>

            <td><c:forEach items="${books}" var="book">
                <c:if test="${book.getBook_id().getIsbn() == commandLine.value.getBook().getIsbn()}">
                    <a href="/DLivres/bookDetails/${commandLine.value.getBook().getIsbn()}">${book.getTranslationTitleOfBook() }</a>
                </c:if>
            </c:forEach></td>
            <td>${commandLine.value.getQuantity()}</td>
            <td> ${commandLine.value.getBook().getPrice()} </td>

            <td><a href="/DLivres/cart/delete/${commandLine.value.getBook().getIsbn()}"><spring:message code="delete"/></a></td>

        </tr>
    </c:forEach>
</table>
<c:if test="${cart.isEmpty() == false}">
    <p><spring:message code="totalPrice"/> : ${totalPrice} €</p>
    <c:if test="${currentUser != null }">
        <a href="/DLivres/cart/confirm"><spring:message code="confirmCommand"/></a>
    </c:if>
</c:if>
</body>
</html>