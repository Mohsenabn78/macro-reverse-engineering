package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzjp {
    private final zzjl zza;
    private final zzjn zzb;
    private final zzjn zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjp(zzjm zzjmVar, zzjo zzjoVar) {
        zzjl zzjlVar;
        zzjlVar = zzjmVar.zza;
        this.zza = zzjlVar;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzjp) && Objects.equal(this.zza, ((zzjp) obj).zza) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    @Nullable
    @zzbl(zza = 1)
    public final zzjl zza() {
        return this.zza;
    }
}
