package com.arlosoft.macrodroid.variables;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.VariableUpdatedEvent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class MacroDroidVariablesActivity extends MacroDroidDaggerBaseActivity {
    @Inject

    /* renamed from: f  reason: collision with root package name */
    PremiumStatusHandler f16172f;
    @BindView(R.id.filterPanel)
    ViewGroup filterPanel;

    /* renamed from: g  reason: collision with root package name */
    private p f16173g;

    /* renamed from: h  reason: collision with root package name */
    private Macro f16174h;
    @BindView(R.id.local_variable_checkbox)
    CheckBox localVariableCheckbox;
    @BindView(R.id.local_variable_option_layout)
    ViewGroup localVariableOptionLayout;
    @BindView(R.id.variables_activity_list)
    ListView m_list;
    @BindView(R.id.rootContainer)
    LinearLayout rootContainer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.variableTypeSpinner)
    Spinner variableTypeSpinner;

    /* loaded from: classes3.dex */
    class b implements com.arlosoft.macrodroid.variables.a {
        b() {
        }

        @Override // com.arlosoft.macrodroid.variables.a
        public void a() {
            MacroDroidVariablesActivity.this.refreshEmptyState();
        }
    }

    /* loaded from: classes3.dex */
    class c implements VariableHelper.NewVariableCreationListener {
        c() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
        public void newVariableCreated(@NonNull MacroDroidVariable macroDroidVariable, boolean z3) {
            MacroDroidVariableStore.getInstance().addVariable(macroDroidVariable);
            MacroDroidVariablesActivity.this.A(macroDroidVariable);
            MacroDroidVariablesActivity.this.refreshEmptyState();
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.NewVariableCreationListener
        public boolean validateVariableName(String str) {
            if (MacroDroidVariableStore.getInstance().getVariableByName(str) == null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    class d implements SearchView.OnQueryTextListener {
        d() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            MacroDroidVariablesActivity.this.f16173g.J(str);
            MacroDroidVariablesActivity.this.refresh();
            return true;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(MacroDroidVariable macroDroidVariable) {
        refresh();
        this.m_list.smoothScrollToPosition(this.f16173g.t(macroDroidVariable));
    }

    private void B() {
        ViewGroup viewGroup = this.filterPanel;
        int i4 = 8;
        if (viewGroup.getVisibility() == 8) {
            i4 = 0;
        }
        viewGroup.setVisibility(i4);
    }

    public static Intent createIntent(@NonNull Context context, @Nullable long j4) {
        Intent intent = new Intent(context, MacroDroidVariablesActivity.class);
        intent.putExtra("localMacro", j4);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (!this.localVariableCheckbox.isChecked()) {
            this.f16173g.H(null);
        } else {
            this.f16173g.H(this.f16174h);
        }
        this.f16173g.notifyDataSetChanged();
        refreshEmptyState();
    }

    private void t() {
        List<MacroDroidVariable> allVariables = MacroDroidVariableStore.getInstance().getAllVariables(false);
        HashMap<String, List<Macro>> s3 = this.f16173g.s();
        for (MacroDroidVariable macroDroidVariable : allVariables) {
            if (!s3.containsKey(macroDroidVariable.getName())) {
                MacroDroidVariableStore.getInstance().removeVariable(macroDroidVariable.getName());
            }
        }
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(DialogInterface dialogInterface, int i4) {
        MacroDroidVariableStore.getInstance().clearAllVariables();
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(DialogInterface dialogInterface, int i4) {
        t();
    }

    private void y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.delete_all_variables);
        builder.setMessage(R.string.please_confirm_operation);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidVariablesActivity.this.u(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    private void z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.delete_unused_variables);
        builder.setMessage(R.string.please_confirm_operation);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                MacroDroidVariablesActivity.this.w(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.variables.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.variables_activity);
        ButterKnife.bind(this);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.variables_title);
        this.variableTypeSpinner.setOnItemSelectedListener(new a());
        this.rootContainer.getLayoutTransition().enableTransitionType(4);
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getLongExtra("localMacro", -1L));
        this.f16174h = macroByGUID;
        if (macroByGUID != null) {
            if (macroByGUID.isActionBlock) {
                CheckBox checkBox = this.localVariableCheckbox;
                checkBox.setText(getString(R.string.this_action_block_only) + " (" + this.f16174h.getName() + ")");
            } else {
                CheckBox checkBox2 = this.localVariableCheckbox;
                checkBox2.setText(getString(R.string.this_macro_only) + " (" + this.f16174h.getName() + ")");
            }
            this.localVariableOptionLayout.setVisibility(0);
            this.localVariableCheckbox.setChecked(true);
        } else {
            this.localVariableOptionLayout.setVisibility(8);
        }
        p pVar = new p(this, this.f16174h, !Settings.shouldHideInfoCardVariables(this), new b());
        this.f16173g = pVar;
        this.m_list.setAdapter((ListAdapter) pVar);
        EventBusUtils.getEventBus().register(this);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.variable_activity_menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.menu_search));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setElevation(0.0f);
        searchView.setOnQueryTextListener(new d());
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        super.onDestroy();
    }

    public void onEventMainThread(VariableUpdatedEvent variableUpdatedEvent) {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnCheckedChanged({R.id.local_variable_checkbox})
    public void onLocalVariableCheckboxChanged(boolean z3) {
        Macro macro;
        p pVar = this.f16173g;
        if (pVar != null) {
            if (z3) {
                macro = this.f16174h;
            } else {
                macro = null;
            }
            pVar.H(macro);
            this.f16173g.notifyDataSetChanged();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                return true;
            case R.id.menu_delete_all /* 2131363388 */:
                y();
                return true;
            case R.id.menu_delete_unused /* 2131363389 */:
                z();
                return true;
            case R.id.menu_filter /* 2131363395 */:
                B();
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.fab})
    public void onPlusButtonClicked() {
        VariableHelper.createNewVariable(this, this.f16172f.getPremiumStatus().isPro(), false, R.style.Theme_App_Dialog_Variables, false, false, R.layout.simple_spinner_dropdown_item_2_lines, "#999999", false, null, null, new c());
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refresh();
    }

    public void refreshEmptyState() {
        int i4;
        int i5 = !Settings.shouldHideInfoCardVariables(this);
        View findViewById = findViewById(R.id.variables_emptyView);
        if (this.f16173g.getCount() == i5) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        findViewById.setVisibility(i4);
    }

    /* loaded from: classes3.dex */
    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            MacroDroidVariablesActivity.this.f16173g.K(i4 - 1);
            MacroDroidVariablesActivity.this.refresh();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
