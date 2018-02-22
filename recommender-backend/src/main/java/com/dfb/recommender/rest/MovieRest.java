package com.dfb.recommender.rest;

import javax.ws.rs.Path;

/**
 * Created by Dante on 2/21/2018.
 */
@Path("/movies")
public class MovieController {

    @Inject
    private PersonRepository persons;

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Person> listPersons() {
        return persons.listPersons();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/xml", "application/json"})
    public Response getPerson(@PathParam("id") Long id) {
        Optional<Person> person = persons.getPerson(id);
        if (person.isPresent()) {
            return Response.ok(person.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
