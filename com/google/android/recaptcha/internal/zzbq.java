package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbq implements zzby {
    @NotNull
    public static final zzbq zza = new zzbq();

    private zzbq() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        if (objArr.length == 3) {
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
                    Object obj3 = objArr[2];
                    if (true != (obj3 instanceof Object)) {
                        obj3 = null;
                    }
                    if (obj3 != null) {
                        try {
                            Array.set(obj, intValue, obj3);
                            return;
                        } catch (Exception e4) {
                            if (e4 instanceof ArrayIndexOutOfBoundsException) {
                                throw new zzt(4, 22, e4);
                            }
                            throw new zzt(4, 25, e4);
                        }
                    }
                    throw new zzt(4, 5, null);
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
