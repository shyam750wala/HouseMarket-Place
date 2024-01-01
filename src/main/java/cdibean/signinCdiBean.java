/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import Entity.UserTable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SHYAM
 */
@Named(value = "signinCdiBean")
@RequestScoped
public class signinCdiBean {
    
    @PersistenceContext
    EntityManager em;
    
    
    String emailid;
    String password;
   
    
    /**
     * Creates a new instance of signinCdiBean
     */
    public signinCdiBean() {
    }
    
       public String login() {
           
        try {
            Query query = em.createQuery("SELECT u FROM UserTable u WHERE u.emailId = :email AND u.password = :password");
            query.setParameter("email", emailid);
            query.setParameter("password", password);

            UserTable user = (UserTable) query.getSingleResult();
            if (user != null) {
                System.out.println("Login successful");
                return "property.jsf"; // Redirect to the success page
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid emailid and password", "Invalid Emailid and password"));
                System.out.println("Login failed: User not found");
                // Handle login failure (e.g., display an error message)
                return null;
            }
        } catch (NoResultException e) {
            System.out.println("Login failed: No result found");
            // Handle login failure (e.g., display an error message)
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions (e.g., database connection issues)
            return null;
        }
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
