package com.arlosoft.macrodroid.telephony;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TelephonyMonitor.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TelephonyMonitor {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static TelephonyDisplayInfo f13645a;
    @NotNull
    public static final TelephonyMonitor INSTANCE = new TelephonyMonitor();
    public static final int $stable = 8;

    private TelephonyMonitor() {
    }

    @Nullable
    public final TelephonyDisplayInfo getTelephonyDisplayInfo() {
        return f13645a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean is5g() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            r2 = 0
            if (r0 < r1) goto L39
            android.telephony.TelephonyDisplayInfo r0 = com.arlosoft.macrodroid.telephony.TelephonyMonitor.f13645a
            r1 = 1
            if (r0 == 0) goto L15
            int r0 = o0.b.a(r0)
            r3 = 2
            if (r0 != r3) goto L15
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            if (r0 != 0) goto L38
            android.telephony.TelephonyDisplayInfo r0 = com.arlosoft.macrodroid.telephony.TelephonyMonitor.f13645a
            if (r0 == 0) goto L25
            int r0 = o0.b.a(r0)
            r3 = 3
            if (r0 != r3) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 != 0) goto L38
            android.telephony.TelephonyDisplayInfo r0 = com.arlosoft.macrodroid.telephony.TelephonyMonitor.f13645a
            if (r0 == 0) goto L35
            int r0 = o0.b.a(r0)
            r3 = 4
            if (r0 != r3) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 == 0) goto L39
        L38:
            r2 = 1
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.telephony.TelephonyMonitor.is5g():boolean");
    }

    public final void monitorTelephonyState(@NotNull Context context) {
        Executor mainExecutor;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 39) {
                mainExecutor = context.getMainExecutor();
                telephonyManager.registerTelephonyCallback(mainExecutor, new TelephonyMonitor$monitorTelephonyState$1());
            } else if (i4 > 30) {
                telephonyManager.listen(new PhoneStateListener() { // from class: com.arlosoft.macrodroid.telephony.TelephonyMonitor$monitorTelephonyState$2
                    @Override // android.telephony.PhoneStateListener
                    public void onDisplayInfoChanged(@NotNull TelephonyDisplayInfo displayInfo) {
                        Intrinsics.checkNotNullParameter(displayInfo, "displayInfo");
                        TelephonyMonitor.INSTANCE.setTelephonyDisplayInfo(displayInfo);
                    }
                }, 1048576);
            }
        } catch (SecurityException unused) {
            SystemLog.logDebug("NOT monitoring telephony display info changes (No permission).");
        }
    }

    public final void setTelephonyDisplayInfo(@Nullable TelephonyDisplayInfo telephonyDisplayInfo) {
        f13645a = telephonyDisplayInfo;
    }
}
