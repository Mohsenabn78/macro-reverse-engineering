package com.google.mlkit.common.sdkinternal.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.LongSparseArray;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zziy;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzmh;
import com.google.android.gms.internal.mlkit_common.zzmq;
import com.google.android.gms.internal.mlkit_common.zzmr;
import com.google.android.gms.internal.mlkit_common.zzms;
import com.google.android.gms.internal.mlkit_common.zzmt;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.5.0 */
@WorkerThread
/* loaded from: classes5.dex */
public final class zzd extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final long f33042a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f33043b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ RemoteModelDownloadManager f33044c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzd(RemoteModelDownloadManager remoteModelDownloadManager, long j4, TaskCompletionSource taskCompletionSource, zzc zzcVar) {
        this.f33044c = remoteModelDownloadManager;
        this.f33042a = j4;
        this.f33043b = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        GmsLogger gmsLogger;
        LongSparseArray longSparseArray;
        LongSparseArray longSparseArray2;
        zzmq zzmqVar;
        RemoteModel remoteModel;
        zzmq zzmqVar2;
        RemoteModel remoteModel2;
        RemoteModel remoteModel3;
        zzmq zzmqVar3;
        RemoteModel remoteModel4;
        MlKitException k4;
        MlKitContext mlKitContext;
        long longExtra = intent.getLongExtra("extra_download_id", -1L);
        if (longExtra != this.f33042a) {
            return;
        }
        Integer downloadingModelStatusCode = this.f33044c.getDownloadingModelStatusCode();
        synchronized (this.f33044c) {
            try {
                mlKitContext = this.f33044c.f33014c;
                mlKitContext.getApplicationContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e4) {
                gmsLogger = RemoteModelDownloadManager.f33010m;
                gmsLogger.w("ModelDownloadManager", "Exception thrown while trying to unregister the broadcast receiver for the download", e4);
            }
            longSparseArray = this.f33044c.f33012a;
            longSparseArray.remove(this.f33042a);
            longSparseArray2 = this.f33044c.f33013b;
            longSparseArray2.remove(this.f33042a);
        }
        if (downloadingModelStatusCode != null) {
            if (downloadingModelStatusCode.intValue() == 16) {
                zzmqVar3 = this.f33044c.f33018g;
                zzmh zzg = zzmt.zzg();
                RemoteModelDownloadManager remoteModelDownloadManager = this.f33044c;
                remoteModel4 = remoteModelDownloadManager.f33016e;
                Long valueOf = Long.valueOf(longExtra);
                zzmqVar3.zze(zzg, remoteModel4, false, remoteModelDownloadManager.getFailureReason(valueOf));
                TaskCompletionSource taskCompletionSource = this.f33043b;
                k4 = this.f33044c.k(valueOf);
                taskCompletionSource.setException(k4);
                return;
            } else if (downloadingModelStatusCode.intValue() == 8) {
                zzmqVar2 = this.f33044c.f33018g;
                zzmh zzg2 = zzmt.zzg();
                remoteModel2 = this.f33044c.f33016e;
                zzmr zzh = zzms.zzh();
                zzh.zzb(zziy.NO_ERROR);
                zzh.zze(true);
                remoteModel3 = this.f33044c.f33016e;
                zzh.zzd(remoteModel3.getModelType());
                zzh.zza(zzje.SUCCEEDED);
                zzmqVar2.zzg(zzg2, remoteModel2, zzh.zzh());
                this.f33043b.setResult(null);
                return;
            }
        }
        zzmqVar = this.f33044c.f33018g;
        zzmh zzg3 = zzmt.zzg();
        remoteModel = this.f33044c.f33016e;
        zzmqVar.zze(zzg3, remoteModel, false, 0);
        this.f33043b.setException(new MlKitException("Model downloading failed", 13));
    }
}
