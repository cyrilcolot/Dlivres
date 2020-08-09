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

    <h1>${book.getTranslationTitleOfBook()} <span>(<spring:message code="By"/> ${book.getBook_id().getAuthor().getName()}) (${book.getBook_id().getTypeOfBook()})</span></h1>
    <div class="image_panel"><img src="../images/${book.getTranslationTitleOfBook()}.jpg" alt="CSS Template" width="100" height="150" /></div>
    <ul>
        <li><spring:message code="By"/> ${book.getBook_id().getAuthor().getName()}</li>
        <li> ${book.getBook_id().getPublicationDate().getDate()}/${book.getBook_id().getPublicationDate().getMonth()+1}/${book.getBook_id().getPublicationDate().getYear()+1900}</li>
        <li><spring:message code="pages"/>: ${book.getBook_id().getNumberOfPages()}</li>
        <li>ISBN:  ${book.getBook_id().getIsbn()}</li>
        <c:if test="${book.getBook_id().getTypeOfBook().equals(\"Paper book\")}">
            <li><spring:message code="height"/>: ${book.getBook_id().getHeight()} </li>
            <li><spring:message code="width"/>: ${book.getBook_id().getWidth()}</li>
            <li><spring:message code="thickness"/>: ${book.getBook_id().getThickness()}</li>
            <li><spring:message code="weight"/>: ${book.getBook_id().getWeight()}</li>
        </c:if>
        <c:if test="${book.getBook_id().getTypeOfBook().equals(\"E-book\")}" >
            <li><spring:message code="fileSize"/>: ${book.getBook_id().getFileSize()}</li>
            <li><spring:message code="extension"/>: ${book.getBook_id().getExtension()}</li>
        </c:if>
    </ul>

    <p>${book.getBook_id().getSummary()}</p>


    <h3>${book.getBook_id().getPrice()} € </h3>



    <form:form id="addToCartForm" method="POST" action="/DLivres/bookDetails/send" modelAttribute="addToCartForm">
        <form:input type="number" min="1" max="${book.getBook_id().getStock()}" size="1" maxlength="2" path="numberOfBook" required = "true"/>
        <form:input type="hidden" path="isbn" value="${book.getBook_id().getIsbn()}"/>

        <button id="buy_now_button">Buy Now</button>

    </form:form>

    <div class="cleaner_with_height">&nbsp;</div>



</div>

</body>
</html>