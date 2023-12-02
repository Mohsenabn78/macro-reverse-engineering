package com.twofortyfouram.spackle;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.annotation.AnyRes;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import java.util.NoSuchElementException;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class ResourceUtil {
    private ResourceUtil() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static boolean getBoolean(@NonNull Context context, @NonNull String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotEmpty(str, "resourceName");
        return context.getResources().getBoolean(context.getResources().getIdentifier(str, "bool", context.getPackageName()));
    }

    public static int getPositionForIdInArray(@NonNull Context context, @ArrayRes int i4, @AnyRes int i5) {
        Assertions.assertNotNull(context, "context");
        TypedArray typedArray = null;
        try {
            typedArray = context.getResources().obtainTypedArray(i4);
            for (int i6 = 0; i6 < typedArray.length(); i6++) {
                if (typedArray.getResourceId(i6, 0) == i5) {
                    typedArray.recycle();
                    return i6;
                }
            }
            typedArray.recycle();
            throw new NoSuchElementException();
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }

    public static int getResourceIdForPositionInArray(@NonNull Context context, @ArrayRes int i4, int i5) {
        Assertions.assertNotNull(context, "context");
        TypedArray typedArray = null;
        try {
            typedArray = context.getResources().obtainTypedArray(i4);
            int resourceId = typedArray.getResourceId(i5, 0);
            if (resourceId != 0) {
                typedArray.recycle();
                return resourceId;
            }
            throw new IndexOutOfBoundsException();
        } catch (Throwable th) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th;
        }
    }
}
