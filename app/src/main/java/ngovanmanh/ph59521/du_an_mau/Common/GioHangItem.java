package ngovanmanh.ph59521.du_an_mau.Common;

import androidx.annotation.Nullable;

import ngovanmanh.ph59521.du_an_mau.Model.SanPham;

public class GioHangItem {
    private SanPham sp;
    private int soLuong;

    public GioHangItem(SanPham sp, int soLuong) {
        this.sp = sp;
        this.soLuong = soLuong;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GioHangItem)) throw new IllegalArgumentException();
        GioHangItem item = (GioHangItem) obj;
        return item.getSanPham().getMaSanPham().equals(this.sp.getMaSanPham());
    }

    public SanPham getSanPham() {
        return sp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
} 