<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html>
<!--[if lt IE 10]> <html class="lt-ie9"> <![endif]-->
<html>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
.thumbnail-img { width: 120px; height: 100px; }
.flex-video { position: relative; padding-top: 25px; padding-bottom: 67.5%; height: 0; margin-bottom: 16px; overflow: hidden; }
.video-duration { margin: 0; padding: 0; border: 0; font-size: 90%; background: transparent; }
.flex-video.widescreen { padding-bottom: 57.25%; } 
.flex-video video{ position: absolute; top: 0; left: 0; width: 100%; height: 100%; }
body { font-family: "Helvetica Neue",Helvetica,Arial,sans-serif; font-size: 14px; line-height: 1.42857143; color: #333; background-color: #323131; }
a {
	text-decoration: none !important; 
}
h1 { color:#ffffff; }
.link { background:none; border:none; color: #1443ff; }
.no-result{ color: #ff1446; }
.drager-place-flight-time{ cursor: move; margin:10px; background-color: rgb(44, 168, 255) }
.drager-place-embargoed{ cursor: move; margin:10px; background-color: rgb(254, 172, 68) }
.white-color-text {color:#ffffff; }
</style>
<meta charset="UTF-8">
<title>Brightcove</title>

</head>
<body>
	<div class="container">
			<div>
			<div class="col-lg-12">
				<h1 for="search-brightcove-videos">Search</h1>
			</div>
				<div class="col-lg-6">
				<div class="input-group">
				<input type="text" class="form-control" name="search-brightcove-videos" id="search-brightcove-videos" onkeyup="submitSearchOnEnter(event)" /> <span class="input-group-btn">
						<button class="btn btn-secondary" type="button"
							onclick="getVideos();">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span> 
				</div>
				<div> 
					<!-- File
					<label class="radio-inline"><input type="radio" name="flight_time_flag" value="ON" onchange="getVideos();" checked="checked" /> <b class="white-color-text" >Flight Time Enabled</b></label> 
					<label class="radio-inline"><input type="radio" name="flight_time_flag" value="OFF" onchange="getVideos();" /> <b class="white-color-text" >Flight Time Diabled</b></label> -->
					
					<div class="checkbox">
					  <label><input type="checkbox" name="flight_time_flag" id="flight_time_flag" checked="checked" onchange="getVideos();"><b class="white-color-text" >Include out of flight</b></label>
					</div>
				</div>
			</div>
			</div>
			<div class="col-sm-12 col-md-12">
			<div style="padding-top: 10px;">
				<div class = "row" id="video-content"> 

				</div>
			</div>
		</div>
	</div>

	<script>
	var oldIEBrowser = "false";
	(function ($) {
	    "use strict";

	    if ($('html').is('.lt-ie7, .lt-ie8, .lt-ie9')) {
	    	oldIEBrowser = "true";
	    }

	    /* if (oldIE) {
	        // Here's your JS for IE..
	        alert("IE 9")
	    } else {
	    	alert("IE 10")
	        // ..And here's the full-fat code for everyone else
	    } */

	}(jQuery));
	
		function renderVideo(result) {
			if(result.length > 0) {
			var content = "";
			for(var i = 0 ; i < result.length; i++) {
				if(result[i].embargoedFlag == false)
					content +="<a class=\"col-sm-6 col-md-3 inline_block drager-place-flight-time thumbnail\" onclick=\"return false\" id=\""+ result[i].embargoedFlag +"\" onmouseover=\"liover(this)\" onmouseout=\"liout(this)\" draggable=\"true\" ondragstart=\"methode_draghandler(event);\" href=\"http://<%=request.getServerName()%>:${initParam['eom_import_server_port']}/?brightCoveId="+result[i].id+"&videoName="+result[i].name+"&imageSrc="+result[i].imageSrc+"&description="+result[i].description+"&duration="+result[i].duration+"&paidOnly="+result[i].paidOnly+"&eomFileName="+result[i].emoFileName+".video.xml&eomImport=http://<%=request.getServerName()%>:${initParam['eom_import_server_port']}/brightcove/methode-import&eomType=VideoStory\">";
				else
					content +="<a class=\"col-sm-6 col-md-3 inline_block drager-place-embargoed thumbnail\" onclick=\"return false\" id=\""+ result[i].embargoedFlag +"\" onmouseover=\"liover(this)\" onmouseout=\"liout(this)\" draggable=\"true\" ondragstart=\"methode_draghandler(event);\" href=\"http://<%=request.getServerName()%>:${initParam['eom_import_server_port']}/?brightCoveId="+result[i].id+"&videoName="+result[i].name+"&imageSrc="+result[i].imageSrc+"&description="+result[i].description+"&duration="+result[i].duration+"&paidOnly="+result[i].paidOnly+"&eomFileName="+result[i].emoFileName+".video.xml&eomImport=http://<%=request.getServerName()%>:${initParam['eom_import_server_port']}/brightcove/methode-import&eomType=VideoStory\">";
				   		
				   		if(result[i].codec == "null" || result[i].codec == null || result[i].container == "null" || result[i].container == null || result[i].container != "MP4") {
				   			content +="<img class=\"img-resposive\" name=\"media\" source src=\""+result[i].imageSrc+"\" />";
				   		} else {
				   		 content += "<div class=\"flex-video widescreen\">";
				         content +="<video controls=\"\" name=\"media\"><source src=\""+result[i].videoSrc+"\" type=\"video/mp4\"></video>";
				   		}
				         content +="</div>";
				      	 content +="<div class = \"caption\">";
				      	if(result[i].schedules == "null" || result[i].schedules == null) {
				      	 	//content +="<p class=\"error\">Always Available</p>";
				      	}
				      	else if ((result[i].schedules.starts_at == "null" || result[i].schedules.starts_at == null) && (result[i].schedules.ends_at == "null" || result[i].schedules.ends_at == null)) {
				      		//content +="<p class=\"video-duration\">Always Available</p>";
				      	}
				      	else if((result[i].schedules.starts_at == "null" || result[i].schedules.starts_at == null) && (result[i].schedules.ends_at != "null" || result[i].schedules.ends_at != null)) {
				      		content +="<p class=\"video-duration\"> - - ~ "+ formateDateFromISOString(result[i].schedules.ends_at) +"</p>";
				      	}
				      	else if((result[i].schedules.starts_at != "null" || result[i].schedules.starts_at != null) && (result[i].schedules.ends_at == "null" || result[i].schedules.ends_at == null)) {
				      		content +="<p class=\"video-duration\"> "+ formateDateFromISOString(result[i].schedules.starts_at) +" ~ - - </p>";
				      	}
				      	else if((result[i].schedules.starts_at != "null" || result[i].schedules.starts_at != null) && (result[i].schedules.ends_at != "null" || result[i].schedules.ends_at != null)) {
				      		content +="<p class=\"video-duration\"> "+ formateDateFromISOString(result[i].schedules.starts_at) +" ~ "+ formateDateFromISOString(result[i].schedules.ends_at) +" </p>";
				      	}
				      	 content +="<p class=\"video-duration\">"+msToTime(result[i].duration)+"</p>";
				         content +="<h4>"+result[i].name+"</h4>";
				         content +="<p>"+stringBeautify(result[i].description)+"</p>";
				      content +="</div>";
				   content +="</a>";
			}
			$('#video-content').html(content);
			}
			else {
				$('#video-content').html("<p class=\"no-result\">Sorry no result found...</p>");
			}
			
	}

		function getVideos() {
			//alert($('input[name=flight_time_flag]:checked').val())
			var filghtTimeFlag = "ON"
			if($("#flight_time_flag").prop('checked') == true) {
				filghtTimeFlag = "OFF";
			}
			var brightcoveUrl = 'http://localhost:8080/BrightCoveImplemetation/brightcove/api?q='+ $("#search-brightcove-videos").val()+"&videoSource=true"+"&flightTimeFlag="+filghtTimeFlag+"&oldIEBrowserFlag="+oldIEBrowser;

			$.ajax({
						url : brightcoveUrl,
						method : 'GET',
						dataType : 'json',
						success : function(result) {
							renderVideo(result);
						}
					});
		}
		function liover(element) {
			if(element.id == "false") {
				element.style.backgroundColor = "rgb(22, 124, 255)";
			}
			else {
				element.style.backgroundColor = "rgb(254, 90, 34)";
			}
		}
		function liout(element) {
			if(element.id == "false") {
				element.style.backgroundColor = "rgb(44, 168, 255)";
			}
			else {
				element.style.backgroundColor = "rgb(254, 172, 68)";
			}
		}
		function stringBeautify(stringValue) {
			if(stringValue == "null" || stringValue == null || stringValue == 'null')
				return "";
			else if(stringValue.length > 50) {
				return stringValue.substr(0, 50) + "<button class=\"link\" onClick=\"getFulltext(this, '"+stringValue+"')\"> more...</button>";
			}
			else
				return stringValue;
		}
		function getFulltext(element, contentText) {
			var parentElement = element.parentElement.innerHTML = contentText + "<button class=\"link\" onClick=\"getLesstext(this, '"+contentText+"')\"> less...</button>";
		}
		function getLesstext(element, contentText) {
			var parentElement = element.parentElement.innerHTML = contentText.substr(0, 50) + "<button class=\"link\" onClick=\"getFulltext(this, '"+ contentText +"')\"> more...</button>";
		}
		function msToTime(duration) {
	        var milliseconds = parseInt((duration%1000)/100)
	            , seconds = parseInt((duration/1000)%60)
	            , minutes = parseInt((duration/(1000*60))%60)
	            , hours = parseInt((duration/(1000*60*60))%24);

	        hours = (hours < 10) ? "0" + hours : hours;
	        minutes = (minutes < 10) ? "0" + minutes : minutes;
	        seconds = (seconds < 10) ? "0" + seconds : seconds;

	        return hours + ":" + minutes + ":" + seconds;
	    }
		function submitSearchOnEnter(element) {
			var keyPressed = event.which || event.keyCode;
			if(keyPressed == 13) {
				getVideos();
			}
		}
		function formateDateFromISOString(isoDate) {
			var date = new Date(isoDate);
			var formatOptions = { 
			       day:    '2-digit', 
			       month:  '2-digit', 
			       year:   'numeric',
			       hour:   '2-digit', 
			       minute: '2-digit',
			       hour12: true 
			};
			var dateString = date.toLocaleDateString('en-US', formatOptions);
			// => "02/17/2017, 11:32 PM"

			dateString = dateString.replace(',', '')
			                       .replace('PM', 'p.m.')
			                       .replace('AM', 'a.m.');
			// => "02/17/2017 11:32 p.m."

			console.log(dateString);
			return dateString;
		}
		methode_draghandler = function (event) {
		    var href = event.target.getAttribute('href');
		    event.dataTransfer.setData('Text', href);
		};
		$(document).ready(function() {
			getVideos();
		})
	</script>
</body>
</html>