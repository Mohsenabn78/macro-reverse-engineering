package com.arlosoft.macrodroid.celltowers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public class CellTowerGroupActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private CellTowerGroupActivity f9637a;

    /* renamed from: b  reason: collision with root package name */
    private View f9638b;

    /* renamed from: c  reason: collision with root package name */
    private View f9639c;

    /* loaded from: classes3.dex */
    class a extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CellTowerGroupActivity f9640a;

        a(CellTowerGroupActivity cellTowerGroupActivity) {
            this.f9640a = cellTowerGroupActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9640a.onCellTowerBgScanPressed(view);
        }
    }

    /* loaded from: classes3.dex */
    class b extends DebouncingOnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CellTowerGroupActivity f9642a;

        b(CellTowerGroupActivity cellTowerGroupActivity) {
            this.f9642a = cellTowerGroupActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f9642a.onScanningStopPressed(view);
        }
    }

    @UiThread
    public CellTowerGroupActivity_ViewBinding(CellTowerGroupActivity cellTowerGroupActivity) {
        this(cellTowerGroupActivity, cellTowerGroupActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CellTowerGroupActivity cellTowerGroupActivity = this.f9637a;
        if (cellTowerGroupActivity != null) {
            this.f9637a = null;
            cellTowerGroupActivity.m_cellTowerList = null;
            cellTowerGroupActivity.m_fab = null;
            cellTowerGroupActivity.m_scanningLayout = null;
            cellTowerGroupActivity.m_cellTowerCountText = null;
            cellTowerGroupActivity.m_scanningText = null;
            cellTowerGroupActivity.m_scanBgButton = null;
            this.f9638b.setOnClickListener(null);
            this.f9638b = null;
            this.f9639c.setOnClickListener(null);
            this.f9639c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public CellTowerGroupActivity_ViewBinding(CellTowerGroupActivity cellTowerGroupActivity, View view) {
        this.f9637a = cellTowerGroupActivity;
        cellTowerGroupActivity.m_cellTowerList = (ListView) Utils.findRequiredViewAsType(view, R.id.cell_tower_list, "field 'm_cellTowerList'", ListView.class);
        cellTowerGroupActivity.m_fab = (FloatingActionButton) Utils.findRequiredViewAsType(view, R.id.cell_tower_done_button, "field 'm_fab'", FloatingActionButton.class);
        cellTowerGroupActivity.m_scanningLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.cell_tower_scanning_layout, "field 'm_scanningLayout'", ViewGroup.class);
        cellTowerGroupActivity.m_cellTowerCountText = (TextView) Utils.findRequiredViewAsType(view, R.id.cell_tower_count_text, "field 'm_cellTowerCountText'", TextView.class);
        cellTowerGroupActivity.m_scanningText = (TextView) Utils.findRequiredViewAsType(view, R.id.scanning_text, "field 'm_scanningText'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.cell_tower_scan_bg_button, "field 'm_scanBgButton' and method 'onCellTowerBgScanPressed'");
        cellTowerGroupActivity.m_scanBgButton = (Button) Utils.castView(findRequiredView, R.id.cell_tower_scan_bg_button, "field 'm_scanBgButton'", Button.class);
        this.f9638b = findRequiredView;
        findRequiredView.setOnClickListener(new a(cellTowerGroupActivity));
        View findRequiredView2 = Utils.findRequiredView(view, R.id.cell_tower_stop_scanning_button, "method 'onScanningStopPressed'");
        this.f9639c = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(cellTowerGroupActivity));
    }
}
