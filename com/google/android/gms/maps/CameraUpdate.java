package com.google.android.gms.maps;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class CameraUpdate {

    /* renamed from: a  reason: collision with root package name */
    private final IObjectWrapper f21197a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraUpdate(IObjectWrapper iObjectWrapper) {
        this.f21197a = (IObjectWrapper) Preconditions.checkNotNull(iObjectWrapper);
    }

    public final IObjectWrapper zzb() {
        return this.f21197a;
    }
}
