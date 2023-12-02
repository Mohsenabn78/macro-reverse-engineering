package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzku {
    private final Long zza;
    private final zzld zzb;
    private final Boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzku(zzks zzksVar, zzkt zzktVar) {
        Long l4;
        zzld zzldVar;
        Boolean bool;
        l4 = zzksVar.zza;
        this.zza = l4;
        zzldVar = zzksVar.zzb;
        this.zzb = zzldVar;
        bool = zzksVar.zzc;
        this.zzc = bool;
    }

    @Nullable
    @zzbg(zza = 2)
    public final zzld zza() {
        return this.zzb;
    }

    @Nullable
    @zzbg(zza = 3)
    public final Boolean zzb() {
        return this.zzc;
    }

    @Nullable
    @zzbg(zza = 1)
    public final Long zzc() {
        return this.zza;
    }
}
