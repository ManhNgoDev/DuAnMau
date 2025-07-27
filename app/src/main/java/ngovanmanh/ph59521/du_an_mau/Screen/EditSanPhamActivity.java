package ngovanmanh.ph59521.du_an_mau.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ngovanmanh.ph59521.du_an_mau.Database.DatabaseHelper;
import ngovanmanh.ph59521.du_an_mau.Model.DanhMuc;
import ngovanmanh.ph59521.du_an_mau.Model.SanPham;
import ngovanmanh.ph59521.du_an_mau.R;

public class EditSanPhamActivity extends AppCompatActivity {
    private EditText edtMaSanPham, edtTenSanPham, edtGiaSanPham, edtSoLuong, edtDonViTinh, edtNgayNhap;
    private Spinner spDanhMuc;
    private List<DanhMuc> danhMucList;
    private Button btnLuu, btnHuy;
    private DatabaseHelper db;
    private String maSanPham;
    int type;
    LinearLayout layoutMaSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_san_pham);

        db = new DatabaseHelper(this);

        edtMaSanPham = findViewById(R.id.edtMaSanPham);
        edtTenSanPham = findViewById(R.id.edtTenSanPham);
        edtGiaSanPham = findViewById(R.id.edtGiaSanPham);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        edtDonViTinh = findViewById(R.id.edtDonViTinh);
        edtNgayNhap = findViewById(R.id.edtNgayNhap);
        spDanhMuc = findViewById(R.id.spDanhMuc);
        btnLuu = findViewById(R.id.btnLuu);
        btnHuy = findViewById(R.id.btnHuy);
        layoutMaSP = findViewById(R.id.layoutMaSP);

        btnLuu.setOnClickListener(v -> luuSanPham());
        btnHuy.setOnClickListener(v -> finish());

        danhMucList = db.layTatCaDanhMuc();
        ArrayAdapter<DanhMuc> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, danhMucList);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spDanhMuc.setAdapter(adapter);

        Intent intent = getIntent();
        type = intent.getIntExtra("Type", -1);
        if (type == 0) { // Edit
            edtMaSanPham.setEnabled(false);
            SanPham sanPham = intent.getParcelableExtra(QuanLySanPhamActivity.SAN_PHAM);
            if (sanPham != null) {
                edtMaSanPham.setText(sanPham.getMaSanPham());
                edtTenSanPham.setText(sanPham.getTenSanPham());
                edtGiaSanPham.setText(String.valueOf(sanPham.getGiaSanPham()));
                edtSoLuong.setText(String.valueOf(sanPham.getSoLuong()));
                edtDonViTinh.setText(sanPham.getDonViTinh());
                edtNgayNhap.setText(sanPham.getNgayNhap());
                setSelectedDanhMuc(sanPham.getMaDanhMuc());
            }
        } else if (type == 1) { // Add
            layoutMaSP.setVisibility(View.GONE);
        }
    }

    private void setSelectedDanhMuc(String maDanhMucHienTai) {
        for (int i = 0; i < danhMucList.size(); i++) {
            if (danhMucList.get(i).getMaDanhMuc().equals(maDanhMucHienTai)) {
                spDanhMuc.setSelection(i);
                break;
            }
        }
    }

    private void luuSanPham() {
        maSanPham = edtMaSanPham.getText().toString().trim();
        String tenSanPham = edtTenSanPham.getText().toString().trim();
        String giaSanPhamStr = edtGiaSanPham.getText().toString().trim();
        String soLuongStr = edtSoLuong.getText().toString().trim();
        String donViTinh = edtDonViTinh.getText().toString().trim();
        String ngayNhap = edtNgayNhap.getText().toString().trim();
        String maDanhMuc = ((DanhMuc)spDanhMuc.getSelectedItem()).getMaDanhMuc();

        if (tenSanPham.isEmpty() || giaSanPhamStr.isEmpty() || soLuongStr.isEmpty() || donViTinh.isEmpty() || ngayNhap.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin sản phẩm", Toast.LENGTH_SHORT).show();
            return;
        }
        int giaSanPham, soLuong;
        try {
            giaSanPham = Integer.parseInt(giaSanPhamStr);
            soLuong = Integer.parseInt(soLuongStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Giá và số lượng phải là số hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isOK;
        if (type == 0) { // Edit
            SanPham sanPham = new SanPham(maSanPham, tenSanPham, giaSanPham, soLuong, donViTinh, ngayNhap, maDanhMuc);
            isOK = db.suaSanPham(sanPham);
        } else { // Add new
            maSanPham = db.taoMaSanPhamMoi();
            SanPham sanPham = new SanPham(maSanPham, tenSanPham, giaSanPham, soLuong, donViTinh, ngayNhap, maDanhMuc);
            isOK = db.themSanPham(sanPham);
        }
        if (isOK) {
            Toast.makeText(this, (type == 0 ? "Cập nhật " : "Thêm ") + "sản phẩm thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, (type == 0 ? "Cập nhật " : "Thêm ") + "sản phẩm thất bại", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
} 