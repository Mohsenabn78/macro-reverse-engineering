package com.arlosoft.macrodroid.selectableitemlist.classic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.info.BreakFromLoopActionInfo;
import com.arlosoft.macrodroid.action.info.ContinueLoopActionInfo;
import com.arlosoft.macrodroid.action.info.IfConditionActionInfo;
import com.arlosoft.macrodroid.action.info.IfConfirmedThenActionInfo;
import com.arlosoft.macrodroid.action.info.IterateDictionaryActionInfo;
import com.arlosoft.macrodroid.action.info.LoopActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter;
import com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard;
import java.util.List;

/* loaded from: classes3.dex */
public class SelectActionAdapter extends SelectableItemAdapter {

    /* renamed from: l  reason: collision with root package name */
    private final boolean f13370l;

    /* loaded from: classes3.dex */
    static class ViewHolder extends SelectableItemAdapter.ViewHolder {
        @BindView(R.id.select_item_heading_container)
        ViewGroup headingContainer;
        @BindView(R.id.select_item_heading)
        TextView headingText;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding extends SelectableItemAdapter.ViewHolder_ViewBinding {

        /* renamed from: b  reason: collision with root package name */
        private ViewHolder f13371b;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            super(viewHolder, view);
            this.f13371b = viewHolder;
            viewHolder.headingContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.select_item_heading_container, "field 'headingContainer'", ViewGroup.class);
            viewHolder.headingText = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_heading, "field 'headingText'", TextView.class);
        }

        @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter.ViewHolder_ViewBinding, butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.f13371b;
            if (viewHolder != null) {
                this.f13371b = null;
                viewHolder.headingContainer = null;
                viewHolder.headingText = null;
                super.unbind();
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SelectActionAdapter(Activity activity, Macro macro, boolean z3, @NonNull SelectableItemChosenListener selectableItemChosenListener, boolean z4) {
        super(activity, macro, z3, selectableItemChosenListener, 1, false);
        this.f13370l = z4;
        refresh();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter
    protected List<SelectableItemInfo> f() {
        List<SelectableItemInfo> allActionsInfo = Action.getAllActionsInfo(this.f13379h.getApplicationContext(), this.f13378g, false);
        if (this.f13370l) {
            allActionsInfo.add(0, ContinueLoopActionInfo.getInstance());
            allActionsInfo.add(0, BreakFromLoopActionInfo.getInstance());
            allActionsInfo.add(0, IterateDictionaryActionInfo.getInstance());
            allActionsInfo.add(0, LoopActionInfo.getInstance());
            allActionsInfo.add(0, IfConfirmedThenActionInfo.getInstance());
            allActionsInfo.add(0, IfConditionActionInfo.getInstance());
        }
        return allActionsInfo;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter
    protected int g() {
        return R.drawable.circular_icon_background_action;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        super.onBindViewHolder(viewHolder, i4);
        if (!(viewHolder instanceof AddSelectableItemInfoCard.ViewHolder)) {
            int i5 = i4 - (this.f13377f ? 1 : 0);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            if (!this.f13382k && this.f13370l && (i5 == 0 || i5 == 6)) {
                viewHolder2.headingContainer.setVisibility(0);
                boolean z3 = this.f13377f;
                int i6 = R.string.control_flow;
                if (z3) {
                    TextView textView = viewHolder2.headingText;
                    if (i4 != 1) {
                        i6 = R.string.actions;
                    }
                    textView.setText(i6);
                    return;
                }
                TextView textView2 = viewHolder2.headingText;
                if (i4 != 0) {
                    i6 = R.string.actions;
                }
                textView2.setText(i6);
                return;
            }
            viewHolder2.headingContainer.setVisibility(8);
        }
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        if (i4 == 1) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.select_item_row, viewGroup, false));
        }
        return super.onCreateViewHolder(viewGroup, i4);
    }
}
