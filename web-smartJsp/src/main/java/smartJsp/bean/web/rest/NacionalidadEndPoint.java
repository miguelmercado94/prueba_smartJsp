package smartJsp.bean.web.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import smartJsp.bean.web.model.Nacionalidad;

@Path("nacionalidades")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public interface NacionalidadEndPoint {

	 @POST
	 Response create(Nacionalidad param);
	
	 @GET
	 Response list();
	
}
