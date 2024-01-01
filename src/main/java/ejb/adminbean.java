/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;//
import javax.persistence.TypedQuery;

/**
 *
 * @author SHYAM
 */
@Stateless
public class adminbean implements adminbeanLocal {
    
    @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    //done
    @Override
    public void insertproperty(String title, String Type, String description, String state_name, String city_name, String fulladdress, String image1, String image2, String image3, String image4, String listingdate, String conatctno, String emailid, String price,int property_mster_id) {
        PropertyMster pm = em.find(PropertyMster.class, property_mster_id);
       
       
       PropertyTable pt = new PropertyTable();
       pt.setTitle(title);
       pt.setType(Type);
       pt.setDescription(description);
       pt.setStateName(state_name);
       pt.setCityName(city_name);
       pt.setFulladdress(fulladdress);
       pt.setImage1(image1);
       pt.setImage2(image2);
      // pt.setImage3(image3);
       pt.setImage3(image3);
       pt.setImage4(image4);
       pt.setListingdate(listingdate);
       pt.setConatctno(conatctno);
       pt.setEmailid(emailid);
       pt.setPrice(price);
       pt.setStatus(0);
       pt.setRoleId(pm);
       
       em.persist(pt);
    }

    //done
    @Override
    public void deleteProperty(int p_id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         PropertyTable pt = em.find(PropertyTable.class, p_id);
         em.remove(pt);
    }

    //done
    @Override
    public Collection<UserTable> getAllUserCollection() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return em.createNamedQuery("UserTable.findAll").getResultList();
    }
    //done
    @Override
    public Collection<ReviewTable> getAllReview() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("ReviewTable.findAll").getResultList();
    }
    //done
    @Override
    public Collection<BookingTable> getAllBookingCollection() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       return em.createNamedQuery("BookingTable.findAll").getResultList();
    }
    //done
    @Override
    public Collection<PaymentTable> getAllPaymentCollection() {
        return em.createNamedQuery("PaymentTable.findAll").getResultList();
    }
    
    @Override
    public void insertstate(String state, int status) {
         StateTable st = new StateTable();
       
       st.setStateName(state);
       st.setStateStatus(1);
       
       em.persist(st);
    }

    @Override
    public void updatestat(int id, String state, int status) {
         StateTable st = em.find(StateTable.class, id);
     
     st.setStateName(state);
     st.setStateStatus(status);
     
     em.merge(st);
    }
    //done
    @Override
    public void deletestate(int id) {
         StateTable st = em.find(StateTable.class, id);
       
       em.remove(st);
    }
    //done
    @Override
    public Collection<StateTable> getAllStateCollection() {
        return em.createQuery("SELECT s FROM StateTable s", StateTable.class).getResultList();
    }

    @Override
    public void insertcity(int state_id, String name, int status) {
         StateTable stat = em.find(StateTable.class, state_id);
       CityTable ct = new CityTable();
       
       ct.setStateId(stat);
       ct.setCityName(name);
       ct.setCityStatus(1);
       
       em.persist(ct);
    }

    @Override
    public void updatecity(int id, int state_id, String name, int status) {
         StateTable stat = em.find(StateTable.class, state_id);
       Collection<CityTable> cities = stat.getCityTableCollection();
       
       CityTable city = em.find(CityTable.class, id);
       
       if(cities.contains(city)){
       
           city.setStateId(stat);
           city.setCityName(name);
           city.setCityStatus(status);
           
           em.merge(city);
       }
    }
    //done
    @Override
    public void deletecity(int id, int state_id) {
        StateTable stat = em.find(StateTable.class, state_id);
       Collection<CityTable> cities = stat.getCityTableCollection();
       
       CityTable city = em.find(CityTable.class, id);
       
       if(cities.contains(city)){
       
           em.remove(city);
        }
    }
    //done
    @Override
    public Collection<CityTable> getAllCityCollection() {
       return em.createNamedQuery("CityTable.findAll").getResultList();
    }
    //done
    @Override
    public void insertrole(String role) {
         PropertyMster pm = new PropertyMster();
       
       pm.setRole(role);
       em.persist(pm);
    }
    //done
    @Override
    public PropertyTable searchPropertyById(int p_id) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       PropertyTable  pt = em.find(PropertyTable.class, p_id);
        return pt;
    }
    //done
    @Override
    public void updateproperty(int p_id, String title, String Type, String description, String state_name, String city_name, String fulladdress, String image1, String image2, String image3, String image4, String listingdate, String conatctno, String emailid, String price, int status,int property_mster_id) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     PropertyTable pt = em.find(PropertyTable.class, p_id);
     PropertyMster pmt = em.find(PropertyMster.class, property_mster_id);
     
       pt.setTitle(title);
       pt.setType(Type);
       pt.setDescription(description);
       pt.setStateName(state_name);
       pt.setCityName(city_name);
       pt.setFulladdress(fulladdress);
       pt.setImage1(image1);
       pt.setImage2(image2);
       pt.setImage3(image3);
       pt.setImage3(image3);
       pt.setImage4(image4);
       pt.setListingdate(listingdate);
       pt.setConatctno(conatctno);
       pt.setEmailid(emailid);
       pt.setPrice(price);
       pt.setStatus(1);
       pt.setRoleId(pmt);
       
       em.merge(pt);
    }
    
    @Override
    public UserTable searchUserById(String e_id) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       UserTable ut = em.find(UserTable.class, e_id);
       return ut;
    }

    @Override
    public Collection<String> getallStateName() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        TypedQuery<String> query = em.createQuery("SELECT s.stateName FROM StateTable s", String.class);
        return query.getResultList();
    }


    @Override
    public Collection<CityTable> getCitiesByState(String stateName) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           Query query = em.createQuery("SELECT c FROM CityTable c JOIN c.stateId s WHERE s.stateName = :stateName");
        query.setParameter("stateName", stateName);
        return query.getResultList();
    }

    @Override
    public Collection<String> getAllRoleCollection() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      TypedQuery<String> query = em.createQuery("SELECT p FROM PropertyMster p", String.class);
        return query.getResultList();
    }

    @Override
    public void updateStatus(int bid, int Status) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BookingTable book = em.find(BookingTable.class, bid);

        if (book != null) {
            // Update the status to 'approve'
            book.setStatus(1);
            em.merge(book); // Merge the changes into the database
        }else{
            System.out.println("Data Not Approved..");
        }
    }

    @Override
    public BookingTable searchbyBookingid(int bid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.find(BookingTable.class, bid);
    }

    @Override
    public void deletestatus(int bid, int Status) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         BookingTable book = em.find(BookingTable.class, bid);

        if (book != null) {
            // Update the status to 'approve'
            book.setStatus(2);
            em.merge(book); // Merge the changes into the database
        }else{
            System.out.println("Data Not Approved..");
        } 
    }

    @Override
    public Collection<PropertyMster> getAllrole() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("PropertyMster.findAll").getResultList();
       
    }

    @Override
    public void deleteRole(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       PropertyMster pmt = em.find(PropertyMster.class, id);
        em.remove(pmt);
        
    }

    @Override
    public void hideProperty(int pid, int Status) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          PropertyTable pt = em.find(PropertyTable.class, pid);

        if (pt != null) {
            // Update the status to 'approve'
            pt.setStatus(1);
            em.merge(pt); // Merge the changes into the database
        }else{
            System.out.println("Data Not Approved..");
        } 
    }

    @Override
    public Collection<BookingTable> getBookingByStatus(int status) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         TypedQuery<BookingTable> query = em.createQuery(
                "SELECT b FROM BookingTable b WHERE b.status = :status", BookingTable.class);
            query.setParameter("status", status);
        
        return query.getResultList();
    }

    @Override
    public Long countAllUsers() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM UserTable u",
                Long.class
        );
        Long userCount = query.getSingleResult();
        System.out.println("Total Users: " + userCount);

        // Perform any other actions with the userCount if needed
        return userCount; // Return the user count
    }

    @Override
    public Long countAllProperty() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM PropertyTable u",
                Long.class
        );
        Long propertyCount = query.getSingleResult();
        System.out.println("Total Property: " + propertyCount);

        // Perform any other actions with the userCount if needed
        return propertyCount; // Return the user count
        
    }

    @Override
    public Long countAllBooking() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM BookingTable u",
                Long.class
        );
        Long bookingCount = query.getSingleResult();
        System.out.println("Total Booking: " + bookingCount);

        // Perform any other actions with the userCount if needed
        return bookingCount; // Return the user count
     
    }

    @Override
    public Long countAllBrand() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM PropertyMster u",
                Long.class
        );
        Long brandCount = query.getSingleResult();
        System.out.println("Total Booking: " + brandCount);

        // Perform any other actions with the userCount if needed
        return brandCount; // Return the user count
    }
    
}
