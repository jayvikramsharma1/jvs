<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>PS-1010</title>
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<style>
.container {
  width: 300px;
}
.selected-tgs-span {
  float: left;
  padding: 0.5rem;
  background: #e4e4e4;
  color: #3d3c3c;
  font-weight: bold;
  clear:both;
  width:75%;
  border : 1px solid #6a6a6a;
  margin: 1px;
  cursor: pointer;
}
.available-tgs-span {
  float: left;
  padding: 0.5rem;
  background: #fafafa;
  color: #3d3c3c;
  font-weight: bold;
  clear:both;
  width:80%;
  border : 1px solid #6a6a6a;
  margin: 1px;
  cursor: pointer;
}
.available-tgs {
	height: 400px;
	overflow: auto;
}
.available-tgs b {
	text-align: right;
	float: right;
}
.available-tgs b:after {
	content: '\002B';
}

.selected-tgs b {
	text-align: right;
	float: right;
}
.selected-tgs b:after {
	content: '\00D7';
}
fieldset {
	margin : 2px;
	padding : 2px;
	border: none;
}

  </style>
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<div id="container" class="container">
		<fieldset class="line">
			<legend><h4>Selected Tags</h4></legend>
		<div id="selected-tags" class="selected-tgs">
		</div>
		</fieldset>
		<fieldset class="line">
			<legend><h4>Available Tags</h4></legend>
		<div id="available-tags" class="available-tgs">
		</div>
		</fieldset>
	</div>

	<script>
	function initCustomTag(tagsData) {
		sortTagsByScore(tagsData, "score");
		var allTags = tagsData.tags;
		var selectedTags = allTags.slice(0, 5);
		var availableTags = new Array(allTags.length)
		var slicedAvailableArray = allTags.slice(5, allTags.length);
		for(i=0; i<slicedAvailableArray.length; i++) {
			availableTags[i] = slicedAvailableArray[i];
		}
		populateSelectedTags(selectedTags, availableTags);
		populateAvailableTags(selectedTags, availableTags);
	}
function sortTagsByScore(data, key) {
	data.tags.sort(function(a, b) { 
		return b.score - a.score;
	});
}

function sortTagsDataByScore(data, key) {
	data.sort(function(a, b) {
		if(a != null && b != null) 
			return b.score - a.score;
	});
}

function getTagsDataFromGoogle(storyText) {
	
	/* var storyText = {
			text: "ddfdfdfd",
			title: "ddd"
	} */
	/* $.post({
		url  : "http://localhost:8080/PS-1010-P/OrderdTagProvider",
		data : storyText,//JSON.parse(storyText),
		dataType: "json",
		processData: false,
	}).done(function (response) {
			//console.log(response);
			if(response != null && response.tags != null)
				initCustomTag(response);
		}); */
		
		response = {"metadata":{"timestamp":"2017-11-23T06:35:26.699657"},"tags":[{"score":0.573725556184914,"type":"OTHER","name":"bunch"},{"score":0.4252499192518246,"type":"WORK_OF_ART","name":"piece"},{"score":0.12928244726958535,"type":"WORK_OF_ART","name":"article"},{"score":0.08809356866297618,"type":"OTHER","name":"number"},{"score":0.043721177121814885,"type":"OTHER","name":"words"},{"score":0.03314143084305524,"type":"OTHER","name":"Methode"},{"score":0.015148155368224597,"type":"WORK_OF_ART","name":"text"}]};
		initCustomTag(response);
}

$(document).ready(function() {
	var storyText = "{\"text\":\"This is a bunch of text for the article. It could be written in Methode or wherever. I'm not too bothered. The piece of text that is written should have a decent number of words in the text (I'm not exactly sure what that should be) but I'll sort that out later\", \"title\":\"This is a title for my article\"}";
	getTagsDataFromGoogle(storyText);
	
});

	function populateAvailableTags(selectedTags, availableTags) {
		$("#available-tags").empty();
		for(i=0; i<availableTags.length; i++) {
			if(availableTags[i] != '' && availableTags[i] != null) {
				$("#available-tags").append('<span class=\"available-tgs-span\" onClick=\'return clickOnAvailableTags(this,'+  JSON.stringify(selectedTags)+', '+JSON.stringify(availableTags)+ ')\' data-score='+ availableTags[i].score +' data-type=\"'+ availableTags[i].type+'\" data-name=\"'+availableTags[i].name+'\" data-index='+i+'>' +availableTags[i].name+' <br/>' + availableTags[i].type + '<b></b></span>');
			}
		}
	}

	function populateSelectedTags(selectedTags, availableTags) {
		$("#selected-tags").empty();
		for(i=0; i<selectedTags.length; i++) {
			if(selectedTags[i] != '' && selectedTags[i] != null) {
				$("#selected-tags").append('<span class=\"selected-tgs-span\" onClick=\'return clickOnSelectedTags(this,'+JSON.stringify(selectedTags)+', '+JSON.stringify(availableTags)+')\' data-score='+ selectedTags[i].score +' data-type=\"'+selectedTags[i].type+'\" data-name=\"'+selectedTags[i].name+'\" data-index='+i+'>' +selectedTags[i].name+' <br/>' + selectedTags[i].type + '<b></b></span>');	
			}
		}
	}

	function clickOnSelectedTags(element, selectedTags, availableTags) {
			for(i=0; i<availableTags.length; i++) {
				if(availableTags[i] == "" || availableTags[i] == '' || availableTags[i] == null) {
					availableTags[i] = selectedTags[element.getAttribute('data-index')];
					break;
				}
			}
			for(i=0; i<selectedTags.length; i++) {
				//console.log(i + " " + element.getAttribute('data-index'));
				if(i == element.getAttribute('data-index')) {
					//console.log("elemment found at : " + i);
					selectedTags[i] = '';
				} else {
					selectedTags[i] = selectedTags[i];
				}
			}

			//console.log(availableTags)
			sortTagsDataByScore(availableTags, "score");
			sortTagsDataByScore(selectedTags, "score");
			//console.log(availableTags);
			//console.log(selectedTags);
			if(availableTags.length > 0)
				populateAvailableTags(selectedTags, availableTags);
			if(selectedTags.length > 0)
				populateSelectedTags(selectedTags, availableTags);

	}



	function clickOnAvailableTags(element, selectedTags, availableTags) {
		//console.log("Clicked on selected tags");
		var selectedContainerLength = $("#selected-tags").children().length;
		if(selectedContainerLength >= 5) {
			//console.log("selected tags container is full please remove some item and try again"); 
			return false;
		} else {
			for(i=0; i<selectedTags.length; i++) {
				if(selectedTags[i] == "" || selectedTags[i] == '' || selectedTags[i] == null) {
					selectedTags[i] = availableTags[element.getAttribute('data-index')];
					break;
				}
			}
			for(i=0; i<availableTags.length; i++) {
				//console.log(i + " " + element.getAttribute('data-index'));
				if(i == element.getAttribute('data-index')) {
					//console.log("elemment found at : " + i);
					availableTags[i] = '';
				} else {
					availableTags[i] = availableTags[i];
				}
			}
			sortTagsDataByScore(availableTags, "score");
			sortTagsDataByScore(selectedTags, "score");
			//console.log(availableTags);
			//console.log(selectedTags);
			if(availableTags.length > 0)
				populateAvailableTags(selectedTags, availableTags);
			if(selectedTags.length > 0)
				populateSelectedTags(selectedTags, availableTags);
		}
	}
	</script>
</body>
</html>