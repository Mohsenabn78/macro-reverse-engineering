package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzak {
    private int zzA;
    private int zzB;
    private int zzC;
    @Nullable
    private String zza;
    @Nullable
    private String zzb;
    @Nullable
    private String zzc;
    private int zzd;
    private int zze;
    private int zzf;
    @Nullable
    private String zzg;
    @Nullable
    private zzbz zzh;
    @Nullable
    private String zzi;
    @Nullable
    private String zzj;
    private int zzk;
    @Nullable
    private List zzl;
    @Nullable
    private zzad zzm;
    private long zzn;
    private int zzo;
    private int zzp;
    private float zzq;
    private int zzr;
    private float zzs;
    @Nullable
    private byte[] zzt;
    private int zzu;
    @Nullable
    private zzs zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private int zzz;

    public zzak() {
        this.zze = -1;
        this.zzf = -1;
        this.zzk = -1;
        this.zzn = Long.MAX_VALUE;
        this.zzo = -1;
        this.zzp = -1;
        this.zzq = -1.0f;
        this.zzs = 1.0f;
        this.zzu = -1;
        this.zzw = -1;
        this.zzx = -1;
        this.zzy = -1;
        this.zzB = -1;
        this.zzC = 0;
    }

    public final zzak zzA(int i4) {
        this.zzC = i4;
        return this;
    }

    public final zzak zzB(@Nullable zzad zzadVar) {
        this.zzm = zzadVar;
        return this;
    }

    public final zzak zzC(int i4) {
        this.zzz = i4;
        return this;
    }

    public final zzak zzD(int i4) {
        this.zzA = i4;
        return this;
    }

    public final zzak zzE(float f4) {
        this.zzq = f4;
        return this;
    }

    public final zzak zzF(int i4) {
        this.zzp = i4;
        return this;
    }

    public final zzak zzG(int i4) {
        this.zza = Integer.toString(i4);
        return this;
    }

    public final zzak zzH(@Nullable String str) {
        this.zza = str;
        return this;
    }

    public final zzak zzI(@Nullable List list) {
        this.zzl = list;
        return this;
    }

    public final zzak zzJ(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    public final zzak zzK(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    public final zzak zzL(int i4) {
        this.zzk = i4;
        return this;
    }

    public final zzak zzM(@Nullable zzbz zzbzVar) {
        this.zzh = zzbzVar;
        return this;
    }

    public final zzak zzN(int i4) {
        this.zzy = i4;
        return this;
    }

    public final zzak zzO(int i4) {
        this.zzf = i4;
        return this;
    }

    public final zzak zzP(float f4) {
        this.zzs = f4;
        return this;
    }

    public final zzak zzQ(@Nullable byte[] bArr) {
        this.zzt = bArr;
        return this;
    }

    public final zzak zzR(int i4) {
        this.zzr = i4;
        return this;
    }

    public final zzak zzS(@Nullable String str) {
        this.zzj = str;
        return this;
    }

    public final zzak zzT(int i4) {
        this.zzx = i4;
        return this;
    }

    public final zzak zzU(int i4) {
        this.zzd = i4;
        return this;
    }

    public final zzak zzV(int i4) {
        this.zzu = i4;
        return this;
    }

    public final zzak zzW(long j4) {
        this.zzn = j4;
        return this;
    }

    public final zzak zzX(int i4) {
        this.zzo = i4;
        return this;
    }

    public final zzam zzY() {
        return new zzam(this);
    }

    public final zzak zzu(int i4) {
        this.zzB = i4;
        return this;
    }

    public final zzak zzv(int i4) {
        this.zze = i4;
        return this;
    }

    public final zzak zzw(int i4) {
        this.zzw = i4;
        return this;
    }

    public final zzak zzx(@Nullable String str) {
        this.zzg = str;
        return this;
    }

    public final zzak zzy(@Nullable zzs zzsVar) {
        this.zzv = zzsVar;
        return this;
    }

    public final zzak zzz(@Nullable String str) {
        this.zzi = ImageUtils.MIME_TYPE_JPEG;
        return this;
    }

    public /* synthetic */ zzak(zzam zzamVar, zzaj zzajVar) {
        this.zza = zzamVar.zzb;
        this.zzb = zzamVar.zzc;
        this.zzc = zzamVar.zzd;
        this.zzd = zzamVar.zze;
        this.zze = zzamVar.zzg;
        this.zzf = zzamVar.zzh;
        this.zzg = zzamVar.zzj;
        this.zzh = zzamVar.zzk;
        this.zzi = zzamVar.zzl;
        this.zzj = zzamVar.zzm;
        this.zzk = zzamVar.zzn;
        this.zzl = zzamVar.zzo;
        this.zzm = zzamVar.zzp;
        this.zzn = zzamVar.zzq;
        this.zzo = zzamVar.zzr;
        this.zzp = zzamVar.zzs;
        this.zzq = zzamVar.zzt;
        this.zzr = zzamVar.zzu;
        this.zzs = zzamVar.zzv;
        this.zzt = zzamVar.zzw;
        this.zzu = zzamVar.zzx;
        this.zzv = zzamVar.zzy;
        this.zzw = zzamVar.zzz;
        this.zzx = zzamVar.zzA;
        this.zzy = zzamVar.zzB;
        this.zzz = zzamVar.zzC;
        this.zzA = zzamVar.zzD;
        this.zzB = zzamVar.zzE;
        this.zzC = zzamVar.zzF;
    }
}
