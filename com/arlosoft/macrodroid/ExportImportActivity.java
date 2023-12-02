package com.arlosoft.macrodroid;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.afollestad.materialdialogs.MaterialDialog;
import com.arlosoft.macrodroid.ExportImportActivity;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshHomeScreenEvent;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroDeserializer;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.MacroImportPermissionsActivity;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.arlosoft.macrodroid.utils.UriHelper;
import com.arlosoft.macrodroid.utils.encryption.Encryptor;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ExportImportActivity extends MacroDroidDialogDaggerBaseActivity implements CategoryPasswordHelper.CategoriesUpdatedListener {
    @Inject

    /* renamed from: d  reason: collision with root package name */
    PremiumStatusHandler f1961d;

    /* renamed from: e  reason: collision with root package name */
    private transient MaterialDialog f1962e;

    /* renamed from: f  reason: collision with root package name */
    private String f1963f = null;

    /* renamed from: g  reason: collision with root package name */
    private CheckBox f1964g;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f1965h;

    /* renamed from: i  reason: collision with root package name */
    private CategoryPasswordHelper f1966i;

    /* renamed from: j  reason: collision with root package name */
    private CategoryList f1967j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements DialogInterface.OnCancelListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            ExportImportActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f1971a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1972b;

        d(TextView textView, ViewGroup viewGroup) {
            this.f1971a = textView;
            this.f1972b = viewGroup;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            String str;
            int i4;
            TextView textView = this.f1971a;
            if (z3) {
                str = ".emdr";
            } else {
                str = ".mdr";
            }
            textView.setText(str);
            ViewGroup viewGroup = this.f1972b;
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            viewGroup.setVisibility(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f1977a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup f1978b;

        f(TextView textView, ViewGroup viewGroup) {
            this.f1977a = textView;
            this.f1978b = viewGroup;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            String str;
            int i4;
            TextView textView = this.f1977a;
            if (z3) {
                str = ".emdr";
            } else {
                str = ".mdr";
            }
            textView.setText(str);
            ViewGroup viewGroup = this.f1978b;
            if (z3) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            viewGroup.setVisibility(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements DialogInterface.OnCancelListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            ExportImportActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements DialogInterface.OnCancelListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
            ExportImportActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class j extends AsyncTask<Void, Void, Integer> {

        /* renamed from: c  reason: collision with root package name */
        private List<Macro> f1987c;

        /* renamed from: d  reason: collision with root package name */
        private long f1988d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f1989e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f1991g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f1992h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f1993i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f1994j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f1995k;

        /* renamed from: a  reason: collision with root package name */
        private int f1985a = 0;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1986b = false;

        /* renamed from: f  reason: collision with root package name */
        private Uri f1990f = null;

        public j(String str, boolean z3, boolean z4, boolean z5, boolean z6) {
            ExportImportActivity.this.f1963f = str;
            this.f1989e = z3;
            this.f1993i = z4;
            this.f1991g = z5;
            this.f1995k = z6;
        }

        private boolean b(SelectableItem selectableItem) {
            return !PermissionsHelper.checkForNormalPermissions(ExportImportActivity.this, selectableItem, true);
        }

        private boolean c(SelectableItem selectableItem) {
            boolean checkForSpecialPermissions = PermissionsHelper.checkForSpecialPermissions(ExportImportActivity.this, selectableItem, false, false);
            if (checkForSpecialPermissions) {
                checkForSpecialPermissions = PermissionsHelper.checkForNormalPermissions(ExportImportActivity.this, selectableItem, false);
            }
            return !checkForSpecialPermissions;
        }

        private boolean d(List<Macro> list) {
            for (Macro macro : list) {
                Iterator<Trigger> it = macro.getTriggerList().iterator();
                while (it.hasNext()) {
                    if (c(it.next())) {
                        return true;
                    }
                }
                Iterator<Action> it2 = macro.getActions().iterator();
                while (it2.hasNext()) {
                    if (c(it2.next())) {
                        return true;
                    }
                }
                for (Constraint constraint : macro.getConstraints()) {
                    if (c(constraint)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean e(List<Macro> list) {
            for (Macro macro : list) {
                Iterator<Trigger> it = macro.getTriggerList().iterator();
                while (it.hasNext()) {
                    if (b(it.next())) {
                        return true;
                    }
                }
                Iterator<Action> it2 = macro.getActions().iterator();
                while (it2.hasNext()) {
                    if (b(it2.next())) {
                        return true;
                    }
                }
                for (Constraint constraint : macro.getConstraints()) {
                    if (b(constraint)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(DialogInterface dialogInterface, int i4) {
            dialogInterface.dismiss();
            ExportImportActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f */
        public Integer doInBackground(Void... voidArr) {
            if (this.f1990f != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(ExportImportActivity.this.getContentResolver().openInputStream(this.f1990f)));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    ExportImportActivity.this.f1963f = sb.toString();
                } catch (Exception unused) {
                    return null;
                }
            }
            if (this.f1991g) {
                MacroStore.getInstance().removeAllMacros();
            }
            try {
                if (this.f1989e) {
                    this.f1987c = MacroStore.getInstance().importJson(ExportImportActivity.this.f1963f, true);
                } else {
                    this.f1987c = MacroStore.getInstance().importJsonString(ExportImportActivity.this.f1963f, true);
                }
                if (this.f1987c.size() == 1 && this.f1987c.get(0).isActionBlock) {
                    this.f1986b = true;
                }
                if (this.f1993i) {
                    MacroDroidVariableStore.getInstance().resetAllVariables();
                }
                int freeMacros = Settings.getFreeMacros(ExportImportActivity.this);
                this.f1985a = 0;
                List<Macro> list = this.f1987c;
                if (list != null && list.size() > 0) {
                    List<Macro> allCompletedMacrosWithActionBlocks = MacroStore.getInstance().getAllCompletedMacrosWithActionBlocks(true);
                    for (Macro macro : this.f1987c) {
                        if (!ExportImportActivity.this.f1961d.getPremiumStatus().isPro() && this.f1985a >= freeMacros && !macro.isActionBlock) {
                            macro.setEnabled(false);
                            this.f1992h = true;
                        }
                        Iterator<Macro> it = allCompletedMacrosWithActionBlocks.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Macro next = it.next();
                                if (next.getName().equals(macro.getName()) && next.getGUID() == macro.getGUID()) {
                                    this.f1994j = true;
                                    break;
                                } else if (next.getName().equals(macro.getName())) {
                                    macro.setName(macro.getName() + " (2)");
                                }
                            } else {
                                allCompletedMacrosWithActionBlocks.add(macro);
                                if (!macro.isActionBlock) {
                                    this.f1985a++;
                                }
                            }
                        }
                    }
                    MacroStore.getInstance().storeMacroList(allCompletedMacrosWithActionBlocks);
                    MacroStore.getInstance().writeToJSON();
                    EventBusUtils.getEventBus().post(new RefreshHomeScreenEvent());
                }
            } catch (Exception e4) {
                SystemLog.logError("Error during import: " + e4.toString());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: h */
        public void onPostExecute(Integer num) {
            int i4;
            String sb;
            int i5;
            long currentTimeMillis = (System.currentTimeMillis() - this.f1988d) / 1000;
            if (this.f1992h) {
                ToastCompat.makeText(ExportImportActivity.this.getApplicationContext(), (int) R.string.macro_limit_reached, 0).show();
            }
            if (this.f1994j) {
                ToastCompat.makeText(ExportImportActivity.this.getApplicationContext(), (int) R.string.duplicate_detected, 0).show();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("IMPORT TIME: ");
            sb2.append(currentTimeMillis);
            sb2.append("s");
            if (this.f1985a <= 0 && !this.f1986b) {
                if (ExportImportActivity.this.f1962e != null) {
                    try {
                        ExportImportActivity.this.f1962e.dismiss();
                    } catch (Exception unused) {
                    }
                }
                if (!this.f1992h && !this.f1994j) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ExportImportActivity.this, R.style.Theme_App_Dialog_ExportImport);
                    builder.setTitle(R.string.import_failed);
                    builder.setMessage(R.string.could_not_import).setCancelable(false).setNegativeButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.b0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            ExportImportActivity.j.this.g(dialogInterface, i6);
                        }
                    });
                    if (!ExportImportActivity.this.isDestroyedOrFinishing()) {
                        builder.create().show();
                        return;
                    }
                    return;
                }
                if (this.f1995k) {
                    ExportImportActivity.this.startActivity(NewHomeScreenActivity.Companion.createMacroListIntent(ExportImportActivity.this));
                }
                ExportImportActivity.this.finish();
                return;
            }
            if (ExportImportActivity.this.f1962e != null) {
                try {
                    ExportImportActivity.this.f1962e.dismiss();
                } catch (Exception unused2) {
                }
            }
            List<Macro> list = this.f1987c;
            if (list != null) {
                for (Macro macro : list) {
                    ExportImportActivity.this.F(macro);
                }
                if (e(this.f1987c)) {
                    num = 1;
                } else {
                    if (d(this.f1987c)) {
                        i5 = 2;
                    } else {
                        i5 = 0;
                    }
                    num = Integer.valueOf(i5);
                }
            }
            if (num.intValue() != 1) {
                try {
                    if (this.f1986b) {
                        sb = ExportImportActivity.this.getString(R.string.action_block_imported);
                    } else if (this.f1985a == 1) {
                        sb = ExportImportActivity.this.getString(R.string.macro_imported);
                    } else {
                        sb = String.format(ExportImportActivity.this.getString(R.string.x_macros_imported), Integer.valueOf(this.f1985a));
                    }
                } catch (Exception unused3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(ExportImportActivity.this.getString(R.string.imported));
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    sb3.append(this.f1985a);
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    ExportImportActivity exportImportActivity = ExportImportActivity.this;
                    if (this.f1985a == 1) {
                        i4 = R.string.action_disable_macro_macro;
                    } else {
                        i4 = R.string.macros;
                    }
                    sb3.append(exportImportActivity.getString(i4).toLowerCase(Locale.getDefault()));
                    sb = sb3.toString();
                }
                ToastCompat.makeText(ExportImportActivity.this.getApplicationContext(), (CharSequence) sb, 1).show();
            }
            if (num.intValue() == 2) {
                ExportImportActivity.this.finish();
                ExportImportActivity.this.startActivity(new Intent(ExportImportActivity.this.getApplicationContext(), MacroImportPermissionsActivity.class));
            } else if (num.intValue() == 1) {
                ToastCompat.makeText(ExportImportActivity.this.getApplicationContext(), (CharSequence) ExportImportActivity.this.getString(R.string.requires_permission_to_import), 1).show();
                Intent intent = new Intent(ExportImportActivity.this, MacroImportPermissionsActivity.class);
                intent.putExtra(MacroImportPermissionsActivity.EXTRA_CHECK_IMPORT_PERMISSIONS, true);
                ExportImportActivity.this.startActivityForResult(intent, 2);
            } else {
                ExportImportActivity.this.finish();
                MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
                if (this.f1995k) {
                    ExportImportActivity.this.startActivity(NewHomeScreenActivity.Companion.createMacroListIntent(ExportImportActivity.this));
                }
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.f1988d = System.currentTimeMillis();
            MacroStore.getInstance();
            ExportImportActivity exportImportActivity = ExportImportActivity.this;
            exportImportActivity.q0(exportImportActivity.getString(R.string.importing_macros));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(Macro macro) {
        Iterator<Trigger> it = macro.getTriggerList().iterator();
        while (it.hasNext()) {
            Trigger next = it.next();
            next.applyImport();
            for (Constraint constraint : next.getConstraints()) {
                constraint.setMacro(macro);
                constraint.applyImport();
            }
        }
        Iterator<Action> it2 = macro.getActions().iterator();
        while (it2.hasNext()) {
            Action next2 = it2.next();
            next2.applyImport();
            for (Constraint constraint2 : next2.getConstraints()) {
                constraint2.setMacro(macro);
                constraint2.applyImport();
            }
        }
        for (Constraint constraint3 : macro.getConstraints()) {
            constraint3.setMacro(macro);
            constraint3.applyImport();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x0071 -> B:46:0x0071). Please submit an issue!!! */
    private void G(String str, Uri uri, @Nullable String str2) {
        InputStream fileInputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (FirebaseAnalytics.Param.CONTENT.equals(str)) {
            try {
                fileInputStream = getContentResolver().openInputStream(uri);
            } catch (Exception e4) {
                ToastCompat.makeText(getApplicationContext(), (int) R.string.could_not_import, 1).show();
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import macro list from input stream: " + e4.getMessage()));
                finish();
                try {
                    throw null;
                } catch (Exception unused) {
                    return;
                }
            }
        } else {
            try {
                fileInputStream = new FileInputStream(uri.getPath());
            } catch (Exception e5) {
                ToastCompat.makeText(getApplicationContext(), (int) R.string.could_not_import, 1).show();
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import macro list from file: " + e5.getMessage()));
                finish();
                try {
                    throw null;
                } catch (Exception unused2) {
                    return;
                }
            }
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            } catch (Exception unused3) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                M(sb.toString(), false, uri);
                bufferedReader.close();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                try {
                    ToastCompat.makeText(getApplicationContext(), (int) R.string.could_not_import, 1).show();
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import macro: " + th.getMessage()));
                    finish();
                    bufferedReader2.close();
                    fileInputStream.close();
                } catch (Throwable th3) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                    throw th3;
                }
            }
            fileInputStream.close();
        } catch (Exception unused6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (MacroStore.getInstance().getAllCompletedMacros().size() > 0) {
            this.f1965h.setVisibility(4);
            if (getPackageManager().queryIntentActivities(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 0).size() > 0) {
                Uri importExportUri = Settings.getImportExportUri(this);
                if (importExportUri == null) {
                    o0();
                    return;
                }
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, importExportUri);
                if (fromTreeUri.canWrite()) {
                    J(fromTreeUri);
                    return;
                } else {
                    o0();
                    return;
                }
            }
            K(Settings.getImportExportDir(this));
            return;
        }
        ToastCompat.makeText(getApplicationContext(), (int) R.string.no_macros_to_export, 1).show();
    }

    private void I(Dialog dialog, String str, DocumentFile documentFile, String str2, @Nullable String str3, boolean z3) {
        String str4;
        boolean z4;
        if (TextUtils.isEmpty(str3)) {
            str4 = ".mdr";
        } else {
            str4 = ".emdr";
        }
        String str5 = Settings.getImportExportDir(this) + RemoteSettings.FORWARD_SLASH_STRING + str2 + str4;
        if (z3) {
            Settings.setLastExportedFilename(this, str2);
        }
        if (str != null) {
            z4 = MacroStore.getInstance().writeToJSON(str5, true, true, true, str3);
        } else if (documentFile != null) {
            z4 = MacroStore.getInstance().writeToJSON(documentFile, str2 + str4, true, true, str3);
        } else {
            z4 = false;
        }
        dialog.dismiss();
        if (z4) {
            ToastCompat.makeText(getApplicationContext(), (CharSequence) (getString(R.string.exported) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str5), 1).show();
            finish();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_ExportImport);
        builder.setTitle(R.string.export_failed);
        builder.setMessage(getString(R.string.failed_to_export_to) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str5).setCancelable(false).setNegativeButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ExportImportActivity.this.U(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void J(DocumentFile documentFile) {
        L(null, documentFile);
    }

    private void K(String str) {
        L(str, null);
    }

    private void L(final String str, final DocumentFile documentFile) {
        String str2;
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_ExportImport);
        appCompatDialog.setContentView(R.layout.export_dialog);
        appCompatDialog.setTitle(R.string.export_macro_list);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        boolean z3 = false;
        appCompatDialog.setCanceledOnTouchOutside(false);
        appCompatDialog.setCancelable(false);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.exportdialog_filename);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.export_dialog_export_path);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.export_dialog_folder_chooser);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.encrypt_output_checkbox);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.passwordEntry);
        checkBox.setOnCheckedChangeListener(new d((TextView) appCompatDialog.findViewById(R.id.fileExtension), (ViewGroup) appCompatDialog.findViewById(R.id.password_layout)));
        ((Button) appCompatDialog.findViewById(R.id.export_dialog_filename_magic_text_chooser)).setVisibility(8);
        if (str != null) {
            textView.setText(str);
        } else if (documentFile != null) {
            DocumentFile documentFileParent = Util.getDocumentFileParent(documentFile);
            StringBuilder sb = new StringBuilder();
            if (documentFileParent != null) {
                str2 = documentFileParent.getName();
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(documentFile.getName());
            textView.setText(sb.toString());
        }
        final String str3 = "MacroDroid_" + new SimpleDateFormat("yy_MM_dd_HH_mm").format(new Date());
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.V(editText, str3, appCompatDialog, view);
            }
        });
        if (Settings.getLastExportedFilename(this) != null && !Settings.getLastExportedFilename(this).isEmpty()) {
            editText.setText(Settings.getLastExportedFilename(this));
        } else {
            editText.setText(str3);
        }
        if (editText.getText().length() > 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        editText.setSelection(editText.getText().length());
        editText.addTextChangedListener(new e(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.X(checkBox, editText2, documentFile, editText, appCompatDialog, str, str3, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.Y(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private void M(final String str, final boolean z3, @Nullable Uri uri) {
        final boolean contains = str.contains("exportFormat");
        if (contains && MacroStore.getInstance().getAllCompletedMacros().size() > 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_ExportImport);
            builder.setTitle(R.string.existing_macros_configured);
            builder.setMessage(R.string.importing_macros_will_release);
            builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ExportImportActivity.this.Z(dialogInterface, i4);
                }
            });
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.v
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ExportImportActivity.this.a0(str, z3, contains, dialogInterface, i4);
                }
            });
            builder.setOnCancelListener(new h());
            builder.create().show();
            return;
        }
        if (uri != null) {
            try {
                Macro macro = (Macro) GsonUtils.getGsonBuilder().registerTypeAdapter(Macro.class, new MacroDeserializer(getApplicationContext(), true, true, true)).create().fromJson(str, (Class<Object>) Macro.class);
                if (macro != null && !TextUtils.isEmpty(macro.getName())) {
                    Intent intent = new Intent(this, EditMacroActivity.class);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(uri);
                    startActivity(intent);
                    finish();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        l0(str, z3, contains, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_App_Dialog_ExportImport);
        appCompatDialog.setContentView(R.layout.export_share_dialog);
        appCompatDialog.setTitle(R.string.android_share);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        boolean z3 = false;
        appCompatDialog.setCanceledOnTouchOutside(false);
        appCompatDialog.setCancelable(false);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.exportdialog_filename);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.encrypt_output_checkbox);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.passwordEntry);
        checkBox.setOnCheckedChangeListener(new f((TextView) appCompatDialog.findViewById(R.id.fileExtension), (ViewGroup) appCompatDialog.findViewById(R.id.password_layout)));
        String format = new SimpleDateFormat("yy_MM_dd_HH_mm").format(new Date());
        editText.setText("MacroDroid_" + format);
        if (editText.getText().length() > 0) {
            z3 = true;
        }
        button.setEnabled(z3);
        editText.setSelection(editText.getText().length());
        editText.addTextChangedListener(new g(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.b0(checkBox, editText2, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.c0(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private boolean O() {
        for (Category category : this.f1967j.getCategories()) {
            if (category.isLocked()) {
                return true;
            }
        }
        return false;
    }

    private void P() {
        MaterialDialog materialDialog = this.f1962e;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.f1962e.hide();
        }
    }

    private void Q() {
        int columnIndex;
        this.f1965h.setVisibility(4);
        final Uri data = getIntent().getData();
        String scheme = data.getScheme();
        getContentResolver().getType(data);
        Cursor query = getContentResolver().query(data, null, null, null, null);
        String str = "";
        if (query != null) {
            try {
                if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_display_name")) >= 0) {
                    str = query.getString(columnIndex);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                try {
                    query.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
            try {
                query.close();
            } catch (Exception unused3) {
            }
        }
        if (str.endsWith(".emdr")) {
            View inflate = getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
            builder.setTitle(R.string.import_macros);
            builder.setView(inflate);
            final AlertDialog create = builder.create();
            create.getWindow().clearFlags(131080);
            create.getWindow().setSoftInputMode(5);
            create.show();
            ((Button) inflate.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportImportActivity.this.d0(editText, data, create, view);
                }
            });
            ((Button) inflate.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExportImportActivity.this.e0(create, view);
                }
            });
            create.setOnCancelListener(new c());
            editText.requestFocus();
            return;
        }
        G(scheme, data, null);
    }

    private void R() {
        Q();
    }

    private void S(Uri uri) {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    M(sb.toString(), false, null);
                    bufferedReader2.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        ToastCompat.makeText(getApplicationContext(), (int) R.string.could_not_import, 1).show();
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import macro: " + th.getMessage()));
                        finish();
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused2) {
        }
    }

    private void T(Uri uri, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream openInputStream;
        try {
            try {
                openInputStream = getContentResolver().openInputStream(uri);
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                M(new String(Encryptor.decrypt(byteArrayOutputStream.toByteArray(), str), "UTF-8"), false, null);
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                throw null;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (th instanceof GeneralSecurityException) {
                        ToastCompat.makeText(getApplicationContext(), (int) R.string.invalid_password, 1).show();
                    } else {
                        ToastCompat.makeText(getApplicationContext(), (int) R.string.could_not_import, 1).show();
                        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to import macro: " + th.getMessage()));
                    }
                    finish();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw null;
                } catch (Throwable th3) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        throw null;
                    } catch (Exception unused4) {
                        throw th3;
                    }
                }
            }
        } catch (Exception unused5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i4) {
        dialogInterface.cancel();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(EditText editText, String str, AppCompatDialog appCompatDialog, View view) {
        if (!editText.getText().toString().equals(str)) {
            Settings.setLastExportedFilename(this, editText.getText().toString());
        }
        o0();
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(AppCompatDialog appCompatDialog, String str, DocumentFile documentFile, EditText editText, String str2, String str3, DialogInterface dialogInterface, int i4) {
        I(appCompatDialog, str, documentFile, editText.getText().toString(), str2, !str3.equals(editText.getText().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(CheckBox checkBox, EditText editText, final DocumentFile documentFile, final EditText editText2, final AppCompatDialog appCompatDialog, final String str, final String str2, View view) {
        String str3;
        boolean exists;
        final String str4;
        if (checkBox.isChecked() && editText.getText().length() == 0) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.enter_password, 1).show();
            return;
        }
        if (checkBox.isChecked()) {
            str3 = ".emdr";
        } else {
            str3 = ".mdr";
        }
        if (documentFile != null) {
            if (documentFile.findFile(editText2.getText().toString() + str3) != null) {
                exists = true;
            } else {
                exists = false;
            }
        } else {
            exists = new File(Settings.getImportExportDir(this) + RemoteSettings.FORWARD_SLASH_STRING + editText2.getText().toString() + str3).exists();
        }
        if (checkBox.isChecked()) {
            str4 = editText.getText().toString();
        } else {
            str4 = null;
        }
        if (exists) {
            new AlertDialog.Builder(this, R.style.Theme_App_Dialog_ExportImport).setTitle(R.string.file_already_exists).setMessage(R.string.overwrite_file_confirm).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ExportImportActivity.this.W(appCompatDialog, str, documentFile, editText2, str4, str2, dialogInterface, i4);
                }
            }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
            return;
        }
        I(appCompatDialog, str, documentFile, editText2.getText().toString(), str4, !str2.equals(editText2.getText().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.cancel();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(String str, boolean z3, boolean z4, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        l0(str, z3, z4, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(CheckBox checkBox, EditText editText, EditText editText2, AppCompatDialog appCompatDialog, View view) {
        String str;
        if (checkBox.isChecked() && editText.getText().length() == 0) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.enter_password, 1).show();
            return;
        }
        if (checkBox.isChecked()) {
            str = ".emdr";
        } else {
            str = ".mdr";
        }
        n0(editText2.getText().toString() + str, editText.getText().toString());
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(AppCompatDialog appCompatDialog, View view) {
        appCompatDialog.cancel();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(EditText editText, Uri uri, Dialog dialog, View view) {
        if (editText.getText().toString().isEmpty()) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.enter_password, 1).show();
            return;
        }
        T(uri, editText.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Dialog dialog, View view) {
        dialog.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface, int i4) {
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        if (O()) {
            this.f1966i.promptForCategoryPassword(this, getString(R.string.enter_category_lock_password), "", Settings.getLockedCategoryPassword(this), 0, new a());
        } else {
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(View view) {
        if (O()) {
            this.f1966i.promptForCategoryPassword(this, getString(R.string.enter_category_lock_password), "", Settings.getLockedCategoryPassword(this), 0, new b());
        } else {
            N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        this.f1965h.setVisibility(4);
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(EditText editText, Uri uri, Dialog dialog, View view) {
        if (editText.getText().toString().isEmpty()) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.enter_password, 1).show();
            return;
        }
        T(uri, editText.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(Dialog dialog, View view) {
        dialog.dismiss();
        finish();
    }

    private void l0(String str, boolean z3, boolean z4, boolean z5) {
        new j(str, z3, this.f1964g.isChecked(), z4, z5).execute((Object[]) null);
    }

    private void m0(final Uri uri) {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText editText = (EditText) inflate.findViewById(R.id.passwordEntry);
        builder.setTitle(R.string.import_macros);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        create.getWindow().clearFlags(131080);
        create.getWindow().setSoftInputMode(5);
        create.show();
        ((Button) inflate.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.j0(editText, uri, create, view);
            }
        });
        ((Button) inflate.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.k0(create, view);
            }
        });
        create.setOnCancelListener(new i());
        editText.requestFocus();
    }

    private void n0(String str, @Nullable String str2) {
        File file = new File(getExternalFilesDir(null), str);
        MacroStore.getInstance().writeToJSON(file.getAbsolutePath(), true, true, true, str2);
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            FileUtils.addFileStreamToIntent(this, intent, file);
            startActivityForResult(Intent.createChooser(intent, getString(R.string.menu_share)), 41);
        } catch (ActivityNotFoundException unused) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.no_app_found_to_share, 0).show();
        } catch (Exception e4) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.export_failed, 0).show();
            SystemLog.logError("Failed to export file: " + e4.toString());
        }
    }

    private void o0() {
        try {
            startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 20);
            ToastCompat.makeText(getApplicationContext(), (int) R.string.select_export_directory, 1).show();
        } catch (ActivityNotFoundException e4) {
            SystemLog.logError("No activity to handle ACTION_OPEN_DOCUMENT_TREE intent: " + e4.toString());
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    private void p0() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.setType("*/*");
            startActivityForResult(intent, 19);
        } catch (ActivityNotFoundException e4) {
            SystemLog.logError("Failed to import file: " + e4.toString());
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(String str) {
        this.f1962e = new MaterialDialog.Builder(this).title(R.string.please_wait).widgetColor(ContextCompat.getColor(this, R.color.upgrade_primary)).content(str).progress(true, 0).cancelable(false).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        P();
        if (i4 == 41) {
            if (i5 == -1) {
                ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.macro_export_complete), 0).show();
                finish();
            } else if (i5 != 0) {
                ToastCompat.makeText(getApplicationContext(), (CharSequence) getString(R.string.export_failed), 0).show();
            }
        } else if (i4 == 2) {
            if (i5 == -1) {
                l0(this.f1963f, false, true, false);
            } else {
                ToastCompat.makeText(getApplicationContext(), (int) R.string.import_permission_issue, 1).show();
            }
        } else if (i5 == -1) {
            if (i4 == 20) {
                Uri data = intent.getData();
                getContentResolver().takePersistableUriPermission(data, 3);
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, data);
                Settings.setImportExportDir(this, Uri.decode(data.toString()));
                Settings.setImportExportUri(this, data);
                J(fromTreeUri);
            } else if (i4 == 19) {
                Uri data2 = intent.getData();
                String displayNameFromUri = UriHelper.getDisplayNameFromUri(this, data2);
                if (!displayNameFromUri.endsWith(".ablock") && !displayNameFromUri.contains(".ablock")) {
                    if (!displayNameFromUri.endsWith(".macro") && !displayNameFromUri.contains(".macro")) {
                        if (displayNameFromUri.endsWith(".emdr")) {
                            m0(data2);
                            return;
                        } else {
                            S(data2);
                            return;
                        }
                    }
                    finish();
                    Intent intent2 = new Intent(this, EditMacroActivity.class);
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(data2);
                    startActivity(intent2);
                    return;
                }
                finish();
                Intent intent3 = new Intent(this, ActionBlockEditActivity.class);
                intent3.setAction("android.intent.action.VIEW");
                intent3.setData(data2);
                startActivity(intent3);
            }
        } else {
            finish();
        }
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogDaggerBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.exportimport_view);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.export_import_macros);
        Cache cache = MacroDroidApplication.getInstance().getCache(Category.CATEGORY_CACHE);
        this.f1966i = new CategoryPasswordHelper(cache, this);
        CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
        this.f1967j = categoryList;
        if (categoryList == null || categoryList.getCategories() == null) {
            this.f1967j = new CategoryList(new ArrayList());
        }
        this.f1964g = (CheckBox) findViewById(R.id.exportimport_reset_variables);
        this.f1965h = (ViewGroup) findViewById(R.id.root_layout);
        if (getIntent() != null && getIntent().getAction() != null && getIntent().getAction().equals("android.intent.action.VIEW") && getIntent().getData() != null) {
            new AlertDialog.Builder(this, R.style.Theme_App_Dialog).setTitle(R.string.importing_macros).setMessage(R.string.confirm_import).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    ExportImportActivity.this.f0(dialogInterface, i4);
                }
            }).show();
            return;
        }
        ((FloatingActionButton) findViewById(R.id.exportimport_export_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.g0(view);
            }
        });
        ((FloatingActionButton) findViewById(R.id.exportimport_export_share_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.h0(view);
            }
        });
        ((FloatingActionButton) findViewById(R.id.exportimport_import_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportImportActivity.this.i0(view);
            }
        });
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogDaggerBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        P();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                super.onRequestPermissionsResult(i4, strArr, iArr);
            } else if (iArr.length > 0 && iArr[0] == 0) {
                if (getPackageManager().queryIntentActivities(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 0).size() > 0) {
                    Uri importExportUri = Settings.getImportExportUri(this);
                    if (importExportUri == null) {
                        o0();
                        return;
                    } else {
                        J(DocumentFile.fromTreeUri(this, importExportUri));
                        return;
                    }
                }
                K(Settings.getImportExportDir(this));
            } else if (strArr.length != 0 && !ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[0])) {
                Context applicationContext = getApplicationContext();
                ToastCompat.makeText(applicationContext, (CharSequence) (getString(R.string.enable_permission_after_dont_ask_again) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(R.string.permission_storage)), 1).show();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                startActivityForResult(intent, 0);
            }
        } else if (iArr.length > 0 && iArr[0] == 0) {
            p0();
        } else if (strArr.length != 0 && !ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[0])) {
            Context applicationContext2 = getApplicationContext();
            ToastCompat.makeText(applicationContext2, (CharSequence) (getString(R.string.enable_permission_after_dont_ask_again) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(R.string.permission_storage)), 1).show();
            try {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", getPackageName(), null));
                startActivityForResult(intent2, 0);
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CategoryPasswordHelper.PasswordListener {
        a() {
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            ExportImportActivity.this.H();
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements CategoryPasswordHelper.PasswordListener {
        b() {
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCorrect() {
            ExportImportActivity.this.N();
        }

        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
        public void passwordCancelled() {
        }
    }

    @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.CategoriesUpdatedListener
    public void categoriesUpdated() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f1974a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f1975b;

        e(Button button, EditText editText) {
            this.f1974a = button;
            this.f1975b = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f1974a;
            if (this.f1975b.getText().length() > 0) {
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
    /* loaded from: classes2.dex */
    public class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f1980a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f1981b;

        g(Button button, EditText editText) {
            this.f1980a = button;
            this.f1981b = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f1980a;
            if (this.f1981b.getText().length() > 0) {
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
}
