/**
*
* @author LoganZ :>
*/
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args){

        NhanVien Nam = new NhanVien("Nhat Nam", "0123456", "Dak Lak");
        NhanVien Hai = new NhanVien(" Hoang Hai", "0987654", "Dong Nai");
        NhanVien Nguyen = new NhanVien("Tay Nguyen", "0135790", "Tay Nguyen");
        
        ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
        listNV.add(Nam); listNV.add(Hai); listNV.add(Nguyen);

        SachGiaoKhoa sachToan = new SachGiaoKhoa("sgktoan1", "ToanCaoCap", "Kim Dong", 1, 13);
        SachKhac Conan = new SachKhac("conan1", "Conan", "Kim Dong", 1, "Tieu thuyet");
        SachThamKhao thamkhao = new SachThamKhao("tkvan1", "Sach Giai Van 12", "Kim Dong", 2, "Van"); 
        
        ArrayList<SachGiaoKhoa> listsachgiaokhoa = new ArrayList<SachGiaoKhoa>();
        ArrayList<SachThamKhao> listsachthamkhao = new ArrayList<SachThamKhao>();
        ArrayList<SachKhac> listsachkhac = new ArrayList<SachKhac>();

        listsachkhac.add(Conan);    listsachgiaokhoa.add(sachToan);    listsachthamkhao.add(thamkhao);
        
        ArrayList<Sach> thuvien = new ArrayList<Sach>();
        thuvien.add(Conan);     thuvien.add(sachToan);      thuvien.add(thamkhao);
        
        Scanner sc = new Scanner(System.in);



        ArrayList<TheThuVien> ds = new ArrayList<TheThuVien>();

        int chon = 0;
        do{
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.print("1. Nhan Vien.\n2. Thong tin sach trong thu vien.\n3. Dang ky hoi vien\n4. Muon sach.\n");
        System.out.print("5. Danh sach nguoi muon.\n6. Danh nguoi muon qua thoi han\n7. Exit.\n");
        System.out.print("Ban chon: ");
        chon = sc.nextInt();
        switch(chon){
            case 1:
                int chon2;
                System.out.print("\t1. In nhan vien.\n\t2. Them nhan vien\n"); //2 chức năng của nhân viên 
                System.out.print("\tBan chon: ");
                chon2 = sc.nextInt();
                switch(chon2){
                    case 1:
                    System.out.println("\t\t    -------Thong tin nhan vien--------");
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
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                    case 2:
                        System.out.print("\t\tSo nhan vien can them: ");
                        int nv = sc.nextInt();
                        for(int i=0; i<nv;i++){
                            System.out.println("\t\t    ----Nhap thong tin nhan vien thu "+ (i + 1) +"-----");
                            NhanVien newNV = new NhanVien();
                            newNV.NhapInfo();
                            listNV.add(newNV);
                        }
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                        break;
                }
                break;
            case 2:
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
                System.out.print("Nhan Enter de tiep tuc!");
                sc.nextLine();
                sc.nextLine();
                break;
            case 4:
                int s = 0;
                do
                {
                    System.out.println("\t\t    ----Nhap thong tin muon sach-----");
                    int vitri = -1;
                    if(ds.size()<=0){
                        System.out.println("\n\t\t\t    Chua co hoi vien!");
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                    }
                    else{
                        System.out.print("Nhap ma the: ");
                        String mathe = sc.next();
                    do{
                        for(int i = 0; i < ds.size(); i++){
                            if(ds.get(i).getMaThe().equals(mathe)){
                                vitri = i;
                            }
                        }
                        if(vitri == -1){
                            System.out.println("Ma the khong ton tai! Vui long nhap lai!");
                            System.out.print("Nhap lai ma: ");
                            mathe = sc.next();
                        }
                    }while(vitri == -1);
                    ds.get(vitri).NhapInfo();
                    for(int i=0; i<ds.get(vitri)._nm.getSosach(); i++){
                        boolean check = false;
                        if(String.valueOf(ds.get(vitri)._thuvien.get(i).getClass()).equalsIgnoreCase("class SachGiaoKhoa")){
                            for(int j = 0; j<listsachgiaokhoa.size();j++){
                                if(ds.get(vitri)._thuvien.get(i).getMaSach().equals(listsachgiaokhoa.get(j).getMaSach())){
                                    check = true;
                                }
                            }
                            if(!check){
                                System.out.println("Sach co ma '"+ ds.get(vitri)._thuvien.get(i).getMaSach() + "' trong SGK khong ton tai!");
                                System.out.print("Vui long nhap lai ma sach: ");
                                String masach = sc.next();
                                ds.get(vitri)._thuvien.get(i).setMaSach(masach);
                                i-=1;
                                continue;
                            }
                        }
                        if(String.valueOf(ds.get(vitri)._thuvien.get(i).getClass()).equalsIgnoreCase("class SachThamKhao")){
                            for(int j = 0; j<listsachgiaokhoa.size();j++){
                                if(ds.get(vitri)._thuvien.get(i).getMaSach().equals(listsachthamkhao.get(j).getMaSach())){
                                    check = true;
                                }
                            }
                            if(!check){
                                System.out.println("Sach co ma '"+ ds.get(vitri)._thuvien.get(i).getMaSach() + "' trong sach tham khao khong ton tai!");
                                System.out.print("Vui long nhap lai ma sach: ");
                                String masach = sc.next();
                                ds.get(vitri)._thuvien.get(i).setMaSach(masach);
                                i-=1;
                                continue;
                            }
                        }
                        if(String.valueOf(ds.get(vitri)._thuvien.get(i).getClass()).equalsIgnoreCase("class SachKhac")){
                            for(int j = 0; j<listsachgiaokhoa.size();j++){
                                if(ds.get(vitri)._thuvien.get(i).getMaSach().equals(listsachkhac.get(j).getMaSach())){
                                    check = true;
                                }
                            }
                            if(!check){
                                System.out.println("Sach co ma '"+ ds.get(vitri)._thuvien.get(i).getMaSach() + "' trong sach khac khong ton tai!");
                                System.out.print("Vui long nhap lai ma sach: ");
                                String masach = sc.next();
                                ds.get(vitri)._thuvien.get(i).setMaSach(masach);
                                i-=1;
                                continue;
                            }
                        }
                    }
                    for(int i = 0; i<ds.get(vitri)._nm.getSosach();i++){
                        if(String.valueOf(ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass()).equalsIgnoreCase("class SachKhac")){
                            for(int j = 0; j<listsachkhac.size();j++){
                                if(ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach().equals(listsachkhac.get(j).getMaSach())){
                                    listsachkhac.get(j).soluong-=1;
                                }
                            }
                            continue;
                        }
                        if(String.valueOf(ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass()).equalsIgnoreCase("class SachGiaoKhoa")){
                            for(int j = 0; j<listsachgiaokhoa.size();j++){
                                if(ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach().equals(listsachgiaokhoa.get(j).getMaSach())){
                                    listsachgiaokhoa.get(j).soluong-=1;
                                }
                            }
                            continue;
                        }
                        if(String.valueOf(ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getClass()).equalsIgnoreCase("class SachThamKhao")){
                            for(int j = 0; j<listsachthamkhao.size();j++){
                                if(ds.get(vitri)._thuvien.get(ds.get(vitri).sosachdamuon - i - 1).getMaSach().equals(listsachthamkhao.get(j).getMaSach())){
                                    listsachthamkhao.get(j).soluong-=1;
                                }
                            }
                            continue;
                        }
                    }
                    System.out.print("Nhap ngay tra: ");
                    String ngaytra = sc.next();
                    ds.get(vitri)._ngaytra.add(ngaytra);
                    System.out.print("Co muon nhap nua khong (1-Yes/2-No): ");
                    s = sc.nextInt();
                }
                } while(s==1);
                break;
            case 5:
                System.out.println("\t\t\t\t    -------Thong tin nguoi muon--------");
                ArrayList<Integer> vitri = new ArrayList<Integer>();
                if(ds.size()<=0){
                    System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
                    System.out.print("Nhan Enter de tiep tuc!");
                    sc.nextLine();
                    sc.nextLine();
                }
                else{
                    int count = 0;
                    for(int i=0; i<ds.size(); i++){
                        if(ds.get(i)._ngaytra.size() <= 0){
                            count+=1;
                        }
                        else if(ds.get(i)._ngaytra.size() != 0){
                            vitri.add(i);
                        }
                    }
                    if(count == ds.size()){
                        System.out.println("\n\t\t\t\t\t   Khong co nguoi muon!");
                        System.out.print("Nhan Enter de tiep tuc!");
                        sc.nextLine();
                        sc.nextLine();
                    }
                    else{
                List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");
                List<List<String>> rowsList = new ArrayList<List<String>>();
                for(int i=0; i<vitri.size(); i++) {
                    rowsList.add(ds.get(vitri.get(i)).XuatInfo());
                }
                    Board board = new Board(105);
                    Table table = new Table(board, 83, headersList, rowsList);
                    List<Integer> colAlignList = Arrays.asList(
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER);
                    List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10);
                    table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                    int chon3 = 0;
                    System.out.println("1. Xem chi tiet cac sach muon. \n2. Thoat");
                    System.out.print("Ban chon: ");
                    chon3 = sc.nextInt(); 
                    switch(chon3) {
                        case 1:
                            System.out.print("\tNhap ma the: ");
                            String mathe = sc.next();
                            List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban", "Ngay muon", "Ngay tra");
                            List<List<String>> row = new ArrayList<List<String>>();
                            for(int i = 0; i < ds.size(); i++){
                                if(ds.get(i).getMaThe().equals(mathe)){
                                    ArrayList<Sach> CacSach = ds.get(i)._thuvien;
                                    for(int j = 0; j < CacSach.size(); j++)
                                        for(int k = 0; k < thuvien.size(); k++)
                                        {
                                            if(CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                                row.add(Arrays.asList(thuvien.get(k).getMaSach(), thuvien.get(k).getTenSach(), 
                                                thuvien.get(k).getNhaXuatBan(),String.valueOf(ds.get(i)._ngaymuon.get(j)), ds.get(i)._ngaytra.get(j)));
                                        }
                                    break;
                                }
                            }
                            Board board1 = new Board(94);
                            Table table1 = new Table(board1, 94, header, row);
                            List<Integer> colAlignList1 = Arrays.asList(
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER);
                            List<Integer> colWidthsListEdited1 = Arrays.asList(20, 19, 29, 10, 10);
                            table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1).setGridMode(Table.GRID_FULL);
                            Block tableBlock1 = table1.tableToBlocks();
                            board1.setInitialBlock(tableBlock1);
                            board1.build();
                            String tableString1 = board1.getPreview();
                            System.out.println(tableString1);
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }
                }
            }
                break;
            case 6:
                long maToday = System.currentTimeMillis();   
                Date today = new Date(maToday);
                System.out.println("\t\t    -------Thong tin nguoi muon qua han--------");
                List<String> headersList = Arrays.asList("Ho va ten", "So dien thoai", "Dia chi", "Ma the");
                List<List<String>> rowsList = new ArrayList<List<String>>();
                ArrayList<TheThuVien> quahan = new ArrayList<TheThuVien>();
                ArrayList<Integer> vitri1 = new ArrayList<Integer>();
                int index = 0;
                for(int i = 0; i < ds.size(); i++){
                    if(ds.get(i)._ngaytra.size() != 0){
                        vitri1.add(i);
                    }
                    else{
                        index+=1;
                    }
                }
                if(index != 0){
                    System.out.println("\n\t\t\t   Khong co nguoi muon qua han!");
                    System.out.print("Nhan Enter de tiep tuc!");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                }
                for(int i = 0; i < vitri1.size(); i++)
                {
                    for(int j = 0; j < ds.get(vitri1.get(i))._ngaytra.size(); j++){
                        Date date = Date.valueOf(ds.get(vitri1.get(i))._ngaytra.get(j));
                        if(today.compareTo(date) > 0) 
                        {
                            rowsList.add(ds.get(i).XuatInfo());
                            quahan.add(ds.get(i));
                        }
                    }
                }
                if(rowsList.size()<= 0){
                    System.out.println("\n\t\t\t   Khong co nguoi muon qua han!");
                    System.out.print("Nhan Enter de tiep tuc!");
                    sc.nextLine();
                    sc.nextLine();
                }
                else{
                    Board board = new Board(105);
                    Table table = new Table(board, 83, headersList, rowsList);
                    List<Integer> colAlignList = Arrays.asList(
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER, 
                    Block.DATA_CENTER);
                    List<Integer> colWidthsListEdited = Arrays.asList(20, 15, 33, 10);
                    table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited).setGridMode(Table.GRID_FULL);
                    Block tableBlock = table.tableToBlocks();
                    board.setInitialBlock(tableBlock);
                    board.build();
                    String tableString = board.getPreview();
                    System.out.println(tableString);
                    int chon3 = 0;
                    System.out.println("1. Xem chi tiet cac sach muon qua han. \n2. Thoat");
                    System.out.print("Ban chon: ");
                    chon3 = sc.nextInt();
                    switch (chon3) {
                        case 1:
                            System.out.print("\tNhap ma the: ");
                            String mathe = sc.next();
                            List<String> header = Arrays.asList("Ma sach", "Ten Sach", "Ten nha xuat ban", "Ngay muon", "Ngay tra");
                            List<List<String>> row = new ArrayList<List<String>>();
                            for(int i = 0; i < quahan.size(); i++){
                                if(quahan.get(i).getMaThe().equals(mathe)){
                                    ArrayList<Sach> CacSach = quahan.get(i)._thuvien;
                                    for(int j = 0; j < CacSach.size(); j++)
                                        for(int k = 0; k < thuvien.size(); k++)
                                        {
                                            if(CacSach.get(j).getMaSach().equals(thuvien.get(k).getMaSach()))
                                                row.add(Arrays.asList(thuvien.get(k).getMaSach(), thuvien.get(k).getTenSach(), 
                                                thuvien.get(k).getNhaXuatBan(),String.valueOf(ds.get(i)._ngaymuon.get(j)), ds.get(i)._ngaytra.get(j)));
                                        }
                                    break;
                                }
                            }
                            Board board1 = new Board(94);
                            Table table1 = new Table(board1, 94, header, row);
                            List<Integer> colAlignList1 = Arrays.asList(
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.DATA_CENTER,
                            Block.BLOCK_CENTRE);
                            List<Integer> colWidthsListEdited1 = Arrays.asList(20, 19, 29, 10, 10);
                            table1.setColAlignsList(colAlignList1).setColWidthsList(colWidthsListEdited1).setGridMode(Table.GRID_FULL);
                            Block tableBlock1 = table1.tableToBlocks();
                            board1.setInitialBlock(tableBlock1);
                            board1.build();
                            String tableString1 = board1.getPreview();
                            System.out.println(tableString1);
                            System.out.print("Nhan Enter de tiep tuc!");
                            sc.nextLine();
                            sc.nextLine();
                            break;
                        case 2:
                            break;
                        default:
                            break;
                    }
                }
                break;
            case 3:
                System.out.println("\t\t    -------Dang ky the thu vien--------");
                TheThuVien t = new TheThuVien();
                t.Dangky();
                for(int i = 0; i<ds.size(); i++){
                    if(t.getMaThe().equals(ds.get(i).getMaThe())){
                        System.out.println("Ma the da co nguoi dang ky! Vui long ma khac!");
                        System.out.print("Nhap lai ma: ");
                        String mathe = sc.next();
                        t.setMaThe(mathe);
                        i-=1;
                    }
                }
                ds.add(t);
                System.out.println("Dang ky thanh cong!");
                System.out.print("Nhan Enter de tiep tuc!");
                sc.nextLine();
                sc.nextLine();
                break;
            default:
                System.out.println("\t\tTam biet!!!!!");
                wait(1000);
                break;
        }
    }while(chon<7);
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