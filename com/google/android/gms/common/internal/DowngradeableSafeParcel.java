package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f20444b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private boolean f20445a = false;

    @KeepForSdk
    public void setShouldDowngrade(boolean z3) {
        this.f20445a = z3;
    }
}
