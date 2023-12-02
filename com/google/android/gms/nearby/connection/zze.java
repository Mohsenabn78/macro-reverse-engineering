package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zze {

    /* renamed from: a  reason: collision with root package name */
    private int f22231a;

    /* renamed from: b  reason: collision with root package name */
    private int f22232b;

    public final zze zza(int i4) {
        this.f22232b = i4;
        return this;
    }

    public final zze zzb(int i4) {
        this.f22231a = i4;
        return this;
    }

    public final BandwidthInfo zzc() {
        return new BandwidthInfo(this.f22231a, this.f22232b, null);
    }
}
