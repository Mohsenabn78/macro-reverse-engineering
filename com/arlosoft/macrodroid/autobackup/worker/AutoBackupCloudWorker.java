package com.arlosoft.macrodroid.autobackup.worker;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.arlosoft.macrodroid.firebase.FirestoreHelper;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: AutoBackupCloudWorker.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AutoBackupCloudWorker extends Worker {
    public static final long DELAY_BEFORE_UPLOADING_HOURS = 6;
    public static final long INITIAL_RETRY_TIME_MINUTES = 5;
    @NotNull
    public static final String UNIQUE_WORK_NAME = "cloud_backup";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f9426a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final WorkerParameters f9427b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AutoBackupCloudWorker.kt */
    @SourceDebugExtension({"SMAP\nAutoBackupCloudWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupCloudWorker.kt\ncom/arlosoft/macrodroid/autobackup/worker/AutoBackupCloudWorker$Companion\n+ 2 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequestKt\n*L\n1#1,60:1\n104#2:61\n*S KotlinDebug\n*F\n+ 1 AutoBackupCloudWorker.kt\ncom/arlosoft/macrodroid/autobackup/worker/AutoBackupCloudWorker$Companion\n*L\n36#1:61\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void scheduleNewBackup$default(Companion companion, Context context, long j4, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                j4 = 6;
            }
            companion.scheduleNewBackup(context, j4);
        }

        @JvmStatic
        public final void cancel(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager workManager = WorkManager.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
            workManager.cancelUniqueWork(AutoBackupCloudWorker.UNIQUE_WORK_NAME);
        }

        @JvmStatic
        public final void scheduleNewBackup(@NotNull Context context, long j4) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (Settings.getCloudBackupsEnabled(context) && Settings.getCloudBackupsId(context) != null) {
                Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                SystemLog.logDebug("==> Scheduling a new cloud backup for around 2 hours time");
                WorkManager workManager = WorkManager.getInstance(context);
                Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(context)");
                workManager.enqueueUniqueWork(AutoBackupCloudWorker.UNIQUE_WORK_NAME, ExistingWorkPolicy.REPLACE, new OneTimeWorkRequest.Builder(AutoBackupCloudWorker.class).setConstraints(build).setInitialDelay(j4, TimeUnit.HOURS).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5L, TimeUnit.MINUTES).build());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoBackupCloudWorker(@NotNull Context context, @NotNull WorkerParameters params) {
        super(context, params);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        this.f9426a = context;
        this.f9427b = params;
    }

    @JvmStatic
    public static final void cancel(@NotNull Context context) {
        Companion.cancel(context);
    }

    @JvmStatic
    public static final void scheduleNewBackup(@NotNull Context context, long j4) {
        Companion.scheduleNewBackup(context, j4);
    }

    @Override // androidx.work.Worker
    @NotNull
    public ListenableWorker.Result doWork() {
        new FirestoreHelper(this.f9426a).backupMacrosToCloud();
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "success()");
        return success;
    }
}
