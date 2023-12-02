package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeoa implements zzeqx {
    private final boolean zza;

    public zzeoa(boolean z3) {
        this.zza = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        ((Bundle) obj).putBoolean("is_gbid", this.zza);
    }
}
