package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzca implements zzby {
    @NotNull
    public static final zzca zza = new zzca();

    private zzca() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (true != (obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                try {
                    if (obj instanceof String) {
                        obj = zzbx.zza(this, (String) obj, zzblVar.zza());
                    }
                    zzblVar.zzc().zzf(i4, zzbk.zza(obj));
                    return;
                } catch (Exception e4) {
                    throw new zzt(6, 8, e4);
                }
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
