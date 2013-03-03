<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        

<jsp:include page="../common/Header.jsp" flush="false"></jsp:include>

  <div class="container">
        <div class="row">
        
            <div class="span9">
                <div class="row">
                    <div class="span9 image-detail">
                        <div class="auto image-single">
                            <img src="img/4_b.jpg" class="centered" />
                        </div>
                    </div>
                    <div class="span9 image-description">
                        <h3>Description</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sed erat tristique sem rutrum laoreet facilisis ut tortor. 
                        Cras tristique ultricies est sit amet consequat. Quisque nibh nunc, consequat at molestie vel, fermentum sit amet felis. 
                        Donec id lectus ligula, non tempus ante. Aliquam ut turpis enim, eget rhoncus arcu. Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                        Morbi feugiat accumsan felis, in mattis sapien fringilla et. Nullam placerat viverra massa, eu vestibulum neque blandit in. 
                        Morbi ac diam ac elit interdum tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas laoreet, enim sit amet faucibus rhoncus, eros tortor.</p>
                    </div>
                    <div class="span9 image-comments">
                        <div class="comment">
                            <h3>3 Comments On This Image</h3>
                            <ul>
                                <li>
                                    <div class="avatar">
                                        <a href="#"><img src="img/gravatar.jpg" /></a>
                                        <span class="comment-name"><a href="#">John Doe</a></span>
                                        <span class="comment-date"><p>July 16th, 2012 at 4:49 pm</p></span>
                                    </div>
                                    <div class="comment-text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur convallis condimentum dignissim. 
                                        Curabitur sapien nisi, ultrices vitae iaculis quis, consectetur ac neque. Phasellus vitae lorem.</p>
                                    </div>
                                </li>
                                <li class="comment-blue">
                                    <div class="avatar">
                                        <a href="#"><img src="img/gravatar.jpg" /></a>
                                        <span class="comment-name"><a href="#">John Doe</a></span>
                                        <span class="comment-date"><p>July 16th, 2012 at 5:09 pm</p></span>
                                    </div>
                                    <div class="comment-text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur convallis condimentum dignissim. 
                                        Curabitur sapien nisi, ultrices vitae iaculis quis, consectetur ac neque. Phasellus vitae lorem.
                                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur convallis condimentum dignissim. 
                                        Curabitur sapien nisi, ultrices vitae iaculis quis, consectetur ac neque. Phasellus vitae lorem.</p>
                                    </div>
                                </li>
                                <li>
                                    <div class="avatar">
                                        <a href="#"><img src="img/gravatar.jpg" /></a>
                                        <span class="comment-name"><a href="#">John Doe</a></span>
                                        <span class="comment-date"><p>July 16th, 2012 at 5:49 pm</p></span>
                                    </div>
                                    <div class="comment-text">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur convallis condimentum dignissim. 
                                        Curabitur sapien nisi, ultrices vitae iaculis quis, consectetur ac neque. Phasellus vitae lorem.</p>
                                    </div>
                                </li>
                            </ul>
                         </div>
                        
                        <br class="clearfix" />
                        <h3>Post Comment</h3>
                        <div class="post-comment">
                            <form class="form-horizontal">
                                <textarea rows="5" class="input-xxlarge inp-btm" name="comments" style="resize: none;" placeholder="Enter your comment here.."></textarea><br />
                                <input type="email" name="email" class="input-xxlarge inp-btm" placeholder="Enter your email address" required/><br />
                                <input type="text" name="name" class="input-xxlarge inp-btm" placeholder="Enter your name" required /><br />
                                <input type="text" name="site" class="input-xxlarge inp-btm" placeholder="Enter your site" required /><br />
                                <input type="submit" name="submit" value="Submit" class="btn btn-primary" /> <input type="reset" name="reset" value="Reset" class="btn" />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="span3">
                <div class="row">
                    <div class="span3 sidebar-detail-menu">
                        <ul>
                            <li><a href="#" rel="tooltip" title="Share">Share</a></li>
                            <li><a href="#" rel="tooltip" title="Add Comment">Comment</a></li>
                            <li><a href="#" rel="tooltip" title="Download">Download</a></li>
                            <li><a href="#" rel="tooltip" title="Like">Like</a></li>
                        </ul>
                    </div>
                    <div class="span3 sidebar-detail-similiar">
                        <div class="similiar-image">
                            <h4>Similar Image</h4>
                            <a href="#"><img src="img/1_b.jpg" class="img-thumbs" /></a><a href="#"><img src="img/2_b.jpg" class="img-thumbs" /></a><a href="#"><img src="img/3_b.jpg" class="img-thumbs" /></a>
                            <a href="#"><img src="img/4_b.jpg" class="img-thumbs" /></a><a href="#"><img src="img/5_b.jpg" class="img-thumbs" /></a><a href="#"><img src="img/1_b.jpg" class="img-thumbs" /></a>
                        </div>    
                    </div>
                    <div class="span3 sidebar-detail-category">
                        <div class="category-image">
                            <div class="cat-tags">Tags : <a href="#">Building</a>, <a href="#">Tower</a>, <a href="#">Eifel</a>, <a href="#">Wonders of the world</a>, <a href="#">Miracle</a></div>
                            <div class="cat-category">Category : <a href="#">image</a>, <a href="#">building</a>, <a href="#">photography</a> </div>
                            <div class="cat-downloaded">Downloaded by : <a href="#">John Doe</a>, <a href="#">Lisa</a>, <a href="#">Andra</a>, <a href="#">Avriq</a>, <a href="#">Aji satria</a> </div>
                            <div class="cat-liked">Liked by : <a href="#">Lisa</a>, <a href="#">John Doe</a>, <a href="#">Avriq</a>, <a href="#">Aji satria</a> </div>
                            <div class="cat-shared">Shared by : <a href="#">Nichols</a>, <a href="#">John Doe</a>, <a href="#">Avriq</a>, <a href="#">Abraham</a>, <a href="#">Jordan</a>, <a href="#">James</a> </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>

<jsp:include page="../common/Tail.jsp" flush="false"></jsp:include>    