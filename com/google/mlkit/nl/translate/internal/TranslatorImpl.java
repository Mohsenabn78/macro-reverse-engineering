package com.google.mlkit.nl.translate.internal;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.sdkinternal.CloseGuard;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class TranslatorImpl implements Translator {

    /* renamed from: i  reason: collision with root package name */
    private static final DownloadConditions f33068i = new DownloadConditions.Builder().build();
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a  reason: collision with root package name */
    private final TranslatorOptions f33069a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider f33070b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference f33071c;

    /* renamed from: d  reason: collision with root package name */
    private final zzt f33072d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f33073e;

    /* renamed from: f  reason: collision with root package name */
    private final Task f33074f;

    /* renamed from: g  reason: collision with root package name */
    private final CancellationTokenSource f33075g = new CancellationTokenSource();

    /* renamed from: h  reason: collision with root package name */
    private CloseGuard f33076h;

    /* compiled from: com.google.mlkit:translate@@17.0.1 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public static class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Provider f33077a;

        /* renamed from: b  reason: collision with root package name */
        private final zzj f33078b;

        /* renamed from: c  reason: collision with root package name */
        private final zzr f33079c;

        /* renamed from: d  reason: collision with root package name */
        private final zzaf f33080d;

        /* renamed from: e  reason: collision with root package name */
        private final ExecutorSelector f33081e;

        /* renamed from: f  reason: collision with root package name */
        private final zzq f33082f;

        /* renamed from: g  reason: collision with root package name */
        private final CloseGuard.Factory f33083g;

        public Factory(Provider provider, zzj zzjVar, zzr zzrVar, zzaf zzafVar, ExecutorSelector executorSelector, zzq zzqVar, CloseGuard.Factory factory) {
            this.f33081e = executorSelector;
            this.f33082f = zzqVar;
            this.f33077a = provider;
            this.f33079c = zzrVar;
            this.f33078b = zzjVar;
            this.f33080d = zzafVar;
            this.f33083g = factory;
        }

        @NonNull
        public final Translator zza(@NonNull TranslatorOptions translatorOptions) {
            TranslatorImpl translatorImpl = new TranslatorImpl(translatorOptions, this.f33077a, (TranslateJni) this.f33078b.get(translatorOptions), this.f33079c.zza(translatorOptions.zza()), this.f33081e.getExecutorToUse(translatorOptions.zzf()), this.f33082f, null);
            TranslatorImpl.c(translatorImpl, this.f33083g, this.f33080d);
            return translatorImpl;
        }
    }

    /* synthetic */ TranslatorImpl(TranslatorOptions translatorOptions, Provider provider, TranslateJni translateJni, zzt zztVar, Executor executor, zzq zzqVar, zzas zzasVar) {
        this.f33069a = translatorOptions;
        this.f33070b = provider;
        this.f33071c = new AtomicReference(translateJni);
        this.f33072d = zztVar;
        this.f33073e = executor;
        this.f33074f = zzqVar.getMigrationTask();
    }

    static /* bridge */ /* synthetic */ void c(final TranslatorImpl translatorImpl, CloseGuard.Factory factory, zzaf zzafVar) {
        translatorImpl.f33076h = factory.create(translatorImpl, 1, new Runnable() { // from class: com.google.mlkit.nl.translate.internal.zzap
            @Override // java.lang.Runnable
            public final void run() {
                TranslatorImpl.this.d();
            }
        });
        ((TranslateJni) translatorImpl.f33071c.get()).pin();
        translatorImpl.f33072d.zzx();
        zzafVar.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task b(DownloadConditions downloadConditions, Task task) throws Exception {
        Preconditions.checkHandlerThread(MLTaskExecutor.getInstance().getHandler());
        com.google.android.gms.internal.mlkit_translate.zzs zzg = com.google.android.gms.internal.mlkit_translate.zzv.zzg();
        com.google.android.gms.internal.mlkit_translate.zzam it = zzad.zzc(this.f33069a.zzd(), this.f33069a.zze()).iterator();
        while (it.hasNext()) {
            zzg.zzc(((zzaa) this.f33070b.get()).zza(new TranslateRemoteModel.Builder((String) it.next()).build(), true).zzb(downloadConditions));
        }
        return Tasks.whenAll(zzg.zzd());
    }

    @Override // com.google.mlkit.nl.translate.Translator, java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void close() {
        this.f33076h.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d() {
        boolean z3;
        CancellationTokenSource cancellationTokenSource = this.f33075g;
        AtomicReference atomicReference = this.f33071c;
        Executor executor = this.f33073e;
        cancellationTokenSource.cancel();
        TranslateJni translateJni = (TranslateJni) atomicReference.getAndSet(null);
        if (translateJni != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        translateJni.unpin(executor);
    }

    @Override // com.google.mlkit.nl.translate.Translator
    @NonNull
    public final Task<Void> downloadModelIfNeeded() {
        DownloadConditions downloadConditions = f33068i;
        return this.f33074f.continueWithTask(MLTaskExecutor.workerThreadExecutor(), new zzao(this, downloadConditions));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(String str, boolean z3, long j4, Task task) {
        this.f33072d.zzy(str, z3, SystemClock.elapsedRealtime() - j4, task);
    }

    @Override // com.google.mlkit.nl.translate.Translator
    @NonNull
    public final Task<String> translate(@NonNull final String str) {
        boolean z3;
        Preconditions.checkNotNull(str, "Input can't be null");
        final TranslateJni translateJni = (TranslateJni) this.f33071c.get();
        if (translateJni != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "Translator has been closed");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final boolean z4 = !translateJni.isLoaded();
        return translateJni.callAfterLoad(this.f33073e, new Callable() { // from class: com.google.mlkit.nl.translate.internal.zzaq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                TranslateJni translateJni2 = TranslateJni.this;
                String str2 = str;
                int i4 = TranslatorImpl.zza;
                return translateJni2.zzd(str2);
            }
        }, this.f33075g.getToken()).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.mlkit.nl.translate.internal.zzar
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TranslatorImpl.this.e(str, z4, elapsedRealtime, task);
            }
        });
    }

    @Override // com.google.mlkit.nl.translate.Translator
    @NonNull
    public final Task<Void> downloadModelIfNeeded(@NonNull DownloadConditions downloadConditions) {
        return this.f33074f.continueWithTask(MLTaskExecutor.workerThreadExecutor(), new zzao(this, downloadConditions));
    }
}
