public class People {
    private int _tuoi;
    private String _name;
    public void setName(String N) {
        this._name = N;
    }
    public void setTuoi(int T) {
        this._tuoi = T;
    }
    public void PrintInfo(){
        System.out.println("Ho ten: "+this._name);
        System.out.println("Tuoi: "+this._tuoi);
    }
}
