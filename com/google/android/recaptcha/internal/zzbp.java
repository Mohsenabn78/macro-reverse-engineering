package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbp implements zzby {
    @NotNull
    public static final zzbp zza = new zzbp();

    private zzbp() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        Object obj;
        if (objArr.length == 2) {
            Object obj2 = objArr[0];
            if (true != (obj2 instanceof Object)) {
                obj2 = null;
            }
            if (obj2 != null) {
                Object obj3 = objArr[1];
                if (true != (obj3 instanceof Integer)) {
                    obj3 = null;
                }
                Integer num = (Integer) obj3;
                if (num != null) {
                    int intValue = num.intValue();
                    try {
                        if (obj2 instanceof String) {
                            obj = String.valueOf(((String) obj2).charAt(intValue));
                        } else if (obj2 instanceof List) {
                            obj = ((List) obj2).get(intValue);
                        } else {
                            obj = Array.get(obj2, intValue);
                        }
                        zzblVar.zzc().zzf(i4, obj);
                        return;
                    } catch (Exception e4) {
                        if (e4 instanceof ArrayIndexOutOfBoundsException) {
                            throw new zzt(4, 22, e4);
                        }
                        throw new zzt(4, 23, e4);
                    }
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
