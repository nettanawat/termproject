'use strict';

var forumMainController = angular.module('forumMainController', ['forumServices']);


forumMainController.controller('listForumController', ['$scope', '$http', '$rootScope','$route',
    function ($scope, $http, $rootScope,forumService,$route) {
        $http.get("/forum/allforum").success(function (data) {
        //var data = forumService.query(function(){
            $scope.forums = data;
            $scope.totalForum = data.length;
        });

        $http.get("/forum/lasttwoforum").success(function (data) {
            //var data = forumService.query(function(){
            $scope.lastTwoForum = data;
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

forumMainController.controller('aForumController', ['$scope', '$http','$routeParams', '$rootScope','$route',
    function ($scope, $http,$routeParams, $rootScope,forumService,$route) {
        var id = $routeParams.id;
        $http.get("/forum/forumById/" + id).success(function (data) {
            $scope.forum = data;
        });
    }]);