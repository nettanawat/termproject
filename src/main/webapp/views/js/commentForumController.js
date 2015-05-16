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

        //$scope.deleteComment = function (id) {
        //    var answer = confirm("Do you want to delete the product?");
        //    if (answer) {
        //        productService.delete({id:id},function(){
        //            $rootScope.deleteSuccess = true;
        //            $route.reload();
        //        })
        //    }
        //}

        var id = $routeParams.id;
        $http.get("/comment/comment/" + id).success(function (data) {
            $scope.comment = data;
        });

        $scope.deleteComment = function () {

            var answer = confirm("Do you want to delete the product?");
            if (answer) {
                $http.put("/comment/editcomment/" + id, $scope.comment).then(function () {
                    //memberService.update({id:$scope.member.id},$scope.member,function(){
                    $rootScope.editSuccess = true;
                    $location.path("/forum/"+id);
                });
            }
        }

    }]);

commentForumMainController.controller('editCommentController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','memberService',
    function ($scope, $http, $routeParams, $location, $rootScope,memberService) {
        $scope.addMember = false;
        $scope.editMember = true;
        var id = $routeParams.id;
        $http.get("/comment/comment/" + id).success(function (data) {
            $scope.member = data;
        });

        $scope.editAMember = function () {
            $http.put("/member/editmember/" +id, $scope.member).then(function () {
                //memberService.update({id:$scope.member.id},$scope.member,function(){
                $rootScope.editSuccess = true;
                $location.path("/admin/listmember");
            });
        }
    }]);