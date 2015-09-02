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
        //scope: {
            //@ reads the attribute value, = provides two-way binding, & works with functions
        //    title: '@'         },
        //template: '<div>{{ myVal }}</div>',
        templateUrl: 'templates/html-includes/angular-chart-template.html',
        //controller: controllerFunction, //Embed a custom controller in the directive
        link: function ($scope, element) {
        	element.text('Boooooooo!!');
        } //DOM manipulation
    };
  });
