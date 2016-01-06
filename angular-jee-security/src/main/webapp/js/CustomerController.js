app.controller('CustomerController', function ($scope, $location, $routeParams, CustomerService) {

    var self = this;
    self.customers = [];
    self.customer = {cid: '', name: '', phone: ''};


    self.fetchAllLocations = function () {
        CustomerService.fetchAllCustomer()
                .then(
                        function (d) {
                            self.customers = d;
                            console.log(self.customers);
                        },
                        function (errResponse) {
                            console.error('Error while fetching customers');
                        }
                );
    };
    self.readCustomer = function (cid) {
        CustomerService.getCustomer(cid)
                .then(
                        function (d) {
                            self.customer = d;
                            console.log(self.customer);
                        },
                        function (errResponse) {
                            console.error('Error while fetching customer');
                        }
                );
    };

    self.addCustomer = function () {
        CustomerService.createCustomer(self.customer)
                .then(
                        function (d) {
                            $location.path('/customers');
                        },
                        function (errResponse) {
                            console.error('Error while adding customer');
                        }
                );
    };
    self.updateCustomer = function () {
        CustomerService.updateCustomer(self.customer)
                .then(
                        function (d) {
                            $location.path('/customers');
                        },
                        function (errResponse) {
                            console.error('Error while updating customer');
                        }
                );
    };

    self.submit = function () {
        if (!self.customer.cid) {
            self.addCustomer();
        } else {
            self.updateCustomer();
        }
    };
    if ($routeParams.cid) {
        self.readCustomer($routeParams.cid);
    } else {
        //call default function
        self.fetchAllLocations();
    }
});

