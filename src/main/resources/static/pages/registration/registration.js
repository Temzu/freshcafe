angular.module('market-front').controller("registrationController",
    function ($scope, $http, $localStorage, $location) {
      const contextPath = "https://freshcafe-production.up.railway.app//freshcafe";

      $scope.tryToSignUp = function () {
        $http.post(contextPath + '/api/v1/auth/signup', $scope.user)
        .then(function successCallback(response) {

          if (response.data.token) {
            $http.defaults.headers.common.Authorization = response.data.token;

            $localStorage.currentUser = {
              login: $scope.user.login,
              token: response.data.token
            };

            $scope.currentUserName = $scope.user.login;

            $scope.user.login = null;
            $scope.user.password = null;
            $scope.user.email = null;

            $location.path('/categories');
          }
        }, function errorCallback(response) {
          alert(response.data.messages);
        });
      };

    })