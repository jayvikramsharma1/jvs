<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Brightcove</title>

<!-- Bootstrap Core CSS -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<style>
.hero-spacer {
	margin-top: 50px;
}

.hero-feature {
	margin-bottom: 30px;
}
.navbar-brand {
    color: #ffffff !important;
}

.drager-place-flight-time {
	cursor: move;
	margin: 10px;
	background-color: rgb(250, 250, 250);
}

.drager-place-embargoed {
	cursor: move;
	margin: 10px;
	background-color: rgb(255, 170, 170);
}

.drager-place-flight-time:hover {
	background-color: rgb(220, 220, 220);
}

.drager-place-embargoed:hover {
	background-color: rgb(255, 150, 150);
}

.paidOnly {
	float: right;
	padding: 0.5rem;
	background: red;
	color: white;
	font-weight: bold;
}
</style>

<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-navbar-collapseable">
					<span class="sr-only">...</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<b class="navbar-brand">Brightcove Search</b>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-navbar-collapseable">
				<div class="navbar-form navbar-left" style="border:0px !important;">
							<div class="checkbox"
								style="color: white; white-space: nowrap !important; float: left; padding:10px;">
								<label> <input type="checkbox" name="flight_time_flag"
									id="flight_time_flag" onchange="getVideos();">
								</label> Include out of flight</label>
							</div>
						</div>
						<div class="navbar-form navbar-left" style="border:0px !important;">
						<div class="input-group"
							style="white-space: nowrap !important; float: left; padding:10px;">
							<select class="form-control" name="brightcove_order_by"
								id="brightcove_order_by">
								<option value="updated_at">Updated Date</option>
								<option value="published_at">Published Date</option>
								<option value="created_at">Created Date</option>
								<option value="schedule_starts_at">Schedule Start Date</option>
								<option value="schedule_ends_at">Schedule End Date</option>
								<option value="name">Name</option>
							</select>
							<div class="input-group-btn">
								<button type="button" class="btn btn-primary" id="sort-desc">
									<i class="fa fa-arrow-down"></i>
								</button>
								<button type="button" class="btn btn-default" id="sort-asc">
									<i class="fa fa-arrow-up"></i>
								</button>
							</div>
						</div>
						</div>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="input-group">
			<input type="text" class="form-control" placeholder="Search"
				name="search-brightcove-videos" id="search-brightcove-videos"
				onkeyup="submitSearchOnEnter(event)">
			<div class="input-group-btn">
				<button class="btn btn-primary btn-md" type="submit"
					onclick="getVideos();" id="search-brightcove-videos-btn">
					&nbsp;<i class="fa fa-search"></i>
				</button>
			</div>
		</div>

		<hr>
		<!-- Page Features -->
		<div class="row text-center" id="video-content">
			<!-- vidoes to be appended here -->
			<!-- /.row -->

		</div>
		<!-- /.container -->

		<!-- jQuery -->
		<!-- <script src="js/jquery.js"></script> -->
		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<!-- <script src="js/bootstrap.min.js"></script> -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>



		<script>
    var sortOrder = "-updated_at";
	var oldIEBrowser = "false";
	var oldSearchQueryText = "";
	var blankSearchQuery = false;
	(function ($) {
	    "use strict";

	    if ($('html').is('.lt-ie7, .lt-ie8, .lt-ie9')) {
	    	oldIEBrowser = "true";
	    }
	}(jQuery));
	
	$('#sort-desc').click(function() {
    	sortOrder = "-" + $("#brightcove_order_by").val();
    	$('#sort-desc').attr('class', 'btn btn-primary');
    	$('#sort-asc').attr('class', 'btn btn-default');
    	getVideos();
    }); 
    $('#sort-asc').click(function() {
    	sortOrder = $("#brightcove_order_by").val();
    	$('#sort-asc').attr('class', 'btn btn-primary');
    	$('#sort-desc').attr('class', 'btn btn-default');
    	getVideos();
    });
	
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
				content += '<div class="col-md-3 col-sm-6 hero-feature drager-place-flight-time">';
				content += '<a style="text-decoration:none;text-overflow: ellipsis;" onclick="return false" id="'+ result.embargoedFlag +'" draggable="true" ondragstart="methode_draghandler(event);" ';
				content += 'href = "http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/?brightCoveId='+result.id+'&videoName='+result.name+'&imageSrc='+result.imageSrc+'&description='+result.description+'&duration='+result.duration+'&paidOnly='+result.paidOnly+'&competitionId='+result.competitionId+'&embargoedFlag=false&flightTimeString='+encodeURIComponent(flightTimeStringFormate)+'&eomFileName='+result.emoFileName+'.video.xml&eomImport=http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/brightcove/methode-import&eomType=VideoStory" >';
			}
			else {
				content += '<div class="col-md-3 col-sm-6 hero-feature drager-place-embargoed">';
				content += '<a style="text-decoration:none;text-overflow: ellipsis;" onclick="return false" id="'+ result.embargoedFlag +'" draggable="true" ondragstart="methode_draghandler(event);" ';
				content += 'href = "http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/?brightCoveId='+result.id+'&videoName='+result.name+'&imageSrc='+result.imageSrc+'&description='+result.description+'&duration='+result.duration+'&paidOnly='+result.paidOnly+'&competitionId='+result.competitionId+'&embargoedFlag=true&flightTimeString='+encodeURIComponent(flightTimeStringFormate)+'&eomFileName='+result.emoFileName+'.video.xml&eomImport=http://<%=request.getServerName()%>:${initParam["eom_import_server_port"]}/brightcove/methode-import&eomType=VideoStory" >';
			}
			
			
			
			
            
            content += '<div class="thumbnail">';
            if(result.codec == "null" || result.codec == null || result.container == "null" || result.container == null || result.container != "MP4") {
				content += '<img style="height: 200px; width: 100%; display: block;" src="'+result.imageSrc+'" alt="Card image">';
	   		} else {
	         	content +='<video style="height: 200px; width: 100%; display: block;" controls=\"\" name=\"media\"><source src=\""+result[i].videoSrc+"\" type=\"video/mp4\"></video>';
	   		}
            content +=        '<div class="caption">';
            content +=			  '<p>'+flightTimeStringFormate+'</p>';
            if(result.paidOnly == "true") {
	      	 	content +="<p class=\"paidOnly\">Paid Users Only</p>";
	     	}
            content +=            '<h3 style="width:auto; display: block; overflow:hidden; text-overflow: ellipsis;">'+result.name+'</h3>';
            content +=            '<p>'+stringBeautify(result.description)+'</p>';
            content +=            '<p>';
            content +=                msToTime(result.duration);
            content +=            '</p>';
            content +=        '</div>';
            content +=    '</div>';
            
			content += '</a>';
			content +='</div>';
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
			$("#search-brightcove-videos-btn").prop('disabled', false);
			
	}

		
					function getVideos() {
						waitingDialog.show();
						$("#search-brightcove-videos-btn").prop('disabled',
								true);
						var filghtTimeFlag = "ON"
						if ($("#flight_time_flag").prop('checked') == true) {
							filghtTimeFlag = "OFF";
						}
						$('#video-content').empty();
						
						var brightcoveUrl = 'http://localhost:8080/BrightCoveImplemetation/brightcove/api?q='
								+ $("#search-brightcove-videos").val()
								+ '&videoSource=true'
								+ '&flightTimeFlag='
								+ filghtTimeFlag
								+ '&oldIEBrowserFlag='
								+ oldIEBrowser
								+ '&sort='+sortOrder
								+ '&exclusive=SundayTimesOnly';
						brightcoveUrl = encodeURI(brightcoveUrl);
						$.ajax({
							url : brightcoveUrl,
							method : 'GET',
							dataType : 'json',
							success : function(result) {
								renderVideo(result);
							}
						});
					}

					function stringBeautify(stringValue) {
						if (stringValue == "null" || stringValue == null
								|| stringValue == 'null')
							return "";
						else if (stringValue.length > 50) {
							return stringValue.substr(0, 50)
									+ '&nbsp;<button class="link" onClick="getFulltext(this, \''+ stringValue + '\')" style="border: none;padding: 0;background: none;color:blue;"> more...</button>';
						} else
							return stringValue;
					}
					function getFulltext(element, contentText) {
						var parentElement = element.parentElement.innerHTML = contentText
								+ '&nbsp;<button class="link" onClick="getLesstext(this, \''+ contentText + '\')\" style="border: none;padding: 0;background: none;color:blue;"> less...</button>';
					}
					function getLesstext(element, contentText) {
						var parentElement = element.parentElement.innerHTML = contentText
								.substr(0, 50)
								+ '&nbsp;<button class="link" onClick="getFulltext(this, \''+ contentText + '\')" style="border: none;padding: 0;background: none;color:blue;"> more...</button>';
					}
					function msToTime(duration) {
						var milliseconds = parseInt((duration % 1000) / 100), seconds = parseInt((duration / 1000) % 60), minutes = parseInt((duration / (1000 * 60)) % 60), hours = parseInt((duration / (1000 * 60 * 60)) % 24);

						hours = (hours < 10) ? "0" + hours : hours;
						minutes = (minutes < 10) ? "0" + minutes : minutes;
						seconds = (seconds < 10) ? "0" + seconds : seconds;

						return hours + ":" + minutes + ":" + seconds;
					}
					function submitSearchOnEnter(element) {
						$(window).on('keydown', function(event) {
											if (event.which == 13) {
												if ($("#search-brightcove-videos").val() != oldSearchQueryText
														&& $("#search-brightcove-videos").val() != "") {
													getVideos();
													oldSearchQueryText = $("#search-brightcove-videos").val();
													blankSearchQuery = true;
													return false;
												} else if ($("#search-brightcove-videos").val() == ""
														&& blankSearchQuery == true) {
													getVideos();
													blankSearchQuery = false;
													return false;
												}
											}
										});
					}
					function formateDateFromISOString(isoDate) {
						var date = new Date(isoDate);
						var formatOptions = {
							day : '2-digit',
							month : '2-digit',
							year : 'numeric',
							hour : '2-digit',
							minute : '2-digit',
							hour12 : true
						};
						var dateString = date.toLocaleDateString('en-GB',
								formatOptions);
						// => "02/17/2017, 11:32 PM"
						dateString = dateString.replace(',', '').replace('PM',
								'pm').replace('AM', 'am');
						// => "02/17/2017 11:32pm"
						return dateString;
					}
					methode_draghandler = function(event) {
						var href = event.target.getAttribute('href');
						event.dataTransfer.setData('Text', href);
					};
					$(document).ready(function() {
						getVideos();
					})
				</script>

		<script>
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
				</script>
</body>

</html>
