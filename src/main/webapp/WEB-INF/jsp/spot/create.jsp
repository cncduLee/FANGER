<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        

<jsp:include page="../../common/Header.jsp" flush="false"></jsp:include>

 <div class="container">
       <div class="row mt-30" >
			<div class="span10 offset1 mt-80">
				<div class="hero-unit board">
					<h1>乐享*生活</h1>
					<p>从本地上传或引用网络图片进行分享</p>
					
					<div class="row-fluid">
						<div class="span5 row-fluid">
							<div class="span11 thumbnail row-fluid">
								<div class="span12 upload-img p-r row-fluid">
									<a id="upload-image-btn" class="p-a upload-btn"
									href="#upload-image-modal" data-toggle="modal" title="上传,引用图片"> + </a>
									<img width="244px" id="spot-image" class="" alt="" src="<c:url value="/resources/img/upload_bg_grey.gif"/>"/>
								</div>
							</div>
						</div>
						<div class="span7">
						
							<form:form id="create-spot-form" action="../spot/create" modelAttribute="spotVo" method="post">
							
								<input id="image-url-hid" name="imageUrl" type="hidden" required="required"/>
								<input id="place-id-hid" name="placeId" type="hidden" />
								
								<div class="row-fluid">
									<input class="span9" id="name" name="name" type="text" 
											placeholder="给这件事取个名称" autocomplete="off" required="required"/>
									<div class="span2 offset1"><form:errors path="name" cssClass="alert alert-error" /></div>
								</div>
								<div class="row-fluid mt-10">
									<div class="input-append">
										<input id="full-addr-input" name="fullAddr" type="text" class="span3"
												placeholder="故事发生地点" autocomplete="off" required="required"/>
										<span class="add-on">
											<a id="place-locate-btn" class="" 
													href="#place-locate-modal" data-toggle="modal" title="手动定位地址">
												<i class="icon-map-marker"></i></a>
											</span>
									</div>
									<div class="span2 offset1"><form:errors path="fullAddr" cssClass="alert alert-error"/></div>
								</div>
								<div class="row-fluid mt-10">
									<select id="category" class="span5" name="category" >
											<option>选择分类...</option>
											<option value="1">新闻</option>
											<option value="2">美食</option>
											<option value="3">美图</option>
											<option value="4">娱乐</option>
											<option value="5">购物</option>
									</select>
									<div class="span2 offset1"><form:errors path="category" cssClass="alert alert-error"/></div>
								</div>
								<div class="row-fluid mt-10">
									<textarea id="summary" class="span9" name="summary" placeholder="随便描述下..." autocomplete="off" required="required"></textarea>
									<div class="span2 offset1"><form:errors path="summary" cssClass="alert alert-error"/></div>
								</div>
								<div class="row-fluid mt-10">
									 <button type="submit" class="btn btn-primary btn-large">乐享每一天</button>
									 <a id="return-btn" class="btn btn-large ml-10" href="<c:url value="/" />">返回</a>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
    </div>
    
 <!-- 定位 -->
 
 <c:import url="../utill/upload.jsp"/>
 <c:import url="../utill/locate.jsp"/>
     
<script src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script> 


<script type="text/javascript">
	$(function(){
		//调整css
		function imageAdjust(){
			alert("----");
	    	$('#image-url-hid').val($(this).attr('src'));
			var top = ($('#spot-image').height()-$('#upload-image-btn').height())/2;
			var left = ($('#spot-image').width()-$('#upload-image-btn').width())/2;
			
			$('#upload-image-btn').css('top', top);
	    	$('#upload-image-btn').css('left', left);
    	}
		
		  $('#create-spot-form').ajaxForm({ 
		        dataType:  'json', 
		        beforeSubmit: function(formData, jqForm, options){
		        	
		        },
		        success:  function(data){
		        	if(!data || data.resultCode != 'SUCCESS' ) 
		        		return;
		        	//window.location.href = $('#return-btn').attr('href');
		        },
		        complete: function(jqXHR, textStatus){
	          		
	          	}
		    });
		
		function getLocateObj(){
			return {fullAddr : $('#full-addr-input').val(), 
				lngLat: $('#full-addr-input').data('lngLat'),
				placeId: $('#place-id-hid').val()};
		}
		function locateCallback(place){
			$('#place-id-hid').val(place.id);
			$('#full-addr-input').val(place.fullAddr);
			$('#full-addr-input').data('lngLat', place.lngLat);
		}
		
	});
</script>
<jsp:include page="../../common/Tail.jsp" flush="false"></jsp:include>    