package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zam {

    /* renamed from: a  reason: collision with root package name */
    private final int f20322a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f20323b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(ConnectionResult connectionResult, int i4) {
        Preconditions.checkNotNull(connectionResult);
        this.f20323b = connectionResult;
        this.f20322a = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f20322a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.f20323b;
    }
}
