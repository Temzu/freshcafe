angular.module('market-front').controller('ordersController', function ($scope, $http) {
  const contextPath = "https://freshcafe-production.up.railway.app/freshcafe";

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
});