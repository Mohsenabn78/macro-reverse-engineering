package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbo implements zzby {
    @NotNull
    public static final zzbo zza = new zzbo();

    private zzbo() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        Object array;
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
                    if (obj instanceof Integer) {
                        array = Integer.valueOf(((Number) obj).intValue() + intValue);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        ArrayList arrayList = new ArrayList(iArr.length);
                        for (int i5 : iArr) {
                            arrayList.add(Integer.valueOf(i5 + intValue));
                        }
                        array = arrayList.toArray(new Integer[0]);
                    } else {
                        throw new zzt(4, 5, null);
                    }
                    zzblVar.zzc().zzf(i4, array);
                    return;
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
