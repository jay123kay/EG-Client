package com.eg.electrogrid.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import com.eg.electrogrid.model.powerplantmodel;
import com.eg.electrogrid.service.powerplantservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

	@Path("/powerplants")
	public class powerplantresource {
		
		powerplantservice service = new powerplantservice();
		
		@Path("/insertion")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public powerplantmodel addPowerplant(powerplantmodel powerplant) {
			 return service.insertPowerplant(powerplant);
			
		}
		
		@Path("/retrieve")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<powerplantmodel>  getPowerplan() throws SQLException {
			 return service.getPowerplant();
			
		}
		
		@Path("/retrieveById/{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public ArrayList<powerplantmodel>  getPowerplant(@PathParam("id")String id) throws SQLException {
			 return service.getPowerplantById(id);

		}
		
		@Path("/updatePowerplant")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public powerplantmodel uPowerplant(powerplantmodel powerplant) {
			 return service.updatePowerplant(powerplant);
			
		}
		
		@Path("/deletePowerplantById/{id}")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		public int  deletePowerplant(@PathParam("id") int id) {
			 return service.deletePowerplant(id);

		}

}
