package com.google.android.gms.internal.mlkit_translate;

import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqh {
    private static final GmsLogger zza = new GmsLogger("RemoteModelUtils", "");

    @WorkerThread
    public static zzll zza(RemoteModel remoteModel, SharedPrefManager sharedPrefManager, zzpw zzpwVar) {
        zzln zzlnVar;
        ModelType zzb = zzpwVar.zzb();
        String modelHash = remoteModel.getModelHash();
        zzlr zzlrVar = new zzlr();
        zzlm zzlmVar = new zzlm();
        zzlmVar.zzc(remoteModel.getModelNameForBackend());
        zzlmVar.zzd(zzlo.CLOUD);
        zzlmVar.zza(zzl.zzb(modelHash));
        int i4 = zzqg.zza[zzb.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    zzlnVar = zzln.TYPE_UNKNOWN;
                } else {
                    zzlnVar = zzln.CUSTOM;
                }
            } else {
                zzlnVar = zzln.BASE_DIGITAL_INK;
            }
        } else {
            zzlnVar = zzln.BASE_TRANSLATE;
        }
        zzlmVar.zzb(zzlnVar);
        zzlrVar.zzb(zzlmVar.zzg());
        zzlu zzc = zzlrVar.zzc();
        zzli zzliVar = new zzli();
        zzliVar.zzd(zzpwVar.zzc());
        zzliVar.zzc(zzpwVar.zzd());
        zzliVar.zzb(Long.valueOf(zzpwVar.zza()));
        zzliVar.zze(zzc);
        if (zzpwVar.zzg()) {
            long modelDownloadBeginTimeMs = sharedPrefManager.getModelDownloadBeginTimeMs(remoteModel);
            if (modelDownloadBeginTimeMs == 0) {
                zza.w("RemoteModelUtils", "Model downloaded without its beginning time recorded.");
            } else {
                long modelFirstUseTimeMs = sharedPrefManager.getModelFirstUseTimeMs(remoteModel);
                if (modelFirstUseTimeMs == 0) {
                    modelFirstUseTimeMs = SystemClock.elapsedRealtime();
                    sharedPrefManager.setModelFirstUseTimeMs(remoteModel, modelFirstUseTimeMs);
                }
                zzliVar.zzf(Long.valueOf(modelFirstUseTimeMs - modelDownloadBeginTimeMs));
            }
        }
        return zzliVar.zzh();
    }
}
