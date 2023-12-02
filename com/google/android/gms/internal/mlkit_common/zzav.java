package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzav extends zzao {
    final /* synthetic */ zzaw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzaw zzawVar) {
        this.zza = zzawVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        int i5;
        Object[] objArr;
        Object[] objArr2;
        i5 = this.zza.zzc;
        zzac.zza(i4, i5, FirebaseAnalytics.Param.INDEX);
        zzaw zzawVar = this.zza;
        int i6 = i4 + i4;
        objArr = zzawVar.zzb;
        Object obj = objArr[i6];
        obj.getClass();
        objArr2 = zzawVar.zzb;
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
