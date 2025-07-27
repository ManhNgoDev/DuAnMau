package ngovanmanh.ph59521.du_an_mau;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ngovanmanh.ph59521.du_an_mau.Screen.LoginActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class FullAppUITest {
    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);

    // 1. Đăng nhập thành công
    @Test
    public void testLoginSuccess() {
        onView(withId(R.id.edtUsername)).perform(typeText("NV001"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("admin123"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("Quản lý sản phẩm")).check(matches(isDisplayed()));
    }

    // 2. Đăng nhập thất bại
    @Test
    public void testLoginFail() {
        onView(withId(R.id.edtUsername)).perform(typeText("NV001"), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("sai"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withText("Sai tài khoản hoặc mật khẩu!")).check(matches(isDisplayed()));
    }

    // 3. Thêm sản phẩm mới
    @Test
    public void testAddProduct() {
        testLoginSuccess();
        onView(withId(R.id.fabThemDanhMuc)).perform(click());
        onView(withId(R.id.edtTenSanPham)).perform(typeText("Bim Bim Test"), closeSoftKeyboard());
        onView(withId(R.id.edtGiaSanPham)).perform(typeText("10000"), closeSoftKeyboard());
        onView(withId(R.id.edtSoLuong)).perform(typeText("10"), closeSoftKeyboard());
        onView(withId(R.id.edtDonViTinh)).perform(typeText("Gói"), closeSoftKeyboard());
        onView(withId(R.id.edtNgayNhap)).perform(typeText("2024-07-25"), closeSoftKeyboard());
        onView(withId(R.id.btnLuu)).perform(click());
        onView(withText("Bim Bim Test")).check(matches(isDisplayed()));
    }

    // 4. Tìm kiếm sản phẩm
    @Test
    public void testSearchProduct() {
        testLoginSuccess();
        onView(withId(R.id.edtSearch)).perform(typeText("Bim Bim"), closeSoftKeyboard());
        onView(withText("Bim Bim Test")).check(matches(isDisplayed()));
    }

    // 5. Sửa sản phẩm (giả sử click vào sản phẩm đầu tiên)
    @Test
    public void testEditProduct() {
        testLoginSuccess();
        onView(withText("Bim Bim Test")).perform(click());
        onView(withId(R.id.edtTenSanPham)).perform(replaceText("Bim Bim Đã Sửa"), closeSoftKeyboard());
        onView(withId(R.id.btnLuu)).perform(click());
        onView(withText("Bim Bim Đã Sửa")).check(matches(isDisplayed()));
    }

    // 6. Xóa sản phẩm
    @Test
    public void testDeleteProduct() {
        testLoginSuccess();
        onView(withText("Bim Bim Đã Sửa")).perform(longClick());
        onView(withText("Xóa")).perform(click());
        onView(withText("Bim Bim Đã Sửa")).check(doesNotExist());
    }

    // Có thể mở rộng cho các chức năng khác: danh mục, khách hàng, nhân viên, hóa đơn...
} 