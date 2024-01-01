/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdibean;

import restClient.adminClient;
import restClient.userClient;
import Entity.CityTable;
import Entity.PropertyTable;
import Entity.RoleMstr;
import Entity.StateTable;
import ejb.adminbeanLocal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
//import Entity.UserTable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author SHYAM
 */
@Named(value = "insertPropertyBean")
@RequestScoped
public class insertPropertyBean {

    private Part file1;
    private Part file2;
    private Part file3;
    private Part file4;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public Part getFile2() {
        return file2;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file3;
    }

    public Part getFile4() {
        return file4;
    }

    public void setFile4(Part file4) {
        this.file4 = file4;
    }

    @PersistenceContext(unitName = "jpapu")
    EntityManager em;
    @EJB
    adminbeanLocal abl;
    private PropertyTable selectedProperty;
    int propertyid;
    String p_id;
    adminClient ac = new adminClient();
    userClient uc = new userClient();
    String title;
    String type;
    String description;
    String statename;
    String cityname;
    String fulladdress;
    String image1;
    String image2;
    String image3;
    String image4;
    String listingdate;
    String contactno;
    String emailid;
    String price;
    String role;
    String selectedState;
    String selectedCity;
    String selectedRoles;
    Response rs;
    Integer status;
    int listingCount;
    String email_id;
    String statu;
    String b_price;
    Collection<CityTable> city;
    GenericType<Collection<CityTable>> gcity;
    Collection<StateTable> state;
    GenericType<Collection<StateTable>> gstate;
    Collection<PropertyTable> property;
    GenericType<Collection<PropertyTable>> gproperty;
    Collection<RoleMstr> roles;
    GenericType<Collection<RoleMstr>> groles;

    public insertPropertyBean() {

        ac = new adminClient();
        property = new ArrayList();
        gproperty = new GenericType<Collection<PropertyTable>>() {

        };
        state = new ArrayList();
        gstate = new GenericType<Collection<StateTable>>() {

        };

        city = new ArrayList();
        gcity = new GenericType<Collection<CityTable>>() {

        };

        roles = new ArrayList();
        groles = new GenericType<Collection<RoleMstr>>() {
        };

    }

    public String uploadFile(Part file) {
        String fileName = null;
        if (file != null) {
            try {
                fileName = file.getSubmittedFileName();

                // Specify the directory where you want to store the files
                String uploadDirectory = "F:\\Project Practice\\final_project_home\\src\\main\\webapp\\resources\\images";
                //String uploadDirectory = "F:\\Project Practice\\final_project_home\\src\\main\\webapp\\userTemplate\\img";

                File uploadDir = new File(uploadDirectory);

                // Create the directory if it doesn't exist
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Create a File object representing the uploaded file
                File uploadedFile = new File(uploadDirectory, fileName);

                // Copy the content of the InputStream to the FileOutputStream
                try (InputStream in = file.getInputStream(); FileOutputStream out = new FileOutputStream(uploadedFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }

                // You can use standard Java I/O operations to handle the file.
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is null");
        }

        return fileName; // Navigate to a success page
    }

    public String insertPropertes() {
        String image1Path = uploadFile(file1);
        String image2Path = uploadFile(file2);
        String image3Path = uploadFile(file3);
        String image4Path = uploadFile(file4);

        System.out.println("title : " + title );
        System.out.println("type :" + type);
        System.out.println("Desc :" + description);
        System.out.println("State :" + selectedState);
        System.out.println("City :" + selectedCity);
        System.out.println("Address :" + fulladdress);
        System.out.println("Role :" + selectedRoles);
        System.out.println("listingdate :" + listingdate);
        System.out.println("emailid :" + emailid);
        System.out.println("conatctno :" + contactno);
        System.out.println("price :" + price);
        System.out.println(image1Path);
        System.out.println(image2Path);
        System.out.println(image3Path);
        System.out.println(image4Path);

//        ac.insertProperty(title, type, description, selectedState, selectedCity, fulladdress, image1Path, image2Path, image3Path, image4Path, listingdate, contactno, emailid, price, selectedRoles);
           ac.insertProperty(title, type, description, selectedState, selectedCity, fulladdress, image1Path, image2Path, image3Path, image4Path, listingdate, contactno, emailid, price, selectedRoles);
        
        return "manageProperty.jsf";
    }

    public void searcproperty(int pid) {

        rs = ac.searchPropertyById(Response.class, pid + "");
        GenericType<PropertyTable> gstate = new GenericType<PropertyTable>() {
        };
        PropertyTable cc = rs.readEntity(gstate);
        propertyid = cc.getPId();
        status = cc.getStatus();
        deniedproperty();

    }

    public String deniedproperty() {
        PropertyTable pt = new PropertyTable();
        pt.setPId(propertyid);
        pt.setStatus(1);
        abl.hideProperty(propertyid, status);
        return "manageProperty.jsf?faces-redirect=true";
    }

    public String deleteProperty(String pid) {
        ac.deleteProperty(pid);
        return "manageProperty.jsf";
    }

    public Collection<StateTable> allstatex() {

        rs = ac.getAllStates(Response.class);
        state = rs.readEntity(gstate);
        return state;
    }

    public Collection<CityTable> allcitybystate() {
        rs = ac.getAllCities(Response.class);
        city = rs.readEntity(gcity);
        return city;
    }

    public Collection<RoleMstr> getallroles() {
        rs = ac.getAllRoles(Response.class);
        roles = rs.readEntity(groles);
        return roles;

    }

    public Collection<PropertyTable> getallproperty() {
        rs = uc.getAllProperties(Response.class);
        property = rs.readEntity(gproperty);
        return property;
    }
    
     public Collection<PropertyTable> getallpropertyByStatus() {
        rs = uc.getPropertyByStatus(Response.class);
        property = rs.readEntity(gproperty);
        return property;
    }
    
    public String viewPropertyDetails(int pid) {

        return "/userTemplate/housedetails.jsf?faces-redirect=true&includeViewParams=true&propertyId=" + propertyid;
    }

    public String Bookinginsert() {
        
        
         FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);

        String AdminEmail = (String) session.getAttribute("Admin");
        String UserEmail = (String) session.getAttribute("User");

        if (uc != null) {
            if (AdminEmail == null) {
                uc.insertBooking(p_id, UserEmail, listingdate, price, b_price, description);
            } else {
              uc.insertBooking(p_id, AdminEmail, listingdate, price, b_price, description);
            }
        }
       
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Booking successful", "Your booking is confirmed"));
        return "mybooking.jsf";
    }

     public void load() {
        //System.err.println(p_id);
        rs = ac.searchPropertyById(Response.class, p_id);
        GenericType<PropertyTable> genricEvent = new GenericType<PropertyTable>() {
        };

        PropertyTable cc = rs.readEntity(genricEvent);

        this.title = cc.getTitle();
        this.type = cc.getType();
        this.description = cc.getDescription();
        this.statename = cc.getStateName();
        this.cityname = cc.getCityName();
        this.fulladdress = cc.getFulladdress();
        this.image1 = cc.getImage1();
        this.image2 = cc.getImage2();
        this.image3 = cc.getImage3();
        this.image4 = cc.getImage4();
        this.price = cc.getPrice();
        this.listingdate = cc.getListingdate();
        this.contactno = cc.getConatctno();
        this.emailid = cc.getEmailid();

    }
     

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

   
    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getB_price() {
        return b_price;
    }

    public void setB_price(String b_price) {
        this.b_price = b_price;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public Collection<CityTable> getCity() {
        return city;
    }

    public void setCity(Collection<CityTable> city) {
        this.city = city;
    }

    public int getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(int propertyid) {
        this.propertyid = propertyid;
    }

    public Collection<Collection<CityTable>> getGcity() {
        return (Collection<Collection<CityTable>>) gcity;
    }

    public void setGcity(Collection<Collection<CityTable>> gcity) {
        this.gcity = (GenericType<Collection<CityTable>>) gcity;
    }

    public Collection<StateTable> getState() {
        return state;
    }

    public void setState(Collection<StateTable> state) {
        this.state = state;
    }

    public GenericType<Collection<StateTable>> getGstate() {
        return gstate;
    }

    public void setGstate(GenericType<Collection<StateTable>> gstate) {
        this.gstate = gstate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(String selectedState) {
        this.selectedState = selectedState;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public adminClient getAc() {
        return ac;
    }

    public void setAc(adminClient ac) {
        this.ac = ac;
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

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
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

    public Response getRs() {
        return rs;
    }

    public void setRs(Response rs) {
        this.rs = rs;
    }

    public Collection<PropertyTable> getProperty() {
        return property;
    }

    public void setProperty(Collection<PropertyTable> property) {
        this.property = property;
    }

    public GenericType<Collection<PropertyTable>> getGproperty() {
        return gproperty;
    }

    public void setGproperty(GenericType<Collection<PropertyTable>> gproperty) {
        this.gproperty = gproperty;
    }

    public String getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(String selectedRoles) {
        this.selectedRoles = selectedRoles;
    }

    public PropertyTable getSelectedProperty() {
        return selectedProperty;
    }

    public void setSelectedProperty(PropertyTable selectedProperty) {
        this.selectedProperty = selectedProperty;
    }

}
