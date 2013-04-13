<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 外部通过参数传递得到图片的src -->

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
jQuery(function($){

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
    $('#target').Jcrop({
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

  });
</script>