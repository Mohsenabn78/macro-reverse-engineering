package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzdv implements zzec {
    private final zzec[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(zzec... zzecVarArr) {
        this.zza = zzecVarArr;
    }

    @Override // com.google.android.gms.internal.icing.zzec
    public final boolean zzb(Class<?> cls) {
        zzec[] zzecVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzecVarArr[i4].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.icing.zzec
    public final zzeb zzc(Class<?> cls) {
        String str;
        zzec[] zzecVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzec zzecVar = zzecVarArr[i4];
            if (zzecVar.zzb(cls)) {
                return zzecVar.zzc(cls);
            }
        }
        String name = cls.getName();
        if (name.length() != 0) {
            str = "No factory is available for message type: ".concat(name);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }
}
