package com.arlosoft.macrodroid.bugreporting;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class BugDetailsFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private BugDetailsFragment f9556a;

    /* renamed from: b  reason: collision with root package name */
    private View f9557b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BugDetailsFragment f9558a;

        a(BugDetailsFragment bugDetailsFragment) {
            this.f9558a = bugDetailsFragment;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9558a.onFabClicked();
        }
    }

    @UiThread
    public BugDetailsFragment_ViewBinding(BugDetailsFragment bugDetailsFragment, View view) {
        this.f9556a = bugDetailsFragment;
        bugDetailsFragment.descriptionText = (EditText) Utils.findRequiredViewAsType(view, R.id.description_text, "field 'descriptionText'", EditText.class);
        bugDetailsFragment.screenshotsContainer = (FlowLayout) Utils.findRequiredViewAsType(view, R.id.screenshotsContainer, "field 'screenshotsContainer'", FlowLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.continueButton, "method 'onFabClicked'");
        this.f9557b = findRequiredView;
        findRequiredView.setOnClickListener(new a(bugDetailsFragment));
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BugDetailsFragment bugDetailsFragment = this.f9556a;
        if (bugDetailsFragment != null) {
            this.f9556a = null;
            bugDetailsFragment.descriptionText = null;
            bugDetailsFragment.screenshotsContainer = null;
            this.f9557b.setOnClickListener(null);
            this.f9557b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
