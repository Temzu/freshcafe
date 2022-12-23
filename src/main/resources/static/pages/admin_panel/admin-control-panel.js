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
        });
      };

      $scope.updateCategoryTitle = function (category, newTitle = category.title) {
        category.title = newTitle;
        $http.put(contextPath + '/api/v1/categories/update', category)
        .then(function successCallback(response) {
          $scope.loadCategories();
          $("#ModalCategoryChangeForm" + category.id).modal("hide");
        }, function errorCallback(response) {
          alert(response.data.messages);
        });
      };

      $scope.uploadCategoryImage = function (categoryId) {
        let imageUrl = $('#imageInput' + categoryId).val();

        $http({
          url: contextPath + '/api/v1/categories/' + categoryId + '/upload',
          method: 'PUT',
          params: {
            imageUrl: imageUrl
          }
        }).then(function successCallback(response) {
          $scope.loadCategories();
          $("#ModalCategoryChangeImageForm" + categoryId).modal("hide");
        });
      }


      $scope.uploadFileToUrl = function(categoryId, url){

        $http({
          url: contextPath + url,
          method: 'PUT',
          params: {
            imageUrl: pageIndex
          }
        }).then(function successCallback(response) {
          $scope.loadCategories();
          $("#ModalCategoryChangeImageForm" + categoryId).modal("hide");
        });

        // let file = new FormData();
        //
        // file.append('file', file1);
        //
        // return $http({
        //   url: contextPath + url,
        //   method: 'POST',
        //   data: file,
        //   //assign content-type as undefined, the browser
        //   //will assign the correct boundary for us
        //   headers: { 'Content-Type': undefined},
        //   //prevents serializing payload.  don't do it.
        //   transformRequest: angular.identity
        // });
      }

      $scope.createProduct = function (categoryTitle = $rootScope.categoryTitle) {
        console.log($scope.newProduct);
        $scope.newProduct.categoryTitle = categoryTitle;

        $http.post(contextPath + '/api/v1/products/create', $scope.newProduct)
        .then(function successCallback(response) {
          $scope.showPageByCategory(categoryTitle);
          $("#ModalProductCreateForm").modal("hide");
        }, function errorCallback(response) {
          alert(response.data.messages);
        });
      }

      $scope.updateProduct = function (productId, categoryTitle = $rootScope.categoryTitle) {
        let newTitle = $('#inputProductChangeTitle' + productId).val();
        let newPrice = $('#inputProductChangePrice' + productId).val();

        let updateProduct = {
          'id': productId,
          'categoryTitle': categoryTitle,
          'title': newTitle,
          'price': newPrice
        }

        $http.put(contextPath + '/api/v1/products/' + productId + '/update', updateProduct)
        .then(function successCallback(response) {
          $scope.showPageByCategory(categoryTitle);
          $("#ModalProductChangeForm" + productId).modal("hide");

          $http.get(contextPath + '/api/v1/products/list')
          .then(function successCallback(response) {
            $rootScope.allProducts = response.data;
          });

        }, function errorCallback(response) {
          alert(response.data.messages);
        });


      };

      $scope.uploadProductImage = function (productId) {
        let imageUrl = $('#imageProductInput' + productId).val();

        $http({
          url: contextPath + '/api/v1/products/' + productId + '/upload',
          method: 'PUT',
          params: {
            imageUrl: imageUrl
          }
        }).then(function successCallback(response) {
          $scope.showPageByCategory($rootScope.categoryTitle);
          $("#ModalProductChangeImageForm" + productId).modal("hide");

          $http.get(contextPath + '/api/v1/products/list')
          .then(function successCallback(response) {
            $rootScope.allProducts = response.data;
          });

        }, function errorCallback(response) {
          alert(response.data.messages);
        });
      }

      $scope.deleteCategory = function (categoryId) {
        $http({
          url: contextPath + '/api/v1/categories/delete/' + categoryId,
          method: 'DELETE'
        }).then(function successCallback(response) {
          $scope.loadCategories();
          $("#ModalCategoriesDeleteForm" + categoryId).modal("hide");
        }, function errorCallback(response) {
          alert(response.data.messages);
        });
      }

      $scope.createCategory = function () {
        $http.post(contextPath + '/api/v1/categories/create', $scope.category)
        .then(function successCallback(response) {
          $scope.loadCategories();
          $("#ModalCategoryCreateForm").modal("hide");
        }, function errorCallback(response) {
          alert(response.data.messages);
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
        }, function errorCallback(response) {
          alert(response.data.messages);
        });
      }

      $scope.showCategoryPage();
    });