package com.github.surajchhetry.angularjeesecurity.customers.boundary;

import com.github.surajchhetry.angularjeesecurity.customers.control.CustomerManager;
import com.github.surajchhetry.angularjeesecurity.customers.entity.Customer;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author surajchhetry
 */
@Path("customers")
public class CustomerResource {

    @Inject
    private CustomerManager customerManager;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        return Response.ok(customerManager.findAll()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer customer) {
        if (this.customerManager.findById(customer.getCid()) != null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        this.customerManager.add(customer);
        return Response.ok().build();
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer customer) {
        this.customerManager.update(customer);
        return Response.ok().build();
    }

    @GET
    @Path("{cid}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("cid") String cid) {
        return Response.ok(customerManager.findById(cid)).build();
    }

}
