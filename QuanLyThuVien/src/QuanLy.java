import java.util.ArrayList;
import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args){
        ArrayList ds = new ArrayList();
        Scanner sc = new Scanner(System.in);
        String s;
        int d = 0; 
        do
        {
            System.out.println("Nhap thong tin nguoi muon thu:" + (++d));
            TheThuVien t = new TheThuVien();
            t.NhapInfo();
            ds.add(t);
            System.out.print("Co muon nhap nua khong (Yes/No): ");
            s=sc.nextLine();
         }while(s=="Yes"||s=="yes");
        System.out.println("=============================================");
        
    }
}