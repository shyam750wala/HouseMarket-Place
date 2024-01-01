/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package restClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:restUser [restUser]<br>
 * USAGE:
 * <pre>
 *        userClient client = new userClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author SHYAM
 */
public class userClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/final_project_home/resources";

    public userClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("restUser");
    }

    public void insertPayment(String b_id, String e_id, String date, String price, String status) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("payment/{0}/{1}/{2}/{3}/{4}", new Object[]{b_id, e_id, date, price, status})).request().post(null);
    }

    public void insertUser(String emailid, String fname, String lname, String contactno, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("insert/{0}/{1}/{2}/{3}/{4}", new Object[]{emailid, fname, lname, contactno, password})).request().post(null);
    }

    public <T> T getPropertiesByRole(Class<T> responseType, String role) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("byRole/{0}", new Object[]{role}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void insertReview(String e_id, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("review/{0}/{1}", new Object[]{e_id, description})).request().post(null);
    }

    public void insertBooking(String p_id, String e_id, String BookingDate, String price, String b_price, String propertydetails) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("booking/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{p_id, e_id, BookingDate, price, b_price, propertydetails})).request().post(null);
    }

    public <T> T getAllProperties(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("properties");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePasswordByEmail(String email, String password) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatepassword/{0}/{1}", new Object[]{email, password})).request().put(null);
    }

    public <T> T getPropertyByStatus(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getPropertyByStatus");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
