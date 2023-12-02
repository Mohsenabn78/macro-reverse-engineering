package com.arlosoft.macrodroid.celltowers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.celltowers.CellTowerListActivity;
import com.arlosoft.macrodroid.constraint.CellTowerConstraint;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.CellTowerTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CellTowerListActivity extends MacroDroidBaseActivity {
    public static final String EXTRA_CELL_TOWER_GROUP_NAME = "CellTowerGroupName";
    public static final String EXTRA_CELL_TOWER_LIST = "CellTowerList";
    public static final String EXTRA_EDIT_MODE_ON = "EditModeOn";
    public static final String EXTRA_THEME_TYPE = "ThemeType";
    public static final int THEME_TYPE_CONDITION = 3;
    public static final int THEME_TYPE_CONSTRAINT = 2;
    public static final int THEME_TYPE_TRIGGER = 1;

    /* renamed from: f  reason: collision with root package name */
    private CellTowerGroupStore f9647f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9648g;

    /* renamed from: h  reason: collision with root package name */
    private d f9649h;

    /* renamed from: i  reason: collision with root package name */
    private int f9650i;
    @BindView(R.id.infoCardDetail)
    TextView infoCardDetail;
    @BindView(R.id.infoCardGotIt)
    Button infoCardGotIt;
    @BindView(R.id.infoCardTitle)
    TextView infoCardTitle;
    @BindView(R.id.infoCardView)
    CardView infoCardView;
    @BindView(R.id.cell_tower_add_button)
    FloatingActionButton m_addCellTowerButton;
    @BindView(R.id.cell_tower_group_list)
    ListView m_groupList;

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CellTowerListActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private List<CellTowerGroup> f9657a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Context> f9658b;

        public d(Context context, List<CellTowerGroup> list) {
            this.f9657a = list;
            this.f9658b = new WeakReference<>(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(CellTowerGroup cellTowerGroup, View view) {
            CellTowerListActivity.this.groupClicked(cellTowerGroup);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean d(CellTowerGroup cellTowerGroup, View view) {
            CellTowerListActivity.this.groupLongClicked(cellTowerGroup);
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f9657a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return this.f9657a.get(i4);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"NewApi"})
        public View getView(int i4, View view, ViewGroup viewGroup) {
            final CellTowerGroup cellTowerGroup = (CellTowerGroup) getItem(i4);
            Context context = this.f9658b.get();
            if (context == null) {
                return view;
            }
            if (view == null) {
                view = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.cell_tower_group_list_item, (ViewGroup) null);
            }
            CardView cardView = (CardView) view.findViewById(R.id.container);
            ImageView imageView = (ImageView) view.findViewById(R.id.cell_tower_group_list_item_icon);
            TextView textView = (TextView) view.findViewById(R.id.cell_tower_group_list_towers_label);
            ((TextView) view.findViewById(R.id.cell_tower_group_list_item_name)).setText(cellTowerGroup.getName());
            int size = cellTowerGroup.getCellTowerIds().size();
            if (size == 1) {
                textView.setText(R.string.trigger_cell_tower_one_tower);
            } else {
                textView.setText(size + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getString(R.string.trigger_cell_tower_towers));
            }
            if (CellTowerListActivity.this.f9650i != 0) {
                int i5 = CellTowerListActivity.this.f9650i;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            cardView.setCardBackgroundColor(ContextCompat.getColor(CellTowerListActivity.this, R.color.actions_primary));
                            imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(CellTowerListActivity.this, R.color.actions_primary)));
                        }
                    } else {
                        cardView.setCardBackgroundColor(ContextCompat.getColor(CellTowerListActivity.this, R.color.constraints_primary));
                        imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(CellTowerListActivity.this, R.color.constraints_primary)));
                    }
                } else {
                    cardView.setCardBackgroundColor(ContextCompat.getColor(CellTowerListActivity.this, R.color.trigger_primary));
                    imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(CellTowerListActivity.this, R.color.trigger_primary)));
                }
            }
            cardView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CellTowerListActivity.d.this.c(cellTowerGroup, view2);
                }
            });
            cardView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.celltowers.s
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean d4;
                    d4 = CellTowerListActivity.d.this.d(cellTowerGroup, view2);
                    return d4;
                }
            });
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(CellTowerGroup cellTowerGroup, DialogInterface dialogInterface, int i4) {
        if (CellTowerBackgroundScanService.getCurrentScanGroup() != null && CellTowerBackgroundScanService.getCurrentScanGroup().equals(cellTowerGroup.getName())) {
            CellTowerBackgroundScanService.cancelScanning(this);
        }
        this.f9647f.removeGroup(cellTowerGroup);
        this.f9647f.persistData();
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(AppCompatEditText appCompatEditText, DialogInterface dialogInterface, int i4) {
        Intent intent = new Intent(this, CellTowerGroupActivity.class);
        intent.putExtra(CellTowerGroupActivity.EXTRA_NEW_GROUP_NAME, appCompatEditText.getText().toString());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(EditText editText, CellTowerGroup cellTowerGroup, String str, AppCompatDialog appCompatDialog, View view) {
        String obj = editText.getText().toString();
        cellTowerGroup.setName(obj);
        this.f9647f.persistData();
        F();
        G(str, obj);
        MacroStore.getInstance().writeToJSON();
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(CellTowerGroup cellTowerGroup, DialogInterface dialogInterface, int i4) {
        if (i4 == 0) {
            w(cellTowerGroup);
        } else if (i4 == 1) {
            Intent intent = new Intent(this, CellTowerGroupActivity.class);
            intent.putExtra("CellTowerGroupName", cellTowerGroup.getName());
            startActivityForResult(intent, 22);
        } else if (i4 == 2) {
            u(cellTowerGroup);
        }
    }

    private void F() {
        d dVar = new d(this, this.f9647f.getCellTowerGroupsSorted());
        this.f9649h = dVar;
        this.m_groupList.setAdapter((ListAdapter) dVar);
    }

    private void G(String str, String str2) {
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosIncludingExtras()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof CellTowerTrigger) {
                    CellTowerTrigger cellTowerTrigger = (CellTowerTrigger) next;
                    if (cellTowerTrigger.getCellGroupName().equals(str)) {
                        cellTowerTrigger.setCellGroupName(str2);
                    }
                }
                for (Constraint constraint : next.getConstraints()) {
                    H(constraint, str, str2);
                }
            }
            Iterator<Action> it2 = macro.getActions().iterator();
            while (it2.hasNext()) {
                for (Constraint constraint2 : it2.next().getConstraints()) {
                    H(constraint2, str, str2);
                }
            }
            for (Constraint constraint3 : macro.getConstraints()) {
                H(constraint3, str, str2);
            }
        }
    }

    private void H(Constraint constraint, String str, String str2) {
        if (constraint instanceof CellTowerConstraint) {
            CellTowerConstraint cellTowerConstraint = (CellTowerConstraint) constraint;
            if (cellTowerConstraint.getCellGroupName().equals(str)) {
                cellTowerConstraint.setCellGroupName(str2);
            }
        }
        if (constraint instanceof LogicConstraint) {
            for (Constraint constraint2 : ((LogicConstraint) constraint).getConstraints()) {
                H(constraint2, str, str2);
            }
        }
    }

    private void t() {
        int i4;
        if (Settings.shouldHideInfoCardCellTowers(this)) {
            this.infoCardView.setVisibility(8);
            return;
        }
        int i5 = this.f9650i;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        i4 = R.color.condition_primary;
                    }
                } else {
                    i4 = R.color.constraints_primary;
                }
            } else {
                i4 = R.color.trigger_primary;
            }
            this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, i4));
            this.infoCardTitle.setText(R.string.cell_tower_groups);
            this.infoCardDetail.setText(R.string.cell_towers_info_card);
            this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CellTowerListActivity.this.z(view);
                }
            });
        }
        i4 = R.color.cell_towers_primary;
        this.infoCardView.setCardBackgroundColor(ContextCompat.getColor(this, i4));
        this.infoCardTitle.setText(R.string.cell_tower_groups);
        this.infoCardDetail.setText(R.string.cell_towers_info_card);
        this.infoCardGotIt.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CellTowerListActivity.this.z(view);
            }
        });
    }

    private void u(final CellTowerGroup cellTowerGroup) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, y());
        builder.setTitle(R.string.delete_cell_tower_group);
        builder.setMessage(getString(R.string.are_you_sure_delete_cell_tower_group) + ": " + cellTowerGroup.getName());
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CellTowerListActivity.this.A(cellTowerGroup, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    private void v() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, y());
        builder.setTitle(R.string.trigger_cell_tower_add_group);
        final AppCompatEditText appCompatEditText = new AppCompatEditText(this);
        appCompatEditText.setInputType(524289);
        appCompatEditText.setHint(R.string.trigger_cell_tower_enter_group_name_hint);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        builder.setView(appCompatEditText, dimensionPixelOffset, getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin), dimensionPixelOffset, 0);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CellTowerListActivity.this.B(appCompatEditText, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        AlertDialog show = builder.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(show.getWindow().getAttributes());
        layoutParams.width = -1;
        show.getWindow().setAttributes(layoutParams);
        Button button = show.getButton(-1);
        button.setEnabled(false);
        appCompatEditText.addTextChangedListener(new c(button));
    }

    private void w(final CellTowerGroup cellTowerGroup) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, y());
        appCompatDialog.setContentView(R.layout.edit_cell_tower_group_name_dialog);
        appCompatDialog.setTitle(R.string.trigger_cell_tower_rename_group);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.edit_cell_tower_group_name_dialog_name);
        final String name = cellTowerGroup.getName();
        editText.setText(cellTowerGroup.getName());
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CellTowerListActivity.this.C(editText, cellTowerGroup, name, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private int x() {
        int i4 = this.f9650i;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return ContextCompat.getColor(this, R.color.cell_towers_primary);
                }
                return ContextCompat.getColor(this, R.color.condition_primary_dark);
            }
            return ContextCompat.getColor(this, R.color.constraints_primary_dark);
        }
        return ContextCompat.getColor(this, R.color.trigger_primary_dark);
    }

    private int y() {
        int i4 = this.f9650i;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return R.style.Theme_App_Dialog_CellTowers;
                }
                return R.style.Theme_App_Condition;
            }
            return R.style.Theme_App_Constraint;
        }
        return R.style.Theme_App_Dialog_Trigger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        Settings.hideInfoCardCellTowers(getApplicationContext());
        this.infoCardView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.cell_tower_add_button})
    public void addGeofenceButtonClick() {
        v();
    }

    public void groupClicked(@NonNull CellTowerGroup cellTowerGroup) {
        if (this.f9648g) {
            Intent intent = new Intent(this, CellTowerGroupActivity.class);
            intent.putExtra("CellTowerGroupName", cellTowerGroup.getName());
            startActivityForResult(intent, 22);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("CellTowerGroupName", cellTowerGroup.getName());
        intent2.putExtra(EXTRA_CELL_TOWER_LIST, cellTowerGroup.getCellTowerIds());
        setResult(-1, intent2);
        finish();
    }

    public void groupLongClicked(@NonNull final CellTowerGroup cellTowerGroup) {
        String[] strArr = {getString(R.string.trigger_cell_tower_rename_group), getString(R.string.trigger_cell_tower_edit_towers), getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(cellTowerGroup.getName()).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CellTowerListActivity.this.E(cellTowerGroup, dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int intExtra = getIntent().getIntExtra("ThemeType", 0);
        this.f9650i = intExtra;
        if (intExtra != 0) {
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra == 3) {
                        setTheme(R.style.Theme_App_Constraint_ColoredButton);
                    }
                } else {
                    setTheme(R.style.Theme_App_Constraint_ColoredButton);
                }
            } else {
                setTheme(R.style.Theme_App_Trigger_ColoredButton);
            }
        }
        super.onCreate(bundle);
        setContentView(R.layout.configure_cell_tower);
        ButterKnife.bind(this);
        this.f9647f = CellTowerGroupStore.getInstance();
        this.m_groupList.setEmptyView(findViewById(R.id.celltowers_emptyView));
        this.f9648g = getIntent().getBooleanExtra(EXTRA_EDIT_MODE_ON, false);
        this.m_addCellTowerButton.setBackgroundTintList(ColorStateList.valueOf(x()));
        t();
        if (!this.f9648g) {
            setTitle(R.string.select_cell_tower_group);
        } else {
            setTitle(R.string.cell_tower_groups);
        }
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            PermissionsHelper.showLocationDisclosureInfoDialog(this, null, false);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cell_tower_configure_menu, menu);
        return true;
    }

    public void onEventMainThread(CellTowerUpdateEvent cellTowerUpdateEvent) {
        F();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_ignored_towers) {
                if (itemId == R.id.menu_recent_towers) {
                    startActivity(new Intent(this, RecentCellTowersActivity.class));
                    return true;
                }
                return true;
            }
            startActivity(new Intent(this, IgnoredCellTowersActivity.class));
            return true;
        }
        finish();
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        EventBusUtils.getEventBus().unregister(this);
        super.onPause();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        F();
        if (Build.VERSION.SDK_INT >= 27) {
            try {
                if (Settings.Secure.getInt(getContentResolver(), "location_mode") == 0) {
                    SnackbarAnimate make = SnackbarAnimate.make(findViewById(R.id.coordinator_layout), getString(R.string.location_services_must_be_enabled), -2);
                    make.setAction(R.string.configure, new a());
                    make.setActionTextColor(-1);
                    make.getView().setBackgroundResource(R.color.macro_error);
                    make.show();
                }
            } catch (Settings.SettingNotFoundException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f9655a;

        c(Button button) {
            this.f9655a = button;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f9655a;
            if (i6 > 0) {
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
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f9652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f9653b;

        b(Button button, EditText editText) {
            this.f9652a = button;
            this.f9653b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f9652a;
            if (this.f9653b.getText().length() > 0) {
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
