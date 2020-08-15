<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8"%>

<%@ include file="include/importTags.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>

<div id="templatemo_content_right">

    <h1>${book.getTranslationTitleOfBook()} <span>(<spring:message code="By"/> ${book.getBookId().getAuthor().getName()} ${book.getBookId().getAuthor().getFirstName()}) (${book.getBookId().getTypeOfBook()})</span></h1>
    <div class="image_panel"><img src="../images/${book.getTranslationTitleOfBook()}.jpg" alt="CSS Template" width="100" height="150" /></div>
    <ul>
        <li><spring:message code="By"/> ${book.getBookId().getAuthor().getName()}</li>
        <li> ${book.getBookId().getPublicationDate().getDate()}/${book.getBookId().getPublicationDate().getMonth()+1}/${book.getBookId().getPublicationDate().getYear()+1900}</li>
        <li><spring:message code="pages"/>: ${book.getBookId().getNumberOfPages()}</li>
        <li>ISBN:  ${book.getBookId().getIsbn()}</li>
        <c:if test="${book.getBookId().getTypeOfBook().equals(\"Paper book\")}">
            <li><spring:message code="height"/>: ${book.getBookId().getHeight()} </li>
            <li><spring:message code="width"/>: ${book.getBookId().getWidth()}</li>
            <li><spring:message code="thickness"/>: ${book.getBookId().getThickness()}</li>
            <li><spring:message code="weight"/>: ${book.getBookId().getWeight()}</li>
        </c:if>
        <c:if test="${book.getBookId().getTypeOfBook().equals(\"E-book\")}" >
            <li><spring:message code="fileSize"/>: ${book.getBookId().getFileSize()}</li>
            <li><spring:message code="extension"/>: ${book.getBookId().getExtension()}</li>
        </c:if>
    </ul>

    <p>${book.getBookId().getSummary()}</p>


    <h3>${book.getBookId().getPrice()} € </h3>



    <form:form id="addToCartForm" method="POST" action="/DLivres/bookDetails/send" modelAttribute="addToCartForm">
        <form:input type="number" min="1" max="${book.getBookId().getStock()}" size="1" maxlength="2" path="numberOfBook" required = "true"/>
        <form:input type="hidden" path="isbn" value="${book.getBookId().getIsbn()}"/>

        <button id="buy_now_button">Buy Now</button>

    </form:form>

    <div class="cleaner_with_height">&nbsp;</div>



</div>

</body>
</html>