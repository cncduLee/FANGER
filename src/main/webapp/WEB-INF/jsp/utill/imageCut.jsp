<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 图片上传组件 -->
<div id="image-cut-modal" class="modal hide" >
    <div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>上传头像</h3>
	</div>
	<div class="modal-body upload">
		<div class="tabbable">
			
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
</div>

<!-- 剪切组件  -->
<div id="image-preview-modal" class="modal hide" >
    <div class="modal-header">
		<a class="close" data-dismiss="modal">×</a>
		<h3>头像截图</h3>
	</div>
	<div class="modal-body">
			<!-- 源文件 -->
    		<img src="<c:url value="/resources/img/gravatar.jpg"/>" id="avatar_target" alt="avatar" />
			<!-- 切图预览 -->	
			<div id="preview-pane">
				<div class="preview-container">
					<img src="<c:url value="/resources/img/gravatar.jpg"/>" id="avatar_preview" class="jcrop-preview" alt="Preview" />
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
		    	$('#avatar_target').attr('src', response);
		    	$('#avatar_preview').attr('src', response);
		    	
		    	//设置其他参数
				//==================================================//	  
				//==================切图=============================//	  
				//==================================================//	  
			    	 // Create variables (in this scope) to hold the API and image size
				    var jcrop_api,
				        boundx,
				        boundy,
				
				        // Grab some information about the preview pane
				        $preview = $('#preview-pane'),
				        $pcnt = $('#preview-pane .preview-container'),
				        $pimg = $('#preview-pane .preview-container img'),
				
				        xsize = $pcnt.width(),
				        ysize = $pcnt.height();
				    
				    console.log('init',[xsize,ysize]);
				
				function updatePreview(c)
			    {
			      if (parseInt(c.w) > 0)
			      {
			        var rx = xsize / c.w;
			        var ry = ysize / c.h;

			        $pimg.css({
			          width: Math.round(rx * boundx) + 'px',
			          height: Math.round(ry * boundy) + 'px',
			          marginLeft: '-' + Math.round(rx * c.x) + 'px',
			          marginTop: '-' + Math.round(ry * c.y) + 'px'
			        });
			      }
			    };
				
		    	//==================================================//	    	
		    	 $('#avatar_target').Jcrop({
			      onChange: updatePreview,
			      onSelect: updatePreview,
			      aspectRatio: xsize / ysize
			    },function(){
			      // Use the API to get the real image size
			      var bounds = this.getBounds();
			      boundx = bounds[0];
			      boundy = bounds[1];
			      // Store the API in the jcrop_api variable
			      jcrop_api = this;
			
			      // Move the preview into the jcrop container for css positioning
			      $preview.appendTo(jcrop_api.ui.holder);
			    });
		    	//==================================================//
		    	
		    	
		    	$('#image-cut-modal').modal('hide');//隐藏上传组件的modal
		    	$('#image-preview-modal').modal('show');
		    },
		    onError: function (event, queueID ,fileObj, errorObj) {
		    	alert("上传失败！");
            }
		});
		
	});
</script>