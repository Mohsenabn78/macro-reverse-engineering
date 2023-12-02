package com.arlosoft.macrodroid.celltowers;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public class CellTowerListActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CellTowerListActivity f9660a;

    /* renamed from: b  reason: collision with root package name */
    private View f9661b;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CellTowerListActivity f9662a;

        a(CellTowerListActivity cellTowerListActivity) {
            this.f9662a = cellTowerListActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9662a.addGeofenceButtonClick();
        }
    }

    @UiThread
    public CellTowerListActivity_ViewBinding(CellTowerListActivity cellTowerListActivity) {
        this(cellTowerListActivity, cellTowerListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CellTowerListActivity cellTowerListActivity = this.f9660a;
        if (cellTowerListActivity != null) {
            this.f9660a = null;
            cellTowerListActivity.m_addCellTowerButton = null;
            cellTowerListActivity.m_groupList = null;
            cellTowerListActivity.infoCardView = null;
            cellTowerListActivity.infoCardTitle = null;
            cellTowerListActivity.infoCardDetail = null;
            cellTowerListActivity.infoCardGotIt = null;
            this.f9661b.setOnClickListener(null);
            this.f9661b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public CellTowerListActivity_ViewBinding(CellTowerListActivity cellTowerListActivity, View view) {
        this.f9660a = cellTowerListActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.cell_tower_add_button, "field 'm_addCellTowerButton' and method 'addGeofenceButtonClick'");
        cellTowerListActivity.m_addCellTowerButton = (FloatingActionButton) Utils.castView(findRequiredView, R.id.cell_tower_add_button, "field 'm_addCellTowerButton'", FloatingActionButton.class);
        this.f9661b = findRequiredView;
        findRequiredView.setOnClickListener(new a(cellTowerListActivity));
        cellTowerListActivity.m_groupList = (ListView) Utils.findRequiredViewAsType(view, R.id.cell_tower_group_list, "field 'm_groupList'", ListView.class);
        cellTowerListActivity.infoCardView = (CardView) Utils.findRequiredViewAsType(view, R.id.infoCardView, "field 'infoCardView'", CardView.class);
        cellTowerListActivity.infoCardTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardTitle, "field 'infoCardTitle'", TextView.class);
        cellTowerListActivity.infoCardDetail = (TextView) Utils.findRequiredViewAsType(view, R.id.infoCardDetail, "field 'infoCardDetail'", TextView.class);
        cellTowerListActivity.infoCardGotIt = (Button) Utils.findRequiredViewAsType(view, R.id.infoCardGotIt, "field 'infoCardGotIt'", Button.class);
    }
}
