angular.module('market-front').controller('accountController',
    function ($scope, $http, $localStorage, $rootScope) {

      const contextPath = 'http://localhost:8189/freshcafe';

      $scope.loadAccountInfo = function () {
        $http({
          url: contextPath + '/api/v1/accounts/current',
          method: 'GET'
        }).then(function (response) {
          $rootScope.currentUserInfo = response.data;
        });
      }

      $scope.changeFields = function () {
        $('#loginField').prop('disabled', false);
        $('#emailField').prop('disabled', false);
        $('#changeButton').prop('disabled', true);
        $('#saveButton').prop('disabled', false);
      }

      $scope.tryToSaveInfo = function () {
        $('#loginField').prop('disabled', false);
        $('#emailField').prop('disabled', false);
        $('#changeButton').prop('disabled', true);
        $('#saveButton').prop('disabled', false);
      }

      $scope.showMyOrders = function (pageIndex = 1) {
        $http({
          url: contextPath + '/api/v1/orders',
          method: 'GET',
          params: {
            page: pageIndex
          }
        }).then(function (response) {
          $scope.orderPage = response.data;
          console.log($scope.orderPage.content)
          $scope.navList = $scope.generatePagesIndexes(1, $scope.orderPage.totalPages);
        });
      };

      $scope.generatePagesIndexes = function (startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
          arr.push(i);
        }
        return arr;
      }

      $scope.showMyOrders();

      $scope.loadAccountInfo();
    });