public class SachThamKhao extends Sach {
    private double thue, thanhTien;
 
    public SachThamKhao() {
        super();
    }
 
    public SachThamKhao(double thue) {
        super();
        this.thue = thue;
    }
 
    public double getThue() {
        return thue;
    }
 
    public void setThue(double thue) {
        this.thue = thue;
    }
 
    public void nhapSach() {
        super.nhapSach();
        System.out.print("Nhap thue: ");
        thue = scanner.nextDouble();
    }
     
    @Override
    public String toString() {
        return super.toString() + ", thue: " + this.thue;
    }
     
}