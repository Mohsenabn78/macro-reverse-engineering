package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public abstract class DataHolderResult implements Result, Releasable {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    protected final Status f20047a;
    @NonNull
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    protected final DataHolder f20048b;

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    @KeepForSdk
    public Status getStatus() {
        return this.f20047a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    @KeepForSdk
    public void release() {
        DataHolder dataHolder = this.f20048b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
