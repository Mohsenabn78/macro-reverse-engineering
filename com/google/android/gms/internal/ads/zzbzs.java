package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbzs {
    public static boolean zza(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle != null && bundle2 != null) {
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            for (String str : bundle.keySet()) {
                if (!bundle2.containsKey(str)) {
                    return false;
                }
                Object obj = bundle.get(str);
                Object obj2 = bundle2.get(str);
                if (obj != null && obj2 != null) {
                    if (obj instanceof Bundle) {
                        if (!(obj2 instanceof Bundle) || !zza((Bundle) obj, (Bundle) obj2)) {
                            return false;
                        }
                    } else if (obj.getClass().isArray()) {
                        int length = Array.getLength(obj);
                        if (!obj2.getClass().isArray() || length != Array.getLength(obj2)) {
                            return false;
                        }
                        for (int i4 = 0; i4 < length; i4++) {
                            if (!Objects.equal(Array.get(obj, i4), Array.get(obj2, i4))) {
                                return false;
                            }
                        }
                        continue;
                    } else if (!obj.equals(obj2)) {
                        return false;
                    }
                } else if (obj == null && obj2 == null) {
                    return true;
                } else {
                    return false;
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
