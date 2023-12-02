package com.arlosoft.macrodroid.macrolist;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.ArraySet;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.pm.ShortcutManagerCompat;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.ShortcutActivity;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ActionBlockAction;
import com.arlosoft.macrodroid.action.SetWallpaperAction;
import com.arlosoft.macrodroid.actionblock.ActionBlockHelper;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.data.CategoryExportData;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.CategoryEnabledStateChangeEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDeletedEvent;
import com.arlosoft.macrodroid.events.MacroEnabledStateChangeEvent;
import com.arlosoft.macrodroid.events.MacroRunEvent;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroDeserializer;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macrolist.MacroListFragment;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.model.TemplateCategory;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.arlosoft.macrodroid.utils.MacroUtils;
import com.arlosoft.macrodroid.utils.encryption.Encryptor;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.melnykov.fab.FloatingActionButton;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.varunest.sparkbutton.SparkButton2;
import com.varunest.sparkbutton.SparkEventListener;
import de.greenrobot.event.EventBusException;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.Payload;
import eu.davidea.flexibleadapter.common.FlexibleItemDecoration;
import eu.davidea.flexibleadapter.common.SmoothScrollLinearLayoutManager;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.flexibleadapter.items.IHeader;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import me.drakeet.support.toast.ToastCompat;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public class MacroListFragment extends MacroDroidDaggerBaseFragment implements CategoryPasswordHelper.CategoriesUpdatedListener {
    private List<IFlexible> A;
    private Set<String> B;
    private Collator C;
    private HeadingColorMapper E;
    private CategoryPasswordHelper H;
    private boolean J;
    @Inject

    /* renamed from: b  reason: collision with root package name */
    RemoteConfig f12887b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    PremiumStatusHandler f12888c;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    NearbyHelper f12889d;
    @BindView(R.id.dismissButton)
    ImageView dismissButton;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    ActionBlockStore f12890e;
    @BindView(R.id.macrolist_emptyLabel)
    TextView emptyTextView;
    @BindView(R.id.macrolist_emptyView)
    View emptyView;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    CategoriesHelper f12891f;
    @BindView(R.id.favouriteButton)
    SparkButton2 favouriteButton;
    @BindView(R.id.favouritesHint)
    TextView favouritesHint;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    ExtrasManager f12892g;

    /* renamed from: h  reason: collision with root package name */
    private List<Macro> f12893h;

    /* renamed from: i  reason: collision with root package name */
    private MenuItem f12894i;

    /* renamed from: j  reason: collision with root package name */
    private MenuItem f12895j;

    /* renamed from: k  reason: collision with root package name */
    private MenuItem f12896k;

    /* renamed from: l  reason: collision with root package name */
    private MenuItem f12897l;

    /* renamed from: m  reason: collision with root package name */
    private MenuItem f12898m;

    /* renamed from: n  reason: collision with root package name */
    private MenuItem f12899n;
    @BindView(R.id.nearbySharePanel)
    ExpandableLayout nearbySharePanel;

    /* renamed from: o  reason: collision with root package name */
    private MenuItem f12900o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12901p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f12902q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12903r;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    /* renamed from: s  reason: collision with root package name */
    private SearchView f12904s;

    /* renamed from: t  reason: collision with root package name */
    private FloatingActionButton f12905t;
    @BindView(R.id.titleContainer)
    ViewGroup titleContainer;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    /* renamed from: u  reason: collision with root package name */
    private TextView f12906u;

    /* renamed from: v  reason: collision with root package name */
    private ViewGroup f12907v;

    /* renamed from: w  reason: collision with root package name */
    private FlexibleAdapter<IFlexible> f12908w;

    /* renamed from: x  reason: collision with root package name */
    private int f12909x;

    /* renamed from: y  reason: collision with root package name */
    private Cache f12910y;

    /* renamed from: z  reason: collision with root package name */
    private CategoryList f12911z;
    private boolean D = true;
    private Set<String> F = new HashSet();
    private Set<String> G = new HashSet();
    private CompositeDisposable I = new CompositeDisposable();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12929a;

        g(String str) {
            this.f12929a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            MacroListFragment.this.l1(this.f12929a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12931a;

        h(String str) {
            this.f12931a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            MacroListFragment.this.l1(this.f12931a, false);
        }
    }

    /* loaded from: classes3.dex */
    class j extends FlexibleAdapter {
        j(List list, Object obj, boolean z3) {
            super(list, obj, z3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // eu.davidea.flexibleadapter.FlexibleAdapter
        public void u0() {
            super.u0();
            MacroListFragment.this.C1();
            MacroListFragment.this.f12908w.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    class l extends RecyclerView.AdapterDataObserver {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i4, int i5, @Nullable Object obj) {
            super.onItemRangeChanged(i4, i5, obj);
            if (obj == Payload.COLLAPSED) {
                MacroListFragment.this.v1();
            } else if (obj == Payload.EXPANDED) {
                MacroListFragment.this.v1();
            }
            MacroListFragment macroListFragment = MacroListFragment.this;
            macroListFragment.f0(macroListFragment.toolbar.getMenu(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class m implements NearbyHelper.NearbyReceiveListener {
        m() {
        }

        @Override // com.arlosoft.macrodroid.nearby.NearbyHelper.NearbyReceiveListener
        public void jsonDataAvailable(String str) {
            MacroListFragment.this.nearbySharePanel.collapse();
            MacroListFragment.this.w0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class n implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroListCategoryHeader f12939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f12940b;

        n(MacroListCategoryHeader macroListCategoryHeader, boolean z3) {
            this.f12939a = macroListCategoryHeader;
            this.f12940b = z3;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
            MacroListFragment.this.e0(this.f12939a, !this.f12940b);
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            MacroListFragment.this.G.add(this.f12939a.category().getName());
            MacroListFragment.this.e0(this.f12939a, this.f12940b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class o implements SearchView.OnCloseListener {
        o() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnCloseListener
        public boolean onClose() {
            MacroListFragment.this.titleContainer.setVisibility(0);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MacroListFragment.this.titleContainer.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class q implements SearchView.OnQueryTextListener {
        q() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            MacroListFragment.this.f12908w.setFilter(str);
            if (MacroListFragment.this.A != null) {
                MacroListFragment.this.f12908w.filterItems(new ArrayList(MacroListFragment.this.A));
            }
            MacroListFragment.this.f12908w.notifyDataSetChanged();
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(Macro macro, DialogInterface dialogInterface, int i4) {
        if (i4 == 0) {
            i1(macro, false);
        } else if (i4 == 1) {
            o1(macro);
        } else if (i4 == 2) {
            n1(macro);
        } else if (i4 == 3) {
            q1(macro);
        } else if (i4 == 4) {
            j1(macro);
        } else if (i4 == 5) {
            int size = MacroStore.getInstance().getAllCompletedMacros().size();
            int freeMacros = Settings.getFreeMacros(requireActivity());
            if (!this.f12888c.getPremiumStatus().isPro() && size >= freeMacros) {
                Util.showMacroLimitReached(requireActivity(), this.f12887b);
            } else {
                i1(macro.cloneMacro(true, true), true);
            }
        } else if (i4 == 6) {
            MacroUtils.onShareMacro(requireActivity(), macro, this.f12890e);
        } else if (i4 == 7) {
            Intent intent = new Intent(requireActivity(), ShortcutActivity.class);
            intent.putExtra("Macro", macro);
            startActivity(intent);
        } else if (i4 == 8) {
            SystemLogActivity.Companion.launchForIndividualMacro(requireActivity(), macro.getGUID());
        }
    }

    private void A1() {
        startActivity(new Intent(requireActivity(), UpgradeActivity2.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(View view) {
        this.nearbySharePanel.collapse();
        this.f12889d.stopAdvertising();
        this.f12889d.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B1 */
    public boolean H0(MenuItem menuItem) {
        int i4;
        int i5;
        switch (menuItem.getItemId()) {
            case R.id.categories_collapsed_default /* 2131362221 */:
                boolean z3 = !this.f12896k.isChecked();
                this.f12896k.setChecked(z3);
                Settings.setCollapseCategoriesDefault(requireActivity(), z3);
                break;
            case R.id.menu_delete_all /* 2131363388 */:
                p1();
                break;
            case R.id.menu_descriptions /* 2131363390 */:
                this.f12903r = !this.f12903r;
                Settings.setShowDescriptions(requireActivity(), this.f12903r);
                MenuItem menuItem2 = this.f12900o;
                if (this.f12903r) {
                    i4 = R.string.hide_descriptions;
                } else {
                    i4 = R.string.show_descriptions;
                }
                menuItem2.setTitle(i4);
                D1();
                break;
            case R.id.menu_expand_collapse_categories /* 2131363394 */:
                CharSequence title = this.f12895j.getTitle();
                int i6 = R.string.collapse_categories;
                int i7 = 0;
                if (title.equals(getString(R.string.collapse_categories))) {
                    for (int i8 = 0; i8 < this.f12908w.getItemCount(); i8++) {
                        this.f12908w.collapse(i8);
                    }
                    this.F.clear();
                } else {
                    while (i7 < this.f12908w.getItemCount()) {
                        IFlexible iFlexible = this.f12908w.getCurrentItems().get(i7);
                        if (iFlexible instanceof MacroListCategoryHeader) {
                            MacroListCategoryHeader macroListCategoryHeader = (MacroListCategoryHeader) iFlexible;
                            if (!macroListCategoryHeader.category().isLocked() || this.G.contains(macroListCategoryHeader.category().getName())) {
                                this.f12908w.expand(this.f12908w.getGlobalPositionOf(macroListCategoryHeader));
                            }
                        }
                        i7++;
                    }
                    i7 = 1;
                }
                MenuItem menuItem3 = this.f12895j;
                if (i7 == 0) {
                    i6 = R.string.expand_categories;
                }
                menuItem3.setTitle(i6);
                MenuItem menuItem4 = this.f12895j;
                if (d0()) {
                    i5 = R.drawable.unfold_less_horizontal;
                } else {
                    i5 = R.drawable.unfold_more_horizontal;
                }
                menuItem4.setIcon(i5);
                v1();
                break;
            case R.id.menu_import_from_nearby /* 2131363400 */:
                v0();
                break;
            case R.id.menu_last_edited /* 2131363404 */:
                this.f12902q = !this.f12902q;
                Settings.setShowLastEditedTimes(requireActivity(), this.f12902q);
                this.f12899n.setChecked(this.f12902q);
                D1();
                break;
            case R.id.menu_last_invoked /* 2131363405 */:
                this.f12901p = !this.f12901p;
                Settings.setShowLastActivations(requireActivity(), this.f12901p);
                this.f12898m.setChecked(this.f12901p);
                D1();
                break;
            case R.id.menu_set_max_lines /* 2131363425 */:
                y1();
                break;
            case R.id.menu_show_macro_details /* 2131363434 */:
                boolean z4 = !this.f12897l.isChecked();
                this.f12897l.setChecked(z4);
                Settings.setMacroListShowDetails(requireActivity(), z4);
                refresh();
                break;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.nearbySharePanel.expand();
            this.f12889d.initialiseHelperForReceiving(new m());
            this.dismissButton.setOnClickListener(new View.OnClickListener() { // from class: d0.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MacroListFragment.this.B0(view);
                }
            });
            this.f12889d.startAdvertising(NearbyHelper.SERVICE_ID_MACRO_SHARE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        if (this.f12908w.getItemCount() == 0) {
            if (this.f12893h.size() == 0) {
                if (Settings.getShowFavouritesOnly(getContext())) {
                    this.emptyTextView.setText(R.string.no_favourites_selected);
                } else {
                    this.emptyTextView.setText(R.string.no_macros_configured);
                }
            } else {
                this.emptyTextView.setText(R.string.no_macros_found);
            }
            this.emptyView.setVisibility(0);
            return;
        }
        this.emptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(EditText editText, Macro macro, Spinner spinner, EditText editText2, AppCompatDialog appCompatDialog, View view) {
        if (editText.getText().toString().isEmpty()) {
            ToastCompat.makeText(requireContext(), (int) R.string.enter_macro_name, 1).show();
        } else if (MacroStore.getInstance().getMacroByName(editText.getText().toString()) != null) {
            ToastCompat.makeText(requireContext(), (int) R.string.macro_name_already_exists, 1).show();
        } else {
            Macro cloneMacro = macro.cloneMacro(false, true);
            cloneMacro.setCategory(spinner.getSelectedItem().toString());
            cloneMacro.setName(editText.getText().toString());
            cloneMacro.setDescription(editText2.getText().toString());
            MacroStore.getInstance().addMacro(cloneMacro);
            for (ActionBlock actionBlock : this.f12890e.getActionBlocksBeingImported()) {
                actionBlock.setIsBeingImported(false);
                this.f12890e.updateActionBlock(actionBlock);
            }
            refresh();
            appCompatDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void D1() {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.macrolist.MacroListFragment.D1():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(View view) {
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(View view) {
        A1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(DialogInterface dialogInterface, int i4) {
        this.f12909x = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(Macro macro, String[] strArr, DialogInterface dialogInterface, int i4) {
        int i5 = this.f12909x;
        if (i5 == 0) {
            r1(macro);
            return;
        }
        macro.setCategory(strArr[i5]);
        Category categoryByName = this.f12911z.getCategoryByName(macro.getCategory());
        macro.setHeadingColor(0);
        if (categoryByName != null) {
            macro.setHeadingColor(categoryByName.getColor());
        }
        MacroStore.getInstance().writeToJSON();
        D1();
        s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(Macro macro, DialogInterface dialogInterface, int i4) {
        if (macro != null) {
            SystemLog.logInfo("Macro Deleted - " + macro.getName());
            MacroStore.getInstance().removeMacro(macro, true);
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(DialogInterface dialogInterface, int i4) {
        MacroStore.getInstance().removeAllMacros();
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(Macro macro, EditText editText, AppCompatDialog appCompatDialog, View view) {
        macro.setCategory(editText.getText().toString());
        MacroStore.getInstance().writeToJSON();
        D1();
        appCompatDialog.dismiss();
        s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(AppCompatDialog appCompatDialog, EditText editText, String str, View view) {
        appCompatDialog.dismiss();
        this.f12891f.renameCategory(requireContext(), str, editText.getText().toString());
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(String str, int i4, boolean z3, boolean z4, int i5, DialogInterface dialogInterface, int i6) {
        this.f12911z.setCategory(new Category(str, i4, z3, z4));
        this.f12910y.put(Category.CATEGORIES_KEY, this.f12911z);
        if (i6 == 0) {
            for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
                if (macro.getCategory().equals(str) && macro.getHeadingColor() == 0) {
                    macro.setHeadingColor(i5);
                }
            }
        } else if (i6 == 1) {
            for (Macro macro2 : MacroStore.getInstance().getAllCompletedMacros()) {
                if (macro2.getCategory().equals(str)) {
                    macro2.setHeadingColor(i4);
                }
            }
        }
        MacroStore.getInstance().writeToJSON();
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(EditText editText, DialogInterface dialogInterface, int i4) {
        int i5 = 1;
        try {
            int intValue = Integer.valueOf(editText.getText().toString()).intValue();
            if (intValue != 0) {
                i5 = intValue;
            }
        } catch (Exception unused) {
        }
        Settings.setListViewNumLines(requireActivity(), i5);
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(String str, DialogInterface dialogInterface, int i4) {
        k1(str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(DialogInterface dialogInterface, int i4) {
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0(DialogInterface dialogInterface) {
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a1(String str, View view) {
        p0(str);
        return true;
    }

    private void b0() {
        startActivity(new Intent(requireActivity(), WizardActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(MacroListCategoryHeader macroListCategoryHeader, CompoundButton compoundButton, boolean z3) {
        q0(macroListCategoryHeader, z3);
    }

    private boolean c0() {
        for (IFlexible iFlexible : this.f12908w.getCurrentItems()) {
            if ((iFlexible instanceof MacroListCategoryHeader) && !((MacroListCategoryHeader) iFlexible).isExpanded()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(Macro macro, View view) {
        s0(macro);
    }

    private boolean d0() {
        for (IFlexible iFlexible : this.f12908w.getCurrentItems()) {
            if (iFlexible instanceof MacroListCategoryHeader) {
                MacroListCategoryHeader macroListCategoryHeader = (MacroListCategoryHeader) iFlexible;
                macroListCategoryHeader.category();
                if (macroListCategoryHeader.isExpanded()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean d1(Macro macro, View view) {
        t0(macro);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(@NonNull MacroListCategoryHeader macroListCategoryHeader, boolean z3) {
        Set<String> disabledCategories = Settings.getDisabledCategories(requireActivity());
        if (z3) {
            if ((macroListCategoryHeader.category().getName().toLowerCase().contains(BillingModuleKt.SKU_STOPCLUB_SUB) || macroListCategoryHeader.category().getName().toLowerCase().contains("stop club")) && this.f12892g.isExtraInstalled("")) {
                z1(macroListCategoryHeader.category().getName());
                return;
            }
            disabledCategories.remove(macroListCategoryHeader.category().getName());
        } else {
            disabledCategories.add(macroListCategoryHeader.category().getName());
        }
        Settings.setDisabledCategories(requireActivity(), disabledCategories);
        macroListCategoryHeader.setCategoryEnabled(z3);
        List<S> subItems = macroListCategoryHeader.getSubItems();
        if (subItems != 0) {
            for (S s3 : subItems) {
                Macro macro = s3.getMacro();
                if (macro != null) {
                    boolean isEnabled = macro.isEnabled();
                    if (z3 && isEnabled) {
                        MacroStore.getInstance().enableMacroAndUpdate(macro, false);
                    } else if (!z3 && isEnabled) {
                        MacroStore.getInstance().disableMacroAndUpdate(macro, false);
                        macro.setEnabledFlag(true);
                    }
                }
            }
            MacroStore.getInstance().writeToJSON();
        }
        for (S s4 : macroListCategoryHeader.getSubItems()) {
            s4.setDisabledCategory(!z3);
        }
        D1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(Menu menu, boolean z3) {
        try {
            this.f12895j = menu.findItem(R.id.menu_expand_collapse_categories);
            boolean d02 = d0();
            boolean c02 = c0();
            int i4 = R.drawable.unfold_less_horizontal;
            int i5 = R.string.collapse_categories;
            if (z3) {
                MenuItem menuItem = this.f12895j;
                if (!d02) {
                    i5 = R.string.expand_categories;
                }
                menuItem.setTitle(i5);
                MenuItem menuItem2 = this.f12895j;
                if (!d02) {
                    i4 = R.drawable.unfold_more_horizontal;
                }
                menuItem2.setIcon(i4);
            } else {
                boolean equals = this.f12895j.getTitle().equals(getString(R.string.expand_categories));
                if (equals && c02) {
                    this.f12895j.setTitle(R.string.collapse_categories);
                    this.f12895j.setIcon(R.drawable.unfold_less_horizontal);
                } else if (!equals && !d02) {
                    this.f12895j.setTitle(R.string.expand_categories);
                    this.f12895j.setIcon(R.drawable.unfold_more_horizontal);
                }
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int f1(String str, String str2) {
        return this.C.compare(str, str2);
    }

    private void g0(Menu menu) {
        int i4;
        boolean z3;
        List<Macro> list;
        boolean z4 = true;
        f0(menu, true);
        this.f12894i = menu.findItem(R.id.menu_delete_all);
        MenuItem findItem = menu.findItem(R.id.menu_descriptions);
        this.f12900o = findItem;
        if (this.f12903r) {
            i4 = R.string.hide_descriptions;
        } else {
            i4 = R.string.show_descriptions;
        }
        findItem.setTitle(i4);
        MenuItem findItem2 = menu.findItem(R.id.menu_last_invoked);
        this.f12898m = findItem2;
        findItem2.setChecked(this.f12901p);
        MenuItem findItem3 = menu.findItem(R.id.menu_last_edited);
        this.f12899n = findItem3;
        findItem3.setChecked(this.f12902q);
        MenuItem findItem4 = menu.findItem(R.id.menu_show_macro_details);
        this.f12897l = findItem4;
        findItem4.setChecked(Settings.getMacroListShowDetails(requireActivity()));
        MenuItem findItem5 = menu.findItem(R.id.categories_collapsed_default);
        this.f12896k = findItem5;
        findItem5.setChecked(Settings.getCollapseCategoriesDefault(requireActivity()));
        MenuItem menuItem = this.f12896k;
        if (this.B.size() > 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        menuItem.setVisible(z3);
        MenuItem menuItem2 = this.f12894i;
        if (menuItem2 != null && (list = this.f12893h) != null) {
            if (list.size() <= 0) {
                z4 = false;
            }
            menuItem2.setEnabled(z4);
        }
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.menu_search));
        this.f12904s = searchView;
        searchView.setOnCloseListener(new o());
        this.f12904s.setOnSearchClickListener(new p());
        this.f12904s.setMaxWidth(Integer.MAX_VALUE);
        this.f12904s.setElevation(0.0f);
        this.f12904s.setOnQueryTextListener(new q());
        this.f12908w.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int g1(Macro macro, Macro macro2) {
        return this.C.compare(macro.getName(), macro2.getName());
    }

    private void h0() {
        i0(null);
    }

    private void i0(String str) {
        Macro macro = new Macro();
        macro.setCompleted(false);
        macro.setName("");
        if (str != null) {
            macro.setCategory(str);
        }
        MacroStore.getInstance().addMacro(macro);
        Intent intent = new Intent(requireActivity(), EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        intent.putExtra(EditMacroActivity.ADDING_NEW_MACRO_EXTRA, true);
        startActivity(intent);
    }

    private void i1(@NonNull Macro macro, boolean z3) {
        Intent intent = new Intent(requireActivity(), EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        intent.putExtra(Constants.EXTRA_IS_CLONE, z3);
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.OutputStreamWriter] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.OutputStream, java.io.FileOutputStream] */
    private File j0(@NonNull String str, boolean z3, boolean z4) {
        ArrayList arrayList;
        OutputStreamWriter outputStreamWriter;
        ActionBlock actionBlockByGuid;
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(false);
        ArrayList<Macro> arrayList2 = new ArrayList();
        ArraySet arraySet = new ArraySet();
        for (Macro macro : allCompletedMacrosSorted) {
            if (macro.getCategory().equals(str)) {
                macro.configureForExport();
                arrayList2.add(macro);
            }
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if ((next instanceof ActionBlockAction) && (actionBlockByGuid = this.f12890e.getActionBlockByGuid(((ActionBlockAction) next).getActionBlockId())) != null) {
                    arraySet.add(actionBlockByGuid);
                }
            }
        }
        arrayList2.addAll(arraySet);
        ?? r02 = 0;
        r02 = 0;
        if (z4) {
            arrayList = new ArrayList();
            for (Macro macro2 : arrayList2) {
                arrayList.addAll(macro2.getUserIconData());
                macro2.setCategory(str);
            }
        } else {
            arrayList = null;
        }
        String json = GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(requireActivity(), true, true, true)).create().toJson(new CategoryExportData(1, arrayList2, arrayList));
        if (z3) {
            json = Encryptor.encryptToBase64(json, SetWallpaperAction.EXTRA_ENCRYPTION_PASSWORD);
        }
        String replaceAll = str.replace(' ', '_').replaceAll("[\\\\/:*?\"<>|]", "-");
        File filesDir = requireContext().getFilesDir();
        ?? r9 = replaceAll + ".category";
        File file = new File(filesDir, (String) r9);
        try {
            try {
                r9 = new FileOutputStream(file);
                try {
                    outputStreamWriter = new OutputStreamWriter((OutputStream) r9, "UTF8");
                } catch (Exception e4) {
                    e = e4;
                    outputStreamWriter = null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        r02.close();
                        r9.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                r9 = 0;
                outputStreamWriter = null;
            } catch (Throwable th2) {
                th = th2;
                r9 = 0;
            }
            try {
                outputStreamWriter.write(json);
                outputStreamWriter.close();
                try {
                    outputStreamWriter.close();
                    r9.close();
                } catch (Exception unused2) {
                }
                return file;
            } catch (Exception e6) {
                e = e6;
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to write macro when sharing: " + e.getMessage()));
                try {
                    outputStreamWriter.close();
                    r9.close();
                } catch (Exception unused3) {
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            r02 = filesDir;
        }
    }

    private void j1(Macro macro) {
        try {
            if (macro.getTriggerList().size() > 0) {
                SystemLog.logInfo("TESTING MACRO:" + macro.getName());
                macro.invokeActions(new TriggerContextInfo(macro.getTriggerList().get(0)), true);
            } else {
                SystemLog.logError("Macro cannot be tested as it has no triggers.", macro.getGUID());
            }
        } catch (Exception unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setTitle(R.string.macro_test_failed);
            builder.setMessage(R.string.macro_cannot_be_run_without_trigger);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: d0.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    MacroListFragment.I0(dialogInterface, i4);
                }
            });
            builder.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(@NonNull final String str, final boolean z3) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.delete_category);
        builder.setMessage(getString(R.string.confirm_delete_category_confirm));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: d0.r
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.x0(str, z3, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: d0.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void k1(String str, boolean z3) {
        ArrayList<Macro> arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            if (macro.getCategory().equals(str)) {
                arrayList.add(macro);
            }
        }
        for (Macro macro2 : arrayList) {
            MacroStore.getInstance().removeMacro(macro2, false);
        }
        MacroStore.getInstance().writeToJSON();
        List<String> categories = Util.getCategories(requireActivity());
        if (categories != null) {
            categories.remove(str);
            Settings.setCategories(requireActivity(), categories);
            refresh();
        }
        CategoryList categoryList = this.H.getCategoryList();
        categoryList.deleteCategory(str);
        this.f12910y.put(Category.CATEGORIES_KEY, categoryList);
        if (z3) {
            this.H.deletePasswordLockIfRequired(requireContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(@NonNull String str) {
        boolean z3;
        ArrayList arrayList = new ArrayList();
        new ArraySet();
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosSorted(false)) {
            if (macro.getCategory().equals(str)) {
                arrayList.add(macro);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((Macro) it.next()).hasUserIconData()) {
                    z3 = true;
                    break;
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (!z3) {
            l1(str, false);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog_Action);
        builder.setTitle(R.string.export_category);
        builder.setMessage(R.string.share_category_include_user_icons_question);
        builder.setPositiveButton(R.string.dialog_option_yes, new g(str));
        builder.setNegativeButton(R.string.dialog_option_no, new h(str));
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(@NonNull String str, boolean z3) {
        File j02 = j0(str, false, z3);
        if (j02 != null) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Context requireContext = requireContext();
            arrayList.add(FileProvider.getUriForFile(requireContext, requireContext().getPackageName() + ".provider", j02));
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.addFlags(268435456);
            intent.setType("text/plain");
            try {
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                startActivity(Intent.createChooser(intent, getString(R.string.export_category)));
            } catch (Exception e4) {
                ToastCompat.makeText(requireActivity(), (int) R.string.export_failed, 0).show();
                SystemLog.logError("Failed to export file: " + e4.toString());
            }
        }
    }

    private Category m0(CategoryList categoryList, String str) {
        Category categoryByName = categoryList.getCategoryByName(str);
        if (this.F.contains(str)) {
            return new Category(categoryByName.getName(), categoryByName.getColor(), true, categoryByName.isLocked());
        }
        return categoryByName;
    }

    private void m1(Category category, Boolean bool) {
        this.f12911z.setCategory(new Category(category.getName(), category.getColor(), bool.booleanValue(), category.isLocked()));
        this.f12910y.put(Category.CATEGORIES_KEY, this.f12911z);
    }

    private void n0() {
        int size = MacroStore.getInstance().getAllCompletedMacros().size();
        int freeMacros = Settings.getFreeMacros(requireActivity());
        if (!this.f12888c.getPremiumStatus().isPro() && size >= freeMacros) {
            Util.showMacroLimitReached(requireActivity(), this.f12887b);
        } else if (Settings.isUseWizardMode(requireActivity())) {
            b0();
        } else {
            h0();
        }
    }

    private void n1(final Macro macro) {
        this.f12909x = 0;
        List<String> categories = Util.getCategories(requireActivity());
        categories.add(0, "[" + getString(R.string.new_category) + "]");
        for (int i4 = 0; i4 < categories.size(); i4++) {
            if (categories.get(i4).equals(macro.getCategory())) {
                this.f12909x = i4;
            }
        }
        final String[] strArr = (String[]) categories.toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.select_category);
        builder.setSingleChoiceItems(strArr, this.f12909x, new DialogInterface.OnClickListener() { // from class: d0.v
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MacroListFragment.this.J0(dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: d0.x
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MacroListFragment.K0(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: d0.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MacroListFragment.this.L0(macro, strArr, dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void h1(MacroListCategoryHeader macroListCategoryHeader) {
        int globalPositionOf = this.f12908w.getGlobalPositionOf(macroListCategoryHeader);
        Category categoryByName = this.f12911z.getCategoryByName(macroListCategoryHeader.category().getName());
        if (categoryByName == null) {
            categoryByName = macroListCategoryHeader.category();
        }
        boolean z3 = true;
        if (!macroListCategoryHeader.isExpanded()) {
            if ((categoryByName == null || !categoryByName.isLocked() || this.G.contains(categoryByName.getName())) ? false : false) {
                this.H.promptForCategoryPassword(requireActivity(), getString(R.string.unlock_category), macroListCategoryHeader.category().getName(), Settings.getLockedCategoryPassword(requireContext()), 0, new b(macroListCategoryHeader, globalPositionOf, categoryByName));
                return;
            }
            this.f12908w.expand(globalPositionOf);
            m1(categoryByName, Boolean.TRUE);
            return;
        }
        this.f12908w.collapse(globalPositionOf, true);
        if (categoryByName != null && this.F.contains(categoryByName.getName())) {
            this.F.remove(categoryByName.getName());
        }
        m1(categoryByName, Boolean.FALSE);
    }

    private void o1(final Macro macro) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(getString(R.string.delete) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + macro.getName());
        builder.setMessage(R.string.are_you_sure_delete_macro);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: d0.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.M0(macro, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: d0.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void p0(@NonNull final String str) {
        final boolean z3;
        int i4;
        final Category categoryByName = this.f12911z.getCategoryByName(str);
        if (categoryByName != null && categoryByName.isLocked()) {
            z3 = true;
        } else {
            z3 = false;
        }
        String[] strArr = new String[6];
        strArr[0] = getString(R.string.select_color);
        strArr[1] = getString(R.string.rename_category);
        strArr[2] = getString(R.string.export_category);
        if (z3) {
            i4 = R.string.remove_category_lock;
        } else {
            i4 = R.string.lock_category;
        }
        strArr[3] = getString(i4);
        strArr[4] = getString(R.string.delete_category);
        strArr[5] = getString(R.string.add_macro);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: d0.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                MacroListFragment.this.z0(str, z3, categoryByName, dialogInterface, i5);
            }
        });
        builder.create().show();
    }

    private void p1() {
        boolean z3;
        Iterator<Category> it = this.f12911z.getCategories().iterator();
        while (true) {
            if (it.hasNext()) {
                Category next = it.next();
                if (next.isLocked() && !this.G.contains(next.getName())) {
                    z3 = true;
                    break;
                }
            } else {
                z3 = false;
                break;
            }
        }
        if (z3) {
            ToastCompat.makeText(requireContext(), (int) R.string.delete_all_macros_remove_category_locks, 1).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.delete_all_macros);
        builder.setMessage(R.string.are_you_sure_remove_all_macros);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: d0.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.O0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: d0.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void q0(@NonNull MacroListCategoryHeader macroListCategoryHeader, boolean z3) {
        if (!macroListCategoryHeader.isExpanded() && macroListCategoryHeader.category().isLocked() && !this.G.contains(macroListCategoryHeader.category().getName())) {
            this.H.promptForCategoryPassword(requireActivity(), getString(R.string.enter_password), macroListCategoryHeader.category().getName(), Settings.getLockedCategoryPassword(requireContext()), 0, new n(macroListCategoryHeader, z3));
        } else {
            e0(macroListCategoryHeader, z3);
        }
    }

    private void q1(Macro macro) {
        int color;
        if (macro.getHeadingColor() != 0) {
            color = macro.getHeadingColor();
        } else {
            Category categoryByName = this.f12911z.getCategoryByName(macro.getCategory());
            if (categoryByName != null) {
                color = categoryByName.getColor();
            } else {
                color = ContextCompat.getColor(requireActivity(), R.color.default_macro_tile_color);
            }
        }
        ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(color).setPresets(getContext().getResources().getIntArray(R.array.macro_list_heading_colors)).setDialogTitle(R.string.select_color).setSelectedButtonText(17039370).setPresetsButtonText(R.string.icon_tint_color_presets).setCustomButtonText(R.string.color_picker_custom_color_short_label).create();
        create.setColorPickerDialogListener(new a(macro));
        create.show(getChildFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public void e1(MacroListItem macroListItem) {
        if (Settings.getShowFavouritesOnly(requireContext())) {
            FlexibleAdapter<IFlexible> flexibleAdapter = this.f12908w;
            flexibleAdapter.removeItem(flexibleAdapter.getGlobalPositionOf(macroListItem));
            if (this.f12908w.getItemCount() <= 1) {
                refresh();
            }
        }
    }

    private void r1(final Macro macro) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.enter_category);
        appCompatDialog.setTitle(R.string.new_category);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_category_text);
        editText.addTextChangedListener(new i(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: d0.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroListFragment.this.Q0(macro, editText, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: d0.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
        ViewExtensionsKt.focusAndShowKeyboard(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        D1();
        C1();
    }

    private void s0(@NonNull Macro macro) {
        i1(macro, false);
    }

    private void s1() {
        this.f12896k.setVisible(u0(1));
    }

    private void t0(@NonNull final Macro macro) {
        String[] strArr = {getString(R.string.edit), getString(R.string.delete), getString(R.string.select_category), getString(R.string.select_color), getString(R.string.menu_run), getString(R.string.clone_macro), getString(R.string.menu_share)};
        String[] strArr2 = {getString(R.string.edit), getString(R.string.delete), getString(R.string.select_category), getString(R.string.select_color), getString(R.string.menu_run), getString(R.string.clone_macro), getString(R.string.menu_share), getString(R.string.create_home_screen_shortcut), getString(R.string.edit_macro_screen_show_log)};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity(), R.style.Theme_App_Dialog);
        AlertDialog.Builder title = builder.setTitle(macro.getName());
        if (Build.VERSION.SDK_INT >= 23 && ShortcutManagerCompat.isRequestPinShortcutSupported(requireActivity())) {
            strArr = strArr2;
        }
        title.setItems(strArr, new DialogInterface.OnClickListener() { // from class: d0.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.A0(macro, dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void t1(long j4, long j5) {
        Iterator<IHeader> it = this.f12908w.getHeaderItems().iterator();
        while (it.hasNext()) {
            for (S s3 : ((MacroListCategoryHeader) it.next()).getSubItems()) {
                if (s3.getMacro().getGUID() == j4) {
                    s3.setLastInvokedTime(j5);
                    this.f12908w.getGlobalPositionOf(s3);
                    this.f12908w.updateItem(s3);
                    return;
                }
            }
        }
    }

    private boolean u0(int i4) {
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        ArraySet arraySet = new ArraySet();
        for (Macro macro : allCompletedMacros) {
            arraySet.add(macro.getCategory());
            if (arraySet.size() > i4) {
                return true;
            }
        }
        return false;
    }

    private void u1(@NonNull final String str) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.enter_category);
        appCompatDialog.setTitle(R.string.rename_category);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_category_text);
        editText.setText(str);
        editText.setSelection(str.length());
        editText.addTextChangedListener(new f(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: d0.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroListFragment.this.S0(appCompatDialog, editText, str, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: d0.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
        ViewExtensionsKt.focusAndShowKeyboard(editText);
    }

    private void v0() {
        String[] strArr;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31) {
            strArr = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        } else if (i4 < 33) {
            strArr = new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"};
        } else {
            strArr = new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.NEARBY_WIFI_DEVICES", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT"};
        }
        this.I.add(new RxPermissions(this).request(strArr).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: d0.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MacroListFragment.this.C0((Boolean) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        if (this.f12911z != null) {
            for (IFlexible iFlexible : this.f12908w.getCurrentItems()) {
                if (iFlexible instanceof MacroListCategoryHeader) {
                    MacroListCategoryHeader macroListCategoryHeader = (MacroListCategoryHeader) iFlexible;
                    Category category = macroListCategoryHeader.category();
                    this.f12911z.setCategory(new Category(category.getName(), category.getColor(), macroListCategoryHeader.isExpanded(), category.isLocked()));
                }
            }
            this.f12910y.put(Category.CATEGORIES_KEY, this.f12911z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(String str) {
        String description;
        final Macro macro = (Macro) GsonUtils.getMacroGson().fromJson(str, (Class<Object>) Macro.class);
        macro.setNewRandomGUID();
        ActionBlockHelper.addActionBlocks(this.f12890e, macro, macro.getActionBlocksToImport(), true);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog);
        appCompatDialog.setContentView(R.layout.dialog_add_macro_from_nearby);
        appCompatDialog.setTitle(R.string.add_macro);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.descriptionText);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.catgorySpinner);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.nameText);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        editText2.setText(macro.getName());
        if (TextUtils.isEmpty(macro.getDescription())) {
            description = "";
        } else {
            description = macro.getDescription();
        }
        editText.setText(description);
        int i4 = 0;
        List<TemplateCategory> allCategories = TemplateCategory.getAllCategories(requireContext(), false);
        ArrayList arrayList = new ArrayList();
        for (TemplateCategory templateCategory : allCategories) {
            arrayList.add(templateCategory.getName());
        }
        arrayList.add(0, getString(R.string.uncategorized));
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext(), 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        while (true) {
            if (i4 >= arrayList.size()) {
                break;
            } else if (((String) arrayList.get(i4)).equals(macro.getCategory())) {
                spinner.setSelection(i4);
                break;
            } else {
                i4++;
            }
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: d0.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroListFragment.this.D0(editText2, macro, spinner, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: d0.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private void w1(@NonNull String str) {
        int color;
        Category categoryByName = this.f12911z.getCategoryByName(str);
        if (categoryByName != null) {
            color = categoryByName.getColor();
        } else {
            color = ContextCompat.getColor(requireActivity(), R.color.default_macro_tile_color);
        }
        ColorPickerDialog create = ColorPickerDialog.newBuilder().setColor(color).setPresets(getContext().getResources().getIntArray(R.array.macro_list_heading_colors)).setDialogTitle(R.string.select_color).setPresetsButtonText(R.string.icon_tint_color_presets).setSelectedButtonText(17039370).setCustomButtonText(R.string.color_picker_custom_color_short_label).create();
        create.setColorPickerDialogListener(new e(color, str, categoryByName));
        create.show(getChildFragmentManager(), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(String str, boolean z3, DialogInterface dialogInterface, int i4) {
        k1(str, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(final int i4, final int i5, final String str, final boolean z3, final boolean z4) {
        String[] strArr = {getString(R.string.category_only), getString(R.string.category_plus_macros)};
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(R.string.select_option);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: d0.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroListFragment.this.U0(str, i5, z3, z4, i4, dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void y1() {
        boolean z3;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        View inflate = getLayoutInflater().inflate(R.layout.dialog_set_max_lines, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.max_lines);
        editText.setText(String.valueOf(Settings.getListViewNumLines(requireActivity())));
        editText.setSelection(editText.getText().length());
        builder.setTitle(R.string.set_max_lines);
        builder.setView(inflate);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: d0.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.V0(editText, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: d0.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog show = builder.show();
        editText.addTextChangedListener(new r(show));
        Button button = show.getButton(-1);
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        show.getWindow().setSoftInputMode(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(String str, boolean z3, Category category, DialogInterface dialogInterface, int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                i0(str);
                                return;
                            }
                            return;
                        } else if (z3 && !this.G.contains(category.getName())) {
                            this.H.promptForCategoryPassword(requireActivity(), getString(R.string.delete_category), str, Settings.getLockedCategoryPassword(requireContext()), 0, new d(str));
                            return;
                        } else {
                            k0(str, false);
                            return;
                        }
                    } else if (z3) {
                        this.H.removeCategoryLock(requireActivity(), str);
                        return;
                    } else {
                        this.H.lockCategory(requireActivity(), str);
                        return;
                    }
                } else if (z3 && !this.G.contains(category.getName())) {
                    this.H.promptForCategoryPassword(requireActivity(), getString(R.string.export_category), str, Settings.getLockedCategoryPassword(requireContext()), 0, new c(str));
                    return;
                } else {
                    l0(str);
                    return;
                }
            }
            u1(str);
            return;
        }
        w1(str);
    }

    private void z1(final String str) {
        new AlertDialog.Builder(requireActivity()).setTitle(R.string.error).setMessage(R.string.cannot_enable_stopclub_category).setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: d0.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.X0(str, dialogInterface, i4);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: d0.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroListFragment.this.Y0(dialogInterface, i4);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: d0.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MacroListFragment.this.Z0(dialogInterface);
            }
        }).show();
    }

    @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.CategoriesUpdatedListener
    public void categoriesUpdated() {
        refresh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FirebaseAnalyticsEventLogger.logScreenView(requireActivity(), "MacroListFrament");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.J = Settings.getCollapseCategoriesDefault(requireActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.macro_list_view_new, viewGroup, false);
        ButterKnife.bind(this, inflate);
        setHasOptionsMenu(true);
        this.E = new HeadingColorMapper(requireActivity());
        Collator collator = Collator.getInstance(Settings.getLocale(requireActivity()));
        this.C = collator;
        collator.setStrength(0);
        Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
        this.f12910y = cache;
        this.H = new CategoryPasswordHelper(cache, this);
        this.recyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(requireActivity()));
        this.f12901p = Settings.getShowLastActivations(requireActivity());
        this.f12902q = Settings.getShowLastEditedTimes(requireActivity());
        this.f12903r = Settings.getShowDescriptions(requireActivity());
        FloatingActionButton floatingActionButton = (FloatingActionButton) inflate.findViewById(R.id.macro_list_add_button);
        this.f12905t = floatingActionButton;
        floatingActionButton.attachToRecyclerView(this.recyclerView);
        this.f12905t.setOnClickListener(new View.OnClickListener() { // from class: d0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroListFragment.this.F0(view);
            }
        });
        this.f12906u = (TextView) inflate.findViewById(R.id.macro_list_limit_text);
        this.f12907v = (ViewGroup) inflate.findViewById(R.id.macro_list_limit_container);
        ((Button) inflate.findViewById(R.id.macro_list_get_more_macros)).setOnClickListener(new View.OnClickListener() { // from class: d0.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MacroListFragment.this.G0(view);
            }
        });
        this.f12908w = new j(new ArrayList(), null, true);
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        this.B = new ArraySet();
        for (Macro macro : allCompletedMacros) {
            this.B.add(macro.getCategory());
        }
        this.favouriteButton.setChecked(Settings.getShowFavouritesOnly(requireContext()));
        this.favouriteButton.setEventListener(new k());
        this.f12908w.setAnimateToLimit(Integer.MAX_VALUE);
        this.f12908w.setAutoScrollOnExpand(true);
        this.f12908w.registerAdapterDataObserver(new l());
        this.recyclerView.setLayoutManager(new SmoothScrollLinearLayoutManager(requireActivity()));
        this.recyclerView.setAdapter(this.f12908w);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.addItemDecoration(new FlexibleItemDecoration(requireActivity()).addItemViewType(R.layout.macro_list_row, 0, 3, 0, 0).withEdge(true).withBottomEdge(false).withSectionGapOffset(0));
        this.toolbar.inflateMenu(R.menu.macro_list_menu);
        this.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: d0.w
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean H0;
                H0 = MacroListFragment.this.H0(menuItem);
                return H0;
            }
        });
        g0(this.toolbar.getMenu());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.I.clear();
    }

    public void onEventMainThread(CategoryEnabledStateChangeEvent categoryEnabledStateChangeEvent) {
        refresh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        EventBusUtils.getEventBus().unregister(this);
        this.f12889d.stopAdvertising();
        this.f12889d.disconnect();
        this.f12889d.cleanUpHelper();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        CategoryList categoryList = (CategoryList) this.f12910y.get(Category.CATEGORIES_KEY, CategoryList.class);
        this.f12911z = categoryList;
        if (categoryList == null || categoryList.getCategories() == null) {
            this.f12911z = new CategoryList(new ArrayList());
        }
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        ArraySet arraySet = new ArraySet();
        for (Macro macro : allCompletedMacros) {
            arraySet.add(macro.getCategory());
        }
        if (this.J && arraySet.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (Category category : this.f12911z.getCategories()) {
                arrayList.add(new Category(category.getName(), category.getColor(), false, category.isLocked()));
            }
            Iterator it = arraySet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.f12911z.getCategoryByName(str) == null) {
                    Category category2 = new Category(str, ContextCompat.getColor(requireActivity(), R.color.default_macro_tile_color), false, false);
                    this.f12911z.setCategory(category2);
                    arrayList.add(category2);
                }
            }
            CategoryList categoryList2 = new CategoryList(arrayList);
            this.f12910y.put(Category.CATEGORIES_KEY, categoryList2);
            this.f12911z = categoryList2;
        }
        refresh();
        this.D = false;
        try {
            EventBusUtils.getEventBus().register(this);
        } catch (EventBusException unused) {
        }
        this.f12907v.setVisibility(8);
        this.J = false;
        s1();
        g0(this.toolbar.getMenu());
    }

    public void onEventMainThread(MacroEnabledStateChangeEvent macroEnabledStateChangeEvent) {
        refresh();
    }

    public void onEventMainThread(MacroDeletedEvent macroDeletedEvent) {
        refresh();
    }

    public void onEventMainThread(MacroRunEvent macroRunEvent) {
        if (TextUtils.isEmpty(this.f12904s.getQuery().toString())) {
            t1(macroRunEvent.GUID, macroRunEvent.runTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ColorPickerDialogListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Macro f12912a;

        a(Macro macro) {
            this.f12912a = macro;
        }

        @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
        public void onColorSelected(int i4, int i5) {
            this.f12912a.setHeadingColor(i5);
            MacroStore.getInstance().writeToJSON();
            MacroListFragment.this.D1();
        }

        @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
        public void onDialogDismissed(int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements ColorPickerDialogListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f12922a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f12923b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Category f12924c;

        e(int i4, String str, Category category) {
            this.f12922a = i4;
            this.f12923b = str;
            this.f12924c = category;
        }

        @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
        public void onColorSelected(int i4, int i5) {
            boolean z3;
            boolean z4;
            MacroListFragment macroListFragment = MacroListFragment.this;
            int i6 = this.f12922a;
            String str = this.f12923b;
            Category category = this.f12924c;
            if (category != null) {
                z3 = category.isExpanded();
            } else {
                z3 = true;
            }
            Category category2 = this.f12924c;
            if (category2 != null) {
                z4 = category2.isLocked();
            } else {
                z4 = false;
            }
            macroListFragment.x1(i6, i5, str, z3, z4);
        }

        @Override // com.jaredrummler.android.colorpicker.ColorPickerDialogListener
        public void onDialogDismissed(int i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f12926a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f12927b;

        f(Button button, EditText editText) {
            this.f12926a = button;
            this.f12927b = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            this.f12926a.setEnabled(!TextUtils.isEmpty(this.f12927b.getText()));
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class r implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f12945a;

        r(AlertDialog alertDialog) {
            this.f12945a = alertDialog;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f12945a.getButton(-1);
            if (charSequence.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MacroListCategoryHeader f12914a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f12915b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Category f12916c;

        b(MacroListCategoryHeader macroListCategoryHeader, int i4, Category category) {
            this.f12914a = macroListCategoryHeader;
            this.f12915b = i4;
            this.f12916c = category;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            MacroListFragment.this.G.add(this.f12914a.category().getName());
            this.f12914a.setHasUnlocked(true);
            MacroListFragment.this.f12908w.notifyItemChanged(MacroListFragment.this.f12908w.getGlobalPositionOf(this.f12914a));
            MacroListFragment.this.f12908w.expand(this.f12915b);
            MacroListFragment.this.F.add(this.f12916c.getName());
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12918a;

        c(String str) {
            this.f12918a = str;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            MacroListFragment.this.l0(this.f12918a);
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements CategoryPasswordHelper.PasswordListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f12920a;

        d(String str) {
            this.f12920a = str;
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            MacroListFragment.this.k0(this.f12920a, true);
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* loaded from: classes3.dex */
    class k implements SparkEventListener {
        k() {
        }

        @Override // com.varunest.sparkbutton.SparkEventListener
        public void onEvent(ImageView imageView, boolean z3) {
            Settings.setShowFavouritesOnly(MacroListFragment.this.requireActivity(), z3);
            MacroListFragment.this.refresh();
        }

        @Override // com.varunest.sparkbutton.SparkEventListener
        public void onEventAnimationEnd(ImageView imageView, boolean z3) {
        }

        @Override // com.varunest.sparkbutton.SparkEventListener
        public void onEventAnimationStart(ImageView imageView, boolean z3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f12933a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f12934b;

        i(Button button, EditText editText) {
            this.f12933a = button;
            this.f12934b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f12933a;
            if (this.f12934b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
