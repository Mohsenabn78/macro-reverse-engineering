package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzftn extends zzfsc {
    final /* synthetic */ zzfto zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzftn(zzfto zzftoVar) {
        this.zza = zzftoVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        int i5;
        Object[] objArr;
        Object[] objArr2;
        i5 = this.zza.zzc;
        zzfph.zza(i4, i5, FirebaseAnalytics.Param.INDEX);
        zzfto zzftoVar = this.zza;
        objArr = zzftoVar.zzb;
        int i6 = i4 + i4;
        Object obj = objArr[i6];
        obj.getClass();
        objArr2 = zzftoVar.zzb;
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

    @Override // com.google.android.gms.internal.ads.zzfrx
    public final boolean zzf() {
        return true;
    }
}
