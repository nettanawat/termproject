'use strict';

var eventMainController = angular.module('eventMainController', ['eventServices']);

productMainController.controller('addProductController', ['$scope', '$http', '$location', '$rootScope','productService',
    function ($scope, $http, $location, $rootScope,productService) {
        $scope.product = {};
        $scope.addPerson = true;
        $scope.editPerson = false;
        $scope.addProduct = function () {

            //$http.post("/product", $scope.product).success(function () {
            productService.save($scope.product,function(){
                $rootScope.addSuccess = true;
                $location.path("listProduct");

            });
        };


    }]);

eventMainController.controller('listEventController', ['$scope', '$http', '$rootScope','eventService','$route','totalCalService',
    function ($scope, $http, $rootScope,eventService,$route,totalCalService) {
        $http.get("/event/allevents").success(function (data) {
        //var data = eventService.query(function(){
            $scope.events = data;
            $scope.totalEvent = data.length;
        });

        $http.get("/event/randomthreeevents").success(function (data) {
            //var data = eventService.query(function(){
            $scope.randomThreeEvents = data;
        });

        $http.get("/event/upcomingevent").success(function (data) {
            //var data = eventService.query(function(){
            $scope.upcomingevent = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteProduct = function (id) {
            var answer = confirm("Do you want to delete the product?");
            if (answer) {
                productService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }

    }]);

eventMainController.controller('editEventController', ['$scope', '$http', '$routeParams', '$location', '$rootScope',
    function ($scope, $http, $routeParams, $location, $rootScope) {
        $scope.addEvent = false;
        $scope.editEvent = true;
        var id = $routeParams.id;
        $http.get("/event/eventbyid/" + id).success(function (data) {
            $scope.event = data;
        });

        $scope.editAnEvent = function () {
            $http.put("/event/editevent/" +id, $scope.event).then(function () {
                //memberService.update({id:$scope.member.id},$scope.member,function(){
                $rootScope.editSuccess = true;
                $location.path("/admin/listevent");
            });
        }
    }]);

eventMainController.controller('singleEventController', ['$scope', '$http','$routeParams',
    function ($scope, $http,$routeParams) {
        var id = $routeParams.id;
        $http.get("/event/eventbyid/" + id).success(function (data) {
            $scope.event = data;
        });
    }]);

