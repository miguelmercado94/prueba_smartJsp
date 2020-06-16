package smartJsp.bean.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

import smartJsp.bean.web.model.Usuario;

@Path("usuarios")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public interface UsuarioEndpoint {

	    @POST
	    Response create(Usuario param);
	    
	    @PUT
	    Response update(Usuario param);

	    @GET
	    Response list();
	    
	    @GET
	    @Path("{filtro}")
	    Response listFiltro(@PathParam("filtro")String filtro);

	    @DELETE
	    @Path("{id}")
	    Response delete(@PathParam("id") Long personId);
	
}
