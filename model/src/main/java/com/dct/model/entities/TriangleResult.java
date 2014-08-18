package com.dct.model.entities;

public class TriangleResult {
    private String exists;
    private final String YES = "YES";
    private final String NO = "NO";

    public TriangleResult() {};

    public TriangleResult(boolean flag) {
        this.exists = convertExists(flag);
    }

    public String getExists() {
        return exists;
    }

    public void setExists(String exists) {
        this.exists = exists;
    }

    public String convertExists(boolean flag) {
        return flag ? YES : NO;
    }

    @Override
    public String toString() {
        return "TriangleData{" + "exists=" + exists + '}';
    }
}
