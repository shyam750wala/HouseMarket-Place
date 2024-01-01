/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import Entity.BookingTable;
import Entity.CityTable;
import Entity.PaymentTable;
import Entity.PropertyMster;
import Entity.PropertyTable;
import Entity.ReviewTable;
import Entity.StateTable;
import Entity.UserTable;
import ejb.adminbeanLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author SHYAM
 */
@Path("sampleadmin")
@RequestScoped
public class restAdmin {

    @EJB
    private adminbeanLocal adminBean;

    @POST
    @Path("/insertproperty/{title}/{Type}/{description}/{state_name}/{city_name}/{fulladdress}/{image1}/{image2}/{image3}/{image4}/{listingdate}/{conatctno}/{emailid}/{price}/{property_mster_id}")
    public void insertProperty(@PathParam("title") String title,
                               @PathParam("Type") String Type,
                               @PathParam("description") String description,
                               @PathParam("state_name") String state_name,
                               @PathParam("city_name") String city_name,
                               @PathParam("fulladdress") String fulladdress,
                               @PathParam("image1") String image1,
                               @PathParam("image2") String image2,
                               @PathParam("image3") String image3,
                               @PathParam("image4") String image4,
                               @PathParam("listingdate") String listingdate,
                               @PathParam("conatctno") String conatctno,
                               @PathParam("emailid") String emailid,
                               @PathParam("price") String price,
                               @PathParam("property_mster_id") int property_mster_id) {
        adminBean.insertproperty(title, Type, description, state_name, city_name, fulladdress, image1, image2, image3, image4, listingdate, conatctno, emailid, price, property_mster_id);
    }

    @DELETE
    @Path("/deleteProperty/{p_id}")
    public void deleteProperty(@PathParam("p_id") int p_id) {
        adminBean.deleteProperty(p_id);
    }

    @GET
    @Path("/getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserTable> getAllUsers() {
        return adminBean.getAllUserCollection();
    }

    @GET
    @Path("/getAllReviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ReviewTable> getAllReviews() {
        return adminBean.getAllReview();
    }

    @GET
    @Path("/getAllBookings")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<BookingTable> getAllBookings() {
        return adminBean.getAllBookingCollection();
    }

    @GET
    @Path("/getAllPayments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PaymentTable> getAllPayments() {
        return adminBean.getAllPaymentCollection();
    }

    @POST
    @Path("/insertstate/{state}/{status}")
    public void insertState(@PathParam("state") String state,
                            @PathParam("status") int status) {
        adminBean.insertstate(state, status);
    }

    @PUT
    @Path("/updatestate/{id}/{state}/{status}")
    public void updateState(@PathParam("id") int id,
                            @PathParam("state") String state,
                            @PathParam("status") int status) {
        adminBean.updatestat(id, state, status);
    }

    @DELETE
    @Path("/deletestate/{id}")
    public void deleteState(@PathParam("id") int id) {
        adminBean.deletestate(id);
    }

    @GET
    @Path("/getAllStates")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<StateTable> getAllStates() {
        return adminBean.getAllStateCollection();
    }

    @POST
    @Path("/insertcity/{state_id}/{name}/{status}")
    public void insertCity(@PathParam("state_id") int state_id,
                           @PathParam("name") String name,
                           @PathParam("status") int status) {
        adminBean.insertcity(state_id, name, status);
    }

    @PUT
    @Path("/updatecity/{id}/{state_id}/{name}/{status}")
    public void updateCity(@PathParam("id") int id,
                           @PathParam("state_id") int state_id,
                           @PathParam("name") String name,
                           @PathParam("status") int status) {
        adminBean.updatecity(id, state_id, name, status);
    }

    @DELETE
    @Path("/deletecity/{id}/{state_id}")
    public void deleteCity(@PathParam("id") int id,
                           @PathParam("state_id") int state_id) {
        adminBean.deletecity(id, state_id);
    }

    @GET
    @Path("/getAllCities")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CityTable> getAllCities() {
        return adminBean.getAllCityCollection();
    }

    @POST
    @Path("/insertrole/{role}")
    public void insertRole(@PathParam("role") String role) {
        adminBean.insertrole(role);
    }

    @GET
    @Path("/searchPropertyById/{p_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PropertyTable searchPropertyById(@PathParam("p_id") int p_id) {
        return adminBean.searchPropertyById(p_id);
    }

   @PUT
    @Path("/{p_id}/{title}/{Type}/{description}/{state_name}/{city_name}/{fulladdress}/{image1}/{image2}/{image3}/{image4}/{listingdate}/{conatctno}/{emailid}/{price}/{status}/{property_mster_id}")
    public void updateProperty(
            @PathParam("p_id") int p_id,
            @PathParam("title") String title,
            @PathParam("Type") String type,
            @PathParam("description") String description,
            @PathParam("state_name") String state_name,
            @PathParam("city_name") String city_name,
            @PathParam("fulladdress") String fulladdress,
            @PathParam("image1") String image1,
            @PathParam("image2") String image2,
            @PathParam("image3") String image3,
            @PathParam("image4") String image4,
            @PathParam("listingdate") String listingdate,
            @PathParam("conatctno") String conatctno,
            @PathParam("emailid") String emailid,
            @PathParam("price") String price,
            @PathParam("status") int status,
            @PathParam("property_mster_id") int property_mster_id) {
        adminBean.updateproperty(p_id, title, type, description, state_name, city_name, fulladdress, image1, image2, image3, image4, listingdate, conatctno, emailid, price, status, property_mster_id);
    }

    @GET
    @Path("/searchUserById/{e_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserTable searchUserById(@PathParam("e_id") String e_id) {
        return adminBean.searchUserById(e_id);
    }

    @GET
    @Path("/getallStateNames")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<String> getAllStateNames() {
        return adminBean.getallStateName();
    }

    @GET
    @Path("/getCitiesByState/{stateName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<CityTable> getCitiesByState(@PathParam("stateName") String stateName) {
        return adminBean.getCitiesByState(stateName);
    }
    
    @GET
    @Path("/getAllRoles")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<String> getAllRoles() {
        return adminBean.getAllRoleCollection();
    }
    
    @GET
    @Path("/searchbybookingid/{bid}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookingTable searchbybookingid(@PathParam("bid") int bid) {
        return adminBean.searchbyBookingid(bid);
    }
    
     @DELETE
    @Path("/deleterole/{id}")
    public void deleteRole(@PathParam("id") int id) {
        adminBean.deleteRole(id);
    }
    
      @GET
    @Path("/getAllRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PropertyMster> getAllRole() {
        return adminBean.getAllrole();
    }
    
  
}
