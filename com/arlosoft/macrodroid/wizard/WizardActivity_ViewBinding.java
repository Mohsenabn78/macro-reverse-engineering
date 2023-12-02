package com.arlosoft.macrodroid.wizard;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes3.dex */
public class WizardActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private WizardActivity f16530a;

    /* renamed from: b  reason: collision with root package name */
    private View f16531b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ WizardActivity f16532a;

        a(WizardActivity wizardActivity) {
            this.f16532a = wizardActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f16532a.onFabClicked();
        }
    }

    @UiThread
    public WizardActivity_ViewBinding(WizardActivity wizardActivity) {
        this(wizardActivity, wizardActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        WizardActivity wizardActivity = this.f16530a;
        if (wizardActivity != null) {
            this.f16530a = null;
            wizardActivity.toolbarContainer = null;
            wizardActivity.tabLayout = null;
            wizardActivity.viewPager = null;
            wizardActivity.toolBar = null;
            wizardActivity.fab = null;
            this.f16531b.setOnClickListener(null);
            this.f16531b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public WizardActivity_ViewBinding(WizardActivity wizardActivity, View view) {
        this.f16530a = wizardActivity;
        wizardActivity.toolbarContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.toolbar_container, "field 'toolbarContainer'", ViewGroup.class);
        wizardActivity.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, R.id.tabbar, "field 'tabLayout'", TabLayout.class);
        wizardActivity.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.viewpager, "field 'viewPager'", ViewPager.class);
        wizardActivity.toolBar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolBar'", Toolbar.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.fab, "field 'fab' and method 'onFabClicked'");
        wizardActivity.fab = (FloatingActionButton) Utils.castView(findRequiredView, R.id.fab, "field 'fab'", FloatingActionButton.class);
        this.f16531b = findRequiredView;
        findRequiredView.setOnClickListener(new a(wizardActivity));
        Resources resources = view.getContext().getResources();
        wizardActivity.wizardTabIconSize = resources.getDimensionPixelSize(R.dimen.wizard_tab_icon_size);
        wizardActivity.wizardTabIconPadding = resources.getDimensionPixelSize(R.dimen.wizard_tab_icon_padding);
    }
}
