package com.arlosoft.macrodroid.celltowers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.celltowers.RecentCellTowersActivity;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.data.CellTowerRecord;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.LogUpdateEvent;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import me.drakeet.support.toast.ToastCompat;
import org.apmem.tools.layouts.FlowLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

/* compiled from: RecentCellTowersActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class RecentCellTowersActivity extends MacroDroidBaseActivity {
    public static final int $stable = 8;
    @BindView(R.id.emptyView)
    public ViewGroup emptyView;

    /* renamed from: f  reason: collision with root package name */
    private Database f9679f;

    /* renamed from: g  reason: collision with root package name */
    private RecentTowersAdapter f9680g;
    @BindView(R.id.infoCard)
    public CardView infoCard;
    @BindView(R.id.infoCardDetail)
    public TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    public Button infoCardGotit;
    @BindView(R.id.infoCardTitle)
    public TextView infoCardTitle;
    @BindView(R.id.loadingView)
    public ViewGroup loadingView;
    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    /* compiled from: RecentCellTowersActivity.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nRecentCellTowersActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecentCellTowersActivity.kt\ncom/arlosoft/macrodroid/celltowers/RecentCellTowersActivity$RecentTowersAdapter\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,382:1\n37#2,2:383\n*S KotlinDebug\n*F\n+ 1 RecentCellTowersActivity.kt\ncom/arlosoft/macrodroid/celltowers/RecentCellTowersActivity$RecentTowersAdapter\n*L\n334#1:383,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class RecentTowersAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final RecentCellTowersActivity f9681a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Database f9682b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private List<? extends CellTowerRecord> f9683c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final SimpleDateFormat f9684d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final List<CellTowerGroup> f9685e;

        /* renamed from: f  reason: collision with root package name */
        private final int f9686f;

        /* renamed from: g  reason: collision with root package name */
        private final int f9687g;

        /* renamed from: h  reason: collision with root package name */
        private final int f9688h;

        /* renamed from: i  reason: collision with root package name */
        private final int f9689i;
        @NotNull

        /* renamed from: j  reason: collision with root package name */
        private final String f9690j;
        @NotNull

        /* renamed from: k  reason: collision with root package name */
        private Set<String> f9691k;

        /* compiled from: RecentCellTowersActivity.kt */
        /* loaded from: classes3.dex */
        public final class ViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecentTowersAdapter f9692a;
            @BindView(R.id.cell_tower_record_card)
            public CardView cellTowerCard;
            @BindView(R.id.cell_tower_id)
            public TextView cellTowerId;
            @BindView(R.id.flow_layout)
            public FlowLayout flowLayout;
            @BindView(R.id.header_bg)
            public ViewGroup headerBg;
            @BindView(R.id.ignored_label)
            public TextView ignoredLabel;
            @BindView(R.id.cell_tower_time)
            public TextView time;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@NotNull RecentTowersAdapter recentTowersAdapter, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.f9692a = recentTowersAdapter;
                ButterKnife.bind(this, itemView);
            }

            @NotNull
            public final CardView getCellTowerCard() {
                CardView cardView = this.cellTowerCard;
                if (cardView != null) {
                    return cardView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("cellTowerCard");
                return null;
            }

            @NotNull
            public final TextView getCellTowerId() {
                TextView textView = this.cellTowerId;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("cellTowerId");
                return null;
            }

            @NotNull
            public final FlowLayout getFlowLayout() {
                FlowLayout flowLayout = this.flowLayout;
                if (flowLayout != null) {
                    return flowLayout;
                }
                Intrinsics.throwUninitializedPropertyAccessException("flowLayout");
                return null;
            }

            @NotNull
            public final ViewGroup getHeaderBg() {
                ViewGroup viewGroup = this.headerBg;
                if (viewGroup != null) {
                    return viewGroup;
                }
                Intrinsics.throwUninitializedPropertyAccessException("headerBg");
                return null;
            }

            @NotNull
            public final TextView getIgnoredLabel() {
                TextView textView = this.ignoredLabel;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("ignoredLabel");
                return null;
            }

            @NotNull
            public final TextView getTime() {
                TextView textView = this.time;
                if (textView != null) {
                    return textView;
                }
                Intrinsics.throwUninitializedPropertyAccessException("time");
                return null;
            }

            public final void setCellTowerCard(@NotNull CardView cardView) {
                Intrinsics.checkNotNullParameter(cardView, "<set-?>");
                this.cellTowerCard = cardView;
            }

            public final void setCellTowerId(@NotNull TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.cellTowerId = textView;
            }

            public final void setFlowLayout(@NotNull FlowLayout flowLayout) {
                Intrinsics.checkNotNullParameter(flowLayout, "<set-?>");
                this.flowLayout = flowLayout;
            }

            public final void setHeaderBg(@NotNull ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
                this.headerBg = viewGroup;
            }

            public final void setIgnoredLabel(@NotNull TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.ignoredLabel = textView;
            }

            public final void setTime(@NotNull TextView textView) {
                Intrinsics.checkNotNullParameter(textView, "<set-?>");
                this.time = textView;
            }
        }

        /* loaded from: classes3.dex */
        public final class ViewHolder_ViewBinding implements Unbinder {

            /* renamed from: a  reason: collision with root package name */
            private ViewHolder f9693a;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
                this.f9693a = viewHolder;
                viewHolder.headerBg = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.header_bg, "field 'headerBg'", ViewGroup.class);
                viewHolder.cellTowerCard = (CardView) Utils.findRequiredViewAsType(view, R.id.cell_tower_record_card, "field 'cellTowerCard'", CardView.class);
                viewHolder.cellTowerId = (TextView) Utils.findRequiredViewAsType(view, R.id.cell_tower_id, "field 'cellTowerId'", TextView.class);
                viewHolder.time = (TextView) Utils.findRequiredViewAsType(view, R.id.cell_tower_time, "field 'time'", TextView.class);
                viewHolder.ignoredLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.ignored_label, "field 'ignoredLabel'", TextView.class);
                viewHolder.flowLayout = (FlowLayout) Utils.findRequiredViewAsType(view, R.id.flow_layout, "field 'flowLayout'", FlowLayout.class);
            }

            @Override // butterknife.Unbinder
            public void unbind() {
                ViewHolder viewHolder = this.f9693a;
                if (viewHolder != null) {
                    this.f9693a = null;
                    viewHolder.headerBg = null;
                    viewHolder.cellTowerCard = null;
                    viewHolder.cellTowerId = null;
                    viewHolder.time = null;
                    viewHolder.ignoredLabel = null;
                    viewHolder.flowLayout = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public RecentTowersAdapter(@NotNull RecentCellTowersActivity activity, @Nullable Database database, @NotNull List<? extends CellTowerRecord> cellTowerRecordList, @NotNull Set<String> ignoreCellTowerList) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(cellTowerRecordList, "cellTowerRecordList");
            Intrinsics.checkNotNullParameter(ignoreCellTowerList, "ignoreCellTowerList");
            this.f9681a = activity;
            this.f9682b = database;
            setHasStableIds(true);
            this.f9683c = cellTowerRecordList;
            this.f9691k = ignoreCellTowerList;
            this.f9684d = new SimpleDateFormat("HH:mm");
            List<CellTowerGroup> cellTowerGroups = CellTowerGroupStore.getInstance().getCellTowerGroups();
            Intrinsics.checkNotNullExpressionValue(cellTowerGroups, "getInstance().cellTowerGroups");
            this.f9685e = cellTowerGroups;
            this.f9686f = ContextCompat.getColor(activity, R.color.white_transparent);
            this.f9689i = activity.getResources().getDimensionPixelOffset(R.dimen.margin_micro);
            this.f9688h = activity.getResources().getDimensionPixelOffset(R.dimen.margin_small);
            String string = activity.getString(R.string.no_groups);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.no_groups)");
            this.f9690j = string;
            this.f9687g = ContextCompat.getColor(activity, R.color.no_groups_color);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(RecentTowersAdapter this$0, CellTowerGroup cellTowerGroup, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(cellTowerGroup, "$cellTowerGroup");
            Intent intent = new Intent(this$0.f9681a, CellTowerGroupActivity.class);
            intent.putExtra("CellTowerGroupName", cellTowerGroup.getName());
            this$0.f9681a.startActivity(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(RecentTowersAdapter this$0, CellTowerRecord cellTowerRecord, boolean z3, boolean z4, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(cellTowerRecord, "$cellTowerRecord");
            String str = cellTowerRecord.cellId;
            Intrinsics.checkNotNullExpressionValue(str, "cellTowerRecord.cellId");
            this$0.i(str, z3, z4);
        }

        private final void g(final String str, final boolean z3) {
            int i4;
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            for (CellTowerGroup cellTowerGroup : this.f9685e) {
                if ((!cellTowerGroup.contains(str)) & z3) {
                    String name = cellTowerGroup.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "cellTowerGroup.name");
                    arrayList.add(name);
                    arrayList2.add(cellTowerGroup);
                } else if (!z3 && cellTowerGroup.contains(str)) {
                    String name2 = cellTowerGroup.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "cellTowerGroup.name");
                    arrayList.add(name2);
                    arrayList2.add(cellTowerGroup);
                }
            }
            if (arrayList.size() > 0) {
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f9681a, R.style.Theme_App_Dialog_Settings);
                if (z3) {
                    i4 = R.string.add_to_group;
                } else {
                    i4 = R.string.remove_from_group;
                }
                builder.setTitle(i4);
                builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.g0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        RecentCellTowersActivity.RecentTowersAdapter.h(z3, arrayList2, str, this, dialogInterface, i5);
                    }
                });
                AlertDialog create = builder.create();
                Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
                create.show();
                return;
            }
            ToastCompat.makeText(this.f9681a.getApplicationContext(), (int) R.string.no_groups_to_add_to, 0).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(boolean z3, List groups, String cellId, RecentTowersAdapter this$0, DialogInterface dialogInterface, int i4) {
            Intrinsics.checkNotNullParameter(groups, "$groups");
            Intrinsics.checkNotNullParameter(cellId, "$cellId");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z3) {
                ((CellTowerGroup) groups.get(i4)).getCellTowerIds().add(cellId);
                CellTowerGroupStore.getInstance().persistData();
            } else {
                ((CellTowerGroup) groups.get(i4)).getCellTowerIds().remove(cellId);
                CellTowerGroupStore.getInstance().persistData();
            }
            this$0.f9681a.refresh();
        }

        private final void i(final String str, final boolean z3, final boolean z4) {
            String[] strArr;
            String string;
            String string2;
            if (z3) {
                strArr = new String[3];
                String string3 = this.f9681a.getString(R.string.add_to_group);
                Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.string.add_to_group)");
                strArr[0] = string3;
                String string4 = this.f9681a.getString(R.string.remove_from_group);
                Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.string.remove_from_group)");
                strArr[1] = string4;
                if (z4) {
                    string2 = this.f9681a.getString(R.string.remove_from_global_ignore);
                } else {
                    string2 = this.f9681a.getString(R.string.add_to_global_ignore);
                }
                Intrinsics.checkNotNullExpressionValue(string2, "if (isIgnored) activity.…ing.add_to_global_ignore)");
                strArr[2] = string2;
            } else {
                strArr = new String[2];
                String string5 = this.f9681a.getString(R.string.add_to_group);
                Intrinsics.checkNotNullExpressionValue(string5, "activity.getString(R.string.add_to_group)");
                strArr[0] = string5;
                if (z4) {
                    string = this.f9681a.getString(R.string.remove_from_global_ignore);
                } else {
                    string = this.f9681a.getString(R.string.add_to_global_ignore);
                }
                Intrinsics.checkNotNullExpressionValue(string, "if (isIgnored) activity.…ore\n                    )");
                strArr[1] = string;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f9681a);
            builder.setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.f0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    RecentCellTowersActivity.RecentTowersAdapter.j(RecentCellTowersActivity.RecentTowersAdapter.this, str, z3, z4, dialogInterface, i4);
                }
            });
            builder.create().show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(RecentTowersAdapter this$0, String cellTowerId, boolean z3, boolean z4, DialogInterface dialogInterface, int i4) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(cellTowerId, "$cellTowerId");
            if (i4 == 0) {
                this$0.g(cellTowerId, true);
            } else if (i4 == 1 && z3) {
                this$0.g(cellTowerId, false);
            } else {
                Database database = this$0.f9682b;
                Intrinsics.checkNotNull(database);
                database.setIgnoreCellTowerState(cellTowerId, !z4);
                this$0.f9681a.refresh();
            }
        }

        @Override // android.widget.Filterable
        @Nullable
        public Filter getFilter() {
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f9683c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        public final void setCellTowerRecordList(@NotNull List<? extends CellTowerRecord> cellTowerRecordList, @NotNull Set<String> ignoreCellTowerList) {
            Intrinsics.checkNotNullParameter(cellTowerRecordList, "cellTowerRecordList");
            Intrinsics.checkNotNullParameter(ignoreCellTowerList, "ignoreCellTowerList");
            this.f9683c = cellTowerRecordList;
            this.f9691k = ignoreCellTowerList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
            final boolean z3;
            Intrinsics.checkNotNullParameter(holder, "holder");
            final CellTowerRecord cellTowerRecord = this.f9683c.get(i4);
            holder.getTime().setText(this.f9684d.format(new Date(cellTowerRecord.timestamp)));
            holder.getCellTowerId().setText(cellTowerRecord.cellId);
            final boolean z4 = false;
            if (this.f9691k.contains(cellTowerRecord.cellId)) {
                TextView ignoredLabel = holder.getIgnoredLabel();
                String string = this.f9681a.getString(R.string.ignored);
                ignoredLabel.setText("(" + string + ")");
                holder.getIgnoredLabel().setVisibility(0);
                z3 = true;
            } else {
                holder.getIgnoredLabel().setVisibility(8);
                z3 = false;
            }
            holder.getTime().setTextColor(z3 ? this.f9686f : -1);
            holder.getCellTowerId().setTextColor(z3 ? this.f9686f : -1);
            holder.getFlowLayout().removeAllViews();
            if (this.f9685e.size() > 0) {
                for (final CellTowerGroup cellTowerGroup : this.f9685e) {
                    if (cellTowerGroup.contains(cellTowerRecord.cellId)) {
                        TextView textView = new TextView(this.f9681a);
                        textView.setText(cellTowerGroup.getName());
                        textView.setTextSize(12.0f);
                        textView.setTextColor(z3 ? this.f9686f : -1);
                        textView.setPaintFlags(textView.getPaintFlags() | 8);
                        int i5 = this.f9688h;
                        int i6 = this.f9689i;
                        textView.setPadding(i5, i6, i5, i6);
                        FlowLayout flowLayout = holder.getFlowLayout();
                        Intrinsics.checkNotNull(flowLayout);
                        flowLayout.addView(textView, -2, -2);
                        textView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.d0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                RecentCellTowersActivity.RecentTowersAdapter.e(RecentCellTowersActivity.RecentTowersAdapter.this, cellTowerGroup, view);
                            }
                        });
                        z4 = true;
                    }
                }
                if (!z4) {
                    TextView textView2 = new TextView(this.f9681a);
                    textView2.setText(this.f9690j);
                    textView2.setTextColor(z3 ? this.f9686f : -1);
                    textView2.setTextSize(12.0f);
                    int i7 = this.f9688h;
                    int i8 = this.f9689i;
                    textView2.setPadding(i7, i8, i7, i8);
                    holder.getFlowLayout().addView(textView2, -2, -2);
                }
            }
            holder.getCellTowerCard().setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RecentCellTowersActivity.RecentTowersAdapter.f(RecentCellTowersActivity.RecentTowersAdapter.this, cellTowerRecord, z4, z3, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_celltower_record, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…er_record, parent, false)");
            return new ViewHolder(this, inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecentCellTowersActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RecentCellTowersActivity.kt */
        /* renamed from: com.arlosoft.macrodroid.celltowers.RecentCellTowersActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0094a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Set<String> $ignoreCellTowerList;
            final /* synthetic */ List<CellTowerRecord> $recentCellTowerList;
            int label;
            final /* synthetic */ RecentCellTowersActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0094a(RecentCellTowersActivity recentCellTowersActivity, List<CellTowerRecord> list, Set<String> set, Continuation<? super C0094a> continuation) {
                super(2, continuation);
                this.this$0 = recentCellTowersActivity;
                this.$recentCellTowerList = list;
                this.$ignoreCellTowerList = set;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0094a(this.this$0, this.$recentCellTowerList, this.$ignoreCellTowerList, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.n(this.$recentCellTowerList.isEmpty());
                    RecentTowersAdapter recentTowersAdapter = this.this$0.f9680g;
                    RecentTowersAdapter recentTowersAdapter2 = null;
                    if (recentTowersAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        recentTowersAdapter = null;
                    }
                    List<CellTowerRecord> recentCellTowerList = this.$recentCellTowerList;
                    Intrinsics.checkNotNullExpressionValue(recentCellTowerList, "recentCellTowerList");
                    Set<String> ignoreCellTowerList = this.$ignoreCellTowerList;
                    Intrinsics.checkNotNullExpressionValue(ignoreCellTowerList, "ignoreCellTowerList");
                    recentTowersAdapter.setCellTowerRecordList(recentCellTowerList, ignoreCellTowerList);
                    RecentTowersAdapter recentTowersAdapter3 = this.this$0.f9680g;
                    if (recentTowersAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        recentTowersAdapter2 = recentTowersAdapter3;
                    }
                    recentTowersAdapter2.notifyDataSetChanged();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0094a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                Database database = RecentCellTowersActivity.this.f9679f;
                if (database == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("m_database");
                    database = null;
                }
                List<CellTowerRecord> latestCellTowerRecords = database.getLatestCellTowerRecords(System.currentTimeMillis() - 86400000);
                Database database2 = RecentCellTowersActivity.this.f9679f;
                if (database2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("m_database");
                    database2 = null;
                }
                Set<String> ignoreCellTowerSet = database2.getIgnoreCellTowerSet();
                Timber.e("********* TIME = " + (System.currentTimeMillis() - currentTimeMillis) + TranslateLanguage.MALAY, new Object[0]);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C0094a c0094a = new C0094a(RecentCellTowersActivity.this, latestCellTowerRecords, ignoreCellTowerSet, null);
                this.label = 1;
                if (BuildersKt.withContext(main, c0094a, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean z3) {
        getLoadingView().setVisibility(8);
        if (z3) {
            getEmptyView().setVisibility(0);
            getRecyclerView().setVisibility(8);
            return;
        }
        getEmptyView().setVisibility(8);
        getRecyclerView().setVisibility(0);
    }

    private final void o() {
        if (Settings.shouldHideInfoCardRecentTowers(this)) {
            getInfoCard().setVisibility(8);
            return;
        }
        getInfoCard().setCardBackgroundColor(ContextCompat.getColor(this, R.color.cell_towers_primary));
        getInfoCardTitle().setText(R.string.recent_towers);
        getInfoCardDetail().setText(R.string.recent_towers_info);
        getInfoCardGotit().setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecentCellTowersActivity.p(RecentCellTowersActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(RecentCellTowersActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Settings.hideInfoCardRecentTowers(this$0);
        this$0.getInfoCard().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refresh() {
        kotlinx.coroutines.e.e(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new a(null), 2, null);
    }

    @NotNull
    public final ViewGroup getEmptyView() {
        ViewGroup viewGroup = this.emptyView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
        return null;
    }

    @NotNull
    public final CardView getInfoCard() {
        CardView cardView = this.infoCard;
        if (cardView != null) {
            return cardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoCard");
        return null;
    }

    @NotNull
    public final TextView getInfoCardDetail() {
        TextView textView = this.infoCardDetail;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoCardDetail");
        return null;
    }

    @NotNull
    public final Button getInfoCardGotit() {
        Button button = this.infoCardGotit;
        if (button != null) {
            return button;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoCardGotit");
        return null;
    }

    @NotNull
    public final TextView getInfoCardTitle() {
        TextView textView = this.infoCardTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("infoCardTitle");
        return null;
    }

    @NotNull
    public final ViewGroup getLoadingView() {
        ViewGroup viewGroup = this.loadingView;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        return null;
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        List emptyList;
        Set emptySet;
        super.onCreate(bundle);
        setContentView(R.layout.activity_recent_cell_towers);
        ButterKnife.bind(this);
        Database database = Database.getInstance();
        Intrinsics.checkNotNullExpressionValue(database, "getInstance()");
        this.f9679f = database;
        getRecyclerView().setLayoutManager(new LinearLayoutManager(this));
        Database database2 = this.f9679f;
        RecentTowersAdapter recentTowersAdapter = null;
        if (database2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("m_database");
            database2 = null;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptySet = kotlin.collections.y.emptySet();
        this.f9680g = new RecentTowersAdapter(this, database2, emptyList, emptySet);
        RecyclerView recyclerView = getRecyclerView();
        RecentTowersAdapter recentTowersAdapter2 = this.f9680g;
        if (recentTowersAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            recentTowersAdapter = recentTowersAdapter2;
        }
        recyclerView.setAdapter(recentTowersAdapter);
        EventBusUtils.getEventBus().register(this);
        o();
        refresh();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        super.onDestroy();
    }

    public final void onEventMainThread(@Nullable LogUpdateEvent logUpdateEvent) {
        refresh();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return true;
    }

    public final void setEmptyView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.emptyView = viewGroup;
    }

    public final void setInfoCard(@NotNull CardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "<set-?>");
        this.infoCard = cardView;
    }

    public final void setInfoCardDetail(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.infoCardDetail = textView;
    }

    public final void setInfoCardGotit(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "<set-?>");
        this.infoCardGotit = button;
    }

    public final void setInfoCardTitle(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.infoCardTitle = textView;
    }

    public final void setLoadingView(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.loadingView = viewGroup;
    }

    public final void setRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }
}
