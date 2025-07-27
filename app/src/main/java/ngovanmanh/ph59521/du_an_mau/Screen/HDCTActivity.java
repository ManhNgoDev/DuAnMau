package ngovanmanh.ph59521.du_an_mau.Screen;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import ngovanmanh.ph59521.du_an_mau.Adapter.HDCTAdapter;
import ngovanmanh.ph59521.du_an_mau.Database.DatabaseHelper;
import ngovanmanh.ph59521.du_an_mau.R;

public class HDCTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView lvSanPham = findViewById(R.id.lvSanPham);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Hóa Đơn Chi Tiết");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DatabaseHelper db = new DatabaseHelper(this);
        String maHoaDon = getIntent().getStringExtra("maHoaDon");
        HDCTAdapter hdctAdapter = new HDCTAdapter(this, db.layTatCaHDCT(maHoaDon));
        lvSanPham.setAdapter(hdctAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
} 