package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.f;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcd implements zzby {
    @NotNull
    public static final zzcd zza = new zzcd();

    private zzcd() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        Class<?> cls;
        List<Object> drop;
        int collectionSizeOrDefault;
        if (objArr.length >= 2) {
            Class<?> cls2 = objArr[0];
            if (true != (cls2 instanceof Object)) {
                cls2 = null;
            }
            if (cls2 != null) {
                if (cls2 instanceof Class) {
                    cls = cls2;
                } else {
                    cls = cls2.getClass();
                }
                Object obj = objArr[1];
                if (true != (obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                if (str != null) {
                    String zza2 = zzbx.zza(this, str, zzblVar.zza());
                    if (!Intrinsics.areEqual(zza2, "forName")) {
                        drop = ArraysKt___ArraysKt.drop(objArr, 2);
                        collectionSizeOrDefault = f.collectionSizeOrDefault(drop, 10);
                        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                        for (Object obj2 : drop) {
                            arrayList.add(zzbk.zza(obj2));
                        }
                        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
                        try {
                            zzblVar.zzc().zzf(i4, cls.getMethod(zza2, (Class[]) Arrays.copyOf(clsArr, clsArr.length)));
                            return;
                        } catch (Exception e4) {
                            throw new zzt(6, 13, e4);
                        }
                    }
                    throw new zzt(6, 48, null);
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
