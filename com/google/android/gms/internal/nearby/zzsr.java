package com.google.android.gms.internal.nearby;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzsr extends zzsm {
    private final zzst zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsr(zzst zzstVar, int i4) {
        super(zzstVar.size(), i4);
        this.zza = zzstVar;
    }

    @Override // com.google.android.gms.internal.nearby.zzsm
    protected final Object zza(int i4) {
        return this.zza.get(i4);
    }
}
