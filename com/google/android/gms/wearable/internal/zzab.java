package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzab implements CapabilityApi.CapabilityListener {

    /* renamed from: a  reason: collision with root package name */
    final CapabilityApi.CapabilityListener f22660a;

    /* renamed from: b  reason: collision with root package name */
    final String f22661b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(CapabilityApi.CapabilityListener capabilityListener, String str) {
        this.f22660a = capabilityListener;
        this.f22661b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzab.class != obj.getClass()) {
            return false;
        }
        zzab zzabVar = (zzab) obj;
        if (!this.f22660a.equals(zzabVar.f22660a)) {
            return false;
        }
        return this.f22661b.equals(zzabVar.f22661b);
    }

    public final int hashCode() {
        return (this.f22660a.hashCode() * 31) + this.f22661b.hashCode();
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public final void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        this.f22660a.onCapabilityChanged(capabilityInfo);
    }
}
