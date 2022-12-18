angular.module('market-front').controller('adminController',
    function ($scope, $http, $localStorage, $rootScope) {

      const contextPath = 'http://localhost:8189/freshcafe';

      $scope.loadPage = function (pageIndex = 1) {
        $http({
          url: contextPath + '/api/v1/categories',
          method: 'GET',
          params: {
            page: pageIndex
          }
        }).then(function (response) {
          $scope.categoryPage = response.data;
          $scope.navList = $scope.generatePagesIndexes(1, $scope.categoryPage.totalPages);
        });
      };

      $scope.showCategoryPage = function (pageIndex = 1) {
        $http({
          url: contextPath + '/api/v1/categories',
          method: 'GET',
          params: {
            page: pageIndex
          }
        }).then(function (response) {
          $scope.categoryPage = response.data;

          let minPageIndex = pageIndex - 2;
          if (minPageIndex < 1) {
            minPageIndex = 1;
          }

          let maxPageIndex = pageIndex + 2;
          if (maxPageIndex > $scope.categoryPage.totalPages) {
            maxPageIndex = $scope.categoryPage.totalPages;
          }

          $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
          console.log(response.data);
        });
      };


      $scope.showPageByCategory = function (categoryTitle = '', pageIndex = 1) {
        $http({
          url: contextPath + '/api/v1/categories/' + categoryTitle,
          method: 'GET',
          params: {
            page: pageIndex
          }
        }).then(function (response) {
          $rootScope.productsPage = response.data;
          $rootScope.categoryTitle = categoryTitle;

          console.log($rootScope.productsPage.content)

          let minPageIndex = pageIndex - 2;
          if (minPageIndex < 1) {
            minPageIndex = 1;
          }

          let maxPageIndex = pageIndex + 2;
          if (maxPageIndex > $scope.productsPage.totalPages) {
            maxPageIndex = $scope.productsPage.totalPages;
          }

          $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
          console.log(response.data);
        });
      };

      $scope.showCategoryPage();
    });