package com.arlosoft.macrodroid.celltowers;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.celltowers.CellTowerGroupActivity;
import com.arlosoft.macrodroid.celltowers.CellTowerUtils;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.SnackbarAnimate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class CellTowerGroupActivity extends MacroDroidBaseActivity {
    public static final String EXTRA_CELL_TOWER_GROUP_NAME = "CellTowerGroupName";
    public static final String EXTRA_NEW_GROUP_NAME = "NewGroupName";

    /* renamed from: f  reason: collision with root package name */
    private CellTowerGroupStore f9613f;

    /* renamed from: g  reason: collision with root package name */
    private CellTowerGroup f9614g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9615h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f9616i;

    /* renamed from: j  reason: collision with root package name */
    private Set<String> f9617j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9618k;

    /* renamed from: l  reason: collision with root package name */
    private String f9619l;

    /* renamed from: m  reason: collision with root package name */
    private String f9620m;
    @BindView(R.id.cell_tower_count_text)
    TextView m_cellTowerCountText;
    @BindView(R.id.cell_tower_list)
    ListView m_cellTowerList;
    @BindView(R.id.cell_tower_done_button)
    FloatingActionButton m_fab;
    @BindView(R.id.cell_tower_scan_bg_button)
    Button m_scanBgButton;
    @BindView(R.id.cell_tower_scanning_layout)
    ViewGroup m_scanningLayout;
    @BindView(R.id.scanning_text)
    TextView m_scanningText;

    /* renamed from: n  reason: collision with root package name */
    private Database f9621n;

    /* renamed from: o  reason: collision with root package name */
    private d f9622o;

    /* loaded from: classes3.dex */
    class a extends OnBackPressedCallback {
        a(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            CellTowerGroupActivity.this.handleBackPressed();
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CellTowerGroupActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f9627a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<String> f9628b;

        /* renamed from: c  reason: collision with root package name */
        private Set<String> f9629c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f9630d;

        public d(Context context, ArrayList<String> arrayList, Set<String> set, Set<String> set2) {
            this.f9630d = set2;
            this.f9628b = arrayList;
            this.f9629c = set;
            this.f9627a = context;
        }

        private void f(final String str) {
            AlertDialog.Builder builder = new AlertDialog.Builder(CellTowerGroupActivity.this, R.style.Theme_App_Dialog_Settings);
            builder.setTitle(R.string.delete_cell_tower_group);
            builder.setMessage(CellTowerGroupActivity.this.getString(R.string.are_you_sure_delete_cell_tower) + ": " + str);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    CellTowerGroupActivity.d.this.g(str, dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(String str, DialogInterface dialogInterface, int i4) {
            this.f9628b.remove(str);
            this.f9629c.remove(str);
            CellTowerGroupActivity.this.setHasEdited();
            TextView textView = CellTowerGroupActivity.this.m_cellTowerCountText;
            textView.setText(this.f9628b.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + CellTowerGroupActivity.this.getString(R.string.tower_ids_found));
            notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(String str, f fVar, CompoundButton compoundButton, boolean z3) {
            float f4;
            int i4;
            if (z3) {
                this.f9629c.remove(str);
            } else {
                this.f9629c.add(str);
            }
            TextView textView = fVar.f9635b;
            if (z3) {
                f4 = 1.0f;
            } else {
                f4 = 0.5f;
            }
            textView.setAlpha(f4);
            Context applicationContext = CellTowerGroupActivity.this.getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            CellTowerGroupActivity cellTowerGroupActivity = CellTowerGroupActivity.this;
            if (z3) {
                i4 = R.string.added_to_group;
            } else {
                i4 = R.string.excluded_from_group;
            }
            sb.append(cellTowerGroupActivity.getString(i4));
            ToastCompat.makeText(applicationContext, (CharSequence) sb.toString(), !z3 ? 1 : 0).show();
            CellTowerGroupActivity.this.setHasEdited();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(String str, boolean z3, View view) {
            l(str, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean j(String str, boolean z3, View view) {
            l(str, z3);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(String str, boolean z3, DialogInterface dialogInterface, int i4) {
            if (i4 == 0) {
                f(str);
            } else if (i4 == 1) {
                ((ClipboardManager) CellTowerGroupActivity.this.getSystemService("clipboard")).setText(str);
                ToastCompat.makeText(CellTowerGroupActivity.this.getApplicationContext(), (int) R.string.copied_to_clipboard, 0).show();
            } else if (i4 == 2) {
                CellTowerGroupActivity.this.f9621n.setIgnoreCellTowerState(str, !z3);
                CellTowerGroupActivity.this.H();
            }
        }

        private void l(final String str, final boolean z3) {
            String string;
            String[] strArr = new String[3];
            strArr[0] = this.f9627a.getString(R.string.delete);
            strArr[1] = this.f9627a.getString(R.string.copy_clipboard);
            if (z3) {
                string = this.f9627a.getString(R.string.remove_from_global_ignore);
            } else {
                string = this.f9627a.getString(R.string.add_to_global_ignore);
            }
            strArr[2] = string;
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f9627a);
            builder.setTitle(str).setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    CellTowerGroupActivity.d.this.k(str, z3, dialogInterface, i4);
                }
            });
            builder.create().show();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f9628b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return this.f9628b.get(i4);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            final f fVar;
            float f4;
            final String str = (String) getItem(i4);
            if (view == null) {
                view = ((LayoutInflater) this.f9627a.getSystemService("layout_inflater")).inflate(R.layout.cell_tower_list_row, viewGroup, false);
                fVar = new f();
                fVar.f9635b = (TextView) view.findViewById(R.id.cellid_name);
                fVar.f9636c = (CheckBox) view.findViewById(R.id.cell_tower_list_row_checkbox);
                fVar.f9634a = (TextView) view.findViewById(R.id.cell_tower_list_row_item_count);
                view.setTag(fVar);
            } else {
                fVar = (f) view.getTag();
            }
            boolean contains = this.f9629c.contains(str);
            final boolean contains2 = this.f9630d.contains(str);
            fVar.f9634a.setText(String.valueOf(i4 + 1));
            if (str != null) {
                fVar.f9635b.setText(str);
                TextView textView = fVar.f9635b;
                if (contains) {
                    f4 = 0.5f;
                } else {
                    f4 = 1.0f;
                }
                textView.setAlpha(f4);
            }
            if (contains2) {
                fVar.f9634a.setBackgroundResource(R.drawable.circular_icon_background_cell_tower_disabled);
                fVar.f9634a.setTextColor(ContextCompat.getColor(this.f9627a, R.color.white));
                fVar.f9635b.setTextColor(ContextCompat.getColor(this.f9627a, R.color.white_very_transparent));
                fVar.f9636c.setVisibility(8);
            } else {
                fVar.f9634a.setBackgroundResource(R.drawable.circular_icon_white);
                fVar.f9634a.setTextColor(ContextCompat.getColor(this.f9627a, R.color.cell_towers_primary));
                fVar.f9635b.setTextColor(ContextCompat.getColor(this.f9627a, R.color.white));
                fVar.f9636c.setVisibility(0);
            }
            fVar.f9636c.setOnCheckedChangeListener(null);
            fVar.f9636c.setChecked(!contains);
            fVar.f9636c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.celltowers.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    CellTowerGroupActivity.d.this.h(str, fVar, compoundButton, z3);
                }
            });
            fVar.f9635b.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CellTowerGroupActivity.d.this.i(str, contains2, view2);
                }
            });
            fVar.f9635b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.celltowers.i
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean j4;
                    j4 = CellTowerGroupActivity.d.this.j(str, contains2, view2);
                    return j4;
                }
            });
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        TextView f9634a;

        /* renamed from: b  reason: collision with root package name */
        TextView f9635b;

        /* renamed from: c  reason: collision with root package name */
        CheckBox f9636c;

        f() {
        }
    }

    private void A(Intent intent) {
        this.f9619l = intent.getStringExtra(EXTRA_NEW_GROUP_NAME);
        this.f9613f = CellTowerGroupStore.getInstance();
        this.f9620m = intent.getStringExtra("CellTowerGroupName");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(EditText editText, DialogInterface dialogInterface, int i4) {
        this.f9616i.add(editText.getText().toString());
        this.f9622o.notifyDataSetChanged();
        setHasEdited();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(String str, int[] iArr, Spinner spinner, View view) {
        I();
        finish();
        Intent intent = new Intent(this, CellTowerBackgroundScanService.class);
        intent.putExtra(Constants.EXTRA_CELL_TOWER_GROUP_NAME, str);
        intent.putExtra(CellTowerBackgroundScanService.EXTRA_END_TIME, CellTowerBackgroundScanService.calculateEndTimeFromDuration(iArr[spinner.getSelectedItemPosition()]));
        startService(intent);
        ToastCompat.makeText(getApplicationContext(), (int) R.string.background_scanning_active, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(DialogInterface dialogInterface, int i4) {
        I();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        I();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        TextView textView = this.m_cellTowerCountText;
        textView.setText(this.f9616i.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(R.string.tower_ids_found));
        d dVar = new d(this, this.f9616i, this.f9617j, this.f9621n.getIgnoreCellTowerSet());
        this.f9622o = dVar;
        this.m_cellTowerList.setAdapter((ListAdapter) dVar);
    }

    private void I() {
        this.f9614g.updateCellTowerGroup(this.f9616i, this.f9617j);
        if (this.f9613f.getGroupByName(this.f9614g.getName()) == null) {
            this.f9613f.addGroup(this.f9614g);
        }
        this.f9613f.persistData();
    }

    private void J() {
        this.f9615h = true;
        new e().execute((Object[]) null);
        this.m_scanBgButton.setVisibility(0);
        this.m_scanningText.setText(R.string.trigger_cell_tower_scanning);
        this.m_scanningLayout.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHasEdited() {
        this.m_fab.setVisibility(0);
        this.f9618k = true;
    }

    private void y() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Settings);
        builder.setTitle(R.string.trigger_cell_tower_add_tower_id);
        final EditText editText = new EditText(this);
        editText.setInputType(524289);
        editText.setHint(R.string.trigger_cell_tower_enter_group_name_hint);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        builder.setView(editText, dimensionPixelOffset, getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin), dimensionPixelOffset, 0);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CellTowerGroupActivity.this.B(editText, dialogInterface, i4);
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
        editText.addTextChangedListener(new c(button));
    }

    private void z(final String str) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_Settings);
        appCompatDialog.setContentView(R.layout.dialog_background_cell_scan_configure);
        appCompatDialog.setTitle(R.string.scan_in_background);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.dialog_background_scan_spinner);
        final int[] intArray = getResources().getIntArray(R.array.cell_tower_background_scan_durations);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CellTowerGroupActivity.this.C(str, intArray, spinner, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    public void handleBackPressed() {
        if (!this.f9618k) {
            finish();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_Settings);
        builder.setTitle(R.string.save_changes);
        builder.setMessage(R.string.cell_tower_group_edited);
        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CellTowerGroupActivity.this.E(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CellTowerGroupActivity.this.F(dialogInterface, i4);
            }
        });
        builder.show();
    }

    @OnClick({R.id.cell_tower_scan_bg_button})
    public void onCellTowerBgScanPressed(View view) {
        z(this.f9614g.getName());
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cell_tower_group);
        ButterKnife.bind(this);
        this.f9621n = Database.getInstance();
        A(getIntent());
        getOnBackPressedDispatcher().addCallback(this, new a(true));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cell_group_menu, menu);
        return true;
    }

    public void onEventMainThread(CellTowerUpdateEvent cellTowerUpdateEvent) {
        H();
        setHasEdited();
        this.m_fab.setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        A(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId != R.id.menu_add_tower_id) {
                if (itemId == R.id.menu_scan_towers) {
                    J();
                    return true;
                }
                return true;
            }
            y();
            return true;
        }
        handleBackPressed();
        return true;
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        EventBusUtils.getEventBus().unregister(this);
        this.m_scanningLayout.setVisibility(8);
        this.f9615h = false;
        super.onPause();
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        EventBusUtils.getEventBus().register(this);
        this.f9616i = new ArrayList<>();
        this.f9617j = new HashSet();
        if (this.f9619l != null) {
            CellTowerGroup cellTowerGroup = new CellTowerGroup();
            this.f9614g = cellTowerGroup;
            cellTowerGroup.setName(this.f9619l);
            setTitle(this.f9619l);
            this.m_fab.setVisibility(0);
        } else {
            this.f9614g = this.f9613f.getGroupByName(this.f9620m);
            setTitle(this.f9620m);
        }
        CellTowerGroup cellTowerGroup2 = this.f9614g;
        if (cellTowerGroup2 == null) {
            finish();
        } else {
            this.f9616i.addAll(cellTowerGroup2.getCellTowerIds());
            this.f9617j.addAll(this.f9614g.getIgnoreSet());
            H();
            this.m_fab.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.celltowers.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CellTowerGroupActivity.this.G(view);
                }
            });
            if (this.f9619l != null) {
                J();
            } else if (CellTowerBackgroundScanService.getCurrentScanGroup() != null && CellTowerBackgroundScanService.getCurrentScanGroup().equals(this.f9614g.getName())) {
                this.m_scanningLayout.setVisibility(0);
                this.m_scanningText.setText(R.string.background_scan_in_progress);
                this.m_scanBgButton.setVisibility(8);
            }
        }
        if (Build.VERSION.SDK_INT >= 27) {
            try {
                if (Settings.Secure.getInt(getContentResolver(), "location_mode") == 0) {
                    SnackbarAnimate make = SnackbarAnimate.make(findViewById(R.id.coordinator_layout), getString(R.string.location_services_must_be_enabled), -2);
                    make.setAction(R.string.configure, new b());
                    make.setActionTextColor(-1);
                    make.getView().setBackgroundResource(R.color.macro_error);
                    make.show();
                }
            } catch (Settings.SettingNotFoundException unused) {
            }
        }
    }

    @OnClick({R.id.cell_tower_stop_scanning_button})
    public void onScanningStopPressed(View view) {
        if (this.f9615h) {
            this.f9615h = false;
        } else {
            CellTowerBackgroundScanService.cancelScanning(this);
        }
        this.m_scanningLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f9625a;

        c(Button button) {
            this.f9625a = button;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f9625a;
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

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* loaded from: classes3.dex */
    public class e extends AsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        private final List<CellTowerUtils.CellTowerInfo> f9632a = new ArrayList();

        public e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            while (CellTowerGroupActivity.this.f9615h) {
                List<CellTowerUtils.CellTowerInfo> cellTowersInRange = CellTowerUtils.getCellTowersInRange(CellTowerGroupActivity.this);
                if (cellTowersInRange.size() == 0) {
                    SystemLog.logVerbose("Scan Towers - No towers found");
                } else {
                    SystemLog.logInfo("Scan Towers - Cell towers found = " + cellTowersInRange.size());
                    Iterator<CellTowerUtils.CellTowerInfo> it = cellTowersInRange.iterator();
                    while (it.hasNext()) {
                        SystemLog.logInfo("-> " + it.next().id);
                    }
                }
                for (CellTowerUtils.CellTowerInfo cellTowerInfo : cellTowersInRange) {
                    this.f9632a.remove(cellTowerInfo);
                    this.f9632a.add(cellTowerInfo);
                }
                publishProgress(new Void[0]);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onProgressUpdate(Void... voidArr) {
            boolean z3;
            if (CellTowerGroupActivity.this.f9615h) {
                ArrayList arrayList = new ArrayList();
                for (CellTowerUtils.CellTowerInfo cellTowerInfo : this.f9632a) {
                    Iterator it = CellTowerGroupActivity.this.f9616i.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (cellTowerInfo.id.equals((String) it.next())) {
                                z3 = true;
                                break;
                            }
                        } else {
                            z3 = false;
                            break;
                        }
                    }
                    if (!z3) {
                        arrayList.add(cellTowerInfo.id);
                    }
                }
                if (arrayList.size() > 0) {
                    CellTowerGroupActivity.this.f9616i.addAll(arrayList);
                    CellTowerGroupActivity.this.setHasEdited();
                    CellTowerGroupActivity.this.f9622o.notifyDataSetChanged();
                }
                TextView textView = CellTowerGroupActivity.this.m_cellTowerCountText;
                textView.setText(CellTowerGroupActivity.this.f9616i.size() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + CellTowerGroupActivity.this.getString(R.string.tower_ids_found));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Void r12) {
        }
    }
}
