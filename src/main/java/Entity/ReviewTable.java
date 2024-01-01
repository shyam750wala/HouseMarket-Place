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
@Table(name = "review_table")
@NamedQueries({
    @NamedQuery(name = "ReviewTable.findAll", query = "SELECT r FROM ReviewTable r"),
    @NamedQuery(name = "ReviewTable.findByRId", query = "SELECT r FROM ReviewTable r WHERE r.rId = :rId"),
    @NamedQuery(name = "ReviewTable.findByDescription", query = "SELECT r FROM ReviewTable r WHERE r.description = :description")})
public class ReviewTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "r_id")
    private Integer rId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "email_id", referencedColumnName = "email_id")
    @ManyToOne(optional = false)
    private UserTable emailId;

    public ReviewTable() {
    }

    public ReviewTable(Integer rId) {
        this.rId = rId;
    }

    public ReviewTable(Integer rId, String description) {
        this.rId = rId;
        this.description = description;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewTable)) {
            return false;
        }
        ReviewTable other = (ReviewTable) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.ReviewTable[ rId=" + rId + " ]";
    }
    
}
