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
public final class zzco implements zzby {
    @NotNull
    public static final zzco zza = new zzco();

    private zzco() {
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
        IntRange until;
        int collectionSizeOrDefault;
        IntRange until2;
        int collectionSizeOrDefault2;
        IntRange until3;
        int collectionSizeOrDefault3;
        IntRange until4;
        int collectionSizeOrDefault4;
        int[] intArray;
        byte[] byteArray;
        boolean z3 = obj instanceof Byte;
        if (z3 && (obj2 instanceof Byte)) {
            return Byte.valueOf((byte) (((Number) obj).byteValue() ^ ((Number) obj2).byteValue()));
        }
        boolean z4 = obj instanceof Short;
        if (z4 && (obj2 instanceof Short)) {
            return Short.valueOf((short) (((Number) obj).shortValue() ^ ((Number) obj2).shortValue()));
        }
        boolean z5 = obj instanceof Integer;
        if (z5 && (obj2 instanceof Integer)) {
            return Integer.valueOf(((Number) obj).intValue() ^ ((Number) obj2).intValue());
        }
        boolean z6 = obj instanceof Long;
        if (z6 && (obj2 instanceof Long)) {
            return Long.valueOf(((Number) obj2).longValue() ^ ((Number) obj).longValue());
        }
        int i4 = 0;
        if (obj instanceof String) {
            if (obj2 instanceof Byte) {
                byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
                int length = bytes.length;
                ArrayList arrayList = new ArrayList(length);
                while (i4 < length) {
                    arrayList.add(Byte.valueOf((byte) (bytes[i4] ^ ((Number) obj2).byteValue())));
                    i4++;
                }
                byteArray = CollectionsKt___CollectionsKt.toByteArray(arrayList);
                return byteArray;
            } else if (obj2 instanceof Integer) {
                char[] charArray = ((String) obj).toCharArray();
                int length2 = charArray.length;
                ArrayList arrayList2 = new ArrayList(length2);
                while (i4 < length2) {
                    arrayList2.add(Integer.valueOf(charArray[i4] ^ ((Number) obj2).intValue()));
                    i4++;
                }
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
                return intArray;
            }
        }
        if (z3 && (obj2 instanceof byte[])) {
            byte[] bArr = (byte[]) obj2;
            ArrayList arrayList3 = new ArrayList(bArr.length);
            for (byte b4 : bArr) {
                arrayList3.add(Byte.valueOf((byte) (b4 ^ ((Number) obj).byteValue())));
            }
            return arrayList3.toArray(new Byte[0]);
        } else if (z4 && (obj2 instanceof short[])) {
            short[] sArr = (short[]) obj2;
            ArrayList arrayList4 = new ArrayList(sArr.length);
            for (short s3 : sArr) {
                arrayList4.add(Short.valueOf((short) (s3 ^ ((Number) obj).shortValue())));
            }
            return arrayList4.toArray(new Short[0]);
        } else if (z5 && (obj2 instanceof int[])) {
            int[] iArr = (int[]) obj2;
            ArrayList arrayList5 = new ArrayList(iArr.length);
            for (int i5 : iArr) {
                arrayList5.add(Integer.valueOf(i5 ^ ((Number) obj).intValue()));
            }
            return arrayList5.toArray(new Integer[0]);
        } else if (z6 && (obj2 instanceof long[])) {
            long[] jArr = (long[]) obj2;
            ArrayList arrayList6 = new ArrayList(jArr.length);
            for (long j4 : jArr) {
                arrayList6.add(Long.valueOf(j4 ^ ((Number) obj).longValue()));
            }
            return arrayList6.toArray(new Long[0]);
        } else {
            boolean z7 = obj instanceof byte[];
            if (z7 && (obj2 instanceof Byte)) {
                byte[] bArr2 = (byte[]) obj;
                ArrayList arrayList7 = new ArrayList(bArr2.length);
                for (byte b5 : bArr2) {
                    arrayList7.add(Byte.valueOf((byte) (b5 ^ ((Number) obj2).byteValue())));
                }
                return arrayList7.toArray(new Byte[0]);
            }
            boolean z8 = obj instanceof short[];
            if (z8 && (obj2 instanceof Short)) {
                short[] sArr2 = (short[]) obj;
                ArrayList arrayList8 = new ArrayList(sArr2.length);
                for (short s4 : sArr2) {
                    arrayList8.add(Short.valueOf((short) (s4 ^ ((Number) obj2).shortValue())));
                }
                return arrayList8.toArray(new Short[0]);
            }
            boolean z9 = obj instanceof int[];
            if (z9 && (obj2 instanceof Integer)) {
                int[] iArr2 = (int[]) obj;
                ArrayList arrayList9 = new ArrayList(iArr2.length);
                for (int i6 : iArr2) {
                    arrayList9.add(Integer.valueOf(i6 ^ ((Number) obj2).intValue()));
                }
                return arrayList9.toArray(new Integer[0]);
            }
            boolean z10 = obj instanceof long[];
            if (z10 && (obj2 instanceof Long)) {
                long[] jArr2 = (long[]) obj;
                ArrayList arrayList10 = new ArrayList(jArr2.length);
                for (long j5 : jArr2) {
                    arrayList10.add(Long.valueOf(j5 ^ ((Number) obj2).longValue()));
                }
                return arrayList10.toArray(new Long[0]);
            } else if (z7 && (obj2 instanceof byte[])) {
                byte[] bArr3 = (byte[]) obj;
                int length3 = bArr3.length;
                byte[] bArr4 = (byte[]) obj2;
                zzbx.zzb(this, length3, bArr4.length);
                until4 = h.until(0, length3);
                collectionSizeOrDefault4 = f.collectionSizeOrDefault(until4, 10);
                ArrayList arrayList11 = new ArrayList(collectionSizeOrDefault4);
                Iterator<Integer> it = until4.iterator();
                while (it.hasNext()) {
                    int nextInt = ((IntIterator) it).nextInt();
                    arrayList11.add(Byte.valueOf((byte) (bArr4[nextInt] ^ bArr3[nextInt])));
                }
                return arrayList11.toArray(new Byte[0]);
            } else if (z8 && (obj2 instanceof short[])) {
                short[] sArr3 = (short[]) obj;
                int length4 = sArr3.length;
                short[] sArr4 = (short[]) obj2;
                zzbx.zzb(this, length4, sArr4.length);
                until3 = h.until(0, length4);
                collectionSizeOrDefault3 = f.collectionSizeOrDefault(until3, 10);
                ArrayList arrayList12 = new ArrayList(collectionSizeOrDefault3);
                Iterator<Integer> it2 = until3.iterator();
                while (it2.hasNext()) {
                    int nextInt2 = ((IntIterator) it2).nextInt();
                    arrayList12.add(Short.valueOf((short) (sArr4[nextInt2] ^ sArr3[nextInt2])));
                }
                return arrayList12.toArray(new Short[0]);
            } else if (z9 && (obj2 instanceof int[])) {
                int[] iArr3 = (int[]) obj;
                int length5 = iArr3.length;
                int[] iArr4 = (int[]) obj2;
                zzbx.zzb(this, length5, iArr4.length);
                until2 = h.until(0, length5);
                collectionSizeOrDefault2 = f.collectionSizeOrDefault(until2, 10);
                ArrayList arrayList13 = new ArrayList(collectionSizeOrDefault2);
                Iterator<Integer> it3 = until2.iterator();
                while (it3.hasNext()) {
                    int nextInt3 = ((IntIterator) it3).nextInt();
                    arrayList13.add(Integer.valueOf(iArr4[nextInt3] ^ iArr3[nextInt3]));
                }
                return arrayList13.toArray(new Integer[0]);
            } else if (z10 && (obj2 instanceof long[])) {
                long[] jArr3 = (long[]) obj;
                int length6 = jArr3.length;
                long[] jArr4 = (long[]) obj2;
                zzbx.zzb(this, length6, jArr4.length);
                until = h.until(0, length6);
                collectionSizeOrDefault = f.collectionSizeOrDefault(until, 10);
                ArrayList arrayList14 = new ArrayList(collectionSizeOrDefault);
                Iterator<Integer> it4 = until.iterator();
                while (it4.hasNext()) {
                    int nextInt4 = ((IntIterator) it4).nextInt();
                    arrayList14.add(Long.valueOf(jArr3[nextInt4] ^ jArr4[nextInt4]));
                }
                return arrayList14.toArray(new Long[0]);
            } else {
                throw new zzt(4, 5, null);
            }
        }
    }
}
