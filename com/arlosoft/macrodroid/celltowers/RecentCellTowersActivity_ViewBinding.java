package com.arlosoft.macrodroid.celltowers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class RecentCellTowersActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private RecentCellTowersActivity f9694a;

    @UiThread
    public RecentCellTowersActivity_ViewBinding(RecentCellTowersActivity recentCellTowersActivity) {
        this(recentCellTowersActivity, recentCellTowersActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        RecentCellTowersActivity recentCellTowersActivity = this.f9694a;
        if (recentCellTowersActivity != null) {
            this.f9694a = null;
            recentCellTowersActivity.recyclerView = null;
            recentCellTowersActivity.infoCard = null;
            recentCellTowersActivity.infoCardTitle = null;
            recentCellTowersActivity.infoCardDetail = null;
            recentCellTowersActivity.infoCardGotit = null;
            recentCellTowersActivity.emptyView = null;
            recentCellTowersActivity.loadingView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public RecentCellTowersActivity_ViewBinding(RecentCellTowersActivity recentCellTowersActivity, View view) {
        this.f9694a = recentCellTowersActivity;
        recentCellTowersActivity.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
        recentCellTowersActivity.infoCard = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCard, "field 'infoCard'", CardView.class);
        recentCellTowersActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        recentCellTowersActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        recentCellTowersActivity.infoCardGotit = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotit'", Button.class);
        recentCellTowersActivity.emptyView = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.emptyView, "field 'emptyView'", ViewGroup.class);
        recentCellTowersActivity.loadingView = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.loadingView, "field 'loadingView'", ViewGroup.class);
    }
}
