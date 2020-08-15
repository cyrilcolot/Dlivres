<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign in</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script>
        $(document).ready(function() {
            $("#datepicker").datepicker({changeMonth: true, changeYear: true});
        });
    </script>
</head>
<body>
<form:form id="formInscription" method="POST" action="/DLivres/inscription/send" modelAttribute="inscriptionForm">
    <h1>Inscription</h1>
    <ul>
        <li><form:label for="userName" path="userName"><spring:message code="userName"/></form:label>
            <form:input path="userName" id="userName"></form:input></li>
        <li><form:label for="email" path="email"><spring:message code="email"/></form:label>
            <form:input id="email" path="email"></form:input><c:if test="${errorEmail != null}"><spring:message code="errorEmail"/></c:if></li>
        <li><c:if test="${userAlreadyExist != null}"><spring:message code="userAlreadyExist"/></c:if></li>
        <li><form:label for="name" path="name"><spring:message code="name"/></form:label>
            <form:input id="name" path="name"></form:input><p style="color:red;"><c:if test="${errorName != null}"><spring:message code="errorName"/></c:if></p></li>
        <li><form:label for="firstName" path="firstName"><spring:message code="firstName"/></form:label>
            <form:input id="firstName" path="firstName"></form:input><c:if test="${errorFirstName != null}"><spring:message code="errorFirstName"/></c:if></li>
        <li><form:label for="phoneNumber" path="phoneNumber"><spring:message code="phoneNumber"/></form:label>
            <form:input id="phoneNumber" path="phoneNumber"></form:input></li>

        <li><form:label for="birthDate" path="birthDate"><spring:message code="birthDate"/></form:label>
            <form:input id="datepicker" path="birthDate"></form:input><c:if test="${errorBirthDate != null}"><spring:message code="errorBirthDate"/></c:if></li>
        <li><form:label for="street" path="street"><spring:message code="street"/></form:label>
            <form:input id="street" path="street"></form:input><c:if test="${errorStreet != null}"><spring:message code="errorStreet"/></c:if></li>
        <li><form:label for="streetNumber" path="streetNumber"><spring:message code="streetNumber"/></form:label>
            <form:input id="streetNumber" path="streetNumber"></form:input><c:if test="${errorStreetNumber != null}"><spring:message code="errorStreetNumber"/></c:if></li>
        <li><form:label for="postalCode" path="postalCode"><spring:message code="postalCode"/></form:label>
            <form:input id="postalCode" path="postalCode"></form:input><c:if test="${errorPostalCode != null}"><spring:message code="errorPostalCode"/></c:if></li>
        <li><form:label for="city" path="city"><spring:message code="city"/></form:label>
            <form:input id="city" path="city"></form:input><c:if test="${errorCity != null}"><spring:message code="errorCity"/></c:if></li>
        <li><form:label for="country" path="country"><spring:message code="country"/></form:label>
            <form:input id="country" path="country"></form:input><c:if test="${errorCountry != null}"><spring:message code="errorCountry"/></c:if></li>
        <li><form:label for="password" path="password" ><spring:message code="password"/></form:label>
            <form:input type="password" id="password" path="password"></form:input><c:if test="${errorPassword != null}"><spring:message code="errorPassword"/></c:if></li>
        <li><form:label for="confirmPassword" path="confirmPassword"><spring:message code="confirmPassword"/></form:label>
            <form:input type="password" id="confirmPassword" path="confirmPassword"></form:input><c:if test="${errorConfirmPassword != null}"><spring:message code="errorConfirmPassword"/></c:if></li>


        <li><form:button>Send</form:button></li>
    </ul>
</form:form>
</body>
</html>