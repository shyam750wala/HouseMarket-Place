/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package restClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:restAdmin [sampleadmin]<br>
 * USAGE:
 * <pre>
 *        adminClient client = new adminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author SHYAM
 */
public class adminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/final_project_home/resources";

    public adminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("sampleadmin");
    }

    public void updateState(String id, String state, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatestate/{0}/{1}/{2}", new Object[]{id, state, status})).request().put(null);
    }

    public void updateCity(String id, String state_id, String name, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecity/{0}/{1}/{2}/{3}", new Object[]{id, state_id, name, status})).request().put(null);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRoles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllRoles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllStates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllStates");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T searchbybookingid(Class<T> responseType, String bid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchbybookingid/{0}", new Object[]{bid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertProperty(String title, String Type, String description, String state_name, String city_name, String fulladdress, String image1, String image2, String image3, String image4, String listingdate, String conatctno, String emailid, String price, String property_mster_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertproperty/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}", new Object[]{title, Type, description, state_name, city_name, fulladdress, image1, image2, image3, image4, listingdate, conatctno, emailid, price, property_mster_id})).request().post(null);
    }

    public <T> T getAllPayments(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPayments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertState(String state, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertstate/{0}/{1}", new Object[]{state, status})).request().post(null);
    }

    public <T> T getAllReviews(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllReviews");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertCity(String state_id, String name, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertcity/{0}/{1}/{2}", new Object[]{state_id, name, status})).request().post(null);
    }

    public <T> T searchPropertyById(Class<T> responseType, String p_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchPropertyById/{0}", new Object[]{p_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllRole(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllRoles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteRole(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleterole/{0}", new Object[]{id})).request().delete();
    }

    public void deleteProperty(String p_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteProperty/{0}", new Object[]{p_id})).request().delete();
    }

    public void deleteCity(String id, String state_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletecity/{0}/{1}", new Object[]{id, state_id})).request().delete();
    }

    public void updateProperty(String p_id, String title, String Type, String description, String state_name, String city_name, String fulladdress, String image1, String image2, String image3, String image4, String listingdate, String conatctno, String emailid, String price, String status, String property_mster_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}/{13}/{14}/{15}/{16}", new Object[]{p_id, title, Type, description, state_name, city_name, fulladdress, image1, image2, image3, image4, listingdate, conatctno, emailid, price, status, property_mster_id})).request().put(null);
    }

    public <T> T getCitiesByState(Class<T> responseType, String stateName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCitiesByState/{0}", new Object[]{stateName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllStateNames(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getallStateNames");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCities(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCities");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertRole(String role) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insertrole/{0}", new Object[]{role})).request().post(null);
    }

    public <T> T searchUserById(Class<T> responseType, String e_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("searchUserById/{0}", new Object[]{e_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllBookings(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllBookings");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteState(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletestate/{0}", new Object[]{id})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
