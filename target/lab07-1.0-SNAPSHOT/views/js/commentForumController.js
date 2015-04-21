'use strict';

var commentForumMainController = angular.module('commentForumMainController', ['commentForumServices']);

commentForumMainController.controller('addProductController', ['$scope', '$http', '$location', '$rootScope','productService',
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

commentForumMainController.controller('listCommentForumController', ['$scope', '$http', '$rootScope','commentForumService','$route','totalCalService',
    function ($scope, $http, $rootScope,commentForumService,$route,totalCalService) {
        $http.get("/comment/allcomment").success(function (data) {
        //var data = commentForumService.query(function(){
            $scope.commentForums = data;
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

commentForumMainController.controller('editProductController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','productService',
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