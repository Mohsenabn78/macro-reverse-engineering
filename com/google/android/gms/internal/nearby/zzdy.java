package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface zzdy extends IInterface {
    void zzb(Status status, @Nullable List list) throws RemoteException;
}
