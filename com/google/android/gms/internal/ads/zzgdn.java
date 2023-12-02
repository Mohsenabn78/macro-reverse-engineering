package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgdn {
    private final zzgnk zza;
    private final Class zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgdn(zzgnk zzgnkVar, Class cls, zzgdm zzgdmVar) {
        this.zza = zzgnkVar;
        this.zzb = cls;
    }

    public static zzgdn zzb(zzgdl zzgdlVar, zzgnk zzgnkVar, Class cls) {
        return new zzgdk(zzgnkVar, cls, zzgdlVar);
    }

    public abstract zzfxn zza(zzgfd zzgfdVar, @Nullable zzfyq zzfyqVar) throws GeneralSecurityException;

    public final zzgnk zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
