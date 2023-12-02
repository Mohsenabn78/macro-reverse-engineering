package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public interface RemoteCall<T, U> {
    @KeepForSdk
    void accept(@NonNull T t3, @NonNull U u3) throws RemoteException;
}
