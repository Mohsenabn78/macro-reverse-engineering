package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzaup {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final zzave zze;
    private final zzavm zzf;
    private int zzn;
    private final Object zzg = new Object();
    private final ArrayList zzh = new ArrayList();
    private final ArrayList zzi = new ArrayList();
    private final ArrayList zzj = new ArrayList();
    private int zzk = 0;
    private int zzl = 0;
    private int zzm = 0;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";

    public zzaup(int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z3) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
        this.zzd = z3;
        this.zze = new zzave(i7);
        this.zzf = new zzavm(i8, i9, i10);
    }

    private final void zzp(@Nullable String str, boolean z3, float f4, float f5, float f6, float f7) {
        if (str != null) {
            if (str.length() >= this.zzc) {
                synchronized (this.zzg) {
                    this.zzh.add(str);
                    this.zzk += str.length();
                    if (z3) {
                        this.zzi.add(str);
                        this.zzj.add(new zzava(f4, f5, f6, f7, this.zzi.size() - 1));
                    }
                }
            }
        }
    }

    private static final String zzq(ArrayList arrayList, int i4) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            sb.append((String) arrayList.get(i5));
            sb.append(' ');
            i5++;
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaup)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzaup) obj).zzo;
        if (str == null || !str.equals(this.zzo)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zzo.hashCode();
    }

    public final String toString() {
        int i4 = this.zzl;
        int i5 = this.zzn;
        int i6 = this.zzk;
        String zzq = zzq(this.zzh, 100);
        String zzq2 = zzq(this.zzi, 100);
        String str = this.zzo;
        String str2 = this.zzp;
        String str3 = this.zzq;
        return "ActivityContent fetchId: " + i4 + " score:" + i5 + " total_length:" + i6 + "\n text: " + zzq + "\n viewableText" + zzq2 + "\n signture: " + str + "\n viewableSignture: " + str2 + "\n viewableSignatureForVertical: " + str3;
    }

    @VisibleForTesting
    final int zza(int i4, int i5) {
        if (this.zzd) {
            return this.zzb;
        }
        return (i4 * this.zza) + (i5 * this.zzb);
    }

    public final int zzb() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzo;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzq;
    }

    public final void zzg() {
        synchronized (this.zzg) {
            this.zzm--;
        }
    }

    public final void zzh() {
        synchronized (this.zzg) {
            this.zzm++;
        }
    }

    public final void zzi() {
        synchronized (this.zzg) {
            this.zzn -= 100;
        }
    }

    public final void zzj(int i4) {
        this.zzl = i4;
    }

    public final void zzk(String str, boolean z3, float f4, float f5, float f6, float f7) {
        zzp(str, z3, f4, f5, f6, f7);
    }

    public final void zzl(String str, boolean z3, float f4, float f5, float f6, float f7) {
        zzp(str, z3, f4, f5, f6, f7);
        synchronized (this.zzg) {
            if (this.zzm < 0) {
                zzbzr.zze("ActivityContent: negative number of WebViews.");
            }
            zzm();
        }
    }

    public final void zzm() {
        synchronized (this.zzg) {
            int zza = zza(this.zzk, this.zzl);
            if (zza > this.zzn) {
                this.zzn = zza;
                if (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzM()) {
                    this.zzo = this.zze.zza(this.zzh);
                    this.zzp = this.zze.zza(this.zzi);
                }
                if (!com.google.android.gms.ads.internal.zzt.zzo().zzh().zzN()) {
                    this.zzq = this.zzf.zza(this.zzi, this.zzj);
                }
            }
        }
    }

    public final void zzn() {
        synchronized (this.zzg) {
            int zza = zza(this.zzk, this.zzl);
            if (zza > this.zzn) {
                this.zzn = zza;
            }
        }
    }

    public final boolean zzo() {
        boolean z3;
        synchronized (this.zzg) {
            if (this.zzm == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }
}
