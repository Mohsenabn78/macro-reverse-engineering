package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzay extends zzao {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(Object[] objArr, int i4, int i5) {
        this.zza = objArr;
        this.zzb = i4;
        this.zzc = i5;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzac.zza(i4, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i4 + i4 + this.zzb];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
