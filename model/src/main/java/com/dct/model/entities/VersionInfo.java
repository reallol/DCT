package com.dct.model.entities;

import java.io.Serializable;

/**
 * Class for representing application version information
 */
public class VersionInfo implements Serializable {
    private String version;

    /**
     * Default constructor
     */
    public VersionInfo() {
    };

    /**
     * Overloaded constructor
     * @param version Application's version
     */
    public VersionInfo(String version) {
        this.version = version;
    }

    /**
     * Get application version
     * @return Application's version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets application's version
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "VersionInfo{" +
                "version='" + version + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VersionInfo that = (VersionInfo) o;

        if (!version.equals(that.version)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return version.hashCode();
    }
}
