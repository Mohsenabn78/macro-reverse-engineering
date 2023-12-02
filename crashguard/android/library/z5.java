package crashguard.android.library;

import android.app.admin.DevicePolicyManager;
import android.app.role.RoleManager;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.stetho.dumpapp.Framer;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
final class z5 {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f39158a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z5(Context context) {
        this.f39158a = new WeakReference<>(context);
    }

    private boolean b(String str) {
        Context context = this.f39158a.get();
        if (context == null || context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return b("android.permission.GET_ACCOUNTS");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        if (Build.VERSION.SDK_INT > 28) {
            return b("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (!b("android.permission.ACCESS_FINE_LOCATION") && !b("android.permission.ACCESS_COARSE_LOCATION")) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return b("android.permission.BLUETOOTH");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        return b("android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return b("android.permission.ACCESS_FINE_LOCATION");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return b(new String(new byte[]{99, 111, 109, 46, 103, 111, 111, 103, 108, 101, 46, 97, 110, 100, 114, 111, 105, 100, 46, 112, 114, 111, 118, 105, 100, 101, 114, 115, 46, 103, 115, 102, 46, 112, 101, 114, 109, 105, 115, 115, 105, 111, 110, 46, 82, 69, 65, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 71, 83, 69, 82, 86, 73, 67, 69, 83}));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h() {
        boolean hasCarrierPrivileges;
        boolean isRoleHeld;
        try {
            Context context = this.f39158a.get();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 > 28) {
                hasCarrierPrivileges = ((TelephonyManager) context.getSystemService("phone")).hasCarrierPrivileges();
                if (!hasCarrierPrivileges) {
                    isRoleHeld = ((RoleManager) context.getSystemService("role")).isRoleHeld("android.app.role.SMS");
                    if (isRoleHeld) {
                        return true;
                    }
                    if ((i4 > 30 && ((DevicePolicyManager) context.getSystemService("device_policy")).isDeviceOwnerApp(context.getPackageName())) || b(new String(new byte[]{97, 110, 100, 114, 111, 105, 100, 46, 112, 101, 114, 109, 105, 115, 115, 105, 111, 110, 46, 82, 69, 65, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 82, 73, 86, 73, 76, 69, 71, 69, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, 80, 72, 79, 78, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 83, 84, 65, 84, 69}))) {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (b("android.permission.READ_PHONE_STATE")) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        return b("android.permission.ACCESS_NETWORK_STATE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j() {
        return b("android.permission.ACCESS_WIFI_STATE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        if (Build.VERSION.SDK_INT > 30) {
            return b("android.permission.BLUETOOTH_CONNECT");
        }
        return b("android.permission.BLUETOOTH");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l() {
        return b("android.permission.READ_PHONE_STATE");
    }
}
