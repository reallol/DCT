package com.dct.service;

import com.dct.model.entities.TriangleData;
import com.dct.model.entities.VersionInfo;

public interface TriangleService {

    VersionInfo getVersion();

    boolean checkTriangle(TriangleData request) throws IllegalArgumentException;
}
