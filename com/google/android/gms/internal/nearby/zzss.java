package com.google.android.gms.internal.nearby;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzss extends zzst {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzst zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzss(zzst zzstVar, int i4, int i5) {
        this.zzc = zzstVar;
        this.zza = i4;
        this.zzb = i5;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzsj.zza(i4, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i4 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.nearby.zzst, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i4, int i5) {
        return subList(i4, i5);
    }

    @Override // com.google.android.gms.internal.nearby.zzsq
    final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzsq
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzsq
    public final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zzsq
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.nearby.zzst
    public final zzst zzh(int i4, int i5) {
        zzsj.zzh(i4, i5, this.zzb);
        zzst zzstVar = this.zzc;
        int i6 = this.zza;
        return zzstVar.subList(i4 + i6, i5 + i6);
    }
}
