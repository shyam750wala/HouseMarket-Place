/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import restClient.userClient;
import Entity.ReviewTable;
import Entity.UserTable;
import ejb.adminbeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.PasswordHashCompare;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author SHYAM
 */
@Named(value = "registrationBean")
@RequestScoped
public class registrationBean {
    
    
    @EJB
    adminbeanLocal abl;
    @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    Pbkdf2PasswordHashImpl pb;
    PasswordHashCompare phc;
    userClient uc = new userClient();
    String emailid;
    String fname;
    String lname;
    String contactno;
    String password;
    String updatedpassword;
    String description;
    Collection<UserTable> users;
    GenericType<Collection<UserTable>> gusers;
    Response rs;
    Collection<ReviewTable> review;
    GenericType<Collection<ReviewTable>> greview;

    /**
     * Creates a new instance of registrationBean
     */
    public registrationBean() {

        pb = new Pbkdf2PasswordHashImpl(); // or initialize with appropriate parameters
        phc = new PasswordHashCompare(); // or initialize with appropriate parameters
        uc = new userClient();
        users = new ArrayList();
        gusers = new GenericType<Collection<UserTable>>() {
        };
        review = new ArrayList();
        greview = new GenericType<Collection<ReviewTable>>() {
        };
    }

    public String registration() {
        uc.insertUser(emailid, fname, lname, contactno, password);
        return "Login.jsf";
    }

    public String updatepassword() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        String Email = (String) session.getAttribute("Admin");
        String enc = pb.generate(updatedpassword.toCharArray());
        uc.updatePasswordByEmail(Email, enc);
        System.out.println(password);
        return "home.jsf";
    }

    public String checkEmail() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        String Email = (String) session.getAttribute("Admin");
        System.err.println(Email);
        if (Email == null) {
            // Redirect to the login page
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/Login.jsf");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception as needed
            }
            return "/Login.jsf?faces-redirect=true";
        }
        return "successOutcome";
    }

    public Long fetchCountUsers() {

        Long usersCount = abl.countAllUsers();
        return usersCount;
    }

    public Long fetchCountProperty() {

        Long propertyCount = abl.countAllProperty();
        return propertyCount;
    }

    public Long fetchCountBooking() {

        Long bookingCount = abl.countAllBooking();
        return bookingCount;
    }

    public Long fetchCountBrand() {

        Long brandCount = abl.countAllBrand();
        return brandCount;
    }

    public String insertReview() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        String AdminEmail = (String) session.getAttribute("Admin");
        String UserEmail = (String) session.getAttribute("User");

        if (uc != null) {
            if (AdminEmail == null) {
                uc.insertReview(UserEmail, description);
            } else {
                uc.insertReview(AdminEmail, description);
            }
        }
        return "home.jsf";
    }

    public String logout()
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            request.getSession().invalidate();
            
            return "/Login.jsf?faces-redirect=true";
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public String getUpdatedpassword() {
        return updatedpassword;
    }

    public void setUpdatedpassword(String updatedpassword) {
        this.updatedpassword = updatedpassword;
    }

    public Collection<ReviewTable> getReview() {
        return review;
    }

    public void setReview(Collection<ReviewTable> review) {
        this.review = review;
    }

    public GenericType<Collection<ReviewTable>> getGreview() {
        return greview;
    }

    public void setGreview(GenericType<Collection<ReviewTable>> greview) {
        this.greview = greview;
    }

    public userClient getUc() {
        return uc;
    }

    public void setUc(userClient uc) {
        this.uc = uc;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
