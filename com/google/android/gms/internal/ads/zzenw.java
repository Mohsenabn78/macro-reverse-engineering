package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.mlkit.nl.translate.TranslateLanguage;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzenw implements zzeqx {
    public final String zza;
    public final boolean zzb;

    public zzenw(String str, boolean z3) {
        this.zza = str;
        this.zzb = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqx
    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString(TranslateLanguage.GERMAN, "1");
        }
    }
}
