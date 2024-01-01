/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import restClient.adminClient;
import restClient.userClient;

import Entity.UserTable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
/**
 *
 * @author SHYAM
 */
@Named(value = "userCdiBean")
@RequestScoped
public class userCdiBean {
    
    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare phc;
    userClient uc = new userClient();
    adminClient ac = new adminClient();
    Response rs;
    Collection<UserTable> users;
    GenericType<Collection<UserTable>> gusers;
    String email_id;
    String fname;
    String lname;
    String contactno;
    String password;
    String p_id;
    String booking_date;
    String price;
    String b_price;
    String details;
    String status;
    
    

  
    public userCdiBean() {
        
        pb = new Pbkdf2PasswordHashImpl();
        phc= new PasswordHashCompare();
        uc = new userClient();
        users = new ArrayList();
        gusers = new GenericType<Collection<UserTable>>() {
            
        };
        
    }
    
    
    public String insertUser()
            
    {
         String encpassword = pb.generate("password".toCharArray());
         uc.insertUser(email_id, fname, lname, contactno, encpassword);
         return "signin.jsf";
         
    }
    
    public Collection<UserTable> getallUsers(){
        
          rs = ac.getAllUsers(Response.class);
            users = rs.readEntity(gusers);

            for (UserTable user : users) {
            System.out.println(user.getEmailId());


        }
        return users;
    }

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
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
    
    
    
    
    public Pbkdf2PasswordHashImpl getPb() {
        return pb;
    }

    public void setPb(Pbkdf2PasswordHashImpl pb) {
        this.pb = pb;
    }

    public PasswordHashCompare getPhc() {
        return phc;
    }

    public void setPhc(PasswordHashCompare phc) {
        this.phc = phc;
    }    
    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Collection<UserTable> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserTable> users) {
        this.users = users;
    }

    public GenericType<Collection<UserTable>> getGusers() {
        return gusers;
    }

    public void setGusers(GenericType<Collection<UserTable>> gusers) {
        this.gusers = gusers;
    }
    
}
