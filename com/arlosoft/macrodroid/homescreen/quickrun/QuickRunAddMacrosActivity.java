package com.arlosoft.macrodroid.homescreen.quickrun;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
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
import com.arlosoft.macrodroid.databinding.ActivityUploadTemplateBinding;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macrolist.HeadingColorMapper;
import com.arlosoft.macrodroid.macrolist.MacroListCategoryHeader;
import com.arlosoft.macrodroid.macrolist.MacroListItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.gradients.Gradients;
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
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QuickRunAddMacrosActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nQuickRunAddMacrosActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickRunAddMacrosActivity.kt\ncom/arlosoft/macrodroid/homescreen/quickrun/QuickRunAddMacrosActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 CustomServices.kt\norg/jetbrains/anko/CustomServicesKt\n*L\n1#1,307:1\n766#2:308\n857#2,2:309\n262#3,2:311\n26#4:313\n*S KotlinDebug\n*F\n+ 1 QuickRunAddMacrosActivity.kt\ncom/arlosoft/macrodroid/homescreen/quickrun/QuickRunAddMacrosActivity\n*L\n143#1:308\n143#1:309,2\n158#1:311,2\n276#1:313\n*E\n"})
/* loaded from: classes3.dex */
public final class QuickRunAddMacrosActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private FlexibleAdapter<MacroListCategoryHeader> f12376f;

    /* renamed from: g  reason: collision with root package name */
    private MenuItem f12377g;
    @Inject
    public HeadingColorMapper headingColorMapper;

    /* renamed from: k  reason: collision with root package name */
    private CategoryList f12381k;

    /* renamed from: l  reason: collision with root package name */
    private ActivityUploadTemplateBinding f12382l;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final HashSet<String> f12378h = new HashSet<>();
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final HashSet<String> f12379i = new HashSet<>();

    /* renamed from: j  reason: collision with root package name */
    private boolean f12380j = true;

    /* compiled from: QuickRunAddMacrosActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, Integer num, Macro macro, String str, String str2, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                num = 0;
            }
            Integer num2 = num;
            if ((i4 & 4) != 0) {
                macro = null;
            }
            return companion.createIntent(context, num2, macro, str, str2);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable Integer num, @Nullable Macro macro, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, QuickRunAddMacrosActivity.class);
            intent.putExtra("macro", macro);
            intent.putExtra("default_category", str2);
            intent.putExtra("default_description", str);
            intent.putExtra("updating_macro_id", num);
            return intent;
        }

        public static /* synthetic */ Intent createIntent$default(Companion companion, Context context, Integer num, String str, String str2, String str3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                num = 0;
            }
            return companion.createIntent(context, num, str, str2, str3);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable Integer num, @NotNull String macroName, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(macroName, "macroName");
            Intent intent = new Intent(context, QuickRunAddMacrosActivity.class);
            intent.putExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME, macroName);
            intent.putExtra("default_category", str2);
            intent.putExtra("default_description", str);
            intent.putExtra("updating_macro_id", num);
            return intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int A(Collator collator, String str, String str2) {
        return collator.compare(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QuickRunAddMacrosActivity this$0, MacroListCategoryHeader it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.x(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int C(Collator collator, Macro macro, Macro macro2) {
        return collator.compare(macro.getName(), macro2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(QuickRunAddMacrosActivity this$0, Macro macro, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        this$0.G(macro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(View view) {
        return true;
    }

    private final void G(Macro macro) {
        List<Long> quickRunMacroGuids = Settings.getQuickRunMacroGuids(Gradients.INSTANCE.getContext());
        quickRunMacroGuids.add(Long.valueOf(macro.getGUID()));
        Settings.setQuickRunMacroGuids(this, quickRunMacroGuids);
        finish();
    }

    private final void H(String str, final String str2, final String str3, final MacroListCategoryHeader macroListCategoryHeader) {
        String str4;
        CategoryList categoryList = this.f12381k;
        if (categoryList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            str4 = str2;
            categoryList = null;
        } else {
            str4 = str2;
        }
        final Category categoryByName = categoryList.getCategoryByName(str4);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        Object systemService = new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
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
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickRunAddMacrosActivity.I(QuickRunAddMacrosActivity.this, editText, str3, str2, macroListCategoryHeader, categoryByName, create, view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QuickRunAddMacrosActivity.J(create, view);
                }
            });
            editText.requestFocus();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(QuickRunAddMacrosActivity this$0, EditText editText, String str, String categoryName, MacroListCategoryHeader categoryHeader, Category category, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(categoryName, "$categoryName");
        Intrinsics.checkNotNullParameter(categoryHeader, "$categoryHeader");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (Intrinsics.areEqual(this$0.w(editText.getText().toString()), str)) {
            this$0.f12378h.add(categoryName);
            categoryHeader.setHasUnlocked(true);
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = this$0.f12376f;
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = null;
            if (flexibleAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter = null;
            }
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this$0.f12376f;
            if (flexibleAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter3 = null;
            }
            flexibleAdapter.notifyItemChanged(flexibleAdapter3.getGlobalPositionOf(categoryHeader));
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this$0.f12376f;
            if (flexibleAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter4 = null;
            }
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter5 = this$0.f12376f;
            if (flexibleAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                flexibleAdapter2 = flexibleAdapter5;
            }
            flexibleAdapter4.expand(flexibleAdapter2.getGlobalPositionOf(categoryHeader));
            HashSet<String> hashSet = this$0.f12379i;
            Intrinsics.checkNotNull(category);
            hashSet.add(category.getName());
            dialog.dismiss();
            return;
        }
        ToastCompat.makeText(this$0.getApplicationContext(), (int) R.string.invalid_password, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    private final boolean v() {
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = this.f12376f;
        if (flexibleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter = null;
        }
        List<MacroListCategoryHeader> currentItems = flexibleAdapter.getCurrentItems();
        Intrinsics.checkNotNullExpressionValue(currentItems, "adapter.currentItems");
        for (MacroListCategoryHeader macroListCategoryHeader : currentItems) {
            if (macroListCategoryHeader instanceof MacroListCategoryHeader) {
                MacroListCategoryHeader macroListCategoryHeader2 = macroListCategoryHeader;
                macroListCategoryHeader2.category();
                if (macroListCategoryHeader2.isExpanded()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String w(String str) {
        String calculateSerialCode = SerialCalculator.calculateSerialCode(str, 24);
        Intrinsics.checkNotNullExpressionValue(calculateSerialCode, "calculateSerialCode(password, 24)");
        return calculateSerialCode;
    }

    private final void x(MacroListCategoryHeader macroListCategoryHeader) {
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = this.f12376f;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = null;
        if (flexibleAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter = null;
        }
        int globalPositionOf = flexibleAdapter.getGlobalPositionOf(macroListCategoryHeader);
        CategoryList categoryList = this.f12381k;
        if (categoryList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            categoryList = null;
        }
        Category categoryByName = categoryList.getCategoryByName(macroListCategoryHeader.category().getName());
        boolean z3 = true;
        if (!macroListCategoryHeader.isExpanded()) {
            if ((categoryByName == null || !categoryByName.isLocked() || this.f12378h.contains(categoryByName.getName())) ? false : false) {
                String string = getString(R.string.unlock_category);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.unlock_category)");
                H(string, macroListCategoryHeader.category().getName(), Settings.getLockedCategoryPassword(this), macroListCategoryHeader);
                return;
            }
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this.f12376f;
            if (flexibleAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                flexibleAdapter2 = flexibleAdapter3;
            }
            flexibleAdapter2.expand(globalPositionOf);
            return;
        }
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this.f12376f;
        if (flexibleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            flexibleAdapter2 = flexibleAdapter4;
        }
        flexibleAdapter2.collapse(globalPositionOf, true);
        if (this.f12379i.contains(macroListCategoryHeader.category().getName())) {
            this.f12379i.remove(macroListCategoryHeader.category().getName());
        }
    }

    private final void y() {
        int i4;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter;
        List<Macro> list;
        boolean z3;
        CategoryList categoryList = null;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = new FlexibleAdapter<>(new ArrayList(), null, true);
        this.f12376f = flexibleAdapter2;
        flexibleAdapter2.addListener(new FlexibleAdapter.OnItemClickListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.a
            @Override // eu.davidea.flexibleadapter.FlexibleAdapter.OnItemClickListener
            public final boolean onItemClick(View view, int i5) {
                boolean z4;
                z4 = QuickRunAddMacrosActivity.z(view, i5);
                return z4;
            }
        });
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this.f12376f;
        if (flexibleAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter3 = null;
        }
        flexibleAdapter3.setAnimateToLimit(Integer.MAX_VALUE);
        List<Long> quickRunMacroGuids = Settings.getQuickRunMacroGuids(this);
        ActivityUploadTemplateBinding activityUploadTemplateBinding = this.f12382l;
        if (activityUploadTemplateBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding = null;
        }
        activityUploadTemplateBinding.recyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(this));
        ActivityUploadTemplateBinding activityUploadTemplateBinding2 = this.f12382l;
        if (activityUploadTemplateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding2 = null;
        }
        RecyclerView recyclerView = activityUploadTemplateBinding2.recyclerView;
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this.f12376f;
        if (flexibleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter4 = null;
        }
        recyclerView.setAdapter(flexibleAdapter4);
        ActivityUploadTemplateBinding activityUploadTemplateBinding3 = this.f12382l;
        if (activityUploadTemplateBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding3 = null;
        }
        activityUploadTemplateBinding3.recyclerView.setHasFixedSize(true);
        ActivityUploadTemplateBinding activityUploadTemplateBinding4 = this.f12382l;
        if (activityUploadTemplateBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding4 = null;
        }
        boolean z4 = false;
        activityUploadTemplateBinding4.recyclerView.addItemDecoration(new FlexibleItemDecoration(this).addItemViewType(R.layout.macro_list_row, 0, 3, 0, 0).withEdge(true).withBottomEdge(false).withSectionGapOffset(0));
        HashMap<String, List<Macro>> categoryMap = MacroStore.getInstance().getCategoryMap();
        ArrayList arrayList = new ArrayList();
        final Collator collator = Collator.getInstance(Settings.getLocale(this));
        collator.setStrength(0);
        ArrayList arrayList2 = new ArrayList(categoryMap.keySet());
        kotlin.collections.h.sortWith(arrayList2, new Comparator() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int A;
                A = QuickRunAddMacrosActivity.A(collator, (String) obj, (String) obj2);
                return A;
            }
        });
        CategoryList categoryList2 = (CategoryList) MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE).get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList2 == null) {
            categoryList2 = new CategoryList(new ArrayList());
        }
        this.f12381k = categoryList2;
        Iterator it = arrayList2.iterator();
        int i5 = 0;
        int i6 = AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength;
        int i7 = 0;
        while (it.hasNext()) {
            String categoryName = (String) it.next();
            CategoryList categoryList3 = this.f12381k;
            if (categoryList3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryList");
                categoryList3 = categoryList;
            }
            Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
            Category categoryByName = categoryList3.getCategoryByName(categoryName);
            if (categoryByName == null) {
                categoryByName = new Category(categoryName, ContextCompat.getColor(this, R.color.default_macro_tile_color), z4, z4);
            }
            Category category = categoryByName;
            int i8 = i6 + 1;
            MacroListCategoryHeader macroListCategoryHeader = new MacroListCategoryHeader(category, i6, true, false, false, new MacroListCategoryHeader.OnCategoryClickedListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.c
                @Override // com.arlosoft.macrodroid.macrolist.MacroListCategoryHeader.OnCategoryClickedListener
                public final void onClick(MacroListCategoryHeader macroListCategoryHeader2) {
                    QuickRunAddMacrosActivity.B(QuickRunAddMacrosActivity.this, macroListCategoryHeader2);
                }
            }, null, getHeadingColorMapper());
            List<Macro> list2 = categoryMap.get(categoryName);
            if (list2 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : list2) {
                    if (!quickRunMacroGuids.contains(Long.valueOf(((Macro) obj).getGUID()))) {
                        arrayList3.add(obj);
                    }
                }
                list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList3);
            } else {
                list = null;
            }
            if (list != null) {
                kotlin.collections.h.sortWith(list, new Comparator() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.d
                    @Override // java.util.Comparator
                    public final int compare(Object obj2, Object obj3) {
                        int C;
                        C = QuickRunAddMacrosActivity.C(collator, (Macro) obj2, (Macro) obj3);
                        return C;
                    }
                });
            }
            Intrinsics.checkNotNull(list);
            int i9 = i7;
            int i10 = 0;
            for (final Macro macro : list) {
                int i11 = i10 + 1;
                int i12 = i9 + 1;
                List<Long> list3 = quickRunMacroGuids;
                if (i10 == list.size() - 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                macroListCategoryHeader.addSubItem(new MacroListItem(macroListCategoryHeader, i9, macro, category, 0L, false, 0L, false, false, z3, new View.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QuickRunAddMacrosActivity.D(QuickRunAddMacrosActivity.this, macro, view);
                    }
                }, new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.f
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean E;
                        E = QuickRunAddMacrosActivity.E(view);
                        return E;
                    }
                }, new MacroListItem.FavouriteRemovedListener() { // from class: com.arlosoft.macrodroid.homescreen.quickrun.g
                    @Override // com.arlosoft.macrodroid.macrolist.MacroListItem.FavouriteRemovedListener
                    public final void favouriteRemoved(MacroListItem macroListItem) {
                        QuickRunAddMacrosActivity.F(macroListItem);
                    }
                }, false, getHeadingColorMapper(), false, this.f12378h));
                i5++;
                i10 = i11;
                quickRunMacroGuids = list3;
                i9 = i12;
            }
            List<Long> list4 = quickRunMacroGuids;
            if (macroListCategoryHeader.getSubItemsCount() > 0) {
                arrayList.add(macroListCategoryHeader);
            }
            quickRunMacroGuids = list4;
            i7 = i9;
            i6 = i8;
            categoryList = null;
            z4 = false;
        }
        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter5 = this.f12376f;
        if (flexibleAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            flexibleAdapter5 = null;
        }
        flexibleAdapter5.updateDataSet(arrayList);
        ActivityUploadTemplateBinding activityUploadTemplateBinding5 = this.f12382l;
        if (activityUploadTemplateBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadTemplateBinding5 = null;
        }
        LinearLayout linearLayout = activityUploadTemplateBinding5.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
        if (arrayList.isEmpty()) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        linearLayout.setVisibility(i4);
        if (i5 < 6) {
            this.f12380j = false;
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter6 = this.f12376f;
            if (flexibleAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter6 = null;
            }
            for (IHeader iHeader : flexibleAdapter6.getHeaderItems()) {
                if ((iHeader instanceof MacroListCategoryHeader) && !((MacroListCategoryHeader) iHeader).category().isLocked()) {
                    FlexibleAdapter flexibleAdapter7 = this.f12376f;
                    if (flexibleAdapter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter7 = null;
                    }
                    flexibleAdapter7.expand((FlexibleAdapter) iHeader);
                } else {
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter8 = this.f12376f;
                    if (flexibleAdapter8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter8 = null;
                    }
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter9 = this.f12376f;
                    if (flexibleAdapter9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter9 = null;
                    }
                    flexibleAdapter8.collapse(flexibleAdapter9.getGlobalPositionOf(iHeader));
                }
            }
        } else if (Settings.getQuickRunIsExpanded(this)) {
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter10 = this.f12376f;
            if (flexibleAdapter10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter10 = null;
            }
            for (IHeader iHeader2 : flexibleAdapter10.getHeaderItems()) {
                if ((iHeader2 instanceof MacroListCategoryHeader) && !((MacroListCategoryHeader) iHeader2).category().isLocked()) {
                    FlexibleAdapter flexibleAdapter11 = this.f12376f;
                    if (flexibleAdapter11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter11 = null;
                    }
                    flexibleAdapter11.expand((FlexibleAdapter) iHeader2);
                } else {
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter12 = this.f12376f;
                    if (flexibleAdapter12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter12 = null;
                    }
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter13 = this.f12376f;
                    if (flexibleAdapter13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter13 = null;
                    }
                    flexibleAdapter12.collapse(flexibleAdapter13.getGlobalPositionOf(iHeader2));
                }
            }
        } else {
            FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter14 = this.f12376f;
            if (flexibleAdapter14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                flexibleAdapter = null;
            } else {
                flexibleAdapter = flexibleAdapter14;
            }
            flexibleAdapter.collapseAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(View view, int i4) {
        return false;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityUploadTemplateBinding inflate = ActivityUploadTemplateBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12382l = inflate;
        ActivityUploadTemplateBinding activityUploadTemplateBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setTitle(R.string.add_macro);
        ActivityUploadTemplateBinding activityUploadTemplateBinding2 = this.f12382l;
        if (activityUploadTemplateBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUploadTemplateBinding = activityUploadTemplateBinding2;
        }
        setSupportActionBar(activityUploadTemplateBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.add_quick_run_menu, menu);
        MenuItem findItem = menu.findItem(R.id.menu_expand_collapse_categories);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.menu_…pand_collapse_categories)");
        this.f12377g = findItem;
        MenuItem menuItem = null;
        if (findItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
            findItem = null;
        }
        if (Settings.getQuickRunIsExpanded(this)) {
            i4 = R.drawable.unfold_less_horizontal;
        } else {
            i4 = R.drawable.unfold_more_horizontal;
        }
        findItem.setIcon(i4);
        MenuItem menuItem2 = this.f12377g;
        if (menuItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
            menuItem2 = null;
        }
        if (Settings.getQuickRunIsExpanded(this)) {
            i5 = R.string.collapse_categories;
        } else {
            i5 = R.string.expand_categories;
        }
        menuItem2.setTitle(i5);
        MenuItem menuItem3 = this.f12377g;
        if (menuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
        } else {
            menuItem = menuItem3;
        }
        menuItem.setVisible(this.f12380j);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        boolean z3 = true;
        if (itemId != 16908332) {
            if (itemId == R.id.menu_expand_collapse_categories) {
                MenuItem menuItem = null;
                if (v()) {
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter = this.f12376f;
                    if (flexibleAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter = null;
                    }
                    int itemCount = flexibleAdapter.getItemCount();
                    z3 = false;
                    for (int i6 = 0; i6 < itemCount; i6++) {
                        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter2 = this.f12376f;
                        if (flexibleAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            flexibleAdapter2 = null;
                        }
                        flexibleAdapter2.collapse(i6);
                    }
                } else {
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter3 = this.f12376f;
                    if (flexibleAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter3 = null;
                    }
                    flexibleAdapter3.getItemCount();
                    FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter4 = this.f12376f;
                    if (flexibleAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        flexibleAdapter4 = null;
                    }
                    for (int itemCount2 = flexibleAdapter4.getItemCount() - 1; -1 < itemCount2; itemCount2--) {
                        FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter5 = this.f12376f;
                        if (flexibleAdapter5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            flexibleAdapter5 = null;
                        }
                        MacroListCategoryHeader macroListCategoryHeader = flexibleAdapter5.getCurrentItems().get(itemCount2);
                        Intrinsics.checkNotNullExpressionValue(macroListCategoryHeader, "adapter.getCurrentItems()[i]");
                        MacroListCategoryHeader macroListCategoryHeader2 = macroListCategoryHeader;
                        if (macroListCategoryHeader2 instanceof MacroListCategoryHeader) {
                            MacroListCategoryHeader macroListCategoryHeader3 = macroListCategoryHeader2;
                            if (!macroListCategoryHeader3.category().isLocked() || this.f12378h.contains(macroListCategoryHeader3.category().getName())) {
                                FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter6 = this.f12376f;
                                if (flexibleAdapter6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                    flexibleAdapter6 = null;
                                }
                                int globalPositionOf = flexibleAdapter6.getGlobalPositionOf(macroListCategoryHeader2);
                                FlexibleAdapter<MacroListCategoryHeader> flexibleAdapter7 = this.f12376f;
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
                MenuItem menuItem2 = this.f12377g;
                if (menuItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
                    menuItem2 = null;
                }
                if (z3) {
                    i4 = R.string.collapse_categories;
                } else {
                    i4 = R.string.expand_categories;
                }
                menuItem2.setTitle(i4);
                MenuItem menuItem3 = this.f12377g;
                if (menuItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("expandCollapseMenuItem");
                } else {
                    menuItem = menuItem3;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        y();
    }

    public final void setHeadingColorMapper(@NotNull HeadingColorMapper headingColorMapper) {
        Intrinsics.checkNotNullParameter(headingColorMapper, "<set-?>");
        this.headingColorMapper = headingColorMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(MacroListItem macroListItem) {
    }
}
