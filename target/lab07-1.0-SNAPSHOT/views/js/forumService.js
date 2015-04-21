'use strict'
var forumService = angular.module('forumServices',['ngResource']);

forumService.factory('forumService',function($resource){
    return $resource('/forum/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})