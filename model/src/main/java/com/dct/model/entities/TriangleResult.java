package com.dct.model.entities;

import java.io.Serializable;

/**
 * Represents if the triangle with specified sides exists.
 */
public class TriangleResult implements Serializable {
    private String exists;
    private final String YES = "YES";
    private final String NO = "NO";

    /**
     * Default constructor
     */
    public TriangleResult() {};

    /**
     * Overloaded constructor.
     * Uses result of triangle check to set "YES" if flag is true and "NO" otherwise.
     * @param flag
     */
    public TriangleResult(boolean flag) {
        this.exists = convertExists(flag);
    }

    /**
     * Get triangle check result
     * @return if triangle exists
     */
    public String getExists() {
        return exists;
    }

    /**
     * Sets triangle existence
     * @param exists
     */
    public void setExists(String exists) {
        this.exists = exists;
    }

    /**
     * Method for converting boolean triangle check result to String.
     * @param flag Result of triangle existence check
     * @return "YES" or "NO" according to flag
     */
    public String convertExists(boolean flag) {
        return flag ? YES : NO;
    }

    @Override
    public String toString() {
        return "TriangleData{" + "exists=" + exists + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleResult that = (TriangleResult) o;

        if (!exists.equals(that.exists)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return exists.hashCode();
    }
}
