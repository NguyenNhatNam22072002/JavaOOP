public class People {
    private int _tuoi;
    private String _name;
    public void SetInfo(String name, int tuoi) {
        this._name = name;
        this._tuoi = tuoi;
    }
    public void PrintInfo(){
        System.out.println("Ho ten: "+this._name);
        System.out.println("Tuoi: "+this._tuoi);
    }
}