package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzfut {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j4, Object obj2, Object obj3) {
        while (!r.a(unsafe, obj, j4, obj2, obj3)) {
            if (unsafe.getObject(obj, j4) != obj2) {
                return false;
            }
        }
        return true;
    }
}
