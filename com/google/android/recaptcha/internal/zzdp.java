package com.google.android.recaptcha.internal;

import net.bytebuddy.pool.TypePool;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public abstract class zzdp implements Iterable {
    private final zzde zza = zzde.zza();

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        boolean z3 = true;
        for (Object obj : this) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(obj);
            z3 = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
