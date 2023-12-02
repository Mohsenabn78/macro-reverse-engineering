package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.3.0 */
/* loaded from: classes4.dex */
final class zzdw extends zzch {
    private final com.google.android.gms.measurement.internal.zzhg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdw(com.google.android.gms.measurement.internal.zzhg zzhgVar) {
        this.zza = zzhgVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j4) {
        this.zza.onEvent(str, str2, bundle, j4);
    }
}
