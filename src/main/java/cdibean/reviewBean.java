/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import restClient.adminClient;
import restClient.userClient;
import Entity.ReviewTable;
import Entity.UserTable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author SHYAM
 */
@Named(value = "reviewBean")
@Dependent
public class reviewBean {
    
    adminClient ac = new adminClient();
    userClient uc = new userClient();
    int id;
    String emailid;
    String description;
    Response rs;
    Collection<ReviewTable> review;
    GenericType<Collection<ReviewTable>> greview;
    /**
     * Creates a new instance of reviewBean
     */
    public reviewBean() {
        ac = new adminClient();
        uc = new userClient();
        review = new ArrayList();
        greview = new GenericType<Collection<ReviewTable>>() {};
        
    }
    
    public String insertReview()
    {
        if(uc != null){
        uc.insertReview(emailid, description);
        }
        return "displayreview";
    }
      public Collection<ReviewTable> getallReviews(){
        
          rs = ac.getAllReviews(Response.class);
            review = rs.readEntity(greview);

            
        return review;
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

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
