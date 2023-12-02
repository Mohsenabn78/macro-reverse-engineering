package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.FileOperationActionInfo;
import com.arlosoft.macrodroid.action.services.FileOperationService;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.AndroidExplorer;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.sessions.settings.RemoteSettings;

/* loaded from: classes2.dex */
public class FileOperationAction extends Action {
    private static final int FROM_PICKER_ID = 9876;
    private static final int TO_PICKER_ID = 9877;
    private transient boolean m_displayPatternDialog;
    private String[] m_fileExtensions;
    private String m_fileOption;
    private String m_filePattern;
    private String m_fromPath;
    private String m_option;
    private String m_optionFixed;
    private String m_toPath;
    public static final String OPTION_COPY_FIXED = "Copy";
    public static final String OPTION_MOVE_FIXED = "Move";
    public static final String OPTION_DELETE_FIXED = "Delete";
    private static final String[] s_optionsFixed = {OPTION_COPY_FIXED, OPTION_MOVE_FIXED, OPTION_DELETE_FIXED};
    public static final Parcelable.Creator<FileOperationAction> CREATOR = new b();

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<FileOperationAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FileOperationAction createFromParcel(Parcel parcel) {
            return new FileOperationAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FileOperationAction[] newArray(int i4) {
            return new FileOperationAction[i4];
        }
    }

    /* synthetic */ FileOperationAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void S() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, AndroidExplorer.class);
        intent.putExtra("Title", this.m_option + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_file_operation_from_directory));
        intent.putExtra(Util.FOLDER_EXTRA, true);
        intent.putExtra(Util.PATH_EXTRA, this.m_fromPath);
        activity.startActivityForResult(intent, FROM_PICKER_ID);
    }

    private void T() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, AndroidExplorer.class);
        intent.putExtra("Title", this.m_option + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_file_operation_to_directory));
        intent.putExtra(Util.FOLDER_EXTRA, true);
        intent.putExtra(Util.PATH_EXTRA, this.m_toPath);
        activity.startActivityForResult(intent, TO_PICKER_ID);
    }

    private void U(int i4) {
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
                this.m_fromPath += RemoteSettings.FORWARD_SLASH_STRING;
                this.m_displayPatternDialog = false;
                this.m_filePattern = null;
                this.m_fileExtensions = new String[0];
                return;
            default:
                return;
        }
    }

    private void V() {
        int i4 = 0;
        for (int i5 = 0; i5 < X().length; i5++) {
            if (X()[i5].equals(this.m_fileOption)) {
                i4 = i5;
            }
        }
        U(i4);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(getContext().getString(R.string.action_file_operation_select_file));
        builder.setSingleChoiceItems(X(), i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.u5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                FileOperationAction.this.Y(dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.v5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                FileOperationAction.this.Z(dialogInterface, i6);
            }
        });
        builder.create().show();
    }

    private void W() {
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
        editText.addTextChangedListener(new a(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.w5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileOperationAction.this.a0(appCompatDialog, editText, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.x5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.y5
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                FileOperationAction.c0(editText, magicTextPair);
            }
        };
        ((Button) appCompatDialog.findViewById(R.id.magic_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.z5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FileOperationAction.this.d0(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private String[] X() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_file_operation_all_files), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_media_files), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_images), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_audio), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_videos), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_specify), MacroDroidApplication.getInstance().getString(R.string.action_file_operation_folder)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i4) {
        this.m_fileOption = X()[i4];
        U(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface, int i4) {
        if (this.m_displayPatternDialog) {
            W();
        } else if (!this.m_optionFixed.equals(OPTION_DELETE_FIXED)) {
            T();
        } else {
            this.m_toPath = null;
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(AppCompatDialog appCompatDialog, EditText editText, View view) {
        appCompatDialog.cancel();
        this.m_filePattern = editText.getText().toString();
        if (!this.m_optionFixed.equals(OPTION_DELETE_FIXED)) {
            T();
        } else {
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), false, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    private static final String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_file_operation_copy), SelectableItem.r(R.string.action_file_operation_move), SelectableItem.r(R.string.action_file_operation_delete)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = getOptions()[i4];
        this.m_optionFixed = s_optionsFixed[i4];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        for (int i4 = 0; i4 < getOptions().length; i4++) {
            if (this.m_option.equals(getOptions()[i4])) {
                return i4;
            }
        }
        return 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_fileOption.equals(getContext().getString(R.string.action_file_operation_specify_pattern))) {
            return this.m_option + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_filePattern;
        }
        return this.m_option + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_fileOption;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_fromPath;
        if (str.endsWith("//")) {
            str = str.substring(0, str.length() - 2);
        }
        String str2 = this.m_toPath;
        if (str2 != null && str2.length() > 0) {
            return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getContext().getString(R.string.action_file_operation_to) + ": " + this.m_toPath;
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FileOperationActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT < 30) {
            return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        return new String[0];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1) {
            if (i4 == FROM_PICKER_ID) {
                this.m_fromPath = intent.getExtras().getString(Util.FILE_SELECTION_EXTRA);
                V();
            } else if (i4 == TO_PICKER_ID) {
                this.m_toPath = intent.getExtras().getString(Util.FILE_SELECTION_EXTRA);
                itemComplete();
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        Intent intent = new Intent(getContext(), FileOperationService.class);
        if (this.m_filePattern != null) {
            str = MagicText.replaceMagicText(getContext(), this.m_filePattern, triggerContextInfo, getMacro());
        } else {
            str = null;
        }
        intent.putExtra(FileOperationService.EXTRA_FROM_PATH, this.m_fromPath);
        intent.putExtra(FileOperationService.EXTRA_TO_PATH, this.m_toPath);
        intent.putExtra("FilePattern", str);
        intent.putExtra("FileExtensions", this.m_fileExtensions);
        intent.putExtra(FileOperationService.EXTRA_FILE_OPTION, this.m_option);
        intent.putExtra(FileOperationService.EXTRA_FILE_OPTION_FIXED, this.m_option);
        getContext().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_file_operation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        S();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int i5;
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_option);
        parcel.writeString(this.m_optionFixed);
        parcel.writeString(this.m_fromPath);
        parcel.writeString(this.m_toPath);
        parcel.writeString(this.m_fileOption);
        parcel.writeString(this.m_filePattern);
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

    public FileOperationAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private FileOperationAction() {
        this.m_displayPatternDialog = false;
        this.m_option = getOptions()[0];
        this.m_optionFixed = s_optionsFixed[0];
        this.m_fileOption = X()[0];
        this.m_filePattern = null;
        this.m_fileExtensions = new String[0];
    }

    private FileOperationAction(Parcel parcel) {
        super(parcel);
        this.m_displayPatternDialog = false;
        this.m_option = parcel.readString();
        this.m_optionFixed = parcel.readString();
        this.m_fromPath = parcel.readString();
        this.m_toPath = parcel.readString();
        this.m_fileOption = parcel.readString();
        this.m_filePattern = parcel.readString();
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
        final /* synthetic */ Button f2192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2193b;

        a(Button button, EditText editText) {
            this.f2192a = button;
            this.f2193b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2192a;
            if (this.f2193b.getText().length() > 0) {
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
