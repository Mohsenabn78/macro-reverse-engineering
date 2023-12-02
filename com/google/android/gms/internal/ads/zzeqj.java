package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeqj implements zzeqy {
    private final zzbxw zza;
    private final zzfwn zzb;
    private final Context zzc;

    public zzeqj(zzbxw zzbxwVar, zzfwn zzfwnVar, Context context) {
        this.zza = zzbxwVar;
        this.zzb = zzfwnVar;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 34;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqj.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeqk zzc() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        Long l4;
        if (!this.zza.zzu(this.zzc)) {
            return new zzeqk(null, null, null, null, null);
        }
        String zze = this.zza.zze(this.zzc);
        if (zze == null) {
            str = "";
        } else {
            str = zze;
        }
        String zzc = this.zza.zzc(this.zzc);
        if (zzc == null) {
            str2 = "";
        } else {
            str2 = zzc;
        }
        String zza = this.zza.zza(this.zzc);
        if (zza == null) {
            str3 = "";
        } else {
            str3 = zza;
        }
        String zzb = this.zza.zzb(this.zzc);
        if (zzb == null) {
            str4 = "";
        } else {
            str4 = zzb;
        }
        if ("TIME_OUT".equals(str2)) {
            l4 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzag);
        } else {
            l4 = null;
        }
        return new zzeqk(str, str2, str3, str4, l4);
    }
}
