package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.io.File;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public abstract class LegacyModelMigrator {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    protected final ModelFileHelper f32993a;

    /* renamed from: c  reason: collision with root package name */
    private final Context f32995c;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f32994b = new TaskCompletionSource();

    /* renamed from: d  reason: collision with root package name */
    private final Executor f32996d = MLTaskExecutor.workerThreadExecutor();

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public LegacyModelMigrator(@NonNull Context context, @NonNull ModelFileHelper modelFileHelper) {
        this.f32995c = context;
        this.f32993a = modelFileHelper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public static void a(@NonNull File file) {
        File[] listFiles = file.listFiles();
        if ((listFiles == null || listFiles.length == 0) && !file.delete()) {
            Log.e("MlKitLegacyMigration", "Error deleting model directory ".concat(String.valueOf(file)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @KeepForSdk
    public static boolean c(@NonNull String str) {
        String[] split = str.split("\\+", -1);
        if (split.length != 2) {
            return false;
        }
        try {
            Base64Utils.decodeUrlSafeNoPadding(split[0]);
            Base64Utils.decodeUrlSafeNoPadding(split[1]);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public static void migrateFile(@NonNull File file, @NonNull File file2) {
        if (!file.exists()) {
            return;
        }
        if (!file2.exists() && !file.renameTo(file2)) {
            String valueOf = String.valueOf(file);
            String valueOf2 = String.valueOf(file2);
            Log.e("MlKitLegacyMigration", "Error moving model file " + valueOf + " to " + valueOf2);
        }
        if (file.exists() && !file.delete()) {
            Log.e("MlKitLegacyMigration", "Error deleting model file ".concat(String.valueOf(file)));
        }
    }

    @NonNull
    @VisibleForTesting
    @KeepForSdk
    protected abstract String b();

    @KeepForSdk
    protected abstract void d(@NonNull File file);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e() {
        File legacyRootDir = getLegacyRootDir();
        File[] listFiles = legacyRootDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                d(file);
            }
            a(legacyRootDir);
        }
        this.f32994b.setResult(null);
    }

    @NonNull
    @VisibleForTesting
    @KeepForSdk
    public File getLegacyRootDir() {
        return new File(this.f32995c.getNoBackupFilesDir(), b());
    }

    @NonNull
    @KeepForSdk
    public Task<Void> getMigrationTask() {
        return this.f32994b.getTask();
    }

    @KeepForSdk
    public void start() {
        this.f32996d.execute(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.model.zza
            @Override // java.lang.Runnable
            public final void run() {
                LegacyModelMigrator.this.e();
            }
        });
    }
}
