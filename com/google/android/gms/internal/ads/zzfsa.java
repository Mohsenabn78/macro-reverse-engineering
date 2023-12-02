package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfsa extends zzfqc {
    private final zzfsc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfsa(zzfsc zzfscVar, int i4) {
        super(zzfscVar.size(), i4);
        this.zza = zzfscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfqc
    protected final Object zza(int i4) {
        return this.zza.get(i4);
    }
}
