<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- The below tag disables user zooming to make the app feel like a native one -->
<!-- meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<style type="text/css">
	html { height: 100% }
    body { height: 100%; margin: 0; padding: 0 }
    .outerdiv{height:100%}
    #maphead { width: 900px; text-align:center;}
    #mapdisp { height: 500px; width: 900px;}
    .navbar{width:900px;}
    .heading{margin-left:auto; margin-right:auto; text-align:center;}
    .navbar .navbar-nav {
  display: inline-block;
  float: none;
}

.navbar .navbar-collapse {
  text-align: center;
}
</style>
<!-- Bootstrap for css styling-->
<link href="bootstrap-3.1.1-dist/css/bootstrap.min.css" rel="stylesheet">
<title>Crisis Management System: Real-time Map of Singapore</title>
</head>

<body>
<div class="outerdiv container-fluid">
<div class="row-fluid">
	<div class="col-lg-2 col-sm-2"></div>
	<div class="col-lg-8 col-sm-8">
	<nav class="navbar navbar-default" role="navigation">
  		<div class="heading container-fluid">
    	<!-- Brand and toggle get grouped for better mobile display -->
    		<div class="navbar-header">
      			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        			<span class="sr-only">Toggle navigation</span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
        			<span class="icon-bar"></span>
      			</button>
    		</div>
    	</div>
    	<div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
          <li><span class="navbar-brand">Team Yang's Crisis Management System</span></li>
        </ul>
      </div><!-- navbar-collapse -->
    </nav>
    	<div id="maphead">
    		<p class="text-info"><small><em>
    			Real-time crisis map of Singapore, integrated with weather conditions
    		</em></small></p>
    	</div>
    	<div id="mapdisp"></div>
    	<!--  div class = "table-responsive">
    		<table class="table table-hover ">
    			<tr>
    				<th>Crisis</th>
    				<th>Time</th>
    				<th>Caller</th>
    				<th>Phone</th>
    				<th>Address</th>
    				<th>Pin Code</th>
    				<th>Description</th>
    				<th>Status</th>
    				<th>Operator</th>
    			</tr>
			</table>
		</div-->
    </div>
    <div class="col-lg-2 col-sm-2"></div>
</div>
</div> <!-- container fluid closed -->
</body>
<%@ page import="maps.MapsController" %>
<% MapsController mCtrl = new MapsController(); // Creating new instance of MapsController%>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
var map; // variable for the Google Map
function initialize() { // called when window finishes loading
	var mapOptions = { // options to set the initial zoom and center of the map
		zoom: 11,
		center: new google.maps.LatLng(1.3667, 103.8)
	};
	map = new google.maps.Map(document.getElementById('mapdisp'), mapOptions); // creating a new Google Maps object with initial options specified by mapOptions
	///Weather layers
	var weatherLayer = new google.maps.weather.WeatherLayer({ // Adds an overlay layer containing current weather details and forecasts
		temperatureUnits: google.maps.weather.TemperatureUnit.CELCIUS
	});
	weatherLayer.setMap(map);
	
	///Displaying info window when a marker is clicked, for every marker
	var markers = []; // array of markers displayed on the map
	var infowindow = new google.maps.InfoWindow();
	<%
    for(int i = 0; i<mCtrl.getNumOfMarkers(); i++) { // looping through the total number of markers in the instance of MapsController
    %>
    	var lat = parseFloat("<%= mCtrl.getLatOfMarkerAti(i) %>"); //fetching the latitude of the marker
    	var lng = parseFloat("<%= mCtrl.getLngOfMarkerAti(i) %>"); //fetching the latitude of the marker
    	var txt = "<%= mCtrl.getContentOfMarkerAti(i) %>";  //fetching the content for the info window of the marker
    	var img = "<%= mCtrl.getIconOfMarkerAti(i) %>";  //fetching the icon to display for the marker
    	if(!imageExists(img)){ // if the icon image file does not exists, use the default marker
			var marker = new google.maps.Marker({
				position: new google.maps.LatLng(lat, lng),
				map: map
			});
    	}
    	else{ // if the icon image file exists, use it
    		//alert(img);
    		var marker = new google.maps.Marker({
				position: new google.maps.LatLng(lat, lng),
				map: map,
				icon: img
			});
    	}
		makeInfoWindowEvent(map, infowindow, txt, marker); // creating info window for each marker
		markers.push(marker); // pushing each marker into the markers array
		//alert(markers.length);
    <%
    } // closing for loop
    %>
	
}
/// This function checks it the image file specified by {@param image_url} exists
/// @param image_url url of image file
/// @return boolean value - true if image file exists, else false.
function imageExists(image_url){

    var http = new XMLHttpRequest();

    http.open('HEAD', image_url, false);
    http.send();

    return http.status != 404;

}
/// This function creates the info window for each marker
/// @param map represents displayed map
/// @param infowindow represents the info window
/// @param contentString represents content to be displayed inside the infowindow
/// @param marker represents the marker to be displayed on the map
function makeInfoWindowEvent(map, infowindow, contentString, marker) {
	google.maps.event.addListener(marker, 'click', function() {
		//alert(contentString);
		infowindow.setContent(contentString);
		infowindow.open(map, marker);
	});
}

/// This function is called as soon as the window is loaded. It includes the Google Maps API in the page
function loadScript() {
	//alert('loaded!');
	var script = document.createElement('script');
	script.type = "text/javascript";
	script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyAN1O3gbgwQTf4UFPfUwZ9y51W6Dq1I9Qc&sensor=true&libraries=weather&callback=initialize";
	document.body.appendChild(script);
}

window.onload = loadScript;  // function loadScript() is called as soon as window loads
</script>
</html>