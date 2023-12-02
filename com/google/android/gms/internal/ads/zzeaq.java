package com.google.android.gms.internal.ads;

import android.app.Activity;
import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeaq extends zzebm {
    private Activity zza;
    private com.google.android.gms.ads.internal.overlay.zzl zzb;
    private com.google.android.gms.ads.internal.util.zzbr zzc;
    private String zzd;
    private String zze;

    @Override // com.google.android.gms.internal.ads.zzebm
    public final zzebm zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        throw new NullPointerException("Null activity");
    }

    @Override // com.google.android.gms.internal.ads.zzebm
    public final zzebm zzb(@Nullable com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzb = zzlVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzebm
    public final zzebm zzc(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzebm
    public final zzebm zzd(@Nullable String str) {
        this.zze = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzebm
    public final zzebm zze(@Nullable com.google.android.gms.ads.internal.util.zzbr zzbrVar) {
        this.zzc = zzbrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzebm
    public final zzebn zzf() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzeas(activity, this.zzb, this.zzc, this.zzd, this.zze, null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
