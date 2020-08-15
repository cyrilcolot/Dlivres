<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<div id="templatemo_content_right">
    <c:forEach items="${books}" var ="book">


        <div class="templatemo_product_box">
            <h1>${book.getTranslationTitleOfBook()}</h1>
            <img src="../images/${book.getTranslationTitleOfBook()}.jpg" alt="image" style="width:100px;height:140px;" />
            <div class="product_info">
                <p>${book.getBookId().getSummary().subSequence(0, 75)}...</p>
                <h3> ${book.getBookId().getPrice()} € </h3>
                <div class="detail_button"><a href="/DLivres/bookDetails/${book.getBookId().getIsbn()}">Detail</a></div>
            </div>
            <div class="cleaner">&nbsp;</div>
        </div>

        <div class="cleaner_with_width">&nbsp;</div>

    </c:forEach>
</div>
</body>
</html>
