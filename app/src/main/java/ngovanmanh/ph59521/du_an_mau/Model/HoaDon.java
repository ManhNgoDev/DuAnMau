package ngovanmanh.ph59521.du_an_mau.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class HoaDon implements Parcelable {
    private String maHoaDon;
    private String maNhanVien;
    private String maKhachHang;
    private String ngayLap;
    private int tongTien;

    public HoaDon() {}

    public HoaDon(String maHoaDon, String maNhanVien, String maKhachHang, String ngayLap, int tongTien) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    protected HoaDon(Parcel in) {
        maHoaDon = in.readString();
        maNhanVien = in.readString();
        maKhachHang = in.readString();
        ngayLap = in.readString();
        tongTien = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maHoaDon);
        dest.writeString(maNhanVien);
        dest.writeString(maKhachHang);
        dest.writeString(ngayLap);
        dest.writeInt(tongTien);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HoaDon> CREATOR = new Creator<HoaDon>() {
        @Override
        public HoaDon createFromParcel(Parcel in) {
            return new HoaDon(in);
        }

        @Override
        public HoaDon[] newArray(int size) {
            return new HoaDon[size];
        }
    };

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return maHoaDon + " - " + ngayLap;
    }
}
