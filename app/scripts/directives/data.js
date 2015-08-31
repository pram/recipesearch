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
      template: '<div></div>',
      restrict: 'E',
      link: function postLink(scope, element) {
        element.text('this is the data directive');
      }
    };
  });
