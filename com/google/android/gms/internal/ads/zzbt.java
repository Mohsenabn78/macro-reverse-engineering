package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbt {
    @Nullable
    private CharSequence zza;
    @Nullable
    private CharSequence zzb;
    @Nullable
    private CharSequence zzc;
    @Nullable
    private CharSequence zzd;
    @Nullable
    private CharSequence zze;
    @Nullable
    private byte[] zzf;
    @Nullable
    private Integer zzg;
    @Nullable
    private Integer zzh;
    @Nullable
    private Integer zzi;
    @Nullable
    private Integer zzj;
    @Nullable
    private Boolean zzk;
    @Nullable
    private Integer zzl;
    @Nullable
    private Integer zzm;
    @Nullable
    private Integer zzn;
    @Nullable
    private Integer zzo;
    @Nullable
    private Integer zzp;
    @Nullable
    private Integer zzq;
    @Nullable
    private CharSequence zzr;
    @Nullable
    private CharSequence zzs;
    @Nullable
    private CharSequence zzt;
    @Nullable
    private CharSequence zzu;
    @Nullable
    private CharSequence zzv;
    @Nullable
    private Integer zzw;

    public zzbt() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbt(zzbv zzbvVar, zzbs zzbsVar) {
        this.zza = zzbvVar.zzc;
        this.zzb = zzbvVar.zzd;
        this.zzc = zzbvVar.zze;
        this.zzd = zzbvVar.zzf;
        this.zze = zzbvVar.zzg;
        this.zzf = zzbvVar.zzh;
        this.zzg = zzbvVar.zzi;
        this.zzh = zzbvVar.zzj;
        this.zzi = zzbvVar.zzk;
        this.zzj = zzbvVar.zzl;
        this.zzk = zzbvVar.zzm;
        this.zzl = zzbvVar.zzo;
        this.zzm = zzbvVar.zzp;
        this.zzn = zzbvVar.zzq;
        this.zzo = zzbvVar.zzr;
        this.zzp = zzbvVar.zzs;
        this.zzq = zzbvVar.zzt;
        this.zzr = zzbvVar.zzu;
        this.zzs = zzbvVar.zzv;
        this.zzt = zzbvVar.zzw;
        this.zzu = zzbvVar.zzx;
        this.zzv = zzbvVar.zzy;
        this.zzw = zzbvVar.zzz;
    }

    public final zzbt zza(byte[] bArr, int i4) {
        if (this.zzf == null || zzfj.zzC(Integer.valueOf(i4), 3) || !zzfj.zzC(this.zzg, 3)) {
            this.zzf = (byte[]) bArr.clone();
            this.zzg = Integer.valueOf(i4);
        }
        return this;
    }

    public final zzbt zzb(@Nullable zzbv zzbvVar) {
        if (zzbvVar == null) {
            return this;
        }
        CharSequence charSequence = zzbvVar.zzc;
        if (charSequence != null) {
            this.zza = charSequence;
        }
        CharSequence charSequence2 = zzbvVar.zzd;
        if (charSequence2 != null) {
            this.zzb = charSequence2;
        }
        CharSequence charSequence3 = zzbvVar.zze;
        if (charSequence3 != null) {
            this.zzc = charSequence3;
        }
        CharSequence charSequence4 = zzbvVar.zzf;
        if (charSequence4 != null) {
            this.zzd = charSequence4;
        }
        CharSequence charSequence5 = zzbvVar.zzg;
        if (charSequence5 != null) {
            this.zze = charSequence5;
        }
        byte[] bArr = zzbvVar.zzh;
        if (bArr != null) {
            Integer num = zzbvVar.zzi;
            this.zzf = (byte[]) bArr.clone();
            this.zzg = num;
        }
        Integer num2 = zzbvVar.zzj;
        if (num2 != null) {
            this.zzh = num2;
        }
        Integer num3 = zzbvVar.zzk;
        if (num3 != null) {
            this.zzi = num3;
        }
        Integer num4 = zzbvVar.zzl;
        if (num4 != null) {
            this.zzj = num4;
        }
        Boolean bool = zzbvVar.zzm;
        if (bool != null) {
            this.zzk = bool;
        }
        Integer num5 = zzbvVar.zzn;
        if (num5 != null) {
            this.zzl = num5;
        }
        Integer num6 = zzbvVar.zzo;
        if (num6 != null) {
            this.zzl = num6;
        }
        Integer num7 = zzbvVar.zzp;
        if (num7 != null) {
            this.zzm = num7;
        }
        Integer num8 = zzbvVar.zzq;
        if (num8 != null) {
            this.zzn = num8;
        }
        Integer num9 = zzbvVar.zzr;
        if (num9 != null) {
            this.zzo = num9;
        }
        Integer num10 = zzbvVar.zzs;
        if (num10 != null) {
            this.zzp = num10;
        }
        Integer num11 = zzbvVar.zzt;
        if (num11 != null) {
            this.zzq = num11;
        }
        CharSequence charSequence6 = zzbvVar.zzu;
        if (charSequence6 != null) {
            this.zzr = charSequence6;
        }
        CharSequence charSequence7 = zzbvVar.zzv;
        if (charSequence7 != null) {
            this.zzs = charSequence7;
        }
        CharSequence charSequence8 = zzbvVar.zzw;
        if (charSequence8 != null) {
            this.zzt = charSequence8;
        }
        CharSequence charSequence9 = zzbvVar.zzx;
        if (charSequence9 != null) {
            this.zzu = charSequence9;
        }
        CharSequence charSequence10 = zzbvVar.zzy;
        if (charSequence10 != null) {
            this.zzv = charSequence10;
        }
        Integer num12 = zzbvVar.zzz;
        if (num12 != null) {
            this.zzw = num12;
        }
        return this;
    }

    public final zzbt zzc(@Nullable CharSequence charSequence) {
        this.zzd = charSequence;
        return this;
    }

    public final zzbt zzd(@Nullable CharSequence charSequence) {
        this.zzc = charSequence;
        return this;
    }

    public final zzbt zze(@Nullable CharSequence charSequence) {
        this.zzb = charSequence;
        return this;
    }

    public final zzbt zzf(@Nullable CharSequence charSequence) {
        this.zzs = charSequence;
        return this;
    }

    public final zzbt zzg(@Nullable CharSequence charSequence) {
        this.zzt = charSequence;
        return this;
    }

    public final zzbt zzh(@Nullable CharSequence charSequence) {
        this.zze = charSequence;
        return this;
    }

    public final zzbt zzi(@Nullable CharSequence charSequence) {
        this.zzu = charSequence;
        return this;
    }

    public final zzbt zzj(@IntRange(from = 1, to = 31) @Nullable Integer num) {
        this.zzn = num;
        return this;
    }

    public final zzbt zzk(@IntRange(from = 1, to = 12) @Nullable Integer num) {
        this.zzm = num;
        return this;
    }

    public final zzbt zzl(@Nullable Integer num) {
        this.zzl = num;
        return this;
    }

    public final zzbt zzm(@IntRange(from = 1, to = 31) @Nullable Integer num) {
        this.zzq = num;
        return this;
    }

    public final zzbt zzn(@IntRange(from = 1, to = 12) @Nullable Integer num) {
        this.zzp = num;
        return this;
    }

    public final zzbt zzo(@Nullable Integer num) {
        this.zzo = num;
        return this;
    }

    public final zzbt zzp(@Nullable CharSequence charSequence) {
        this.zzv = charSequence;
        return this;
    }

    public final zzbt zzq(@Nullable CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzbt zzr(@Nullable Integer num) {
        this.zzi = num;
        return this;
    }

    public final zzbt zzs(@Nullable Integer num) {
        this.zzh = num;
        return this;
    }

    public final zzbt zzt(@Nullable CharSequence charSequence) {
        this.zzr = charSequence;
        return this;
    }

    public final zzbv zzu() {
        return new zzbv(this);
    }
}
