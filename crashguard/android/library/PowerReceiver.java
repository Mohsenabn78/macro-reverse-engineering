package crashguard.android.library;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import java.util.UUID;

/* loaded from: classes6.dex */
public class PowerReceiver extends i6 {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, String str, boolean z3) {
        j jVar = new j(context, str, z3);
        jVar.c(UUID.randomUUID().toString());
        jVar.a();
    }

    private static void d(final Context context, final String str, final boolean z3) {
        p1.a(new Runnable() { // from class: crashguard.android.library.e
            @Override // java.lang.Runnable
            public final void run() {
                PowerReceiver.c(context, str, z3);
            }
        });
    }

    @Override // crashguard.android.library.i6
    public String[] getActions() {
        return new String[]{"android.intent.action.ACTION_POWER_CONNECTED", "android.intent.action.ACTION_POWER_DISCONNECTED"};
    }

    @Override // crashguard.android.library.i6, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        String str;
        super.onReceive(context, intent);
        if (!n0.b() && !Debug.isDebuggerConnected()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3 || new e1(context).e() == null) {
            return;
        }
        String action = intent.getAction();
        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED") || action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                str = "5";
            } else {
                str = "6";
            }
            d(context, str, action.equals("android.intent.action.ACTION_POWER_CONNECTED"));
        }
    }
}
