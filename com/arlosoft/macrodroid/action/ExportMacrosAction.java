package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ExportMacrosActionInfo;
import com.arlosoft.macrodroid.action.services.FileOperationV21Service;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.AndroidExplorer;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.interfaces.FileReconfigurationCandidate;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.NotificationUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ExportMacrosAction extends Action implements SupportsMagicText, FileReconfigurationCandidate {
    public static final Parcelable.Creator<ExportMacrosAction> CREATOR = new e();
    private static final int FILE_EXPORT_PICKER_ID = 10;
    private static final int FILE_EXPORT_PICKER_ID_V21 = 20;
    private boolean encryptOutput;
    private String encryptionPassword;
    private String m_displayPath;
    private String m_fileName;
    private String m_filePath;
    private String m_pathUri;
    private transient String m_workingPathUri;
    private boolean needsFileReconfiguration;
    private transient String temporaryPathName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DocumentFile f2178a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2179b;

        a(DocumentFile documentFile, String str) {
            this.f2178a = documentFile;
            this.f2179b = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            String str2;
            if (ExportMacrosAction.this.encryptOutput) {
                str = ".emdr";
            } else {
                str = ".mdr";
            }
            MacroStore macroStore = MacroStore.getInstance();
            DocumentFile documentFile = this.f2178a;
            String str3 = this.f2179b + str;
            if (ExportMacrosAction.this.encryptOutput) {
                str2 = ExportMacrosAction.this.encryptionPassword;
            } else {
                str2 = null;
            }
            macroStore.writeToJSON(documentFile, str3, true, true, str2);
        }
    }

    /* loaded from: classes2.dex */
    class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2181a;

        b(String str) {
            this.f2181a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            String str;
            MacroStore macroStore = MacroStore.getInstance();
            String str2 = this.f2181a;
            if (ExportMacrosAction.this.encryptOutput) {
                str = ExportMacrosAction.this.encryptionPassword;
            } else {
                str = null;
            }
            boolean writeToJSON = macroStore.writeToJSON(str2, true, true, true, str);
            if (!writeToJSON) {
                SystemLog.logError("Failed to export macros: " + writeToJSON, ExportMacrosAction.this.getMacroGuid().longValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements Parcelable.Creator<ExportMacrosAction> {
        e() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExportMacrosAction createFromParcel(Parcel parcel) {
            return new ExportMacrosAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExportMacrosAction[] newArray(int i4) {
            return new ExportMacrosAction[i4];
        }
    }

    /* synthetic */ ExportMacrosAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void U(String str) {
        int i4;
        String str2;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.export_dialog);
        appCompatDialog.setTitle(R.string.action_export_macro);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.exportdialog_filename);
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final TextView textView = (TextView) appCompatDialog.findViewById(R.id.export_dialog_export_path);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.export_dialog_folder_chooser);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.export_dialog_filename_magic_text_chooser);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.encrypt_output_checkbox);
        final TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.passwordEntry);
        final ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.password_layout);
        final TextView textView3 = (TextView) appCompatDialog.findViewById(R.id.fileExtension);
        textView2.setText(this.encryptionPassword);
        checkBox.setChecked(this.encryptOutput);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.o5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                ExportMacrosAction.V(viewGroup, button, checkBox, textView2, editText, textView3, compoundButton, z3);
            }
        });
        boolean z3 = false;
        if (this.encryptOutput) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if (this.encryptOutput) {
            str2 = ".emdr";
        } else {
            str2 = ".mdr";
        }
        textView3.setText(str2);
        textView2.addTextChangedListener(new c(button, checkBox, editText));
        textView.setText(str);
        String str3 = this.m_fileName;
        if (str3 != null) {
            editText.setText(str3);
            editText.setSelection(editText.length());
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.p5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportMacrosAction.this.W(appCompatDialog, view);
            }
        });
        if (editText.getText().length() > 0 && (!checkBox.isChecked() || textView2.length() >= 4)) {
            z3 = true;
        }
        button.setEnabled(z3);
        editText.setSelection(editText.getText().length());
        editText.addTextChangedListener(new d(button, checkBox, textView2, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.q5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportMacrosAction.this.X(editText, textView, textView2, checkBox, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.r5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.s5
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ExportMacrosAction.Z(editText, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.t5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportMacrosAction.this.a0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(ViewGroup viewGroup, Button button, CheckBox checkBox, TextView textView, EditText editText, TextView textView2, CompoundButton compoundButton, boolean z3) {
        int i4;
        String str;
        boolean z4 = false;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if ((!checkBox.isChecked() || textView.length() >= 4) && editText.getText().length() > 0) {
            z4 = true;
        }
        button.setEnabled(z4);
        if (checkBox.isChecked()) {
            str = ".emdr";
        } else {
            str = ".mdr";
        }
        textView2.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(AppCompatDialog appCompatDialog, View view) {
        if (Build.VERSION.SDK_INT > 21) {
            c0();
        } else {
            b0();
        }
        appCompatDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(EditText editText, TextView textView, TextView textView2, CheckBox checkBox, AppCompatDialog appCompatDialog, View view) {
        String str = this.m_workingPathUri;
        if (str == null) {
            str = this.m_pathUri;
        }
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(str));
        if (fromTreeUri.canRead() && fromTreeUri.canWrite()) {
            this.needsFileReconfiguration = false;
            this.m_fileName = editText.getText().toString();
            this.m_filePath = textView.getText().toString();
            this.m_displayPath = textView.getText().toString();
            this.encryptionPassword = textView2.getText().toString();
            this.encryptOutput = checkBox.isChecked();
            String str2 = this.m_workingPathUri;
            if (str2 != null) {
                this.m_pathUri = str2;
            }
            appCompatDialog.dismiss();
            itemComplete();
            return;
        }
        ToastCompat.makeText(getContext(), (int) R.string.please_reconigiure_file_path_to_accessible_location, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    private void b0() {
        Activity activity = getActivity();
        String importExportDir = Settings.getImportExportDir(activity);
        Intent intent = new Intent(activity, AndroidExplorer.class);
        intent.putExtra("Title", SelectableItem.r(R.string.select_export_directory));
        intent.putExtra(Util.FOLDER_EXTRA, false);
        intent.putExtra(Util.FILE_EXTENSION_FILTER, "mdr");
        intent.putExtra(Util.PATH_EXTRA, importExportDir);
        intent.putExtra(Util.FOLDER_EXTRA, true);
        activity.startActivityForResult(intent, 10);
    }

    private void c0() {
        try {
            getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 20);
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.select_export_directory, 1).show();
        } catch (ActivityNotFoundException unused) {
            b0();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean canRunWhenInvalid() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        String str = this.m_pathUri;
        if (str == null) {
            return;
        }
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(str));
        if (SystemClock.elapsedRealtime() / 1000 > 90 && !fromTreeUri.canWrite()) {
            this.needsFileReconfiguration = true;
            SystemLog.logError("Cannot access export path: " + this.m_displayPath);
            NotificationUtils.displayFileAccessNotification(getContext(), getMacro().getName());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.please_reconigiure_file_path_to_accessible_location);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ExportMacrosActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT < 30) {
            return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        return new String[0];
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_fileName};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        String str;
        if (i5 == -1) {
            setActivity(activity);
            if (i4 == 10) {
                U(intent.getExtras().getString(Util.FILE_SELECTION_EXTRA));
            } else if (i4 == 20) {
                Uri data = intent.getData();
                getContext().getContentResolver().takePersistableUriPermission(data, 3);
                this.m_workingPathUri = data.toString();
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), data);
                DocumentFile documentFileParent = Util.getDocumentFileParent(fromTreeUri);
                StringBuilder sb = new StringBuilder();
                if (documentFileParent != null) {
                    str = documentFileParent.getName();
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                sb.append(fromTreeUri.getName());
                String sb2 = sb.toString();
                this.temporaryPathName = sb2;
                U(sb2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        if (getContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 0).size() > 0) {
            String str = this.m_pathUri;
            if (str == null) {
                c0();
                return;
            }
            String str2 = this.m_displayPath;
            if (str2 != null) {
                U(Uri.decode(str2));
                return;
            } else {
                U(Uri.decode(str));
                return;
            }
        }
        Activity activity = getActivity();
        String str3 = this.m_filePath;
        if (str3 == null) {
            str3 = Settings.getImportExportDir(activity);
        }
        U(str3);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_fileName, triggerContextInfo, getMacro());
        String str2 = this.m_pathUri;
        if (str2 != null) {
            Uri parse = Uri.parse(str2);
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), parse);
            SystemLog.logVerbose("Attempting to export: " + parse);
            if ((fromTreeUri.canRead() && fromTreeUri.canWrite()) || ((fromTreeUri = FileOperationV21Service.getFileFromRootPermission(getContext(), parse)) != null && fromTreeUri.canWrite())) {
                new a(fromTreeUri, replaceMagicText).start();
                return;
            }
            SystemLog.logError("Cannot access export directory, exportDir = " + fromTreeUri, getMacroGuid().longValue());
            this.needsFileReconfiguration = true;
            MacroStore.getInstance().updateMacro(getMacro());
            NotificationUtils.displayFileAccessNotification(getContext(), getMacro().getName());
            return;
        }
        if (this.encryptOutput) {
            str = ".emdr";
        } else {
            str = ".mdr";
        }
        new b(this.m_filePath + RemoteSettings.FORWARD_SLASH_STRING + replaceMagicText + str).start();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return !this.needsFileReconfiguration;
    }

    @Override // com.arlosoft.macrodroid.interfaces.FileReconfigurationCandidate
    public boolean requiresFileReconfiguration() {
        return this.needsFileReconfiguration;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_fileName = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_filePath);
        parcel.writeString(this.m_fileName);
        parcel.writeString(this.m_pathUri);
        parcel.writeString(this.m_displayPath);
        parcel.writeInt(this.needsFileReconfiguration ? 1 : 0);
        parcel.writeInt(this.encryptOutput ? 1 : 0);
        parcel.writeString(this.encryptionPassword);
    }

    public ExportMacrosAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ExportMacrosAction() {
        this.encryptionPassword = "";
    }

    private ExportMacrosAction(Parcel parcel) {
        super(parcel);
        this.encryptionPassword = "";
        this.m_filePath = parcel.readString();
        this.m_fileName = parcel.readString();
        this.m_pathUri = parcel.readString();
        this.m_displayPath = parcel.readString();
        this.needsFileReconfiguration = parcel.readInt() != 0;
        this.encryptOutput = parcel.readInt() != 0;
        this.encryptionPassword = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2183a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f2184b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2185c;

        c(Button button, CheckBox checkBox, EditText editText) {
            this.f2183a = button;
            this.f2184b = checkBox;
            this.f2185c = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f2183a;
            if ((!this.f2184b.isChecked() || charSequence.length() >= 4) && this.f2185c.getText().length() > 0) {
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
    public class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2187a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CheckBox f2188b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f2189c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ EditText f2190d;

        d(Button button, CheckBox checkBox, TextView textView, EditText editText) {
            this.f2187a = button;
            this.f2188b = checkBox;
            this.f2189c = textView;
            this.f2190d = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f2187a;
            if ((!this.f2188b.isChecked() || this.f2189c.length() >= 4) && this.f2190d.getText().length() > 0) {
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
