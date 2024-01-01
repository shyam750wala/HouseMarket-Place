/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import Entity.PaymentTable;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import restClient.adminClient;

/**
 *
 * @author SHYAM
 */
@Named(value = "paymentBean")
@RequestScoped
public class paymentBean {
    
    adminClient ac = new adminClient();
    Response rs;
    Integer payment_id;
    String pid;
    String emailid;
    String date;
    String price;
    String status;
    Collection<PaymentTable>payment;
    GenericType<Collection<PaymentTable>>gpayment;
    
            

    /**
     * Creates a new instance of paymentBean
     */
    public paymentBean() {
        ac = new adminClient();
        payment = new ArrayList();
        gpayment = new GenericType<Collection<PaymentTable>>() {
         
        };
    }
     public Collection<PaymentTable> getAllPayment(){
     
         rs = ac.getAllPayments(Response.class);
         payment =rs.readEntity(gpayment);
         return payment;
         
     }

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<PaymentTable> getPayment() {
        return payment;
    }

    public void setPayment(Collection<PaymentTable> payment) {
        this.payment = payment;
    }

    public GenericType<Collection<PaymentTable>> getGpayment() {
        return gpayment;
    }

    public void setGpayment(GenericType<Collection<PaymentTable>> gpayment) {
        this.gpayment = gpayment;
    }

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }
     
}
