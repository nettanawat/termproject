<!DOCTYPE html>

<html lang="en" ng-app="labApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Wat Chedi Luang</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
    <link rel="stylesheet" href="app.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="lightbox.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/angular-translate/angular-translate.js"></script>
    <script src="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>
    <script src="app.js"></script>
    <script src="resources/lightbox-2.6.min.js"></script>
    <script src="resources/jquery-1.10.2.min.js"></script>
    <script src="js/productController.js"></script>
    <script src="js/productService.js"></script>
    <script src="js/eventController.js"></script>
    <script src="js/eventService.js"></script>
    <script src="js/memberController.js"></script>
    <script src="js/memberService.js"></script>
    <script src="js/forumController.js"></script>
    <script src="js/forumService.js"></script>
    <script src="js/commentForumController.js"></script>
    <script src="js/commentForumService.js"></script>
    <script src="js/languageController.js"></script>
    <script src="js/languageService.js"></script>
    <script src="http://maps.googleapis.com/maps/api/js"></script>

    <script>
        var myCenter=new google.maps.LatLng(18.786962,98.986553);
        var marker;

        function initialize()
        {
            var mapProp = {
                center:myCenter,
                zoom:15,
                mapTypeId:google.maps.MapTypeId.ROADMAP
            };

            var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

            var marker=new google.maps.Marker({
                position:myCenter,
                animation:google.maps.Animation.BOUNCE
            });

            marker.setMap(map);
        }

        google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</head>
<body>


<ng-view>...Loading</ng-view>




<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->
</body>
</html>

