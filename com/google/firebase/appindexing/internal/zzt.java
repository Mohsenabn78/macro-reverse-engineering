package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.appindexing.Action;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseUserActions;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class zzt extends FirebaseUserActions {

    /* renamed from: b  reason: collision with root package name */
    private final zzr f28839b;

    public zzt(Context context) {
        this.f28839b = new zzr(context);
    }

    private final Task<Void> a(int i4, Action action) {
        zzc[] zzcVarArr = new zzc[1];
        if (action != null) {
            if (!(action instanceof zzc)) {
                return Tasks.forException(new FirebaseAppIndexingInvalidArgumentException("Custom Action objects are not allowed. Please use the 'Actions' or 'ActionBuilder' class for creating Action objects."));
            }
            zzc zzcVar = (zzc) action;
            zzcVarArr[0] = zzcVar;
            zzcVar.zza().zza(i4);
        }
        return this.f28839b.doWrite(new zzq(this, zzcVarArr));
    }

    @Override // com.google.firebase.appindexing.FirebaseUserActions
    public final Task<Void> end(Action action) {
        return a(2, action);
    }

    @Override // com.google.firebase.appindexing.FirebaseUserActions
    public final Task<Void> start(Action action) {
        return a(1, action);
    }
}
