(function () {
  'use strict';
  var app = angular.module('autogeneratedForm', [
    'ui.bootstrap',
    'ngResource',
    'org.bonita.common.resources'
    ]);

  app.controller('MainCtrl', ['$scope','$location', 'contractSrvc','$window', function ($scope, $location, contractSrvc, $window) {

    var taskId = $location.search().id;

    $scope.contract = {};
    $scope.dataToSend = {};

    $scope.getInputName = function() {
      return 'dataToSend.attribute1';
    };


    contractSrvc.fetchContract(taskId).then(function(result){
      $scope.contract = result.data;
    });


    $scope.postData = function() {
      contractSrvc.executeTask(taskId, $scope.dataToSend).then(function(result){
        console.log($window.top.location.href);
        $window.top.location.href = "/bonita"
      });
    };

  }])
  .config(['$locationProvider',function($locationProvider) {
    $locationProvider.html5Mode({
      enabled: true,
      requireBase: false
    });
  }]);


})();
