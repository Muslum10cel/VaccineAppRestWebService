/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muslum;

import com.muslumyusuf.DBOperations;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author muslumoncel
 */
@Path("VaccineAppRestWebService")
public class RESTWebService {

    private final DBOperations operations = new DBOperations();
    private final String UPDATE_STATUS = "update_status";
    private final String REGISTER_STATUS = "register_status";
    private final String ADD_BABY_STATUS = "add_baby_status";
    private final String PASSWORD_UPDATE_STATUS = "password_update_status";
    private final String LOG_IN_LEVEL = "log_in_level";

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RESTWebService
     */
    public RESTWebService() {
    }

    /**
     * Retrieves representation of an instance of com.muslum.RESTWebService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RESTWebService
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/log_in/{username},{password}")
    public String log_in(@PathParam("username") String username, @PathParam("password") String password) throws JSONException {
        return new JSONObject().put(LOG_IN_LEVEL, operations.logIn(username, password)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register/{username},{fullname},{password}")
    public String register(@PathParam("username") String username, @PathParam("full_name") String full_name, @PathParam("password") String password, @PathParam("e_mail") String email) throws JSONException {
        return new JSONObject().put(REGISTER_STATUS, operations.register(username, full_name, password, email)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addBaby/username={username},{babyname},{date_of_birth}")
    public String add_baby(@PathParam("username") String username, @PathParam("baby_name") String baby_name, @PathParam("date_of_birth") String date_of_birth) throws JSONException {
        return new JSONObject().put(ADD_BABY_STATUS, operations.addBaby(username, baby_name, date_of_birth)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_DaBT_IPA_HIB/{baby_id},{flag}")
    public String update_DaBT_IPA_HIB(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_DaBT_IPA_HIB(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_Hepatit_A/{baby_id},{flag}")
    public String update_Hepatit_A(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_Hepatit_A(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_Hepatit_B/{baby_id},{flag}")
    public String update_Hepatit_B(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_Hepatit_B(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_KKK/{baby_id},{flag}")
    public String update_Hepatit_KKK(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_KKK(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_KPA/{baby_id},{flag}")
    public String update_Hepatit_KPA(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_KPA(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_OPA/{baby_id},{flag}")
    public String update_Hepatit_OPA(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS,operations.update_OPA(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_RVA/{baby_id},{flag}")
    public String update_Hepatit_RVA(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_RVA(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update_Vaccines/{baby_id},{flag}")
    public String update_Vaccines(@PathParam("baby_id") int baby_id, @PathParam("flag") int flag) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.update_Vaccines(baby_id, flag)).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add_comment/{username},{vaccine_name},{comment}")
    public String addComment(@PathParam("username") String username, @PathParam("vaccine_name") String vaccine_name, @PathParam("comment") String comment) throws JSONException {
        return new JSONObject().put(UPDATE_STATUS, operations.addComment(username, vaccine_name, comment)).toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/completedAndIncompletedVaccines/{baby_id}")
    public String completedAndIncompletedVaccines(@PathParam("baby_id") int baby_id) throws JSONException {
        return operations.completedAndIncompletedVaccines(baby_id).toString();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/forgottenpassword/{username},{new_password}")
    public String forgottenpassword(@PathParam("username") String username, @PathParam("new_password") String new_password) throws JSONException {
        return new JSONObject().put(PASSWORD_UPDATE_STATUS, operations.forgottenPassword(username, new_password)).toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getComments/{vaccine_name},{begin_index},{last_index}")
    public String getComments(@PathParam("vaccine_name") String vaccine_name, @PathParam("begin_index") int begin_index, @PathParam("last_index") int last_index) throws JSONException {
        return operations.getComments(vaccine_name, begin_index, last_index).toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getBabies/{username}")
    public String getBabies(@PathParam("username") String username) throws JSONException {
        return operations.getBabies(username).toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllVaccineNames")
    public String getAllVaccineNames() throws JSONException {
        return operations.getAllVaccineNames().toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getVaccinesDetailsOfBaby/{baby_id}")
    public String getVaccinesDetailsOfBaby(@PathParam("baby_id") int baby_id) throws JSONException {
        return operations.getVaccinesDetailsOfBaby(baby_id).toString();
    }
}
