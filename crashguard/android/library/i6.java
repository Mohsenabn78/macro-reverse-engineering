package crashguard.android.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.os.Build;

/* loaded from: classes6.dex */
abstract class i6 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    protected IntentFilter f38850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Context context) {
        boolean z3;
        if (Build.VERSION.SDK_INT > 25) {
            return true;
        }
        try {
            for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getApplicationInfo().packageName, 2).receivers) {
                if (activityInfo.name.equalsIgnoreCase(getClass().getName())) {
                    z3 = true;
                    break;
                }
            }
        } catch (Throwable unused) {
        }
        z3 = false;
        if (!z3) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String[] getActions();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
    }
}
