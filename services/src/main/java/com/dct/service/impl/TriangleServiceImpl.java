package com.dct.service.impl;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.VersionInfo;
import com.dct.service.TriangleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TriangleService methods implementation.
 */

public class TriangleServiceImpl implements TriangleService {
    private static final Logger logger = LoggerFactory.getLogger(TriangleServiceImpl.class);

    /**
     * Default constructor
     */
    public TriangleServiceImpl() {};

    /**
     * TriangleService method implementation.
     * Method gets application version from maven artifact.
     * @return
     * @see com.dct.service.TriangleService
     */
    @Override
    public VersionInfo getVersion() {
        VersionInfo version = new VersionInfo(getClass().getPackage().getImplementationVersion());
        return version;
    }

    /**
     * TriangleService method implementation.
     * Checks if triangle with sides specified exists.
     * @param request TriangleData with all three sides specified
     * @return
     * @throws IllegalArgumentException
     * @see com.dct.service.TriangleService
     */
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
