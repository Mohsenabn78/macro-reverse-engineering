package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfju {
    private final Context zza;
    private final Executor zzb;
    private final zzfjb zzc;
    private final zzfjd zzd;
    private final zzfjt zze;
    private final zzfjt zzf;
    private Task zzg;
    private Task zzh;

    @VisibleForTesting
    zzfju(Context context, Executor executor, zzfjb zzfjbVar, zzfjd zzfjdVar, zzfjr zzfjrVar, zzfjs zzfjsVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfjbVar;
        this.zzd = zzfjdVar;
        this.zze = zzfjrVar;
        this.zzf = zzfjsVar;
    }

    public static zzfju zze(@NonNull Context context, @NonNull Executor executor, @NonNull zzfjb zzfjbVar, @NonNull zzfjd zzfjdVar) {
        final zzfju zzfjuVar = new zzfju(context, executor, zzfjbVar, zzfjdVar, new zzfjr(), new zzfjs());
        if (zzfjuVar.zzd.zzd()) {
            zzfjuVar.zzg = zzfjuVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjo
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzfju.this.zzc();
                }
            });
        } else {
            zzfjuVar.zzg = Tasks.forResult(zzfjuVar.zze.zza());
        }
        zzfjuVar.zzh = zzfjuVar.zzh(new Callable() { // from class: com.google.android.gms.internal.ads.zzfjp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzfju.this.zzd();
            }
        });
        return zzfjuVar;
    }

    private static zzaon zzg(@NonNull Task task, @NonNull zzaon zzaonVar) {
        if (!task.isSuccessful()) {
            return zzaonVar;
        }
        return (zzaon) task.getResult();
    }

    private final Task zzh(@NonNull Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, new OnFailureListener() { // from class: com.google.android.gms.internal.ads.zzfjq
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                zzfju.this.zzf(exc);
            }
        });
    }

    public final zzaon zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzaon zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzaon zzc() throws Exception {
        Context context = this.zza;
        zzanq zza = zzaon.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza.zzs(id);
            zza.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza.zzab(6);
        }
        return (zzaon) zza.zzal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzaon zzd() throws Exception {
        Context context = this.zza;
        return zzfjj.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1L, exc);
    }
}
