package com.arlosoft.macrodroid.wizard;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.DisplayCutout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.advert.AdvertActivity;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.CategoryModeUpdateEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.FilterEvent;
import com.arlosoft.macrodroid.events.MacroUpdateEvent;
import com.arlosoft.macrodroid.events.SetHelpVisibilityEvent;
import com.arlosoft.macrodroid.events.WizardScrollToTopEvent;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.macro.RemovedItem;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.AndroidWearTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.widget.ItemFinishedListener;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.SnackbarAnimate;
import com.google.android.material.tabs.TabLayout;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WizardActivity extends MacroDroidBaseActivity implements ItemFinishedListener {

    /* renamed from: f  reason: collision with root package name */
    private Macro f16508f;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    /* renamed from: g  reason: collision with root package name */
    private SearchView f16509g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16510h;

    /* renamed from: i  reason: collision with root package name */
    private i f16511i;

    /* renamed from: j  reason: collision with root package name */
    int f16512j;
    @BindView(R.id.tabbar)
    TabLayout tabLayout;
    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @BindView(R.id.toolbar_container)
    ViewGroup toolbarContainer;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindDimen(R.dimen.wizard_tab_icon_padding)
    int wizardTabIconPadding;
    @BindDimen(R.dimen.wizard_tab_icon_size)
    int wizardTabIconSize;

    /* loaded from: classes3.dex */
    class c extends OnBackPressedCallback {
        c(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            WizardActivity.this.handleBackPressed();
        }
    }

    /* loaded from: classes3.dex */
    class d implements SearchView.OnQueryTextListener {
        d() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            EventBusUtils.getEventBus().post(new FilterEvent(str));
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f16526a;

        h(List list) {
            this.f16526a = list;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00a2 A[LOOP:0: B:14:0x009c->B:16:0x00a2, LOOP_END] */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onClick(android.view.View r8) {
            /*
                r7 = this;
                com.arlosoft.macrodroid.wizard.WizardActivity r8 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.arlosoft.macrodroid.macro.Macro r8 = com.arlosoft.macrodroid.wizard.WizardActivity.v(r8)
                java.util.List r0 = r7.f16526a
                r8.restoreItems(r0)
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.List r0 = r7.f16526a
                r1 = 0
                java.lang.Object r0 = r0.get(r1)
                com.arlosoft.macrodroid.macro.RemovedItem r0 = (com.arlosoft.macrodroid.macro.RemovedItem) r0
                com.arlosoft.macrodroid.common.SelectableItem r0 = r0.getItem()
                boolean r0 = r0 instanceof com.arlosoft.macrodroid.triggers.Trigger
                if (r0 == 0) goto L38
                com.arlosoft.macrodroid.wizard.WizardActivity r0 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.google.android.material.tabs.TabLayout r0 = r0.tabLayout
                com.google.android.material.tabs.TabLayout$Tab r0 = r0.getTabAt(r1)
                com.arlosoft.macrodroid.wizard.WizardActivity r2 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.arlosoft.macrodroid.macro.Macro r2 = com.arlosoft.macrodroid.wizard.WizardActivity.v(r2)
                java.util.ArrayList r2 = r2.getTriggerListWithAwaitingActions()
                r8.addAll(r2)
            L36:
                r2 = 0
                goto L88
            L38:
                java.util.List r0 = r7.f16526a
                java.lang.Object r0 = r0.get(r1)
                com.arlosoft.macrodroid.macro.RemovedItem r0 = (com.arlosoft.macrodroid.macro.RemovedItem) r0
                com.arlosoft.macrodroid.common.SelectableItem r0 = r0.getItem()
                boolean r0 = r0 instanceof com.arlosoft.macrodroid.action.Action
                if (r0 == 0) goto L5f
                com.arlosoft.macrodroid.wizard.WizardActivity r0 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.google.android.material.tabs.TabLayout r0 = r0.tabLayout
                r2 = 1
                com.google.android.material.tabs.TabLayout$Tab r0 = r0.getTabAt(r2)
                com.arlosoft.macrodroid.wizard.WizardActivity r3 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.arlosoft.macrodroid.macro.Macro r3 = com.arlosoft.macrodroid.wizard.WizardActivity.v(r3)
                java.util.ArrayList r3 = r3.getActions()
                r8.addAll(r3)
                goto L88
            L5f:
                java.util.List r0 = r7.f16526a
                java.lang.Object r0 = r0.get(r1)
                com.arlosoft.macrodroid.macro.RemovedItem r0 = (com.arlosoft.macrodroid.macro.RemovedItem) r0
                com.arlosoft.macrodroid.common.SelectableItem r0 = r0.getItem()
                boolean r0 = r0 instanceof com.arlosoft.macrodroid.constraint.Constraint
                if (r0 == 0) goto L86
                com.arlosoft.macrodroid.wizard.WizardActivity r0 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.google.android.material.tabs.TabLayout r0 = r0.tabLayout
                r2 = 2
                com.google.android.material.tabs.TabLayout$Tab r0 = r0.getTabAt(r2)
                com.arlosoft.macrodroid.wizard.WizardActivity r3 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                com.arlosoft.macrodroid.macro.Macro r3 = com.arlosoft.macrodroid.wizard.WizardActivity.v(r3)
                java.util.List r3 = r3.getConstraints()
                r8.addAll(r3)
                goto L88
            L86:
                r0 = 0
                goto L36
            L88:
                android.view.View r0 = r0.getCustomView()
                r3 = 2131363054(0x7f0a04ee, float:1.8345906E38)
                android.view.View r0 = r0.findViewById(r3)
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                r0.removeAllViews()
                java.util.Iterator r8 = r8.iterator()
            L9c:
                boolean r3 = r8.hasNext()
                if (r3 == 0) goto Lcd
                java.lang.Object r3 = r8.next()
                com.arlosoft.macrodroid.common.SelectableItem r3 = (com.arlosoft.macrodroid.common.SelectableItem) r3
                android.widget.ImageView r4 = new android.widget.ImageView
                com.arlosoft.macrodroid.wizard.WizardActivity r5 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                r4.<init>(r5)
                androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = new androidx.appcompat.widget.LinearLayoutCompat$LayoutParams
                com.arlosoft.macrodroid.wizard.WizardActivity r6 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                int r6 = r6.wizardTabIconSize
                r5.<init>(r6, r6)
                r4.setLayoutParams(r5)
                com.arlosoft.macrodroid.wizard.WizardActivity r5 = com.arlosoft.macrodroid.wizard.WizardActivity.this
                int r5 = r5.wizardTabIconPadding
                r4.setPadding(r5, r5, r5, r1)
                int r3 = r3.getIcon()
                r4.setImageResource(r3)
                r0.addView(r4)
                goto L9c
            Lcd:
                de.greenrobot.event.EventBus r8 = com.arlosoft.macrodroid.events.EventBusUtils.getEventBus()
                com.arlosoft.macrodroid.events.MacroUpdateEvent r0 = new com.arlosoft.macrodroid.events.MacroUpdateEvent
                r1 = 3
                r3 = -1
                r0.<init>(r1, r2, r3, r3)
                r8.post(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.wizard.WizardActivity.h.onClick(android.view.View):void");
        }
    }

    /* loaded from: classes3.dex */
    private class i extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private Fragment f16528a;

        public i(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment a() {
            return this.f16528a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return WizardFragment.Companion.newInstance(2);
                }
                return WizardFragment.Companion.newInstance(1);
            }
            return WizardFragment.Companion.newInstance(0);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return WizardActivity.this.getString(R.string.constraints);
                }
                return WizardActivity.this.getString(R.string.actions);
            }
            return WizardActivity.this.getString(R.string.triggers);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i4, Object obj) {
            if (a() != obj) {
                this.f16528a = (Fragment) obj;
            }
            super.setPrimaryItem(viewGroup, i4, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(DialogInterface dialogInterface, int i4) {
        MacroStore.getInstance().removeMacro(this.f16508f, true);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(Menu menu, MenuItem menuItem, View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        boolean isIconified = this.f16509g.isIconified();
        for (int i12 = 0; i12 < menu.size(); i12++) {
            MenuItem item = menu.getItem(i12);
            if (item != menuItem) {
                item.setVisible(isIconified);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Spinner spinner, EditText editText, AppCompatDialog appCompatDialog, View view) {
        K(spinner, editText.getText().toString());
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(Spinner spinner, AppCompatDialog appCompatDialog, View view) {
        spinner.setSelection(0);
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.category);
        builder.setMessage(R.string.to_help_organise_macros);
        builder.setNegativeButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(AppCompatDialog appCompatDialog, EditText editText, Spinner spinner, View view) {
        appCompatDialog.dismiss();
        boolean isConfiguringShortcut = this.f16508f.isConfiguringShortcut();
        this.f16508f.setName(editText.getText().toString());
        this.f16508f.setCategory((String) spinner.getSelectedItem());
        this.f16508f.setCompleted(true);
        this.f16508f.setConfiguringShortcut(false);
        MacroStore.getInstance().addMacro(this.f16508f);
        MacroStore.getInstance().writeToJSON();
        Settings.setLastEditedMacroGuid(this, this.f16508f.getGUID());
        Settings.setLastOpenedMacroGuid(this, this.f16508f.getGUID());
        if (isConfiguringShortcut) {
            y();
            return;
        }
        Intent intent = new Intent(this, NewHomeScreenActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        AdvertActivity.setShowAdvertOnNextResume(null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(final Spinner spinner) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, this.f16512j);
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
        editText.addTextChangedListener(new g(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: w0.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WizardActivity.this.C(spinner, editText, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: w0.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WizardActivity.D(spinner, appCompatDialog, view);
            }
        });
        appCompatDialog.show();
        ViewExtensionsKt.focusAndShowKeyboard(editText);
    }

    private void I(boolean z3) {
        float f4;
        FloatingActionButton floatingActionButton = this.fab;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.8f;
        }
        floatingActionButton.setAlpha(f4);
    }

    private void J() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, this.f16512j);
        appCompatDialog.setContentView(R.layout.enter_name_and_category);
        appCompatDialog.setTitle(R.string.macro_name_and_category);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            layoutParams.width = -1;
        }
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_name_and_category_name);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.enter_name_and_category_spinner);
        K(spinner, null);
        spinner.setOnItemSelectedListener(new e(spinner));
        editText.addTextChangedListener(new f(button, editText));
        ((ImageView) appCompatDialog.findViewById(R.id.enter_name_and_category_help)).setOnClickListener(new View.OnClickListener() { // from class: w0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WizardActivity.this.E(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: w0.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WizardActivity.this.F(appCompatDialog, editText, spinner, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: w0.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    private void K(Spinner spinner, String str) {
        List<String> categories = Util.getCategories(this);
        if (str != null) {
            categories.add(str);
        }
        categories.add("[" + getString(R.string.new_category) + "]");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, categories);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        if (str != null) {
            spinner.setSelection(spinner.getCount() - 2);
        }
    }

    static int w(int i4, int i5, float f4) {
        float f5 = 1.0f - f4;
        return Color.rgb((int) ((Color.red(i4) * f4) + (Color.red(i5) * f5)), (int) ((Color.green(i4) * f4) + (Color.green(i5) * f5)), (int) ((Color.blue(i4) * f4) + (Color.blue(i5) * f5)));
    }

    private void x() {
        HashSet hashSet = new HashSet();
        Iterator<Trigger> it = this.f16508f.getTriggerListWithAwaitingActions().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            hashSet.addAll(Arrays.asList(next.getRequiredPermissions()));
            if (!next.hasAllSpecialPermissions(this)) {
                return;
            }
        }
        Iterator<Action> it2 = this.f16508f.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            hashSet.addAll(Arrays.asList(next2.getRequiredPermissions()));
            if (!next2.hasAllSpecialPermissions(this)) {
                return;
            }
        }
        for (Constraint constraint : this.f16508f.getConstraints()) {
            hashSet.addAll(Arrays.asList(constraint.getRequiredPermissions()));
            if (!constraint.hasAllSpecialPermissions(this)) {
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && hashSet.size() != 0) {
            new RxPermissions(this).request((String[]) hashSet.toArray(new String[0])).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: w0.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    WizardActivity.this.z((Boolean) obj);
                }
            });
            return;
        }
        J();
    }

    private void y() {
        Intent intent = new Intent();
        intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", this.f16508f.getName());
        setResult(-1, intent);
        AdvertActivity.setShowAdvertOnNextResume(null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            J();
        }
    }

    public Macro getMacro() {
        return this.f16508f;
    }

    public void handleBackPressed() {
        if (this.f16508f.getTriggerListWithAwaitingActions().size() <= 0 && this.f16508f.getActions().size() <= 0 && this.f16508f.getConstraints().size() <= 0) {
            finish();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, this.f16512j);
        builder.setMessage(R.string.discard_confirm);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: w0.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                WizardActivity.this.A(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemCancelled() {
        WizardFragment wizardFragment = (WizardFragment) this.f16511i.a();
        if (wizardFragment != null) {
            wizardFragment.itemCancelled();
        }
    }

    @Override // com.arlosoft.macrodroid.widget.ItemFinishedListener
    public void itemComplete(Object obj) {
        WizardFragment wizardFragment = (WizardFragment) this.f16511i.a();
        if (wizardFragment != null) {
            wizardFragment.itemComplete(obj);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        WizardFragment wizardFragment = (WizardFragment) this.f16511i.a();
        if (wizardFragment != null) {
            wizardFragment.handleActivityResult(i4, i5, intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        int safeInsetTop;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 28) {
            rootWindowInsets = getWindow().getDecorView().getRootWindowInsets();
            displayCutout = rootWindowInsets.getDisplayCutout();
            if (displayCutout != null) {
                ViewGroup viewGroup = this.toolbarContainer;
                int paddingLeft = this.toolBar.getPaddingLeft();
                safeInsetTop = displayCutout.getSafeInsetTop();
                viewGroup.setPadding(paddingLeft, safeInsetTop, this.toolBar.getPaddingRight(), this.toolBar.getPaddingBottom());
                return;
            }
            this.toolbarContainer.setPadding(this.toolBar.getPaddingLeft(), i(), this.toolBar.getPaddingRight(), this.toolBar.getPaddingBottom());
            return;
        }
        this.toolbarContainer.setPadding(this.toolBar.getPaddingLeft(), i(), this.toolBar.getPaddingRight(), this.toolBar.getPaddingBottom());
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i4;
        super.onCreate(bundle);
        setContentView(R.layout.activity_wizard);
        ButterKnife.bind(this);
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().getDecorView().setSystemUiVisibility(1024);
        getWindow().setStatusBarColor(0);
        setSupportActionBar(this.toolBar);
        getSupportActionBar().setTitle(R.string.create_macro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.f16512j = R.style.Theme_App_Dialog_Trigger;
        if (bundle != null) {
            this.f16508f = (Macro) bundle.getParcelable("Macro");
        } else {
            Macro macro = (Macro) getIntent().getParcelableExtra("Macro");
            this.f16508f = macro;
            if (macro == null) {
                this.f16508f = new Macro();
            }
        }
        int[] iArr = {ContextCompat.getColor(this, R.color.trigger_primary), ContextCompat.getColor(this, R.color.actions_primary), ContextCompat.getColor(this, R.color.constraints_primary)};
        i iVar = new i(getSupportFragmentManager());
        this.f16511i = iVar;
        this.viewPager.setAdapter(iVar);
        this.viewPager.setOffscreenPageLimit(3);
        this.viewPager.addOnPageChangeListener(new a(iArr));
        if (bundle != null) {
            i4 = bundle.getInt("tab_position", 0);
        } else {
            i4 = 0;
        }
        this.toolbarContainer.setBackgroundColor(iArr[i4]);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b());
        for (int i5 = 0; i5 < this.tabLayout.getTabCount(); i5++) {
            TabLayout.Tab tabAt = this.tabLayout.getTabAt(i5);
            View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_tab, (ViewGroup) null);
            tabAt.setCustomView(inflate);
            ((TextView) inflate.findViewById(R.id.title)).setText(tabAt.getText());
        }
        I(this.f16508f.isValid());
        EventBusUtils.getEventBus().register(this);
        if (getIntent().getBooleanExtra(Util.ADD_WEAR_TRIGGER_EXTRA, false)) {
            new AndroidWearTrigger(this, this.f16508f).setAndroidWearAppOption();
        }
        getOnBackPressedDispatcher().addCallback(this, new c(true));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.wizard_menu, menu);
        final MenuItem findItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(findItem);
        this.f16509g = searchView;
        searchView.setMaxWidth(Integer.MAX_VALUE);
        this.f16509g.setOnQueryTextListener(new d());
        menu.findItem(R.id.menu_show_categories).setChecked(Settings.getShowCategoriesSelectableItems(this));
        this.f16509g.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: w0.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                WizardActivity.this.B(menu, findItem, view, i4, i5, i6, i7, i8, i9, i10, i11);
            }
        });
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBusUtils.getEventBus().unregister(this);
    }

    public void onEventMainThread(MacroUpdateEvent macroUpdateEvent) {
        TabLayout.Tab tab;
        I(this.f16508f.isValid());
        ArrayList arrayList = new ArrayList();
        int i4 = macroUpdateEvent.itemType;
        int i5 = 0;
        if (i4 == 0) {
            tab = this.tabLayout.getTabAt(0);
            arrayList.addAll(this.f16508f.getTriggerListWithAwaitingActions());
        } else if (i4 == 1) {
            tab = this.tabLayout.getTabAt(1);
            arrayList.addAll(this.f16508f.getActions());
        } else if (i4 == 2) {
            tab = this.tabLayout.getTabAt(2);
            arrayList.addAll(this.f16508f.getConstraints());
        } else {
            tab = null;
        }
        LinearLayout linearLayout = (LinearLayout) tab.getCustomView().findViewById(R.id.icons_layout);
        int i6 = macroUpdateEvent.eventType;
        if (i6 == 0) {
            ImageView imageView = new ImageView(this);
            int i7 = this.wizardTabIconSize;
            imageView.setLayoutParams(new LinearLayoutCompat.LayoutParams(i7, i7));
            int i8 = this.wizardTabIconPadding;
            imageView.setPadding(i8, i8, i8, 0);
            imageView.setImageResource(((SelectableItem) arrayList.get(macroUpdateEvent.position1)).getIcon());
            linearLayout.addView(imageView);
        } else if (i6 == 1) {
            linearLayout.removeViewAt(macroUpdateEvent.position1);
        } else if (i6 == 2) {
            View childAt = linearLayout.getChildAt(macroUpdateEvent.position1);
            linearLayout.removeViewAt(macroUpdateEvent.position1);
            linearLayout.addView(childAt, macroUpdateEvent.position2);
        }
        if (linearLayout.getChildCount() == 0) {
            i5 = 8;
        }
        linearLayout.setVisibility(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.fab})
    public void onFabClicked() {
        String string;
        if (!this.f16508f.isValid()) {
            if (this.f16508f.getTriggerListWithAwaitingActions().size() == 0) {
                string = getString(R.string.please_add_a_trigger);
            } else if (this.f16508f.getActions().size() == 0) {
                string = getString(R.string.please_add_an_action);
            } else {
                string = getString(R.string.ensure_valid_macro);
            }
            Util.displayErrorDialog(this, getString(R.string.invalid_macro), string, this.f16512j);
            return;
        }
        x();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_help) {
                if (itemId != R.id.menu_show_categories) {
                    return super.onOptionsItemSelected(menuItem);
                }
                boolean z3 = !Settings.getShowCategoriesSelectableItems(this);
                Settings.setShowCategoriesSelectableItems(this, z3);
                menuItem.setChecked(z3);
                EventBusUtils.getEventBus().post(new CategoryModeUpdateEvent());
                return true;
            }
            this.f16510h = !this.f16510h;
            EventBusUtils.getEventBus().post(new SetHelpVisibilityEvent(this.f16510h));
            return true;
        }
        handleBackPressed();
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("Macro", this.f16508f);
        bundle.putInt("tab_position", this.viewPager.getCurrentItem());
    }

    public void showDeleteUndo(List<RemovedItem> list) {
        SnackbarAnimate make = SnackbarAnimate.make(findViewById(R.id.top_container), String.format(getString(R.string.deleted_with_name), list.get(0).getItem().getConfiguredName()), (int) EditMacroActivity.UNDO_PROMPT_TIMEOUT);
        make.setAction(R.string.undo, new h(list));
        make.getView().setBackgroundResource(R.color.undo_bar_background);
        ((TextView) make.getView().findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(this, R.color.undo_bar_foreground));
        ((TextView) make.getView().findViewById(R.id.snackbar_action)).setTextColor(ContextCompat.getColor(this, R.color.undo_bar_foreground));
        make.show();
    }

    /* loaded from: classes3.dex */
    class a implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f16513a;

        a(int[] iArr) {
            this.f16513a = iArr;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i4, float f4, int i5) {
            if (i4 >= WizardActivity.this.viewPager.getAdapter().getCount() - 1) {
                return;
            }
            int[] iArr = this.f16513a;
            int w3 = WizardActivity.w(iArr[i4 + 1], iArr[i4], f4);
            WizardActivity.this.toolbarContainer.setBackgroundColor(w3);
            Drawable mutate = DrawableCompat.wrap(WizardActivity.this.fab.getDrawable()).mutate();
            DrawableCompat.setTint(mutate, w3);
            WizardActivity.this.fab.setImageDrawable(mutate);
            mutate.invalidateSelf();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        WizardActivity.this.f16512j = R.style.Theme_App_Dialog_Constraint;
                        return;
                    }
                    return;
                }
                WizardActivity.this.f16512j = R.style.Theme_App_Dialog_Action;
                return;
            }
            WizardActivity.this.f16512j = R.style.Theme_App_Dialog_Trigger;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i4) {
        }
    }

    /* loaded from: classes3.dex */
    class b implements TabLayout.OnTabSelectedListener {
        b() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
            EventBusUtils.getEventBus().post(new WizardScrollToTopEvent(tab.getPosition()));
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Spinner f16518a;

        e(Spinner spinner) {
            this.f16518a = spinner;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (i4 == this.f16518a.getCount() - 1) {
                WizardActivity.this.H(this.f16518a);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f16520a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f16521b;

        f(Button button, EditText editText) {
            this.f16520a = button;
            this.f16521b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f16520a;
            if (this.f16521b.getText().length() > 0) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f16523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f16524b;

        g(Button button, EditText editText) {
            this.f16523a = button;
            this.f16524b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f16523a;
            if (this.f16524b.getText().length() > 0) {
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
