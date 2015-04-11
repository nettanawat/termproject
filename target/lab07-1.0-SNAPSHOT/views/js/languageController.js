/**
 * Created by nettanwat on 3/17/15 AD.
 */
'use_strict';
var langController = angular.module('languageController', ['languageServices']);

langController.controller('languageController', ['$scope','$translate','$location','$locale',
    function($scope, $translate, $location,$locale){
        var currentLocal = $locale.id.substring(0,2);
        $scope.currentLocale = currentLocal;
        $scope.changeLanguage = function(locale){
            $translate.use(locale);
            $location.search('lang', locale);
            $scope.currentLocale=locale;
        }
    }])