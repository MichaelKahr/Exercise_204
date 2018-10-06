
import java.time.LocalDate;

public class Entry {

    private String name;
    private double ak;
    private LocalDate beginning;
    private double nd;
    private double bnd;
    private double afabisher;
    private double wertvorher;
    private double afadj;
    private double bw;

    public Entry(String name, double ak, LocalDate beginning, double nd) {
        this.name = name;
        this.ak = ak;
        this.beginning = beginning;
        this.nd = nd;
    }

    public String getName() {
        return name;
    }

    public double getAk() {
        return ak;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public double getNd() {
        return nd;
    }

    public double getBnd() {
        return bnd;
    }

    public double getAfabisher() {
        return afabisher;
    }

    public double getWertvorher() {
        return wertvorher;
    }

    public double getAfadj() {
        return afadj;
    }

    public double getBw() {
        return bw;
    }

    
    
}
