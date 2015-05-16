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

        //$scope.deleteForum = function (id) {
        //    var answer = confirm("Do you want to delete the product?");
        //    if (answer) {
        //        $http.put("/comment/deletecomment/" +id, $scope.forum).then(function () {
        //            $rootScope.deleteSuccess = true;
        //            $route.reload();
        //        });
        //    }
        //}

    }]);

forumMainController.controller('addForumController', ['$scope', '$http', '$location', '$rootScope',
    function ($scope, $http, $location, $rootScope) {
        $scope.forum = {};
        $scope.addMember = true;
        $scope.editMember = false;

        //for admin
        $scope.addForumAdmin = function () {
            $http.post("/forum/addforum", $scope.forum).success(function () {
                $rootScope.addSuccess = true;
                $location.path("/admin/listforum");
            });
        };

        //user
        $scope.addForum = function () {
            $http.post("/forum/addforum", $scope.member).success(function () {
                $rootScope.addSuccess = true;
                $location.path("/forums");
            });
        };
    }]);

forumMainController.controller('aForumController', ['$scope', '$http','$routeParams', '$rootScope','$route','$location',
    function ($scope, $http,$routeParams, $rootScope,forumService,$route,$location) {
        var id = $routeParams.id;
        $rootScope.showDelete = true;
        $http.get("/forum/forumById/" + id).success(function (data) {
            $scope.forum = data;
            var comment = $scope.forum.commentForums;
            for(var i=0; i<comment.length;i++){
                if(comment[i].status==false){
                    $rootScope.showDelete = false;
                }
            }
        });

        $scope.deleteComment = function (id) {
            var answer = confirm("Are you sure to delete this comment?");
            if (answer) {
                $http.delete("/comment/deletecomment/" + id, "").then(function () {
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                });
            }
        }
    }]);