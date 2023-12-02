package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzmq {
    @Nullable
    private static zzao zza;
    private static final zzar zzb = zzar.zzc("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzmp zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzmq(Context context, final SharedPrefManager sharedPrefManager, zzmp zzmpVar, String str) {
        int i4;
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzmpVar;
        zzne.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzml
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzmq.this.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzmm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzar zzarVar = zzb;
        if (zzarVar.containsKey(str)) {
            i4 = DynamiteModule.getRemoteVersion(context, (String) zzarVar.get(str));
        } else {
            i4 = -1;
        }
        this.zzj = i4;
    }

    @NonNull
    private static synchronized zzao zzh() {
        synchronized (zzmq.class) {
            zzao zzaoVar = zza;
            if (zzaoVar != null) {
                return zzaoVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzal zzalVar = new zzal();
            for (int i4 = 0; i4 < locales.size(); i4++) {
                zzalVar.zzc(CommonUtils.languageTagFromLocale(locales.get(i4)));
            }
            zzao zzd = zzalVar.zzd();
            zza = zzd;
            return zzd;
        }
    }

    private final zzle zzi(String str, String str2) {
        String mlSdkInstanceId;
        zzle zzleVar = new zzle();
        zzleVar.zzb(this.zzc);
        zzleVar.zzc(this.zzd);
        zzleVar.zzh(zzh());
        zzleVar.zzg(Boolean.TRUE);
        zzleVar.zzl(str);
        zzleVar.zzj(str2);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zzleVar.zzi(mlSdkInstanceId);
        zzleVar.zzd(10);
        zzleVar.zzk(Integer.valueOf(this.zzj));
        return zzleVar;
    }

    @WorkerThread
    private final String zzj() {
        if (this.zzg.isSuccessful()) {
            return (String) this.zzg.getResult();
        }
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzmh zzmhVar, zziz zzizVar, String str) {
        zzmhVar.zza(zzizVar);
        zzmhVar.zzc(zzi(zzmhVar.zzd(), str));
        this.zze.zza(zzmhVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzmh zzmhVar, zzms zzmsVar, RemoteModel remoteModel) {
        zzmhVar.zza(zziz.MODEL_DOWNLOAD);
        zzmhVar.zzc(zzi(zzmsVar.zze(), zzj()));
        zzmhVar.zzb(zznc.zza(remoteModel, this.zzf, zzmsVar));
        this.zze.zza(zzmhVar);
    }

    public final void zzd(final zzmh zzmhVar, final zziz zzizVar) {
        final String zzj = zzj();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzmn
            @Override // java.lang.Runnable
            public final void run() {
                zzmq.this.zzb(zzmhVar, zzizVar, zzj);
            }
        });
    }

    public final void zze(zzmh zzmhVar, RemoteModel remoteModel, boolean z3, int i4) {
        zzmr zzh = zzms.zzh();
        zzh.zzf(false);
        zzh.zzd(remoteModel.getModelType());
        zzh.zza(zzje.FAILED);
        zzh.zzb(zziy.DOWNLOAD_FAILED);
        zzh.zzc(i4);
        zzg(zzmhVar, remoteModel, zzh.zzh());
    }

    public final void zzf(zzmh zzmhVar, RemoteModel remoteModel, zziy zziyVar, boolean z3, ModelType modelType, zzje zzjeVar) {
        zzmr zzh = zzms.zzh();
        zzh.zzf(z3);
        zzh.zzd(modelType);
        zzh.zzb(zziyVar);
        zzh.zza(zzjeVar);
        zzg(zzmhVar, remoteModel, zzh.zzh());
    }

    public final void zzg(final zzmh zzmhVar, final RemoteModel remoteModel, final zzms zzmsVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_common.zzmo
            @Override // java.lang.Runnable
            public final void run() {
                zzmq.this.zzc(zzmhVar, zzmsVar, remoteModel);
            }
        });
    }
}
