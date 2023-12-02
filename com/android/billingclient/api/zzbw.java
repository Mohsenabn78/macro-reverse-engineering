package com.android.billingclient.api;

import android.text.TextUtils;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes2.dex */
public final class zzbw {
    private String zza;

    private zzbw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbw(zzbv zzbvVar) {
    }

    public final zzbw zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzby zzb() {
        if (!TextUtils.isEmpty(this.zza)) {
            return new zzby(this.zza, null, null, 0, null);
        }
        throw new IllegalArgumentException("SKU must be set.");
    }
}
