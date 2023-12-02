package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@ShowFirstParty
/* loaded from: classes4.dex */
public final class zza {

    /* renamed from: a  reason: collision with root package name */
    private long f21183a = Long.MIN_VALUE;

    public final zza zza(long j4) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "intervalMillis can't be negative.");
        this.f21183a = j4;
        return this;
    }

    public final zzb zzb() {
        boolean z3;
        if (this.f21183a != Long.MIN_VALUE) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Must set intervalMillis.");
        return new zzb(this.f21183a, true, null, null, null, false, null, 0L, null);
    }
}
