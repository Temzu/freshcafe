(function ($localStorage) {
  'use strict';

  angular
  .module('market-front', ['ngRoute', 'ngStorage'])
  .config(config)
  .run(run);

  function config($routeProvider) {
    $routeProvider
    .when('/', {
      templateUrl: 'home/home.html',
      controller: 'homeController'
    })
    .when('/products', {
      templateUrl: 'menu/categories.html',
      controller: 'productsController'
    })
    .when('/categories', {
      templateUrl: 'categories/categories.html',
      controller: 'categoriesController'
    })
    .when('/categories/:categoryTitle', {
      templateUrl: 'categories/categories_item.html',
      controller: 'categoriesController'
    })
    .when('/registration', {
      templateUrl: 'registration/registration.html',
      controller: 'registrationController'
    })
    .when('/orders', {
      templateUrl: 'order/order.html',
      controller: 'ordersController'
    })
    .when('/cart', {
      templateUrl: 'cart/cart.html',
      controller: 'cartController'
    })
    .otherwise({
      redirectTo: '/'
    });
  }
  const contextPath = "http://localhost:8189/freshcafe";

  function run($rootScope, $http, $localStorage) {
    $("#reg").click(function(){
      $("#ModalForm").modal("hide");
    });

    if ($localStorage.currentUser) {
      $http.defaults.headers.common.Authorization = $localStorage.currentUser.token;
    }

    if (!$localStorage.guestCartUuid) {
      $http.get(contextPath + '/api/v1/cart/generate')
      .then(function successCallback(response) {
        $localStorage.guestCartUuid = response.data.value;
        console.log($localStorage.guestCartUuid);
      });
    } else {
      $http({
        url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid,
        method: 'GET'
      }).then(function (response) {
        $rootScope.cart = response.data;
      });
    }

    $http.get(contextPath + '/api/v1/products/list')
    .then(function successCallback(response) {
      $rootScope.allProducts = response.data;
      console.log($rootScope.allProducts);
    });
  }
})();

angular.module('market-front').controller('indexController',
    function ($rootScope, $scope, $http, $localStorage, $location) {

      const contextPath = "http://localhost:8189/freshcafe";

      let myModal = document.getElementById('ModalForm');

      $scope.tryToAuth = function () {

        $http.post(contextPath + '/api/v1/auth/login', $scope.user)
        .then(function successCallback(response) {
          if (response.data.token) {
            $http.defaults.headers.common.Authorization = response.data.token;
            $localStorage.currentUser = {
              email: $scope.user.email,
              token: response.data.token
            };

            $scope.currentUserName = $scope.user.email;

            $scope.user.email = null;
            $scope.user.password = null;

            $("#ModalForm").modal("hide");
            $location.path('/categories');

            $http.get(
                contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid + '/merge')
            .then(function successCallback(response) {
            });

            $http({
              url: contextPath + '/api/v1/cart/' + $localStorage.guestCartUuid,
              method: 'GET'
            }).then(function (response) {
              $rootScope.cart = response.data;
            });
          }
        }, function errorCallback(response) {
          alert(response.data.messages);
        });

      };

      $scope.tryToLogout = function () {
        $scope.clearUser();

        $http.post(contextPath + '/api/v1/cart')
        .then(function successCallback(response) {
          $localStorage.guestCartUuid = response.data;
        });
        $http.defaults.headers.common.Authorization = null;

        if ($scope.user.email) {
          $scope.user.email = null;
        }
        if ($scope.user.password) {
          $scope.user.password = null;
        }

      };

      $scope.toRegistration = function () {
        $location.path('/registration');
      };

      $scope.clearUser = function () {

        $http.post(contextPath + '/api/v1/auth/logout')
        .then(function successCallback(response) {
          //--//
        },function errorCallback(response) {
          alert(response.data.messages);
        });

        delete $localStorage.currentUser;
        $http.defaults.headers.common.Authorization = '';
      };

      $rootScope.isUserLoggedIn = function () {
        if ($localStorage.currentUser) {
          return true;
        } else {
          return false;
        }
      };

      $scope.isCartEmpty = function () {
        if ($rootScope.cart == null || $rootScope.cart.items.length === 0) {
          return true;
        } else {
          return false;
        }
      }
    });