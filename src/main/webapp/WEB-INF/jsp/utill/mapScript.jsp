<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link href="<c:url value="/resources/css/css/main.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2.js"/>"></script>
<script src="http://maps.googleapis.com/maps/api/js?sensor=false" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value="/resources/js/aa/gmap3.js"/>"></script>    

<script type="text/javascript">
var mapMenuOpen = true;

var shadow = new google.maps.MarkerImage(
  '<c:url value="/resources/css/css/images/marker-images/shadow.png"/>',
  new google.maps.Size(87,50),
  new google.maps.Point(0,0),
  new google.maps.Point(30,50)
);

function mapMenuClose() {
  if (!mapMenuOpen) {
  $('#haritaPopUp').css('display', 'none');
    mapMenuOpen = true;	
  }
}


$(function () {
  // map initialisation
  $('#anaharita').gmap3({
    map:{
      options: {
        center: [31.93396, 101.853928],
        zoom: 3,
        panControl: true,
        overviewMapControl: true,
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: false,
        zoomControl: true,
        maxZoom: 18,
        minZoom: 1
      }
    }
  });

  $.ajax({
    	type: "GET",
        url: "<c:url value="/spotsMap"/>",
        data: "{}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) { 
        	initMap(data.resultData);
        },
        error: function (msg) {
            alert(msg);
        },
    	beforeSend: function(){
    		// Handle the beforeSend event
    	},
    	complete: function(){
    		// Handle the complete event
    	}
  });
  
  
 

  $("#haritaPopUp").mouseover(function() {
    mapMenuOpen = true;
    $("#haritaPopUp").css('display', 'block');
  });
  
  $("#haritaPopUp").mouseout(function() {
    $('#haritaPopUp').css('display', 'none');
  });
  
  function initMap(data){
	  $('#anaharita').gmap3({
		    marker:{
		      values: handleData(data), // from js/data.js
		      // single marker options
		      options: {
		        draggable: true,
		        shadow: shadow
		      },
		      // single marker events
		      events: {
		        mouseover: function (marker, event, context) {
		          mapMenuOpen = true;
		          var map = $(this).gmap3('get');
		          var scale = Math.pow(2, map.getZoom());
		          var nw = new google.maps.LatLng(
		          map.getBounds().getNorthEast().lat(), map.getBounds().getSouthWest().lng());
		          var worldCoordinateNW = map.getProjection().fromLatLngToPoint(nw);
		          var worldCoordinate = map.getProjection().fromLatLngToPoint(marker.getPosition());
		          var pixelOffset = new google.maps.Point(Math.floor((worldCoordinate.x - worldCoordinateNW.x) * scale), Math.floor((worldCoordinate.y - worldCoordinateNW.y) * scale));
		          var mapposition = $("#anaharita").position();
		          
		          if (context.data.type != "merkez") {
		            var icerik = "<div class='left'><div class='magazaadi' id='magazaadi'> " + 
		            context.data.category + "</div><div class='magazaadres' id='magazaadres'> " + 
		            context.data.name + "</div><div class='magazabilgi' id='magazabilgi'>" + 
		            context.data.summary + "</div></div><div class='right'><div class='urunlogo' onClick='CreatePresentation("+
		            context.data.place+",1,2);'><img id='magazabrosur' src='"+
		            context.data.imageUrl+"' width='108' height='141'></div></div>";
		            
		            $(".accordion").html(icerik);
		            
		            magazalogopath = "logo/";
		            magazabrosurpath = "";
		            
		            $("#haritaPopUp").css('display', 'block');
		            $("#haritaPopUp").css('left', (pixelOffset.x + mapposition.left + 15 + 'px'));
		            $("#haritaPopUp").css('top', (pixelOffset.y + mapposition.top - 62 + 'px'));
		            
		          }
		        },
		        mouseout: function () {
		          mapMenuOpen = false;
		          var t = setTimeout("mapMenuClose()", 500)
		        }
		      }
		    }
		  });
  }
  
  function handleData(data){
  	var resultList =  [];
      $.each(data, function(i, item) {
        var marka = new google.maps.MarkerImage(
              item.data.imageUrl,
              new google.maps.Size(40,40),
              new google.maps.Point(0,0),
              new google.maps.Point(30,50)
            );
        item.options={icon:marka};
        resultList.push(item);
      });
      return resultList;
  }
  
}); // end of $(function(){
  
  
    </script>
  </head>
<body>    
 <div id="haritaPopUp">
      <div class="arrow"></div>
      <div class="haritaWrapper">
        <div class="top"></div>
        <div class="content">
          <div class="container">
            <div class="accordion"></div>
          </div>
        </div>
      </div>
    </div>

    <div id="haritaMain">
      <div id="haritaSehir">乐享*生活</div>
      <div id="anaharita" class="anaharita"> </div>
    </div>
</body>
</html>