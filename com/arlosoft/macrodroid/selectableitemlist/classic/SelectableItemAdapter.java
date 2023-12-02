package com.arlosoft.macrodroid.selectableitemlist.classic;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class SelectableItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private List<SelectableItemInfo> f13372a;

    /* renamed from: b  reason: collision with root package name */
    private List<SelectableItemInfo> f13373b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13374c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutTransition f13375d = new LayoutTransition();

    /* renamed from: e  reason: collision with root package name */
    private SelectableItemChosenListener f13376e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f13377f;

    /* renamed from: g  reason: collision with root package name */
    protected final Macro f13378g;

    /* renamed from: h  reason: collision with root package name */
    protected final Activity f13379h;

    /* renamed from: i  reason: collision with root package name */
    private final int f13380i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f13381j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f13382k;

    /* loaded from: classes3.dex */
    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.select_item_experimental_label_1)
        TextView experimentalLabel1;
        @BindView(R.id.select_item_row_frame)
        ViewGroup frame;
        @BindView(R.id.select_item_heading_container)
        ViewGroup headingContainer;
        @BindView(R.id.select_item_heading)
        TextView headingText;
        @BindView(R.id.select_item_help)
        TextView helpText;
        @BindView(R.id.select_item_icon)
        ImageView icon;
        @BindView(R.id.select_item_icon_background)
        View iconBackground;
        @BindView(R.id.select_item_name)
        TextView itemName;
        @BindView(R.id.select_item_info_label)
        TextView rootOnlyLabel;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f13383a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f13383a = viewHolder;
            viewHolder.frame = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.select_item_row_frame, "field 'frame'", ViewGroup.class);
            viewHolder.itemName = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_name, "field 'itemName'", TextView.class);
            viewHolder.rootOnlyLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_info_label, "field 'rootOnlyLabel'", TextView.class);
            viewHolder.experimentalLabel1 = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_experimental_label_1, "field 'experimentalLabel1'", TextView.class);
            viewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_item_icon, "field 'icon'", ImageView.class);
            viewHolder.helpText = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_help, "field 'helpText'", TextView.class);
            viewHolder.iconBackground = Utils.findRequiredView(view, R.id.select_item_icon_background, "field 'iconBackground'");
            viewHolder.headingContainer = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.select_item_heading_container, "field 'headingContainer'", ViewGroup.class);
            viewHolder.headingText = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_heading, "field 'headingText'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.f13383a;
            if (viewHolder != null) {
                this.f13383a = null;
                viewHolder.frame = null;
                viewHolder.itemName = null;
                viewHolder.rootOnlyLabel = null;
                viewHolder.experimentalLabel1 = null;
                viewHolder.icon = null;
                viewHolder.helpText = null;
                viewHolder.iconBackground = null;
                viewHolder.headingContainer = null;
                viewHolder.headingText = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    class a extends Filter {
        a() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            String lowerCase = charSequence.toString().toLowerCase();
            for (int i4 = 0; i4 < SelectableItemAdapter.this.f13373b.size(); i4++) {
                SelectableItemInfo selectableItemInfo = (SelectableItemInfo) SelectableItemAdapter.this.f13373b.get(i4);
                for (Integer num : selectableItemInfo.getSerchTerms()) {
                    int intValue = num.intValue();
                    SelectableItemAdapter.this.f13379h.getString(intValue);
                    if (SelectableItemAdapter.this.f13379h.getString(intValue).toLowerCase().contains(lowerCase.toString().toLowerCase()) && !arrayList.contains(selectableItemInfo)) {
                        arrayList.add(selectableItemInfo);
                    }
                }
            }
            filterResults.count = arrayList.size();
            filterResults.values = arrayList;
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            SelectableItemAdapter.this.f13372a = (List) filterResults.values;
            SelectableItemAdapter.this.notifyDataSetChanged();
        }
    }

    public SelectableItemAdapter(Activity activity, Macro macro, boolean z3, @NonNull SelectableItemChosenListener selectableItemChosenListener, int i4, boolean z4) {
        setHasStableIds(true);
        this.f13379h = activity;
        this.f13378g = macro;
        this.f13377f = z3;
        this.f13376e = selectableItemChosenListener;
        this.f13380i = i4;
        this.f13381j = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f13377f = false;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(SelectableItemInfo selectableItemInfo, View view) {
        SelectableItemChosenListener selectableItemChosenListener = this.f13376e;
        if (selectableItemChosenListener != null) {
            selectableItemChosenListener.selectableItemChosen(selectableItemInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean j(SelectableItemInfo selectableItemInfo, View view) {
        SelectableItemChosenListener selectableItemChosenListener = this.f13376e;
        if (selectableItemChosenListener != null) {
            selectableItemChosenListener.selectableItemHelpChosen(selectableItemInfo);
            return true;
        }
        return true;
    }

    protected abstract List<SelectableItemInfo> f();

    @DrawableRes
    protected abstract int g();

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13372a.size() + (this.f13377f ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        if (this.f13377f) {
            return i4;
        }
        return i4 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        if (this.f13377f && i4 == 0) {
            return 0;
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        if (viewHolder instanceof AddSelectableItemInfoCard.ViewHolder) {
            AddSelectableItemInfoCard.bindInfoCard(this.f13379h, (AddSelectableItemInfoCard.ViewHolder) viewHolder, this.f13380i, this.f13381j, new AddSelectableItemInfoCard.InfoCardDismissedListener() { // from class: j0.a
                @Override // com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard.InfoCardDismissedListener
                public final void onDismissed() {
                    SelectableItemAdapter.this.h();
                }
            });
            return;
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final SelectableItemInfo selectableItemInfo = this.f13372a.get(i4 - (this.f13377f ? 1 : 0));
        viewHolder2.frame.setOnClickListener(new View.OnClickListener() { // from class: j0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectableItemAdapter.this.i(selectableItemInfo, view);
            }
        });
        viewHolder2.frame.setOnLongClickListener(new View.OnLongClickListener() { // from class: j0.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean j4;
                j4 = SelectableItemAdapter.this.j(selectableItemInfo, view);
                return j4;
            }
        });
        viewHolder2.itemName.setText(selectableItemInfo.getName());
        viewHolder2.icon.setImageDrawable(this.f13379h.getResources().getDrawable(selectableItemInfo.getIcon()));
        viewHolder2.iconBackground.setBackgroundResource(g());
        if (selectableItemInfo.isRootOnly()) {
            viewHolder2.rootOnlyLabel.setVisibility(0);
            if (selectableItemInfo.supportsAdbHack()) {
                viewHolder2.rootOnlyLabel.setText(R.string.root_or_adb_hack);
            } else {
                viewHolder2.rootOnlyLabel.setText(R.string.root_only);
            }
        } else {
            viewHolder2.rootOnlyLabel.setVisibility(8);
        }
        if (selectableItemInfo.isProOnly()) {
            viewHolder2.rootOnlyLabel.setVisibility(0);
            viewHolder2.rootOnlyLabel.setText(R.string.pro_version_only_short);
        }
        if (selectableItemInfo.isExperimental()) {
            viewHolder2.experimentalLabel1.setText(R.string.experimental);
            viewHolder2.experimentalLabel1.setVisibility(0);
        } else if (selectableItemInfo.isBeta()) {
            viewHolder2.experimentalLabel1.setText(R.string.feature_beta_label);
            viewHolder2.experimentalLabel1.setVisibility(0);
        } else {
            viewHolder2.experimentalLabel1.setVisibility(8);
        }
        if (this.f13374c) {
            viewHolder2.frame.setLayoutTransition(this.f13375d);
            viewHolder2.helpText.setVisibility(0);
            Linkify.addLinks(viewHolder2.helpText, 15);
            viewHolder2.helpText.setText(selectableItemInfo.getHelpInfo());
            return;
        }
        viewHolder2.frame.setLayoutTransition(null);
        viewHolder2.helpText.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        if (i4 == 1) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.select_item_row, viewGroup, false));
        }
        return new AddSelectableItemInfoCard.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_card, viewGroup, false));
    }

    public void refresh() {
        this.f13372a = f();
        Iterator<Trigger> it = this.f13378g.getTriggerList().iterator();
        int i4 = -1;
        while (it.hasNext()) {
            if (it.next() instanceof WidgetPressedTrigger) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f13372a.size()) {
                        break;
                    } else if (this.f13372a.get(i5).getName() == R.string.trigger_widget_pressed) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        }
        if (i4 >= 0) {
            this.f13372a.remove(i4);
        }
        this.f13373b = new ArrayList(this.f13372a);
        notifyDataSetChanged();
    }

    public void setHelp(boolean z3) {
        this.f13374c = z3;
        notifyDataSetChanged();
    }
}
