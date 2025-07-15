package ngovanmanh.ph59521.du_an_mau.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ngovanmanh.ph59521.du_an_mau.Model.DanhMuc;

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
        //Tao bang DANH MỤc
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
}
