'use strict';

describe('Directive: c3', function () {

  // load the directive's module
  beforeEach(module('estestApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<c3></c3>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the c3 directive');
  }));
});
