package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzam implements CapabilityClient.OnCapabilityChangedListener {

    /* renamed from: a  reason: collision with root package name */
    final CapabilityClient.OnCapabilityChangedListener f22669a;

    /* renamed from: b  reason: collision with root package name */
    final String f22670b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzam(CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        this.f22669a = onCapabilityChangedListener;
        this.f22670b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzam.class != obj.getClass()) {
            return false;
        }
        zzam zzamVar = (zzam) obj;
        if (!this.f22669a.equals(zzamVar.f22669a)) {
            return false;
        }
        return this.f22670b.equals(zzamVar.f22670b);
    }

    public final int hashCode() {
        return (this.f22669a.hashCode() * 31) + this.f22670b.hashCode();
    }

    @Override // com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener, com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        this.f22669a.onCapabilityChanged(capabilityInfo);
    }
}
