package Sach.src;

class Sach{
    void nhap(){
        System.out.println("Nhap Sach!");
    }
}
class SachGiaoKhoa extends Sach{
    void nhap(){
        System.out.println("Nhap Sach Giao Khoa!");
    }
}
class SachToan extends SachGiaoKhoa{
    public static void main(String[] args) throws Exception {
        Sach s = new SachToan();
        s.nhap();
    }
}

// class Program {
//     public static void main(String[] args) throws Exception {
//         Sach a1, a2, a3;
//         a1 = new Sach();
//         a2 = new SachGiaoKhoa();
//         a3 = new SachToan();
//         a1.nhap(); a2.nhap(); a3.nhap();
//     }
// }

