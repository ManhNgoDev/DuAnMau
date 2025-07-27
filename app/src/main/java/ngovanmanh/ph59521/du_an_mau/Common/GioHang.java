package ngovanmanh.ph59521.du_an_mau.Common;

import java.util.ArrayList;
import java.util.List;

import ngovanmanh.ph59521.du_an_mau.Model.SanPham;

public class GioHang {
    private List<GioHangItem> danhSachGioHang;

    public GioHang() {
        danhSachGioHang = new ArrayList<>();
    }

    public void addSanPham(SanPham sp) {
        for (GioHangItem item : danhSachGioHang) {
            if (item.getSanPham().getMaSanPham().equals(sp.getMaSanPham())) {
                item.setSoLuong(item.getSoLuong() + 1);
                return;
            }
        }
        GioHangItem gioHangItem = new GioHangItem(sp, 1);
        danhSachGioHang.add(gioHangItem);
    }

    public List<GioHangItem> getDanhSachGioHang() {
        return danhSachGioHang;
    }
} 