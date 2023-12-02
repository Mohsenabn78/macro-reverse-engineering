package com.arlosoft.macrodroid.telephony;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TelephonyMonitor.kt */
/* loaded from: classes3.dex */
public final class TelephonyMonitor$monitorTelephonyState$1 extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    @Override // android.telephony.TelephonyCallback.DisplayInfoListener
    public void onDisplayInfoChanged(@NotNull TelephonyDisplayInfo displayInfo) {
        Intrinsics.checkNotNullParameter(displayInfo, "displayInfo");
        TelephonyMonitor.INSTANCE.setTelephonyDisplayInfo(displayInfo);
    }
}
