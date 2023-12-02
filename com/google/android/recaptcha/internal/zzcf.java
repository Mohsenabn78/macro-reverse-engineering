package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcf implements zzby {
    @NotNull
    public static final zzcf zza = new zzcf();

    private zzcf() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        List list;
        int length = objArr.length;
        if (length != 0) {
            Object obj = objArr[0];
            if (true != (obj instanceof Method)) {
                obj = null;
            }
            Method method = (Method) obj;
            if (method != null) {
                list = ArraysKt___ArraysKt.toList(objArr);
                Object[] array = list.subList(1, length).toArray(new Object[0]);
                try {
                    zzblVar.zzc().zzf(i4, method.invoke(null, Arrays.copyOf(array, array.length)));
                    return;
                } catch (Exception e4) {
                    throw new zzt(6, 15, e4);
                }
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
