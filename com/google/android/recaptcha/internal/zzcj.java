package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcj implements zzby {
    @NotNull
    public static final zzcj zza = new zzcj();

    private zzcj() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 1) {
            zzblVar.zzc().zzf(i4, objArr[0]);
            return;
        }
        throw new zzt(4, 3, null);
    }
}
