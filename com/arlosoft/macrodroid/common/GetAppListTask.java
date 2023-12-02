package com.arlosoft.macrodroid.common;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.AsyncTask;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GetAppListTask extends AsyncTask<Void, Void, List<AppInfo>> {

    /* renamed from: a  reason: collision with root package name */
    private AppListListener f9859a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Activity> f9860b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9861c;

    /* renamed from: d  reason: collision with root package name */
    private transient MaterialDialog f9862d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9863e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9864f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private final int f9865g;

    /* loaded from: classes3.dex */
    public interface AppListListener {
        void appListUpdate(List<AppInfo> list, boolean z3);
    }

    public GetAppListTask(AppListListener appListListener, Activity activity, boolean z3, boolean z4, @ColorInt int i4) {
        this(appListListener, activity, z3, z4, i4, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public List<AppInfo> doInBackground(Void... voidArr) {
        Activity activity = this.f9860b.get();
        if (activity != null) {
            return Util.getInstalledAppList(activity.getApplicationContext(), this.f9863e);
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d */
    public void onPostExecute(List<AppInfo> list) {
        MaterialDialog materialDialog = this.f9862d;
        if (materialDialog != null) {
            try {
                materialDialog.dismiss();
                this.f9862d = null;
            } catch (IllegalArgumentException unused) {
            }
        }
        Activity activity = this.f9860b.get();
        if (activity == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Get Package List failed from background thread"));
            list = Util.getInstalledAppList(activity.getApplicationContext(), this.f9863e);
        }
        if (list != null && list.size() > 0) {
            boolean z3 = this.f9861c;
            if (z3) {
                this.f9859a.appListUpdate(list, z3);
                return;
            }
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Get Package List returned empty even when run from activity_home_screen thread"));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.error);
        builder.setMessage("Could not obtain list of installed applications");
        builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        Activity activity;
        if (this.f9861c && (activity = this.f9860b.get()) != null) {
            MaterialDialog build = new MaterialDialog.Builder(activity).title(R.string.please_wait).content(R.string.getting_list_of_apps).progress(true, 0).cancelable(false).widgetColor(this.f9865g).build();
            this.f9862d = build;
            if (this.f9864f) {
                build.getWindow().setType(OverlayUtils.getOverlayType());
            }
            this.f9862d.show();
        }
    }

    public GetAppListTask(AppListListener appListListener, Activity activity, boolean z3, boolean z4, @ColorInt int i4, boolean z5) {
        this.f9859a = appListListener;
        this.f9860b = new WeakReference<>(activity);
        this.f9861c = z3;
        this.f9863e = z4;
        this.f9865g = i4;
        this.f9864f = z5;
    }
}
