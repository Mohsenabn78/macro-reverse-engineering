package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzmq;
import com.google.android.gms.internal.mlkit_common.zznb;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class RemoteModelLoader {

    /* renamed from: h  reason: collision with root package name */
    private static final GmsLogger f33032h = new GmsLogger("RemoteModelLoader", "");
    @GuardedBy("RemoteModelLoader.class")

    /* renamed from: i  reason: collision with root package name */
    private static final Map f33033i = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final MlKitContext f33034a;

    /* renamed from: b  reason: collision with root package name */
    private final RemoteModel f33035b;

    /* renamed from: c  reason: collision with root package name */
    private final RemoteModelDownloadManager f33036c;

    /* renamed from: d  reason: collision with root package name */
    private final RemoteModelFileManager f33037d;

    /* renamed from: e  reason: collision with root package name */
    private final RemoteModelLoaderHelper f33038e;

    /* renamed from: f  reason: collision with root package name */
    private final zzmq f33039f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f33040g;

    private RemoteModelLoader(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.f33037d = remoteModelFileManager;
        this.f33040g = true;
        this.f33036c = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.f33038e = remoteModelLoaderHelper;
        this.f33034a = mlKitContext;
        this.f33035b = remoteModel;
        this.f33039f = zznb.zzb("common");
    }

    @NonNull
    @WorkerThread
    private final MappedByteBuffer a(@NonNull String str) throws MlKitException {
        return this.f33038e.loadModelAtPath(str);
    }

    private final MappedByteBuffer b(File file) throws MlKitException {
        try {
            return a(file.getAbsolutePath());
        } catch (Exception e4) {
            this.f33037d.zzc(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e4);
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized RemoteModelLoader getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelLoader remoteModelLoader;
        synchronized (RemoteModelLoader.class) {
            String uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
            Map map = f33033i;
            if (!map.containsKey(uniqueModelNameForPersist)) {
                map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
            }
            remoteModelLoader = (RemoteModelLoader) map.get(uniqueModelNameForPersist);
        }
        return remoteModelLoader;
    }

    @NonNull
    @KeepForSdk
    public RemoteModel getRemoteModel() {
        return this.f33035b;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5 A[Catch: all -> 0x00f6, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:26:0x00b5, B:28:0x00c4, B:30:0x00cc, B:33:0x00d2, B:34:0x00f0, B:35:0x00f1, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x006d, B:19:0x0075, B:20:0x0087, B:22:0x008f, B:23:0x00a6), top: B:42:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f1 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:26:0x00b5, B:28:0x00c4, B:30:0x00cc, B:33:0x00d2, B:34:0x00f0, B:35:0x00f1, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x006d, B:19:0x0075, B:20:0x0087, B:22:0x008f, B:23:0x00a6), top: B:42:0x0001, inners: #1 }] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.nio.MappedByteBuffer load() throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.load():java.nio.MappedByteBuffer");
    }
}
