package com.arlosoft.macrodroid.bugreporting;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ReportBugActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private ReportBugActivity f9572a;

    @UiThread
    public ReportBugActivity_ViewBinding(ReportBugActivity reportBugActivity) {
        this(reportBugActivity, reportBugActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ReportBugActivity reportBugActivity = this.f9572a;
        if (reportBugActivity != null) {
            this.f9572a = null;
            reportBugActivity.viewPager = null;
            reportBugActivity.loadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public ReportBugActivity_ViewBinding(ReportBugActivity reportBugActivity, View view) {
        this.f9572a = reportBugActivity;
        reportBugActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewPager, "field 'viewPager'", ViewPager.class);
        reportBugActivity.loadingView = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.loading_view, "field 'loadingView'", ViewGroup.class);
    }
}
