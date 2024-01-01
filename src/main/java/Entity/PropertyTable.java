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
@Table(name = "property_table")
@NamedQueries({
    @NamedQuery(name = "PropertyTable.findAll", query = "SELECT p FROM PropertyTable p"),
    @NamedQuery(name = "PropertyTable.findByPId", query = "SELECT p FROM PropertyTable p WHERE p.pId = :pId"),
    @NamedQuery(name = "PropertyTable.findByTitle", query = "SELECT p FROM PropertyTable p WHERE p.title = :title"),
    @NamedQuery(name = "PropertyTable.findByType", query = "SELECT p FROM PropertyTable p WHERE p.type = :type"),
    @NamedQuery(name = "PropertyTable.findByDescription", query = "SELECT p FROM PropertyTable p WHERE p.description = :description"),
    @NamedQuery(name = "PropertyTable.findByStateName", query = "SELECT p FROM PropertyTable p WHERE p.stateName = :stateName"),
    @NamedQuery(name = "PropertyTable.findByCityName", query = "SELECT p FROM PropertyTable p WHERE p.cityName = :cityName"),
    @NamedQuery(name = "PropertyTable.findByFulladdress", query = "SELECT p FROM PropertyTable p WHERE p.fulladdress = :fulladdress"),
    @NamedQuery(name = "PropertyTable.findByImage1", query = "SELECT p FROM PropertyTable p WHERE p.image1 = :image1"),
    @NamedQuery(name = "PropertyTable.findByImage2", query = "SELECT p FROM PropertyTable p WHERE p.image2 = :image2"),
    @NamedQuery(name = "PropertyTable.findByImage3", query = "SELECT p FROM PropertyTable p WHERE p.image3 = :image3"),
    @NamedQuery(name = "PropertyTable.findByImage4", query = "SELECT p FROM PropertyTable p WHERE p.image4 = :image4"),
    @NamedQuery(name = "PropertyTable.findByListingdate", query = "SELECT p FROM PropertyTable p WHERE p.listingdate = :listingdate"),
    @NamedQuery(name = "PropertyTable.findByConatctno", query = "SELECT p FROM PropertyTable p WHERE p.conatctno = :conatctno"),
    @NamedQuery(name = "PropertyTable.findByEmailid", query = "SELECT p FROM PropertyTable p WHERE p.emailid = :emailid"),
    @NamedQuery(name = "PropertyTable.findByPrice", query = "SELECT p FROM PropertyTable p WHERE p.price = :price"),
    @NamedQuery(name = "PropertyTable.findByStatus", query = "SELECT p FROM PropertyTable p WHERE p.status = :status")})
public class PropertyTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "p_id")
    private Integer pId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state_name")
    private String stateName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city_name")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fulladdress")
    private String fulladdress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image1")
    private String image1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image2")
    private String image2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image3")
    private String image3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image4")
    private String image4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "listingdate")
    private String listingdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "conatctno")
    private String conatctno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "emailid")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pId")
    @JsonbTransient
    private Collection<BookingTable> bookingTableCollection;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    
    private PropertyMster roleId;

    public PropertyTable() {
    }

    public PropertyTable(Integer pId) {
        this.pId = pId;
    }

    public PropertyTable(Integer pId, String title, String type, String description, String stateName, String cityName, String fulladdress, String image1, String image2, String image3, String image4, String listingdate, String conatctno, String emailid, String price, int status) {
        this.pId = pId;
        this.title = title;
        this.type = type;
        this.description = description;
        this.stateName = stateName;
        this.cityName = cityName;
        this.fulladdress = fulladdress;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.listingdate = listingdate;
        this.conatctno = conatctno;
        this.emailid = emailid;
        this.price = price;
        this.status = status;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getListingdate() {
        return listingdate;
    }

    public void setListingdate(String listingdate) {
        this.listingdate = listingdate;
    }

    public String getConatctno() {
        return conatctno;
    }

    public void setConatctno(String conatctno) {
        this.conatctno = conatctno;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
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

    public Collection<BookingTable> getBookingTableCollection() {
        return bookingTableCollection;
    }

    public void setBookingTableCollection(Collection<BookingTable> bookingTableCollection) {
        this.bookingTableCollection = bookingTableCollection;
    }

    public PropertyMster getRoleId() {
        return roleId;
    }

    public void setRoleId(PropertyMster roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof PropertyTable)) {
            return false;
        }
        PropertyTable other = (PropertyTable) object;
        if ((this.pId == null && other.pId != null) || (this.pId != null && !this.pId.equals(other.pId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.PropertyTable[ pId=" + pId + " ]";
    }
    
}
