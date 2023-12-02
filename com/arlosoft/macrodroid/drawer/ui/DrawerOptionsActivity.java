package com.arlosoft.macrodroid.drawer.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.ShortcutActivity;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockConfigDialog;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.applications.ApplicationAdapter;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.common.AppListAdapter;
import com.arlosoft.macrodroid.common.GetAppListTask;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.drawer.model.DrawerConfiguration;
import com.arlosoft.macrodroid.drawer.model.DrawerItem;
import com.arlosoft.macrodroid.drawer.model.DrawerItemActionBlock;
import com.arlosoft.macrodroid.drawer.model.DrawerItemAppShortcut;
import com.arlosoft.macrodroid.drawer.model.DrawerItemLog;
import com.arlosoft.macrodroid.drawer.model.DrawerItemMacro;
import com.arlosoft.macrodroid.drawer.model.DrawerItemOpenShortcut;
import com.arlosoft.macrodroid.drawer.model.DrawerItemStopwatch;
import com.arlosoft.macrodroid.drawer.model.DrawerItemText;
import com.arlosoft.macrodroid.drawer.model.DrawerItemVariable;
import com.arlosoft.macrodroid.drawer.ui.SpectrumDialogOverlay;
import com.arlosoft.macrodroid.events.DrawerRefreshEvent;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.IconSelectedEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.stopwatch.StopWatch;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class DrawerOptionsActivity extends MacroDroidBaseActivity implements GetAppListTask.AppListListener {
    public static final String EXTRA_DRAWER_ITEM_ID = "drawer_item_id";
    public static final String EXTRA_OPTION_TYPE = "option_type";
    public static final String EXTRA_USER_LOG = "user_log";
    public static final int OPTION_ACTION_BLOCKS = 3;
    public static final int OPTION_APP_SHORTCUT = 1;
    public static final int OPTION_EDIT_EXISING = 0;
    public static final int OPTION_LOG = 6;
    public static final int OPTION_MACROS = 2;
    public static final int OPTION_OPEN_SHORTCUT = 8;
    public static final int OPTION_SEPERATOR = 9;
    public static final int OPTION_STOPWATCHES = 5;
    public static final int OPTION_TEXT = 7;
    public static final int OPTION_VARIABLES = 4;

    /* renamed from: f  reason: collision with root package name */
    private DrawerItem f11502f;

    /* renamed from: g  reason: collision with root package name */
    private DrawerItemViewHolder f11503g;

    /* renamed from: h  reason: collision with root package name */
    private AlertDialog f11504h;

    /* renamed from: i  reason: collision with root package name */
    private ApplicationAdapter.AppSelectionListener f11505i;

    /* renamed from: j  reason: collision with root package name */
    AlertDialog f11506j;

    /* renamed from: k  reason: collision with root package name */
    private int f11507k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements SearchView.OnQueryTextListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApplicationAdapter f11508a;

        a(ApplicationAdapter applicationAdapter) {
            this.f11508a = applicationAdapter;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            this.f11508a.getFilter().filter((CharSequence) str, false);
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Function1<List<String>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f11510a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f11511b;

        b(String[] strArr, int i4) {
            this.f11510a = strArr;
            this.f11511b = i4;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(List<String> list) {
            DrawerOptionsActivity.this.C1(new DrawerItemVariable(this.f11510a[this.f11511b], new DictionaryKeys(list)), true, Settings.getDrawerConfiguration(DrawerOptionsActivity.this));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i implements Function1<ActionBlockData, Unit> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerItemActionBlock f11528a;

        i(DrawerItemActionBlock drawerItemActionBlock) {
            this.f11528a = drawerItemActionBlock;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(ActionBlockData actionBlockData) {
            this.f11528a.setActionBlockData(actionBlockData);
            return null;
        }
    }

    private void A0(@Nullable final DrawerItemOpenShortcut drawerItemOpenShortcut, final DrawerConfiguration drawerConfiguration, final boolean z3) {
        boolean z4;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.text);
        View inflate = LayoutInflater.from(new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog)).inflate(R.layout.dialog_enter_text, (ViewGroup) null);
        builder.setView(inflate);
        final EditText editText = (EditText) inflate.findViewById(R.id.text);
        Button button = (Button) inflate.findViewById(R.id.special_text_button);
        ((Spinner) inflate.findViewById(R.id.macro_spinner)).setVisibility(8);
        ((TextView) inflate.findViewById(R.id.invoke_macro_label)).setVisibility(8);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.drawer.ui.k0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                DrawerOptionsActivity.f1(editText, magicTextPair);
            }
        };
        if (drawerItemOpenShortcut != null) {
            editText.setText(drawerItemOpenShortcut.getText());
        }
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.l0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.g1(drawerItemOpenShortcut, editText, z3, drawerConfiguration, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.m0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.h1(dialogInterface, i4);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawerOptionsActivity.this.i1(magicTextListener, view);
            }
        });
        AlertDialog show = builder.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(show.getWindow().getAttributes());
        layoutParams.width = -1;
        show.getWindow().setAttributes(layoutParams);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.o0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.j1(dialogInterface);
            }
        });
        Button button2 = show.getButton(-1);
        if (editText.getText().length() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        button2.setEnabled(z4);
        editText.addTextChangedListener(new f(show, editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A1(final DrawerItem drawerItem, final View view, View view2) {
        if (j()) {
            this.f11506j.dismiss();
        } else {
            new SpectrumDialogOverlay.Builder(this).setTitle(R.string.select_color).setColors(R.array.toast_colors).setSelectedColor(drawerItem.getColor()).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialogOverlay.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.drawer.ui.v0
                @Override // com.arlosoft.macrodroid.drawer.ui.SpectrumDialogOverlay.OnColorSelectedListener
                public final void onColorSelected(boolean z3, int i4) {
                    DrawerOptionsActivity.this.z1(drawerItem, view, z3, i4);
                }
            }).build().show(getSupportFragmentManager(), "ColorDialog");
        }
    }

    private void B0() {
        final List<MacroDroidVariable> allVariables = MacroDroidVariableStore.getInstance().getAllVariables(true);
        if (allVariables.size() == 0) {
            v0(getString(R.string.no_variables_configured));
            return;
        }
        final String[] strArr = new String[allVariables.size()];
        for (int i4 = 0; i4 < allVariables.size(); i4++) {
            strArr[i4] = allVariables.get(i4).getName();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.action_set_variable_select);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DrawerOptionsActivity.this.k1(allVariables, strArr, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.l1(dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B1(View view) {
        if (j()) {
            this.f11506j.dismiss();
        } else if (!isDestroyedOrFinishing()) {
            s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void C1(final com.arlosoft.macrodroid.drawer.model.DrawerItem r20, final boolean r21, final com.arlosoft.macrodroid.drawer.model.DrawerConfiguration r22) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.drawer.ui.DrawerOptionsActivity.C1(com.arlosoft.macrodroid.drawer.model.DrawerItem, boolean, com.arlosoft.macrodroid.drawer.model.DrawerConfiguration):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(List list, DialogInterface dialogInterface, int i4) {
        ActionBlock actionBlock = (ActionBlock) list.get(i4);
        C1(new DrawerItemActionBlock(new ActionBlockData(actionBlock.getName(), actionBlock.getGUID(), new HashMap(), new HashMap())), true, Settings.getDrawerConfiguration(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(AppInfo appInfo) {
        C1(new DrawerItemAppShortcut(appInfo.packageName, appInfo.applicationName), true, Settings.getDrawerConfiguration(getApplicationContext()));
        this.f11504h.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H0(DrawerItem drawerItem, Button button, boolean z3, int i4) {
        if (z3) {
            drawerItem.setColor(i4);
            button.getBackground().setColorFilter(i4, PorterDuff.Mode.MULTIPLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(final DrawerItem drawerItem, final Button button, View view) {
        new SpectrumDialogOverlay.Builder(this).setTitle(R.string.select_color).setColors(R.array.toast_colors).setSelectedColor(drawerItem.getColor()).setDismissOnColorSelected(true).setOutlineWidth(1).setOnColorSelectedListener(new SpectrumDialogOverlay.OnColorSelectedListener() { // from class: com.arlosoft.macrodroid.drawer.ui.w0
            @Override // com.arlosoft.macrodroid.drawer.ui.SpectrumDialogOverlay.OnColorSelectedListener
            public final void onColorSelected(boolean z3, int i4) {
                DrawerOptionsActivity.H0(DrawerItem.this, button, z3, i4);
            }
        }).build().show(getSupportFragmentManager(), "ColorDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(DrawerItem drawerItem, SeekBar seekBar, boolean z3, DrawerConfiguration drawerConfiguration, DialogInterface dialogInterface, int i4) {
        ((DrawerItemLog) drawerItem).setMaxLines(seekBar.getProgress() + 3);
        if (z3) {
            o0(drawerItem, Settings.getDrawerConfiguration(this));
        } else {
            Settings.setDrawerConfiguration(this, drawerConfiguration);
            EventBusUtils.getEventBus().post(new DrawerRefreshEvent(0));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(List list, DialogInterface dialogInterface, int i4) {
        C1(new DrawerItemMacro(((Macro) list.get(i4)).getGUID()), true, Settings.getDrawerConfiguration(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(DialogInterface dialogInterface, int i4) {
        this.f11507k = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(List list, String[] strArr, DialogInterface dialogInterface, int i4) {
        ResolveInfo resolveInfo = (ResolveInfo) list.get(this.f11507k);
        Intent intent = new Intent("android.intent.action.CREATE_SHORTCUT");
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent.setClassName(activityInfo.packageName, activityInfo.name);
        intent.putExtra(ShortcutActivity.EXTRA_PICK_ICON, false);
        ActivityInfo activityInfo2 = resolveInfo.activityInfo;
        this.f11502f = new DrawerItemOpenShortcut(activityInfo2.packageName, activityInfo2.name);
        try {
            startActivityForResult(intent, 0);
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.error, 0).show();
        }
        String str = strArr[this.f11507k];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(String[] strArr, DialogInterface dialogInterface, int i4) {
        C1(new DrawerItemStopwatch(strArr[i4]), true, Settings.getDrawerConfiguration(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(DrawerItemText drawerItemText, EditText editText, long[] jArr, Spinner spinner, CheckBox checkBox, DrawerConfiguration drawerConfiguration, DialogInterface dialogInterface, int i4) {
        DrawerItemText drawerItemText2;
        if (drawerItemText != null) {
            drawerItemText.setText(editText.getText().toString());
            drawerItemText.setMacroGuid(jArr[spinner.getSelectedItemPosition()]);
        }
        if (drawerItemText != null) {
            drawerItemText2 = drawerItemText;
        } else {
            drawerItemText2 = new DrawerItemText(editText.getText().toString(), jArr[spinner.getSelectedItemPosition()]);
        }
        boolean z3 = true;
        drawerItemText2.setEnforceConstraints(!checkBox.isChecked());
        if (drawerItemText != null) {
            z3 = false;
        }
        C1(drawerItemText2, z3, drawerConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(this, magicTextListener, null, true, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(DrawerItemAppShortcut drawerItemAppShortcut, EditText editText, DrawerConfiguration drawerConfiguration, DialogInterface dialogInterface, int i4) {
        DrawerItemAppShortcut drawerItemAppShortcut2;
        if (drawerItemAppShortcut != null) {
            drawerItemAppShortcut.setText(editText.getText().toString());
        }
        if (drawerItemAppShortcut != null) {
            drawerItemAppShortcut2 = drawerItemAppShortcut;
        } else {
            drawerItemAppShortcut2 = new DrawerItemAppShortcut(drawerItemAppShortcut.getPackageName(), drawerItemAppShortcut.getName());
        }
        drawerItemAppShortcut2.setText(drawerItemAppShortcut.getText());
        C1(drawerItemAppShortcut2, false, drawerConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(this, magicTextListener, null, true, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(DrawerItemOpenShortcut drawerItemOpenShortcut, EditText editText, boolean z3, DrawerConfiguration drawerConfiguration, DialogInterface dialogInterface, int i4) {
        DrawerItemOpenShortcut drawerItemOpenShortcut2;
        if (drawerItemOpenShortcut != null) {
            drawerItemOpenShortcut.setText(editText.getText().toString());
        }
        if (drawerItemOpenShortcut != null) {
            drawerItemOpenShortcut2 = drawerItemOpenShortcut;
        } else {
            drawerItemOpenShortcut2 = new DrawerItemOpenShortcut(drawerItemOpenShortcut.getPackageName(), drawerItemOpenShortcut.getName());
        }
        drawerItemOpenShortcut2.setText(drawerItemOpenShortcut.getText());
        C1(drawerItemOpenShortcut2, z3, drawerConfiguration);
    }

    public static Intent getEditIntent(Context context, long j4) {
        Intent intent = new Intent(context, DrawerOptionsActivity.class);
        intent.addFlags(268468224);
        intent.putExtra(EXTRA_DRAWER_ITEM_ID, j4);
        return intent;
    }

    public static Intent getIntent(Context context, int i4) {
        Intent intent = new Intent(context, DrawerOptionsActivity.class);
        intent.addFlags(268468224);
        intent.putExtra(EXTRA_OPTION_TYPE, i4);
        return intent;
    }

    public static Intent getLogIntent(Context context, long j4, boolean z3) {
        Intent intent = new Intent(context, DrawerOptionsActivity.class);
        intent.addFlags(268468224);
        intent.putExtra(EXTRA_USER_LOG, z3);
        intent.putExtra(EXTRA_DRAWER_ITEM_ID, j4);
        intent.putExtra(EXTRA_OPTION_TYPE, 6);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(DialogInterface dialogInterface, int i4) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(this, magicTextListener, null, true, true, false, R.style.Theme_App_Dialog_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(List list, String[] strArr, DialogInterface dialogInterface, int i4) {
        MacroDroidVariable macroDroidVariable = (MacroDroidVariable) list.get(i4);
        if (!macroDroidVariable.isDictionary() && !macroDroidVariable.isArray()) {
            C1(new DrawerItemVariable(strArr[i4], null), true, Settings.getDrawerConfiguration(this));
        } else {
            VariableHelper.showSelectKeyDialog(this, R.style.Theme_App_Dialog_Action, macroDroidVariable, null, false, macroDroidVariable.getDictionary(), null, new ArrayList(), 0, VariableHelper.ShowThisDictionaryOption.DONT_SHOW, false, null, true, new b(strArr, i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(DialogInterface dialogInterface) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(DrawerItem drawerItem, CompoundButton compoundButton, boolean z3) {
        drawerItem.setHideIcon(!z3);
        this.f11503g.onBind(drawerItem, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(DrawerItemMacro drawerItemMacro, CompoundButton compoundButton, boolean z3) {
        drawerItemMacro.setEnforceConstraints(!z3);
        this.f11503g.onBind(drawerItemMacro, false);
    }

    private void o0(DrawerItem drawerItem, DrawerConfiguration drawerConfiguration) {
        drawerConfiguration.drawerItems.add(drawerItem);
        Settings.setDrawerConfiguration(this, drawerConfiguration);
        EventBusUtils.getEventBus().post(new DrawerRefreshEvent(1));
        ToastCompat.makeText(getApplicationContext(), (int) R.string.drawer_item_added, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(DrawerItemMacro drawerItemMacro, CompoundButton compoundButton, boolean z3) {
        drawerItemMacro.setKeepDrawerOpenOnPress(!z3);
        this.f11503g.onBind(drawerItemMacro, false);
    }

    private void p0() {
        final List<ActionBlock> allActionBlocks = MacroStore.getInstance().getAllActionBlocks();
        if (allActionBlocks.size() == 0) {
            v0(getString(R.string.no_action_blocks_configured));
            return;
        }
        String[] strArr = new String[allActionBlocks.size()];
        for (int i4 = 0; i4 < allActionBlocks.size(); i4++) {
            strArr[i4] = allActionBlocks.get(i4).getName();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.select_action_block);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DrawerOptionsActivity.this.D0(allActionBlocks, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.o
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.C0(dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(DrawerItemVariable drawerItemVariable, CompoundButton compoundButton, boolean z3) {
        drawerItemVariable.setHideVariableName(z3);
        this.f11503g.onBind(drawerItemVariable, false);
    }

    private void q0(List<AppInfo> list) {
        if (isDestroyedOrFinishing()) {
            return;
        }
        View inflate = LayoutInflater.from(new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog)).inflate(R.layout.dialog_app_chooser, (ViewGroup) null);
        ((ViewGroup) inflate.findViewById(R.id.button_bar)).setVisibility(8);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.select_application);
        builder.setView(inflate);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.E0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        this.f11504h = create;
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.g0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.F0(dialogInterface);
            }
        });
        this.f11504h.getWindow().setLayout(-1, -2);
        this.f11505i = new ApplicationAdapter.AppSelectionListener() { // from class: com.arlosoft.macrodroid.drawer.ui.h0
            @Override // com.arlosoft.macrodroid.applications.ApplicationAdapter.AppSelectionListener
            public final void appSelected(AppInfo appInfo) {
                DrawerOptionsActivity.this.G0(appInfo);
            }
        };
        ApplicationAdapter applicationAdapter = new ApplicationAdapter(this, list, null, this.f11505i);
        ((ListView) inflate.findViewById(R.id.application_list)).setAdapter((ListAdapter) applicationAdapter);
        ((SearchView) inflate.findViewById(R.id.searchView)).setOnQueryTextListener(new a(applicationAdapter));
        this.f11504h.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(DrawerItemStopwatch drawerItemStopwatch, CompoundButton compoundButton, boolean z3) {
        drawerItemStopwatch.setHideName(z3);
        this.f11503g.onBind(drawerItemStopwatch, false);
    }

    private void r0() {
        new GetAppListTask(this, this, true, true, ContextCompat.getColor(this, R.color.accent), true).execute((Object[]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1(DrawerItem drawerItem, DrawerConfiguration drawerConfiguration, View view) {
        y0((DrawerItemText) drawerItem, drawerConfiguration);
    }

    private void s0() {
        Intent intent = new Intent(this, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DISPLAY_APP_ICONS, true);
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s1(DrawerItemText drawerItemText, CompoundButton compoundButton, boolean z3) {
        drawerItemText.setEnforceConstraints(!z3);
        this.f11503g.onBind(drawerItemText, false);
    }

    private void t0(DrawerItem drawerItem, boolean z3, final DrawerConfiguration drawerConfiguration) {
        final DrawerItemLog drawerItemLog;
        final boolean z4;
        if (drawerItem == null) {
            drawerItemLog = new DrawerItemLog(z3, 10);
            z4 = true;
        } else {
            drawerItemLog = drawerItem;
            z4 = false;
        }
        this.f11502f = drawerItemLog;
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_configure_log, (ViewGroup) null);
        final SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seek_bar);
        TextView textView = (TextView) inflate.findViewById(R.id.num_lines);
        final Button button = (Button) inflate.findViewById(R.id.set_color_button);
        button.getBackground().setColorFilter(drawerItemLog.getColor(), PorterDuff.Mode.MULTIPLY);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawerOptionsActivity.this.I0(drawerItemLog, button, view);
            }
        });
        int maxLines = ((DrawerItemLog) drawerItemLog).getMaxLines();
        textView.setText(String.valueOf(maxLines));
        seekBar.setProgress(maxLines - 3);
        seekBar.setOnSeekBarChangeListener(new g(textView));
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(drawerItemLog.getName());
        builder.setView(inflate);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.J0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.setButton(-1, getString(17039370), new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.y
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.K0(drawerItemLog, seekBar, z4, drawerConfiguration, dialogInterface, i4);
            }
        });
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.j0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.L0(dialogInterface);
            }
        });
        create.getWindow().setLayout(-1, -2);
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1(DrawerItem drawerItem, DrawerConfiguration drawerConfiguration, View view) {
        z0((DrawerItemAppShortcut) drawerItem, drawerConfiguration);
    }

    private void u0() {
        String name;
        final List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        if (allCompletedMacrosSorted.size() == 0) {
            v0(getString(R.string.no_macros_configured));
            return;
        }
        String[] strArr = new String[allCompletedMacrosSorted.size()];
        for (int i4 = 0; i4 < allCompletedMacrosSorted.size(); i4++) {
            if (allCompletedMacrosSorted.get(i4).getIsFavourite()) {
                name = "⭐ " + allCompletedMacrosSorted.get(i4).getName();
            } else {
                name = allCompletedMacrosSorted.get(i4).getName();
            }
            strArr[i4] = name;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.select_macro);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.u0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                DrawerOptionsActivity.this.M0(allCompletedMacrosSorted, dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.x0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.N0(dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(DrawerItem drawerItem, DrawerConfiguration drawerConfiguration, boolean z3, View view) {
        A0((DrawerItemOpenShortcut) drawerItem, drawerConfiguration, z3);
    }

    private void v0(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setMessage(str).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.i0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.O0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(ActionBlock actionBlock, DrawerItemActionBlock drawerItemActionBlock, View view) {
        ActionBlockConfigDialog.displayConfigurationDialog(this, actionBlock, drawerItemActionBlock.getActionBlockData(), null, new i(drawerItemActionBlock));
    }

    private void w0() {
        try {
            PackageManager packageManager = getPackageManager();
            final List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action.CREATE_SHORTCUT"), 0);
            Collections.sort(queryIntentActivities, new ResolveInfo.DisplayNameComparator(packageManager));
            final String[] strArr = new String[queryIntentActivities.size()];
            for (int i4 = 0; i4 < queryIntentActivities.size(); i4++) {
                strArr[i4] = queryIntentActivities.get(i4).loadLabel(packageManager).toString();
            }
            AppListAdapter appListAdapter = new AppListAdapter(this, R.layout.application_item, queryIntentActivities, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.a1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    DrawerOptionsActivity.this.P0(dialogInterface, i5);
                }
            });
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
            builder.setTitle(R.string.action_launch_shortcut_select);
            builder.setSingleChoiceItems(appListAdapter, 0, (DialogInterface.OnClickListener) null);
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.b1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    DrawerOptionsActivity.this.Q0(dialogInterface, i5);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    DrawerOptionsActivity.this.R0(queryIntentActivities, strArr, dialogInterface, i5);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.e
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    DrawerOptionsActivity.this.S0(dialogInterface);
                }
            });
        } catch (Exception e4) {
            SystemLog.logError("Could not query for packages that support shortcut, maybe too many apps installed? " + e4.toString());
            ToastCompat.makeText(this, (int) R.string.too_many_apps_installed, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w1(DrawerItem drawerItem, CheckBox checkBox, boolean z3, DrawerConfiguration drawerConfiguration, DialogInterface dialogInterface, int i4) {
        drawerItem.setHideIcon(!checkBox.isChecked());
        if (z3) {
            o0(drawerItem, drawerConfiguration);
        } else {
            Settings.setDrawerConfiguration(this, drawerConfiguration);
            EventBusUtils.getEventBus().post(new DrawerRefreshEvent(0));
        }
        this.f11506j.dismiss();
        finish();
    }

    private void x0() {
        List<String> stopWatches = StopWatch.getStopWatches(this);
        if (stopWatches.size() == 0) {
            v0(getString(R.string.no_stopwatches_defined));
            return;
        }
        final String[] strArr = (String[]) stopWatches.toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.stopwatches);
        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.y0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.T0(strArr, dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.z0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.U0(dialogInterface);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x1(DialogInterface dialogInterface, int i4) {
        this.f11506j.dismiss();
        finish();
    }

    private void y0(@Nullable final DrawerItemText drawerItemText, final DrawerConfiguration drawerConfiguration) {
        int i4;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.text);
        View inflate = LayoutInflater.from(new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog)).inflate(R.layout.dialog_enter_text, (ViewGroup) null);
        builder.setView(inflate);
        final EditText editText = (EditText) inflate.findViewById(R.id.text);
        Button button = (Button) inflate.findViewById(R.id.special_text_button);
        final Spinner spinner = (Spinner) inflate.findViewById(R.id.macro_spinner);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.ignore_constraints);
        boolean z3 = true;
        List<Macro> allCompletedMacrosSorted = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        String[] strArr = new String[allCompletedMacrosSorted.size() + 1];
        final long[] jArr = new long[allCompletedMacrosSorted.size() + 1];
        strArr[0] = getString(R.string.none);
        jArr[0] = 0;
        if (allCompletedMacrosSorted.size() > 0) {
            int i5 = 0;
            i4 = 0;
            while (i5 < allCompletedMacrosSorted.size()) {
                int i6 = i5 + 1;
                strArr[i6] = allCompletedMacrosSorted.get(i5).getName();
                long guid = allCompletedMacrosSorted.get(i5).getGUID();
                jArr[i6] = guid;
                if (drawerItemText != null && guid == drawerItemText.getMacroGuid()) {
                    i4 = i6;
                }
                i5 = i6;
            }
        } else {
            i4 = 0;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, (int) R.layout.simple_spinner_item, strArr);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setSelection(i4);
        spinner.setOnItemSelectedListener(new c(checkBox));
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.drawer.ui.f
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                DrawerOptionsActivity.V0(editText, magicTextPair);
            }
        };
        if (drawerItemText != null) {
            editText.setText(drawerItemText.getText());
        }
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                DrawerOptionsActivity.this.W0(drawerItemText, editText, jArr, spinner, checkBox, drawerConfiguration, dialogInterface, i7);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                DrawerOptionsActivity.this.X0(dialogInterface, i7);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawerOptionsActivity.this.Y0(magicTextListener, view);
            }
        });
        AlertDialog show = builder.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(show.getWindow().getAttributes());
        layoutParams.width = -1;
        show.getWindow().setAttributes(layoutParams);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.j
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.Z0(dialogInterface);
            }
        });
        Button button2 = show.getButton(-1);
        if (editText.getText().length() <= 0) {
            z3 = false;
        }
        button2.setEnabled(z3);
        editText.addTextChangedListener(new d(show, editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y1(DialogInterface dialogInterface) {
        finish();
    }

    private void z0(@Nullable final DrawerItemAppShortcut drawerItemAppShortcut, final DrawerConfiguration drawerConfiguration) {
        boolean z3;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.text);
        View inflate = LayoutInflater.from(new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog)).inflate(R.layout.dialog_enter_text, (ViewGroup) null);
        builder.setView(inflate);
        final EditText editText = (EditText) inflate.findViewById(R.id.text);
        Button button = (Button) inflate.findViewById(R.id.special_text_button);
        ((Spinner) inflate.findViewById(R.id.macro_spinner)).setVisibility(8);
        ((TextView) inflate.findViewById(R.id.invoke_macro_label)).setVisibility(8);
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.drawer.ui.p0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                DrawerOptionsActivity.a1(editText, magicTextPair);
            }
        };
        if (drawerItemAppShortcut != null) {
            editText.setText(drawerItemAppShortcut.getText());
        }
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.q0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.b1(drawerItemAppShortcut, editText, drawerConfiguration, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.r0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                DrawerOptionsActivity.this.c1(dialogInterface, i4);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.drawer.ui.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawerOptionsActivity.this.d1(magicTextListener, view);
            }
        });
        AlertDialog show = builder.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(show.getWindow().getAttributes());
        layoutParams.width = -1;
        show.getWindow().setAttributes(layoutParams);
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.drawer.ui.t0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DrawerOptionsActivity.this.e1(dialogInterface);
            }
        });
        Button button2 = show.getButton(-1);
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button2.setEnabled(z3);
        editText.addTextChangedListener(new e(show, editText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z1(DrawerItem drawerItem, View view, boolean z3, int i4) {
        if (z3) {
            drawerItem.setColor(i4);
            if (!isDestroyedOrFinishing()) {
                this.f11503g.onBind(drawerItem, false);
                view.setBackgroundColor(i4);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.GetAppListTask.AppListListener
    public void appListUpdate(List<AppInfo> list, boolean z3) {
        q0(list);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i5 != 0) {
            if (i4 == 0) {
                if (this.f11502f == null) {
                    return;
                }
                Intent intent2 = (Intent) intent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
                ((DrawerItemOpenShortcut) this.f11502f).setShortcutName(intent.getStringExtra("android.intent.extra.shortcut.NAME"));
                Bitmap bitmap = (Bitmap) intent.getParcelableExtra("android.intent.extra.shortcut.ICON");
                if (intent2 != null) {
                    ((DrawerItemOpenShortcut) this.f11502f).setIntent(intent2.toURI());
                    C1(this.f11502f, true, Settings.getDrawerConfiguration(getApplicationContext()));
                    return;
                }
                ToastCompat.makeText(getApplicationContext(), (int) R.string.shortcut_not_compatible, 0).show();
            } else if (this.f11502f != null) {
                String stringExtra = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
                this.f11502f.setIcon(intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA), stringExtra);
                DrawerItemViewHolder drawerItemViewHolder = this.f11503g;
                if (drawerItemViewHolder != null) {
                    drawerItemViewHolder.onBind(this.f11502f, false);
                }
            }
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra(EXTRA_DRAWER_ITEM_ID, 0L);
        int intExtra = getIntent().getIntExtra(EXTRA_OPTION_TYPE, 0);
        DrawerConfiguration drawerConfiguration = Settings.getDrawerConfiguration(this);
        DrawerItem itemByGuid = drawerConfiguration.getItemByGuid(longExtra);
        switch (intExtra) {
            case 0:
                if (itemByGuid instanceof DrawerItemLog) {
                    t0(itemByGuid, ((DrawerItemLog) itemByGuid).isUserLog(), drawerConfiguration);
                    break;
                } else {
                    C1(itemByGuid, false, drawerConfiguration);
                    break;
                }
            case 1:
                r0();
                break;
            case 2:
                u0();
                break;
            case 3:
                p0();
                break;
            case 4:
                B0();
                break;
            case 5:
                x0();
                break;
            case 6:
                t0(itemByGuid, getIntent().getBooleanExtra(EXTRA_USER_LOG, false), drawerConfiguration);
                break;
            case 7:
                y0(null, drawerConfiguration);
                break;
            case 8:
                w0();
                break;
        }
        EventBusUtils.getEventBus().register(this);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        EventBusUtils.getEventBus().unregister(this);
        this.f11505i = null;
        super.onDestroy();
    }

    public void onEventMainThread(IconSelectedEvent iconSelectedEvent) {
        DrawerItem drawerItem = this.f11502f;
        if (drawerItem != null) {
            drawerItem.setIcon(iconSelectedEvent.packageName, iconSelectedEvent.resourceName);
            DrawerItemViewHolder drawerItemViewHolder = this.f11503g;
            if (drawerItemViewHolder != null) {
                drawerItemViewHolder.onBind(this.f11502f, false);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AlertDialog alertDialog = this.f11504h;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f11504h.dismiss();
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CheckBox f11513a;

        c(CheckBox checkBox) {
            this.f11513a = checkBox;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int i5;
            CheckBox checkBox = this.f11513a;
            if (i4 == 0) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            checkBox.setVisibility(i5);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f11524a;

        g(TextView textView) {
            this.f11524a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            this.f11524a.setText(String.valueOf(i4 + 3));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DrawerItemText f11526a;

        h(DrawerItemText drawerItemText) {
            this.f11526a = drawerItemText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            try {
                this.f11526a.setMaxLines(Integer.parseInt(charSequence.toString()));
                DrawerOptionsActivity.this.f11503g.onBind(this.f11526a, false);
            } catch (NumberFormatException unused) {
                this.f11526a.setMaxLines(2);
            }
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
    public class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f11515a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f11516b;

        d(AlertDialog alertDialog, EditText editText) {
            this.f11515a = alertDialog;
            this.f11516b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f11515a.getButton(-1);
            if (this.f11516b.getText().length() > 0) {
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
    public class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f11518a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f11519b;

        e(AlertDialog alertDialog, EditText editText) {
            this.f11518a = alertDialog;
            this.f11519b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f11518a.getButton(-1);
            if (this.f11519b.getText().length() > 0) {
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
    public class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AlertDialog f11521a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f11522b;

        f(AlertDialog alertDialog, EditText editText) {
            this.f11521a = alertDialog;
            this.f11522b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f11521a.getButton(-1);
            if (this.f11522b.getText().length() > 0) {
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
