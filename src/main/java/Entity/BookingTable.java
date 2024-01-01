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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "booking_table")
@NamedQueries({
    @NamedQuery(name = "BookingTable.findAll", query = "SELECT b FROM BookingTable b"),
    @NamedQuery(name = "BookingTable.findByBId", query = "SELECT b FROM BookingTable b WHERE b.bId = :bId"),
    @NamedQuery(name = "BookingTable.findByBookingDate", query = "SELECT b FROM BookingTable b WHERE b.bookingDate = :bookingDate"),
    @NamedQuery(name = "BookingTable.findByPrice", query = "SELECT b FROM BookingTable b WHERE b.price = :price"),
    @NamedQuery(name = "BookingTable.findByBeadingPrice", query = "SELECT b FROM BookingTable b WHERE b.beadingPrice = :beadingPrice"),
    @NamedQuery(name = "BookingTable.findByDetails", query = "SELECT b FROM BookingTable b WHERE b.details = :details"),
    @NamedQuery(name = "BookingTable.findByStatus", query = "SELECT b FROM BookingTable b WHERE b.status = :status")})
public class BookingTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "b_id")
    private Integer bId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "booking_date")
    private String bookingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "beading_price")
    private String beadingPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "details")
    private String details;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "email_id", referencedColumnName = "email_id")
    @ManyToOne(optional = false)
    @JsonbTransient
    private UserTable emailId;
    @JoinColumn(name = "p_id", referencedColumnName = "p_id")
    @ManyToOne(optional = false)
    @JsonbTransient
    private PropertyTable pId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bId")
    @JsonbTransient
    private Collection<PaymentTable> paymentTableCollection;

    public BookingTable() {
    }

    public BookingTable(Integer bId) {
        this.bId = bId;
    }

    public BookingTable(Integer bId, String bookingDate, String price, String beadingPrice, String details, int status) {
        this.bId = bId;
        this.bookingDate = bookingDate;
        this.price = price;
        this.beadingPrice = beadingPrice;
        this.details = details;
        this.status = status;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBeadingPrice() {
        return beadingPrice;
    }

    public void setBeadingPrice(String beadingPrice) {
        this.beadingPrice = beadingPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserTable getEmailId() {
        return emailId;
    }

    public void setEmailId(UserTable emailId) {
        this.emailId = emailId;
    }

    public PropertyTable getPId() {
        return pId;
    }

    public void setPId(PropertyTable pId) {
        this.pId = pId;
    }

    public Collection<PaymentTable> getPaymentTableCollection() {
        return paymentTableCollection;
    }

    public void setPaymentTableCollection(Collection<PaymentTable> paymentTableCollection) {
        this.paymentTableCollection = paymentTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookingTable)) {
            return false;
        }
        BookingTable other = (BookingTable) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.BookingTable[ bId=" + bId + " ]";
    }
    
}
