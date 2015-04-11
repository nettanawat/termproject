/**
 * Created by nettanwat on 3/17/15 AD.
 */
'use_strict';
var languageServices = angular.module('languageServices', []);
languageServices.factory('UrlLanguageStorage', ['$location', function($location){
    return {
        put: function (name, value){
        },
        get: function(name){
            return $location.search()['lang']
        }
    };
}]);
