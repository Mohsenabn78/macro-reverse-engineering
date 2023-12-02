package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
class zzhn extends zza {

    /* renamed from: a  reason: collision with root package name */
    private BaseImplementation.ResultHolder f22797a;

    public zzhn(BaseImplementation.ResultHolder resultHolder) {
        this.f22797a = resultHolder;
    }

    public final void a(Object obj) {
        BaseImplementation.ResultHolder resultHolder = this.f22797a;
        if (resultHolder != null) {
            resultHolder.setResult(obj);
            this.f22797a = null;
        }
    }
}
