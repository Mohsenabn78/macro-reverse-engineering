package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.collections.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcb implements zzby {
    @NotNull
    public static final zzcb zza = new zzcb();

    private zzcb() {
    }

    @Override // com.google.android.recaptcha.internal.zzby
    public final void zza(int i4, @NotNull zzbl zzblVar, @NotNull Object... objArr) throws zzt {
        int collectionSizeOrDefault;
        int length = objArr.length;
        if (length != 0) {
            Object obj = objArr[0];
            if (true != (obj instanceof Class)) {
                obj = null;
            }
            Class cls = (Class) obj;
            if (cls != null) {
                ArrayList<Object> arrayList = new ArrayList();
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    Object obj2 = objArr[i5];
                    int i7 = i6 + 1;
                    if (i6 > 0) {
                        arrayList.add(obj2);
                    }
                    i5++;
                    i6 = i7;
                }
                collectionSizeOrDefault = f.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (Object obj3 : arrayList) {
                    arrayList2.add(zzbk.zza(obj3));
                }
                Class[] clsArr = (Class[]) arrayList2.toArray(new Class[0]);
                try {
                    zzblVar.zzc().zzf(i4, cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length)));
                    return;
                } catch (Exception e4) {
                    throw new zzt(6, 9, e4);
                }
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
