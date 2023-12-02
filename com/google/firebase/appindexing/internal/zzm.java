package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.appindexing.FirebaseAppIndex;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
/* loaded from: classes5.dex */
public final class zzm extends TaskApiCall<zzf, Void> {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzn f28826d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzm(zzn zznVar, zzi zziVar) {
        super(null, false, PlacesStatusCodes.KEY_INVALID);
        this.f28826d = zznVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* bridge */ /* synthetic */ void a(zzf zzfVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzz zzzVar;
        int i4;
        Queue queue;
        Queue queue2;
        Queue queue3;
        TaskCompletionSource taskCompletionSource2;
        Queue queue4;
        int i5;
        Queue queue5;
        zzl zzlVar = new zzl(this, taskCompletionSource);
        zzzVar = this.f28826d.f28827a;
        zzg zzd = ((zzv) zzfVar.getService()).zzd(zzlVar, zzzVar);
        if (zzd == null) {
            i4 = 2;
        } else {
            i4 = zzd.zzd;
        }
        boolean z3 = false;
        boolean z4 = true;
        zzn zznVar = null;
        if (i4 == 3) {
            if (zzw.zzb(4)) {
                Log.i(FirebaseAppIndex.APP_INDEXING_API_TAG, "Queue was full. API call will be retried.");
            }
            if (taskCompletionSource.trySetResult(null)) {
                queue4 = this.f28826d.f28829c.f28832c;
                synchronized (queue4) {
                    i5 = this.f28826d.f28829c.f28833d;
                    if (i5 == 0) {
                        queue5 = this.f28826d.f28829c.f28832c;
                        zzn zznVar2 = (zzn) queue5.peek();
                        if (zznVar2 == this.f28826d) {
                            z3 = true;
                        }
                        Preconditions.checkState(z3);
                        zznVar = zznVar2;
                    } else {
                        this.f28826d.f28829c.f28833d = 2;
                    }
                }
            }
        } else {
            if (i4 != 1) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("API call failed. Status code: ");
                sb.append(i4);
                String sb2 = sb.toString();
                if (zzw.zzb(6)) {
                    Log.e(FirebaseAppIndex.APP_INDEXING_API_TAG, sb2);
                }
                if (taskCompletionSource.trySetResult(null)) {
                    taskCompletionSource2 = this.f28826d.f28828b;
                    taskCompletionSource2.setException(new FirebaseAppIndexingException("Indexing error."));
                }
            }
            queue = this.f28826d.f28829c.f28832c;
            synchronized (queue) {
                queue2 = this.f28826d.f28829c.f28832c;
                if (((zzn) queue2.poll()) != this.f28826d) {
                    z4 = false;
                }
                Preconditions.checkState(z4);
                queue3 = this.f28826d.f28829c.f28832c;
                zznVar = (zzn) queue3.peek();
                this.f28826d.f28829c.f28833d = 0;
            }
        }
        if (zznVar != null) {
            zznVar.b();
        }
    }
}
