package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zzlz implements zzmg {
    private final zzmg[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlz(zzmg... zzmgVarArr) {
        this.zza = zzmgVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final zzmf zzb(Class cls) {
        zzmg[] zzmgVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzmg zzmgVar = zzmgVarArr[i4];
            if (zzmgVar.zzc(cls)) {
                return zzmgVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    public final boolean zzc(Class cls) {
        zzmg[] zzmgVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzmgVarArr[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
