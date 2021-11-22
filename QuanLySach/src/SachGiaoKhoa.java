public class SachGiaoKhoa extends Sach {
    private String tinhTrang;
    private int number;
    private double thanhTien;
 
    public SachGiaoKhoa() {
        super();
    }
 
    public SachGiaoKhoa(String tinhTrang, int number) {
        super();
        this.tinhTrang = tinhTrang;
        this.number = number;
    }
 
 
    public String getTinhTrang() {
        return tinhTrang;
    }
 
 
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
 
 
    public int getNumber() {
        return number;
    }
 
 
    public void setNumber(int number) {
        this.number = number;
    }
 
    public String tinhTrangSach(int x) {
        switch (number) {
            case 0:
                tinhTrang = "cu";
                break;
            case 1:
                tinhTrang = "moi";
                break;
            default:
                break;
        }
        return tinhTrang;
    }
     
    public void nhapSach() {
        super.nhapSach();
        System.out.print("Nhap tinh trang sach (0 - cu/ 1 - moi): ");
        number = scanner.nextInt();
    }
     
    public String toString() {
        return super.toString() + ", tinh trang sach: " + this.tinhTrangSach(number);
    }
}