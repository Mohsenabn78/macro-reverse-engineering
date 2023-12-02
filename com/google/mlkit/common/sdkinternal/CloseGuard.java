package com.google.mlkit.common.sdkinternal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zziu;
import com.google.android.gms.internal.mlkit_common.zziv;
import com.google.android.gms.internal.mlkit_common.zziz;
import com.google.android.gms.internal.mlkit_common.zzja;
import com.google.android.gms.internal.mlkit_common.zzmq;
import com.google.android.gms.internal.mlkit_common.zzmt;
import com.google.android.gms.internal.mlkit_common.zznb;
import com.google.mlkit.common.sdkinternal.Cleaner;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class CloseGuard implements Closeable {
    @KeepForSdk
    public static final int API_TRANSLATE = 1;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f32954a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final String f32955b;

    /* renamed from: c  reason: collision with root package name */
    private final Cleaner.Cleanable f32956c;

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public static class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final Cleaner f32957a;

        public Factory(@NonNull Cleaner cleaner) {
            this.f32957a = cleaner;
        }

        @NonNull
        @KeepForSdk
        public CloseGuard create(@NonNull Object obj, int i4, @NonNull Runnable runnable) {
            return new CloseGuard(obj, i4, this.f32957a, runnable, zznb.zzb("common"));
        }
    }

    CloseGuard(Object obj, final int i4, Cleaner cleaner, final Runnable runnable, final zzmq zzmqVar) {
        this.f32955b = obj.toString();
        this.f32956c = cleaner.register(obj, new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zze
            @Override // java.lang.Runnable
            public final void run() {
                CloseGuard.this.b(i4, zzmqVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(int i4, zzmq zzmqVar, Runnable runnable) {
        if (!this.f32954a.get()) {
            Log.e("MlKitCloseGuard", String.format(Locale.ENGLISH, "%s has not been closed", this.f32955b));
            zzja zzjaVar = new zzja();
            zziv zzivVar = new zziv();
            zzivVar.zzb(zziu.zzb(i4));
            zzjaVar.zzh(zzivVar.zzc());
            zzmqVar.zzd(zzmt.zzf(zzjaVar), zziz.HANDLE_LEAKED);
        }
        runnable.run();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f32954a.set(true);
        this.f32956c.clean();
    }
}
