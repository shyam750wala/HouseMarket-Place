/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SHYAM
 */
@Entity
@Table(name = "user_table")
@NamedQueries({
    @NamedQuery(name = "UserTable.findAll", query = "SELECT u FROM UserTable u"),
    @NamedQuery(name = "UserTable.findByEmailId", query = "SELECT u FROM UserTable u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "UserTable.findByFname", query = "SELECT u FROM UserTable u WHERE u.fname = :fname"),
    @NamedQuery(name = "UserTable.findByLname", query = "SELECT u FROM UserTable u WHERE u.lname = :lname"),
    @NamedQuery(name = "UserTable.findByContactNo", query = "SELECT u FROM UserTable u WHERE u.contactNo = :contactNo"),
    @NamedQuery(name = "UserTable.findByPassword", query = "SELECT u FROM UserTable u WHERE u.password = :password")})
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lname")
    private String lname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
     @JsonbTransient
    @ManyToOne(optional = false)
    private RoleMstr roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailId")
    @JsonbTransient
    private Collection<BookingTable> bookingTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailId")
    @JsonbTransient
    private Collection<PaymentTable> paymentTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailId")
    @JsonbTransient
    private Collection<ReviewTable> reviewTableCollection;

    public UserTable() {
    }

    public UserTable(String emailId) {
        this.emailId = emailId;
    }

    public UserTable(String emailId, String fname, String lname, String contactNo, String password) {
        this.emailId = emailId;
        this.fname = fname;
        this.lname = lname;
        this.contactNo = contactNo;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleMstr getRoleId() {
        return roleId;
    }

    public void setRoleId(RoleMstr roleId) {
        this.roleId = roleId;
    }

    public Collection<BookingTable> getBookingTableCollection() {
        return bookingTableCollection;
    }

    public void setBookingTableCollection(Collection<BookingTable> bookingTableCollection) {
        this.bookingTableCollection = bookingTableCollection;
    }

    public Collection<PaymentTable> getPaymentTableCollection() {
        return paymentTableCollection;
    }

    public void setPaymentTableCollection(Collection<PaymentTable> paymentTableCollection) {
        this.paymentTableCollection = paymentTableCollection;
    }

    public Collection<ReviewTable> getReviewTableCollection() {
        return reviewTableCollection;
    }

    public void setReviewTableCollection(Collection<ReviewTable> reviewTableCollection) {
        this.reviewTableCollection = reviewTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTable)) {
            return false;
        }
        UserTable other = (UserTable) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.UserTable[ emailId=" + emailId + " ]";
    }
    
}
