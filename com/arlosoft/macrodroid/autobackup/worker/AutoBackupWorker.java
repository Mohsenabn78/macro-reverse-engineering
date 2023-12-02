package com.arlosoft.macrodroid.autobackup.worker;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.arlosoft.macrodroid.autobackup.model.AutoBackupConstantsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AutoBackupWorker.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AutoBackupWorker extends Worker {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f9428a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final WorkerParameters f9429b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AutoBackupWorker.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(File file) {
            try {
                File[] listFiles = file.listFiles();
                Intrinsics.checkNotNullExpressionValue(listFiles, "backupDir.listFiles()");
                for (File file2 : listFiles) {
                    if (TimeUnit.DAYS.convert(new Date().getTime() - file2.lastModified(), TimeUnit.MILLISECONDS) > 14) {
                        file2.delete();
                    }
                }
            } catch (Exception e4) {
                SystemLog.logError("Failed to clean up old backup files: " + e4);
            }
        }

        private final boolean b(String str) {
            boolean z3;
            boolean z4;
            try {
                ListenableFuture<List<WorkInfo>> workInfosByTag = WorkManager.getInstance().getWorkInfosByTag(str);
                Intrinsics.checkNotNullExpressionValue(workInfosByTag, "getInstance().getWorkInfosByTag(tag)");
                try {
                    boolean z5 = false;
                    for (WorkInfo workInfo : workInfosByTag.get()) {
                        WorkInfo.State state = workInfo.getState();
                        Intrinsics.checkNotNullExpressionValue(state, "workInfo.state");
                        if (state == WorkInfo.State.RUNNING) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (state == WorkInfo.State.ENQUEUED) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z5 = z4 | z3;
                    }
                    return z5;
                } catch (Exception unused) {
                    return false;
                }
            } catch (Exception unused2) {
                return true;
            }
        }

        public final void cancelPeriodicBackups() {
            WorkManager.getInstance().cancelAllWorkByTag(AutoBackupConstantsKt.AUTO_BACKUP_WORKER_TAG);
        }

        public final void doBackup(@NotNull Context context) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            File file = new File(context.getFilesDir().getAbsolutePath(), AutoBackupConstantsKt.AUTO_BACKUP_DIR);
            String str2 = null;
            File file2 = new File(context.getExternalFilesDir(null), AutoBackupConstantsKt.AUTO_BACKUP_DIR);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("[yyyy_MM_dd_HH_mm]");
            boolean autoBackupEncryptionEnabled = Settings.getAutoBackupEncryptionEnabled(context);
            if (autoBackupEncryptionEnabled) {
                str2 = Settings.getAutoBackupEncryptionPassword(context);
            }
            String str3 = str2;
            if (autoBackupEncryptionEnabled) {
                str = ".emdr";
            } else {
                str = ".mdr";
            }
            String str4 = file2.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + simpleDateFormat.format(new Date()) + str;
            if (!MacroStore.isInstanceAvailable()) {
                Thread.sleep(10000L);
            }
            if (MacroStore.getInstance(context.getApplicationContext()).getAllCompletedMacros().size() > 0 && !new File(str4).exists()) {
                try {
                    SystemLog.logVerbose("Saving local auto backup file");
                    if (MacroStore.getInstance(context.getApplicationContext()).writeToJSON(str4, true, true, false, str3)) {
                        if (file.exists() && file.isDirectory()) {
                            a(file);
                        }
                        if (file2.exists() && file2.isDirectory()) {
                            a(file2);
                        }
                    }
                } catch (Exception e4) {
                    SystemLog.logError("Autobackup failed: " + e4);
                    FirebaseCrashlytics.getInstance().recordException(e4);
                }
            }
        }

        public final void enablePeriodicBackups() {
            if (!b(AutoBackupConstantsKt.AUTO_BACKUP_WORKER_TAG)) {
                WorkManager.getInstance().enqueueUniquePeriodicWork(AutoBackupConstantsKt.AUTO_BACKUP_WORKER_TAG, ExistingPeriodicWorkPolicy.KEEP, new PeriodicWorkRequest.Builder(AutoBackupWorker.class, 24L, TimeUnit.HOURS).addTag(AutoBackupConstantsKt.AUTO_BACKUP_WORKER_TAG).build());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoBackupWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f9428a = context;
        this.f9429b = params;
    }

    @Override // androidx.work.Worker
    @NotNull
    public ListenableWorker.Result doWork() {
        Companion.doBackup(this.f9428a);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }
}
