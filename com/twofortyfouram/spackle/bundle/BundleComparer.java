package com.twofortyfouram.spackle.bundle;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.twofortyfouram.spackle.internal.Reflector;
import java.util.Arrays;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class BundleComparer {
    private BundleComparer() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static boolean areBundlesEqual(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            Set<String> keySet = bundle.keySet();
            if (!keySet.equals(bundle2.keySet())) {
                return false;
            }
            for (String str : keySet) {
                Object obj = bundle.get(str);
                Object obj2 = bundle2.get(str);
                if ((obj == null && obj2 != null) || (obj != null && obj2 == null)) {
                    return false;
                }
                if (obj != null || obj2 != null) {
                    if ((obj instanceof Bundle) && (obj2 instanceof Bundle)) {
                        if (!areBundlesEqual((Bundle) obj, (Bundle) obj2)) {
                            return false;
                        }
                    } else {
                        Class<?> cls = obj.getClass();
                        Class<?> cls2 = obj2.getClass();
                        if (cls.isArray() && cls2.isArray()) {
                            Class<?> componentType = cls.getComponentType();
                            if (componentType.equals(cls2.getComponentType())) {
                                if (componentType.isPrimitive()) {
                                    if (((Boolean) Reflector.tryInvokeStatic(Arrays.class, "equals", new Class[]{cls, cls}, new Object[]{obj, obj2})).booleanValue()) {
                                        Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{cls}, new Object[]{obj});
                                        Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{cls}, new Object[]{obj});
                                    } else {
                                        Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{cls}, new Object[]{obj});
                                        Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{cls}, new Object[]{obj});
                                        return false;
                                    }
                                } else if (((Boolean) Reflector.tryInvokeStatic(Arrays.class, "deepEquals", new Class[]{Object[].class, Object[].class}, new Object[]{obj, obj2})).booleanValue()) {
                                    Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{Object[].class}, new Object[]{obj});
                                    Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{Object[].class}, new Object[]{obj});
                                } else {
                                    Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{Object[].class}, new Object[]{obj});
                                    Reflector.tryInvokeStatic(Arrays.class, "toString", new Class[]{Object[].class}, new Object[]{obj});
                                }
                            }
                            return false;
                        } else if (!obj.equals(obj2) || !obj2.equals(obj)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } else if (bundle == null && bundle2 == null) {
            return true;
        } else {
            return false;
        }
    }
}
