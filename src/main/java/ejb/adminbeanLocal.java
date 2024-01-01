/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import Entity.BookingTable;
import Entity.CityTable;
import Entity.PaymentTable;
import Entity.PropertyMster;
import Entity.PropertyTable;
import Entity.ReviewTable;
import Entity.StateTable;
import Entity.UserTable;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author SHYAM
 */
@Local
public interface adminbeanLocal {
 
    //Property Table
    public void insertproperty(String title,String Type, String description,String state_name,String city_name,String fulladdress,String image1,
    String image2,String image3,String image4,String listingdate,String conatctno, String emailid,String price,int property_mster_id);
     
    public void updateproperty(int p_id, String title,String Type, String description,String state_name,String city_name,String fulladdress,String image1,
    String image2,String image3,String image4,String listingdate,String conatctno, String emailid,String price,int status,int property_mster_id);
     
    public void deleteProperty(int p_id);
    
    public PropertyTable searchPropertyById(int p_id);
    
    
    //Show User Data
    
    public Collection<UserTable> getAllUserCollection();
    
    public UserTable searchUserById(String e_id);
    
    // Show Review User
    
    public Collection<ReviewTable> getAllReview();
    
    // Show user Booking
    
    public Collection<BookingTable> getAllBookingCollection();
     
    //Show user payment
    
    public Collection<PaymentTable> getAllPaymentCollection();
    
    //statetable
    public void insertstate(String state , int status);
    public void updatestat(int id,String state,int status);
    public void deletestate(int id);
    public Collection<StateTable> getAllStateCollection();
    
    //cityTable
    public void insertcity(int state_id,String name,int status);
    public void updatecity(int id,int state_id,String name, int status);
    public void deletecity(int id,int state_id);
    public Collection<CityTable> getAllCityCollection( );
    
    //user_role
    public void insertrole(String role);
    
    public Collection<PropertyMster> getAllrole();
    
    public void deleteRole(int id);
    
    
    //getAllStatename
    public Collection<String> getallStateName();
     
    //getCityname according to state
    
//   public Collection<CityTable> getCitiesByState(int state_id);
    
    public Collection<CityTable> getCitiesByState(String stateName);
    
    public Collection<String> getAllRoleCollection();
    
    public void updateStatus(int bid,int Status);
    
    
    public BookingTable searchbyBookingid(int bid);
    
     public void deletestatus(int bid,int Status);
     
     
     public void hideProperty(int pid,int Status);
     
     public Collection<BookingTable> getBookingByStatus(int status);
     
     public Long countAllUsers();
     
      public Long countAllProperty();
      
       public Long countAllBooking();
       
       public Long countAllBrand();
     
   
}
