
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../include/importTags.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <link type="text/css" href="<spring:url value = '/css/DLivres.css' />" rel="stylesheet" >
</head>
<body>

<div id="templatemo_container">
    <div id="templatemo_menu">
        <ul>
            <li><a href="/DLivres/index" class="current"><spring:message code="index"/></a></li>
            <li><a href="/DLivres/inscription"><spring:message code="inscription"/></a></li>
            <li><a href="/DLivres/cart"><img src='<spring:url value="/images/cart.png"/>' alt="image" style="width:35px;height:35px;" /></a></li>
            <c:if test="${currentUser == null }">
                <form:form id="formSignIn" method="POST" action="/bookstore/index/LogIn" modelAttribute="connectionForm">
                    <li><form:label for="userName" path="userName"><spring:message code="userName"/></form:label>
                        <form:input id="userName" path="userName"></form:input></li>
                    <li><form:label for="password" path="password"><spring:message code="passwordTmp"/></form:label>
                        <form:input type="password" id="password" path="password"></form:input></li>
                    <li><form:button id="sf_submit"><spring:message code="loginTmp"/></form:button></li>
                </form:form>
            </c:if>


            <c:if test="${currentUser != null }">
                <li><a href= "/DLivres/index/logOut"><spring:message code="logout"/></a></li>
                <li>${currentUser.getEmail()}</li>
            </c:if>
            <li><spring:url var="localeFr" value=""><spring:param name="locale" value="fr" /></spring:url>
                <a href ="${localeFr}"><img src='<spring:url value="/images/drapeau-francais.png"/>' alt="image" style="width:30px;height:30px;" /></a>
                <spring:url var="localeEn" value=""><spring:param name="locale" value="en" /></spring:url>
                <a href ="${localeEn}"><img src='<spring:url value="/images/drapeau-anglais.png"/>'  alt="image" style="width:30px;height:30px;" /></a>
                <c:if test="${errorLogin != null}"><spring:message code="errorLogin"/></c:if>	</li>
        </ul>

    </div>
    <!-- end of menu -->
    <div id="templatemo_header">
        <div id="templatemo_special_offers">


        </div>



    </div> <!-- end of header -->

    <div id="templatemo_content">

        <div id="templatemo_content_left">
            <div class="templatemo_content_left_section">
                <h1>Categories</h1>
                <ul>
                    <c:forEach items="${categories}" var="category" varStatus="status">

                    <li><a href="/DLivres/category/${category.getCategory_id().getCategory_id()}">${category.getTranslationWordingOfCategory()}</a><li>

                    </c:forEach>
                </ul>
            </div>



        </div> <!-- end of content left -->

        <div id="templatemo_content_right">

            <tiles:insertAttribute name="main-content"/>

        </div>  <!--end of content right -->

        <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->

    <div id="templatemo_footer">

        <a href="/DLivres/index">Home</a><br />
        Copyright © 2020 <a href="/DLivres/index"><strong>DLivres</strong></a>
    </div>

</div> <!-- end of container -->

</body>
</html>