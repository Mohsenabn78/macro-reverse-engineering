package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahz  reason: invalid package */
/* loaded from: classes4.dex */
final class zzahz implements zzaig {
    private final zzaig[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahz(zzaig... zzaigVarArr) {
        this.zza = zzaigVarArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaig
    public final zzaif zzb(Class cls) {
        zzaig[] zzaigVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            zzaig zzaigVar = zzaigVarArr[i4];
            if (zzaigVar.zzc(cls)) {
                return zzaigVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaig
    public final boolean zzc(Class cls) {
        zzaig[] zzaigVarArr = this.zza;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzaigVarArr[i4].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
