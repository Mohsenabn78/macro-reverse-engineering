package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzca extends zzet {

    /* renamed from: a  reason: collision with root package name */
    private final Object f22721a = new Object();
    @GuardedBy("lock")
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private zzcb f22722b;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private zzbe f22723c;

    @Override // com.google.android.gms.wearable.internal.zzeu
    public final void zzb(int i4, int i5) {
        zzcb zzcbVar;
        zzbe zzbeVar;
        synchronized (this.f22721a) {
            zzcbVar = this.f22722b;
            zzbeVar = new zzbe(i4, i5);
            this.f22723c = zzbeVar;
        }
        if (zzcbVar != null) {
            zzcbVar.a(zzbeVar);
        }
    }

    public final void zzc(zzcb zzcbVar) {
        zzbe zzbeVar;
        synchronized (this.f22721a) {
            this.f22722b = (zzcb) Preconditions.checkNotNull(zzcbVar);
            zzbeVar = this.f22723c;
        }
        if (zzbeVar != null) {
            zzcbVar.a(zzbeVar);
        }
    }
}
