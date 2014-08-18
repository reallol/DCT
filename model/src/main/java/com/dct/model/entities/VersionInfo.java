package com.dct.model.entities;

public class VersionInfo {
    private String version;

    public VersionInfo() {
    };

    public VersionInfo(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "version='" + version + '\'' +
                '}';
    }
}
