package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzalk implements Comparable {
    private final zzalv zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    @Nullable
    @GuardedBy("mLock")
    private final zzalo zzf;
    private Integer zzg;
    private zzaln zzh;
    @GuardedBy("mLock")
    private boolean zzi;
    @Nullable
    private zzakt zzj;
    @GuardedBy("mLock")
    private zzalj zzk;
    private final zzaky zzl;

    public zzalk(int i4, String str, @Nullable zzalo zzaloVar) {
        zzalv zzalvVar;
        Uri parse;
        String host;
        if (zzalv.zza) {
            zzalvVar = new zzalv();
        } else {
            zzalvVar = null;
        }
        this.zza = zzalvVar;
        this.zze = new Object();
        int i5 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i4;
        this.zzc = str;
        this.zzf = zzaloVar;
        this.zzl = new zzaky();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i5 = host.hashCode();
        }
        this.zzd = i5;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzalk) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        String str = this.zzc;
        Integer num = this.zzg;
        return "[ ] " + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "0x".concat(valueOf) + " NORMAL " + num;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzakt zzd() {
        return this.zzj;
    }

    public final zzalk zze(zzakt zzaktVar) {
        this.zzj = zzaktVar;
        return this;
    }

    public final zzalk zzf(zzaln zzalnVar) {
        this.zzh = zzalnVar;
        return this;
    }

    public final zzalk zzg(int i4) {
        this.zzg = Integer.valueOf(i4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzalq zzh(zzalg zzalgVar);

    public final String zzj() {
        String str = this.zzc;
        if (this.zzb != 0) {
            String num = Integer.toString(1);
            return num + "-" + str;
        }
        return str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaks {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzalv.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzalt zzaltVar) {
        zzalo zzaloVar;
        synchronized (this.zze) {
            zzaloVar = this.zzf;
        }
        zzaloVar.zza(zzaltVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzo(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(String str) {
        zzaln zzalnVar = this.zzh;
        if (zzalnVar != null) {
            zzalnVar.zzb(this);
        }
        if (zzalv.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzali(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzr() {
        zzalj zzaljVar;
        synchronized (this.zze) {
            zzaljVar = this.zzk;
        }
        if (zzaljVar != null) {
            zzaljVar.zza(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzs(zzalq zzalqVar) {
        zzalj zzaljVar;
        synchronized (this.zze) {
            zzaljVar = this.zzk;
        }
        if (zzaljVar != null) {
            zzaljVar.zzb(this, zzalqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzt(int i4) {
        zzaln zzalnVar = this.zzh;
        if (zzalnVar != null) {
            zzalnVar.zzc(this, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu(zzalj zzaljVar) {
        synchronized (this.zze) {
            this.zzk = zzaljVar;
        }
    }

    public final boolean zzv() {
        boolean z3;
        synchronized (this.zze) {
            z3 = this.zzi;
        }
        return z3;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaks {
        return null;
    }

    public final zzaky zzy() {
        return this.zzl;
    }
}
