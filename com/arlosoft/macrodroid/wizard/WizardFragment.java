package com.arlosoft.macrodroid.wizard;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EdgeEffect;
import android.widget.Filter;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.events.CategoryModeUpdateEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.FilterEvent;
import com.arlosoft.macrodroid.events.MacroUpdateEvent;
import com.arlosoft.macrodroid.events.SetHelpVisibilityEvent;
import com.arlosoft.macrodroid.events.WizardScrollToTopEvent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.ChosenItemsListItem;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemBlank;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemCategoryHeader;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemInfoCard;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemListItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import com.arlosoft.macrodroid.triggers.info.AndroidWearTriggerInfo;
import com.arlosoft.macrodroid.triggers.info.WidgetPressedTriggerInfo;
import com.arlosoft.macrodroid.utils.ColorUtils;
import com.arlosoft.macrodroid.utils.StyleUtils;
import com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard;
import com.arlosoft.macrodroid.wizard.WizardFragment;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WizardFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class WizardFragment extends Fragment implements SelectableItemChosenListener, SelectableItemListItem.OptionsProvider {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private FlexibleAdapter<IFlexible<?>> f16534b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private WizardItemAdapter f16535c;

    /* renamed from: d  reason: collision with root package name */
    private int f16536d;

    /* renamed from: e  reason: collision with root package name */
    private Macro f16537e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private List<IFlexible<?>> f16538f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f16539g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private SelectableItem f16540h;

    /* renamed from: i  reason: collision with root package name */
    private List<SelectableItemInfo> f16541i;

    /* renamed from: j  reason: collision with root package name */
    private ChosenItemsListItem f16542j;
    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: WizardFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WizardFragment newInstance(int i4) {
            WizardFragment wizardFragment = new WizardFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("itemType", i4);
            wizardFragment.setArguments(bundle);
            return wizardFragment;
        }
    }

    private final void f() {
        Macro macro;
        List<SelectableItemInfo> list;
        if (Settings.getShowCategoriesSelectableItems(getActivity())) {
            this.f16535c = null;
            l();
        } else {
            this.f16534b = null;
            FragmentActivity activity = getActivity();
            Macro macro2 = this.f16537e;
            if (macro2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            } else {
                macro = macro2;
            }
            boolean z3 = !AddSelectableItemInfoCard.shouldHideInfoCard(getActivity(), this.f16536d);
            int i4 = this.f16536d;
            List<SelectableItemInfo> list2 = this.f16541i;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectableItemList");
                list = null;
            } else {
                list = list2;
            }
            this.f16535c = new WizardItemAdapter(activity, macro, z3, i4, list, this);
            getRecyclerView().setAdapter(this.f16535c);
            getRecyclerView().setHasFixedSize(false);
            getRecyclerView().setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        j();
    }

    private final List<SelectableItemCategory> g() {
        int i4 = this.f16536d;
        if (i4 != 0) {
            Macro macro = null;
            if (i4 != 1) {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                Context applicationContext = activity.getApplicationContext();
                Macro macro2 = this.f16537e;
                if (macro2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro2;
                }
                List<SelectableItemCategory> categories = Constraint.getCategories(applicationContext, macro, true);
                Intrinsics.checkNotNullExpressionValue(categories, "getCategories(activity!!…ationContext, macro,true)");
                return categories;
            }
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            Context applicationContext2 = activity2.getApplicationContext();
            Macro macro3 = this.f16537e;
            if (macro3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro = macro3;
            }
            List<SelectableItemCategory> categories2 = Action.getCategories(applicationContext2, macro, false, true);
            Intrinsics.checkNotNullExpressionValue(categories2, "getCategories(activity!!…text, macro, false, true)");
            return categories2;
        }
        FragmentActivity activity3 = getActivity();
        Intrinsics.checkNotNull(activity3);
        List<SelectableItemCategory> categories3 = Trigger.getCategories(activity3.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(categories3, "getCategories(activity!!.applicationContext)");
        return categories3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(WizardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getRecyclerView().smoothScrollToPosition(0);
    }

    private final void i(List<? extends SelectableItem> list, boolean z3) {
        if (z3) {
            Iterator<? extends SelectableItem> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof WidgetPressedTrigger) {
                    l();
                    break;
                }
            }
        }
        ChosenItemsListItem chosenItemsListItem = this.f16542j;
        if (chosenItemsListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chosenItemsListItem");
            chosenItemsListItem = null;
        }
        chosenItemsListItem.updateChosenItems(list);
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = this.f16534b;
        if (flexibleAdapter != null) {
            Intrinsics.checkNotNull(flexibleAdapter);
            flexibleAdapter.notifyItemRangeChanged(0, flexibleAdapter.getItemCount());
        }
    }

    private final void j() {
        WizardItemAdapter wizardItemAdapter;
        Macro macro = null;
        if (Settings.getShowCategoriesSelectableItems(getActivity())) {
            int i4 = this.f16536d;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        Macro macro2 = this.f16537e;
                        if (macro2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("macro");
                        } else {
                            macro = macro2;
                        }
                        List<Constraint> constraints = macro.getConstraints();
                        Intrinsics.checkNotNullExpressionValue(constraints, "macro.constraints");
                        i(constraints, false);
                        return;
                    }
                    return;
                }
                Macro macro3 = this.f16537e;
                if (macro3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro3;
                }
                ArrayList<Action> actions = macro.getActions();
                Intrinsics.checkNotNullExpressionValue(actions, "macro.actions");
                i(actions, false);
                return;
            }
            Macro macro4 = this.f16537e;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro = macro4;
            }
            ArrayList<Trigger> triggerList = macro.getTriggerList();
            Intrinsics.checkNotNullExpressionValue(triggerList, "macro.triggerList");
            i(triggerList, true);
            return;
        }
        int i5 = this.f16536d;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2 && (wizardItemAdapter = this.f16535c) != null) {
                    List<SelectableItemInfo> list = this.f16541i;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selectableItemList");
                        list = null;
                    }
                    Macro macro5 = this.f16537e;
                    if (macro5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("macro");
                    } else {
                        macro = macro5;
                    }
                    wizardItemAdapter.refresh(list, macro.getConstraints());
                    return;
                }
                return;
            }
            WizardItemAdapter wizardItemAdapter2 = this.f16535c;
            if (wizardItemAdapter2 != null) {
                List<SelectableItemInfo> list2 = this.f16541i;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectableItemList");
                    list2 = null;
                }
                Macro macro6 = this.f16537e;
                if (macro6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro = macro6;
                }
                wizardItemAdapter2.refresh(list2, macro.getActions());
                return;
            }
            return;
        }
        WizardItemAdapter wizardItemAdapter3 = this.f16535c;
        if (wizardItemAdapter3 != null) {
            List<SelectableItemInfo> list3 = this.f16541i;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectableItemList");
                list3 = null;
            }
            Macro macro7 = this.f16537e;
            if (macro7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
            } else {
                macro = macro7;
            }
            wizardItemAdapter3.refresh(list3, macro.getTriggerList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i4) {
        dialogInterface.cancel();
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v2 */
    private final void l() {
        boolean z3;
        getRecyclerView().setLayoutManager(new MacroDroidSmoothScrollStaggeredLayoutManager(getActivity(), 2));
        this.f16538f = new ArrayList();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        Macro macro = this.f16537e;
        String str = "macro";
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        ChosenItemsListItem chosenItemsListItem = new ChosenItemsListItem(activity, macro, this.f16536d);
        this.f16542j = chosenItemsListItem;
        List<IFlexible<?>> list = this.f16538f;
        ?? r13 = 0;
        if (list != null) {
            list.add(0, chosenItemsListItem);
        }
        if (!AddSelectableItemInfoCard.shouldHideInfoCard(getActivity(), this.f16536d)) {
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            SelectableItemInfoCard selectableItemInfoCard = new SelectableItemInfoCard(activity2, this.f16536d, false, new AddSelectableItemInfoCard.InfoCardDismissedListener() { // from class: w0.k
                @Override // com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard.InfoCardDismissedListener
                public final void onDismissed() {
                    WizardFragment.m(WizardFragment.this);
                }
            }, true);
            List<IFlexible<?>> list2 = this.f16538f;
            if (list2 != null) {
                list2.add(0, selectableItemInfoCard);
            }
        }
        List<SelectableItemCategory> o4 = o(g());
        int i4 = 0;
        int i5 = 0;
        for (SelectableItemCategory selectableItemCategory : o4) {
            int i6 = i4 + 1;
            SelectableItemCategoryHeader selectableItemCategoryHeader = new SelectableItemCategoryHeader(selectableItemCategory, i4, selectableItemCategory.getItems().get(r13).getCategoryColor());
            selectableItemCategoryHeader.setExpanded(r13);
            List<IFlexible<?>> list3 = this.f16538f;
            if (list3 != null) {
                list3.add(selectableItemCategoryHeader);
            }
            int i7 = i6;
            for (SelectableItemInfo selectableItemInfo : selectableItemCategory.getItems()) {
                if (selectableItemInfo instanceof WidgetPressedTriggerInfo) {
                    Macro macro2 = this.f16537e;
                    if (macro2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                        macro2 = null;
                    }
                    Iterator<Trigger> it = macro2.getTriggerList().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        Intrinsics.checkNotNullExpressionValue(next, "macro.triggerList");
                        if (next instanceof WidgetPressedTrigger) {
                            z3 = false;
                            break;
                        }
                    }
                }
                z3 = true;
                if (selectableItemInfo instanceof AndroidWearTriggerInfo) {
                    Macro macro3 = this.f16537e;
                    if (macro3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                        macro3 = null;
                    }
                    Iterator<Trigger> it2 = macro3.getTriggerList().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Trigger next2 = it2.next();
                        Intrinsics.checkNotNullExpressionValue(next2, "macro.triggerList");
                        if (next2 instanceof AndroidWearTriggerInfo) {
                            z3 = false;
                            break;
                        }
                    }
                }
                if (z3) {
                    FragmentActivity activity3 = getActivity();
                    Intrinsics.checkNotNull(activity3);
                    SelectableItemCategoryHeader selectableItemCategoryHeader2 = selectableItemCategoryHeader;
                    SelectableItemListItem selectableItemListItem = new SelectableItemListItem(activity3, selectableItemCategoryHeader, i7, selectableItemInfo, this, this, false, 64, null);
                    selectableItemListItem.setHeader(selectableItemCategoryHeader2);
                    selectableItemCategoryHeader2.addSubItem(selectableItemListItem);
                    selectableItemCategoryHeader = selectableItemCategoryHeader2;
                    i7++;
                    str = str;
                }
            }
            SelectableItemCategoryHeader selectableItemCategoryHeader3 = selectableItemCategoryHeader;
            String str2 = str;
            int i8 = i5 + 1;
            if (i8 == o4.size()) {
                selectableItemCategoryHeader3.addSubItem(new SelectableItemBlank(selectableItemCategoryHeader3));
            }
            i5 = i8;
            i4 = i7;
            str = str2;
            r13 = 0;
        }
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = new FlexibleAdapter<>(this.f16538f, null, true);
        this.f16534b = flexibleAdapter;
        flexibleAdapter.addListener(new FlexibleAdapter.OnItemClickListener() { // from class: w0.l
            @Override // eu.davidea.flexibleadapter.FlexibleAdapter.OnItemClickListener
            public final boolean onItemClick(View view, int i9) {
                boolean n4;
                n4 = WizardFragment.n(view, i9);
                return n4;
            }
        });
        FlexibleAdapter<IFlexible<?>> flexibleAdapter2 = this.f16534b;
        if (flexibleAdapter2 != null) {
            flexibleAdapter2.setAnimateToLimit(Integer.MAX_VALUE);
        }
        FlexibleAdapter<IFlexible<?>> flexibleAdapter3 = this.f16534b;
        if (flexibleAdapter3 != null) {
            flexibleAdapter3.setAutoScrollOnExpand(true);
        }
        getRecyclerView().setAdapter(this.f16534b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(WizardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<IFlexible<?>> list = this$0.f16538f;
        if (list != null) {
            list.remove(0);
        }
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = this$0.f16534b;
        if (flexibleAdapter != null) {
            flexibleAdapter.removeItem(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(View view, int i4) {
        return false;
    }

    private final List<SelectableItemCategory> o(List<? extends SelectableItemCategory> list) {
        List<SelectableItemCategory> sorted;
        List<SelectableItemInfo> sortedWith;
        sorted = CollectionsKt___CollectionsKt.sorted(list);
        for (SelectableItemCategory selectableItemCategory : sorted) {
            List<SelectableItemInfo> items = selectableItemCategory.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "cat.items");
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(items, new Comparator() { // from class: com.arlosoft.macrodroid.wizard.WizardFragment$sortCategories$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = f.compareValues(WizardFragment.this.getString(((SelectableItemInfo) t3).getName()), WizardFragment.this.getString(((SelectableItemInfo) t4).getName()));
                    return compareValues;
                }
            });
            selectableItemCategory.setItems(sortedWith);
        }
        return sorted;
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.SelectableItemListItem.OptionsProvider
    public boolean getHelpEnabled() {
        return this.f16539g;
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

    public final void handleActivityResult(int i4, int i5, @Nullable Intent intent) {
        SelectableItem selectableItem = this.f16540h;
        if (selectableItem != null) {
            selectableItem.handleActivityResult(getActivity(), i4, i5, intent);
        }
    }

    public final void itemCancelled() {
        SelectableItem selectableItem = this.f16540h;
        if (selectableItem != null) {
            selectableItem.handleItemCancel();
        }
    }

    public final void itemComplete(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        SelectableItem selectableItem = this.f16540h;
        if (selectableItem != null) {
            selectableItem.handleItemComplete(obj);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        List<SelectableItemInfo> allTriggersInfo;
        Context context;
        Context context2;
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.arlosoft.macrodroid.wizard.WizardActivity");
        Macro macro = ((WizardActivity) activity).getMacro();
        Intrinsics.checkNotNullExpressionValue(macro, "activity as WizardActivity).macro");
        this.f16537e = macro;
        Bundle arguments = getArguments();
        Intrinsics.checkNotNull(arguments);
        int i4 = arguments.getInt("itemType");
        this.f16536d = i4;
        Context context3 = null;
        Macro macro2 = null;
        Macro macro3 = null;
        if (i4 != 0) {
            if (i4 != 1) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    context2 = activity2.getApplicationContext();
                } else {
                    context2 = null;
                }
                Macro macro4 = this.f16537e;
                if (macro4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro2 = macro4;
                }
                allTriggersInfo = Constraint.getAllConstraintsInfo(context2, macro2, true);
                Intrinsics.checkNotNullExpressionValue(allTriggersInfo, "getAllConstraintsInfo(ac…tionContext, macro, true)");
            } else {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    context = activity3.getApplicationContext();
                } else {
                    context = null;
                }
                Macro macro5 = this.f16537e;
                if (macro5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("macro");
                } else {
                    macro3 = macro5;
                }
                allTriggersInfo = Action.getAllActionsInfo(context, macro3, false);
                Intrinsics.checkNotNullExpressionValue(allTriggersInfo, "getAllActionsInfo(activi…ionContext, macro, false)");
            }
        } else {
            FragmentActivity activity4 = getActivity();
            if (activity4 != null) {
                context3 = activity4.getApplicationContext();
            }
            allTriggersInfo = Trigger.getAllTriggersInfo(context3);
            Intrinsics.checkNotNullExpressionValue(allTriggersInfo, "getAllTriggersInfo(activity?.applicationContext)");
        }
        this.f16541i = allTriggersInfo;
        f();
        j();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        EventBusUtils.getEventBus().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_wizard, viewGroup, false);
        ButterKnife.bind(this, inflate);
        ViewCompat.setNestedScrollingEnabled(getRecyclerView(), false);
        getRecyclerView().setEdgeEffectFactory(new RecyclerView.EdgeEffectFactory() { // from class: com.arlosoft.macrodroid.wizard.WizardFragment$onCreateView$1
            @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
            @NotNull
            protected EdgeEffect createEdgeEffect(@NotNull RecyclerView view, int i4) {
                int i5;
                Intrinsics.checkNotNullParameter(view, "view");
                EdgeEffect edgeEffect = new EdgeEffect(view.getContext());
                WizardFragment wizardFragment = WizardFragment.this;
                Context requireContext = wizardFragment.requireContext();
                i5 = wizardFragment.f16536d;
                edgeEffect.setColor(ContextCompat.getColor(requireContext, ColorUtils.getDarkSelectableItemColor(i5)));
                return edgeEffect;
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBusUtils.getEventBus().unregister(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f16535c = null;
    }

    public final void onEventMainThread(@NotNull MacroUpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.itemType == this.f16536d) {
            j();
        }
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener
    public void selectableItemChosen(@NotNull SelectableItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        FragmentActivity activity = getActivity();
        Macro macro = this.f16537e;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        SelectableItem constructItem = itemInfo.constructItem(activity, macro);
        this.f16540h = constructItem;
        if (constructItem != null) {
            constructItem.onItemSelected();
        }
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener
    public void selectableItemHelpChosen(@NotNull SelectableItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, StyleUtils.getAlertDialogStyle(this.f16536d));
        builder.setTitle(itemInfo.getName());
        if (itemInfo.supportsAdbHack()) {
            builder.setMessage(Util.appendAdbHackInfo(getActivity(), getString(itemInfo.getHelpInfo())));
        } else {
            builder.setMessage(itemInfo.getHelpInfo());
        }
        builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() { // from class: w0.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                WizardFragment.k(dialogInterface, i4);
            }
        });
        Util.linkifyDialogText(builder.show());
    }

    public void setHelpEnabled(boolean z3) {
        this.f16539g = z3;
    }

    public final void setRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    public final void onEventMainThread(@NotNull WizardScrollToTopEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.itemType == this.f16536d) {
            getRecyclerView().post(new Runnable() { // from class: w0.n
                @Override // java.lang.Runnable
                public final void run() {
                    WizardFragment.h(WizardFragment.this);
                }
            });
        }
    }

    public final void onEventMainThread(@NotNull CategoryModeUpdateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        f();
    }

    public final void onEventMainThread(@NotNull FilterEvent event) {
        Filter filter;
        Intrinsics.checkNotNullParameter(event, "event");
        WizardItemAdapter wizardItemAdapter = this.f16535c;
        if (wizardItemAdapter != null && (filter = wizardItemAdapter.getFilter()) != null) {
            filter.filter(event.filterText);
        }
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = this.f16534b;
        boolean z3 = false;
        if (flexibleAdapter != null && flexibleAdapter.hasNewFilter(event.filterText)) {
            z3 = true;
        }
        if (z3) {
            FlexibleAdapter<IFlexible<?>> flexibleAdapter2 = this.f16534b;
            if (flexibleAdapter2 != null) {
                flexibleAdapter2.setFilter(event.filterText);
            }
            FlexibleAdapter<IFlexible<?>> flexibleAdapter3 = this.f16534b;
            if (flexibleAdapter3 != null) {
                List<IFlexible<?>> list = this.f16538f;
                Intrinsics.checkNotNull(list);
                flexibleAdapter3.filterItems(list);
            }
        }
    }

    public final void onEventMainThread(@NotNull SetHelpVisibilityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        setHelpEnabled(!getHelpEnabled());
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = this.f16534b;
        if (flexibleAdapter != null) {
            flexibleAdapter.notifyDataSetChanged();
        }
        WizardItemAdapter wizardItemAdapter = this.f16535c;
        if (wizardItemAdapter != null) {
            wizardItemAdapter.toggleHelp();
        }
    }
}
