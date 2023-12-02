package com.arlosoft.macrodroid.wizard;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.utils.StyleUtils;
import com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard;
import com.arlosoft.macrodroid.wizard.WizardItemAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WizardItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f16546a;

    /* renamed from: b  reason: collision with root package name */
    private List<SelectableItemInfo> f16547b;

    /* renamed from: c  reason: collision with root package name */
    private final Macro f16548c;

    /* renamed from: d  reason: collision with root package name */
    private List<SelectableItemInfo> f16549d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16550e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16551f;

    /* renamed from: g  reason: collision with root package name */
    private int f16552g;

    /* renamed from: h  reason: collision with root package name */
    private SelectableItemChosenListener f16553h;

    /* renamed from: i  reason: collision with root package name */
    private LayoutTransition f16554i = new LayoutTransition();

    /* renamed from: j  reason: collision with root package name */
    private List<? extends SelectableItem> f16555j = new ArrayList();

    /* loaded from: classes3.dex */
    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.select_item_experimental_label_1)
        TextView experimentalLabel1;
        @BindView(R.id.select_item_row_frame)
        ViewGroup frame;
        @BindView(R.id.select_item_help)
        TextView helpText;
        @BindView(R.id.select_item_icon_background)
        View iconBackground;
        @BindView(R.id.select_item_info_label)
        TextView rootOnlyLabel;
        @BindView(R.id.select_item_icon)
        ImageView triggerIcon;
        @BindView(R.id.select_item_name)
        TextView triggerName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f16556a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f16556a = viewHolder;
            viewHolder.frame = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.select_item_row_frame, "field 'frame'", ViewGroup.class);
            viewHolder.triggerName = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_name, "field 'triggerName'", TextView.class);
            viewHolder.rootOnlyLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_info_label, "field 'rootOnlyLabel'", TextView.class);
            viewHolder.experimentalLabel1 = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_experimental_label_1, "field 'experimentalLabel1'", TextView.class);
            viewHolder.iconBackground = Utils.findRequiredView(view, R.id.select_item_icon_background, "field 'iconBackground'");
            viewHolder.triggerIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_item_icon, "field 'triggerIcon'", ImageView.class);
            viewHolder.helpText = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_help, "field 'helpText'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            ViewHolder viewHolder = this.f16556a;
            if (viewHolder != null) {
                this.f16556a = null;
                viewHolder.frame = null;
                viewHolder.triggerName = null;
                viewHolder.rootOnlyLabel = null;
                viewHolder.experimentalLabel1 = null;
                viewHolder.iconBackground = null;
                viewHolder.triggerIcon = null;
                viewHolder.helpText = null;
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
            for (int i4 = 0; i4 < WizardItemAdapter.this.f16549d.size(); i4++) {
                SelectableItemInfo selectableItemInfo = (SelectableItemInfo) WizardItemAdapter.this.f16549d.get(i4);
                for (Integer num : selectableItemInfo.getSerchTerms()) {
                    int intValue = num.intValue();
                    if (TextUtils.isEmpty(lowerCase) || WizardItemAdapter.this.f16546a.getString(intValue).toLowerCase().contains(lowerCase)) {
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
            WizardItemAdapter.this.f16547b = (List) filterResults.values;
            WizardItemAdapter.this.notifyDataSetChanged();
        }
    }

    public WizardItemAdapter(Activity activity, Macro macro, boolean z3, int i4, List<SelectableItemInfo> list, SelectableItemChosenListener selectableItemChosenListener) {
        setHasStableIds(true);
        this.f16546a = activity;
        this.f16548c = macro;
        this.f16551f = z3;
        this.f16552g = i4;
        this.f16547b = list;
        this.f16553h = selectableItemChosenListener;
        this.f16549d = new ArrayList(this.f16547b);
    }

    private void h(AddSelectableItemInfoCard.ViewHolder viewHolder) {
        AddSelectableItemInfoCard.bindInfoCard(this.f16546a, viewHolder, this.f16552g, false, new AddSelectableItemInfoCard.InfoCardDismissedListener() { // from class: w0.r
            @Override // com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard.InfoCardDismissedListener
            public final void onDismissed() {
                WizardItemAdapter.this.j();
            }
        });
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewHolder.cardView.getLayoutParams();
        marginLayoutParams.setMargins(marginLayoutParams.getMarginStart(), marginLayoutParams.topMargin, marginLayoutParams.getMarginEnd(), 0);
        viewHolder.cardView.setLayoutParams(marginLayoutParams);
    }

    private void i(SelectableItemInfo selectableItemInfo) {
        this.f16553h.selectableItemChosen(selectableItemInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f16551f = false;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(SelectableItemInfo selectableItemInfo, View view) {
        i(selectableItemInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean m(SelectableItemInfo selectableItemInfo, View view) {
        Activity activity = this.f16546a;
        int alertDialogStyle = StyleUtils.getAlertDialogStyle(selectableItemInfo.getItemType());
        this.f16552g = alertDialogStyle;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, alertDialogStyle);
        builder.setTitle(selectableItemInfo.getName());
        if (selectableItemInfo.supportsAdbHack()) {
            Activity activity2 = this.f16546a;
            builder.setMessage(Util.appendAdbHackInfo(activity2, activity2.getString(selectableItemInfo.getHelpInfo())));
        } else {
            builder.setMessage(selectableItemInfo.getHelpInfo());
        }
        builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() { // from class: w0.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.cancel();
            }
        });
        Util.linkifyDialogText(builder.show());
        return true;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16547b.size() + 1 + (this.f16551f ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        int itemViewType = getItemViewType(i4);
        if (itemViewType != 0) {
            if (itemViewType != 2) {
                return (i4 - (this.f16551f ? 1 : 0)) + 100;
            }
            return 1L;
        }
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        boolean z3 = this.f16551f;
        if (z3 && i4 == 0) {
            return 0;
        }
        if (!z3 || i4 != 1) {
            if (z3 || i4 != 0) {
                return 1;
            }
            return 2;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        int itemViewType = getItemViewType(i4);
        if (itemViewType == 0) {
            h((AddSelectableItemInfoCard.ViewHolder) viewHolder);
        } else if (itemViewType == 2) {
            ((AddedItemViewHolder) viewHolder).bind(this.f16555j);
        } else {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            final SelectableItemInfo selectableItemInfo = this.f16547b.get((i4 - (this.f16551f ? 1 : 0)) - 1);
            viewHolder2.frame.setOnClickListener(new View.OnClickListener() { // from class: w0.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WizardItemAdapter.this.k(selectableItemInfo, view);
                }
            });
            viewHolder2.frame.setOnLongClickListener(new View.OnLongClickListener() { // from class: w0.p
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean m4;
                    m4 = WizardItemAdapter.this.m(selectableItemInfo, view);
                    return m4;
                }
            });
            viewHolder2.triggerName.setText(selectableItemInfo.getName());
            viewHolder2.triggerIcon.setImageDrawable(this.f16546a.getResources().getDrawable(selectableItemInfo.getIcon()));
            viewHolder2.iconBackground.setBackgroundResource(selectableItemInfo.getIconBgDrawable(false));
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
            if (selectableItemInfo.isExperimental()) {
                viewHolder2.experimentalLabel1.setText(R.string.experimental);
                viewHolder2.experimentalLabel1.setVisibility(0);
            } else if (selectableItemInfo.isBeta()) {
                viewHolder2.experimentalLabel1.setText(R.string.feature_beta_label);
                viewHolder2.experimentalLabel1.setVisibility(0);
            } else {
                viewHolder2.experimentalLabel1.setVisibility(8);
            }
            if (this.f16550e) {
                viewHolder2.frame.setLayoutTransition(this.f16554i);
                viewHolder2.helpText.setVisibility(0);
                viewHolder2.helpText.setText(selectableItemInfo.getHelpInfo());
                return;
            }
            viewHolder2.frame.setLayoutTransition(null);
            viewHolder2.helpText.setVisibility(8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        if (i4 == 1) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.select_item_row, viewGroup, false));
        }
        if (i4 == 2) {
            return new AddedItemViewHolder(this.f16546a, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_wizard_header, viewGroup, false), this.f16548c, this.f16552g);
        }
        return new AddSelectableItemInfoCard.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_card, viewGroup, false));
    }

    public void refresh(List<SelectableItemInfo> list, List<? extends SelectableItem> list2) {
        int i4 = -1;
        for (SelectableItem selectableItem : list2) {
            if (selectableItem instanceof WidgetPressedTrigger) {
                int i5 = 0;
                while (true) {
                    if (i5 >= list.size()) {
                        break;
                    } else if (list.get(i5).getName() == R.string.trigger_widget_pressed) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        }
        if (i4 >= 0) {
            list.remove(i4);
        }
        this.f16547b = list;
        this.f16549d = new ArrayList(this.f16547b);
        this.f16555j = list2;
        if (i4 >= 0) {
            notifyDataSetChanged();
        } else {
            notifyItemChanged(this.f16551f ? 1 : 0);
        }
    }

    public void toggleHelp() {
        this.f16550e = !this.f16550e;
        notifyDataSetChanged();
    }
}
