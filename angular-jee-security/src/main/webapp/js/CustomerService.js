app.factory('CustomerService', ['$http', '$q', function ($http, $q) {
        var self = this;
        self.baseurl = "resources/customers";
        return {
            // Fetch Customer list
            fetchAllCustomer: function () {
                console.log("inside fetchAllCustomer...");
                return $http.get(self.baseurl)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while fetching customer');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            // Create Customer
            createCustomer: function (customer) {
                return $http.post(self.baseurl, customer)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while createCustomer');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            //Update Customer
            updateCustomer: function (customer) {
                return $http.put(self.baseurl, customer)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while updating customer');
                                    return $q.reject(errResponse);
                                }
                        );
            },
            //read user
            getCustomer: function (cid)
            {
                return $http.get(self.baseurl + "/" + cid)
                        .then(
                                function (response) {
                                    return response.data;
                                },
                                function (errResponse) {
                                    console.error('Error while reading customer');
                                    return $q.reject(errResponse);
                                }
                        );
            }

        };
    }]);