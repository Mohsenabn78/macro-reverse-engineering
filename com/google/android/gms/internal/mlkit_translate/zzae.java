package com.google.android.gms.internal.mlkit_translate;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzae extends zzv {
    final /* synthetic */ zzaf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(zzaf zzafVar) {
        this.zza = zzafVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        int i5;
        Object[] objArr;
        Object[] objArr2;
        i5 = this.zza.zzc;
        zzj.zza(i4, i5, FirebaseAnalytics.Param.INDEX);
        zzaf zzafVar = this.zza;
        int i6 = i4 + i4;
        objArr = zzafVar.zzb;
        Object obj = objArr[i6];
        obj.getClass();
        objArr2 = zzafVar.zzb;
        Object obj2 = objArr2[i6 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i4;
        i4 = this.zza.zzc;
        return i4;
    }
}
