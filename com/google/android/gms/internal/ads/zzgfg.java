package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgfg {
    private final Class zza;
    private final zzgnk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgfg(Class cls, zzgnk zzgnkVar, zzgff zzgffVar) {
        this.zza = cls;
        this.zzb = zzgnkVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfg)) {
            return false;
        }
        zzgfg zzgfgVar = (zzgfg) obj;
        if (!zzgfgVar.zza.equals(this.zza) || !zzgfgVar.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(this.zzb);
        return simpleName + ", object identifier: " + valueOf;
    }
}
