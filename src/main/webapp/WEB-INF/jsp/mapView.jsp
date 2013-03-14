<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>

<jsp:include page="../common/sliderSearch.jsp" flush="false">
	<jsp:param value="map" name="viewType"/>
</jsp:include>

<div align="center">
	<jsp:include page="./utill/mapScript.jsp" flush="false"></jsp:include>
</div>

  <!-- Placed at the end of the document so the pages load faster -->
  <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    