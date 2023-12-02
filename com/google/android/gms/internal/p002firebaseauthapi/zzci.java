package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzci  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzci {
    @Nullable
    private final Object zza;
    @Nullable
    private final Object zzb;
    private final byte[] zzc;
    private final zzui zzd;
    private final int zze;
    private final String zzf;
    private final zzbn zzg;
    private final int zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzci(@Nullable Object obj, @Nullable Object obj2, byte[] bArr, int i4, zzui zzuiVar, int i5, String str, zzbn zzbnVar) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzh = i4;
        this.zzd = zzuiVar;
        this.zze = i5;
        this.zzf = str;
        this.zzg = zzbnVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzbn zzb() {
        return this.zzg;
    }

    public final zzui zzc() {
        return this.zzd;
    }

    @Nullable
    public final Object zzd() {
        return this.zza;
    }

    @Nullable
    public final Object zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    @Nullable
    public final byte[] zzg() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzh() {
        return this.zzh;
    }
}
