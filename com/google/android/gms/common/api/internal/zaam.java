package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaam extends zabg {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ConnectionResult f20146b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zaao f20147c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaam(zaao zaaoVar, zabf zabfVar, ConnectionResult connectionResult) {
        super(zabfVar);
        this.f20147c = zaaoVar;
        this.f20146b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    @GuardedBy("mLock")
    public final void a() {
        this.f20147c.f20150c.d(this.f20146b);
    }
}
