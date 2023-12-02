package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzftl implements Comparator {
    public static zzftl zzb(Comparator comparator) {
        if (comparator instanceof zzftl) {
            return (zzftl) comparator;
        }
        return new zzfrn(comparator);
    }

    public static zzftl zzc() {
        return zzftj.zza;
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzftl zza() {
        return new zzftu(this);
    }
}
