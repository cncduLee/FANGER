<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 图片上传组件 -->
<div id="image-cut-modal" class="modal hide" >
    <div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>上传头像</h3>
	</div>
	<div class="modal-body upload">
		
			
			<div class="row-fluid">
    					<div class="span10">
    						<div class="well">
    							<div id="image-file-queue"></div>
    						</div>
    					</div>
						<div class="span2 ta-r">
							<div id="image-file-input-wrapper">
								<input class="none" type="file" id="image-file-input" />
							</div>
						</div>
    		</div>
    		
			
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$('#image-file-input').uploadify({
		    uploader  	: '<c:url value="/resources/js/uploadify.swf" />',
		    script   	: '<c:url value="/avatar/image" />',
		    scriptData  : { 'session': '${pageContext.session.id}'},
		    cancelImg 	: '<c:url value="/resources/img/cancel.png" />',
		    folder 		: '<c:url value="/temp" />',
		    fileDataName : 'imageFile',
		    buttonText	: '浏览...',
		    fileDesc  	: "图片文件",
		    fileExt		: "*.jpg;*.png;*.jpeg;*.gif;*.bmp",
		    sizeLimit 	: 8000000,
		    queueID		: 'image-file-input',
		    multi     	: false,
		    simUploadLimit : 1,
		    auto		: true,
		    removeCompleted: true,
		    hideButton  : true,
		    wmode     	: 'transparent',
		    onSelectOnce : function(event,data) {
		       
		    },
		    onComplete: function(event, ID, fileObj, response, data) {
		    	
		    	$('#image-file-input').uploadifyClearQueue();
		    	
		    	//设置preview 的img src 
		    	//$('#avatar_target').attr('src', response);
		    	//$('#avatar_preview').attr('src', response);
		    	
		    	$('#account_avatar').attr('src', response);
		    	$('#account_avatar_img').attr('src', response);
		    	
		    	$('#avatar_id_hiden').val(response);
		    	
		    	
		    	$('#account_avatar_div_upload').hide();
		    	$('#account_avatar_div').show();
		    	
		    	$('#image-cut-modal').modal('hide');//隐藏上传组件的modal    	
		    	//$('#image-preview-modal').modal('show');//打开剪切的modal
		    },
		    onError: function (event, queueID ,fileObj, errorObj) {
		    	alert("上传失败！");
            }
		});
		$('#image-file-input-wrapper').mouseenter(function(){
			$('#image-file-inputUploader').css('background-position', '-60px 0px');
		});
		$('#image-file-input-wrapper').mouseleave(function(){
			$('#image-file-inputUploader').css('background-position', '0px 0px');
		});
	});
</script>