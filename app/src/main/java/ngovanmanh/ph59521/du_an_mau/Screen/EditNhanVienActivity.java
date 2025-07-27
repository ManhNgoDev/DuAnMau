package ngovanmanh.ph59521.du_an_mau.Screen;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import ngovanmanh.ph59521.du_an_mau.Database.DatabaseHelper;
import ngovanmanh.ph59521.du_an_mau.Dto.ChucVu;
import ngovanmanh.ph59521.du_an_mau.Model.NhanVien;
import ngovanmanh.ph59521.du_an_mau.R;

public class EditNhanVienActivity extends AppCompatActivity {
    private EditText edtMaNhanVien, edtTenNhanVien, edtDiaChi, edtLuong, edtMatKhau;
    private DatabaseHelper db;
    private int type;
    private List<ChucVu> chucVuList;
    private Spinner spChucVu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nhan_vien);

        db = new DatabaseHelper(this);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        edtMaNhanVien = findViewById(R.id.edtMaNhanVien);
        edtTenNhanVien = findViewById(R.id.edtTenNhanVien);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtLuong = findViewById(R.id.edtLuong);
        edtMatKhau = findViewById(R.id.edtMatKhau);

        findViewById(R.id.btnLuu).setOnClickListener(v -> luuNhanVien());
        findViewById(R.id.btnHuy).setOnClickListener(v -> finish());
        LinearLayout layoutMaNhanVien = findViewById(R.id.layoutMaNhanVien);
        spChucVu = findViewById(R.id.spChucVu);

        chucVuList = new ArrayList<>();
        chucVuList.add(new ChucVu(0, "Nhân viên"));
        chucVuList.add(new ChucVu(1, "Quản lý"));
        ArrayAdapter<ChucVu> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, chucVuList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spChucVu.setAdapter(adapter);

        type = getIntent().getIntExtra("Type", -1);
        if (type == 0) { // Edit
            edtMaNhanVien.setEnabled(false);
            NhanVien nhanVien = getIntent().getParcelableExtra(QuanLyNhanVienActivity.NHAN_VIEN);
            if (nhanVien != null) {
                edtMaNhanVien.setText(nhanVien.getMaNhanVien());
                edtTenNhanVien.setText(nhanVien.getTenNhanVien());
                edtDiaChi.setText(nhanVien.getDiaChi());
                edtLuong.setText(currencyFormat.format(nhanVien.getLuong()));
                edtMatKhau.setText(nhanVien.getMatKhau());
                setSelectedChucVu(nhanVien.getChucVu());
            }
        } else if (type == 1) { // Add
            layoutMaNhanVien.setVisibility(View.GONE);
        }
    }

    private void setSelectedChucVu(int chucVu) {
        for (int i = 0; i < chucVuList.size(); i++) {
            if (chucVuList.get(i).getChucVuCode() == chucVu) {
                spChucVu.setSelection(i);
                break;
            }
        }
    }

    private void luuNhanVien() {
        String maNhanVien = edtMaNhanVien.getText().toString().trim();
        String tenNhanVien = edtTenNhanVien.getText().toString().trim();
        String diaChi = edtDiaChi.getText().toString().trim();
        String luongStr = edtLuong.getText().toString().replaceAll("[^\\d]", "").trim();
        String matKhau = edtMatKhau.getText().toString().trim();
        int chucVu = ((ChucVu)spChucVu.getSelectedItem()).getChucVuCode();

        if (tenNhanVien.isEmpty() || diaChi.isEmpty() || luongStr.isEmpty() || matKhau.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin nhân viên", Toast.LENGTH_SHORT).show();
            return;
        }
        double luong;
        try {
            luong = Double.parseDouble(luongStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Lương phải là số hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isOK;
        if (type == 0) { // Edit
            NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, diaChi, chucVu, luong, matKhau);
            isOK = db.suaNhanVien(nhanVien);
        } else { // Add new
            maNhanVien = db.taoMaNhanVienMoi();
            NhanVien nhanVien = new NhanVien(maNhanVien, tenNhanVien, diaChi, chucVu, luong, matKhau);
            isOK = db.themNhanVien(nhanVien);
        }
        if (isOK) {
            Toast.makeText(this, (type == 0 ? "Cập nhật " : "Thêm ") + "nhân viên thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, (type == 0 ? "Cập nhật " : "Thêm ") + "nhân viên thất bại", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
} 