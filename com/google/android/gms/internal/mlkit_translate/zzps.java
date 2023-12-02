package com.google.android.gms.internal.mlkit_translate;

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
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzps {
    @Nullable
    private static zzv zza;
    private static final zzy zzb = zzy.zzd("optional-module-barcode", OptionalModuleUtils.BARCODE_MODULE_ID);
    private final String zzc;
    private final String zzd;
    private final zzpr zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzps(Context context, final SharedPrefManager sharedPrefManager, zzpr zzprVar, String str) {
        int i4;
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzprVar;
        zzrf.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_translate.zzpn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzps.this.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_translate.zzpo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SharedPrefManager.this.getMlSdkInstanceId();
            }
        });
        zzy zzyVar = zzb;
        if (zzyVar.containsKey(str)) {
            i4 = DynamiteModule.getRemoteVersion(context, (String) zzyVar.get(str));
        } else {
            i4 = -1;
        }
        this.zzj = i4;
    }

    @NonNull
    private static synchronized zzv zzg() {
        synchronized (zzps.class) {
            zzv zzvVar = zza;
            if (zzvVar != null) {
                return zzvVar;
            }
            LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
            zzs zzsVar = new zzs();
            for (int i4 = 0; i4 < locales.size(); i4++) {
                zzsVar.zzc(CommonUtils.languageTagFromLocale(locales.get(i4)));
            }
            zzv zzd = zzsVar.zzd();
            zza = zzd;
            return zzd;
        }
    }

    private final zznp zzh(String str, String str2) {
        String mlSdkInstanceId;
        zznp zznpVar = new zznp();
        zznpVar.zzb(this.zzc);
        zznpVar.zzc(this.zzd);
        zznpVar.zzh(zzg());
        zznpVar.zzg(Boolean.TRUE);
        zznpVar.zzl(str);
        zznpVar.zzj(str2);
        if (this.zzh.isSuccessful()) {
            mlSdkInstanceId = (String) this.zzh.getResult();
        } else {
            mlSdkInstanceId = this.zzf.getMlSdkInstanceId();
        }
        zznpVar.zzi(mlSdkInstanceId);
        zznpVar.zzd(10);
        zznpVar.zzk(Integer.valueOf(this.zzj));
        return zznpVar;
    }

    @WorkerThread
    private final String zzi() {
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
    public final /* synthetic */ void zzb(zzpj zzpjVar, zzle zzleVar, String str) {
        zzpjVar.zza(zzleVar);
        zzpjVar.zzc(zzh(zzpjVar.zzd(), str));
        this.zze.zza(zzpjVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzpj zzpjVar, zzpw zzpwVar, RemoteModel remoteModel) {
        zzpjVar.zza(zzle.MODEL_DOWNLOAD);
        zzpjVar.zzc(zzh(zzpwVar.zze(), zzi()));
        zzpjVar.zzb(zzqh.zza(remoteModel, this.zzf, zzpwVar));
        this.zze.zza(zzpjVar);
    }

    public final void zzd(zzpj zzpjVar, zzle zzleVar) {
        zze(zzpjVar, zzleVar, zzi());
    }

    public final void zze(final zzpj zzpjVar, final zzle zzleVar, final String str) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_translate.zzpp
            @Override // java.lang.Runnable
            public final void run() {
                zzps.this.zzb(zzpjVar, zzleVar, str);
            }
        });
    }

    public final void zzf(final zzpj zzpjVar, final RemoteModel remoteModel, final zzpw zzpwVar) {
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_translate.zzpq
            @Override // java.lang.Runnable
            public final void run() {
                zzps.this.zzc(zzpjVar, zzpwVar, remoteModel);
            }
        });
    }
}
