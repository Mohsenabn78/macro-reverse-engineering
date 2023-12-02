package com.twofortyfouram.assertion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class BundleAssertions {
    private BundleAssertions() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    private static String a(@NonNull String str, @NonNull Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static void assertHasBoolean(@NonNull Bundle bundle, @Nullable String str) throws AssertionError {
        assertHasKey(bundle, str);
        if (bundle.getBoolean(str, true) == bundle.getBoolean(str, false)) {
            return;
        }
        throw new AssertionError(a("Extra %s appears to be the wrong type.  It must be a boolean", str));
    }

    public static void assertHasByteArray(@NonNull Bundle bundle, @Nullable String str) throws AssertionError {
        assertHasKey(bundle, str);
        if (bundle.getByteArray(str) != null) {
            return;
        }
        throw new AssertionError(a("Extra %s appears to be the wrong type or null.  It must be a byte[]", str));
    }

    public static void assertHasInt(@NonNull Bundle bundle, @Nullable String str) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        assertHasKey(bundle, str);
        if (bundle.getInt(str, Integer.MIN_VALUE) != bundle.getInt(str, Integer.MAX_VALUE)) {
            throw new AssertionError(a("Extra %s appears to be the wrong type.  It must be an int", str));
        }
    }

    public static void assertHasKey(@NonNull Bundle bundle, @Nullable String str) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        if (bundle.containsKey(str)) {
            return;
        }
        throw new AssertionError(a("Required extra %s is missing", str));
    }

    public static void assertHasLong(@NonNull Bundle bundle, @Nullable String str) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        assertHasKey(bundle, str);
        if (bundle.getLong(str, Long.MIN_VALUE) != bundle.getLong(str, Long.MAX_VALUE)) {
            throw new AssertionError(a("Extra %s appears to be the wrong type.  It must be a long", str));
        }
    }

    @SuppressLint({"NewApi"})
    public static void assertHasParcelable(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<? extends Parcelable> cls) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        Assertions.assertNotNull(cls, "expectedClass");
        assertHasKey(bundle, str);
        Parcelable parcelable = bundle.getParcelable(str);
        if (parcelable != null) {
            if (parcelable.getClass() == cls) {
                return;
            }
            throw new AssertionError(a("Extra %s is not an instance of %s", str, cls.getName()));
        }
        throw new AssertionError(a("Extra %s is not Parcelable", str));
    }

    @SuppressLint({"NewApi"})
    public static void assertHasString(@NonNull Bundle bundle, @Nullable String str) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        assertHasKey(bundle, str);
        if (bundle.get(str) != null && "foo".equals(bundle.getString(str, "foo")) && "bar".equals(bundle.getString(str, "bar"))) {
            throw new AssertionError(a("Extra %s is the wrong type", str));
        }
    }

    public static void assertKeyCount(@NonNull Bundle bundle, int i4) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        Assertions.assertInRangeInclusive(i4, 0, Integer.MAX_VALUE, "expectedCount");
        if (i4 == bundle.keySet().size()) {
            return;
        }
        throw new AssertionError(a("bundle must contain %d keys, but currently contains %d keys: %s", Integer.valueOf(i4), Integer.valueOf(bundle.keySet().size()), bundle.keySet().toString()));
    }

    public static void assertSerializable(@NonNull Bundle bundle) {
        ObjectOutputStream objectOutputStream;
        Assertions.assertNotNull(bundle, "bundle");
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new ByteArrayOutputStream());
            } catch (Throwable th) {
                th = th;
            }
            try {
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj instanceof Bundle) {
                        assertSerializable((Bundle) obj);
                    } else if (obj instanceof Serializable) {
                        try {
                            ClassLoader.getSystemClassLoader().loadClass(obj.getClass().getName());
                            try {
                                objectOutputStream.writeObject(bundle.get(str));
                            } catch (IOException unused) {
                                throw new AssertionError(a("Object associated with key %s couldn't be serialized", str));
                            }
                        } catch (ClassNotFoundException unused2) {
                            throw new AssertionError(a("Object associated with key %s is not available to the Android ClassLoader", str));
                        }
                    } else if (obj != null) {
                        throw new AssertionError(a("Key \"%s\"'s value %s isn't Serializable.  Only primitives or objects implementing Serializable can be stored.  Parcelable is not stable for long-term storage.", str, bundle.get(str)));
                    }
                }
                try {
                    objectOutputStream.close();
                } catch (IOException unused3) {
                    throw new RuntimeException("Internal failure");
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused4) {
                        throw new RuntimeException("Internal failure");
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            throw new RuntimeException();
        }
    }

    public static void assertHasInt(@NonNull Bundle bundle, @Nullable String str, int i4, int i5) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        if (i5 >= i4) {
            assertHasInt(bundle, str);
            Assertions.assertInRangeInclusive(bundle.getInt(str), i4, i5, str);
            return;
        }
        throw new IllegalArgumentException("upperBound is not >= lowerBound");
    }

    public static void assertHasLong(@NonNull Bundle bundle, @Nullable String str, long j4, long j5) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        if (j5 >= j4) {
            assertHasLong(bundle, str);
            Assertions.assertInRangeInclusive(bundle.getLong(str), j4, j5, str);
            return;
        }
        throw new IllegalArgumentException("upperBound is not >= lowerBound");
    }

    public static void assertHasString(@NonNull Bundle bundle, @Nullable String str, @Nullable String... strArr) throws AssertionError {
        boolean z3;
        Assertions.assertNotNull(bundle, "bundle");
        assertHasString(bundle, str);
        if (strArr != null) {
            String string = bundle.getString(str);
            for (String str2 : strArr) {
                if (string == null) {
                    if (str2 == null) {
                        z3 = true;
                        break;
                    }
                } else if (string.equals(str2)) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
            if (!z3) {
                throw new AssertionError(a("Extra %s=%s is not in the set %s", str, string, Arrays.toString(strArr)));
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void assertHasString(@NonNull Bundle bundle, @Nullable String str, boolean z3, boolean z4) throws AssertionError {
        Assertions.assertNotNull(bundle, "bundle");
        assertHasString(bundle, str);
        String string = bundle.getString(str);
        if (!z3 && string == null) {
            throw new AssertionError(a("%s cannot map to null", str));
        }
        if (!z4 && string != null && string.length() == 0) {
            throw new AssertionError(a("%s cannot map to empty string", str));
        }
    }
}
