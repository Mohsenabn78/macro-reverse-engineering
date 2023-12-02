package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.install.InstallException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzr {

    /* renamed from: e  reason: collision with root package name */
    private static final com.google.android.play.core.appupdate.internal.zzm f25251e = new com.google.android.play.core.appupdate.internal.zzm("AppUpdateService");

    /* renamed from: f  reason: collision with root package name */
    private static final Intent f25252f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    @Nullable
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    com.google.android.play.core.appupdate.internal.zzx f25253a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25254b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f25255c;

    /* renamed from: d  reason: collision with root package name */
    private final zzt f25256d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(Context context, zzt zztVar) {
        this.f25254b = context.getPackageName();
        this.f25255c = context;
        this.f25256d = zztVar;
        if (com.google.android.play.core.appupdate.internal.zzab.zza(context)) {
            this.f25253a = new com.google.android.play.core.appupdate.internal.zzx(com.google.android.play.core.appupdate.internal.zzz.zza(context), f25251e, "AppUpdateService", f25252f, zzl.zza, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Bundle b(zzr zzrVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(i());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(zzrVar.f25255c.getPackageManager().getPackageInfo(zzrVar.f25255c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f25251e.zzb("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ AppUpdateInfo f(zzr zzrVar, Bundle bundle, String str) {
        Integer valueOf;
        int i4 = bundle.getInt("version.code", -1);
        int i5 = bundle.getInt("update.availability");
        int i6 = bundle.getInt("install.status", 0);
        if (bundle.getInt("client.version.staleness", -1) == -1) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(bundle.getInt("client.version.staleness"));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("blocking.destructive.intent", k(bundle.getIntegerArrayList("update.precondition.failures:blocking.destructive.intent")));
        hashMap.put("nonblocking.destructive.intent", k(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.destructive.intent")));
        hashMap.put("blocking.intent", k(bundle.getIntegerArrayList("update.precondition.failures:blocking.intent")));
        hashMap.put("nonblocking.intent", k(bundle.getIntegerArrayList("update.precondition.failures:nonblocking.intent")));
        return AppUpdateInfo.zzb(str, i4, i5, i6, valueOf, bundle.getInt("in.app.update.priority", 0), bundle.getLong("bytes.downloaded"), bundle.getLong("total.bytes.to.download"), bundle.getLong("additional.size.required"), zzrVar.f25256d.a(), (PendingIntent) bundle.getParcelable("blocking.intent"), (PendingIntent) bundle.getParcelable("nonblocking.intent"), (PendingIntent) bundle.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle.getParcelable("nonblocking.destructive.intent"), hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putAll(com.google.android.play.core.appupdate.internal.zzi.zza("app_update"));
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }

    private static Task j() {
        f25251e.zzb("onError(%d)", -9);
        return Tasks.forException(new InstallException(-9));
    }

    private static HashSet k(@Nullable ArrayList arrayList) {
        HashSet hashSet = new HashSet();
        if (arrayList != null) {
            hashSet.addAll(arrayList);
        }
        return hashSet;
    }

    public final Task d(String str) {
        if (this.f25253a == null) {
            return j();
        }
        f25251e.zzd("completeUpdate(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f25253a.zzp(new zzn(this, taskCompletionSource, taskCompletionSource, str), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task e(String str) {
        if (this.f25253a == null) {
            return j();
        }
        f25251e.zzd("requestUpdateInfo(%s)", str);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f25253a.zzp(new zzm(this, taskCompletionSource, str, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
