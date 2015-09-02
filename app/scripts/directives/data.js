'use strict';

/**
 * @ngdoc directive
 * @name estestApp.directive:data
 * @description
 * # data
 */
angular.module('estestApp')
  .directive('data', function () {
    return {
        restrict: 'E', //E = element, A = attribute, C = class, M = comment         
        templateUrl: 'templates/html-includes/angular-chart-template.html',
    };
  });
