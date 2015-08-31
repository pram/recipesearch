'use strict';

/**
 * @ngdoc function
 * @name estestApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the estestApp
 */
angular.module('estestApp')
  .controller('MainCtrl', function ($scope) {
  	$scope.options = {
      data: [
        {
          sales: 130,
          income: 250,
          tax: 122
        }
      ],
      dimensions: {
        sales: {
          type: 'pie'
        },
        income: {
          type: 'pie'
        },
        tax: {
          type: 'pie'	
        }
      }
    };  	    
  });
