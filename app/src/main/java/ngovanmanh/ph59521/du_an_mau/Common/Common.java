package ngovanmanh.ph59521.du_an_mau.Common;

public class Common {
    private static GioHang gioHang;
    public static String maNhanVien;

    public static GioHang getGioHang() {
        if (gioHang == null) gioHang = new GioHang();
        return gioHang;
    }
} 