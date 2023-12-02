package com.arlosoft.macrodroid.logging.systemlog.variablefilter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.databinding.ActivityVariableLogFilterBinding;
import com.arlosoft.macrodroid.logging.systemlog.LogFilter;
import com.arlosoft.macrodroid.logging.systemlog.MacroMovementMethod;
import com.arlosoft.macrodroid.logging.systemlog.variablefilter.VariableLogFilterAdapter;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableLogFilterActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nVariableLogFilterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableLogFilterActivity.kt\ncom/arlosoft/macrodroid/logging/systemlog/variablefilter/VariableLogFilterActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n262#2,2:116\n262#2,2:118\n1549#3:120\n1620#3,3:121\n1549#3:124\n1620#3,3:125\n1549#3:128\n1620#3,3:129\n1549#3:132\n1620#3,3:133\n*S KotlinDebug\n*F\n+ 1 VariableLogFilterActivity.kt\ncom/arlosoft/macrodroid/logging/systemlog/variablefilter/VariableLogFilterActivity\n*L\n44#1:116,2\n46#1:118,2\n49#1:120\n49#1:121,3\n89#1:124\n89#1:125,3\n98#1:128\n98#1:129,3\n111#1:132\n111#1:133,3\n*E\n"})
/* loaded from: classes3.dex */
public final class VariableLogFilterActivity extends MacroDroidBaseActivity {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private ActivityVariableLogFilterBinding f12785f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final MacroMovementMethod f12786g = new MacroMovementMethod(this);
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private String f12787h = "";

    /* renamed from: i  reason: collision with root package name */
    private VariableLogFilterAdapter f12788i;

    /* renamed from: j  reason: collision with root package name */
    private MenuItem f12789j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12790k;

    private final void m() {
        LogFilter systemLogFilter;
        int collectionSizeOrDefault;
        List<MacroDroidVariable> variablesList = MacroDroidVariableStore.getInstance().getAllVariables(true);
        VariableLogFilterAdapter variableLogFilterAdapter = null;
        ActivityVariableLogFilterBinding activityVariableLogFilterBinding = null;
        if (variablesList.isEmpty()) {
            ActivityVariableLogFilterBinding activityVariableLogFilterBinding2 = this.f12785f;
            if (activityVariableLogFilterBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityVariableLogFilterBinding = activityVariableLogFilterBinding2;
            }
            LinearLayout linearLayout = activityVariableLogFilterBinding.emptyView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.emptyView");
            linearLayout.setVisibility(0);
            return;
        }
        ActivityVariableLogFilterBinding activityVariableLogFilterBinding3 = this.f12785f;
        if (activityVariableLogFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVariableLogFilterBinding3 = null;
        }
        LinearLayout linearLayout2 = activityVariableLogFilterBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.emptyView");
        linearLayout2.setVisibility(8);
        this.f12790k = Settings.getSystemLogFilter(this).getDisabledVariableNames().isEmpty();
        Intrinsics.checkNotNullExpressionValue(variablesList, "variablesList");
        List<MacroDroidVariable> list = variablesList;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(new VariableWithFilteredState(it, !systemLogFilter.getDisabledVariableNames().contains(it.getName())));
        }
        this.f12788i = new VariableLogFilterAdapter(arrayList, new VariableLogFilterAdapter.OnFilterChangeListener() { // from class: com.arlosoft.macrodroid.logging.systemlog.variablefilter.VariableLogFilterActivity$initialiseVariablesList$1
            @Override // com.arlosoft.macrodroid.logging.systemlog.variablefilter.VariableLogFilterAdapter.OnFilterChangeListener
            public void filterStateChanged(@NotNull String variableName, boolean z3) {
                Intrinsics.checkNotNullParameter(variableName, "variableName");
                VariableLogFilterActivity.this.n(variableName, z3);
            }
        });
        ActivityVariableLogFilterBinding activityVariableLogFilterBinding4 = this.f12785f;
        if (activityVariableLogFilterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityVariableLogFilterBinding4 = null;
        }
        RecyclerView recyclerView = activityVariableLogFilterBinding4.recyclerView;
        VariableLogFilterAdapter variableLogFilterAdapter2 = this.f12788i;
        if (variableLogFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            variableLogFilterAdapter = variableLogFilterAdapter2;
        }
        recyclerView.setAdapter(variableLogFilterAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str, boolean z3) {
        List mutableList;
        List plus;
        int collectionSizeOrDefault;
        List mutableList2;
        LogFilter logFilter = Settings.getSystemLogFilter(this);
        if (z3) {
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) logFilter.getDisabledVariableNames());
            plus = CollectionsKt___CollectionsKt.minus(mutableList2, str);
        } else {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) logFilter.getDisabledVariableNames());
            plus = CollectionsKt___CollectionsKt.plus((Collection<? extends String>) ((Collection<? extends Object>) mutableList), str);
        }
        List list = plus;
        List<MacroDroidVariable> variablesList = MacroDroidVariableStore.getInstance().getAllVariables(true);
        Intrinsics.checkNotNullExpressionValue(variablesList, "variablesList");
        List<MacroDroidVariable> list2 = variablesList;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable it : list2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(new VariableWithFilteredState(it, !list.contains(it.getName())));
        }
        VariableLogFilterAdapter variableLogFilterAdapter = this.f12788i;
        if (variableLogFilterAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            variableLogFilterAdapter = null;
        }
        variableLogFilterAdapter.setVariables(arrayList);
        Intrinsics.checkNotNullExpressionValue(logFilter, "logFilter");
        Settings.setSystemLogFilter(this, LogFilter.copy$default(logFilter, 0, false, false, false, null, list, 31, null));
    }

    private final void o(boolean z3) {
        int collectionSizeOrDefault;
        List emptyList;
        LogFilter copy$default;
        int collectionSizeOrDefault2;
        List<MacroDroidVariable> variablesList = MacroDroidVariableStore.getInstance().getAllVariables(false);
        Intrinsics.checkNotNullExpressionValue(variablesList, "variablesList");
        List<MacroDroidVariable> list = variablesList;
        collectionSizeOrDefault = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (MacroDroidVariable macroDroidVariable : list) {
            arrayList.add(macroDroidVariable.getName());
        }
        LogFilter systemLogFilter = Settings.getSystemLogFilter(this);
        Intrinsics.checkNotNullExpressionValue(systemLogFilter, "getSystemLogFilter(this)");
        LogFilter copy$default2 = LogFilter.copy$default(systemLogFilter, 0, false, false, false, null, null, 63, null);
        if (!z3) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            copy$default = LogFilter.copy$default(copy$default2, 0, false, false, false, null, emptyList, 31, null);
        } else {
            copy$default = LogFilter.copy$default(copy$default2, 0, false, false, false, null, arrayList, 31, null);
        }
        Settings.setSystemLogFilter(this, copy$default);
        collectionSizeOrDefault2 = f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (MacroDroidVariable it : list) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList2.add(new VariableWithFilteredState(it, !copy$default.getDisabledVariableNames().contains(it.getName())));
        }
        VariableLogFilterAdapter variableLogFilterAdapter = this.f12788i;
        VariableLogFilterAdapter variableLogFilterAdapter2 = null;
        if (variableLogFilterAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            variableLogFilterAdapter = null;
        }
        variableLogFilterAdapter.setVariables(arrayList2);
        VariableLogFilterAdapter variableLogFilterAdapter3 = this.f12788i;
        if (variableLogFilterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            variableLogFilterAdapter2 = variableLogFilterAdapter3;
        }
        variableLogFilterAdapter2.notifyDataSetChanged();
    }

    @NotNull
    public final String getSearchTerm() {
        return this.f12787h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityVariableLogFilterBinding inflate = ActivityVariableLogFilterBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f12785f = inflate;
        ActivityVariableLogFilterBinding activityVariableLogFilterBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityVariableLogFilterBinding activityVariableLogFilterBinding2 = this.f12785f;
        if (activityVariableLogFilterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityVariableLogFilterBinding = activityVariableLogFilterBinding2;
        }
        setSupportActionBar(activityVariableLogFilterBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        int i4;
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.system_log_variable_filer_menu, menu);
        MenuItem findItem = menu.findItem(R.id.toggle_filter);
        Intrinsics.checkNotNullExpressionValue(findItem, "menu.findItem(R.id.toggle_filter)");
        this.f12789j = findItem;
        MenuItem menuItem = null;
        if (MacroDroidVariableStore.getInstance().getAllVariables(false).isEmpty()) {
            MenuItem menuItem2 = this.f12789j;
            if (menuItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggleFilter");
            } else {
                menuItem = menuItem2;
            }
            menuItem.setVisible(false);
            return true;
        }
        MenuItem menuItem3 = this.f12789j;
        if (menuItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleFilter");
        } else {
            menuItem = menuItem3;
        }
        if (this.f12790k) {
            i4 = R.drawable.filter_minus;
        } else {
            i4 = R.drawable.filter_plus;
        }
        menuItem.setIcon(i4);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        int i4;
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.toggle_filter) {
                return super.onOptionsItemSelected(item);
            }
            o(this.f12790k);
            this.f12790k = !this.f12790k;
            MenuItem menuItem = this.f12789j;
            if (menuItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggleFilter");
                menuItem = null;
            }
            if (this.f12790k) {
                i4 = R.drawable.filter_minus;
            } else {
                i4 = R.drawable.filter_plus;
            }
            menuItem.setIcon(i4);
            return true;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m();
    }
}
