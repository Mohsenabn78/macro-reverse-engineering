package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
final class zzah implements zzas {
    private final zzaj zza;
    private zzbc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzah(zzaj zzajVar, zzaf zzafVar) {
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzas
    public final /* bridge */ /* synthetic */ zzas zza(zzbc zzbcVar) {
        this.zzb = zzbcVar;
        return this;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzas
    public final zzat zzb() {
        zzck.zzb(this.zzb, zzbc.class);
        return new zzai(this.zza, this.zzb, null);
    }
}
