package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzat  reason: invalid package */
/* loaded from: classes4.dex */
final class zzat extends zzam {
    final /* synthetic */ zzau zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zzau zzauVar) {
        this.zza = zzauVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i4) {
        int i5;
        Object[] objArr;
        Object[] objArr2;
        i5 = this.zza.zzc;
        zzu.zza(i4, i5, FirebaseAnalytics.Param.INDEX);
        zzau zzauVar = this.zza;
        objArr = zzauVar.zzb;
        int i6 = i4 + i4;
        Object obj = objArr[i6];
        obj.getClass();
        objArr2 = zzauVar.zzb;
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
