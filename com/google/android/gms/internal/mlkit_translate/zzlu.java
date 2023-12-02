package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzlu {
    private final zzlq zza;
    private final zzls zzb;
    private final zzls zzc;
    private final Boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlu(zzlr zzlrVar, zzlt zzltVar) {
        zzlq zzlqVar;
        zzlqVar = zzlrVar.zza;
        this.zza = zzlqVar;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzlu) && Objects.equal(this.zza, ((zzlu) obj).zza) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    @Nullable
    @zzbg(zza = 1)
    public final zzlq zza() {
        return this.zza;
    }
}
