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
@Table(name = "city_table")
@NamedQueries({
    @NamedQuery(name = "CityTable.findAll", query = "SELECT c FROM CityTable c"),
    @NamedQuery(name = "CityTable.findByCityId", query = "SELECT c FROM CityTable c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityTable.findByCityName", query = "SELECT c FROM CityTable c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "CityTable.findByCityStatus", query = "SELECT c FROM CityTable c WHERE c.cityStatus = :cityStatus")})
public class CityTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "city_id")
    private Integer cityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city_name")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "city_status")
    private int cityStatus;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private StateTable stateId;

    public CityTable() {
    }

    public CityTable(Integer cityId) {
        this.cityId = cityId;
    }

    public CityTable(Integer cityId, String cityName, int cityStatus) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.cityStatus = cityStatus;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(int cityStatus) {
        this.cityStatus = cityStatus;
    }

    public StateTable getStateId() {
        return stateId;
    }

    public void setStateId(StateTable stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityTable)) {
            return false;
        }
        CityTable other = (CityTable) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.CityTable[ cityId=" + cityId + " ]";
    }
    
}
