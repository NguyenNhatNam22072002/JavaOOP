

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
        
        ArrayList<Sach> thuvien = new ArrayList<Sach>();
        thuvien.add(Conan);     thuvien.add(sachToan);
        Scanner sc = new Scanner(System.in);


        // long maToday1 = System.currentTimeMillis();   
        // Date today1 = new Date(maToday1);  

        // NguoiMuon _Nam = new NguoiMuon("Nam", "0355188464", "dsdsdasdsad");
        // NguoiMuon _Hai = new NguoiMuon("Hai", "0355188464", "dsdsdasdsad");
        // NguoiMuon _Nguyen = new NguoiMuon("Nguyen", "0355188464", "dsdsdasdsad");

        // TheThuVien nam = new TheThuVien(_Nam, "123", today1, "2021-10-11");
        // TheThuVien haiquayxe = new TheThuVien(_Hai, "456", today1, "2021-12-11");
        // TheThuVien nguyen = new TheThuVien(_Nguyen, "789", today1, "2021-10-12");

        ArrayList<TheThuVien> ds = new ArrayList<TheThuVien>();
        // ds.add(nam); ds.add(haiquayxe); ds.add(nguyen); 

        int chon = 0;
        do{
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
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
                        System.out.print("Co tat ca " + listNV.size() + " nhan vien:\n");
                        List<String> headersList = Arrays.asList("Ho ten", "So dien thoai", "Dia chi");
                        List<List<String>> rowsList = new ArrayList<List<String>>();
                        for(int i = 0; i<listNV.size();i++){
                            rowsList.add(listNV.get(i).XuatInfo());
                        }
                        Board board = new Board(75);
                        Table table = new Table(board, 75, headersList, rowsList);
                        List<Integer> colAlignList = Arrays.asList(
                        Block.DATA_CENTER,
                        Block.DATA_CENTER, 
                        Block.DATA_CENTER);
                        List<Integer> colWidthsListEdited = Arrays.asList(20,15,34);
                        table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                        Block block = table.tableToBlocks();
                        board.setInitialBlock(block);
                        board.build();
                        String tableString = board.getPreview();
                        System.out.println(tableString);
                        System.out.println("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                    case 2:
                        System.out.print("So nhan vien can them: ");
                        int nv = sc.nextInt();
                        for(int i=0; i<nv;i++){
                            NhanVien newNV = new NhanVien();
                            newNV.NhapInfo();
                            listNV.add(newNV);
                        }
                        System.out.println("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                }
                break;
            case 2:
                System.out.print("Co tat ca"+ (listsachgiaokhoa.size()+listsachkhac.size()+listsachthamkhao.size()) + " sach:\n");
                System.out.println("\t\t    ---------Thong tin SGK-----------");
                if(listsachgiaokhoa.size()==0){
                    System.out.println("\n\t\t\t    Khong co sach!\n");
                }
                else{
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
                    List<Integer> colWidthsListEdited = Arrays.asList(10, 24, 13, 12, 10);
                    table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                }
                System.out.println("\t\t    ----Thong tin sach tham khao-----");
                if(listsachthamkhao.size()==0){
                    System.out.println("\n\t\t\t    Khong co sach!\n");
                }
                else{
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
                    List<Integer> colWidthsListEdited = Arrays.asList(10, 24, 13, 12, 10);
                    table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                }
                System.out.println("\t\t    -------Thong tin sach khac--------");
                if(listsachkhac.size()==0){
                    System.out.println("\n\t\t\t    Khong co sach!\n");
                }
                else{
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
                    List<Integer> colWidthsListEdited = Arrays.asList(10, 24, 13, 12, 10);
                    table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                }
                System.out.println("Nhan Enter de tiep tuc!");
                sc.nextLine();
                sc.nextLine();
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
                System.out.println("Nhan Enter de tiep tuc!");
                sc.nextLine();
                sc.nextLine();
                break;
            case 4:
                // for(int i = 0; i < ds.size(); i++)
                // {
                //     System.out.println("Thong tin nguoi muon thu " + (i+1) + ":");
                //     ds.get(i).XuatInfo();
                // }
                List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the", "Ngay muon", "Ngay tra");
                List<List<String>> rowsList = new ArrayList<List<String>>();
                for(int i=0; i<ds.size(); i++) {
                    rowsList.add(ds.get(i).XuatInfo());
                }
                Board board = new Board(105);
                Table table = new Table(board, 105, headersList, rowsList);
                List<Integer> colAlignList = Arrays.asList(
                Block.DATA_CENTER, 
                Block.DATA_CENTER, 
                Block.DATA_CENTER, 
                Block.DATA_CENTER, 
                Block.DATA_CENTER,
                Block.DATA_CENTER);
                List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10, 10, 10);
                table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                Block tableBlock = table.tableToBlocks();
                board.setInitialBlock(tableBlock);
                board.build();
                String tableString = board.getPreview();
                System.out.println(tableString);
                int chon3 = 0;
                System.out.println("1.Xem chi tiet. \n2. Thoat");
                chon3 = sc.nextInt(); 
                switch(chon3) {
                    case 1:
                        System.out.print("Nhap ma the: ");
                        sc.nextLine();
                        String mathe = sc.nextLine();
                        List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban");
                        List<List<String>> row = new ArrayList<List<String>>();
                        for(int i = 0; i < ds.size(); i++){
                            if(ds.get(i).getMaThe() == mathe){
                                ArrayList<Sach> CacSach = ds.get(i)._nm._thuvien;
                                for(int j = 0; j < CacSach.size(); j++)
                                    for(int k = 0; k < thuvien.size(); k++)
                                    {
                                        if(CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                            row.add(Arrays.asList(thuvien.get(k).getMaSach(), thuvien.get(k).getTenSach(), thuvien.get(k).getNhaXuatBan()));
                                    }
                                break;
                            }
                        }
                        Board board1 = new Board(72);
                        Table table1 = new Table(board1, 72, header, row);
                        List<Integer> colAlignList1 = Arrays.asList(
                        Block.DATA_CENTER,              
                        Block.DATA_CENTER,
                        Block.DATA_CENTER);
                        List<Integer> colWidthsListEdited1 = Arrays.asList(20, 15, 33);
                        table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1).setGridMode(Table.GRID_FULL);
                        Block tableBlock1 = table1.tableToBlocks();
                        board1.setInitialBlock(tableBlock1);
                        board1.build();
                        String tableString1 = board1.getPreview();
                        System.out.println(tableString1);
                        System.out.println("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                    case 2:
                        break;
                    default:
                        break;
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
                System.out.println("Nhan Enter de tiep tuc!");
                sc.nextLine();
                sc.nextLine();
                break;
        }
    }while(chon!=6);
        sc.close();
    }
    public static void wait(int ms){
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}