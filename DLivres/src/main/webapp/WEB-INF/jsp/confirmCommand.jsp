<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>


<div>
    <h1><spring:message code="sendingAddress"/></h1>
    <h2>${currentUser.firstName} ${user.lastName}</h2>
    <h2>${currentUser.street}, ${currentUser.streetNumber}</h2>
    <h2>${currentUser.postalCode}, ${currentUser.city}</h2>
    <h2>${currentUser.country}</h2>
</div>

<c:forEach var ="book" items="${cart.hashmap}">
    <tr>
        <td class="articleBasket"><a href="/DLivres/book/${book.value.translationOfBook}">${book.value.book.translationOfBook}</a></td>
        <td class="articleBasket">${line.value.quantity}</td>
        <td class="articleBasket"><fmt:formatNumber type="currency" currencySymbol="&#8364" pattern="#,##0.00 ¤" value="${book.value.totalPrice}"/></td>
    </tr>
</c:forEach>

<p style="font-size: 200%;color: white;"><spring:message code="totalPrice"/> : <fmt:formatNumber type="currency" currencySymbol="&#8364" pattern="#,##0.00 ¤" value="${totalPrice}"/></p>
<div class="containerOrder" id="orderButton">
    <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post" target="_top" >
        <input type="hidden" name="business" value="cyrilcolot-facilitator@hotmail.com">
        <input type="hidden" name="cmd" value="_xclick">
        <input type="hidden" name="password" value="EC02tAZ4maLvClr6xJimrLEW6oAyhlcVlMQgpnl50bl7ZqI426Mtq9OOlXVPrk97ffCH1iG2uZAI_JgX">
        <input type="hidden" name="cert_id" value="ARIF4tW4o5oZiYGvhTKBLfDyavEevs-yZDfG4IQeMNJZr3E6aYjpXkrstw2I7WkpUQ_94EKrhDF1-bWG">
        <input type="hidden" name="item_name" value="order DLivres">
        <input type="hidden" name="amount" value="${totalPrice}">
        <input type="hidden" name="currency_code" value="EUR">
        <input type="hidden" name="return" value="http://localhost:8080/DLivres/orderCompleted" />
        <input type="hidden" name="cancel_return" value="http://localhost:8088/DLivres/cart"/>
        <input type="image" name="submit" border="0" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt="PayPal - The safer, easier way to pay online">
    </form>
</div>
</body>
</html>
