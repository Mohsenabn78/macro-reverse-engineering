package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.FileOperationV21ActionInfo;
import com.arlosoft.macrodroid.action.services.FileOperationV21Service;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.FileReconfigurationCandidate;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.NotificationUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class FileOperationV21Action extends Action implements SupportsMagicText, FileReconfigurationCandidate {
    public static final Parcelable.Creator<FileOperationV21Action> CREATOR = new c();
    private static final int FILE_OPTION_ALL_FILES = 0;
    private static final int FILE_OPTION_AUDIO = 3;
    private static final int FILE_OPTION_FOLDER = 6;
    private static final int FILE_OPTION_IMAGES = 2;
    private static final int FILE_OPTION_MEDIA_FILES = 1;
    private static final int FILE_OPTION_SPECIFY_FILE_PATTERN = 5;
    private static final int FILE_OPTION_VIDEOS = 4;
    private static final int FROM_PICKER_ID = 9876;
    public static final int OPTION_COPY = 0;
    public static final int OPTION_CREATE_FOLDER = 3;
    public static final int OPTION_DELETE = 2;
    public static final int OPTION_MOVE = 1;
    private static final int TO_PICKER_ID = 9877;
    private transient boolean m_displayPatternDialog;
    private String[] m_fileExtensions;
    private int m_fileOption;
    private String m_filePattern;
    private String m_folderName;
    private String m_fromName;
    private String m_fromUriString;
    private int m_option;
    private String m_toName;
    private String m_toUriString;
    private transient boolean needsFileReconfiguration;

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<FileOperationV21Action> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FileOperationV21Action createFromParcel(Parcel parcel) {
            return new FileOperationV21Action(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FileOperationV21Action[] newArray(int i4) {
            return new FileOperationV21Action[i4];
        }
    }

    /* synthetic */ FileOperationV21Action(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void W() {
        try {
            getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), FROM_PICKER_ID);
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + SelectableItem.r(R.string.action_file_operation_from_directory) + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT_TREE " + SelectableItem.r(R.string.not_supported)), 0).show();
        }
    }

    private void X() {
        getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), TO_PICKER_ID);
        Context applicationContext = getContext().getApplicationContext();
        ToastCompat.makeText(applicationContext, (CharSequence) ("   " + SelectableItem.r(R.string.action_file_operation_to_directory) + "   "), 1).show();
    }

    private void Y(int i4) {
        switch (i4) {
            case 0:
                this.m_filePattern = "*";
                this.m_fileExtensions = new String[0];
                this.m_displayPatternDialog = false;
                return;
            case 1:
                this.m_displayPatternDialog = false;
                this.m_filePattern = null;
                String[] strArr = Util.AUDIO_FILE_TYPES;
                int length = strArr.length;
                String[] strArr2 = Util.IMAGE_FILE_TYPES;
                int length2 = length + strArr2.length;
                String[] strArr3 = Util.VIDEO_FILE_TYPES;
                String[] strArr4 = new String[length2 + strArr3.length];
                System.arraycopy(strArr2, 0, strArr4, 0, strArr2.length);
                System.arraycopy(strArr, 0, strArr4, strArr2.length, strArr.length);
                System.arraycopy(strArr3, 0, strArr4, strArr2.length + strArr.length, strArr3.length);
                this.m_fileExtensions = strArr4;
                return;
            case 2:
                this.m_displayPatternDialog = false;
                this.m_filePattern = null;
                this.m_fileExtensions = Util.IMAGE_FILE_TYPES;
                return;
            case 3:
                this.m_displayPatternDialog = false;
                this.m_filePattern = null;
                this.m_fileExtensions = Util.AUDIO_FILE_TYPES;
                return;
            case 4:
                this.m_displayPatternDialog = false;
                this.m_filePattern = null;
                this.m_fileExtensions = Util.VIDEO_FILE_TYPES;
                return;
            case 5:
                this.m_displayPatternDialog = true;
                this.m_fileExtensions = new String[0];
                return;
            case 6:
                this.m_fromName += RemoteSettings.FORWARD_SLASH_STRING;
                this.m_displayPatternDialog = false;
                this.m_filePattern = null;
                this.m_fileExtensions = new String[0];
                return;
            default:
                return;
        }
    }

    private void Z() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_folder_name);
        appCompatDialog.setTitle(R.string.action_file_operation_create_folder);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.folder_name);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.magic_text_button);
        String str = this.m_folderName;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
        }
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.c6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileOperationV21Action.this.d0(appCompatDialog, editText, view);
            }
        });
        if (editText.getText().length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.d6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.e6
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                FileOperationV21Action.f0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.f6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileOperationV21Action.this.g0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private void a0() {
        Y(this.m_fileOption);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(getContext().getString(R.string.action_file_operation_select_file));
        builder.setSingleChoiceItems(c0(), this.m_fileOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.a6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                FileOperationV21Action.this.h0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                FileOperationV21Action.this.i0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void b0() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.file_pattern_dialog);
        appCompatDialog.setTitle(R.string.file_pattern);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.file_pattern_dialog_file_pattern);
        editText.setText(this.m_filePattern);
        editText.setSelection(editText.length());
        editText.addTextChangedListener(new b(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileOperationV21Action.this.j0(appCompatDialog, editText, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.i6
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                FileOperationV21Action.l0(editText, magicTextPair);
            }
        };
        ((Button) appCompatDialog.findViewById(R.id.magic_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileOperationV21Action.this.m0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] c0() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_file_operation_all_files), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_media_files), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_images), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_audio), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_videos), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_specify), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_folder)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(AppCompatDialog appCompatDialog, EditText editText, View view) {
        this.needsFileReconfiguration = false;
        appCompatDialog.cancel();
        this.m_folderName = editText.getText().toString();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    public static final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_file_operation_copy), SelectableItem.r(R.string.action_file_operation_move), SelectableItem.r(R.string.action_file_operation_delete), SelectableItem.r(R.string.action_file_operation_create_folder)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        this.m_fileOption = i4;
        Y(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
        if (this.m_displayPatternDialog) {
            b0();
        } else if (this.m_option != 2) {
            X();
        } else {
            this.m_toUriString = null;
            this.needsFileReconfiguration = false;
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.cancel();
        this.m_filePattern = editText.getText().toString();
        if (this.m_option == 2) {
            this.needsFileReconfiguration = false;
            itemComplete();
            return;
        }
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean canRunWhenInvalid() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(this.m_fromUriString));
        if (SystemClock.elapsedRealtime() / 1000 > 90) {
            if (!fromTreeUri.canRead()) {
                this.needsFileReconfiguration = true;
                SystemLog.logError("Cannot access from path: " + this.m_fromName);
                NotificationUtils.displayFileAccessNotification(getContext(), getMacroName());
                return;
            }
            String str = this.m_toUriString;
            if (str != null) {
                if (!DocumentFile.fromTreeUri(getContext(), Uri.parse(str)).canWrite()) {
                    this.needsFileReconfiguration = true;
                    SystemLog.logError("Cannot access to path: " + this.m_toName);
                    NotificationUtils.displayFileAccessNotification(getContext(), getMacroName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_fileOption == 5) {
            return getOptions()[this.m_option] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_filePattern;
        }
        return getOptions()[this.m_option] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + c0()[this.m_fileOption];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.please_reconigiure_file_path_to_accessible_location);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_fromName;
        if (this.m_toName != null) {
            return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_file_operation_to) + ": " + this.m_toName;
        }
        return str;
    }

    public String getFromUriString() {
        return this.m_fromUriString;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FileOperationV21ActionInfo.getInstance();
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
        String[] strArr = new String[2];
        String str = this.m_folderName;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        String str3 = this.m_filePattern;
        if (str3 != null) {
            str2 = str3;
        }
        strArr[1] = str2;
        return strArr;
    }

    public String getToUriString() {
        return this.m_toUriString;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @SuppressLint({"NewApi"})
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1) {
            if (i4 == FROM_PICKER_ID) {
                Uri data = intent.getData();
                getContext().getContentResolver().takePersistableUriPermission(data, 3);
                this.m_fromUriString = data.toString();
                this.m_fromName = DocumentFile.fromTreeUri(getContext(), data).getName();
                if (this.m_option == 3) {
                    Z();
                } else {
                    a0();
                }
            } else if (i4 == TO_PICKER_ID) {
                Uri data2 = intent.getData();
                getContext().getContentResolver().takePersistableUriPermission(data2, 3);
                this.m_toUriString = data2.toString();
                this.m_toName = DocumentFile.fromTreeUri(getContext(), data2).getName();
                DocumentFile.fromTreeUri(getContext(), data2);
                this.needsFileReconfiguration = false;
                itemComplete();
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        String str2 = null;
        if (this.m_folderName != null) {
            str = MagicText.replaceMagicText(getContext(), this.m_folderName, triggerContextInfo, getMacro());
        } else {
            str = null;
        }
        Intent intent = new Intent(getContext(), FileOperationV21Service.class);
        if (this.m_filePattern != null) {
            str2 = MagicText.replaceMagicText(getContext(), this.m_filePattern, triggerContextInfo, getMacro());
        }
        intent.putExtra(FileOperationV21Service.EXTRA_FROM_URI, this.m_fromUriString);
        intent.putExtra(FileOperationV21Service.EXTRA_TO_URI, this.m_toUriString);
        intent.putExtra("FilePattern", str2);
        intent.putExtra("FileExtensions", this.m_fileExtensions);
        intent.putExtra(FileOperationV21Service.EXTRA_OPTION, this.m_option);
        intent.putExtra(FileOperationV21Service.EXTRA_FROM_PATH, this.m_fromName);
        intent.putExtra(FileOperationV21Service.EXTRA_FOLDER_NAME, str);
        intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", getMacroName());
        getContext().startService(intent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return !this.needsFileReconfiguration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_file_operation_v2);
    }

    @Override // com.arlosoft.macrodroid.interfaces.FileReconfigurationCandidate
    public boolean requiresFileReconfiguration() {
        return this.needsFileReconfiguration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        W();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        this.m_folderName = strArr[0];
        this.m_filePattern = strArr[1];
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5;
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeInt(this.m_fileOption);
        parcel.writeString(this.m_fromName);
        parcel.writeString(this.m_toName);
        parcel.writeString(this.m_filePattern);
        parcel.writeString(this.m_fromUriString);
        parcel.writeString(this.m_toUriString);
        parcel.writeString(this.m_folderName);
        String[] strArr = this.m_fileExtensions;
        if (strArr != null) {
            i5 = strArr.length;
        } else {
            i5 = 0;
        }
        parcel.writeInt(i5);
        String[] strArr2 = this.m_fileExtensions;
        if (strArr2 != null && strArr2.length > 0) {
            parcel.writeStringArray(strArr2);
        }
    }

    public FileOperationV21Action(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private FileOperationV21Action() {
        this.m_displayPatternDialog = false;
        this.m_filePattern = null;
        this.m_fileExtensions = new String[0];
    }

    private FileOperationV21Action(Parcel parcel) {
        super(parcel);
        this.m_displayPatternDialog = false;
        this.m_option = parcel.readInt();
        this.m_fileOption = parcel.readInt();
        this.m_fromName = parcel.readString();
        this.m_toName = parcel.readString();
        this.m_filePattern = parcel.readString();
        this.m_fromUriString = parcel.readString();
        this.m_toUriString = parcel.readString();
        this.m_folderName = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            String[] strArr = new String[readInt];
            this.m_fileExtensions = strArr;
            parcel.readStringArray(strArr);
            return;
        }
        this.m_fileExtensions = new String[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2195a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2196b;

        a(Button button, EditText editText) {
            this.f2195a = button;
            this.f2196b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2195a;
            if (this.f2196b.getText().length() > 0) {
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
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2199b;

        b(Button button, EditText editText) {
            this.f2198a = button;
            this.f2199b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2198a;
            if (this.f2199b.getText().length() > 0) {
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
