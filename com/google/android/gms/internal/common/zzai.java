package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.jspecify.nullness.NullMarked;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@NullMarked
/* loaded from: classes4.dex */
public final class zzai extends zzag {
    static final zzag zza = new zzai(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(Object[] objArr, int i4) {
        this.zzb = objArr;
        this.zzc = i4;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzs.zza(i4, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i4];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzag, com.google.android.gms.internal.common.zzac
    final int zza(Object[] objArr, int i4) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.common.zzac
    final int zzb() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] zzg() {
        return this.zzb;
    }
}
