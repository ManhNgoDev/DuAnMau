package ngovanmanh.ph59521.du_an_mau.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import ngovanmanh.ph59521.du_an_mau.Model.DanhMuc;
import ngovanmanh.ph59521.du_an_mau.Model.HoaDon;
import ngovanmanh.ph59521.du_an_mau.Model.HoaDonChiTiet;
import ngovanmanh.ph59521.du_an_mau.Model.KhachHang;
import ngovanmanh.ph59521.du_an_mau.Model.NhanVien;
import ngovanmanh.ph59521.du_an_mau.Model.SanPham;
import ngovanmanh.ph59521.du_an_mau.Model.TopKhachHang;
import ngovanmanh.ph59521.du_an_mau.Model.TopSanPham;
// import ngovanmanh.ph59521.du_an_mau.Dto.HoaDonChiTietDto;
// import ngovanmanh.ph59521.du_an_mau.Dto.HoaDonDto;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "JPMart.db";
    private static final int DB_VERSION = 1;

    public DbHelper(Context mContext) {
        super(mContext, DB_NAME, null, DB_VERSION);
    }
    //Bnag Danh Muc
    public static final String TABLE_DANH_MUC = "DanhMuc";
    public static final String COLUMN_NAME_DANH_MUC = "ten_danh_muc";
    public static final String COLUMN_ID_DANH_MUC = "maDanhMuc";
    //Ten Bang và cac cot
    private static final String TABLE_HOA_DON = "HoaDon";
    private static final String COLUMN_ID_HOA_DON = "maHoaDon";
    private static final String COLUMN_MA_NHAN_VIEN = "maNhanVien";
    private static final String COLUMN_MA_KHACH_HANG = "maKhachHang";
    private static final String COLUMN_NGAY_LAP = "ngayLap";
    private static final String COLUMN_TONG_TIEN = "tongTien";
    //ten bang va cac cot cua bang san pham
    private static final String BANG_SAN_PHAM = "SanPham";
    private static final String COLUMN_ID_SAN_PHAM = "maSanPham";
    private static final String COLUMN_TEN_SAN_PHAM = "tenSanPham";
    private static final String COLUMN_GIA_SAN_PHAM = "giaSanPham";
    private static final String COLUMN_DON_VI_TINH = "donViTinh";
    private static final String COLUMN_NGAY_NHAP = "ngayNhap";
    // ten bang va cac cot cua bang nhan vien
    private static final String BANG_NHAN_VIEN = "NhanVien";
    private static final String COLUMN_ID_NHAN_VIEN = "maNhanVien";
    private static final String COLUMN_TEN_NHAN_VIEN = "tenNhanVien";
    private static final String COLUMN_DIA_CHI = "diaChi";
    private static final String COLUMN_CHUC_VU = "chucVu";
    private static final String COLUMN_LUONG = "luong";
    private static final String COLUMN_MAT_KHAU = "matKhau";
    // ten bang va cac cot cua bang khach hang
    private static final String BANG_KHACH_HANG = "KhachHang";
    private static final String COLUMN_ID_KHACH_HANG = "maKhachHang";
    private static final String COLUMN_TEN_KHACH_HANG = "tenKhachHang";
    private static final String COLUMN_DIA_CHI_KHACH_HANG = "diaChi";
    private static final String COLUMN_SDT_KHACH_HANG = "sdt";
    private static final String COLUMN_EMAIL_KHACH_HANG = "email";
    // ten bang va cac cot cua bang hoa don chi tiet
    private static final String BANG_HOA_DON_CHI_TIET = "HoaDonChiTiet";
    private static final String COLUMN_ID_HOA_DON_CHI_TIET = "maHoaDonChiTiet";
    private static final String COLUMN_MA_HOA_DON = "maHoaDon";
    private static final String COLUMN_MA_SAN_PHAM = "maSanPham";
    private static final String COLUMN_SO_LUONG = "soLuong";
    private static final String COLUMN_DON_GIA = "donGia";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tao bang DANH Mục
        String CREATE_TABLE_DANH_MUC = "CREATE TABLE IF NOT EXISTS " + TABLE_DANH_MUC +
                " (" + COLUMN_ID_DANH_MUC + " TEXT PRIMARY KEY, "
                + COLUMN_NAME_DANH_MUC + " TEXT)";
        //Tao Bang Hoa Don
        String CREATE_TABLE_HOA_DON = "CREATE TABLE IF NOT EXISTS " + TABLE_HOA_DON
                + " (" + COLUMN_ID_HOA_DON + " TEXT PRIMARY KEY, "
                + COLUMN_MA_NHAN_VIEN + " TEXT, "
                + COLUMN_MA_KHACH_HANG + " TEXT, "
                + COLUMN_NGAY_LAP + " TEXT, "
                + COLUMN_TONG_TIEN + " REAL)";
        String CREATE_TABLE_SAN_PHAM = "CREATE TABLE IF NOT EXISTS " + BANG_SAN_PHAM +
                " (" + COLUMN_ID_SAN_PHAM + " TEXT PRIMARY KEY, "
                + COLUMN_TEN_SAN_PHAM + " TEXT, "
                + COLUMN_GIA_SAN_PHAM + " INTEGER, "
                + COLUMN_DON_VI_TINH + " TEXT, "
                + COLUMN_NGAY_NHAP + " TEXT)";
        String CREATE_TABLE_NHAN_VIEN = "CREATE TABLE IF NOT EXISTS " + BANG_NHAN_VIEN +
                " (" + COLUMN_ID_NHAN_VIEN + " TEXT PRIMARY KEY, "
                + COLUMN_TEN_NHAN_VIEN + " TEXT, "
                + COLUMN_DIA_CHI + " TEXT, "
                + COLUMN_CHUC_VU + " TEXT, "
                + COLUMN_LUONG + " REAL, "
                + COLUMN_MAT_KHAU + " TEXT)";
        String CREATE_TABLE_KHACH_HANG = "CREATE TABLE IF NOT EXISTS " + BANG_KHACH_HANG +
                " (" + COLUMN_ID_KHACH_HANG + " TEXT PRIMARY KEY, "
                + COLUMN_TEN_KHACH_HANG + " TEXT, "
                + COLUMN_DIA_CHI_KHACH_HANG + " TEXT, "
                + COLUMN_SDT_KHACH_HANG + " TEXT, "
                + COLUMN_EMAIL_KHACH_HANG + " TEXT)";
        String CREATE_TABLE_HOA_DON_CHI_TIET = "CREATE TABLE IF NOT EXISTS " + BANG_HOA_DON_CHI_TIET +
                " (" + COLUMN_ID_HOA_DON_CHI_TIET + " TEXT PRIMARY KEY, "
                + COLUMN_MA_HOA_DON + " TEXT, "
                + COLUMN_MA_SAN_PHAM + " TEXT, "
                + COLUMN_SO_LUONG + " INTEGER, "
                + COLUMN_DON_GIA + " REAL)";

        db.execSQL(CREATE_TABLE_DANH_MUC);
        db.execSQL(CREATE_TABLE_HOA_DON);
        db.execSQL(CREATE_TABLE_SAN_PHAM);
        db.execSQL(CREATE_TABLE_NHAN_VIEN);
        db.execSQL(CREATE_TABLE_KHACH_HANG);
        db.execSQL(CREATE_TABLE_HOA_DON_CHI_TIET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DANH_MUC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOA_DON);
        db.execSQL("DROP TABLE IF EXISTS " + BANG_SAN_PHAM);
        db.execSQL("DROP TABLE IF EXISTS " + BANG_NHAN_VIEN);
        db.execSQL("DROP TABLE IF EXISTS " + BANG_KHACH_HANG);
        db.execSQL("DROP TABLE IF EXISTS " + BANG_HOA_DON_CHI_TIET);
        onCreate(db);
    }

    // Thêm sản phẩm vào database
    public boolean themSanPham(SanPham sanPham) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_SAN_PHAM, sanPham.getMaSanPham());
        values.put(COLUMN_TEN_SAN_PHAM, sanPham.getTenSanPham());
        values.put(COLUMN_GIA_SAN_PHAM, sanPham.getGiaSanPham());
        values.put(COLUMN_DON_VI_TINH, sanPham.getDonViTinh());
        values.put(COLUMN_NGAY_NHAP, sanPham.getNgayNhap());
        // Nếu có thêm trường số lượng hoặc mã danh mục, bổ sung vào đây
        long result = db.insert(BANG_SAN_PHAM, null, values);
        db.close();
        return result > 0;
    }

    // Lấy thông tin nhân viên theo mã nhân viên
    public NhanVien layNhanVienBangMaNV(String maNhanVien) {
        SQLiteDatabase db = this.getReadableDatabase();
        NhanVien nhanVien = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + BANG_NHAN_VIEN + " WHERE " + COLUMN_ID_NHAN_VIEN + " = ?", new String[]{maNhanVien});
        if (cursor.moveToFirst()) {
            String tenNhanVien = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEN_NHAN_VIEN));
            String diaChi = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIA_CHI));
            int chucVu = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CHUC_VU)));
            double luong = cursor.getDouble(cursor.getColumnIndexOrThrow(COLUMN_LUONG));
            String matKhau = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_MAT_KHAU));
            nhanVien = new NhanVien(maNhanVien, tenNhanVien, diaChi, chucVu, luong, matKhau);
        }
        cursor.close();
        db.close();
        return nhanVien;
    }

    // Thêm khách hàng vào database
    public boolean themKhachHang(KhachHang khachHang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_KHACH_HANG, khachHang.getMaKhachHang());
        values.put(COLUMN_TEN_KHACH_HANG, khachHang.getTenKhachHang());
        values.put(COLUMN_DIA_CHI_KHACH_HANG, khachHang.getDiaChi());
        values.put(COLUMN_SDT_KHACH_HANG, khachHang.getSoDienThoai());
        values.put(COLUMN_EMAIL_KHACH_HANG, khachHang.getEmail());
        long result = db.insert(BANG_KHACH_HANG, null, values);
        db.close();
        return result > 0;
    }

    // Thêm danh mục vào database
    public boolean themDanhMuc(DanhMuc danhMuc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_DANH_MUC, danhMuc.getMaDanhMuc());
        values.put(COLUMN_NAME_DANH_MUC, danhMuc.getTenDanhMuc());
        long result = db.insert(TABLE_DANH_MUC, null, values);
        db.close();
        return result > 0;
    }

    // Thêm nhân viên vào database
    public boolean themNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_NHAN_VIEN, nhanVien.getMaNhanVien());
        values.put(COLUMN_TEN_NHAN_VIEN, nhanVien.getTenNhanVien());
        values.put(COLUMN_DIA_CHI, nhanVien.getDiaChi());
        values.put(COLUMN_CHUC_VU, nhanVien.getChucVu());
        values.put(COLUMN_LUONG, nhanVien.getLuong());
        values.put(COLUMN_MAT_KHAU, nhanVien.getMatKhau());
        long result = db.insert(BANG_NHAN_VIEN, null, values);
        db.close();
        return result > 0;
    }

    // Thêm hóa đơn vào database
    public boolean themHoaDon(HoaDon hoaDon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_HOA_DON, hoaDon.getMaHoaDon());
        values.put(COLUMN_MA_NHAN_VIEN, hoaDon.getMaNhanVien());
        values.put(COLUMN_MA_KHACH_HANG, hoaDon.getMaKhachHang());
        values.put(COLUMN_NGAY_LAP, hoaDon.getNgayLap());
        values.put(COLUMN_TONG_TIEN, hoaDon.getTongTien());
        long result = db.insert(TABLE_HOA_DON, null, values);
        db.close();
        return result > 0;
    }

    // Lấy đơn giá sản phẩm theo mã sản phẩm
    public double layDonGiaSanPham(String maSanPham) {
        SQLiteDatabase db = this.getReadableDatabase();
        double donGia = 0;
        Cursor cursor = db.rawQuery("SELECT " + COLUMN_GIA_SAN_PHAM + " FROM " + BANG_SAN_PHAM + " WHERE " + COLUMN_ID_SAN_PHAM + " = ?", new String[]{maSanPham});
        if (cursor.moveToFirst()) {
            donGia = cursor.getDouble(0);
        }
        cursor.close();
        db.close();
        return donGia;
    }

    // Thêm hóa đơn chi tiết vào database
    public boolean themHDCT(HoaDonChiTiet hoaDonChiTiet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID_HOA_DON_CHI_TIET, hoaDonChiTiet.getMaCTHD());
        values.put(COLUMN_MA_HOA_DON, hoaDonChiTiet.getMaHoaDon());
        values.put(COLUMN_MA_SAN_PHAM, hoaDonChiTiet.getMaSanPham());
        values.put(COLUMN_SO_LUONG, hoaDonChiTiet.getSoLuong());
        values.put(COLUMN_DON_GIA, hoaDonChiTiet.getDonGia());
        long result = db.insert(BANG_HOA_DON_CHI_TIET, null, values);
        db.close();
        return result > 0;
    }

    // Cập nhật tổng tiền hóa đơn
    public void capNhatTongTienHoaDon(String maHoaDon, double tongTien) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " + TABLE_HOA_DON + " SET " + COLUMN_TONG_TIEN + " = ? WHERE " + COLUMN_ID_HOA_DON + " = ?", new Object[]{tongTien, maHoaDon});
        db.close();
    }

    // Cập nhật mật khẩu mới cho nhân viên
    public boolean capNhatMatKhauMoi(String maNhanVien, String matKhauMoi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MAT_KHAU, matKhauMoi);
        int rowsAffected = db.update(BANG_NHAN_VIEN, values, COLUMN_ID_NHAN_VIEN + " = ?", new String[]{maNhanVien});
        db.close();
        return rowsAffected > 0;
    }
}
