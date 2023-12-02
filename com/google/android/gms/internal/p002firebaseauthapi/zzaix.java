package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaix  reason: invalid package */
/* loaded from: classes4.dex */
final class zzaix extends zzajh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaix(int i4) {
        super(i4, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzajh
    public final void zza() {
        if (!zzj()) {
            for (int i4 = 0; i4 < zzb(); i4++) {
                Map.Entry zzg = zzg(i4);
                if (((zzagu) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzagu) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
