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
@Table(name = "state_table")
@NamedQueries({
    @NamedQuery(name = "StateTable.findAll", query = "SELECT s FROM StateTable s"),
    @NamedQuery(name = "StateTable.findByStateId", query = "SELECT s FROM StateTable s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "StateTable.findByStateName", query = "SELECT s FROM StateTable s WHERE s.stateName = :stateName"),
    @NamedQuery(name = "StateTable.findByStateStatus", query = "SELECT s FROM StateTable s WHERE s.stateStatus = :stateStatus")})
public class StateTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state_name")
    private String stateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state_status")
    private int stateStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    @JsonbTransient
    private Collection<CityTable> cityTableCollection;

    public StateTable() {
    }

    public StateTable(Integer stateId) {
        this.stateId = stateId;
    }

    public StateTable(Integer stateId, String stateName, int stateStatus) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.stateStatus = stateStatus;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getStateStatus() {
        return stateStatus;
    }

    public void setStateStatus(int stateStatus) {
        this.stateStatus = stateStatus;
    }

    public Collection<CityTable> getCityTableCollection() {
        return cityTableCollection;
    }

    public void setCityTableCollection(Collection<CityTable> cityTableCollection) {
        this.cityTableCollection = cityTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateTable)) {
            return false;
        }
        StateTable other = (StateTable) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.final_project_home.StateTable[ stateId=" + stateId + " ]";
    }
    
}
