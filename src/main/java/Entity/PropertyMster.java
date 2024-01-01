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
@Table(name = "property_mster")
@NamedQueries({
    @NamedQuery(name = "PropertyMster.findAll", query = "SELECT p FROM PropertyMster p"),
    @NamedQuery(name = "PropertyMster.findById", query = "SELECT p FROM PropertyMster p WHERE p.id = :id"),
    @NamedQuery(name = "PropertyMster.findByRole", query = "SELECT p FROM PropertyMster p WHERE p.role = :role")})
public class PropertyMster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "role")
    private String role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    @JsonbTransient
    private Collection<PropertyTable> propertyTableCollection;

    public PropertyMster() {
    }

    public PropertyMster(Integer id) {
        this.id = id;
    }

    public PropertyMster(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<PropertyTable> getPropertyTableCollection() {
        return propertyTableCollection;
    }

    public void setPropertyTableCollection(Collection<PropertyTable> propertyTableCollection) {
        this.propertyTableCollection = propertyTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropertyMster)) {
            return false;
        }
        PropertyMster other = (PropertyMster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.PropertyMster[ id=" + id + " ]";
    }
    
}
