package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public class AppUpdateInfo {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f25152a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25153b;
    @UpdateAvailability

    /* renamed from: c  reason: collision with root package name */
    private final int f25154c;
    @InstallStatus

    /* renamed from: d  reason: collision with root package name */
    private final int f25155d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Integer f25156e;

    /* renamed from: f  reason: collision with root package name */
    private final int f25157f;

    /* renamed from: g  reason: collision with root package name */
    private final long f25158g;

    /* renamed from: h  reason: collision with root package name */
    private final long f25159h;

    /* renamed from: i  reason: collision with root package name */
    private final long f25160i;

    /* renamed from: j  reason: collision with root package name */
    private final long f25161j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final PendingIntent f25162k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final PendingIntent f25163l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final PendingIntent f25164m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final PendingIntent f25165n;

    /* renamed from: o  reason: collision with root package name */
    private final Map f25166o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f25167p = false;

    private AppUpdateInfo(@NonNull String str, int i4, @UpdateAvailability int i5, @InstallStatus int i6, @Nullable Integer num, int i7, long j4, long j5, long j6, long j7, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4, Map map) {
        this.f25152a = str;
        this.f25153b = i4;
        this.f25154c = i5;
        this.f25155d = i6;
        this.f25156e = num;
        this.f25157f = i7;
        this.f25158g = j4;
        this.f25159h = j5;
        this.f25160i = j6;
        this.f25161j = j7;
        this.f25162k = pendingIntent;
        this.f25163l = pendingIntent2;
        this.f25164m = pendingIntent3;
        this.f25165n = pendingIntent4;
        this.f25166o = map;
    }

    private static Set d(@Nullable Set set) {
        if (set == null) {
            return new HashSet();
        }
        return set;
    }

    private final boolean e(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.allowAssetPackDeletion() && this.f25160i <= this.f25161j) {
            return true;
        }
        return false;
    }

    public static AppUpdateInfo zzb(@NonNull String str, int i4, @UpdateAvailability int i5, @InstallStatus int i6, @Nullable Integer num, int i7, long j4, long j5, long j6, long j7, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4, Map map) {
        return new AppUpdateInfo(str, i4, i5, i6, num, i7, j4, j5, j6, j7, pendingIntent, pendingIntent2, pendingIntent3, pendingIntent4, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final PendingIntent a(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.appUpdateType() == 0) {
            PendingIntent pendingIntent = this.f25163l;
            if (pendingIntent != null) {
                return pendingIntent;
            }
            if (!e(appUpdateOptions)) {
                return null;
            }
            return this.f25165n;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            PendingIntent pendingIntent2 = this.f25162k;
            if (pendingIntent2 != null) {
                return pendingIntent2;
            }
            if (e(appUpdateOptions)) {
                return this.f25164m;
            }
        }
        return null;
    }

    public int availableVersionCode() {
        return this.f25153b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f25167p = true;
    }

    public long bytesDownloaded() {
        return this.f25158g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.f25167p;
    }

    @Nullable
    public Integer clientVersionStalenessDays() {
        return this.f25156e;
    }

    public Set<Integer> getFailedUpdatePreconditions(AppUpdateOptions appUpdateOptions) {
        if (appUpdateOptions.allowAssetPackDeletion()) {
            if (appUpdateOptions.appUpdateType() == 0) {
                return d((Set) this.f25166o.get("nonblocking.destructive.intent"));
            }
            return d((Set) this.f25166o.get("blocking.destructive.intent"));
        } else if (appUpdateOptions.appUpdateType() == 0) {
            return d((Set) this.f25166o.get("nonblocking.intent"));
        } else {
            return d((Set) this.f25166o.get("blocking.intent"));
        }
    }

    @InstallStatus
    public int installStatus() {
        return this.f25155d;
    }

    public boolean isUpdateTypeAllowed(@AppUpdateType int i4) {
        return a(AppUpdateOptions.defaultOptions(i4)) != null;
    }

    @NonNull
    public String packageName() {
        return this.f25152a;
    }

    public long totalBytesToDownload() {
        return this.f25159h;
    }

    @UpdateAvailability
    public int updateAvailability() {
        return this.f25154c;
    }

    public int updatePriority() {
        return this.f25157f;
    }

    public boolean isUpdateTypeAllowed(@NonNull AppUpdateOptions appUpdateOptions) {
        return a(appUpdateOptions) != null;
    }
}
