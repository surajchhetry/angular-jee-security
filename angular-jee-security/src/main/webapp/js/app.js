
var app = angular.module('angularjee', ['ngRoute', 'ngResource']);


// ROUTES
app.config(function ($routeProvider, $httpProvider) {
    $routeProvider

            //customer
            .when('/customers/new', {
                templateUrl: 'customer_mgmt.html'
            })
            .when('/customers/:cid/edit', {
                templateUrl: 'customer_mgmt.html'
            })
            .when('/customers', {
                templateUrl: 'customer_list.html'
            });

});


