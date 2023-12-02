package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class BitmapDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final IObjectWrapper f21282a;

    public BitmapDescriptor(IObjectWrapper iObjectWrapper) {
        this.f21282a = (IObjectWrapper) Preconditions.checkNotNull(iObjectWrapper);
    }

    public final IObjectWrapper zzb() {
        return this.f21282a;
    }
}
