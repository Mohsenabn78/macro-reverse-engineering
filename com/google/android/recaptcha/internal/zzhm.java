package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public abstract class zzhm {
    private static final zzhm zza = new zzhi(null);
    private static final zzhm zzb = new zzhk(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhm(zzhl zzhlVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm zzd() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm zze() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List zza(Object obj, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(Object obj, Object obj2, long j4);
}
