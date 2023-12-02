package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    private static int a(Parcel parcel, int i4) {
        parcel.writeInt(i4 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i4 - 4);
        parcel.writeInt(dataPosition - i4);
        parcel.setDataPosition(dataPosition);
    }

    public static int beginObjectHeader(@NonNull Parcel parcel) {
        return a(parcel, 20293);
    }

    private static void c(Parcel parcel, int i4, int i5) {
        parcel.writeInt(i4 | (i5 << 16));
    }

    private static void d(Parcel parcel, Parcelable parcelable, int i4) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i4);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void finishObjectHeader(@NonNull Parcel parcel, int i4) {
        b(parcel, i4);
    }

    public static void writeBigDecimal(@NonNull Parcel parcel, int i4, @NonNull BigDecimal bigDecimal, boolean z3) {
        if (bigDecimal == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
        parcel.writeInt(bigDecimal.scale());
        b(parcel, a4);
    }

    public static void writeBigDecimalArray(@NonNull Parcel parcel, int i4, @NonNull BigDecimal[] bigDecimalArr, boolean z3) {
        if (bigDecimalArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i5 = 0; i5 < length; i5++) {
            parcel.writeByteArray(bigDecimalArr[i5].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i5].scale());
        }
        b(parcel, a4);
    }

    public static void writeBigInteger(@NonNull Parcel parcel, int i4, @NonNull BigInteger bigInteger, boolean z3) {
        if (bigInteger == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeByteArray(bigInteger.toByteArray());
        b(parcel, a4);
    }

    public static void writeBigIntegerArray(@NonNull Parcel parcel, int i4, @NonNull BigInteger[] bigIntegerArr, boolean z3) {
        if (bigIntegerArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        b(parcel, a4);
    }

    public static void writeBoolean(@NonNull Parcel parcel, int i4, boolean z3) {
        c(parcel, i4, 4);
        parcel.writeInt(z3 ? 1 : 0);
    }

    public static void writeBooleanArray(@NonNull Parcel parcel, int i4, @NonNull boolean[] zArr, boolean z3) {
        if (zArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeBooleanArray(zArr);
        b(parcel, a4);
    }

    public static void writeBooleanList(@NonNull Parcel parcel, int i4, @NonNull List<Boolean> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(list.get(i5).booleanValue() ? 1 : 0);
        }
        b(parcel, a4);
    }

    public static void writeBooleanObject(@NonNull Parcel parcel, int i4, @NonNull Boolean bool, boolean z3) {
        if (bool == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        c(parcel, i4, 4);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public static void writeBundle(@NonNull Parcel parcel, int i4, @NonNull Bundle bundle, boolean z3) {
        if (bundle == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeBundle(bundle);
        b(parcel, a4);
    }

    public static void writeByte(@NonNull Parcel parcel, int i4, byte b4) {
        c(parcel, i4, 4);
        parcel.writeInt(b4);
    }

    public static void writeByteArray(@NonNull Parcel parcel, int i4, @NonNull byte[] bArr, boolean z3) {
        if (bArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeByteArray(bArr);
        b(parcel, a4);
    }

    public static void writeByteArrayArray(@NonNull Parcel parcel, int i4, @NonNull byte[][] bArr, boolean z3) {
        if (bArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        b(parcel, a4);
    }

    public static void writeByteArraySparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<byte[]> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            parcel.writeByteArray(sparseArray.valueAt(i5));
        }
        b(parcel, a4);
    }

    public static void writeChar(@NonNull Parcel parcel, int i4, char c4) {
        c(parcel, i4, 4);
        parcel.writeInt(c4);
    }

    public static void writeCharArray(@NonNull Parcel parcel, int i4, @NonNull char[] cArr, boolean z3) {
        if (cArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeCharArray(cArr);
        b(parcel, a4);
    }

    public static void writeDouble(@NonNull Parcel parcel, int i4, double d4) {
        c(parcel, i4, 8);
        parcel.writeDouble(d4);
    }

    public static void writeDoubleArray(@NonNull Parcel parcel, int i4, @NonNull double[] dArr, boolean z3) {
        if (dArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeDoubleArray(dArr);
        b(parcel, a4);
    }

    public static void writeDoubleList(@NonNull Parcel parcel, int i4, @NonNull List<Double> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeDouble(list.get(i5).doubleValue());
        }
        b(parcel, a4);
    }

    public static void writeDoubleObject(@NonNull Parcel parcel, int i4, @NonNull Double d4, boolean z3) {
        if (d4 == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        c(parcel, i4, 8);
        parcel.writeDouble(d4.doubleValue());
    }

    public static void writeDoubleSparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<Double> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            parcel.writeDouble(sparseArray.valueAt(i5).doubleValue());
        }
        b(parcel, a4);
    }

    public static void writeFloat(@NonNull Parcel parcel, int i4, float f4) {
        c(parcel, i4, 4);
        parcel.writeFloat(f4);
    }

    public static void writeFloatArray(@NonNull Parcel parcel, int i4, @NonNull float[] fArr, boolean z3) {
        if (fArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeFloatArray(fArr);
        b(parcel, a4);
    }

    public static void writeFloatList(@NonNull Parcel parcel, int i4, @NonNull List<Float> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeFloat(list.get(i5).floatValue());
        }
        b(parcel, a4);
    }

    public static void writeFloatObject(@NonNull Parcel parcel, int i4, @NonNull Float f4, boolean z3) {
        if (f4 == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        c(parcel, i4, 4);
        parcel.writeFloat(f4.floatValue());
    }

    public static void writeFloatSparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<Float> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            parcel.writeFloat(sparseArray.valueAt(i5).floatValue());
        }
        b(parcel, a4);
    }

    public static void writeIBinder(@NonNull Parcel parcel, int i4, @NonNull IBinder iBinder, boolean z3) {
        if (iBinder == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeStrongBinder(iBinder);
        b(parcel, a4);
    }

    public static void writeIBinderArray(@NonNull Parcel parcel, int i4, @NonNull IBinder[] iBinderArr, boolean z3) {
        if (iBinderArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeBinderArray(iBinderArr);
        b(parcel, a4);
    }

    public static void writeIBinderList(@NonNull Parcel parcel, int i4, @NonNull List<IBinder> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeBinderList(list);
        b(parcel, a4);
    }

    public static void writeIBinderSparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<IBinder> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            parcel.writeStrongBinder(sparseArray.valueAt(i5));
        }
        b(parcel, a4);
    }

    public static void writeInt(@NonNull Parcel parcel, int i4, int i5) {
        c(parcel, i4, 4);
        parcel.writeInt(i5);
    }

    public static void writeIntArray(@NonNull Parcel parcel, int i4, @NonNull int[] iArr, boolean z3) {
        if (iArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeIntArray(iArr);
        b(parcel, a4);
    }

    public static void writeIntegerList(@NonNull Parcel parcel, int i4, @NonNull List<Integer> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(list.get(i5).intValue());
        }
        b(parcel, a4);
    }

    public static void writeIntegerObject(@NonNull Parcel parcel, int i4, @NonNull Integer num, boolean z3) {
        if (num == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        c(parcel, i4, 4);
        parcel.writeInt(num.intValue());
    }

    public static void writeList(@NonNull Parcel parcel, int i4, @NonNull List list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeList(list);
        b(parcel, a4);
    }

    public static void writeLong(@NonNull Parcel parcel, int i4, long j4) {
        c(parcel, i4, 8);
        parcel.writeLong(j4);
    }

    public static void writeLongArray(@NonNull Parcel parcel, int i4, @NonNull long[] jArr, boolean z3) {
        if (jArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeLongArray(jArr);
        b(parcel, a4);
    }

    public static void writeLongList(@NonNull Parcel parcel, int i4, @NonNull List<Long> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeLong(list.get(i5).longValue());
        }
        b(parcel, a4);
    }

    public static void writeLongObject(@NonNull Parcel parcel, int i4, @NonNull Long l4, boolean z3) {
        if (l4 == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        c(parcel, i4, 8);
        parcel.writeLong(l4.longValue());
    }

    public static void writeParcel(@NonNull Parcel parcel, int i4, @NonNull Parcel parcel2, boolean z3) {
        if (parcel2 == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        b(parcel, a4);
    }

    public static void writeParcelArray(@NonNull Parcel parcel, int i4, @NonNull Parcel[] parcelArr, boolean z3) {
        if (parcelArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, a4);
    }

    public static void writeParcelList(@NonNull Parcel parcel, int i4, @NonNull List<Parcel> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            Parcel parcel2 = list.get(i5);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, a4);
    }

    public static void writeParcelSparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<Parcel> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            Parcel valueAt = sparseArray.valueAt(i5);
            if (valueAt != null) {
                parcel.writeInt(valueAt.dataSize());
                parcel.appendFrom(valueAt, 0, valueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        b(parcel, a4);
    }

    public static void writeParcelable(@NonNull Parcel parcel, int i4, @NonNull Parcelable parcelable, int i5, boolean z3) {
        if (parcelable == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcelable.writeToParcel(parcel, i5);
        b(parcel, a4);
    }

    public static void writePendingIntent(@NonNull Parcel parcel, int i4, @NonNull PendingIntent pendingIntent, boolean z3) {
        if (pendingIntent == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
        b(parcel, a4);
    }

    public static void writeShort(@NonNull Parcel parcel, int i4, short s3) {
        c(parcel, i4, 4);
        parcel.writeInt(s3);
    }

    public static void writeSparseBooleanArray(@NonNull Parcel parcel, int i4, @NonNull SparseBooleanArray sparseBooleanArray, boolean z3) {
        if (sparseBooleanArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeSparseBooleanArray(sparseBooleanArray);
        b(parcel, a4);
    }

    public static void writeSparseIntArray(@NonNull Parcel parcel, int i4, @NonNull SparseIntArray sparseIntArray, boolean z3) {
        if (sparseIntArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseIntArray.keyAt(i5));
            parcel.writeInt(sparseIntArray.valueAt(i5));
        }
        b(parcel, a4);
    }

    public static void writeSparseLongArray(@NonNull Parcel parcel, int i4, @NonNull SparseLongArray sparseLongArray, boolean z3) {
        if (sparseLongArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseLongArray.keyAt(i5));
            parcel.writeLong(sparseLongArray.valueAt(i5));
        }
        b(parcel, a4);
    }

    public static void writeString(@NonNull Parcel parcel, int i4, @NonNull String str, boolean z3) {
        if (str == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeString(str);
        b(parcel, a4);
    }

    public static void writeStringArray(@NonNull Parcel parcel, int i4, @NonNull String[] strArr, boolean z3) {
        if (strArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeStringArray(strArr);
        b(parcel, a4);
    }

    public static void writeStringList(@NonNull Parcel parcel, int i4, @NonNull List<String> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeStringList(list);
        b(parcel, a4);
    }

    public static void writeStringSparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<String> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            parcel.writeString(sparseArray.valueAt(i5));
        }
        b(parcel, a4);
    }

    public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel parcel, int i4, @NonNull T[] tArr, int i5, boolean z3) {
        if (tArr == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        parcel.writeInt(tArr.length);
        for (T t3 : tArr) {
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                d(parcel, t3, i5);
            }
        }
        b(parcel, a4);
    }

    public static <T extends Parcelable> void writeTypedList(@NonNull Parcel parcel, int i4, @NonNull List<T> list, boolean z3) {
        if (list == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = list.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            T t3 = list.get(i5);
            if (t3 == null) {
                parcel.writeInt(0);
            } else {
                d(parcel, t3, 0);
            }
        }
        b(parcel, a4);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel parcel, int i4, @NonNull SparseArray<T> sparseArray, boolean z3) {
        if (sparseArray == null) {
            if (z3) {
                c(parcel, i4, 0);
                return;
            }
            return;
        }
        int a4 = a(parcel, i4);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            parcel.writeInt(sparseArray.keyAt(i5));
            T valueAt = sparseArray.valueAt(i5);
            if (valueAt == null) {
                parcel.writeInt(0);
            } else {
                d(parcel, valueAt, 0);
            }
        }
        b(parcel, a4);
    }
}
