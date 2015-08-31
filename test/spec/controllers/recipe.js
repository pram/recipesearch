'use strict';

describe('Controller: RecipectrlCtrl', function () {

  // load the controller's module
  beforeEach(module('estestApp'));

  var RecipectrlCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    RecipectrlCtrl = $controller('RecipectrlCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    //expect(RecipectrlCtrl.awesomeThings.length).toBe(3);
  });
});
