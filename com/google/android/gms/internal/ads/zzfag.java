package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfag {
    private com.google.android.gms.ads.internal.client.zzl zza;
    private com.google.android.gms.ads.internal.client.zzq zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzfl zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbef zzh;
    private com.google.android.gms.ads.internal.client.zzw zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    @Nullable
    private com.google.android.gms.ads.internal.client.zzcb zzl;
    private zzbkr zzn;
    @Nullable
    private zzejm zzq;
    private com.google.android.gms.ads.internal.client.zzcf zzs;
    private int zzm = 1;
    private final zzezt zzo = new zzezt();
    private boolean zzp = false;
    private boolean zzr = false;

    public static /* bridge */ /* synthetic */ String zzH(zzfag zzfagVar) {
        return zzfagVar.zzc;
    }

    public static /* bridge */ /* synthetic */ ArrayList zzJ(zzfag zzfagVar) {
        return zzfagVar.zzf;
    }

    public static /* bridge */ /* synthetic */ ArrayList zzK(zzfag zzfagVar) {
        return zzfagVar.zzg;
    }

    public static /* bridge */ /* synthetic */ boolean zzL(zzfag zzfagVar) {
        return zzfagVar.zzp;
    }

    public static /* bridge */ /* synthetic */ boolean zzM(zzfag zzfagVar) {
        return zzfagVar.zzr;
    }

    public static /* bridge */ /* synthetic */ boolean zzN(zzfag zzfagVar) {
        return zzfagVar.zze;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzcf zzP(zzfag zzfagVar) {
        return zzfagVar.zzs;
    }

    public static /* bridge */ /* synthetic */ int zza(zzfag zzfagVar) {
        return zzfagVar.zzm;
    }

    public static /* bridge */ /* synthetic */ AdManagerAdViewOptions zzb(zzfag zzfagVar) {
        return zzfagVar.zzj;
    }

    public static /* bridge */ /* synthetic */ PublisherAdViewOptions zzc(zzfag zzfagVar) {
        return zzfagVar.zzk;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzl zzd(zzfag zzfagVar) {
        return zzfagVar.zza;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzq zzf(zzfag zzfagVar) {
        return zzfagVar.zzb;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzw zzh(zzfag zzfagVar) {
        return zzfagVar.zzi;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzcb zzi(zzfag zzfagVar) {
        return zzfagVar.zzl;
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzfl zzj(zzfag zzfagVar) {
        return zzfagVar.zzd;
    }

    public static /* bridge */ /* synthetic */ zzbef zzk(zzfag zzfagVar) {
        return zzfagVar.zzh;
    }

    public static /* bridge */ /* synthetic */ zzbkr zzl(zzfag zzfagVar) {
        return zzfagVar.zzn;
    }

    public static /* bridge */ /* synthetic */ zzejm zzm(zzfag zzfagVar) {
        return zzfagVar.zzq;
    }

    public static /* bridge */ /* synthetic */ zzezt zzn(zzfag zzfagVar) {
        return zzfagVar.zzo;
    }

    public final zzfag zzA(zzbef zzbefVar) {
        this.zzh = zzbefVar;
        return this;
    }

    public final zzfag zzB(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfag zzC(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfag zzD(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zzc();
            this.zzl = publisherAdViewOptions.zza();
        }
        return this;
    }

    public final zzfag zzE(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        this.zza = zzlVar;
        return this;
    }

    public final zzfag zzF(com.google.android.gms.ads.internal.client.zzfl zzflVar) {
        this.zzd = zzflVar;
        return this;
    }

    public final zzfai zzG() {
        Preconditions.checkNotNull(this.zzc, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzb, "ad size must not be null");
        Preconditions.checkNotNull(this.zza, "ad request must not be null");
        return new zzfai(this, null);
    }

    public final String zzI() {
        return this.zzc;
    }

    public final boolean zzO() {
        return this.zzp;
    }

    public final zzfag zzQ(com.google.android.gms.ads.internal.client.zzcf zzcfVar) {
        this.zzs = zzcfVar;
        return this;
    }

    public final com.google.android.gms.ads.internal.client.zzl zze() {
        return this.zza;
    }

    public final com.google.android.gms.ads.internal.client.zzq zzg() {
        return this.zzb;
    }

    public final zzezt zzo() {
        return this.zzo;
    }

    public final zzfag zzp(zzfai zzfaiVar) {
        this.zzo.zza(zzfaiVar.zzo.zza);
        this.zza = zzfaiVar.zzd;
        this.zzb = zzfaiVar.zze;
        this.zzs = zzfaiVar.zzr;
        this.zzc = zzfaiVar.zzf;
        this.zzd = zzfaiVar.zza;
        this.zzf = zzfaiVar.zzg;
        this.zzg = zzfaiVar.zzh;
        this.zzh = zzfaiVar.zzi;
        this.zzi = zzfaiVar.zzj;
        zzq(zzfaiVar.zzl);
        zzD(zzfaiVar.zzm);
        this.zzp = zzfaiVar.zzp;
        this.zzq = zzfaiVar.zzc;
        this.zzr = zzfaiVar.zzq;
        return this;
    }

    public final zzfag zzq(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.getManualImpressionsEnabled();
        }
        return this;
    }

    public final zzfag zzr(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzb = zzqVar;
        return this;
    }

    public final zzfag zzs(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfag zzt(com.google.android.gms.ads.internal.client.zzw zzwVar) {
        this.zzi = zzwVar;
        return this;
    }

    public final zzfag zzu(zzejm zzejmVar) {
        this.zzq = zzejmVar;
        return this;
    }

    public final zzfag zzv(zzbkr zzbkrVar) {
        this.zzn = zzbkrVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzfl(false, true, false);
        return this;
    }

    public final zzfag zzw(boolean z3) {
        this.zzp = z3;
        return this;
    }

    public final zzfag zzx(boolean z3) {
        this.zzr = true;
        return this;
    }

    public final zzfag zzy(boolean z3) {
        this.zze = z3;
        return this;
    }

    public final zzfag zzz(int i4) {
        this.zzm = i4;
        return this;
    }
}
