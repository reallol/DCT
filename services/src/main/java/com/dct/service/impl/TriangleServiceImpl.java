package com.dct.service.impl;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.VersionInfo;
import com.dct.service.TriangleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TriangleServiceImpl implements TriangleService {

    private static final Logger logger = LoggerFactory.getLogger(TriangleServiceImpl.class);

    public TriangleServiceImpl() {};

    @Override
    public VersionInfo getVersion() {
        VersionInfo version = new VersionInfo(getClass().getPackage().getImplementationVersion());
        return version;
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
