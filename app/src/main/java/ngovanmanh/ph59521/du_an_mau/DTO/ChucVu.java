package ngovanmanh.ph59521.du_an_mau.Dto;

import androidx.annotation.NonNull;

public class ChucVu {
    private int chucVuCode;
    private String chucVuName;

    public ChucVu(int chucVuCode, String chucVuName) {
        this.chucVuCode = chucVuCode;
        this.chucVuName = chucVuName;
    }

    @NonNull
    @Override
    public String toString() {
        return chucVuName;
    }

    public int getChucVuCode() {
        return chucVuCode;
    }

    public void setChucVuCode(int chucVuCode) {
        this.chucVuCode = chucVuCode;
    }

    public String getChucVuName() {
        return chucVuName;
    }

    public void setChucVuName(String chucVuName) {
        this.chucVuName = chucVuName;
    }
}
