package com.arlosoft.macrodroid.logging.systemlog.macrofilter;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.SerialCalculator;
import com.arlosoft.macrodroid.databinding.ActivityMacroLogFilterBinding;
import com.arlosoft.macrodroid.logging.systemlog.LogFilter;
import com.arlosoft.macrodroid.logging.systemlog.MacroMovementMethod;
import com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterCategoryHeader;
import com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterListItem;
import com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroLogFilterActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macrolist.HeadingColorMapper;
import com.arlosoft.macrodroid.settings.Settings;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.IHeader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f;
import kotlin.collections.h;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroLogFilterActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroLogFilterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroLogFilterActivity.kt\ncom/arlosoft/macrodroid/logging/systemlog/macrofilter/MacroLogFilterActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,351:1\n262#2,2:352\n766#3:354\n857#3,2:355\n1549#3:357\n1620#3,3:358\n1549#3:361\n1620#3,3:362\n*S KotlinDebug\n*F\n+ 1 MacroLogFilterActivity.kt\ncom/arlosoft/macrodroid/logging/systemlog/macrofilter/MacroLogFilterActivity\n*L\n132#1:352,2\n148#1:354\n148#1:355,2\n148#1:357\n148#1:358,3\n289#1:361\n289#1:362,3\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroLogFilterActivity extends MacroDroidDaggerBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityMacroLogFilterBinding f12770f;
    @Inject
    public HeadingColorMapper headingColorMapper;

    /* renamed from: i  reason: collision with root package name */
    private FlexibleAdapter<MacroFilterCategoryHeader> f12773i;

    /* renamed from: j  reason: collision with root package name */
    private MenuItem f12774j;

    /* renamed from: k  reason: collision with root package name */
    private MenuItem f12775k;

    /* renamed from: o  reason: collision with root package name */
    private CategoryList f12779o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12780p;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final MacroMovementMethod f12771g = new MacroMovementMethod(this);
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private String f12772h = "";
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final HashSet<String> f12776l = new HashSet<>();
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final HashSet<String> f12777m = new HashSet<>();

    /* renamed from: n  reason: collision with root package name */
    private boolean f12778n = true;

    private final void A() {
        LogFilter systemLogFilter;
        boolean z3;
        int i4;
        int i5;
        Macro next;
        boolean z4 = false;
        if (Settings.getSystemLogFilter(this).getDisabledMacroIds().size() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f12780p = z3;
        CategoryList categoryList = null;
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter = new FlexibleAdapter<>(new ArrayList(), null, true);
        this.f12773i = flexibleAdapter;
        flexibleAdapter.addListener(new FlexibleAdapter.OnItemClickListener() { // from class: c0.f
            @Override // eu.davidea.flexibleadapter.FlexibleAdapter.OnItemClickListener
            public final boolean onItemClick(View view, int i6) {
                boolean B;
                B = MacroLogFilterActivity.B(view, i6);
                return B;
            }
        });
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter2 = this.f12773i;
        if (flexibleAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter2 = null;
        }
        flexibleAdapter2.setAnimateToLimit(Integer.MAX_VALUE);
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter3 = this.f12773i;
        if (flexibleAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter3 = null;
        }
        flexibleAdapter3.setAutoScrollOnExpand(false);
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding = this.f12770f;
        if (activityMacroLogFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacroLogFilterBinding = null;
        }
        activityMacroLogFilterBinding.recyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding2 = this.f12770f;
        if (activityMacroLogFilterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacroLogFilterBinding2 = null;
        }
        RecyclerView recyclerView = activityMacroLogFilterBinding2.recyclerView;
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter4 = this.f12773i;
        if (flexibleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter4 = null;
        }
        recyclerView.setAdapter(flexibleAdapter4);
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding3 = this.f12770f;
        if (activityMacroLogFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacroLogFilterBinding3 = null;
        }
        activityMacroLogFilterBinding3.recyclerView.setHasFixedSize(true);
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding4 = this.f12770f;
        if (activityMacroLogFilterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacroLogFilterBinding4 = null;
        }
        activityMacroLogFilterBinding4.recyclerView.addItemDecoration(new FlexibleItemDecoration(this).addItemViewType(R.layout.macro_list_row, 0, 3, 0, 0).withEdge(true).withBottomEdge(false).withSectionGapOffset(0));
        HashMap<String, List<Macro>> categoryMap = MacroStore.getInstance().getCategoryMap();
        ArrayList arrayList = new ArrayList();
        final Collator collator = Collator.getInstance(Settings.getLocale(this));
        collator.setStrength(0);
        ArrayList arrayList2 = new ArrayList(categoryMap.keySet());
        h.sortWith(arrayList2, new Comparator() { // from class: c0.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int C;
                C = MacroLogFilterActivity.C(collator, (String) obj, (String) obj2);
                return C;
            }
        });
        CategoryList categoryList2 = (CategoryList) MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE).get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList2 == null) {
            categoryList2 = new CategoryList(new ArrayList());
        }
        this.f12779o = categoryList2;
        Iterator it = arrayList2.iterator();
        int i6 = 0;
        int i7 = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        int i8 = 0;
        while (it.hasNext()) {
            String categoryName = (String) it.next();
            CategoryList categoryList3 = this.f12779o;
            if (categoryList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryList");
                categoryList3 = categoryList;
            }
            Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
            Category categoryByName = categoryList3.getCategoryByName(categoryName);
            if (categoryByName == null) {
                categoryByName = new Category(categoryName, ContextCompat.getColor(this, R.color.default_macro_tile_color), z4, z4);
            }
            int i9 = i7 + 1;
            MacroFilterCategoryHeader macroFilterCategoryHeader = new MacroFilterCategoryHeader(categoryByName, i7, true, false, false, new MacroFilterCategoryHeader.OnCategoryClickedListener() { // from class: c0.h
                @Override // com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterCategoryHeader.OnCategoryClickedListener
                public final void onClick(MacroFilterCategoryHeader macroFilterCategoryHeader2) {
                    MacroLogFilterActivity.D(MacroLogFilterActivity.this, macroFilterCategoryHeader2);
                }
            }, null, getHeadingColorMapper());
            List<Macro> list = categoryMap.get(categoryName);
            if (list != null) {
                h.sortWith(list, new Comparator() { // from class: c0.i
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int E;
                        E = MacroLogFilterActivity.E(collator, (Macro) obj, (Macro) obj2);
                        return E;
                    }
                });
            }
            Intrinsics.checkNotNull(list);
            Iterator<Macro> it2 = list.iterator();
            while (true) {
                i5 = i8;
                if (!it2.hasNext()) {
                    break;
                }
                i8 = i5 + 1;
                macroFilterCategoryHeader.addSubItem(new MacroFilterListItem(macroFilterCategoryHeader, i5, it2.next(), !systemLogFilter.getDisabledMacroIds().contains(Long.valueOf(next.getGUID())), new MacroFilterListItem.OnFilterChangeListener() { // from class: c0.j
                    @Override // com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterListItem.OnFilterChangeListener
                    public final void filterStateChanged(Long l4, boolean z5) {
                        MacroLogFilterActivity.F(MacroLogFilterActivity.this, l4, z5);
                    }
                }));
                i6++;
            }
            if (macroFilterCategoryHeader.getSubItemsCount() > 0) {
                arrayList.add(macroFilterCategoryHeader);
            }
            i8 = i5;
            i7 = i9;
            z4 = false;
            categoryList = null;
        }
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter5 = this.f12773i;
        if (flexibleAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter5 = null;
        }
        flexibleAdapter5.updateDataSet(arrayList);
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding5 = this.f12770f;
        if (activityMacroLogFilterBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMacroLogFilterBinding5 = null;
        }
        LinearLayout linearLayout = activityMacroLogFilterBinding5.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        if (arrayList.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
        if (i6 < 6) {
            this.f12778n = false;
        }
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter6 = this.f12773i;
        if (flexibleAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter6 = null;
        }
        for (IHeader iHeader : flexibleAdapter6.getHeaderItems()) {
            if ((iHeader instanceof MacroFilterCategoryHeader) && !((MacroFilterCategoryHeader) iHeader).category().isLocked()) {
                FlexibleAdapter flexibleAdapter7 = this.f12773i;
                if (flexibleAdapter7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    flexibleAdapter7 = null;
                }
                flexibleAdapter7.expand((FlexibleAdapter) iHeader);
            } else {
                FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter8 = this.f12773i;
                if (flexibleAdapter8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    flexibleAdapter8 = null;
                }
                FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter9 = this.f12773i;
                if (flexibleAdapter9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    flexibleAdapter9 = null;
                }
                flexibleAdapter8.collapse(flexibleAdapter9.getGlobalPositionOf(iHeader));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(View view, int i4) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C(Collator collator, String str, String str2) {
        return collator.compare(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(MacroLogFilterActivity this$0, MacroFilterCategoryHeader it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.z(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E(Collator collator, Macro macro, Macro macro2) {
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MacroLogFilterActivity this$0, Long id, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(id, "id");
        this$0.G(id.longValue(), z3);
    }

    private final void G(long j4, boolean z3) {
        List mutableList;
        List plus;
        List mutableList2;
        LogFilter logFilter = Settings.getSystemLogFilter(this);
        if (z3) {
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) logFilter.getDisabledMacroIds());
            plus = CollectionsKt___CollectionsKt.minus(mutableList2, Long.valueOf(j4));
        } else {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) logFilter.getDisabledMacroIds());
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends Long>) ((Collection<? extends Object>) mutableList), Long.valueOf(j4));
        }
        Intrinsics.checkNotNullExpressionValue(logFilter, "logFilter");
        Settings.setSystemLogFilter(this, LogFilter.copy$default(logFilter, 0, false, false, false, plus, null, 47, null));
    }

    private final void H(String str, final String str2, final int i4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
        Button button = (Button) inflate.findViewById(R.id.okButton);
        Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
        builder.setTitle(str);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "alert.create()");
        Window window = create.getWindow();
        if (window != null) {
            window.clearFlags(131080);
        }
        Window window2 = create.getWindow();
        if (window2 != null) {
            window2.setSoftInputMode(5);
        }
        create.show();
        button.setOnClickListener(new View.OnClickListener() { // from class: c0.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroLogFilterActivity.I(MacroLogFilterActivity.this, editText, str2, i4, create, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: c0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroLogFilterActivity.J(create, view);
            }
        });
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(MacroLogFilterActivity this$0, EditText editText, String str, int i4, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (Intrinsics.areEqual(this$0.y(editText.getText().toString()), str)) {
            FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter = this$0.f12773i;
            if (flexibleAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter = null;
            }
            flexibleAdapter.expand(i4);
            dialog.dismiss();
            return;
        }
        ToastCompat.makeText(this$0, (int) R.string.invalid_password, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    private final void K(boolean z3) {
        List emptyList;
        int collectionSizeOrDefault;
        LogFilter systemLogFilter = Settings.getSystemLogFilter(this);
        Intrinsics.checkNotNullExpressionValue(systemLogFilter, "getSystemLogFilter(this)");
        LogFilter copy$default = LogFilter.copy$default(systemLogFilter, 0, false, false, false, null, null, 63, null);
        if (!z3) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            Settings.setSystemLogFilter(this, LogFilter.copy$default(copy$default, 0, false, false, false, emptyList, null, 47, null));
        } else {
            List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
            Intrinsics.checkNotNullExpressionValue(allCompletedMacros, "getInstance().allCompletedMacros");
            List<Macro> list = allCompletedMacros;
            collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Macro macro : list) {
                arrayList.add(Long.valueOf(macro.getGUID()));
            }
            Settings.setSystemLogFilter(this, LogFilter.copy$default(copy$default, 0, false, false, false, arrayList, null, 47, null));
        }
        L();
    }

    private final void L() {
        boolean z3;
        int collectionSizeOrDefault;
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter;
        boolean z4;
        Category copy$default;
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter2 = this.f12773i;
        if (flexibleAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter2 = null;
        }
        List<IHeader> headerItems = flexibleAdapter2.getHeaderItems();
        Intrinsics.checkNotNullExpressionValue(headerItems, "adapter.headerItems");
        ArrayList<IHeader> arrayList = new ArrayList();
        Iterator<T> it = headerItems.iterator();
        while (true) {
            boolean z5 = true;
            z3 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            IHeader iHeader = (IHeader) next;
            if (((iHeader instanceof MacroFilterCategoryHeader) && ((MacroFilterCategoryHeader) iHeader).isExpanded()) ? false : false) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = f.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (IHeader iHeader2 : arrayList) {
            Intrinsics.checkNotNull(iHeader2, "null cannot be cast to non-null type com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterCategoryHeader");
            arrayList2.add(((MacroFilterCategoryHeader) iHeader2).category().getName());
        }
        LogFilter systemLogFilter = Settings.getSystemLogFilter(this);
        HashMap<String, List<Macro>> categoryMap = MacroStore.getInstance().getCategoryMap();
        ArrayList arrayList3 = new ArrayList();
        final Collator collator = Collator.getInstance(Settings.getLocale(this));
        collator.setStrength(0);
        ArrayList arrayList4 = new ArrayList(categoryMap.keySet());
        h.sortWith(arrayList4, new Comparator() { // from class: c0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int N;
                N = MacroLogFilterActivity.N(collator, (String) obj, (String) obj2);
                return N;
            }
        });
        CategoryList categoryList = (CategoryList) MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE).get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList == null) {
            categoryList = new CategoryList(new ArrayList());
        }
        this.f12779o = categoryList;
        Iterator it2 = arrayList4.iterator();
        int i4 = 0;
        int i5 = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        while (it2.hasNext()) {
            String categoryName = (String) it2.next();
            CategoryList categoryList2 = this.f12779o;
            if (categoryList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryList");
                categoryList2 = null;
            }
            Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
            Category categoryByName = categoryList2.getCategoryByName(categoryName);
            boolean contains = arrayList2.contains(categoryName);
            if (categoryByName == null) {
                copy$default = new Category(categoryName, ContextCompat.getColor(this, R.color.default_macro_tile_color), contains, z3);
            } else {
                copy$default = Category.copy$default(categoryByName, null, 0, contains, false, 11, null);
            }
            int i6 = i5 + 1;
            MacroFilterCategoryHeader macroFilterCategoryHeader = new MacroFilterCategoryHeader(copy$default, i5, true, false, false, new MacroFilterCategoryHeader.OnCategoryClickedListener() { // from class: c0.c
                @Override // com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterCategoryHeader.OnCategoryClickedListener
                public final void onClick(MacroFilterCategoryHeader macroFilterCategoryHeader2) {
                    MacroLogFilterActivity.O(MacroLogFilterActivity.this, macroFilterCategoryHeader2);
                }
            }, null, getHeadingColorMapper());
            List<Macro> list = categoryMap.get(categoryName);
            if (list != null) {
                h.sortWith(list, new Comparator() { // from class: c0.d
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int P;
                        P = MacroLogFilterActivity.P(collator, (Macro) obj, (Macro) obj2);
                        return P;
                    }
                });
            }
            Intrinsics.checkNotNull(list);
            int i7 = i4;
            for (Macro macro : list) {
                macroFilterCategoryHeader.addSubItem(new MacroFilterListItem(macroFilterCategoryHeader, i7, macro, !systemLogFilter.getDisabledMacroIds().contains(Long.valueOf(macro.getGUID())), new MacroFilterListItem.OnFilterChangeListener() { // from class: c0.e
                    @Override // com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroFilterListItem.OnFilterChangeListener
                    public final void filterStateChanged(Long l4, boolean z6) {
                        MacroLogFilterActivity.M(MacroLogFilterActivity.this, l4, z6);
                    }
                }));
                i7++;
            }
            if (macroFilterCategoryHeader.getSubItemsCount() > 0) {
                arrayList3.add(macroFilterCategoryHeader);
            }
            i4 = i7;
            i5 = i6;
            z3 = false;
        }
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter3 = this.f12773i;
        if (flexibleAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            z4 = false;
            flexibleAdapter = null;
        } else {
            flexibleAdapter = flexibleAdapter3;
            z4 = false;
        }
        flexibleAdapter.updateDataSet(arrayList3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(MacroLogFilterActivity this$0, Long id, boolean z3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(id, "id");
        this$0.G(id.longValue(), z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int N(Collator collator, String str, String str2) {
        return collator.compare(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(MacroLogFilterActivity this$0, MacroFilterCategoryHeader it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.z(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int P(Collator collator, Macro macro, Macro macro2) {
        return collator.compare(macro.getName(), macro2.getName());
    }

    private final boolean x() {
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter = this.f12773i;
        if (flexibleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter = null;
        }
        List<MacroFilterCategoryHeader> currentItems = flexibleAdapter.getCurrentItems();
        Intrinsics.checkNotNullExpressionValue(currentItems, "adapter.currentItems");
        for (MacroFilterCategoryHeader macroFilterCategoryHeader : currentItems) {
            if (macroFilterCategoryHeader instanceof MacroFilterCategoryHeader) {
                MacroFilterCategoryHeader macroFilterCategoryHeader2 = macroFilterCategoryHeader;
                macroFilterCategoryHeader2.category();
                if (macroFilterCategoryHeader2.isExpanded()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String y(String str) {
        String calculateSerialCode = SerialCalculator.calculateSerialCode(str, 24);
        Intrinsics.checkNotNullExpressionValue(calculateSerialCode, "calculateSerialCode(password, 24)");
        return calculateSerialCode;
    }

    private final void z(MacroFilterCategoryHeader macroFilterCategoryHeader) {
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter = this.f12773i;
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter2 = null;
        if (flexibleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter = null;
        }
        int globalPositionOf = flexibleAdapter.getGlobalPositionOf(macroFilterCategoryHeader);
        CategoryList categoryList = this.f12779o;
        if (categoryList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            categoryList = null;
        }
        Category categoryByName = categoryList.getCategoryByName(macroFilterCategoryHeader.category().getName());
        boolean z3 = true;
        if (!macroFilterCategoryHeader.isExpanded()) {
            if ((categoryByName == null || !categoryByName.isLocked() || this.f12776l.contains(categoryByName.getName())) ? false : false) {
                String string = getString(R.string.unlock_category);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.unlock_category)");
                H(string, Settings.getLockedCategoryPassword(this), globalPositionOf);
                return;
            }
            FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter3 = this.f12773i;
            if (flexibleAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                flexibleAdapter2 = flexibleAdapter3;
            }
            flexibleAdapter2.expand(globalPositionOf);
            return;
        }
        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter4 = this.f12773i;
        if (flexibleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            flexibleAdapter2 = flexibleAdapter4;
        }
        flexibleAdapter2.collapse(globalPositionOf, true);
        if (this.f12777m.contains(macroFilterCategoryHeader.category().getName())) {
            this.f12777m.remove(macroFilterCategoryHeader.category().getName());
        }
    }

    @NotNull
    public final HeadingColorMapper getHeadingColorMapper() {
        HeadingColorMapper headingColorMapper = this.headingColorMapper;
        if (headingColorMapper != null) {
            return headingColorMapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("headingColorMapper");
        return null;
    }

    @NotNull
    public final String getSearchTerm() {
        return this.f12772h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityMacroLogFilterBinding inflate = ActivityMacroLogFilterBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12770f = inflate;
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityMacroLogFilterBinding activityMacroLogFilterBinding2 = this.f12770f;
        if (activityMacroLogFilterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMacroLogFilterBinding = activityMacroLogFilterBinding2;
        }
        setSupportActionBar(activityMacroLogFilterBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        A();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.system_log_macro_filer_menu, menu);
        MenuItem findItem = menu.findItem(R.id.menu_expand_collapse_categories);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.menu_…pand_collapse_categories)");
        this.f12774j = findItem;
        MenuItem findItem2 = menu.findItem(R.id.toggle_filter);
        Intrinsics.checkNotNullExpressionValue(findItem2, "menu.findItem(R.id.toggle_filter)");
        this.f12775k = findItem2;
        boolean x3 = x();
        MenuItem menuItem = this.f12774j;
        MenuItem menuItem2 = null;
        if (menuItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
            menuItem = null;
        }
        if (x3) {
            i4 = R.drawable.unfold_less_horizontal;
        } else {
            i4 = R.drawable.unfold_more_horizontal;
        }
        menuItem.setIcon(i4);
        MenuItem menuItem3 = this.f12774j;
        if (menuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
            menuItem3 = null;
        }
        if (x3) {
            i5 = R.string.collapse_categories;
        } else {
            i5 = R.string.expand_categories;
        }
        menuItem3.setTitle(i5);
        MenuItem menuItem4 = this.f12774j;
        if (menuItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
            menuItem4 = null;
        }
        menuItem4.setVisible(this.f12778n);
        if (MacroStore.getInstance().getAllCompletedMacros().isEmpty()) {
            MenuItem menuItem5 = this.f12775k;
            if (menuItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggleFilter");
            } else {
                menuItem2 = menuItem5;
            }
            menuItem2.setVisible(false);
            return true;
        }
        MenuItem menuItem6 = this.f12775k;
        if (menuItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleFilter");
        } else {
            menuItem2 = menuItem6;
        }
        if (this.f12780p) {
            i6 = R.drawable.filter_minus;
        } else {
            i6 = R.drawable.filter_plus;
        }
        menuItem2.setIcon(i6);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        boolean z3 = true;
        if (itemId != 16908332) {
            MenuItem menuItem = null;
            if (itemId != R.id.menu_expand_collapse_categories) {
                if (itemId == R.id.toggle_filter) {
                    K(this.f12780p);
                    this.f12780p = !this.f12780p;
                    MenuItem menuItem2 = this.f12775k;
                    if (menuItem2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("toggleFilter");
                    } else {
                        menuItem = menuItem2;
                    }
                    if (this.f12780p) {
                        i6 = R.drawable.filter_minus;
                    } else {
                        i6 = R.drawable.filter_plus;
                    }
                    menuItem.setIcon(i6);
                }
            } else {
                if (x()) {
                    FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter = this.f12773i;
                    if (flexibleAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter = null;
                    }
                    int itemCount = flexibleAdapter.getItemCount();
                    z3 = false;
                    for (int i7 = 0; i7 < itemCount; i7++) {
                        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter2 = this.f12773i;
                        if (flexibleAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            flexibleAdapter2 = null;
                        }
                        flexibleAdapter2.collapse(i7);
                    }
                } else {
                    FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter3 = this.f12773i;
                    if (flexibleAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter3 = null;
                    }
                    flexibleAdapter3.getItemCount();
                    FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter4 = this.f12773i;
                    if (flexibleAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter4 = null;
                    }
                    for (int itemCount2 = flexibleAdapter4.getItemCount() - 1; -1 < itemCount2; itemCount2--) {
                        FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter5 = this.f12773i;
                        if (flexibleAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            flexibleAdapter5 = null;
                        }
                        MacroFilterCategoryHeader macroFilterCategoryHeader = flexibleAdapter5.getCurrentItems().get(itemCount2);
                        Intrinsics.checkNotNullExpressionValue(macroFilterCategoryHeader, "adapter.getCurrentItems()[i]");
                        MacroFilterCategoryHeader macroFilterCategoryHeader2 = macroFilterCategoryHeader;
                        if (macroFilterCategoryHeader2 instanceof MacroFilterCategoryHeader) {
                            MacroFilterCategoryHeader macroFilterCategoryHeader3 = macroFilterCategoryHeader2;
                            if (!macroFilterCategoryHeader3.category().isLocked() || this.f12776l.contains(macroFilterCategoryHeader3.category().getName())) {
                                FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter6 = this.f12773i;
                                if (flexibleAdapter6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                    flexibleAdapter6 = null;
                                }
                                int globalPositionOf = flexibleAdapter6.getGlobalPositionOf(macroFilterCategoryHeader2);
                                FlexibleAdapter<MacroFilterCategoryHeader> flexibleAdapter7 = this.f12773i;
                                if (flexibleAdapter7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                    flexibleAdapter7 = null;
                                }
                                flexibleAdapter7.expand(globalPositionOf);
                            }
                        }
                    }
                }
                Settings.setQuickRunIsExpanded(this, z3);
                MenuItem menuItem3 = this.f12774j;
                if (menuItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
                    menuItem3 = null;
                }
                if (z3) {
                    i4 = R.string.collapse_categories;
                } else {
                    i4 = R.string.expand_categories;
                }
                menuItem3.setTitle(i4);
                MenuItem menuItem4 = this.f12774j;
                if (menuItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
                } else {
                    menuItem = menuItem4;
                }
                if (Settings.getQuickRunIsExpanded(this)) {
                    i5 = R.drawable.unfold_less_horizontal;
                } else {
                    i5 = R.drawable.unfold_more_horizontal;
                }
                menuItem.setIcon(i5);
            }
            return super.onOptionsItemSelected(item);
        }
        finish();
        return true;
    }

    public final void setHeadingColorMapper(@NotNull HeadingColorMapper headingColorMapper) {
        Intrinsics.checkNotNullParameter(headingColorMapper, "<set-?>");
        this.headingColorMapper = headingColorMapper;
    }
}
