package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbze implements zzaut {
    @VisibleForTesting
    final zzbzb zza;
    private final com.google.android.gms.ads.internal.util.zzg zze;
    private final Object zzd = new Object();
    @VisibleForTesting
    final HashSet zzb = new HashSet();
    @VisibleForTesting
    final HashSet zzc = new HashSet();
    private boolean zzg = false;
    private final zzbzc zzf = new zzbzc();

    public zzbze(String str, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = new zzbzb(str, zzgVar);
        this.zze = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaut
    public final void zza(boolean z3) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        if (z3) {
            if (currentTimeMillis - this.zze.zzd() > ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaQ)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzc();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzt(currentTimeMillis);
        this.zze.zzJ(this.zza.zzd);
    }

    public final zzbyt zzb(Clock clock, String str) {
        return new zzbyt(clock, this, this.zzf.zza(), str);
    }

    public final String zzc() {
        return this.zzf.zzb();
    }

    public final void zzd(zzbyt zzbytVar) {
        synchronized (this.zzd) {
            this.zzb.add(zzbytVar);
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            this.zza.zzb();
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzi(com.google.android.gms.ads.internal.client.zzl zzlVar, long j4) {
        synchronized (this.zzd) {
            this.zza.zzf(zzlVar, j4);
        }
    }

    public final void zzj(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzk() {
        return this.zzg;
    }

    public final Bundle zzl(Context context, zzfbo zzfboVar) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zza(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzbyt) it2.next()).zza());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzfboVar.zzc(hashSet);
            return bundle;
        }
        zzbzd zzbzdVar = (zzbzd) it.next();
        throw null;
    }
}
