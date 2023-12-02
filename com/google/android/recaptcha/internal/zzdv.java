package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Iterator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzdv {
    public static boolean zza(Collection collection, Iterator it) {
        it.getClass();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= collection.add(it.next());
        }
        return z3;
    }
}
