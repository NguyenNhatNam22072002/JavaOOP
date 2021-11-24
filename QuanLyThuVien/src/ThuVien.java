import java.util.ArrayList;

public class ThuVien {
    private ArrayList<Sach> sach = new ArrayList<Sach>();
    public void them(Sach s){
        sach.add(s);
    }
    public void xoa(Sach s){
        sach.remove(s);
    }
    public void showSach(){
        for(Sach s : sach){
            s.InSach();
        }
    }
}
