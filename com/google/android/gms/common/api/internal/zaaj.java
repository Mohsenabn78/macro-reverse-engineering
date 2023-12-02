package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaaj implements zabf {

    /* renamed from: a  reason: collision with root package name */
    private final zabi f20140a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20141b = false;

    public zaaj(zabi zabiVar) {
        this.f20140a = zabiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.f20141b) {
            this.f20141b = false;
            this.f20140a.f20231n.f20214x.zab();
            zaj();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zaa(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        zab(apiMethodImpl);
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final BaseImplementation.ApiMethodImpl zab(BaseImplementation.ApiMethodImpl apiMethodImpl) {
        try {
            this.f20140a.f20231n.f20214x.a(apiMethodImpl);
            zabe zabeVar = this.f20140a.f20231n;
            Api.Client client = (Api.Client) zabeVar.f20205o.get(apiMethodImpl.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && this.f20140a.f20224g.containsKey(apiMethodImpl.getClientKey())) {
                apiMethodImpl.setFailedResult(new Status(17));
            } else {
                apiMethodImpl.run(client);
            }
        } catch (DeadObjectException unused) {
            this.f20140a.f(new zaah(this, this));
        }
        return apiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zae() {
        if (this.f20141b) {
            this.f20141b = false;
            this.f20140a.f(new zaai(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zai(int i4) {
        this.f20140a.e(null);
        this.f20140a.f20232o.zac(i4, this.f20141b);
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        if (this.f20141b) {
            return false;
        }
        Set<zada> set = this.f20140a.f20231n.f20213w;
        if (set != null && !set.isEmpty()) {
            this.f20141b = true;
            for (zada zadaVar : set) {
                zadaVar.h();
            }
            return false;
        }
        this.f20140a.e(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zag(@Nullable Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zah(ConnectionResult connectionResult, Api api, boolean z3) {
    }
}
