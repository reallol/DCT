package com.dct.model.entities;

import java.io.Serializable;

/**
 * Represents triangle sides used for triangle correctness checking.
 */
public class TriangleData implements Serializable {
    private Double a;
    private Double b;
    private Double c;

    /**
     * Default constructor
     */
    public TriangleData() {};

    /**
     * Overloaded constructor for TriangleData.
     * Uses passed parameters to set triangle's sides
     * @param a
     * @param b
     * @param c
     */
    public TriangleData(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Get first triangle side
     * @return triangle's side a
     */
    public Double getA() {
        return a;
    }

    /**
     * Set first triangle side length
     * @param a Triangle's side
     */
    public void setA(Double a) {
        this.a = a;
    }

    /**
     * Get second triangle side
     * @return triangle's side b
     */
    public Double getB() {
        return b;
    }

    /**
     * Set second triangle side length
     * @param b Triangle's side
     */
    public void setB(Double b) {
        this.b = b;
    }

    /**
     * Get third triangle side
     * @return triangle's side c
     */
    public Double getC() {
        return c;
    }

    /**
     * Set third triangle side length
     * @param c Triangle's side
     */
    public void setC(Double c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "TriangleData{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleData that = (TriangleData) o;

        if (!a.equals(that.a)) return false;
        if (!b.equals(that.b)) return false;
        if (!c.equals(that.c)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        return result;
    }
}
