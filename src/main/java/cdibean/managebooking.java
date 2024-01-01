/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import restClient.adminClient;
import restClient.userClient;
import Entity.BookingTable;
import ejb.adminbeanLocal;
import ejb.userbeanLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author SHYAM
 */
@Named(value = "managebooking")
@RequestScoped
public class managebooking implements Serializable {

    @EJB
    adminbeanLocal abl;
    @EJB
    userbeanLocal ubl;
    adminClient ac = new adminClient();
    userClient uc = new userClient();
    Collection<BookingTable> status1Bookings;
    Collection<BookingTable> status2Bookings;
    Response rs;
    Integer bid;
    String pid;
    String emailid;
    String bookingdate;
    String price;
    String b_price;
    String details;
    Integer status;
    String Status;
    String p_id;
    String message;

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    Collection<BookingTable> book;
    GenericType<Collection<BookingTable>> gbook;

    /**
     * Creates a new instance of managebooking
     */
    public managebooking() {

        ac = new adminClient();
        book = new ArrayList();
        gbook = new GenericType<Collection<BookingTable>>() {

        };
    }

    public Collection<BookingTable> getallBooking() {
        rs = ac.getAllBookings(Response.class);
        book = rs.readEntity(gbook);
        return book;
    }

    public void insertBooking() {
        try {
            if (this.p_id != null && !this.p_id.isEmpty()) {
                int parsedPId = Integer.parseInt(this.p_id);

                // Add null checks before calling the method
                if (emailid != null && bookingdate != null && price != null && b_price != null && details != null && Status != null) {
                   uc.insertBooking(p_id, p_id, bookingdate, price, b_price, details);
                    System.out.println("Booking inserted successfully");
                } else {
                    System.err.println("One or more required fields are null. Please provide valid data.");
                }

                System.out.println("p_id: " + parsedPId);
                System.out.println("emailid: " + emailid);
                System.out.println("bookingdate: " + bookingdate);
                System.out.println("price: " + price);
                System.out.println("b_price: " + b_price);
                System.out.println("details: " + details);
                System.out.println("status: " + status);
            } else {
                System.err.println("p_id is null or empty. Please provide a valid p_id.");
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing p_id as an integer");
            // Handle the error as needed
        }

    }

    public void searchbooking(int bookid) {
        rs = ac.searchbybookingid(Response.class, bookid + "");
        GenericType<BookingTable> gstate = new GenericType<BookingTable>() {
        };
        BookingTable cc = rs.readEntity(gstate);
        bid = cc.getBId();
        status = cc.getStatus();
        approvedbooking();

    }
    
    public String serachstatus(int bookid)
    {
        rs = ac.searchbybookingid(Response.class, bookid+"");
          GenericType<BookingTable> gstate = new GenericType<BookingTable>() {
        };
        BookingTable cc = rs.readEntity(gstate);
        bid = cc.getBId();
        
        status = cc.getStatus();
        
        if(status == 1)
        {
            System.out.print("booking successful");
            return "booking successful";
        }
        else
        {
            
        }
        return "success";
    }
      @PostConstruct
    public void retriveuser() {
        // Initialize the book collection during bean initialization
        retrieveUserBookings();
    }
    
     public void retrieveUserBookings() {
         
         FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        String AdminEmail = (String) session.getAttribute("Admin");
        String UserEmail = (String) session.getAttribute("User");

        if (uc != null) {
            if (AdminEmail == null) {
                book = ubl.getUserBookings(UserEmail);
            } else {
              book = ubl.getUserBookings(AdminEmail);
            }
        }
        
     }
     
     
    public String approvedbooking() {
        BookingTable bt = new BookingTable();
        bt.setBId(bid);
        bt.setStatus(1);
        abl.updateStatus(bid, status);
        
        return "confirmbooking.jsf?faces-redirect=true";
    }

    public void searchbookingcancel(int bookid) {
        rs = ac.searchbybookingid(Response.class, bookid + "");
        GenericType<BookingTable> gstate = new GenericType<BookingTable>() {
        };
        BookingTable cc = rs.readEntity(gstate);
        bid = cc.getBId();
        status = cc.getStatus();
        cancelbooking();

    }

    public String cancelbooking() {
        BookingTable bt = new BookingTable();
        bt.setBId(bid);
        bt.setStatus(2);
        abl.deletestatus(bid, status);
        return "newbooking.jsf?faces-redirect=true";
    }

    public void init() {
        status1Bookings = abl.getBookingByStatus(1);
        status2Bookings = abl.getBookingByStatus(2);
    }
    
    public void notfyUser(String message)
    {
       this.message = message;
    }

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }

    public userClient getUc() {
        return uc;
    }

    public void setUc(userClient uc) {
        this.uc = uc;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getB_price() {
        return b_price;
    }

    public void setB_price(String b_price) {
        this.b_price = b_price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Collection<BookingTable> getBook() {
        return book;
    }

    public void setBook(Collection<BookingTable> book) {
        this.book = book;
    }

    public GenericType<Collection<BookingTable>> getGbook() {
        return gbook;
    }

    public void setGbook(GenericType<Collection<BookingTable>> gbook) {
        this.gbook = gbook;
    }

    public Collection<BookingTable> getStatus1Bookings() {
        return status1Bookings;
    }

    public void setStatus1Bookings(Collection<BookingTable> status1Bookings) {
        this.status1Bookings = status1Bookings;
    }

    public Collection<BookingTable> getStatus2Bookings() {
        return status2Bookings;
    }

    public void setStatus2Bookings(Collection<BookingTable> status2Bookings) {
        this.status2Bookings = status2Bookings;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

}
