package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgqn implements zzgqu {
    private final zzgqu[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgqn(zzgqu... zzgquVarArr) {
        this.zza = zzgquVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgqu
    public final zzgqt zzb(Class cls) {
        zzgqu[] zzgquVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzgqu zzgquVar = zzgquVarArr[i4];
            if (zzgquVar.zzc(cls)) {
                return zzgquVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.ads.zzgqu
    public final boolean zzc(Class cls) {
        zzgqu[] zzgquVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzgquVarArr[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
