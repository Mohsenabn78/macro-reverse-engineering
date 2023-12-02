package com.arlosoft.macrodroid.celltowers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public class IgnoredCellTowersActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private IgnoredCellTowersActivity f9675a;

    /* renamed from: b  reason: collision with root package name */
    private View f9676b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IgnoredCellTowersActivity f9677a;

        a(IgnoredCellTowersActivity ignoredCellTowersActivity) {
            this.f9677a = ignoredCellTowersActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9677a.onAddTowerButtonClick();
        }
    }

    @UiThread
    public IgnoredCellTowersActivity_ViewBinding(IgnoredCellTowersActivity ignoredCellTowersActivity) {
        this(ignoredCellTowersActivity, ignoredCellTowersActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        IgnoredCellTowersActivity ignoredCellTowersActivity = this.f9675a;
        if (ignoredCellTowersActivity != null) {
            this.f9675a = null;
            ignoredCellTowersActivity.recyclerView = null;
            ignoredCellTowersActivity.infoCard = null;
            ignoredCellTowersActivity.infoCardTitle = null;
            ignoredCellTowersActivity.infoCardDetail = null;
            ignoredCellTowersActivity.infoCardGotit = null;
            ignoredCellTowersActivity.emptyView = null;
            this.f9676b.setOnClickListener(null);
            this.f9676b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public IgnoredCellTowersActivity_ViewBinding(IgnoredCellTowersActivity ignoredCellTowersActivity, View view) {
        this.f9675a = ignoredCellTowersActivity;
        ignoredCellTowersActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        ignoredCellTowersActivity.infoCard = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCard, "field 'infoCard'", CardView.class);
        ignoredCellTowersActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        ignoredCellTowersActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        ignoredCellTowersActivity.infoCardGotit = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotit'", Button.class);
        ignoredCellTowersActivity.emptyView = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.emptyView, "field 'emptyView'", ViewGroup.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.addTowerButton, "method 'onAddTowerButtonClick'");
        this.f9676b = findRequiredView;
        findRequiredView.setOnClickListener(new a(ignoredCellTowersActivity));
    }
}
