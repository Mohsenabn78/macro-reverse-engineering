package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes3.dex */
public final class Util {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f17585a = "0123456789abcdef".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f17586b = new char[64];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17587a;

        static {
            Bitmap.Config config;
            int[] iArr = new int[Bitmap.Config.values().length];
            f17587a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17587a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17587a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr2 = f17587a;
                config = Bitmap.Config.RGBA_F16;
                iArr2[config.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17587a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private Util() {
    }

    @NonNull
    private static String a(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = i4 * 2;
            char[] cArr2 = f17585a;
            cArr[i6] = cArr2[i5 >>> 4];
            cArr[i6 + 1] = cArr2[i5 & 15];
        }
        return new String(cArr);
    }

    public static void assertBackgroundThread() {
        if (isOnBackgroundThread()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on a background thread");
    }

    public static void assertMainThread() {
        if (isOnMainThread()) {
            return;
        }
        throw new IllegalArgumentException("You must call this method on the main thread");
    }

    private static int b(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = a.f17587a[config.ordinal()];
        if (i4 == 1) {
            return 1;
        }
        if (i4 == 2 || i4 == 3) {
            return 2;
        }
        if (i4 != 4) {
            return 4;
        }
        return 8;
    }

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        } else if (obj instanceof Model) {
            return ((Model) obj).isEquivalentTo(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean bothNullOrEqual(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    private static boolean c(int i4) {
        if (i4 <= 0 && i4 != Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    @NonNull
    public static <T> Queue<T> createQueue(int i4) {
        return new ArrayDeque(i4);
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    @Deprecated
    public static int getSize(@NonNull Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t3 : collection) {
            if (t3 != null) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    public static int hashCode(int i4, int i5) {
        return (i5 * 31) + i4;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public static boolean isValidDimensions(int i4, int i5) {
        if (c(i4) && c(i5)) {
            return true;
        }
        return false;
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        String a4;
        char[] cArr = f17586b;
        synchronized (cArr) {
            a4 = a(bArr, cArr);
        }
        return a4;
    }

    public static int hashCode(int i4) {
        return hashCode(i4, 17);
    }

    public static int hashCode(float f4) {
        return hashCode(f4, 17);
    }

    public static int hashCode(float f4, int i4) {
        return hashCode(Float.floatToIntBits(f4), i4);
    }

    public static int hashCode(@Nullable Object obj, int i4) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i4);
    }

    public static int getBitmapByteSize(int i4, int i5, @Nullable Bitmap.Config config) {
        return i4 * i5 * b(config);
    }

    public static int hashCode(boolean z3, int i4) {
        return hashCode(z3 ? 1 : 0, i4);
    }

    public static int hashCode(boolean z3) {
        return hashCode(z3, 17);
    }
}
