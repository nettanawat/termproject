'use strict'
var eventService = angular.module('eventServices',['ngResource']);

eventService.factory('eventService',function($resource){
    return $resource('/event/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

eventService.service('totalCalService',function() {
    this.getTotalNetPrice = function (products) {
        var output = 0.0;

        for (var index = 0; index < products.length;index++) {
            var product = products[index];
            output += parseFloat(product.netPrice);
        }
        return output;
    }
})