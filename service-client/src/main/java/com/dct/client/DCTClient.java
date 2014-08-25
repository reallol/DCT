package com.dct.client;


import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;
import com.dct.model.exceptions.DCTClientException;

/**
 * Client's interface which defines basic methods.
 */
public interface DCTClient {

    /**
     * Method for getting application's version
     * @return VersionInfo
     */
    VersionInfo getVersionInfo();

    /**
     * Method for checking if the triangle specified is valid
     * @param data TriangleData with all three sides specified
     * @return TriangleResult - "YES" or "NO"
     * @throws DCTClientException
     */
    TriangleResult checkTriangle(TriangleData data) throws DCTClientException;

    /**
     * Method for setting endpoint URL to local
     */
    void setLocalEndpoint();

    /**
     * Method for setting endpoint URL to remote
     */
    void setRemoteEndpoint();
}
