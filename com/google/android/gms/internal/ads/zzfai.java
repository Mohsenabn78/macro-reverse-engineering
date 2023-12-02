package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfai {
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzfl zza;
    @Nullable
    public final zzbkr zzb;
    @Nullable
    public final zzejm zzc;
    public final com.google.android.gms.ads.internal.client.zzl zzd;
    public final com.google.android.gms.ads.internal.client.zzq zze;
    public final String zzf;
    public final ArrayList zzg;
    public final ArrayList zzh;
    public final zzbef zzi;
    public final com.google.android.gms.ads.internal.client.zzw zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final com.google.android.gms.ads.internal.client.zzcb zzn;
    public final zzezv zzo;
    public final boolean zzp;
    public final boolean zzq;
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzcf zzr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfai(zzfag zzfagVar, zzfah zzfahVar) {
        com.google.android.gms.ads.internal.client.zzfl zzflVar;
        zzbef zzk;
        this.zze = zzfag.zzf(zzfagVar);
        this.zzf = zzfag.zzH(zzfagVar);
        this.zzr = zzfag.zzP(zzfagVar);
        int i4 = zzfag.zzd(zzfagVar).zza;
        long j4 = zzfag.zzd(zzfagVar).zzb;
        Bundle bundle = zzfag.zzd(zzfagVar).zzc;
        int i5 = zzfag.zzd(zzfagVar).zzd;
        List list = zzfag.zzd(zzfagVar).zze;
        boolean z3 = zzfag.zzd(zzfagVar).zzf;
        int i6 = zzfag.zzd(zzfagVar).zzg;
        boolean z4 = true;
        if (!zzfag.zzd(zzfagVar).zzh && !zzfag.zzN(zzfagVar)) {
            z4 = false;
        }
        this.zzd = new com.google.android.gms.ads.internal.client.zzl(i4, j4, bundle, i5, list, z3, i6, z4, zzfag.zzd(zzfagVar).zzi, zzfag.zzd(zzfagVar).zzj, zzfag.zzd(zzfagVar).zzk, zzfag.zzd(zzfagVar).zzl, zzfag.zzd(zzfagVar).zzm, zzfag.zzd(zzfagVar).zzn, zzfag.zzd(zzfagVar).zzo, zzfag.zzd(zzfagVar).zzp, zzfag.zzd(zzfagVar).zzq, zzfag.zzd(zzfagVar).zzr, zzfag.zzd(zzfagVar).zzs, zzfag.zzd(zzfagVar).zzt, zzfag.zzd(zzfagVar).zzu, zzfag.zzd(zzfagVar).zzv, com.google.android.gms.ads.internal.util.zzs.zza(zzfag.zzd(zzfagVar).zzw), zzfag.zzd(zzfagVar).zzx);
        if (zzfag.zzj(zzfagVar) != null) {
            zzflVar = zzfag.zzj(zzfagVar);
        } else if (zzfag.zzk(zzfagVar) != null) {
            zzflVar = zzfag.zzk(zzfagVar).zzf;
        } else {
            zzflVar = null;
        }
        this.zza = zzflVar;
        this.zzg = zzfag.zzJ(zzfagVar);
        this.zzh = zzfag.zzK(zzfagVar);
        if (zzfag.zzJ(zzfagVar) == null) {
            zzk = null;
        } else if (zzfag.zzk(zzfagVar) == null) {
            zzk = new zzbef(new NativeAdOptions.Builder().build());
        } else {
            zzk = zzfag.zzk(zzfagVar);
        }
        this.zzi = zzk;
        this.zzj = zzfag.zzh(zzfagVar);
        this.zzk = zzfag.zza(zzfagVar);
        this.zzl = zzfag.zzb(zzfagVar);
        this.zzm = zzfag.zzc(zzfagVar);
        this.zzn = zzfag.zzi(zzfagVar);
        this.zzb = zzfag.zzl(zzfagVar);
        this.zzo = new zzezv(zzfag.zzn(zzfagVar), null);
        this.zzp = zzfag.zzL(zzfagVar);
        this.zzc = zzfag.zzm(zzfagVar);
        this.zzq = zzfag.zzM(zzfagVar);
    }

    @Nullable
    public final zzbgi zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null && this.zzl == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzb();
        }
        return this.zzl.zza();
    }

    public final boolean zzb() {
        return this.zzf.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcO));
    }
}
