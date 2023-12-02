package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaho  reason: invalid package */
/* loaded from: classes4.dex */
public class zzaho {
    private static final zzagq zzb = zzagq.zza;
    protected volatile zzaii zza;
    private volatile zzafy zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaho)) {
            return false;
        }
        zzaho zzahoVar = (zzaho) obj;
        zzaii zzaiiVar = this.zza;
        zzaii zzaiiVar2 = zzahoVar.zza;
        if (zzaiiVar == null && zzaiiVar2 == null) {
            return zzb().equals(zzahoVar.zzb());
        }
        if (zzaiiVar != null && zzaiiVar2 != null) {
            return zzaiiVar.equals(zzaiiVar2);
        }
        if (zzaiiVar != null) {
            zzahoVar.zzc(zzaiiVar.zzM());
            return zzaiiVar.equals(zzahoVar.zza);
        }
        zzc(zzaiiVar2.zzM());
        return this.zza.equals(zzaiiVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzafv) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzs();
        }
        return 0;
    }

    public final zzafy zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzafy.zzb;
            } else {
                this.zzc = this.zza.zzo();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzaii zzaiiVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzaiiVar;
                    this.zzc = zzafy.zzb;
                } catch (zzahl unused) {
                    this.zza = zzaiiVar;
                    this.zzc = zzafy.zzb;
                }
            }
        }
    }
}
