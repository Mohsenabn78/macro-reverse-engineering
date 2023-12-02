package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzhp implements zzhw {
    private final zzhw[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhp(zzhw... zzhwVarArr) {
        this.zza = zzhwVarArr;
    }

    @Override // com.google.android.recaptcha.internal.zzhw
    public final zzhv zzb(Class cls) {
        zzhw[] zzhwVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzhw zzhwVar = zzhwVarArr[i4];
            if (zzhwVar.zzc(cls)) {
                return zzhwVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.recaptcha.internal.zzhw
    public final boolean zzc(Class cls) {
        zzhw[] zzhwVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzhwVarArr[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
