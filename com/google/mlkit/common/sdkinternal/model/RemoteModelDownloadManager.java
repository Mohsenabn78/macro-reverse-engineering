package com.google.mlkit.common.sdkinternal.model;

import android.app.DownloadManager;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.LongSparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zziy;
import com.google.android.gms.internal.mlkit_common.zzje;
import com.google.android.gms.internal.mlkit_common.zzmh;
import com.google.android.gms.internal.mlkit_common.zzmq;
import com.google.android.gms.internal.mlkit_common.zzmt;
import com.google.android.gms.internal.mlkit_common.zznb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelInfo;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class RemoteModelDownloadManager {

    /* renamed from: m  reason: collision with root package name */
    private static final GmsLogger f33010m = new GmsLogger("ModelDownloadManager", "");
    @GuardedBy("RemoteModelDownloadManager.class")

    /* renamed from: n  reason: collision with root package name */
    private static final Map f33011n = new HashMap();
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final LongSparseArray f33012a = new LongSparseArray();
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private final LongSparseArray f33013b = new LongSparseArray();

    /* renamed from: c  reason: collision with root package name */
    private final MlKitContext f33014c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final DownloadManager f33015d;

    /* renamed from: e  reason: collision with root package name */
    private final RemoteModel f33016e;

    /* renamed from: f  reason: collision with root package name */
    private final ModelType f33017f;

    /* renamed from: g  reason: collision with root package name */
    private final zzmq f33018g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedPrefManager f33019h;

    /* renamed from: i  reason: collision with root package name */
    private final ModelFileHelper f33020i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final ModelInfoRetrieverInterop f33021j;

    /* renamed from: k  reason: collision with root package name */
    private final RemoteModelFileManager f33022k;

    /* renamed from: l  reason: collision with root package name */
    private DownloadConditions f33023l;

    @VisibleForTesting
    RemoteModelDownloadManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop, @NonNull zzmq zzmqVar) {
        this.f33014c = mlKitContext;
        this.f33017f = remoteModel.getModelType();
        this.f33016e = remoteModel;
        DownloadManager downloadManager = (DownloadManager) mlKitContext.getApplicationContext().getSystemService("download");
        this.f33015d = downloadManager;
        this.f33018g = zzmqVar;
        if (downloadManager == null) {
            f33010m.d("ModelDownloadManager", "Download manager service is not available in the service.");
        }
        this.f33020i = modelFileHelper;
        this.f33019h = SharedPrefManager.getInstance(mlKitContext);
        this.f33021j = modelInfoRetrieverInterop;
        this.f33022k = remoteModelFileManager;
    }

    @NonNull
    @KeepForSdk
    public static synchronized RemoteModelDownloadManager getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileManager remoteModelFileManager, @Nullable ModelInfoRetrieverInterop modelInfoRetrieverInterop) {
        RemoteModelDownloadManager remoteModelDownloadManager;
        synchronized (RemoteModelDownloadManager.class) {
            Map map = f33011n;
            if (!map.containsKey(remoteModel)) {
                map.put(remoteModel, new RemoteModelDownloadManager(mlKitContext, remoteModel, modelFileHelper, remoteModelFileManager, modelInfoRetrieverInterop, zznb.zzb("common")));
            }
            remoteModelDownloadManager = (RemoteModelDownloadManager) map.get(remoteModel);
        }
        return remoteModelDownloadManager;
    }

    private final Task i(long j4) {
        this.f33014c.getApplicationContext().registerReceiver(l(j4), new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), null, MLTaskExecutor.getInstance().getHandler());
        return j(j4).getTask();
    }

    private final synchronized TaskCompletionSource j(long j4) {
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f33013b.get(j4);
        if (taskCompletionSource == null) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.f33013b.put(j4, taskCompletionSource2);
            return taskCompletionSource2;
        }
        return taskCompletionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MlKitException k(@Nullable Long l4) {
        DownloadManager downloadManager = this.f33015d;
        Cursor cursor = null;
        if (downloadManager != null && l4 != null) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l4.longValue()));
        }
        int i4 = 13;
        String str = "Model downloading failed";
        if (cursor != null && cursor.moveToFirst()) {
            int i5 = cursor.getInt(cursor.getColumnIndex("reason"));
            if (i5 == 1006) {
                str = "Model downloading failed due to insufficient space on the device.";
                i4 = 101;
            } else {
                str = "Model downloading failed due to error code: " + i5 + " from Android DownloadManager";
            }
        }
        return new MlKitException(str, i4);
    }

    private final synchronized zzd l(long j4) {
        zzd zzdVar = (zzd) this.f33012a.get(j4);
        if (zzdVar == null) {
            zzd zzdVar2 = new zzd(this, j4, j(j4), null);
            this.f33012a.put(j4, zzdVar2);
            return zzdVar2;
        }
        return zzdVar;
    }

    @Nullable
    private final synchronized Long m(@NonNull DownloadManager.Request request, @NonNull ModelInfo modelInfo) {
        DownloadManager downloadManager = this.f33015d;
        if (downloadManager == null) {
            return null;
        }
        long enqueue = downloadManager.enqueue(request);
        GmsLogger gmsLogger = f33010m;
        gmsLogger.d("ModelDownloadManager", "Schedule a new downloading task: " + enqueue);
        this.f33019h.setDownloadingModelInfo(enqueue, modelInfo);
        this.f33018g.zzf(zzmt.zzg(), this.f33016e, zziy.NO_ERROR, false, modelInfo.getModelType(), zzje.SCHEDULED);
        return Long.valueOf(enqueue);
    }

    @Nullable
    @WorkerThread
    private final synchronized Long n(@NonNull ModelInfo modelInfo, @NonNull DownloadConditions downloadConditions) throws MlKitException {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        String downloadingModelHash = this.f33019h.getDownloadingModelHash(this.f33016e);
        Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
        if (downloadingModelHash != null && downloadingModelHash.equals(modelInfo.getModelHash()) && downloadingModelStatusCode != null) {
            Integer downloadingModelStatusCode2 = getDownloadingModelStatusCode();
            if (downloadingModelStatusCode2 == null || (downloadingModelStatusCode2.intValue() != 8 && downloadingModelStatusCode2.intValue() != 16)) {
                zzmq zzmqVar = this.f33018g;
                zzmh zzg = zzmt.zzg();
                RemoteModel remoteModel = this.f33016e;
                zzmqVar.zzf(zzg, remoteModel, zziy.NO_ERROR, false, remoteModel.getModelType(), zzje.DOWNLOADING);
            }
            f33010m.d("ModelDownloadManager", "New model is already in downloading, do nothing.");
            return null;
        }
        GmsLogger gmsLogger = f33010m;
        gmsLogger.d("ModelDownloadManager", "Need to download a new model.");
        removeOrCancelDownload();
        DownloadManager.Request request = new DownloadManager.Request(modelInfo.getModelUri());
        if (this.f33020i.modelExistsLocally(modelInfo.getModelNameForPersist(), modelInfo.getModelType())) {
            gmsLogger.d("ModelDownloadManager", "Model update is enabled and have a previous downloaded model, use download condition");
            this.f33018g.zzf(zzmt.zzg(), this.f33016e, zziy.NO_ERROR, false, modelInfo.getModelType(), zzje.UPDATE_AVAILABLE);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            request.setRequiresCharging(downloadConditions.isChargingRequired());
        }
        if (downloadConditions.isWifiRequired()) {
            request.setAllowedNetworkTypes(2);
        }
        return m(request, modelInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
        r1 = n(r1, r13.f33023l);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b2, code lost:
        if (r1 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
        return i(r1.longValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
        com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.f33010m.i("ModelDownloadManager", "Didn't schedule download for the updated model");
     */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.tasks.Task<java.lang.Void> ensureModelDownloaded() {
        /*
            r13 = this;
            com.google.android.gms.internal.mlkit_common.zzmq r0 = r13.f33018g
            com.google.android.gms.internal.mlkit_common.zzmh r1 = com.google.android.gms.internal.mlkit_common.zzmt.zzg()
            com.google.mlkit.common.model.RemoteModel r2 = r13.f33016e
            com.google.android.gms.internal.mlkit_common.zziy r3 = com.google.android.gms.internal.mlkit_common.zziy.NO_ERROR
            r4 = 0
            com.google.mlkit.common.sdkinternal.ModelType r5 = com.google.mlkit.common.sdkinternal.ModelType.UNKNOWN
            com.google.android.gms.internal.mlkit_common.zzje r6 = com.google.android.gms.internal.mlkit_common.zzje.EXPLICITLY_REQUESTED
            r0.zzf(r1, r2, r3, r4, r5, r6)
            r0 = 0
            com.google.mlkit.common.sdkinternal.ModelInfo r1 = r13.g()     // Catch: com.google.mlkit.common.MlKitException -> L19
            r2 = r0
            goto L1c
        L19:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L1c:
            r3 = 13
            java.lang.Integer r4 = r13.getDownloadingModelStatusCode()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.Long r5 = r13.getDownloadingId()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            boolean r6 = r13.modelExistsLocally()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            if (r6 != 0) goto Laa
            if (r4 == 0) goto L38
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 8
            if (r6 != r7) goto L38
            goto Laa
        L38:
            if (r4 == 0) goto L4e
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 16
            if (r6 != r7) goto L4e
            com.google.mlkit.common.MlKitException r0 = r13.k(r5)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r13.removeOrCancelDownload()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        L4e:
            if (r4 == 0) goto L8a
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 4
            if (r6 == r7) goto L65
            int r6 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r7 = 2
            if (r6 == r7) goto L65
            int r4 = r4.intValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r6 = 1
            if (r4 != r6) goto L8a
        L65:
            if (r5 == 0) goto L8a
            java.lang.String r4 = r13.getDownloadingModelHash()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            if (r4 == 0) goto L8a
            com.google.android.gms.internal.mlkit_common.zzmq r6 = r13.f33018g     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.internal.mlkit_common.zzmh r7 = com.google.android.gms.internal.mlkit_common.zzmt.zzg()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.mlkit.common.model.RemoteModel r8 = r13.f33016e     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.internal.mlkit_common.zziy r9 = com.google.android.gms.internal.mlkit_common.zziy.NO_ERROR     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r10 = 0
            com.google.mlkit.common.sdkinternal.ModelType r11 = r8.getModelType()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.internal.mlkit_common.zzje r12 = com.google.android.gms.internal.mlkit_common.zzje.DOWNLOADING     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            r6.zzf(r7, r8, r9, r10, r11, r12)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            long r0 = r5.longValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = r13.i(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        L8a:
            if (r1 != 0) goto L8d
            goto L93
        L8d:
            com.google.mlkit.common.model.DownloadConditions r0 = r13.f33023l     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.Long r0 = r13.n(r1, r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
        L93:
            if (r0 != 0) goto La1
            com.google.mlkit.common.MlKitException r0 = new com.google.mlkit.common.MlKitException     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.String r1 = "Failed to schedule the download task"
            r0.<init>(r1, r3, r2)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        La1:
            long r0 = r0.longValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = r13.i(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        Laa:
            if (r1 == 0) goto Lc6
            com.google.mlkit.common.model.DownloadConditions r2 = r13.f33023l     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.Long r1 = r13.n(r1, r2)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            if (r1 == 0) goto Lbd
            long r0 = r1.longValue()     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            com.google.android.gms.tasks.Task r0 = r13.i(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        Lbd:
            com.google.android.gms.common.internal.GmsLogger r1 = com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.f33010m     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            java.lang.String r2 = "ModelDownloadManager"
            java.lang.String r4 = "Didn't schedule download for the updated model"
            r1.i(r2, r4)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
        Lc6:
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forResult(r0)     // Catch: com.google.mlkit.common.MlKitException -> Lcb
            return r0
        Lcb:
            r0 = move-exception
            com.google.mlkit.common.MlKitException r1 = new com.google.mlkit.common.MlKitException
            java.lang.String r2 = "Failed to ensure the model is downloaded."
            r1.<init>(r2, r3, r0)
            com.google.android.gms.tasks.Task r0 = com.google.android.gms.tasks.Tasks.forException(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager.ensureModelDownloaded():com.google.android.gms.tasks.Task");
    }

    @Nullable
    @WorkerThread
    final synchronized ModelInfo g() throws MlKitException {
        boolean z3;
        boolean modelExistsLocally = modelExistsLocally();
        if (modelExistsLocally) {
            zzmq zzmqVar = this.f33018g;
            zzmh zzg = zzmt.zzg();
            RemoteModel remoteModel = this.f33016e;
            zzmqVar.zzf(zzg, remoteModel, zziy.NO_ERROR, false, remoteModel.getModelType(), zzje.LIVE);
        }
        ModelInfoRetrieverInterop modelInfoRetrieverInterop = this.f33021j;
        if (modelInfoRetrieverInterop != null) {
            ModelInfo retrieveRemoteModelInfo = modelInfoRetrieverInterop.retrieveRemoteModelInfo(this.f33016e);
            if (retrieveRemoteModelInfo == null) {
                return null;
            }
            MlKitContext mlKitContext = this.f33014c;
            RemoteModel remoteModel2 = this.f33016e;
            String modelHash = retrieveRemoteModelInfo.getModelHash();
            SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(mlKitContext);
            boolean equals = modelHash.equals(sharedPrefManager.getIncompatibleModelHash(remoteModel2));
            boolean z4 = false;
            if (equals && CommonUtils.getAppVersion(mlKitContext.getApplicationContext()).equals(sharedPrefManager.getPreviousAppVersion())) {
                f33010m.e("ModelDownloadManager", "The model is incompatible with TFLite and the app is not upgraded, do not download");
                z3 = false;
            } else {
                z3 = true;
            }
            if (!modelExistsLocally) {
                this.f33019h.clearLatestModelHash(this.f33016e);
            }
            boolean z5 = !retrieveRemoteModelInfo.getModelHash().equals(SharedPrefManager.getInstance(this.f33014c).getLatestModelHash(this.f33016e));
            if (z3) {
                if (!modelExistsLocally || z5) {
                    return retrieveRemoteModelInfo;
                }
            } else {
                z4 = z5;
            }
            if (modelExistsLocally && (z4 ^ z3)) {
                return null;
            }
            throw new MlKitException("The model " + this.f33016e.getModelName() + " is incompatible with TFLite runtime", 100);
        }
        throw new MlKitException("Please include com.google.mlkit:linkfirebase sdk as your dependency when you try to download from Firebase.", 14);
    }

    @Nullable
    @KeepForSdk
    public synchronized ParcelFileDescriptor getDownloadedFile() {
        Long downloadingId = getDownloadingId();
        DownloadManager downloadManager = this.f33015d;
        ParcelFileDescriptor parcelFileDescriptor = null;
        if (downloadManager == null || downloadingId == null) {
            return null;
        }
        try {
            parcelFileDescriptor = downloadManager.openDownloadedFile(downloadingId.longValue());
        } catch (FileNotFoundException unused) {
            f33010m.e("ModelDownloadManager", "Downloaded file is not found");
        }
        return parcelFileDescriptor;
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingId() {
        return this.f33019h.getDownloadingModelId(this.f33016e);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash() {
        return this.f33019h.getDownloadingModelHash(this.f33016e);
    }

    @Nullable
    @KeepForSdk
    public synchronized Integer getDownloadingModelStatusCode() {
        Integer num;
        Long downloadingId = getDownloadingId();
        DownloadManager downloadManager = this.f33015d;
        Integer num2 = null;
        if (downloadManager != null && downloadingId != null) {
            Cursor query = downloadManager.query(new DownloadManager.Query().setFilterById(downloadingId.longValue()));
            if (query != null && query.moveToFirst()) {
                num = Integer.valueOf(query.getInt(query.getColumnIndex(NotificationCompat.CATEGORY_STATUS)));
            } else {
                num = null;
            }
            if (num == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            if (num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 1 || num.intValue() == 8 || num.intValue() == 16) {
                num2 = num;
            }
            query.close();
            return num2;
        }
        return null;
    }

    @KeepForSdk
    public int getFailureReason(@NonNull Long l4) {
        int columnIndex;
        DownloadManager downloadManager = this.f33015d;
        Cursor cursor = null;
        if (downloadManager != null && l4 != null) {
            cursor = downloadManager.query(new DownloadManager.Query().setFilterById(l4.longValue()));
        }
        if (cursor == null || !cursor.moveToFirst() || (columnIndex = cursor.getColumnIndex("reason")) == -1) {
            return 0;
        }
        return cursor.getInt(columnIndex);
    }

    @KeepForSdk
    @WorkerThread
    public boolean isModelDownloadedAndValid() throws MlKitException {
        try {
            if (modelExistsLocally()) {
                return true;
            }
        } catch (MlKitException unused) {
            f33010m.d("ModelDownloadManager", "Failed to check if the model exist locally.");
        }
        Long downloadingId = getDownloadingId();
        String downloadingModelHash = getDownloadingModelHash();
        if (downloadingId != null && downloadingModelHash != null) {
            Integer downloadingModelStatusCode = getDownloadingModelStatusCode();
            f33010m.d("ModelDownloadManager", "Download Status code: ".concat(String.valueOf(downloadingModelStatusCode)));
            if (downloadingModelStatusCode == null) {
                removeOrCancelDownload();
                return false;
            } else if (Objects.equal(downloadingModelStatusCode, 8) && zzi(downloadingModelHash) != null) {
                return true;
            } else {
                return false;
            }
        }
        f33010m.d("ModelDownloadManager", "No new model is downloading.");
        removeOrCancelDownload();
        return false;
    }

    @KeepForSdk
    public boolean modelExistsLocally() throws MlKitException {
        return this.f33020i.modelExistsLocally(this.f33016e.getUniqueModelNameForPersist(), this.f33017f);
    }

    @KeepForSdk
    public synchronized void removeOrCancelDownload() throws MlKitException {
        Long downloadingId = getDownloadingId();
        if (this.f33015d != null && downloadingId != null) {
            f33010m.d("ModelDownloadManager", "Cancel or remove existing downloading task: ".concat(downloadingId.toString()));
            if (this.f33015d.remove(downloadingId.longValue()) <= 0 && getDownloadingModelStatusCode() != null) {
                return;
            }
            this.f33020i.deleteTempFilesInPrivateFolder(this.f33016e.getUniqueModelNameForPersist(), this.f33016e.getModelType());
            this.f33019h.clearDownloadingModelInfo(this.f33016e);
        }
    }

    @KeepForSdk
    public void setDownloadConditions(@NonNull DownloadConditions downloadConditions) {
        Preconditions.checkNotNull(downloadConditions, "DownloadConditions can not be null");
        this.f33023l = downloadConditions;
    }

    @KeepForSdk
    public synchronized void updateLatestModelHashAndType(@NonNull String str) throws MlKitException {
        this.f33019h.setLatestModelHash(this.f33016e, str);
        removeOrCancelDownload();
    }

    @Nullable
    public final File zzi(@NonNull String str) throws MlKitException {
        GmsLogger gmsLogger = f33010m;
        gmsLogger.d("ModelDownloadManager", "Model downloaded successfully");
        this.f33018g.zzf(zzmt.zzg(), this.f33016e, zziy.NO_ERROR, true, this.f33017f, zzje.SUCCEEDED);
        ParcelFileDescriptor downloadedFile = getDownloadedFile();
        if (downloadedFile == null) {
            removeOrCancelDownload();
            return null;
        }
        gmsLogger.d("ModelDownloadManager", "moving downloaded model from external storage to private folder.");
        try {
            return this.f33022k.moveModelToPrivateFolder(downloadedFile, str, this.f33016e);
        } finally {
            removeOrCancelDownload();
        }
    }
}
