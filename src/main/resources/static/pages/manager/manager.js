angular.module('market-front').controller('managerController', function ($scope, $http) {

  const contextPath = "https://freshcafe-production.up.railway.app/freshcafe";

  $scope.activeCustomer='Обрабатывается';

  $scope.showAllOrders = function () {
    $http({
      url: contextPath + '/api/v1/orders/find_all',
      method: 'GET'
    }).then(function (response) {
      $scope.allOrders = response.data;
      console.log($scope.allOrders)
    });
  };

  $scope.getVal=function(active){
    $scope.activeCustomer=active.currentTarget.value;
  }

  $scope.isClosed = function (value) {
    return value === 'Закрыт'
  }

  $scope.changeStatus = function (orderId) {
    $http.post(contextPath + '/api/v1/orders/' + orderId + '/change_status')
    .then(function successCallback(response) {
      $scope.showAllOrders();
    }, function errorCallback(response) {
      alert(response.data.messages);
    });
  }

  $scope.showAllOrders();
});