angular.module('market-front').controller('adminController',
    function ($scope, $http, $localStorage, $rootScope) {

      const contextPath = 'http://localhost:8189/freshcafe';

      $scope.loadCategories = function (pageIndex = 1) {
        $http({
          url: contextPath + '/api/v1/categories',
          method: 'GET',
          params: {
            page: pageIndex
          }
        }).then(function (response) {
          $scope.categoryPage = response.data;
          console.log($scope.categoryPage);
        });
      };

      $scope.loadProduct = function (pageIndex = 1) {
        $http({
          url: contextPath + '/api/v1/categories',
          method: 'GET',
          params: {
            page: pageIndex
          }
        }).then(function (response) {
          $scope.categoryPage = response.data;
          console.log($scope.categoryPage);
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

          console.log(response.data);
        });
      };

      $scope.deleteCategory = function (categoryId) {
        $http({
          url: contextPath + '/api/v1/categories/delete/' + categoryId,
          method: 'DELETE'
        }).then(function successCallback(response) {
          $scope.loadCategories();
          $("#ModalCategoriesDeleteForm" + categoryId).modal("hide");
        });
      }

      $scope.deleteProduct = function (productId, categoryTitle = '') {
        $http({
          url: contextPath + '/api/v1/products/delete/' + productId,
          method: 'DELETE'
        }).then(function successCallback(response) {
          $scope.showPageByCategory(categoryTitle);
          $("#ModalProductDeleteForm" + productId).modal("hide");
        });
      }

      $scope.addToCart = function (productId) {
        $http({
          url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid
              + '/add/' + productId,
          method: 'GET'
        }).then(function successCallback(response) {
          $scope.loadCart();
          $("#ModalCategoriesForm" + productId).modal("hide");
        });
      }

      $scope.showCategoryPage();
    });