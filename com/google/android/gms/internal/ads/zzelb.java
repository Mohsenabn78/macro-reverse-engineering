package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzelb implements zzeqy {
    private final zzfwm zza;
    private final Executor zzb;

    public zzelb(zzfwm zzfwmVar, Executor executor) {
        this.zza = zzfwmVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return zzfwc.zzm(this.zza, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzela
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                final String str = (String) obj;
                return zzfwc.zzh(new zzeqx() { // from class: com.google.android.gms.internal.ads.zzekz
                    @Override // com.google.android.gms.internal.ads.zzeqx
                    public final void zzh(Object obj2) {
                        ((Bundle) obj2).putString(TranslateLanguage.MALAY, str);
                    }
                });
            }
        }, this.zzb);
    }
}
