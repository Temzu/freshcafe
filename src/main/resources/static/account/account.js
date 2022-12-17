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


      //
      // $scope.incrementCartPosition = function (productId) {
      //   console.log($rootScope.cart)
      //   $http({
      //     url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid
      //         + '/add/' + productId,
      //     method: 'GET'
      //   }).then(function (response) {
      //     $scope.loadCart();
      //   });
      // }
      //
      // $scope.decrementCartPosition = function (productId) {
      //   $http({
      //     url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid
      //         + '/decrement/' + productId,
      //     method: 'GET'
      //   }).then(function (response) {
      //     $scope.loadCart();
      //   });
      // }
      //
      // $scope.clearCart = function () {
      //   $http({
      //     url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid
      //         + '/clear',
      //     method: 'GET'
      //   }).then(function (response) {
      //     $rootScope.cart = null;
      //   });
      // }
      //
      // $scope.removeItemFromCart = function (productId) {
      //   $http({
      //     url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid
      //         + '/remove/' + productId,
      //     method: 'GET'
      //   }).then(function (response) {
      //     $scope.loadCart();
      //   });
      // }
      //
      // $scope.createOrder = function () {
      //   $http.post(contextPath + '/api/v1/orders', $scope.order_info)
      //   .then(function (response) {
      //     alert('Order created');
      //     $scope.loadCart();
      //   }, function errorCallback(response) {
      //     alert(response.data.messages);
      //   });
      // }
      //
      // $scope.filterMyData = function (input, search_param) {
      //   if (input === search_param) {
      //     return true;
      //   }
      // }
      //
      // $scope.loadCart();

      $scope.loadAccountInfo();
    });