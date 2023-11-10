import java.util.Arrays;

class MathVector {
    private final int      dim;
    private final double[] values;


    public MathVector(int N) {
        dim = N;
        values = new double[dim];
    }
    public MathVector(double... arr) {
        dim    = arr.length;
        values = new double[dim];
        for(int i = 0; i < dim; i++){
            values[i] = arr[i];
        }
       // values = arr;
    }

    public MathVector(MathVector v) {
        dim = v.dim;
        values = new double[dim];

        for(int i = 0; i < dim; i++){
            values[i] = v.values[i];
        }
    }


    public static MathVector vec2DfromPolar(double r, double theta) {
        double[] polar2 = {r * Math.cos(theta), r * Math.sin(theta)};
        return new MathVector(polar2);
    }

    public static MathVector vec3DfromPolar(double r, double theta, double phi) {
        double[] polar3 = {r * Math.sin(theta) * Math.cos(phi), r * Math.sin(theta) * Math.sin(phi), r * Math.cos(theta)};
        return new MathVector(polar3);
    }


    public int getDimension() { return this.dim;}


    public double getValue(int idx) { return this.values[idx-1]; }
    public void setValue(int idx, double val) {
        this.values[idx-1] = val;
    }


    public double dotWith(MathVector other) { 
        double prod = 0; 
        for(int i = 0; i < dim; i++){
           prod +=  values[i] * other.values[i];
        }
        return prod;}


    public double getMagnitude() { 
        double sum = 0;
        for(int i = 0; i < dim; i++){
            sum += values[i] * values[i];
        }
        return Math.sqrt(sum); }


    public void scaleBy(double scalar) {
        for(int i = 0; i < dim; i++){
            values[i] = scalar * values[i];
        }      
    }



    public static MathVector multiply(double scalar, MathVector v) {
       MathVector w = new MathVector(v.dim);
        for(int i = 0; i < v.dim; i++){
            w.values[i] = scalar * v.values[i];
        }     
        return w;
    }


    public void shiftBy(MathVector other) {
        for(int i = 0; i < dim; i++){
            values[i] += other.values[i];
        } 
    }
    public static MathVector add(MathVector v1, MathVector v2) {
        MathVector v3 = new MathVector(v1);
        for(int i = 0; i < v3.dim; i++){
            v3.values[i] += v2.values[i];

        }
        return v3;                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    }
    public static MathVector add(MathVector... vs) {
        if(vs.length == 0){
         return new MathVector(0);
        }
        MathVector w = new MathVector(vs[1].dim);
        for(int i = 0; i < vs.length; i++){
            for(int j = 0; j < w.dim; j++){
                w.values[j] += vs[i].values[j];

            }
        }
        return w;
    }

    public boolean equals(MathVector other) { 
        if(dim != other.dim){
            return false;
        }
        
        for(int i = 0; i<dim; i++){
            if(values[i] != other.values[i]){
                return false; 
            }
            
        }
        return true; }

    public String toString() { return Arrays.toString(values); }
    
}