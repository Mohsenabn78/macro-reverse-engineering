package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbv implements zzby {
    @NotNull
    public static final zzbv zza = new zzbv();

    private zzbv() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 2) {
            Object obj = objArr[0];
            if (true != (obj instanceof Object)) {
                obj = null;
            }
            if (obj != null) {
                Object obj2 = objArr[1];
                if (true != (obj2 instanceof Integer)) {
                    obj2 = null;
                }
                Integer num = (Integer) obj2;
                if (num != null) {
                    int intValue = num.intValue();
                    try {
                        if (obj instanceof String) {
                            obj = zzbx.zza(this, (String) obj, zzblVar.zza());
                        }
                        zzblVar.zzc().zzf(i4, Array.newInstance(zzbk.zza(obj), intValue));
                        return;
                    } catch (Exception e4) {
                        throw new zzt(6, 21, e4);
                    }
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
