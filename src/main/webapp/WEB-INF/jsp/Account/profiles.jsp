<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../../common/Header.jsp" flush="true"></jsp:include>

 <div class="container">
        <div class="row">
            <div class="span3 left-sidebar">
                <div class="account-settings">
                    <img src="<c:url value="/resources/ img/gravatar.jpg"/>" />
                </div>
                <div class="account-detail">
                    <p><strong>创建时间 :</strong></p>
                    <p>${account.createAt }</p>
                    <p><strong>性别 : </strong></p>
                    <p>${account.gender }</p>
                    <p><strong>联系方式: </strong></p>
                    <p><a href="mailto:${account.email }">${account.email }</a></p>
                    <hr />
                </div>
            </div>
            
            
            <div class="span9 content-setting">
                <div class="content-settings">
                    <div class="tabbable"> <!-- Only required for left/right tabs -->
                      
                      <ul class="nav nav-tabs">
                        <li class="active"><a href="#profile" data-toggle="tab">他/她身边的故事</a></li>
                        <li><a href="#groupInfo" data-toggle="tab">他/她的圈子</a></li>
                      </ul>
                      
                      <div class="tab-content">
                        <div class="tab-pane active" id="profile"><!-- Profile -->
                          
				           <c:forEach items="${account.spots }" var="item">
					            <div class="span3 galery">
					            
									<div class="image-galery">
									<c:choose>
				            		<c:when test="${empty item.images}">
					                	<a class="images3" href="<c:url value="/resources/img/gravatar.jpg"/>"><img src="<c:url value="/resources/img/gravatar.jpg"/>" /></a>
					                </c:when>
					                <c:otherwise>
					                	<a class="images3" href="<c:url value="${item.images.resId }"/>"><img src="<c:url value="${item.images.resId }"/>" /></a>
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
					                    	
					                    </ul>
					                </div>
					                
					                <!-- 只显示最新的数据 -->
					                <div class="tags-galery">
						                    	<p>  
						                    		${item.createdAt }在 
						                    		<i class="icon-map-marker"></i>
						                    		${item.place.fullAddr }
						                    		发表一则
						                    		${item.category }....
						                    		<a href="<c:url value="/spotDetail?spotId=${item.id }"/>"><i class="icon-play"></i>detail</a>
						                    	</p>
					                </div>
					              
				            	</div>
				            </c:forEach>
                          </div>
                        
                        <div class="tab-pane" id="groupInfo"><!-- Password -->
                            <!-- 在此填入相关分享内容 -->
                          	
                          	<button type="button" class="btn btn-primary btn-large" data-toggle="collapse" data-target="#this_target_div">
								他/她关注的...
							</button>
							 <hr />
							 <!-- 他关注的 -->
							 <div id="this_target_div" class="collapse in">
			<c:forEach items="${targetUsers }" var="tt">
	            <div class="span3 galery">
	               
					<div class="image-galery">
					<c:choose>
            		<c:when test="${empty tt.avatar}">
	                	<a class="images3" href="<c:url value="/resources/img/gravatar.jpg"/>"><img src="<c:url value="/resources/img/gravatar.jpg"/>" /></a>
	                </c:when>
	                <c:otherwise>
	                	<a class="images3" href="<c:url value="${tt.avatar.resId }"/>"><img src="<c:url value="${tt.avatar.resId }"/>" /></a>
	                </c:otherwise>
	                </c:choose>
	                </div>
	                
	                <div class="count-galery">
	                    <ul>
	                    	<li><i class="icon-user"></i>
		                    	<a href="<c:url value="/account/profiles?accountId=${tt.id }"/>">
		                    		${tt.name } 
		                    	</a>
	                    	</li>
	                    </ul>
	                </div>
	                <!-- 只显示最新的数据 -->
	                <div class="tags-galery">
	                    	<c:forEach var="sptt" items="${tt.spots }" begin="1" end="2" step="1">
		                    	<p>  
		                    		${sptt.createdAt }在 
		                    		<i class="icon-map-marker"></i>
		                    		${sptt.place.fullAddr }
		                    		发表一则
		                    		${sptt.category }....
		                    		<a href="<c:url value="/spotDetail?spotId=${tt.id }"/>"><i class="icon-play"></i>detail</a>
		                    	</p>
		                    </c:forEach>
	                </div>
	              
            	</div>
            </c:forEach>
									 
							 </div>
                          	 <hr />
                          	<button type="button" class="btn btn-primary btn-large" data-toggle="collapse" data-target="#this_followed_div">
							  关注他/她的...
							</button>
							 <hr />
							 <!-- 关注他/她的 -->
							<div id="this_followed_div" class="collapse in">
								
								<c:forEach items="${followedUsers }" var="foll">
						            
						            <div class="span3 galery">   
										<div class="image-galery">
										<c:choose>
					            		<c:when test="${empty foll.avatar}">
						                	<a class="images3" href="<c:url value="/resources/img/gravatar.jpg"/>"><img src="<c:url value="/resources/img/gravatar.jpg"/>" /></a>
						                </c:when>
						                <c:otherwise>
						                	<a class="images3" href="<c:url value="${foll.avatar.resId }"/>"><img src="<c:url value="${foll.avatar.resId }"/>" /></a>
						                </c:otherwise>
						                </c:choose>
						                </div>
						                
						                <div class="count-galery">
						                    <ul>
						                    	<li><i class="icon-user"></i>
							                    	<a href="<c:url value="/account/profiles?accountId=${foll.id }"/>">
							                    		${foll.name } 
							                    	</a>
						                    	</li>
						                    	<li id="follow_div_${foll.id}">			                    	
						                    		<a id="follow_btn_${foll.id}" href="#" class="btn btn-info">加关注</a>
						                    	</li>
						                    </ul>
						                </div>
						                <script type="text/javascript">
						                	$(function(){
						                		$("#follow_btn_${foll.id}").bind("click",function(){
							            		
							            			var url = "<c:url value="/account/follow?targetId=${foll.id }"/>";
							            			var alertStr = "";
							            			var follow_div = $("#follow_div_${foll.id}");
							            			
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
											<c:forEach var="sp" items="${foll.spots }" begin="1" end="2" step="1">
							                    	<!-- 只显示最新的数据 -->
						                			<div class="tags-galery">
							                    	<p>  
							                    		${sp.createdAt }在 
							                    		<i class="icon-map-marker"></i>
							                    		${sp.place.fullAddr }
							                    		发表一则
							                    		${sp.category }....
							                    		<a href="<c:url value="/spotDetail?spotId=${item.id }"/>"><i class="icon-play"></i>detail</a>
							                    	</p>
							                    	</div>
							                    </c:forEach>
						              
					            	</div>
					            </c:forEach>
							</div>
                          	  
      	               </div>
                      </div>
                    </div> <!-- end tabbable -->
                </div>
            </div>
        </div>
    </div>
<jsp:include page="../../common/Script.jsp" flush="true"></jsp:include>    
<jsp:include page="../../common/Tail.jsp" flush="true"></jsp:include> 