
public class Results {

    private String functionName;
    private long duration;   
    private int sample;     

    public Results() {
    }

    public Results(String functionName, long duration, int sample) {
        this.functionName = functionName;
        this.duration = duration;
        this.sample = sample;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }
    
    public double getDurationMs() {
        return duration / 1_000_000.0;
    }


    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        double segundos = duration / 1_000_000_000.0;
        return "Results [" + functionName + ", duration=" + duration + "ns, " + segundos + "s, sample=" + sample + "]";
    }

    // Método separado en milisegundos
    public String enMilisegundos() {
        return "Results [" + functionName + ", sample=" + sample + ", "
                + String.format("%.3f", getDurationMs()) + " ms]";
    }
}

