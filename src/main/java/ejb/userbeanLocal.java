/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;


import Entity.BookingTable;
import Entity.PropertyTable;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author SHYAM
 */
@Local
public interface userbeanLocal {
    
    
    public Collection<PropertyTable> getPropertyByStatus();
    
    //Show Property
    public Collection<PropertyTable> getAllpropertyCollection();
    
    //for Booking
    
    public void insertbooking(int p_id,String e_id,String BookingDate,String price,String b_price,String propertydetails);
    
    //Display Booking Userwise
   // public Collection<BookingTable> getBooktoUser(String e_id);
    
    //payment
     public void insertpayment(int b_id,String e_id,String date,String price,int status);
     
    //Review
     
     public void insertReview(String e_id,String description);
     
     //user registertraion
     public void insertUser(String emailid,String fname,String lname,String contactno,String password);
     
     //Get propertyBy its  role
     
      public Collection<PropertyTable> getrolebyproperty(String role);
    
      
    public void updatepasswordbyemail(String email,String password);
    
    public Collection<BookingTable> getUserBookings(String emailId);
    
    
}
