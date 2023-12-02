package crashguard.android.library;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.stetho.dumpapp.Framer;
import java.util.UUID;

/* loaded from: classes6.dex */
public class SchedulerReceiver extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Context context, String str, boolean z3) {
        j jVar = new j(context, str, z3);
        jVar.c(UUID.randomUUID().toString());
        jVar.a();
    }

    private static void c(final Context context, final String str, final boolean z3) {
        p1.a(new Runnable() { // from class: crashguard.android.library.f
            @Override // java.lang.Runnable
            public final void run() {
                SchedulerReceiver.b(context, str, z3);
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            String str = "BootHeartbeat";
            c(context, "4", false);
            p1.a(new l6(context));
        }
        if ("android.intent.action.TIMEZONE_CHANGED".equals(action)) {
            intent.getStringExtra(new String(new byte[]{116, 105, 109, 101, Framer.STDIN_FRAME_PREFIX, 122, 111, 110, 101}));
            String str2 = "TimezoneHeartbeat";
            c(context, "1", true);
        }
        if ("android.intent.action.TIME_SET".equals(action)) {
            String str3 = "TimeHeartbeat";
            c(context, "1", true);
        }
    }
}
