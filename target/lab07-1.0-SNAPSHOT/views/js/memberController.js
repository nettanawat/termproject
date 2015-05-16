'use strict';

var memberMainController = angular.module('memberMainController', ['memberServices']);


memberMainController.controller('addMemberController', ['$scope', '$http', '$location', '$rootScope','memberService',
    function ($scope, $http, $location, $rootScope,productService) {
        $scope.member = {};
        $scope.addMember = true;
        $scope.editMember = false;

        //for admin
        $scope.addMember = function () {
            $http.post("/member/addmember", $scope.member).success(function () {
                $rootScope.addSuccess = true;
                $location.path("/admin/listmember");
            });
        };

        //user
        $scope.registerMember = function () {
            $http.post("/member/addmember", $scope.member).success(function () {
                $rootScope.addSuccess = true;
                $location.path("/");
            });
        };
    }]);

memberMainController.controller('listMemberController', ['$scope', '$http', '$rootScope','memberService','$route','$routeParams',
    function ($scope, $http, $rootScope,memberService,$route,$routeParams) {
        $http.get("/member/allmember").success(function (data) {
        //var data = memberService.query(function(){
            $scope.totalMember= data.length;
            $scope.members = data;
        });

        $http.get("/member/lastjoinedfivemembers").success(function (data) {
            $scope.lastfivemembers = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });


        $scope.deleteMember = function (id) {
            var answer = confirm("Are you sure to delete this member?");
            if (answer) {
                $http.delete("/member/deletemember/" +id,"").then(function () {
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                });
            }
        }

    }]);


//for admin
memberMainController.controller('editMemberController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','memberService',
    function ($scope, $http, $routeParams, $location, $rootScope,memberService) {
        $scope.addMember = false;
        $scope.editMember = true;
        var id = $routeParams.id;
        $http.get("/member/member/" + id).success(function (data) {
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