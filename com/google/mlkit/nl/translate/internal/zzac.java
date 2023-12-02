package com.google.mlkit.nl.translate.internal;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_translate.zzba;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzac {

    /* renamed from: e  reason: collision with root package name */
    private static final GmsLogger f33087e = new GmsLogger("TranslateModelLoader", "");
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a  reason: collision with root package name */
    private final zzi f33088a;

    /* renamed from: b  reason: collision with root package name */
    private final zzz f33089b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Task f33090c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private CancellationTokenSource f33091d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzac(zzi zziVar, zzz zzzVar, zzab zzabVar) {
        this.f33088a = zziVar;
        this.f33089b = zzzVar;
    }

    private final void d() throws MlKitException {
        if (this.f33088a.j()) {
            return;
        }
        f33087e.d("TranslateModelLoader", "No existing model file");
        throw new MlKitException("No existing model file", 13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task a(DownloadConditions downloadConditions, Task task) throws Exception {
        if (task.isCanceled()) {
            return Tasks.forResult(com.google.android.gms.internal.mlkit_translate.zzf.zzb());
        }
        return this.f33088a.a(downloadConditions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void b(Task task) throws Exception {
        this.f33090c = null;
        Exception exception = task.getException();
        if (exception != null) {
            zzz.b(this.f33089b);
        }
        if (exception == null && ((com.google.android.gms.internal.mlkit_translate.zzf) task.getResult()).zza()) {
            this.f33089b.f33141a = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            d();
            return null;
        }
        throw new MlKitException("Model not downloaded.", 13, exception);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void c(Task task) throws Exception {
        if (task.isSuccessful()) {
            return (Void) task.getResult();
        }
        try {
            f33087e.d("TranslateModelLoader", "Try to load newly downloaded model file.");
            if (this.f33088a.b() != null) {
                return null;
            }
            throw new MlKitException("Newly downloaded model file could not be loaded.", 13);
        } catch (MlKitException unused) {
            f33087e.d("TranslateModelLoader", "Loading existing model file.");
            d();
            return null;
        }
    }

    @WorkerThread
    public final Task zzb(final DownloadConditions downloadConditions) {
        double d4;
        Preconditions.checkHandlerThread(MLTaskExecutor.getInstance().getHandler());
        if (this.f33090c == null) {
            f33087e.d("TranslateModelLoader", "Initial loading, check for model updates.");
            CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
            this.f33091d = cancellationTokenSource;
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
            d4 = this.f33089b.f33141a;
            MLTaskExecutor.getInstance().scheduleRunnableDelayed(new Runnable() { // from class: com.google.mlkit.nl.translate.internal.zzv
                @Override // java.lang.Runnable
                public final void run() {
                    TaskCompletionSource taskCompletionSource2 = TaskCompletionSource.this;
                    int i4 = zzac.zza;
                    taskCompletionSource2.trySetResult(null);
                }
            }, (long) (d4 * 1000.0d));
            this.f33090c = taskCompletionSource.getTask().continueWithTask(zzba.zza(), new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzw
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return zzac.this.a(downloadConditions, task);
                }
            }).continueWith(zzba.zza(), new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzx
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    zzac.this.b(task);
                    return null;
                }
            });
        }
        return this.f33090c.continueWith(zzba.zza(), new Continuation() { // from class: com.google.mlkit.nl.translate.internal.zzy
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return zzac.this.c(task);
            }
        });
    }

    @WorkerThread
    public final void zze() throws MlKitException {
        CancellationTokenSource cancellationTokenSource = this.f33091d;
        if (cancellationTokenSource != null) {
            cancellationTokenSource.cancel();
        }
        this.f33088a.f();
        this.f33090c = null;
    }

    @WorkerThread
    public final boolean zzf() {
        return this.f33088a.j();
    }
}
