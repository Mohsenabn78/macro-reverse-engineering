package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfos implements zzfpi {
    public static zzfos zzc(char c4) {
        return new zzfop(c4);
    }

    @Override // com.google.android.gms.internal.ads.zzfpi
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c4);
}
