package com.google.android.gms.nearby.uwb;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzc {

    /* renamed from: a  reason: collision with root package name */
    private int f22555a = 0;

    public final zzc zza(int i4) {
        this.f22555a = i4;
        return this;
    }

    public final zze zzb() {
        boolean z3;
        if (this.f22555a != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "deviceType must be set.");
        return new zze(this.f22555a, false, null, hashCode(), null);
    }
}
