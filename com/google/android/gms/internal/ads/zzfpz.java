package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfpz implements zzfpx {
    private static final zzfpx zza = new zzfpx() { // from class: com.google.android.gms.internal.ads.zzfpy
        @Override // com.google.android.gms.internal.ads.zzfpx
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzfpx zzb;
    @CheckForNull
    private Object zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfpz(zzfpx zzfpxVar) {
        this.zzb = zzfpxVar;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzfpx
    public final Object zza() {
        zzfpx zzfpxVar = this.zzb;
        zzfpx zzfpxVar2 = zza;
        if (zzfpxVar != zzfpxVar2) {
            synchronized (this) {
                if (this.zzb != zzfpxVar2) {
                    Object zza2 = this.zzb.zza();
                    this.zzc = zza2;
                    this.zzb = zzfpxVar2;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
