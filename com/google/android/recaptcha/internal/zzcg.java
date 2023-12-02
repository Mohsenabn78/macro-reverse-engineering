package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.f;
import kotlin.ranges.IntRange;
import kotlin.ranges.h;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcg implements zzby {
    @NotNull
    public static final zzcg zza = new zzcg();

    private zzcg() {
    }

    private final Object zzb(Object obj, Object obj2) throws zzt, ArithmeticException {
        IntRange until;
        int collectionSizeOrDefault;
        IntRange until2;
        int collectionSizeOrDefault2;
        IntRange until3;
        int collectionSizeOrDefault3;
        IntRange until4;
        int collectionSizeOrDefault4;
        IntRange until5;
        int collectionSizeOrDefault5;
        IntRange until6;
        int collectionSizeOrDefault6;
        int[] intArray;
        int[] intArray2;
        byte[] byteArray;
        boolean z3 = obj instanceof Byte;
        if (z3 && (obj2 instanceof Byte)) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z4 = obj instanceof Short;
        if (z4 && (obj2 instanceof Short)) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z5 = obj instanceof Integer;
        if (z5 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() % ((Number) obj2).intValue());
        }
        boolean z6 = obj instanceof Long;
        if (z6 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj).longValue() % ((Number) obj2).longValue());
        }
        boolean z7 = obj instanceof Float;
        if (z7 && (obj2 instanceof Float)) {
            return Float.valueOf(((Number) obj).floatValue() % ((Number) obj2).floatValue());
        }
        boolean z8 = obj instanceof Double;
        if (z8 && (obj2 instanceof Double)) {
            return Double.valueOf(((Number) obj).doubleValue() % ((Number) obj2).doubleValue());
        }
        int i4 = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i4 < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i4] % ((Number) obj2).intValue())));
                    i4++;
                }
                byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
                return new String(byteArray, Charsets.UTF_8);
            } else if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i4 < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i4] % ((Number) obj2).intValue()));
                    i4++;
                }
                intArray2 = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
                return intArray2;
            }
        }
        if (z3 && (obj2 instanceof byte[])) {
            byte[] bArr = (byte[]) obj2;
            ArrayList arrayList3 = new ArrayList(bArr.length);
            for (byte b4 : bArr) {
                arrayList3.add(Integer.valueOf(b4 % ((Number) obj).intValue()));
            }
            return arrayList3.toArray(new Integer[0]);
        } else if (z4 && (obj2 instanceof short[])) {
            short[] sArr = (short[]) obj2;
            ArrayList arrayList4 = new ArrayList(sArr.length);
            for (short s3 : sArr) {
                arrayList4.add(Integer.valueOf(s3 % ((Number) obj).intValue()));
            }
            return arrayList4.toArray(new Integer[0]);
        } else if (z5 && (obj2 instanceof int[])) {
            int[] iArr = (int[]) obj2;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            for (int i5 : iArr) {
                arrayList5.add(Integer.valueOf(i5 % ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        } else if (z6 && (obj2 instanceof long[])) {
            long[] jArr = (long[]) obj2;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            for (long j4 : jArr) {
                arrayList6.add(Long.valueOf(j4 % ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        } else if (z7 && (obj2 instanceof float[])) {
            float[] fArr = (float[]) obj2;
            ArrayList arrayList7 = new ArrayList(fArr.length);
            for (float f4 : fArr) {
                arrayList7.add(Float.valueOf(f4 % ((Number) obj).floatValue()));
            }
            return arrayList7.toArray(new Float[0]);
        } else if (z8 && (obj2 instanceof double[])) {
            double[] dArr = (double[]) obj2;
            ArrayList arrayList8 = new ArrayList(dArr.length);
            for (double d4 : dArr) {
                arrayList8.add(Double.valueOf(d4 % ((Number) obj).doubleValue()));
            }
            return arrayList8.toArray(new Double[0]);
        } else {
            boolean z9 = obj instanceof byte[];
            if (z9 && (obj2 instanceof Byte)) {
                byte[] bArr2 = (byte[]) obj;
                ArrayList arrayList9 = new ArrayList(bArr2.length);
                for (byte b5 : bArr2) {
                    arrayList9.add(Integer.valueOf(b5 % ((Number) obj2).intValue()));
                }
                return arrayList9.toArray(new Integer[0]);
            }
            boolean z10 = obj instanceof short[];
            if (z10 && (obj2 instanceof Short)) {
                short[] sArr2 = (short[]) obj;
                ArrayList arrayList10 = new ArrayList(sArr2.length);
                for (short s4 : sArr2) {
                    arrayList10.add(Integer.valueOf(s4 % ((Number) obj2).intValue()));
                }
                return arrayList10.toArray(new Integer[0]);
            }
            boolean z11 = obj instanceof int[];
            if (z11 && (obj2 instanceof Integer)) {
                int[] iArr2 = (int[]) obj;
                int length3 = iArr2.length;
                ArrayList arrayList11 = new ArrayList(length3);
                while (i4 < length3) {
                    arrayList11.add(Integer.valueOf(iArr2[i4] % ((Number) obj2).intValue()));
                    i4++;
                }
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList11);
                return intArray;
            }
            boolean z12 = obj instanceof long[];
            if (z12 && (obj2 instanceof Long)) {
                long[] jArr2 = (long[]) obj;
                ArrayList arrayList12 = new ArrayList(jArr2.length);
                for (long j5 : jArr2) {
                    arrayList12.add(Long.valueOf(j5 % ((Number) obj2).longValue()));
                }
                return arrayList12.toArray(new Long[0]);
            }
            boolean z13 = obj instanceof float[];
            if (z13 && (obj2 instanceof Float)) {
                float[] fArr2 = (float[]) obj;
                ArrayList arrayList13 = new ArrayList(fArr2.length);
                for (float f5 : fArr2) {
                    arrayList13.add(Float.valueOf(f5 % ((Number) obj2).floatValue()));
                }
                return arrayList13.toArray(new Float[0]);
            }
            boolean z14 = obj instanceof double[];
            if (z14 && (obj2 instanceof Double)) {
                double[] dArr2 = (double[]) obj;
                ArrayList arrayList14 = new ArrayList(dArr2.length);
                for (double d5 : dArr2) {
                    arrayList14.add(Double.valueOf(d5 % ((Number) obj2).doubleValue()));
                }
                return arrayList14.toArray(new Double[0]);
            } else if (z9 && (obj2 instanceof byte[])) {
                byte[] bArr3 = (byte[]) obj;
                int length4 = bArr3.length;
                byte[] bArr4 = (byte[]) obj2;
                zzbx.zzb(this, length4, bArr4.length);
                until6 = h.until(0, length4);
                collectionSizeOrDefault6 = f.collectionSizeOrDefault(until6, 10);
                ArrayList arrayList15 = new ArrayList(collectionSizeOrDefault6);
                Iterator<Integer> it = until6.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    arrayList15.add(Integer.valueOf(bArr3[nextInt] % bArr4[nextInt]));
                }
                return arrayList15.toArray(new Integer[0]);
            } else if (z10 && (obj2 instanceof short[])) {
                short[] sArr3 = (short[]) obj;
                int length5 = sArr3.length;
                short[] sArr4 = (short[]) obj2;
                zzbx.zzb(this, length5, sArr4.length);
                until5 = h.until(0, length5);
                collectionSizeOrDefault5 = f.collectionSizeOrDefault(until5, 10);
                ArrayList arrayList16 = new ArrayList(collectionSizeOrDefault5);
                Iterator<Integer> it2 = until5.iterator();
                while (it2.hasNext()) {
                    int nextInt2 = ((IntIterator) it2).nextInt();
                    arrayList16.add(Integer.valueOf(sArr3[nextInt2] % sArr4[nextInt2]));
                }
                return arrayList16.toArray(new Integer[0]);
            } else if (z11 && (obj2 instanceof int[])) {
                int[] iArr3 = (int[]) obj;
                int length6 = iArr3.length;
                int[] iArr4 = (int[]) obj2;
                zzbx.zzb(this, length6, iArr4.length);
                until4 = h.until(0, length6);
                collectionSizeOrDefault4 = f.collectionSizeOrDefault(until4, 10);
                ArrayList arrayList17 = new ArrayList(collectionSizeOrDefault4);
                Iterator<Integer> it3 = until4.iterator();
                while (it3.hasNext()) {
                    int nextInt3 = ((IntIterator) it3).nextInt();
                    arrayList17.add(Integer.valueOf(iArr3[nextInt3] % iArr4[nextInt3]));
                }
                return arrayList17.toArray(new Integer[0]);
            } else if (z12 && (obj2 instanceof long[])) {
                long[] jArr3 = (long[]) obj;
                int length7 = jArr3.length;
                long[] jArr4 = (long[]) obj2;
                zzbx.zzb(this, length7, jArr4.length);
                until3 = h.until(0, length7);
                collectionSizeOrDefault3 = f.collectionSizeOrDefault(until3, 10);
                ArrayList arrayList18 = new ArrayList(collectionSizeOrDefault3);
                Iterator<Integer> it4 = until3.iterator();
                while (it4.hasNext()) {
                    int nextInt4 = ((IntIterator) it4).nextInt();
                    arrayList18.add(Long.valueOf(jArr3[nextInt4] % jArr4[nextInt4]));
                }
                return arrayList18.toArray(new Long[0]);
            } else if (z13 && (obj2 instanceof float[])) {
                float[] fArr3 = (float[]) obj;
                int length8 = fArr3.length;
                float[] fArr4 = (float[]) obj2;
                zzbx.zzb(this, length8, fArr4.length);
                until2 = h.until(0, length8);
                collectionSizeOrDefault2 = f.collectionSizeOrDefault(until2, 10);
                ArrayList arrayList19 = new ArrayList(collectionSizeOrDefault2);
                Iterator<Integer> it5 = until2.iterator();
                while (it5.hasNext()) {
                    int nextInt5 = ((IntIterator) it5).nextInt();
                    arrayList19.add(Float.valueOf(fArr3[nextInt5] % fArr4[nextInt5]));
                }
                return arrayList19.toArray(new Float[0]);
            } else if (z14 && (obj2 instanceof double[])) {
                double[] dArr3 = (double[]) obj;
                int length9 = dArr3.length;
                double[] dArr4 = (double[]) obj2;
                zzbx.zzb(this, length9, dArr4.length);
                until = h.until(0, length9);
                collectionSizeOrDefault = f.collectionSizeOrDefault(until, 10);
                ArrayList arrayList20 = new ArrayList(collectionSizeOrDefault);
                Iterator<Integer> it6 = until.iterator();
                while (it6.hasNext()) {
                    int nextInt6 = ((IntIterator) it6).nextInt();
                    arrayList20.add(Double.valueOf(dArr3[nextInt6] % dArr4[nextInt6]));
                }
                return arrayList20.toArray(new Double[0]);
            } else {
                throw new zzt(4, 5, null);
            }
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
                    try {
                        zzblVar.zzc().zzf(i4, zzb(obj, obj2));
                        return;
                    } catch (ArithmeticException e4) {
                        throw new zzt(4, 6, e4);
                    }
                }
                throw new zzt(4, 5, null);
            }
            throw new zzt(4, 5, null);
        }
        throw new zzt(4, 3, null);
    }
}
