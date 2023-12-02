package com.arlosoft.macrodroid.macrolist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.varunest.sparkbutton.SparkButton2;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public class MacroListFragment_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private MacroListFragment f12953a;

    @UiThread
    public MacroListFragment_ViewBinding(MacroListFragment macroListFragment, View view) {
        this.f12953a = macroListFragment;
        macroListFragment.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        macroListFragment.emptyView = Utils.findRequiredView(view, R.id.macrolist_emptyView, "field 'emptyView'");
        macroListFragment.emptyTextView = (TextView) Utils.findRequiredViewAsType(view, R.id.macrolist_emptyLabel, "field 'emptyTextView'", TextView.class);
        macroListFragment.toolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        macroListFragment.nearbySharePanel = (ExpandableLayout) Utils.findRequiredViewAsType(view, R.id.nearbySharePanel, "field 'nearbySharePanel'", ExpandableLayout.class);
        macroListFragment.dismissButton = (ImageView) Utils.findRequiredViewAsType(view, R.id.dismissButton, "field 'dismissButton'", ImageView.class);
        macroListFragment.titleText = (TextView) Utils.findRequiredViewAsType(view, R.id.titleText, "field 'titleText'", TextView.class);
        macroListFragment.favouriteButton = (SparkButton2) Utils.findRequiredViewAsType(view, R.id.favouriteButton, "field 'favouriteButton'", SparkButton2.class);
        macroListFragment.titleContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.titleContainer, "field 'titleContainer'", ViewGroup.class);
        macroListFragment.favouritesHint = (TextView) Utils.findRequiredViewAsType(view, R.id.favouritesHint, "field 'favouritesHint'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MacroListFragment macroListFragment = this.f12953a;
        if (macroListFragment != null) {
            this.f12953a = null;
            macroListFragment.recyclerView = null;
            macroListFragment.emptyView = null;
            macroListFragment.emptyTextView = null;
            macroListFragment.toolbar = null;
            macroListFragment.nearbySharePanel = null;
            macroListFragment.dismissButton = null;
            macroListFragment.titleText = null;
            macroListFragment.favouriteButton = null;
            macroListFragment.titleContainer = null;
            macroListFragment.favouritesHint = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
