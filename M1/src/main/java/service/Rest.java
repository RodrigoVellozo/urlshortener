package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import control.EncurtadorURL;
import entity.Url;
import persistence.UrlDao;

@Path("/service")
public class Rest {

	@GET
	@Path("/teste")
	@Produces(MediaType.TEXT_PLAIN)
	public String teste() {
		return "funcionou";
	}
	
	@GET
	@Path("/urls")
	@Produces(MediaType.APPLICATION_JSON)
	public String listar() throws Exception {
		return new Gson().toJson(new UrlDao().findAll());
	}
	
	@POST
	@Path("/url")
	@Consumes(MediaType.APPLICATION_JSON)
	public String gravar(Url u){
		try {
			u.setShorturl(new EncurtadorURL().sendGet(u.getLongurl()));
			new UrlDao().persist(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Dados gravados";
	}
	
	
	
	
	

}
