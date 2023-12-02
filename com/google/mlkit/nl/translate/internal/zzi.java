package com.google.mlkit.nl.translate.internal;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager;
import com.google.mlkit.nl.translate.TranslateRemoteModel;
import java.io.File;
import java.util.List;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
@WorkerThread
/* loaded from: classes5.dex */
public final class zzi {

    /* renamed from: p  reason: collision with root package name */
    private static final GmsLogger f33111p = new GmsLogger("TranslateDLManager", "");

    /* renamed from: a  reason: collision with root package name */
    private final Context f33112a;

    /* renamed from: b  reason: collision with root package name */
    private final RemoteModelFileManager f33113b;

    /* renamed from: c  reason: collision with root package name */
    private final TranslateRemoteModel f33114c;

    /* renamed from: d  reason: collision with root package name */
    private final zzaf f33115d;

    /* renamed from: e  reason: collision with root package name */
    private final zzt f33116e;

    /* renamed from: f  reason: collision with root package name */
    private final zzu f33117f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final DownloadManager f33118g;

    /* renamed from: h  reason: collision with root package name */
    private final ModelFileHelper f33119h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedPrefManager f33120i;

    /* renamed from: j  reason: collision with root package name */
    private final zzc f33121j;

    /* renamed from: k  reason: collision with root package name */
    private final SharedPreferences f33122k;

    /* renamed from: l  reason: collision with root package name */
    private TaskCompletionSource f33123l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private List f33124m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private DownloadConditions f33125n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private BroadcastReceiver f33126o;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzi(Context context, RemoteModelFileManager remoteModelFileManager, TranslateRemoteModel translateRemoteModel, zzaf zzafVar, zzt zztVar, zzu zzuVar, @Nullable DownloadManager downloadManager, ModelFileHelper modelFileHelper, SharedPrefManager sharedPrefManager, zzc zzcVar) {
        this.f33112a = context;
        this.f33113b = remoteModelFileManager;
        this.f33114c = translateRemoteModel;
        this.f33115d = zzafVar;
        this.f33116e = zztVar;
        this.f33117f = zzuVar;
        if (downloadManager == null) {
            f33111p.d("TranslateDLManager", "Download manager service is not available in the service.");
        }
        this.f33118g = downloadManager;
        this.f33119h = modelFileHelper;
        this.f33121j = zzcVar;
        this.f33120i = sharedPrefManager;
        this.f33122k = context.getSharedPreferences("com.google.mlkit.translate.download_manager", 0);
        this.f33123l = new TaskCompletionSource();
    }

    private final int k() {
        List list = this.f33124m;
        if (list != null && !list.isEmpty()) {
            List list2 = (List) Preconditions.checkNotNull(this.f33124m);
            String string = this.f33122k.getString("last_uri_for_".concat(String.valueOf(((ModelInfo) list2.get(0)).getModelHash())), null);
            if (string != null) {
                int i4 = 0;
                while (i4 < list2.size()) {
                    boolean equals = string.equals(((ModelInfo) list2.get(i4)).getModelUri().toString());
                    i4++;
                    if (equals) {
                        return i4;
                    }
                }
                f33111p.e("TranslateDLManager", "Stored LAST_URI_ATTEMPTED was not found in ModelInfo");
            }
        }
        return 0;
    }

    private final Task l() {
        boolean z3;
        boolean z4 = false;
        if (this.f33125n != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        int k4 = k();
        List list = this.f33124m;
        if (list != null && k4 < list.size()) {
            ModelInfo modelInfo = (ModelInfo) this.f33124m.get(k4);
            try {
                if (this.f33125n != null) {
                    z4 = true;
                }
                Preconditions.checkState(z4);
                DownloadConditions downloadConditions = (DownloadConditions) Preconditions.checkNotNull(this.f33125n);
                String e4 = e();
                DownloadManager.Request request = null;
                if (e4 != null && e4.equals(modelInfo.getModelHash()) && c() != null) {
                    f33111p.d("TranslateDLManager", "New model is already in downloading, do nothing.");
                } else {
                    GmsLogger gmsLogger = f33111p;
                    gmsLogger.d("TranslateDLManager", "Need to download a new model.");
                    boolean i4 = i(this.f33114c, modelInfo.getModelHash());
                    h();
                    DownloadManager.Request request2 = new DownloadManager.Request(modelInfo.getModelUri());
                    if (j() && !i4) {
                        gmsLogger.d("TranslateDLManager", "Remote model hash is simliar to local model. Skipping download.");
                    } else {
                        if (Build.VERSION.SDK_INT >= 24) {
                            request2.setRequiresCharging(downloadConditions.isChargingRequired());
                        }
                        if (downloadConditions.isWifiRequired()) {
                            request2.setAllowedNetworkTypes(2);
                        }
                        request2.addRequestHeader("User-Agent", "TRANSLATE_OPM5_TEST_1");
                        request = request2;
                    }
                }
                if (request == null && d() == null) {
                    return Tasks.forResult(com.google.android.gms.internal.mlkit_translate.zzf.zzb());
                }
                if (request != null) {
                    Preconditions.checkHandlerThread(MLTaskExecutor.getInstance().getHandler());
                    DownloadManager downloadManager = this.f33118g;
                    if (downloadManager == null) {
                        this.f33116e.l();
                    } else {
                        long enqueue = downloadManager.enqueue(request);
                        GmsLogger gmsLogger2 = f33111p;
                        gmsLogger2.d("TranslateDLManager", "Schedule a new downloading task: " + enqueue);
                        this.f33120i.setDownloadingModelInfo(enqueue, modelInfo);
                        this.f33122k.edit().putString("last_uri_for_".concat(String.valueOf(modelInfo.getModelHash())), modelInfo.getModelUri().toString()).commit();
                    }
                }
                Integer c4 = c();
                if (c4 != null && (c4.intValue() == 4 || c4.intValue() == 1 || c4.intValue() == 2)) {
                    if (this.f33126o == null) {
                        zzg zzgVar = new zzg(this, this);
                        this.f33126o = zzgVar;
                        this.f33112a.registerReceiver(zzgVar, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                    }
                } else {
                    MLTaskExecutor.getInstance().getHandler().post(new Runnable() { // from class: com.google.mlkit.nl.translate.internal.zze
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzi.this.g();
                        }
                    });
                }
                return this.f33123l.getTask();
            } catch (MlKitException e5) {
                return Tasks.forException(e5);
            }
        }
        return Tasks.forResult(com.google.android.gms.internal.mlkit_translate.zzf.zzb());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Task a(DownloadConditions downloadConditions) {
        try {
            List zza = this.f33117f.zza(this.f33112a, this.f33114c);
            ModelInfo modelInfo = (ModelInfo) zza.get(0);
            boolean z3 = !j();
            if (z3) {
                this.f33120i.clearLatestModelHash(this.f33114c);
            }
            boolean i4 = i(this.f33114c, modelInfo.getModelHash());
            if (!z3 && !i4) {
                zza = null;
            }
            this.f33124m = zza;
            if (zza != null && !zza.isEmpty()) {
                this.f33123l = new TaskCompletionSource();
                this.f33125n = downloadConditions;
                return l();
            }
            f33111p.d("TranslateDLManager", "No model updates for model: ".concat(String.valueOf(zzad.zze(this.f33114c.getLanguage()))));
            return Tasks.forResult(com.google.android.gms.internal.mlkit_translate.zzf.zzb());
        } catch (MlKitException e4) {
            return Tasks.forException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x017c, code lost:
        throw new java.util.zip.ZipException("Illegal name: ".concat(java.lang.String.valueOf(r9)));
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009f A[Catch: all -> 0x025d, TryCatch #5 {all -> 0x025d, blocks: (B:16:0x006d, B:18:0x007c, B:26:0x009f, B:27:0x00a6, B:29:0x00b7, B:30:0x00be, B:31:0x00dd, B:34:0x0104, B:36:0x011e, B:61:0x017d, B:63:0x0186, B:65:0x0191, B:67:0x0194, B:69:0x019c, B:71:0x01a2, B:73:0x01a5, B:75:0x01b6, B:76:0x01b9, B:77:0x01c0, B:78:0x01c1, B:80:0x01c7, B:84:0x01f0, B:85:0x01f7, B:86:0x01f8, B:87:0x01ff, B:88:0x0200, B:89:0x0207, B:90:0x0208, B:91:0x020f, B:92:0x0210, B:93:0x0217, B:101:0x0223, B:100:0x0220, B:102:0x0224, B:103:0x0228, B:104:0x0249, B:106:0x024b, B:107:0x025c, B:19:0x0082, B:22:0x008a, B:24:0x0095), top: B:133:0x006d, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[Catch: all -> 0x025d, TryCatch #5 {all -> 0x025d, blocks: (B:16:0x006d, B:18:0x007c, B:26:0x009f, B:27:0x00a6, B:29:0x00b7, B:30:0x00be, B:31:0x00dd, B:34:0x0104, B:36:0x011e, B:61:0x017d, B:63:0x0186, B:65:0x0191, B:67:0x0194, B:69:0x019c, B:71:0x01a2, B:73:0x01a5, B:75:0x01b6, B:76:0x01b9, B:77:0x01c0, B:78:0x01c1, B:80:0x01c7, B:84:0x01f0, B:85:0x01f7, B:86:0x01f8, B:87:0x01ff, B:88:0x0200, B:89:0x0207, B:90:0x0208, B:91:0x020f, B:92:0x0210, B:93:0x0217, B:101:0x0223, B:100:0x0220, B:102:0x0224, B:103:0x0228, B:104:0x0249, B:106:0x024b, B:107:0x025c, B:19:0x0082, B:22:0x008a, B:24:0x0095), top: B:133:0x006d, inners: #1, #2 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.io.File b() throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.nl.translate.internal.zzi.b():java.io.File");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cf, code lost:
        if (r4.intValue() != 16) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x0044, TRY_ENTER, TryCatch #1 {all -> 0x0044, blocks: (B:11:0x002f, B:13:0x0035, B:22:0x0050, B:24:0x0058, B:28:0x0070, B:29:0x0076, B:30:0x0079, B:39:0x00ac, B:31:0x007c, B:32:0x0082, B:33:0x0088, B:34:0x008e, B:35:0x0094, B:36:0x009a, B:37:0x00a0, B:38:0x00a6, B:40:0x00af, B:42:0x00b6, B:44:0x00bd, B:46:0x00c3, B:48:0x00cb), top: B:62:0x002f }] */
    @androidx.annotation.Nullable
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.Integer c() {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.nl.translate.internal.zzi.c():java.lang.Integer");
    }

    @Nullable
    @VisibleForTesting
    final Long d() {
        return this.f33120i.getDownloadingModelId(this.f33114c);
    }

    @Nullable
    @VisibleForTesting
    final String e() {
        return this.f33120i.getDownloadingModelHash(this.f33114c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f() throws MlKitException {
        h();
        this.f33120i.clearLatestModelHash(this.f33114c);
        String zze = zzad.zze(this.f33114c.getLanguage());
        File modelDirUnsafe = this.f33113b.getModelDirUnsafe(false);
        String[] a4 = zzad.a(zze);
        zzaf.f(modelDirUnsafe, a4[0], a4[1]);
        zzaf.f(modelDirUnsafe, a4[1], a4[0]);
        com.google.android.gms.internal.mlkit_translate.zzs zzsVar = new com.google.android.gms.internal.mlkit_translate.zzs();
        com.google.android.gms.internal.mlkit_translate.zzv zza = zzad.zza(zze);
        int size = zza.size();
        for (int i4 = 0; i4 < size; i4++) {
            String str = (String) zza.get(i4);
            File file = new File(modelDirUnsafe, str);
            if (file.exists() && !file.delete()) {
                zzsVar.zzc(str);
            }
        }
        com.google.android.gms.internal.mlkit_translate.zzv zzd = zzsVar.zzd();
        if (zzd.isEmpty()) {
            this.f33123l.trySetException(new MlKitException("Download canceled", 1));
            return;
        }
        throw new MlKitException("Couldn't delete model files ".concat(String.valueOf(TextUtils.join(", ", zzd))), 13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void g() {
        List list;
        Integer c4 = c();
        if (c4 != null) {
            try {
                if (c4.intValue() == 16 && (list = this.f33124m) != null && list.size() > k()) {
                    this.f33120i.clearDownloadingModelInfo(this.f33114c);
                    l();
                    return;
                }
            } catch (MlKitException e4) {
                this.f33123l.setException(e4);
                return;
            }
        }
        b();
    }

    @SuppressLint({"ApplySharedPref"})
    @VisibleForTesting
    final void h() throws MlKitException {
        Preconditions.checkHandlerThread(MLTaskExecutor.getInstance().getHandler());
        if (this.f33118g == null) {
            this.f33116e.l();
            return;
        }
        Long d4 = d();
        if (d4 == null) {
            return;
        }
        f33111p.d("TranslateDLManager", "Cancel or remove existing downloading task: ".concat(d4.toString()));
        if (this.f33118g.remove(d4.longValue()) > 0 || c() == null) {
            this.f33119h.deleteTempFilesInPrivateFolder(TranslateRemoteModel.zza(zzad.zze(this.f33114c.getLanguage())), this.f33114c.getModelType());
            this.f33120i.clearDownloadingModelInfo(this.f33114c);
            List list = this.f33124m;
            if (list != null && !list.isEmpty()) {
                this.f33122k.edit().remove("last_uri_for_".concat(String.valueOf(((ModelInfo) this.f33124m.get(0)).getModelHash()))).commit();
            }
        }
    }

    @VisibleForTesting
    final boolean i(RemoteModel remoteModel, String str) {
        if (!str.equals(this.f33120i.getLatestModelHash(remoteModel))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j() {
        String zze = zzad.zze(this.f33114c.getLanguage());
        File modelDirUnsafe = this.f33113b.getModelDirUnsafe(false);
        com.google.android.gms.internal.mlkit_translate.zzv zza = zzad.zza(zze);
        int size = zza.size();
        int i4 = 0;
        while (i4 < size) {
            i4++;
            if (!new File(modelDirUnsafe, (String) zza.get(i4)).exists()) {
                return false;
            }
        }
        return true;
    }
}
