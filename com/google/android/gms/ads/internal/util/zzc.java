package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzr;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzc extends zzb {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19316a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(Context context) {
        this.f19316a = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        boolean z3;
        try {
            z3 = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f19316a);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e4) {
            zzbzr.zzh("Fail to get isAdIdFakeForDebugLogging", e4);
            z3 = false;
        }
        zzbzq.zzj(z3);
        zzbzr.zzj("Update ad debug logging enablement as " + z3);
    }
}
