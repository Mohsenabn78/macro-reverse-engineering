package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzlq {
    private final String zza;
    private final String zzb;
    private final zzlo zzc;
    private final String zzd;
    private final String zze;
    private final zzln zzf;
    private final Long zzg;
    private final Boolean zzh;
    private final Boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlq(zzlm zzlmVar, zzlp zzlpVar) {
        String str;
        zzlo zzloVar;
        String str2;
        zzln zzlnVar;
        str = zzlmVar.zza;
        this.zza = str;
        this.zzb = null;
        zzloVar = zzlmVar.zzb;
        this.zzc = zzloVar;
        this.zzd = null;
        str2 = zzlmVar.zzc;
        this.zze = str2;
        zzlnVar = zzlmVar.zzd;
        this.zzf = zzlnVar;
        this.zzg = null;
        this.zzh = null;
        this.zzi = null;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzlq)) {
            return false;
        }
        zzlq zzlqVar = (zzlq) obj;
        if (Objects.equal(this.zza, zzlqVar.zza) && Objects.equal(null, null) && Objects.equal(this.zzc, zzlqVar.zzc) && Objects.equal(null, null) && Objects.equal(this.zze, zzlqVar.zze) && Objects.equal(this.zzf, zzlqVar.zzf) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    @Nullable
    @zzbg(zza = 6)
    public final zzln zza() {
        return this.zzf;
    }

    @Nullable
    @zzbg(zza = 3)
    public final zzlo zzb() {
        return this.zzc;
    }

    @Nullable
    @zzbg(zza = 5)
    public final String zzc() {
        return this.zze;
    }

    @Nullable
    @zzbg(zza = 1)
    public final String zzd() {
        return this.zza;
    }
}
