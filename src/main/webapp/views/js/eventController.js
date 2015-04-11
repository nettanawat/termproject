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
        //$http.get("/product/").success(function (data) {
        var data = eventService.query(function(){
            $scope.events = data;
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

productMainController.controller('editProductController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','productService',
    function ($scope, $http, $routeParams, $location, $rootScope,productService) {
        $scope.addPerson = false;
        $scope.editPerson = true;
        var id = $routeParams.id;
        $http.get("/product/" + id).success(function (data) {
            $scope.product = data;
        });

        $scope.editProduct = function () {
            //$http.put("/product", $scope.product).then(function () {
            productService.update({id:$scope.product.id},$scope.product,function(){
                $rootScope.editSuccess = true;
                $location.path("listProduct");
            });
        }
    }]);