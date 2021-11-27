

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args){
        NhanVien Nam = new NhanVien("Nam", "0123456", "Dak Lak");
        NhanVien Hai = new NhanVien("Hai", "0987654", "Dong Nai");
        NhanVien Nguyen = new NhanVien("Nguyen", "013579", "Tay Nguyen");
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        listNV.add(Nam); listNV.add(Hai); listNV.add(Nguyen);

        SachGiaoKhoa sachToan = new SachGiaoKhoa("toan", "ToanCaoCap", "KimDong", 1, 13);
        SachKhac Conan = new SachKhac("truyen", "Conlan", "KimDong", 1, "tieuthuyet");
        ArrayList<SachGiaoKhoa> listsachgiaokhoa = new ArrayList<SachGiaoKhoa>();
        ArrayList<SachThamKhao> listsachthamkhao = new ArrayList<SachThamKhao>();
        ArrayList<SachKhac> listsachkhac = new ArrayList<SachKhac>();
        listsachkhac.add(Conan);    listsachgiaokhoa.add(sachToan);
        Scanner sc = new Scanner(System.in);

        ArrayList<TheThuVien> ds = new ArrayList<TheThuVien>();

        int chon = 0;
        do{
        System.out.print("1. Nhan Vien.\n2. Thong tin sach trong thu vien.\n3. Muon sach.\n");
        System.out.print("4. Danh sach nguoi muon.\n5. Danh nguoi muon qua thoi han\n6. Exit.\n");
        System.out.print("Ban chon: ");
        chon = sc.nextInt();
        switch(chon){
            case 1:
                int chon2;
                System.out.print("1. In nhan vien.\n2. Them nhan vien\n"); //2 chức năng của nhân viên 
                System.out.print("Ban chon: ");
                chon2 = sc.nextInt();
                switch(chon2){
                    case 1:
                        System.out.print("Co " + listNV.size() + " nhan vien:\n");
                        for(int i=0; i<listNV.size(); i++){
                            listNV.get(i).XuatInfo();
                        }
                        break;
                    case 2:
                        System.out.print("So nhan vien can them: ");
                        int nv = sc.nextInt();
                        for(int i=0; i<nv;i++){
                            NhanVien newNV = new NhanVien();
                            newNV.NhapInfo();
                            listNV.add(newNV);
                        }
                        break;
                }
                break;
            case 2:
                System.out.print("Co "+ (listsachgiaokhoa.size()+listsachkhac.size()+listsachthamkhao.size()) + " sach:\n");
                System.out.println("\t\t   ---------Thong tin SGK-----------");
                if(listsachgiaokhoa.size()==0){
                    System.out.println("\n\t\t   Khong co sach!\n");
                }
                else{
                    // for(int i = 0; i<listsachgiaokhoa.size(); i++){
                    //     listsachgiaokhoa.get(i).InSach();
                    // }
                    // System.out.print("\n");
                    List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "Phan lop", "So luong");
                    List<List<String>> rowsList = new ArrayList<List<String>>();
                    for(int i=0; i<listsachgiaokhoa.size(); i++) {
                        rowsList.add(listsachgiaokhoa.get(i).InSach());
                    }
                    Board board = new Board(75);
                    Table table = new Table(board, 75, headersList, rowsList);
                    List<Integer> colAlignList = Arrays.asList(
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER);
                    table.setColAlignsList(colAlignList);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                }
                System.out.println("\t\t   ----Thong tin sach tham khao-----");
                if(listsachthamkhao.size()==0){
                    System.out.println("\n\t\t   Khong co sach!\n");
                }
                else{
                    // for(int i = 0; i<listsachthamkhao.size(); i++){
                    //     listsachthamkhao.get(i).InSach();
                    // }
                    // System.out.print("\n");
                    List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "Phan loai", "So luong");
                    List<List<String>> rowsList = new ArrayList<List<String>>();
                    for(int i=0; i<listsachthamkhao.size(); i++) {
                        rowsList.add(listsachthamkhao.get(i).InSach());
                    }
                    Board board = new Board(75);
                    Table table = new Table(board, 75, headersList, rowsList);
                    List<Integer> colAlignList = Arrays.asList(
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER);
                    table.setColAlignsList(colAlignList);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                }
                System.out.println("\t\t   -------Thong tin sach khac--------");
                if(listsachkhac.size()==0){
                    System.out.println("\n\t\t   Khong co sach!\n");
                }
                else{
                    // for(int i = 0; i<listsachkhac.size(); i++){
                    //     listsachkhac.get(i).InSach();
                    // }
                    // System.out.print("\n");
                    List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "The loai", "So luong");
                    List<List<String>> rowsList = new ArrayList<List<String>>();
                    for(int i=0; i<listsachkhac.size(); i++) {
                        rowsList.add(listsachkhac.get(i).InSach());
                    }
                    Board board = new Board(75);
                    Table table = new Table(board, 75, headersList, rowsList);
                    List<Integer> colAlignList = Arrays.asList(
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER);
                    table.setColAlignsList(colAlignList);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                }
                break;
            case 3:
                int s;
                do
                {
                    System.out.println("Nhap thong tin nguoi muon");
                    TheThuVien t = new TheThuVien();
                    t.NhapInfo();
                    ds.add(t);
                    System.out.print("Co muon nhap nua khong (1-Yes/2-No): ");
                    s = sc.nextInt();
                } while(s==1);
                break;
            case 4:
                for(int i = 0; i < ds.size(); i++)
                {
                    System.out.println("Thong tin nguoi muon thu " + (i+1) + ":");
                    ds.get(i).XuatInfo();
                }
                break;
            case 5:
                long maToday = System.currentTimeMillis();   
                Date today = new Date(maToday);   
                for(int i = 0; i < ds.size(); i++)
                {
                    Date date = Date.valueOf(ds.get(i).getNgaytra());
                    if(today.compareTo(date) > 0) 
                    {
                        System.out.println("Thong tin nguoi muon qua han thu " + (i+1) + ":");
                        ds.get(i).XuatInfo();
                    }
                }
                break;
        }
    }while(chon!=6);
        sc.close();
    }
}