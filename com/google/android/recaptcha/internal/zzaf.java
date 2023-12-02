package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzaf {
    @NotNull
    private final zzkw zza;
    @NotNull
    private final String zzb;
    @NotNull
    private final String zzc;
    @NotNull
    private final String zzd;
    @Nullable
    private final String zze = null;

    public zzaf(@NotNull zzkw zzkwVar, @NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4) {
        this.zza = zzkwVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzaf) {
            zzaf zzafVar = (zzaf) obj;
            if (zzafVar.zza == this.zza && Intrinsics.areEqual(zzafVar.zzb, this.zzb) && Intrinsics.areEqual(zzafVar.zzc, this.zzc) && Intrinsics.areEqual(zzafVar.zzd, this.zzd) && Intrinsics.areEqual((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    @NotNull
    public final zzkw zza() {
        return this.zza;
    }

    @NotNull
    public final String zzb() {
        return this.zzb;
    }

    @NotNull
    public final String zzc() {
        return this.zzc;
    }

    @NotNull
    public final String zzd() {
        return this.zzd;
    }
}
