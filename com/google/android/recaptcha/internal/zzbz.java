package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbz implements zzby {
    @NotNull
    public static final zzbz zza = new zzbz();

    private zzbz() {
    }

    @Nullable
    public static final List zzc(@NotNull Object obj) {
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        List list6;
        if (obj instanceof byte[]) {
            list6 = ArraysKt___ArraysKt.toList((byte[]) obj);
            return list6;
        } else if (obj instanceof short[]) {
            list5 = ArraysKt___ArraysKt.toList((short[]) obj);
            return list5;
        } else if (obj instanceof int[]) {
            list4 = ArraysKt___ArraysKt.toList((int[]) obj);
            return list4;
        } else if (obj instanceof long[]) {
            list3 = ArraysKt___ArraysKt.toList((long[]) obj);
            return list3;
        } else if (obj instanceof float[]) {
            list2 = ArraysKt___ArraysKt.toList((float[]) obj);
            return list2;
        } else if (obj instanceof double[]) {
            list = ArraysKt___ArraysKt.toList((double[]) obj);
            return list;
        } else {
            return null;
        }
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
                if (true != (obj2 instanceof Object)) {
                    obj2 = null;
                }
                if (obj2 != null) {
                    zzblVar.zzc().zzf(i4, zzb(obj, obj2));
                    return;
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }

    @NotNull
    public final Object zzb(@NotNull Object obj, @NotNull Object obj2) throws zzt {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<Number> zzc = zzc(obj);
        List<Number> zzc2 = zzc(obj2);
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return Double.valueOf(Math.pow(((Number) obj).doubleValue(), ((Number) obj2).doubleValue()));
            }
            if (zzc2 != null) {
                collectionSizeOrDefault2 = f.collectionSizeOrDefault(zzc2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                for (Number number : zzc2) {
                    arrayList.add(Double.valueOf(Math.pow(number.doubleValue(), ((Number) obj).doubleValue())));
                }
                return arrayList.toArray(new Double[0]);
            }
        }
        if (zzc != null && (obj2 instanceof Number)) {
            collectionSizeOrDefault = f.collectionSizeOrDefault(zzc, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (Number number2 : zzc) {
                arrayList2.add(Double.valueOf(Math.pow(number2.doubleValue(), ((Number) obj2).doubleValue())));
            }
            return arrayList2.toArray(new Double[0]);
        } else if (zzc != null && zzc2 != null) {
            zzbx.zzb(this, zzc.size(), zzc2.size());
            int size = zzc.size();
            Double[] dArr = new Double[size];
            for (int i4 = 0; i4 < size; i4++) {
                dArr[i4] = Double.valueOf(Math.pow(((Number) zzc.get(i4)).doubleValue(), ((Number) zzc2.get(i4)).doubleValue()));
            }
            return dArr;
        } else {
            throw new zzt(4, 5, null);
        }
    }
}
