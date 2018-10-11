public class Anlage {
    
    private String text;
    private double ak;
    private double year;
    private double duration;

    public Anlage(String text, double ak, double year, double duration) {
        this.text = text;
        this.ak = ak;
        this.year = year;
        this.duration = duration;
    }
    
    public double calcDurUntilNow(int i){
        if((double) i - year < 0){
            return duration;
        }
        if(i - year >= duration){
            return duration;
        }
        return (double) i - year;
    }
    
    public double calcAfAUntilNow(int i){
        return calcDurUntilNow(i)/duration*ak;
    }
    
    public double calcValueBefore(int i){
        double afaUN = calcAfAUntilNow(i);
        if(ak  - afaUN < 0){
            return 0;
        }else{
            return ak - afaUN;
        }
    }
    
    public double calcAfA(int i){
        if(calcValueBefore(i) == 0){
            return 0;
        }else{
            return ak/duration;
        }
    }
    
    public double calcBW(int i){
        return calcValueBefore(i)-calcAfA(i);
    }

    public String getText() {
        return text;
    }

    public double getAk() {
        return ak;
    }

    public double getYear() {
        return year;
    }

    public double getDuration() {
        return duration;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAk(double ak) {
        this.ak = ak;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    
}
