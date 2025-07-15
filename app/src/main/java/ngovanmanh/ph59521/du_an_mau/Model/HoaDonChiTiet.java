package ngovanmanh.ph59521.du_an_mau.Model;

public class HoaDonChiTiet {
    private String maHoaDonChiTiet;
    private String maHoaDon;
    private String maSanPham;
    private int soLuong;
    private double donGia;

    public String getMaHoaDonChiTiet() {
        return maHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String maHoaDonChiTiet) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public HoaDonChiTiet(String maHoaDonChiTiet, String maHoaDon, String maSanPham, int soLuong, double donGia) {
        this.maHoaDonChiTiet = maHoaDonChiTiet;
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTiet() {
    }
}
