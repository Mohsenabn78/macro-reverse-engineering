package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfjb {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    zzfjb(@NonNull Context context, @NonNull Executor executor, @NonNull Task task, boolean z3) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z3;
    }

    public static zzfjb zza(@NonNull final Context context, @NonNull Executor executor, boolean z3) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z3) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfix
                @Override // java.lang.Runnable
                public final void run() {
                    taskCompletionSource.setResult(zzfld.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfiy
                @Override // java.lang.Runnable
                public final void run() {
                    TaskCompletionSource.this.setResult(zzfld.zzc());
                }
            });
        }
        return new zzfjb(context, executor, taskCompletionSource.getTask(), z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzg(int i4) {
        zzf = i4;
    }

    private final Task zzh(final int i4, long j4, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfiz
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return Boolean.valueOf(task.isSuccessful());
                }
            });
        }
        final zzanc zza2 = zzang.zza();
        zza2.zza(this.zzb.getPackageName());
        zza2.zze(j4);
        zza2.zzg(zzf);
        if (exc != null) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zza2.zzf(stringWriter.toString());
            zza2.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zza2.zzb(str2);
        }
        if (str != null) {
            zza2.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfja
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                zzanc zzancVar = zzanc.this;
                int i5 = i4;
                int i6 = zzfjb.zza;
                if (task.isSuccessful()) {
                    zzflc zza3 = ((zzfld) task.getResult()).zza(((zzang) zzancVar.zzal()).zzax());
                    zza3.zza(i5);
                    zza3.zzc();
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
    }

    public final Task zzb(int i4, String str) {
        return zzh(i4, 0L, null, null, null, str);
    }

    public final Task zzc(int i4, long j4, Exception exc) {
        return zzh(i4, j4, exc, null, null, null);
    }

    public final Task zzd(int i4, long j4) {
        return zzh(i4, j4, null, null, null, null);
    }

    public final Task zze(int i4, long j4, String str) {
        return zzh(i4, j4, null, null, null, str);
    }

    public final Task zzf(int i4, long j4, String str, Map map) {
        return zzh(i4, j4, null, str, null, null);
    }
}
