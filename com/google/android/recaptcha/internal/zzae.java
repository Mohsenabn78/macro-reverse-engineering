package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzae {
    @NotNull
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzae(@NotNull String str, long j4, int i4) {
        this.zza = str;
        this.zzb = j4;
        this.zzc = i4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzae) {
            zzae zzaeVar = (zzae) obj;
            if (Intrinsics.areEqual(zzaeVar.zza, this.zza) && zzaeVar.zzb == this.zzb && zzaeVar.zzc == this.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    @NotNull
    public final String zzc() {
        return this.zza;
    }
}
