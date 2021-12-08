import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SachThamKhao extends Sach {
    private String loai;

    public SachThamKhao() {
        super();
    }

    public SachThamKhao(String maSach, String tenSach, String nhaXuatBan, int soLuong, String loai) {
        super(maSach, tenSach, nhaXuatBan, soLuong);
        this.loai = loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getLoai() {
        return this.loai;
    }

    public void NhapSach() {
        super.NhapSach();
        System.out.print("Nhap loai cua sach: ");
        scanner.nextLine();
        loai = scanner.nextLine();
    }

    @Override
    public List<String> InSach() {
        return Arrays.asList(this.maSach, this.tenSach, this.tenNXB, this.loai, String.valueOf(this.soluong));
    }

    public static void ThongtinSach(ArrayList<SachThamKhao> listsachthamkhao)
    {
        System.out.println("\t\t    ----Thong tin sach tham khao-----");
                    if (listsachthamkhao.size() == 0) {
                        System.out.println("\n\t\t\t    Khong co sach!\n");
                    } else {
                        List<String> headersList = Arrays.asList("Ma sach", "Ten sach", "Nha xuat ban", "Phan loai",
                                "So luong");
                        List<List<String>> rowsList = new ArrayList<List<String>>();
                        for (int i = 0; i < listsachthamkhao.size(); i++) {
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