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
    
    public double calcDurUntilNow(int y){
        return (double) y - year;
    }
    
    public double calcAfAUntilNow(int y){
        return calcDurUntilNow(y)/duration*ak;
    }
    
    public double calcValueBefore(int y){
        return ak-calcAfAUntilNow(y);
    }
    
    public double calcAfA(int y){
        return ak/duration;
    }
    
    public double calcBW(int y){
        System.out.println("Calc: "+y);
        return calcValueBefore(y)-calcAfA(y);
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