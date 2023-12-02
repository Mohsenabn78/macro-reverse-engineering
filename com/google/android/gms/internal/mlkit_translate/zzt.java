package com.google.android.gms.internal.mlkit_translate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzt extends zzm {
    private final zzv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzv zzvVar, int i4) {
        super(zzvVar.size(), i4);
        this.zza = zzvVar;
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzm
    protected final Object zza(int i4) {
        return this.zza.get(i4);
    }
}
