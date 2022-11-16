package ViewModel;

public class KhachHang {

    private String maKH;
    private String tenKH;
    private int tuoi;
    private boolean gioiTinh;
    private String loaiKH;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, int tuoi, boolean gioiTinh, String loaiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.loaiKH = loaiKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public String trangThai() {
        if (this.getTuoi()> 24) {
            return "Trưởng thành";
        } else {
            return "Chưa trưởng thành";
        }
    }
}
