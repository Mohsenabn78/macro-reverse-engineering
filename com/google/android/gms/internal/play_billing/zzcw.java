package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzcw implements zzdd {
    private final zzdd[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcw(zzdd... zzddVarArr) {
        this.zza = zzddVarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public final zzdc zzb(Class cls) {
        zzdd[] zzddVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzdd zzddVar = zzddVarArr[i4];
            if (zzddVar.zzc(cls)) {
                return zzddVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public final boolean zzc(Class cls) {
        zzdd[] zzddVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzddVarArr[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
