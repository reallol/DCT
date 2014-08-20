package com.dct.service;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.VersionInfo;

/**
 * Service interface which defines basic methods available
 */
public interface TriangleService {

    /**
     * Method for getting application's version
     * @return
     */
    VersionInfo getVersion();

    /**
     * Method for checking if triangle is valid
     * @param request TriangleData with all three sides specified
     * @return boolean check result
     * @throws IllegalArgumentException
     */
    boolean checkTriangle(TriangleData request) throws IllegalArgumentException;
}
