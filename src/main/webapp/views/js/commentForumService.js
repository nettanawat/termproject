'use strict'
var commentForumService = angular.module('commentForumServices',['ngResource']);

commentForumService.factory('commentForumService',function($resource){
    return $resource('/commentForum/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

commentForumService.service('totalCalService',function() {
    this.getTotalNetPrice = function (products) {
        var output = 0.0;
        for (var index = 0; index < products.length;index++) {
            var product = products[index];
            output += parseFloat(product.netPrice);
        }
        return output;
    }
})