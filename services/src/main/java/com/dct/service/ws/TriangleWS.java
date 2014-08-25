package com.dct.service.ws;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.service.TriangleService;
import com.dct.service.impl.TriangleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * REST service for requests mapping.
 */
@Path("/service")
@Produces("application/json")
public class TriangleWS {
    private static final Logger logger = LoggerFactory.getLogger(TriangleWS.class);
    TriangleService service;

    public TriangleWS() {
        service = new TriangleServiceImpl();
    }

    /**
     * GET request mapping method.
     * Uses TriangleService method implementation.
     * @return
     */
    @GET
    @Path("/version")
    @Produces("application/json")
    public Response getVersionInfo() {
        logger.debug("GET request handler");
        VersionInfo version = service.getVersion();
        return Response.status(Response.Status.OK).entity(version).build();
    }

    /**
     * POST request mapping.
     * Uses TriangleService method implementation.
     * @param request TriangleData with all three sides specified
     * @return
     */
    @POST
    @Path("/checkTriangle")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validateTriangle(TriangleData request) {
        logger.debug("POST request handler");
        boolean checkResult = false;
        TriangleResult result;
        try {
            checkResult = service.checkTriangle(request);
        } catch (IllegalArgumentException e) {
            logger.error("Check arguments for request");
        }

        result = new TriangleResult(checkResult);
        return Response.status(Response.Status.OK).entity(result).build();
    }
}
