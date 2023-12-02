package com.google.android.recaptcha.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzio extends zziy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(int i4) {
        super(i4, null);
    }

    @Override // com.google.android.recaptcha.internal.zziy
    public final void zza() {
        if (!zzj()) {
            for (int i4 = 0; i4 < zzb(); i4++) {
                ((zzgd) zzg(i4).getKey()).zzg();
            }
            for (Map.Entry entry : zzc()) {
                ((zzgd) entry.getKey()).zzg();
            }
        }
        super.zza();
    }
}
