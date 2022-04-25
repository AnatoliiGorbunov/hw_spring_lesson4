angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.changeQuantity = function (productId, delta){
              $http({
                  url: contextPath + '/product/change_quantity',
                  method: 'GET',
                  params: {
                      productId: productId,
                      delta: delta
                  }
              }).then(function (response){
                  $scope.loadProduct();
              });
          };
    $scope.loadProduct();


    $scope.deleteProduct = function (productId){
               $http({
                   url: contextPath + '/product/delete',
                   method: 'GET',
                   params: {
                        productId: productId,
                         }
               }).then(function (response){
                    $scope.loadProduct();
               });
           };

    $scope.loadProduct();

});