'use strict';

/**
 * @ngdoc directive
 * @name estestApp.directive:c3
 * @description
 * # c3
 */
angular.module('estestApp')
  .directive('c3', function () {
    return {
      template: '<div></div>',
      restrict: 'E',
      link: function postLink(scope, element) {
        element.text('this is the c3 directive');
      }
    };
  });
