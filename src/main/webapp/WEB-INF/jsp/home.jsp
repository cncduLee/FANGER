<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>

 <div class="container">
        <div class="row">
            <div class="span3">
                <div class="nav-headers">
                    <h3>
                    	发现美食、分享美食、生活中多一点分享，多一点色彩！
                    </h3>
                    <p><a href="#" class="btn">查看 &rarr;</a></p>
                </div>
                <ul class="nav nav-tabs nav-stacked">
                    <li class="active"><a href="#"><i class="icon-picture"></i>最新</a></li>
                    <li><a href="#"><i class="icon-ok"></i>最受欢迎</a></li>
                    <li><a href="#"><i class="icon-bookmark"></i>评论最多</a></li>
                    <li><a href="#"><i class="icon-th-list"></i>分类</a></li>
                    <li><a href="#"><i class="icon-download"></i>下载排名</a></li>
                    <li><a href="#"><i class="icon-heart"></i>推荐</a></li>
                </ul>
            </div>
            
       
            
            <c:forEach items="${fangs }" var="item">
	            <div class="span3 galery">
	                <div class="menu-galery">
	                    <ul>
	                        <li><a href="<c:url value="/spotDetail?spotId=${item.id }"/>" rel="tooltip" title="查看详情"><i class="iconbig-search"></i></a></li>
	                        <li><a href="#" rel="tooltip" title="添加评论"><i class="iconbig-speak"></i></a></li>
	                        <li><a href="#" rel="tooltip" title="下载"><i class="iconbig-download"></i></a></li>
	                        <li><a href="#" rel="tooltip" title="喜欢"><i class="iconbig-black-star"></i></a></li>
	                    </ul>
	                </div>
	                <div class="image-galery"><a class="images3" href="<c:url value="${item.images.resId }"/>"><img src="<c:url value="${item.images.resId }"/>" /></a></div>
	                <div class="count-galery">
	                    <ul>
	                        <li><i class="icon-comment"></i> 5</li>
	                        <li><i class="icon-download-alt"></i> 7</li>
	                        <li><i class="icon-star"></i> 2</li>
	                        <li><i class="icon-eye-open"></i> 20</li>
	                    </ul>
	                </div>
	                <div class="tags-galery">
	                    <p><i class="icon-tags"></i> 标签 : <a href="#">建筑</a>, <a href="#">塔子</a>, 
	                     <a href="#">多彩世界</a>, <a href="#">神奇</a><a href="#">多彩世界</a>, <a href="#">神奇</a></p>
	                </div>
            	</div>
            </c:forEach>
            
        </div>
    </div>
    
    <!-- 分页控件 -->
    <!-- 分页控件 -->
    
    <div class="container">
        <div class="pagination">
        <ul>
          <li class="disabled"><a href="#" title="点击去到第一页">&laquo; 第一页</a></li>
          <li><a href="#" title="上一页">&larr;</a></li>
          <li class="active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">..</a></li>
          <li><a href="#">8</a></li>
          <li><a href="#">9</a></li>
          <li><a href="#" title="下一页">&rarr;</a></li>
          <li><a href="#" title="跳转到最后一页">最后一页 &raquo;</a></li>
        </ul>
      </div>
    </div>
<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    