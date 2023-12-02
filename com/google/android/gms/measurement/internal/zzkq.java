package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkq {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f22010a;

    /* renamed from: b  reason: collision with root package name */
    private long f22011b;

    public zzkq(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f22010a = clock;
    }

    public final void a() {
        this.f22011b = 0L;
    }

    public final void b() {
        this.f22011b = this.f22010a.elapsedRealtime();
    }

    public final boolean c(long j4) {
        if (this.f22011b == 0 || this.f22010a.elapsedRealtime() - this.f22011b >= 3600000) {
            return true;
        }
        return false;
    }
}
