package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zag extends zac {

    /* renamed from: a  reason: collision with root package name */
    private final TaskApiCall f20309a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f20310b;

    /* renamed from: c  reason: collision with root package name */
    private final StatusExceptionMapper f20311c;

    public zag(int i4, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(i4);
        this.f20310b = taskCompletionSource;
        this.f20309a = taskApiCall;
        this.f20311c = statusExceptionMapper;
        if (i4 == 2 && taskApiCall.shouldAutoResolveMissingFeatures()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        return this.f20309a.shouldAutoResolveMissingFeatures();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    @Nullable
    public final Feature[] zab(zabq zabqVar) {
        return this.f20309a.zab();
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(@NonNull Status status) {
        this.f20310b.trySetException(this.f20311c.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(@NonNull Exception exc) {
        this.f20310b.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            this.f20309a.a(zabqVar.zaf(), this.f20310b);
        } catch (DeadObjectException e4) {
            throw e4;
        } catch (RemoteException e5) {
            zad(zai.a(e5));
        } catch (RuntimeException e6) {
            this.f20310b.trySetException(e6);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(@NonNull zaad zaadVar, boolean z3) {
        zaadVar.d(this.f20310b, z3);
    }
}
