'use strict'
var memberService = angular.module('memberServices',['ngResource']);

memberService.factory('memberService',function($resource){
    return $resource('/member/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})

memberService.service('totalCalService',function() {
    this.getTotalNetPrice = function (products) {
        var output = 0.0;

        for (var index = 0; index < products.length;index++) {
            var product = products[index];
            output += parseFloat(product.netPrice);
        }
        return output;
    }
})