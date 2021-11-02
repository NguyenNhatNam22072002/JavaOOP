public class People {
    private int tuoi;
    private String name;
    public void setName(String N) {
        this.name = N;
    }
    public String Name() {
        return this.name;
    }
    public void setTuoi(int T) {
        if(T<=0) {
            System.out.println("Tuoi must be greater than 0");
            return;
        }
        this.tuoi = T;
    }
    public int Tuoi() {
        return this.tuoi;
    }
}
