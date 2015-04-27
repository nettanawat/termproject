'use strict';

// Declare app level module which depends on views, and components
var labApp = angular.module('labApp', [
    'ngRoute',
    'productMainController',
    'memberMainController',
    'eventMainController',
    'forumMainController',
    'commentForumMainController',
    'languageController',
    'languageServices',
    'pascalprecht.translate'
])
labApp.config(['$routeProvider',
  function($routeProvider) {
  $routeProvider.
      when('/addProduct',{
          templateUrl: 'template/editProduct.html',
          controller: 'addProductController'
      }).
      when('/editProduct/:id',{
          templateUrl: 'template/editProduct.html',
          controller: 'editProductController'
      }).
      when('/signup',{
          templateUrl: 'template/signup.html'
      }).
      when('/login',{
          templateUrl: 'template/login.html'
      }).
      when('/events',{
          templateUrl: 'template/eventList.html'
      }).
      when('/event/:id',{
          templateUrl: 'template/event.html'
      }).
      when('/',{
          templateUrl: 'template/index.html'
      }).
      when('/filenotfound',{
          templateUrl: 'template/filenotfound.html'
      }).
      when('/forums',{
          templateUrl: 'template/forumList.html'
      }).
      when('/forum/:id',{
          templateUrl: 'template/forum.html'
      }).
      when('/admin/dashboard',{
          templateUrl: 'template/admin-dashboard.html'
      }).
      when('/admin/listmember',{
          templateUrl: 'template/admin-memberList.html'
      }).
      when('/admin/addmember',{
          templateUrl: 'template/admin-addMember.html',
          controller: 'addMemberController'
      }).
      when('/admin/editmember/:id',{
          templateUrl: 'template/admin-addMember.html',
          controller: 'editMemberController'
      }).
      when('/admin/listevent',{
          templateUrl: 'template/admin-eventList.html',
          controller: 'listEventController'
      }).
      when('/admin/addevent',{
          templateUrl: 'template/admin-addEvent.html',
          controller: 'addEventController'
      }).
      when('/admin/editevent/:id',{
          templateUrl: 'template/admin-addEvent.html',
          controller: 'editEventController'
      }).
       otherwise({redirectTo: '/filenotfound'});
}]);

labApp.config(function($translateProvider){
    $translateProvider.useUrlLoader('/messageBundle');
    $translateProvider.useStorage('UrlLanguageStorage');
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('en');
})
