package com.dct.service.impl;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.service.TriangleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
/*import org.springframework.stereotype.Service;*/

/*@Service*/
@Path("/service")
public class TriangleServiceImpl implements TriangleService {

    private static final Logger logger = LoggerFactory.getLogger(TriangleServiceImpl.class);

    public TriangleServiceImpl() {};

    @GET
    @Path("/version")
    @Produces("application/json")
    public Response getVersionInfo() {
        logger.debug("GET request handler");
        VersionInfo version = getVersion();
        return Response.status(200).entity(version).build();
    }

    @Override
    public VersionInfo getVersion() {
        VersionInfo version = new VersionInfo(getClass().getPackage().getImplementationVersion());
        return version;
    }

    @POST
    @Path("/checkTriangle")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validateTriangle(TriangleData request) {
        logger.debug("POST request handler");
        boolean checkResult;
        try {
            checkResult = checkTriangle(request);
        } catch (IllegalArgumentException e) {
            return Response.status(400).build();
        }
        TriangleResult result = new TriangleResult(checkResult);
        return Response.status(200).entity(result).build();
    }

    @Override
    public boolean checkTriangle(TriangleData request) throws IllegalArgumentException {
        boolean exists = false;

        if (request.getA() > 0 && request.getB() > 0 && request.getC() > 0) {
            exists = (request.getA() + request.getB() > request.getC()) &&
                    (request.getA() + request.getC() > request.getB()) &&
                    (request.getB() + request.getC() > request.getA());
        } else {
            logger.error("Incorrect arguments for triangle");
            throw new IllegalArgumentException("Arguments provided are not correct, please check.");
        }

        return exists;
    }
}
