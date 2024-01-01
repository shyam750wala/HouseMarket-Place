/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import Entity.BookingTable;
import Entity.PaymentTable;
import Entity.PropertyTable;
import Entity.ReviewTable;
import Entity.RoleMstr;
import Entity.UserTable;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author SHYAM
 */
@Stateless
public class userbean implements userbeanLocal {

    @PersistenceContext(unitName = "jpapu")
    EntityManager em;

    @Override
    public Collection<PropertyTable> getAllpropertyCollection() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return em.createNamedQuery("PropertyTable.findAll").getResultList();
    }
     @Override
     public Collection<PropertyTable> getPropertyByStatus() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         TypedQuery<PropertyTable> query = em.createQuery(
                "SELECT p FROM PropertyTable p WHERE p.status = 0", PropertyTable.class);
         
        
        return query.getResultList();
        
        
    }

    @Override
    public void insertbooking(int p_id, String e_id, String BookingDate, String price, String b_price, String propertydetails) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        PropertyTable pt = em.find(PropertyTable.class, p_id);
        UserTable ut = em.find(UserTable.class, e_id);

        BookingTable bt = new BookingTable();
        bt.setPId(pt);
        bt.setEmailId(ut);
        bt.setBookingDate(BookingDate);
        bt.setPrice(price);
        bt.setBeadingPrice(b_price);
        bt.setDetails(propertydetails);
        bt.setStatus(0);

        em.persist(bt);

    }

    @Override
    public void insertpayment(int b_id, String e_id, String date, String price, int status) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        BookingTable bt = em.find(BookingTable.class, b_id);
        UserTable ut = em.find(UserTable.class, e_id);

        PaymentTable pmt = new PaymentTable();

        pmt.setBId(bt);
        pmt.setEmailId(ut);
        pmt.setDate(date);
        pmt.setPrice(price);
        pmt.setStatus(status);

        em.persist(pmt);
    }

    @Override
    public void insertReview( String e_id, String description) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        UserTable ut = em.find(UserTable.class, e_id);
        // Collection<ReviewTable> rt = ut.getReviewTableCollection();

        ReviewTable rt = new ReviewTable();
        rt.setEmailId(ut);
        rt.setDescription(description);

        em.persist(rt);
    }

    
    @Override
    public Collection<PropertyTable> getrolebyproperty(String role) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
         Query query = em.createQuery("SELECT p FROM PropertyTable p JOIN p.roleId s WHERE s.role = :role");
        query.setParameter("role",role );
        return query.getResultList();
    }

    @Override
    public void insertUser(String emailid, String fname, String lname, String contactno, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     RoleMstr rm = em.find(RoleMstr.class, 2);
     
     UserTable ut = new UserTable();
     
     ut.setEmailId(emailid);
     ut.setFname(fname);
     ut.setLname(lname);
     ut.setContactNo(contactno);
     ut.setPassword(password);
     ut.setRoleId(rm);
     
     em.persist(ut);
    }

    @Override
    public void updatepasswordbyemail(String email,String password) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       try {
            UserTable ut = em.find(UserTable.class, email);
            ut.setPassword(password);
            em.merge(ut);
        } catch (Exception e) {
            System.out.println("Password not updated...");
        }

    }

    @Override
    public Collection<BookingTable> getUserBookings(String emailId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       TypedQuery<BookingTable> query = em.createQuery(
            "SELECT b FROM BookingTable b WHERE b.emailId.emailId = :emailId", BookingTable.class);
    query.setParameter("emailId", emailId);
    return query.getResultList();
    }

   

  

   

}
