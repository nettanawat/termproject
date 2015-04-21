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
          templateUrl: 'template/events-programs.html'
      }).
      when('/',{
          templateUrl: 'template/index.html'
      }).
      when('/filenotfound',{
          templateUrl: 'template/filenotfound.html'
      }).
      when('/event',{
          templateUrl: 'template/event-program-detail.html'
      }).
      when('/forums',{
          templateUrl: 'template/forumList.html'
      }).
       otherwise({redirectTo: '/filenotfound'});
}]);

labApp.config(function($translateProvider){
    $translateProvider.useUrlLoader('/messageBundle');
    $translateProvider.useStorage('UrlLanguageStorage');
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('en');
})
