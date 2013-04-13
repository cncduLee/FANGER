<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>
<script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
 <div class="container">
        <div class="row">
           
           <c:forEach items="${users }" var="item">
	            <div class="span3 galery">
	               
					<div class="image-galery">
					<c:choose>
            		<c:when test="${empty item.avatar}">
	                	<a class="images3" href="<c:url value="/resources/img/gravatar.jpg"/>"><img src="<c:url value="/resources/img/gravatar.jpg"/>" /></a>
	                </c:when>
	                <c:otherwise>
	                	<a class="images3" href="${item.avatar.resId }"><img src="${item.avatar.resId }"/></a>
	                </c:otherwise>
	                </c:choose>
	                </div>
	                
	                <div class="count-galery">
	                    <ul>
	                    	<li><i class="icon-user"></i>
		                    	<a href="<c:url value="/account/profiles?accountId=${item.id }"/>">
		                    		${item.name } 
		                    	</a>
	                    	</li>
	                    	<li id="follow_div_${item.id}">			                    	
	                    		<a id="follow_btn_${item.id}" href="#" class="btn btn-info">加关注</a>
	                    	</li>
	                    </ul>
	                </div>
	                <script type="text/javascript">
	                	$(function(){
	                		$("#follow_btn_${item.id}").bind("click",function(){
		            		
		            			var url = "<c:url value="/account/follow?targetId=${item.id }"/>";
		            			var alertStr = "";
		            			var follow_div = $("#follow_div_${item.id}");
		            			
		            			 $.ajax({
		            			        type: "POST",
		            			        dataType: "json",
		            			        url: url,
		            			        success: function(data){
		            			        	if(!data || data.resultCode == 'SUCCESS' ){alertStr="<p class=\"alert-message success\">关注成功啦！</p>";}
		            				    	if(!data || data.resultCode == 'EXCEPTION' ){alertStr="<p class=\"alert-message warning\">程序异常，请重新尝试！</p>";}
		            				    	if(!data || data.resultCode == 'NO_AUTH' ){alertStr="<p class=\"alert-message error\">您还未登陆，点击 <a href='<c:url value='/signIn' />'>这里</a> 登陆！</p>";}
		            				    	if(!data || data.resultCode == 'FAILE' ){
		            				    		
		            				    		alertStr="<p class=\"alert-message warning\">对不起，您已经关注了该用户！</p>";
		            				    		
		            				    		follow_div.html('<button class=\"btn\">已关注</button>');
		            				    		
		            				    	}
		            				    },
		            				    complete: function(jqXHR, textStatus){

		            			            //follow_div.text('');//清空
		            			            follow_div.html('<button class=\"btn\">已关注</button>');
		            				    	
		            			            $('#alert_msg_content').html(alertStr);
		            			            $("#alert-msg-model").modal('show');
		            			            
		            				  	}
		            			    });
		            		});
	                	});
	                </script>
	                
	                <!-- 只显示最新的数据 -->
	                <div class="tags-galery">
	                    	<c:forEach var="sp" items="${item.spots }" begin="1" end="2" step="1">
		                    	<p>  
		                    		${sp.createdAt }在 
		                    		<i class="icon-map-marker"></i>
		                    		${sp.place.fullAddr }
		                    		发表一则
		                    		${sp.category }....
		                    		<a href="<c:url value="/spotDetail?spotId=${item.id }"/>"><i class="icon-play"></i>detail</a>
		                    	</p>
		                    </c:forEach>
	                </div>
	              
            	</div>
            </c:forEach>
            
        </div>
    </div>
    
    <!-- 分页控件 -->
    <!-- 分页控件 -->
    
    <div class="container">
        <div class="pagination">
        ${pagingScript } 
      </div>
    </div>

<!-- alert pop model -->
<div id="alert-msg-model" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <h3>信息提示</h3>
  </div>
  <div class="modal-body">
  	<div id="alert_msg_content" class="alert alert-block alert-error fade in"></div>
  </div>
  <div class="modal-footer">
    <a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">关闭</a>
  </div>
</div>

<!-- 导航信息栏 -->
<jsp:include page="./utill/navBar.jsp" flush="false"></jsp:include>
<!-- 返回顶部-->
<jsp:include page="./utill/backTop.jsp" flush="false"></jsp:include>

<!-- 版权信息 -->
<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>

<!-- 脚本文件 -->
<jsp:include page="../common/Script.jsp" flush="false"></jsp:include>