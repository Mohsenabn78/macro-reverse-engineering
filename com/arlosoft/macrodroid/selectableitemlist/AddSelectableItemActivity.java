package com.arlosoft.macrodroid.selectableitemlist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ConditionAction;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemListItem;
import com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.widget.ItemFinishedListener;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.IFlexible;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AddSelectableItemActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class AddSelectableItemActivity extends MacroDroidBaseActivity implements SelectableItemListItem.OptionsProvider, ItemFinishedListener, SelectableItemChosenListener {
    public static final int $stable = 8;

    /* renamed from: f  reason: collision with root package name */
    private int f13326f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private FlexibleAdapter<IFlexible<?>> f13327g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private SearchView f13328h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private List<IFlexible<?>> f13329i;

    /* renamed from: j  reason: collision with root package name */
    private long f13330j;

    /* renamed from: k  reason: collision with root package name */
    private long f13331k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private SelectableItem f13332l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Macro f13333m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f13334n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f13335o;

    /* JADX WARN: Removed duplicated region for block: B:69:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A() {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity.A():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(AddSelectableItemActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = this$0.f13327g;
        if (flexibleAdapter != null) {
            flexibleAdapter.removeItem(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(View view, int i4) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r0 == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void D() {
        /*
            r3 = this;
            r0 = 2131361930(0x7f0a008a, float:1.8343626E38)
            android.view.View r0 = r3.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            r1.<init>(r3)
            r0.setLayoutManager(r1)
            com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter r1 = r3.t()
            r0.setAdapter(r1)
            androidx.appcompat.widget.SearchView r0 = r3.f13328h
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L26
            boolean r0 = r0.isIconified()
            if (r0 != r1) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = 0
        L27:
            if (r0 == 0) goto L59
            androidx.appcompat.widget.SearchView r0 = r3.f13328h
            if (r0 == 0) goto L3f
            java.lang.CharSequence r0 = r0.getQuery()
            if (r0 == 0) goto L3f
            int r0 = r0.length()
            if (r0 <= 0) goto L3b
            r0 = 1
            goto L3c
        L3b:
            r0 = 0
        L3c:
            if (r0 != r1) goto L3f
            goto L40
        L3f:
            r1 = 0
        L40:
            if (r1 == 0) goto L59
            com.arlosoft.macrodroid.selectableitemlist.classic.SelectableItemAdapter r0 = r3.t()
            android.widget.Filter r0 = r0.getFilter()
            if (r0 == 0) goto L59
            androidx.appcompat.widget.SearchView r1 = r3.f13328h
            if (r1 == 0) goto L55
            java.lang.CharSequence r1 = r1.getQuery()
            goto L56
        L55:
            r1 = 0
        L56:
            r0.filter(r1)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity.D():void");
    }

    private final void E() {
        if (Settings.getShowCategoriesSelectableItems(this)) {
            A();
        } else {
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0.isIconified() == true) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void x(com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity r0, android.view.Menu r1, android.view.MenuItem r2, android.view.View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        /*
            java.lang.String r3 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "$menu"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            androidx.appcompat.widget.SearchView r0 = r0.f13328h
            r3 = 0
            if (r0 == 0) goto L17
            boolean r0 = r0.isIconified()
            r4 = 1
            if (r0 != r4) goto L17
            goto L18
        L17:
            r4 = 0
        L18:
            int r0 = r1.size()
        L1c:
            if (r3 >= r0) goto L2a
            android.view.MenuItem r5 = r1.getItem(r3)
            if (r5 == r2) goto L27
            r5.setVisible(r4)
        L27:
            int r3 = r3 + 1
            goto L1c
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity.x(com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity, android.view.Menu, android.view.MenuItem, android.view.View, int, int, int, int, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(DialogInterface dialogInterface, int i4) {
        dialogInterface.cancel();
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.SelectableItemListItem.OptionsProvider
    public boolean getHelpEnabled() {
        return this.f13334n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Macro getMacro() {
        return this.f13333m;
    }

    public boolean isCondition() {
        return this.f13335o;
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemCancelled() {
        SelectableItem selectableItem = this.f13332l;
        if (selectableItem != null) {
            selectableItem.handleItemCancel();
        }
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemComplete(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        SelectableItem selectableItem = this.f13332l;
        if (selectableItem != null) {
            selectableItem.handleItemComplete(obj);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, @Nullable Intent intent) {
        super.onActivityResult(i4, i5, intent);
        SelectableItem selectableItem = this.f13332l;
        if (selectableItem != null && selectableItem != null) {
            selectableItem.handleActivityResult(this, i4, i5, intent);
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(R.layout.add_selectable_item_view);
        this.f13326f = -1;
        if (bundle != null) {
            SelectableItem selectableItem = (SelectableItem) bundle.getParcelable("selectable_item");
            this.f13332l = selectableItem;
            if (selectableItem != null) {
                selectableItem.setActivity(this);
            }
            this.f13326f = bundle.getInt("MacroId");
        } else {
            Intent intent = getIntent();
            if (intent != null && (extras = intent.getExtras()) != null) {
                this.f13326f = extras.getInt("MacroId", -1);
                this.f13330j = extras.getLong(Constants.EXTRA_PARENT_GUID, 0L);
                this.f13331k = extras.getLong(Constants.EXTRA_PARENT_GUID_FOR_INSERT, 0L);
            }
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(this, q()));
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        Macro macroById = MacroStore.getInstance().getMacroById(this.f13326f);
        this.f13333m = macroById;
        if (macroById == null) {
            finish();
            return;
        }
        SelectableItem selectableItem2 = this.f13332l;
        if (selectableItem2 != null) {
            selectableItem2.setMacro(macroById);
        }
        E();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull final Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.add_selectable_item_menu, menu);
        menu.findItem(R.id.menu_show_categories).setChecked(Settings.getShowCategoriesSelectableItems(this));
        final MenuItem findItem = menu.findItem(R.id.menu_search);
        View actionView = findItem.getActionView();
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SearchView");
        SearchView searchView = (SearchView) actionView;
        this.f13328h = searchView;
        if (searchView != null) {
            searchView.setMaxWidth(Integer.MAX_VALUE);
        }
        SearchView searchView2 = this.f13328h;
        if (searchView2 != null) {
            searchView2.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity$onCreateOptionsMenu$1
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(@NotNull String newText) {
                    FlexibleAdapter flexibleAdapter;
                    FlexibleAdapter flexibleAdapter2;
                    FlexibleAdapter flexibleAdapter3;
                    List list;
                    Intrinsics.checkNotNullParameter(newText, "newText");
                    flexibleAdapter = AddSelectableItemActivity.this.f13327g;
                    if (flexibleAdapter != null) {
                        flexibleAdapter.setFilter(newText);
                    }
                    flexibleAdapter2 = AddSelectableItemActivity.this.f13327g;
                    if (flexibleAdapter2 != null) {
                        list = AddSelectableItemActivity.this.f13329i;
                        Intrinsics.checkNotNull(list);
                        flexibleAdapter2.filterItems(list);
                    }
                    AddSelectableItemActivity.this.t().getFilter().filter(newText);
                    flexibleAdapter3 = AddSelectableItemActivity.this.f13327g;
                    if (flexibleAdapter3 != null) {
                        flexibleAdapter3.notifyDataSetChanged();
                        return true;
                    }
                    return true;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(@NotNull String query) {
                    Intrinsics.checkNotNullParameter(query, "query");
                    return false;
                }
            });
        }
        SearchView searchView3 = this.f13328h;
        if (searchView3 != null) {
            searchView3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.arlosoft.macrodroid.selectableitemlist.a
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    AddSelectableItemActivity.x(AddSelectableItemActivity.this, menu, findItem, view, i4, i5, i6, i7, i8, i9, i10, i11);
                }
            });
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f13328h = null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_help) {
                if (itemId != R.id.menu_show_categories) {
                    return super.onOptionsItemSelected(item);
                }
                boolean z3 = !Settings.getShowCategoriesSelectableItems(this);
                Settings.setShowCategoriesSelectableItems(this, z3);
                item.setChecked(z3);
                E();
                return true;
            }
            setHelpEnabled(!getHelpEnabled());
            FlexibleAdapter<IFlexible<?>> flexibleAdapter = this.f13327g;
            if (flexibleAdapter != null) {
                flexibleAdapter.notifyDataSetChanged();
            }
            t().setHelp(getHelpEnabled());
            return true;
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (i4 == 34) {
            SelectableItem selectableItem = this.f13332l;
            if (selectableItem != null) {
                PermissionsHelper.handleRequestPermissionResult(selectableItem, permissions, grantResults);
                return;
            }
            return;
        }
        super.onRequestPermissionsResult(i4, permissions, grantResults);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt("MacroId", this.f13326f);
        SelectableItem selectableItem = this.f13332l;
        if (selectableItem != null) {
            outState.putParcelable("selectable_item", selectableItem);
        }
        Macro macro = this.f13333m;
        if (macro != null) {
            Intrinsics.checkNotNull(macro);
            outState.putInt("MacroId", macro.getId());
        }
        super.onSaveInstanceState(outState);
    }

    protected abstract int q();

    @NotNull
    protected abstract List<SelectableItemCategory> r();

    public final void refresh() {
        FlexibleAdapter<IFlexible<?>> flexibleAdapter = this.f13327g;
        if (flexibleAdapter != null) {
            flexibleAdapter.notifyDataSetChanged();
        }
        SelectableItem selectableItem = this.f13332l;
        if (selectableItem instanceof ConditionAction) {
            Intrinsics.checkNotNull(selectableItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.action.ConditionAction");
            ((ConditionAction) selectableItem).configureConditionsList();
        }
    }

    protected abstract int s();

    public void selectableItemChosen(@NotNull SelectableItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        SelectableItem constructItem = itemInfo.constructItem(this, this.f13333m);
        this.f13332l = constructItem;
        F(constructItem);
        SelectableItem selectableItem = this.f13332l;
        if (selectableItem != null) {
            selectableItem.onItemSelected();
        }
    }

    @Override // com.arlosoft.macrodroid.selectableitemlist.SelectableItemChosenListener
    public void selectableItemHelpChosen(@NotNull SelectableItemInfo itemInfo) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        AlertDialog.Builder builder = new AlertDialog.Builder(this, v());
        builder.setTitle(itemInfo.getName());
        if (itemInfo.supportsAdbHack()) {
            builder.setMessage(Util.appendAdbHackInfo(this, getString(itemInfo.getHelpInfo())));
        } else {
            builder.setMessage(itemInfo.getHelpInfo());
        }
        builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.selectableitemlist.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AddSelectableItemActivity.y(dialogInterface, i4);
            }
        });
        Util.linkifyDialogText(builder.show());
    }

    public void setHelpEnabled(boolean z3) {
        this.f13334n = z3;
    }

    public abstract boolean shouldHideInfoCard();

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<SelectableItemCategory> sortCategories(@NotNull List<? extends SelectableItemCategory> categories) {
        List<SelectableItemInfo> sortedWith;
        Intrinsics.checkNotNullParameter(categories, "categories");
        for (SelectableItemCategory selectableItemCategory : categories) {
            List<SelectableItemInfo> items = selectableItemCategory.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "cat.items");
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(items, new Comparator() { // from class: com.arlosoft.macrodroid.selectableitemlist.AddSelectableItemActivity$sortCategories$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = kotlin.comparisons.f.compareValues(AddSelectableItemActivity.this.getString(((SelectableItemInfo) t3).getName()), AddSelectableItemActivity.this.getString(((SelectableItemInfo) t4).getName()));
                    return compareValues;
                }
            });
            selectableItemCategory.setItems(sortedWith);
        }
        return categories;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract SelectableItemAdapter t();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final SelectableItem u() {
        return this.f13332l;
    }

    @StyleRes
    protected abstract int v();

    protected abstract int w();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z(@Nullable SelectableItem selectableItem) {
        this.f13332l = selectableItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(@Nullable SelectableItem selectableItem) {
    }
}
