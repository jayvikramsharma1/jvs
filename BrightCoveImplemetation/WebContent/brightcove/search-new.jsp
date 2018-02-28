<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <!--[if IE]>
			<link href="css/bootstrap-ie9.css" rel="stylesheet">
			<script src="https://cdn.polyfill.io/v2/polyfill.min.js"></script>
		<![endif]-->
  <!--[if lt IE 9]>
		<link href="css/bootstrap-ie8.css" rel="stylesheet">
		<![endif]-->

<title>Insert title here</title>
<style>
body {margin:0;}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav li {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* .topnav li:not(:last-child):hover {
  background-color: #82b8e7dd;
  color: black;
} */

/* topnav .icon:hover {
  background-color: #aadd;
  color: black;
} */

.active {
  background-color: #4CAF50;
  color: white;
}

.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav li:first-child { 
  	width: -webkit-calc(100% - 50px);  
  	width:    -moz-calc(100% - 50px);
  	width:         calc(100% - 50px);}
  .topnav li:not(:first-child) {display: none;}
  .topnav li.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive li {
    float: none;
    display: block;
    text-align: left;
  }
  .topnav .input {
  	color:black
  }
}
.card {
    /* Add shadows to create the "card" effect */
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    max-width: 500px; !important
    margin: auto;
}

/* On mouse-over, add a deeper shadow */
.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

/* Add some padding inside the card container */
.card .container {
    padding: 2px 16px;
}
/* .card .card-title {
    text-decoration: none;
    font-size: 22px;
    color: black;
} */
.card .card-title {
    color: grey;
    font-size: 18px;
}

</style>
</head>
<body>
	<div class="topnav" id="myTopnav">
  <li href="#search-ui" class="active">
  	 <div class="input-group">
      <input type="text" class="form-control" placeholder="Search" name="search-brightcove-videos" id="search-brightcove-videos">
      <div class="input-group-btn">
        <button class="btn btn-primary btn-md" type="submit">&nbsp;<i class="fa fa-search"></i></button>
      </div>
    </div>
    
    <!-- <form class="form-inline my-2 my-lg-0">
                  <input class="form-control mr-sm-2" type="text" placeholder="Search">
                  <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                </form> -->
  </li>
  <li href="#flight-time-videos">
  	<!-- <label> &nbsp;<input class="checkbox-round" type="checkbox" name="flight_time_flag" id="flight_time_flag" checked="checked" onchange="getVideos();"><b class="white-color-text" > Include out of flight</b></label> -->
  	<div class="custom-control custom-checkbox">
  <input type="checkbox" class="custom-control-input" id="flight_time_flag" name="flight_time_flag">
  <label class="custom-control-label" for="flight_time_flag">Include out of flight</label>
</div>
  	
  	</li>
  <li href="#sorting-order">
  <fieldset>
    <legend>Sorting</legend>
  	<select class="form-control input-lg" name="brightcove_order_by" id="brightcove_order_by" onchange="getVideos();">
							<option value="updated_at">Updated Date</option>
							<option value="published_at">Published Date</option>
							<option value="created_at">Created Date</option>
							<option value="schedule_starts_at">Schedule Start Date</option>
							<option value="schedule_ends_at">Schedule End Date</option>
							<option value="name">Schedule End Date</option>
	</select>
	<select class="form-control input-sm" name="brightcove_order_by_order" id="brightcove_order_by_order" onchange="getVideos();">
							<option value="desc">DESC</option>
							<option value="asc">ASC</option>
	</select>
	</fieldset>
	
  </li>
		<li href="#select-title">
		<fieldset>
    		<legend>Select Title</legend>
			<select class="form-control">
				<option value="all-titles">All Titles</option>
				<option value="the-times">The Times</option>
				<option value="the-sunday-times">The Sunday Times</option>
			</select>
			</fieldset>
		</li>
		<li href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</li>
</div>

	<div style="padding-left: 16px; padding-bottom: 10px; padding-top: 10px;">
		<div class="row">
			<div class="col-lg-4">
				<div class="bs-component" id="video-content">
				</div>
			</div>
		</div>
	</div>

	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
	</script>
	
	<script>
	var oldIEBrowser = "false";
	(function ($) {
	    "use strict";

	    if ($('html').is('.lt-ie7, .lt-ie8, .lt-ie9')) {
	    	oldIEBrowser = "true";
	    }
	}(jQuery));
	
	
	
	
	
	
	var waitingDialog = waitingDialog || (function ($) {
	    'use strict';

		// Creating modal dialog's DOM
		var $dialog = $(
			'<div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="padding-top:15%; overflow-y:visible;">' +
			'<div class="modal-dialog modal-m">' +
			'<div class="modal-content">' +
				'<div class="modal-header"><h3 style="margin:0;"></h3></div>' +
				'<div class="modal-body">' +
					'<div class="progress progress-striped active" style="margin-bottom:0;"><div class="progress-bar" style="width: 100%"></div></div>' +
				'</div>' +
			'</div></div></div>');

		return {
			/**
			 * Opens our dialog
			 * @param message Custom message
			 * @param options Custom options:
			 * 				  options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
			 * 				  options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
			 */
			show: function (message, options) {
				// Assigning defaults
				if (typeof options === 'undefined') {
					options = {};
				}
				if (typeof message === 'undefined') {
					message = 'Loading';
				}
				var settings = $.extend({
					dialogSize: 'm',
					progressType: '',
					onHide: null // This callback runs after the dialog was hidden
				}, options);

				// Configuring dialog
				$dialog.find('.modal-dialog').attr('class', 'modal-dialog').addClass('modal-' + settings.dialogSize);
				$dialog.find('.progress-bar').attr('class', 'progress-bar');
				if (settings.progressType) {
					$dialog.find('.progress-bar').addClass('progress-bar-' + settings.progressType);
				}
				$dialog.find('h3').text(message);
				// Adding callbacks
				if (typeof settings.onHide === 'function') {
					$dialog.off('hidden.bs.modal').on('hidden.bs.modal', function (e) {
						settings.onHide.call($dialog);
					});
				}
				// Opening dialog
				$dialog.modal();
			},
			/**
			 * Closes dialog
			 */
			hide: function () {
				$dialog.modal('hide');
			}
		};

	})(jQuery);

	
	
	
	
	
		function generateDragableContent(result) {
			var content = "";
			var flightTimeStringFormate = "";
			if(result.schedules == "null" || result.schedules == null) {
	      	 	//content +="<p class=\"error\">Always Available</p>";
	      	}
	      	else if ((result.schedules.starts_at == "null" || result.schedules.starts_at == null) && (result.schedules.ends_at == "null" || result.schedules.ends_at == null)) {
	      		//content +="<p class=\"video-duration\">Always Available</p>";
	      	}
	      	else if((result.schedules.starts_at == "null" || result.schedules.starts_at == null) && (result.schedules.ends_at != "null" || result.schedules.ends_at != null)) {
	      		flightTimeStringFormate = "Available until "+ formateDateFromISOString(result.schedules.ends_at);
	      	}
	      	else if((result.schedules.starts_at != "null" || result.schedules.starts_at != null) && (result.schedules.ends_at == "null" || result.schedules.ends_at == null)) {
	      		flightTimeStringFormate = "Available from "+ formateDateFromISOString(result.schedules.starts_at);
	      	}
	      	else if((result.schedules.starts_at != "null" || result.schedules.starts_at != null) && (result.schedules.ends_at != "null" || result.schedules.ends_at != null)) {
	      		flightTimeStringFormate = "Available from "+ formateDateFromISOString(result.schedules.starts_at) +" <br/>until "+ formateDateFromISOString(result.schedules.ends_at);
	      	}
			if(result.embargoedFlag == false) {
				content += '<a style="text-decoration:none;" onclick="return false" id="'+ result.embargoedFlag +'" onmouseover="liover(this)" onmouseout="liout(this)" draggable="true" ondragstart="methode_draghandler(event);" ';
				content += 'href = "http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/?brightCoveId='+result.id+'&videoName='+result.name+'&imageSrc='+result.imageSrc+'&description='+result.description+'&duration='+result.duration+'&paidOnly='+result.paidOnly+'&embargoedFlag=false&flightTimeString='+encodeURIComponent(flightTimeStringFormate)+'&eomFileName='+result.emoFileName+'.video.xml&eomImport=http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/brightcove/methode-import&eomType=VideoStory" >';
			}
			else {
				content += '<a style="text-decoration:none;" onclick="return false" id="'+ result.embargoedFlag +'" onmouseover="liover(this)" onmouseout="liout(this)" draggable="true" ondragstart="methode_draghandler(event);" ';
				content += 'href = "http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/?brightCoveId='+result.id+'&videoName='+result.name+'&imageSrc='+result.imageSrc+'&description='+result.description+'&duration='+result.duration+'&paidOnly='+result.paidOnly+'&embargoedFlag=true&flightTimeString='+encodeURIComponent(flightTimeStringFormate)+'&eomFileName='+result.emoFileName+'.video.xml&eomImport=http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/brightcove/methode-import&eomType=VideoStory" >';
			}
			
				content += '<div class="card" style="max-width: 20rem;">';
				content += '<div class="card-header">'+result.id+'</div>';
				if(result.codec == "null" || result.codec == null || result.container == "null" || result.container == null || result.container != "MP4") {
					content += '<img style="height: 200px; width: 100%; display: block;" src="'+result.imageSrc+'" alt="Card image">';
		   		} else {
		         	content +='<video style="height: 200px; width: 100%; display: block;" controls=\"\" name=\"media\"><source src=\""+result[i].videoSrc+"\" type=\"video/mp4\"></video>';
		   		}
				/* content += '<div class="card-body">';
				
				content += '</div>'; */
				content += '<div class="card-body">';
				content += '<div class="card-text">';
				content += '<i class="card-link">'+flightTimeStringFormate+'</i>';
				content += '<i class="card-link">'+msToTime(result.duration)+'</i>';
				content += '</div>';
				content += '<h4 class="card-title">'+result.name+'</h4>';
				content += '<p class="card-text">'+stringBeautify(result.description)+'</p>';
				content += '</div>';
				content += '</div>';
			content += '</a>';
			return content;
		}
		function renderVideo(result) {
			if(result.length > 0) {
			var content = "";
			for(var i = 0 ; i < result.length; i++) {
				content += generateDragableContent(result[i]);
			}
			console.log(content);
				$('#video-content').html(content);
			}
			else {
				$('#video-content').html("<p class=\"no-result\">Sorry no result found...</p>");
			}
			waitingDialog.hide();
			
	}

		function getVideos() {
			waitingDialog.show();
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