package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzev extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzey zza;

    public zzev(zzey zzeyVar) {
        this.zza = zzeyVar;
    }

    @Override // android.telephony.TelephonyCallback.DisplayInfoListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int overrideNetworkType;
        boolean z3;
        overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
        int i4 = 5;
        if (overrideNetworkType != 3 && overrideNetworkType != 4 && overrideNetworkType != 5) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzey zzeyVar = this.zza;
        if (true == z3) {
            i4 = 10;
        }
        zzey.zzc(zzeyVar, i4);
    }
}
