/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import Entity.PropertyTable;
import ejb.userbeanLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 * REST Web Service
 *
 * @author SHYAM
 */
@Path("restUser")
@RequestScoped
public class restUser {

    @Context
    private UriInfo context;

    
    @EJB userbeanLocal userBean;
    Pbkdf2PasswordHashImpl pb;
 PasswordHashCompare phc;
    /**
     * Creates a new instance of restUser
     */
    public restUser() {
    }
    
    @GET
    @Path("/properties")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PropertyTable> getAllProperties() {
        return userBean.getAllpropertyCollection();
    }

    @POST
    @Path("/booking/{p_id}/{e_id}/{BookingDate}/{price}/{b_price}/{propertydetails}")
    public void insertBooking(
            @PathParam("p_id") int p_id,
            @PathParam("e_id") String e_id,
            @PathParam("BookingDate") String bookingDate,
            @PathParam("price") String price,
            @PathParam("b_price") String b_price,
            @PathParam("propertydetails") String propertydetails)
    {
        userBean.insertbooking(p_id, e_id, bookingDate, price, b_price, propertydetails);
    }

    @POST
    @Path("/payment/{b_id}/{e_id}/{date}/{price}/{status}")
    public void insertPayment(
            @PathParam("b_id") int b_id,
            @PathParam("e_id") String e_id,
            @PathParam("date") String date,
            @PathParam("price") String price,
            @PathParam("status") int status) {
        userBean.insertpayment(b_id, e_id, date, price, status);
    }

    @POST
    @Path("/review/{e_id}/{description}")
    public void insertReview(
            @PathParam("e_id") String e_id,
            @PathParam("description") String description) {
        userBean.insertReview( e_id, description);
    }

    @POST
    @Path("/insert/{emailid}/{fname}/{lname}/{contactno}/{password}")
    public void insertUser(
            @PathParam("emailid") String emailid,
            @PathParam("fname") String fname,
            @PathParam("lname") String lname,
            @PathParam("contactno") String contactno,
            @PathParam("password") String password)
            
    {
        pb = new Pbkdf2PasswordHashImpl();
            phc= new PasswordHashCompare();
             String enc = pb.generate(password.toCharArray());
         userBean.insertUser(emailid, fname, lname, contactno, enc);
    }
    
    
    
    @GET
    @Path("/byRole/{role}")
    @Produces("application/json")
    public Collection<PropertyTable> getPropertiesByRole(@PathParam("role") String role) {
        return userBean.getrolebyproperty(role);
    }
    
    @PUT
    @Path("/updatepassword/{email}/{password}")
    public void updatePasswordByEmail(@PathParam("email") String email, @PathParam("password") String password){
    
             pb = new Pbkdf2PasswordHashImpl();
             phc= new PasswordHashCompare();
             String enc = pb.generate(password.toCharArray());
             userBean.updatepasswordbyemail(email, enc);
    
    }
    
    @GET
    @Path("getPropertyByStatus")
    @Produces(MediaType.APPLICATION_JSON)
      public Collection<PropertyTable> getPropertyByStatus() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return userBean.getPropertyByStatus();
        
        
    }
    
    
    
    
}
