package com.dct.client;


import com.dct.model.entities.TriangleData;
import com.dct.model.entities.TriangleResult;
import com.dct.model.entities.VersionInfo;

public interface DCTClient {

    VersionInfo getVersionInfo();

    TriangleResult checkTriangle(TriangleData data) throws IllegalArgumentException;
}
