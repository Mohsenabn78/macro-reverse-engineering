package com.google.mlkit.common.sdkinternal.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class RemoteModelFileManager {

    /* renamed from: h  reason: collision with root package name */
    private static final GmsLogger f33024h = new GmsLogger("RemoteModelFileManager", "");

    /* renamed from: a  reason: collision with root package name */
    private final MlKitContext f33025a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33026b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelType f33027c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final ModelValidator f33028d;

    /* renamed from: e  reason: collision with root package name */
    private final RemoteModelFileMover f33029e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPrefManager f33030f;

    /* renamed from: g  reason: collision with root package name */
    private final ModelFileHelper f33031g;

    @SuppressLint({"FirebaseLambdaLast"})
    public RemoteModelFileManager(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @Nullable ModelValidator modelValidator, @NonNull ModelFileHelper modelFileHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        String uniqueModelNameForPersist;
        this.f33025a = mlKitContext;
        ModelType modelType = remoteModel.getModelType();
        this.f33027c = modelType;
        if (modelType == ModelType.TRANSLATE) {
            uniqueModelNameForPersist = remoteModel.getModelNameForBackend();
        } else {
            uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
        }
        this.f33026b = uniqueModelNameForPersist;
        this.f33028d = modelValidator;
        this.f33030f = SharedPrefManager.getInstance(mlKitContext);
        this.f33031g = modelFileHelper;
        this.f33029e = remoteModelFileMover;
    }

    @NonNull
    @KeepForSdk
    public File getModelDirUnsafe(boolean z3) {
        return this.f33031g.getModelDirUnsafe(this.f33026b, this.f33027c, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0098, code lost:
        com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager.f33024h.d("RemoteModelFileManager", "Hash does not match with expected: ".concat(java.lang.String.valueOf(r11)));
        com.google.android.gms.internal.mlkit_common.zznb.zzb("common").zzf(com.google.android.gms.internal.mlkit_common.zzmt.zzg(), r12, com.google.android.gms.internal.mlkit_common.zziy.MODEL_HASH_MISMATCH, true, r9.f33027c, com.google.android.gms.internal.mlkit_common.zzje.SUCCEEDED);
        r10 = new com.google.mlkit.common.MlKitException("Hash does not match with expected", 102);
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.io.File moveModelToPrivateFolder(@androidx.annotation.NonNull android.os.ParcelFileDescriptor r10, @androidx.annotation.NonNull java.lang.String r11, @androidx.annotation.NonNull com.google.mlkit.common.model.RemoteModel r12) throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager.moveModelToPrivateFolder(android.os.ParcelFileDescriptor, java.lang.String, com.google.mlkit.common.model.RemoteModel):java.io.File");
    }

    @NonNull
    @WorkerThread
    public final synchronized File zza(@NonNull File file) throws MlKitException {
        File file2 = new File(String.valueOf(this.f33031g.getModelDir(this.f33026b, this.f33027c).getAbsolutePath()).concat("/0"));
        if (file2.exists()) {
            return file;
        }
        if (file.renameTo(file2)) {
            return file2;
        }
        return file;
    }

    @Nullable
    @WorkerThread
    public final synchronized String zzb() throws MlKitException {
        return this.f33031g.zzb(this.f33026b, this.f33027c);
    }

    @WorkerThread
    public final synchronized void zzc(@NonNull File file) {
        File modelDirUnsafe = getModelDirUnsafe(false);
        if (!modelDirUnsafe.exists()) {
            return;
        }
        File[] listFiles = modelDirUnsafe.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.equals(file)) {
                this.f33031g.deleteRecursively(file);
                return;
            }
        }
    }

    @WorkerThread
    public final synchronized boolean zzd(@NonNull File file) throws MlKitException {
        File modelDir = this.f33031g.getModelDir(this.f33026b, this.f33027c);
        if (!modelDir.exists()) {
            return false;
        }
        File[] listFiles = modelDir.listFiles();
        boolean z3 = true;
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.equals(file) && !this.f33031g.deleteRecursively(file2)) {
                z3 = false;
            }
        }
        return z3;
    }
}
