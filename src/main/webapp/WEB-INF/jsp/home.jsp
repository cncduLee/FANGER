<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>
<jsp:include page="../common/sliderSearch.jsp" flush="false">
	<jsp:param value="wf" name="viewType"/>
</jsp:include>

 <div class="container">
        <div class="row">
            <div class="span3">
                <div class="nav-headers">
                    <h3>
                    	乐分享，乐生活，在自己的世界里，快乐每一天。
                    </h3>
                </div>
                <ul class="nav nav-tabs nav-stacked">
                    <li id="type_last_new"><a href="<c:url value="/home?type=createdAt"/>"><i class="icon-picture"></i>最新</a></li>
                    <li id="type_mark_most"><a href="<c:url value="/home?type=markCount"/>"><i class="icon-ok"></i>标记最多</a></li>
                    <li id="type_comment_most"><a href="<c:url value="/home?type=commentsCount"/>"><i class="icon-bookmark"></i>评论最多</a></li>
                    <li id="type_like_most"><a href="<c:url value="/home?type=likeCount"/>"><i class="icon-th-list"></i>最受欢迎</a></li>
                    <li id="type_download_most"><a href="<c:url value="/home?type=downloadCount"/>"><i class="icon-download"></i>下载排名</a></li>
                    <li id="type_share_most"><a href="<c:url value="/home?type=shareCount"/>"><i class="icon-heart"></i>分享最多</a></li>
                </ul>
            </div>
    	            
            <c:forEach items="${fangs }" var="item">
	            <div class="span3 galery">
	                <div class="menu-galery">
	                    <ul>
	                        <li><a href="<c:url value="/spotDetail?spotId=${item.id }"/>" rel="tooltip" title="查看详情"><i class="iconbig-search"></i></a></li>
	                        <li><a href="#" id="commentModel${item.id}" rel="tooltip" title="添加评论" ><i class="iconbig-speak"></i></a></li>
	                        <li><a href="<c:url value="/spotDetail/download/${item.id }"/>" rel="tooltip" title="下载"><i class="iconbig-download"></i></a></li>
	                        <li><a href="#" id="share${item.id }"  rel="tooltip" title="分享"><i class="iconbig-black-star"></i></a></li>
	                    </ul>
	                </div>
	                <div class="image-galery"><a class="images3" href="<c:url value="${item.images.resId }"/>"><img src="<c:url value="${item.images.resId }"/>" /></a></div>
	                <div class="count-galery">
	                    <ul>
	                        <li id="item_commentsCount"><i class="icon-comment"></i> ${item.commentsCount } </li>
	                        <li><i class="icon-download-alt"></i> ${item.downloadCount } </li>
	                        <li><i class="icon-star"></i>${item.shareCount } </li>
	                    </ul>
	                </div>
	                <div class="tags-galery">
	                    <p><i class="icon-tags"></i> ${item.summary }</p>
	                </div>
            	</div>
            	<script type="text/javascript">
	            	$(function(){
	            		//评论
	            		$("#commentModel${item.id}").bind("click",function(){
		            		$("#comment_spotId").val( ${item.id} );
		                    $('#commentModel').modal('show');		                         
		            	});
	            		//分享
	            		$("#share${item.id }").bind("click",function(){
	            			var divshow = $("#item_shareCount");
	            			var sharecount = ${item.shareCount };
	            			
	            			var url = "<c:url value="/spotDetail/share/${item.id }"/>";
	            			var alertStr = "";
	            			
	            			 $.ajax({
	            			        type: "POST",
	            			        dataType: "json",
	            			        url: url,
	            			        success: function(data){
	            			        	if(!data || data.resultCode == 'SUCCESS' ){
	            			        		alertStr="<p class=\"alert-message success\">分享成功！</p>";
	            			        		//清空数据
	            			        		divshow.text("");
	            			        		//修改相关数值
	            			        		 divshow.append(sharecount++); 
	            			        	}
	            				    	if(!data || data.resultCode == 'EXCEPTION' ){alertStr="<p class=\"alert-message warning\">程序异常，请重新尝试！</p>";}
	            				    	if(!data || data.resultCode == 'NO_AUTH' ){alertStr="<p class=\"alert-message error\">您还未登陆，点击 <a href='<c:url value='/signIn' />'>这里</a> 登陆！</p>";}
	            					    	
	            				    },
	            				    complete: function(jqXHR, textStatus){
	            				    	
	            			            $('#alert_msg_content').html(alertStr);
	            			            $("#alert-msg-model").modal('show');
	            			            
	            				  	}
	            			    });
	            		});
	            		
	            	});
            	</script>
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

<!-- 评论 -->
<div id="commentModel" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">写评论</h3>
  	</div>
	
	<div class="modal-body">	  
	<form id="add-comment-form" class="form-horizontal"
		action="<c:url value="/addComment"/>" autocomplete="off" method="post">
		<input type="hidden" name="spotId" id="comment_spotId"/>
		<c:choose>
			<c:when test="${empty sessionScope.signInUser}">
				<hr class="alt" />
				<p>
					要评论，但不想填写这些信息。您可以点击<a href="<c:url value="/signIn"/>">这里登陆</a>系统，如果没有账号，那就去<a
						href="<c:url value="/signUp"/>">注册</a>吧！
				<hr class="alt" />
				<textarea rows="5" class="input-xxlarge inp-btm" name=content id="modal_comment_content"
					style="resize: none;" placeholder="写评论.." required></textarea>
				<br />
				<input type="email" name="email" class="input-xxlarge inp-btm"
					placeholder="你的邮箱..." required />
				<br />
				<input type="text" name="name" class="input-xxlarge inp-btm"
					placeholder="怎么称呼..." required />
				<br />
				<input type="text" name="siteAdd" class="input-xxlarge inp-btm"
					placeholder="你的站点..." />
				<br />

			</c:when>
			<c:otherwise>
				<textarea rows="5" class="input-xxlarge inp-btm" name="content" id="modal_comment_content"
					style="resize: none;" placeholder="写评论.." required></textarea>
				<br />
			</c:otherwise>
		</c:choose>
		
		<input type="submit" id="comment_submit"  value="提交" class="btn btn-primary"/>
		<input type="reset"  value="关闭" class="btn" data-dismiss="modal" aria-hidden="true"/>
	</form>
	</div>
</div>


<!-- 评论 -->
<div id="shareModel" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">去分享</h3>
  	</div>
	
	<div class="modal-body">	  
	<form id="add-share-form" class="form-horizontal"
		action="<c:url value="/addComment"/>" autocomplete="off" method="post">
		
		<input type="hidden" name="spotId" id="share_spotId"/>
		
		<textarea rows="4" class="input-xlarge inp-btm" name="descript"
					style="resize: none;" placeholder="写评论.." required></textarea>
		<br />
		
		<input type="submit" id="share_submit"  value="提交" class="btn btn-primary"/>
		<input type="reset"  value="关闭" class="btn" data-dismiss="modal" aria-hidden="true"/>
		
	</form>
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

<jsp:include page="../common/Script.jsp" flush="false"></jsp:include>
<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>
<script type="text/javascript">
$(function(){
	var alertStr = "";
	//var divshow = $("#item_comentsCount");
	//var commentscount = ${item.commentsCount };
	
	
	$('#add-comment-form').ajaxForm({ 
	    dataType:  'json', 
	    beforeSubmit: function(formData, jqForm, options){
            $('#commentModel').modal('hide');
	    },
	    success:  function(data){
	    	
	    	if(!data || data.resultCode == 'SUCCESS' ){
	    		alertStr="<p class=\"alert-message success\">评论成功！</p>";
	    		//清空数据
        		//divshow.text("");
        		//修改相关数值
        		 //divshow.append(commentscount++); 
	    	}
	    	if(!data || data.resultCode == 'EXCEPTION' ){alertStr="<p class=\"alert-message warning\">程序异常，请重新尝试！</p>";}
	    	if(!data || data.resultCode == 'NO_AUTH' ){alertStr="<p class=\"alert-message error\">认证失败，请重新尝试！</p>";}
		    	
	    },
	    complete: function(jqXHR, textStatus){
	    	$("#comment_spotId").val('');
	    	$("#modal_comment_content").val('');
	    	
	    	
            $('#alert_msg_content').html(alertStr);
            $("#alert-msg-model").modal('show');
	  	}
	});	
	
	
	//=======类型搜索=======//
	var typeVar = '${type}';
	if(typeVar == 'createdAt'){
		$("#type_last_new").addClass("active");
	}
	if(typeVar == 'commentsCount'){
		$("#type_comment_most").addClass("active");
	}
	if(typeVar == 'downloadCount'){
		$("#type_download_most").addClass("active");
	}
	if(typeVar == 'shareCount'){
		$("#type_share_most").addClass("active");
	}
	if(typeVar == 'likeCount'){
		$("#type_like_most").addClass("active");
	}
	if(typeVar == 'markCount'){
		$("#type_mark_most").addClass("active");
	}
});
</script>    