package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public class zzgj extends zzgi implements zzhz {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzgj(zzgk zzgkVar) {
        super(zzgkVar);
    }

    @Override // com.google.android.recaptcha.internal.zzgi, com.google.android.recaptcha.internal.zzhx
    /* renamed from: zzd */
    public final zzgk zzk() {
        if (!((zzgk) this.zza).zzF()) {
            return (zzgk) this.zza;
        }
        ((zzgk) this.zza).zzb.zzg();
        return (zzgk) super.zzk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.recaptcha.internal.zzgi
    public final void zzn() {
        super.zzn();
        if (((zzgk) this.zza).zzb != zzge.zzd()) {
            zzgk zzgkVar = (zzgk) this.zza;
            zzgkVar.zzb = zzgkVar.zzb.clone();
        }
    }
}
