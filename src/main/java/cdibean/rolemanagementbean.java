/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import Entity.PropertyMster;
import ejb.adminbeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import restClient.adminClient;

/**
 *
 * @author SHYAM
 */
@Named(value = "rolemanagementbean")
@RequestScoped
public class rolemanagementbean {
  
    adminClient ac = new adminClient();
    Response rs;
    Integer id;
    String propertyrole;
    Collection<PropertyMster>mstr;
    GenericType<Collection<PropertyMster>>gmstr;
    

    /**
     * Creates a new instance of rolemanagementbean
     */
    public rolemanagementbean() {
        
       ac = new adminClient();
       mstr = new ArrayList();
        gmstr = new GenericType<Collection<PropertyMster>>() {
         
        };
    }
    public Collection<PropertyMster> getAllRoles()
    {
      rs = ac.getAllRole(Response.class);
      mstr = rs.readEntity(gmstr);
      return mstr;
    }
    
      public String deleteRole(String rid) {
        ac.deleteRole(rid);
        return "managerole.jsf";
    }
      
     public String insertrole()
     {
         ac.insertRole(propertyrole);
         return "managerole.jsf";
     }

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyrole() {
        return propertyrole;
    }

    public void setPropertyrole(String propertyrole) {
        this.propertyrole = propertyrole;
    }

  

    public Collection<PropertyMster> getMstr() {
        return mstr;
    }

    public void setMstr(Collection<PropertyMster> mstr) {
        this.mstr = mstr;
    }

    public GenericType<Collection<PropertyMster>> getGmstr() {
        return gmstr;
    }

    public void setGmstr(GenericType<Collection<PropertyMster>> gmstr) {
        this.gmstr = gmstr;
    }


    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }
    
    
}
