package com.google.android.gms.ads.internal.util;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbz {

    /* renamed from: a  reason: collision with root package name */
    private long f19313a;

    /* renamed from: b  reason: collision with root package name */
    private long f19314b = Long.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private final Object f19315c = new Object();

    public zzbz(long j4) {
        this.f19313a = j4;
    }

    public final void zza(long j4) {
        synchronized (this.f19315c) {
            this.f19313a = j4;
        }
    }

    public final boolean zzb() {
        synchronized (this.f19315c) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            if (this.f19314b + this.f19313a > elapsedRealtime) {
                return false;
            }
            this.f19314b = elapsedRealtime;
            return true;
        }
    }
}
