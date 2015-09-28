'use strict';

/**
 * @ngdoc overview
 * @name estestApp
 * @description
 * # estestApp
 *
 * Main module of the application.
 */
angular
  .module('estestApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'elasticsearch',
    'angularChart',
    'ngMaterial'
  ],
  ['$locationProvider', function($locationProvider){
        $locationProvider.html5Mode(true);
  }]
  )
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
