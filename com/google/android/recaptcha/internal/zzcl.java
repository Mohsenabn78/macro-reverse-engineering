package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcl implements zzby {
    @NotNull
    public static final zzcl zza = new zzcl();

    private zzcl() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 1) {
            Object obj = objArr[0];
            if (true != (obj instanceof Byte)) {
                obj = null;
            }
            Byte b4 = (Byte) obj;
            if (b4 != null) {
                zzblVar.zzh(b4.byteValue());
                return;
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
