package com.arlosoft.macrodroid.bugreporting;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class SubmitBugFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private SubmitBugFragment f9582a;

    /* renamed from: b  reason: collision with root package name */
    private View f9583b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SubmitBugFragment f9584a;

        a(SubmitBugFragment submitBugFragment) {
            this.f9584a = submitBugFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9584a.onFabClicked();
        }
    }

    @UiThread
    public SubmitBugFragment_ViewBinding(SubmitBugFragment submitBugFragment, View view) {
        this.f9582a = submitBugFragment;
        submitBugFragment.emailAddress = (EditText) Utils.findRequiredViewAsType(view, R.id.email_address, "field 'emailAddress'", EditText.class);
        submitBugFragment.holidayWarning = (TextView) Utils.findRequiredViewAsType(view, R.id.holiday_warning, "field 'holidayWarning'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.submit_bug, "method 'onFabClicked'");
        this.f9583b = findRequiredView;
        findRequiredView.setOnClickListener(new a(submitBugFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        SubmitBugFragment submitBugFragment = this.f9582a;
        if (submitBugFragment != null) {
            this.f9582a = null;
            submitBugFragment.emailAddress = null;
            submitBugFragment.holidayWarning = null;
            this.f9583b.setOnClickListener(null);
            this.f9583b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
