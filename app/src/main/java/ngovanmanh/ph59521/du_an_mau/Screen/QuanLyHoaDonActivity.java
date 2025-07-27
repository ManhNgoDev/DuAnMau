package ngovanmanh.ph59521.du_an_mau.Screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;
import java.util.Objects;

import ngovanmanh.ph59521.du_an_mau.Adapter.HoaDonAdapter;
import ngovanmanh.ph59521.du_an_mau.Database.DatabaseHelper;
import ngovanmanh.ph59521.du_an_mau.Dto.HoaDonDto;
import ngovanmanh.ph59521.du_an_mau.Model.HoaDon;
import ngovanmanh.ph59521.du_an_mau.R;

public class QuanLyHoaDonActivity extends AppCompatActivity implements HoaDonAdapter.OnHoaDonClickListener {

    private HoaDonAdapter hoaDonAdapter;
    private List<HoaDonDto> danhSachHoaDon;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_hoa_don);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView lvHoaDon = findViewById(R.id.lvHoaDon);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Quản lý hóa đơn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db = new DatabaseHelper(this);

        // Lấy danh sách hóa đơn từ SQLite
        danhSachHoaDon = db.layDanhSachHoaDon();
        hoaDonAdapter = new HoaDonAdapter(this, danhSachHoaDon);
        hoaDonAdapter.setOnHoaDonClickListener(this);
        lvHoaDon.setAdapter(hoaDonAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        danhSachHoaDon.clear();
        danhSachHoaDon.addAll(db.layDanhSachHoaDon());
        hoaDonAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onDeleteHoaDon(HoaDonDto hoaDon) {
        DatabaseHelper db = new DatabaseHelper(this);
        boolean isDeleted = db.xoaHoaDon(hoaDon.getMaHoaDon());
        if (isDeleted) {
            danhSachHoaDon.remove(hoaDon);
            hoaDonAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Xoá hóa đơn thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Xoá hóa đơn thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onOpenHDCT(HoaDonDto hoaDon) {
        // Mở activity chi tiết hóa đơn
        Intent intent = new Intent(this, HDCTActivity.class);
        intent.putExtra("maHoaDon", hoaDon.getMaHoaDon());
        startActivity(intent);
    }
}