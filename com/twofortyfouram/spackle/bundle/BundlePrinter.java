package com.twofortyfouram.spackle.bundle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.twofortyfouram.spackle.internal.Reflector;
import java.util.Arrays;
import java.util.Locale;
import java.util.TreeSet;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class BundlePrinter {
    private BundlePrinter() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @NonNull
    public static String toString(@Nullable Bundle bundle) {
        String str;
        String str2;
        if (BundleScrubber.scrub(bundle)) {
            return "bad";
        }
        if (bundle == null) {
            return "null";
        }
        if (bundle.keySet().isEmpty()) {
            return "empty";
        }
        TreeSet<String> treeSet = new TreeSet(new BundleKeyComparator());
        treeSet.addAll(bundle.keySet());
        StringBuilder sb = new StringBuilder();
        for (String str3 : treeSet) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            if (str3 == null) {
                str = "null";
            } else {
                str = str3;
            }
            Object obj = bundle.get(str3);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    str2 = toString((Bundle) obj);
                } else {
                    Class<?> cls = obj.getClass();
                    if (cls.isArray()) {
                        if (cls.getComponentType().isPrimitive()) {
                            str2 = (String) Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{cls}, new Object[]{obj});
                        } else {
                            str2 = (String) Reflector.tryInvokeStatic(Arrays.class, "deepToString", new Class[]{Object[].class}, new Object[]{obj});
                        }
                    } else {
                        str2 = obj.toString();
                    }
                }
            } else {
                str2 = null;
            }
            sb.append(String.format(Locale.US, "{%s = %s}", str, str2));
        }
        return sb.toString();
    }
}
