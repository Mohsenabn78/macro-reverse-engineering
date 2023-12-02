package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzct implements zzda {
    private final zzda[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzct(zzda... zzdaVarArr) {
        this.zza = zzdaVarArr;
    }

    @Override // com.google.android.gms.internal.wearable.zzda
    public final zzcz zzb(Class cls) {
        zzda[] zzdaVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzda zzdaVar = zzdaVarArr[i4];
            if (zzdaVar.zzc(cls)) {
                return zzdaVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.wearable.zzda
    public final boolean zzc(Class cls) {
        zzda[] zzdaVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzdaVarArr[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
