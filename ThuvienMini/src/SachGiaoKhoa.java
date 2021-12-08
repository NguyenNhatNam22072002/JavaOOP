
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SachGiaoKhoa extends Sach {
    private int lop;

    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, String tenSach, String nhaXuatBan, int soLuong, int lop) {
        super(maSach, tenSach, nhaXuatBan, soLuong);
        this.lop = lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public int getLop() {
        return lop;
    }

    public void NhapSach() {
        super.NhapSach();
        System.out.print("Nhap lop cua sach: ");
        scanner.nextLine();
        lop = scanner.nextInt();
    }

    @Override
    public List<String> InSach() {
        return Arrays.asList(this.maSach, this.tenSach, this.tenNXB, String.valueOf(this.lop),
                String.valueOf(this.soluong));
    }
    public static void ThongtinSach(ArrayList<SachGiaoKhoa> listsachgiaokhoa)
    {
        System.out.println("\t\t    ---------Thong tin SGK-----------");
                    if (listsachgiaokhoa.size() == 0) {
                        System.out.println("\n\t\t\t    Khong co sach!\n");
                    } else {
                        List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "Phan lop",
                                "So luong");
                        List<List<String>> rowsList = new ArrayList<List<String>>();
                        for (int i = 0; i < listsachgiaokhoa.size(); i++) {
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
                        table.setColAlignsList(colAlignList).setColWidthsList(colWidthsListEdited)
                                .setGridMode(Table.GRID_FULL);
                        Block tableBlock = table.tableToBlocks();
                        board.setInitialBlock(tableBlock);
                        board.build();
                        String tableString = board.getPreview();
                        System.out.println(tableString);
                    }
    }
}