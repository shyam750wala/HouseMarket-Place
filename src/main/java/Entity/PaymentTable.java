/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SHYAM
 */
@Entity
@Table(name = "payment_table")
@NamedQueries({
    @NamedQuery(name = "PaymentTable.findAll", query = "SELECT p FROM PaymentTable p"),
    @NamedQuery(name = "PaymentTable.findByPId", query = "SELECT p FROM PaymentTable p WHERE p.pId = :pId"),
    @NamedQuery(name = "PaymentTable.findByDate", query = "SELECT p FROM PaymentTable p WHERE p.date = :date"),
    @NamedQuery(name = "PaymentTable.findByPrice", query = "SELECT p FROM PaymentTable p WHERE p.price = :price"),
    @NamedQuery(name = "PaymentTable.findByStatus", query = "SELECT p FROM PaymentTable p WHERE p.status = :status")})
public class PaymentTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id")
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "b_id", referencedColumnName = "b_id")
    @ManyToOne(optional = false)
    private BookingTable bId;
    @JoinColumn(name = "email_id", referencedColumnName = "email_id")
    @ManyToOne(optional = false)
    private UserTable emailId;

    public PaymentTable() {
    }

    public PaymentTable(Integer pId) {
        this.pId = pId;
    }

    public PaymentTable(Integer pId, String date, String price, int status) {
        this.pId = pId;
        this.date = date;
        this.price = price;
        this.status = status;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BookingTable getBId() {
        return bId;
    }

    public void setBId(BookingTable bId) {
        this.bId = bId;
    }

    public UserTable getEmailId() {
        return emailId;
    }

    public void setEmailId(UserTable emailId) {
        this.emailId = emailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pId != null ? pId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTable)) {
            return false;
        }
        PaymentTable other = (PaymentTable) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.PaymentTable[ pId=" + pId + " ]";
    }
    
}
