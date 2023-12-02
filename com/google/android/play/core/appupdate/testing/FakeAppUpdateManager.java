package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.zzc;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public class FakeAppUpdateManager implements AppUpdateManager {

    /* renamed from: a  reason: collision with root package name */
    private final zzc f25210a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f25211b;

    /* renamed from: c  reason: collision with root package name */
    private final List f25212c = new ArrayList();
    @InstallStatus

    /* renamed from: d  reason: collision with root package name */
    private int f25213d = 0;
    @InstallErrorCode

    /* renamed from: e  reason: collision with root package name */
    private int f25214e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25215f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f25216g = 0;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Integer f25217h = null;

    /* renamed from: i  reason: collision with root package name */
    private int f25218i = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f25219j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f25220k = 0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f25221l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f25222m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f25223n = false;
    @Nullable
    @AppUpdateType

    /* renamed from: o  reason: collision with root package name */
    private Integer f25224o;

    public FakeAppUpdateManager(Context context) {
        this.f25210a = new zzc(context);
        this.f25211b = context;
    }

    private static int a() {
        if (Build.VERSION.SDK_INT >= 23) {
            return 67108864;
        }
        return 0;
    }

    @UpdateAvailability
    private final int b() {
        if (this.f25215f) {
            int i4 = this.f25213d;
            if (i4 != 0 && i4 != 4 && i4 != 5 && i4 != 6) {
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private final void c() {
        this.f25210a.zzd(InstallState.zza(this.f25213d, this.f25219j, this.f25220k, this.f25214e, this.f25211b.getPackageName()));
    }

    private final boolean d(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.f25222m = true;
            this.f25224o = 1;
        } else {
            this.f25221l = true;
            this.f25224o = 0;
        }
        return true;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<Void> completeUpdate() {
        if (this.f25214e != 0) {
            return Tasks.forException(new InstallException(this.f25214e));
        }
        int i4 = this.f25213d;
        if (i4 == 11) {
            this.f25213d = 3;
            this.f25223n = true;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
            return Tasks.forResult(null);
        } else if (i4 == 3) {
            return Tasks.forException(new InstallException(-8));
        } else {
            return Tasks.forException(new InstallException(-7));
        }
    }

    public void downloadCompletes() {
        int i4 = this.f25213d;
        if (i4 == 2 || i4 == 1) {
            this.f25213d = 11;
            this.f25219j = 0L;
            this.f25220k = 0L;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.f25224o)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i4 = this.f25213d;
        if (i4 != 1 && i4 != 2) {
            return;
        }
        this.f25213d = 5;
        Integer num = 0;
        if (num.equals(this.f25224o)) {
            c();
        }
        this.f25224o = null;
        this.f25222m = false;
        this.f25213d = 0;
    }

    public void downloadStarts() {
        if (this.f25213d == 1) {
            this.f25213d = 2;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        PendingIntent pendingIntent4;
        PendingIntent pendingIntent5;
        PendingIntent pendingIntent6;
        if (this.f25214e != 0) {
            return Tasks.forException(new InstallException(this.f25214e));
        }
        if (b() == 2) {
            if (this.f25212c.contains(0)) {
                pendingIntent5 = PendingIntent.getBroadcast(this.f25211b, 0, new Intent(), a());
                pendingIntent6 = PendingIntent.getBroadcast(this.f25211b, 0, new Intent(), a());
            } else {
                pendingIntent5 = null;
                pendingIntent6 = null;
            }
            if (this.f25212c.contains(1)) {
                PendingIntent broadcast = PendingIntent.getBroadcast(this.f25211b, 0, new Intent(), a());
                pendingIntent2 = pendingIntent5;
                pendingIntent3 = PendingIntent.getBroadcast(this.f25211b, 0, new Intent(), a());
                pendingIntent = broadcast;
            } else {
                pendingIntent2 = pendingIntent5;
                pendingIntent = null;
                pendingIntent3 = null;
            }
            pendingIntent4 = pendingIntent6;
        } else {
            pendingIntent = null;
            pendingIntent2 = null;
            pendingIntent3 = null;
            pendingIntent4 = null;
        }
        return Tasks.forResult(AppUpdateInfo.zzb(this.f25211b.getPackageName(), this.f25216g, b(), this.f25213d, this.f25217h, this.f25218i, this.f25219j, this.f25220k, 0L, 0L, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, new HashMap()));
    }

    @Nullable
    @AppUpdateType
    public Integer getTypeForUpdateInProgress() {
        return this.f25224o;
    }

    public void installCompletes() {
        if (this.f25213d == 3) {
            this.f25213d = 4;
            this.f25215f = false;
            this.f25216g = 0;
            this.f25217h = null;
            this.f25218i = 0;
            this.f25219j = 0L;
            this.f25220k = 0L;
            this.f25222m = false;
            this.f25223n = false;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
            this.f25224o = null;
            this.f25213d = 0;
        }
    }

    public void installFails() {
        if (this.f25213d == 3) {
            this.f25213d = 5;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
            this.f25224o = null;
            this.f25223n = false;
            this.f25222m = false;
            this.f25213d = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.f25221l;
    }

    public boolean isImmediateFlowVisible() {
        return this.f25222m;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.f25223n;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f25210a.zzb(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j4) {
        if (this.f25213d == 2 && j4 <= this.f25220k) {
            this.f25219j = j4;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
        }
    }

    public void setClientVersionStalenessDays(@Nullable Integer num) {
        if (this.f25215f) {
            this.f25217h = num;
        }
    }

    public void setInstallErrorCode(@InstallErrorCode int i4) {
        this.f25214e = i4;
    }

    public void setTotalBytesToDownload(long j4) {
        if (this.f25213d == 2) {
            this.f25220k = j4;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
        }
    }

    public void setUpdateAvailable(int i4) {
        this.f25215f = true;
        this.f25212c.clear();
        this.f25212c.add(0);
        this.f25212c.add(1);
        this.f25216g = i4;
    }

    public void setUpdateNotAvailable() {
        this.f25215f = false;
        this.f25217h = null;
    }

    public void setUpdatePriority(int i4) {
        if (this.f25215f) {
            this.f25218i = i4;
        }
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        if (d(appUpdateInfo, appUpdateOptions)) {
            return Tasks.forResult(-1);
        }
        return Tasks.forException(new InstallException(-6));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i4, Activity activity, int i5) {
        return d(appUpdateInfo, AppUpdateOptions.newBuilder(i4).build());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f25210a.zzc(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.f25221l || this.f25222m) {
            this.f25221l = false;
            this.f25213d = 1;
            Integer num = 0;
            if (num.equals(this.f25224o)) {
                c();
            }
        }
    }

    public void userCancelsDownload() {
        int i4 = this.f25213d;
        if (i4 != 1 && i4 != 2) {
            return;
        }
        this.f25213d = 6;
        Integer num = 0;
        if (num.equals(this.f25224o)) {
            c();
        }
        this.f25224o = null;
        this.f25222m = false;
        this.f25213d = 0;
    }

    public void userRejectsUpdate() {
        if (!this.f25221l && !this.f25222m) {
            return;
        }
        this.f25221l = false;
        this.f25222m = false;
        this.f25224o = null;
        this.f25213d = 0;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, @AppUpdateType int i4, IntentSenderForResultStarter intentSenderForResultStarter, int i5) {
        return d(appUpdateInfo, AppUpdateOptions.newBuilder(i4).build());
    }

    public void setUpdateAvailable(int i4, @AppUpdateType int i5) {
        this.f25215f = true;
        this.f25212c.clear();
        this.f25212c.add(Integer.valueOf(i5));
        this.f25216g = i4;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i4) {
        return d(appUpdateInfo, appUpdateOptions);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i4) {
        return d(appUpdateInfo, appUpdateOptions);
    }
}
