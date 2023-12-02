package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.WriteToFileActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.saf.StorageAccessFrameworkHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import me.drakeet.support.toast.ToastCompat;
import org.apache.commons.io.IOUtils;

/* loaded from: classes2.dex */
public class WriteToFileAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<WriteToFileAction> CREATOR = new c();
    private static final int PICKER_ID = 9876;
    private transient TextView dirText;
    private boolean m_append;
    private String m_filename;
    private String m_logText;
    private String m_path;
    private String m_pathName;
    private String m_pathUri;
    private boolean m_prepend;
    private String m_temporaryPathName;
    private boolean overwrite;
    private Object writeFileLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2751a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2752b;

        a(String str, String str2) {
            this.f2751a = str;
            this.f2752b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (WriteToFileAction.this.writeFileLock) {
                if (WriteToFileAction.this.m_prepend) {
                    WriteToFileAction.this.k0(this.f2751a, this.f2752b);
                } else if (WriteToFileAction.this.overwrite) {
                    WriteToFileAction.this.m0(this.f2751a, this.f2752b, true);
                } else {
                    WriteToFileAction.this.m0(this.f2751a, this.f2752b, false);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<WriteToFileAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public WriteToFileAction createFromParcel(Parcel parcel) {
            return new WriteToFileAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public WriteToFileAction[] newArray(int i4) {
            return new WriteToFileAction[i4];
        }
    }

    /* synthetic */ WriteToFileAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void Z() {
        try {
            getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), PICKER_ID);
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + SelectableItem.r(R.string.action_write_to_file_select_folder) + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT_TREE " + SelectableItem.r(R.string.not_supported)), 0).show();
        }
    }

    private void a0(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private void b0() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_write_to_file);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.filename);
        final EditText editText2 = (EditText) appCompatDialog.findViewById(R.id.text_to_write);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.append_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.prepend_radio_button);
        final RadioButton radioButton3 = (RadioButton) appCompatDialog.findViewById(R.id.overwrite_radio_button);
        ImageButton imageButton = (ImageButton) appCompatDialog.findViewById(R.id.pick_dir_button);
        this.dirText = (TextView) appCompatDialog.findViewById(R.id.directory_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.special_text_button_text_content);
        Button button4 = (Button) appCompatDialog.findViewById(R.id.special_text_button_filename);
        this.m_temporaryPathName = this.m_pathName;
        editText.setText(this.m_filename);
        editText2.setText(this.m_logText);
        radioButton.setChecked(this.m_append);
        radioButton2.setChecked(this.m_prepend);
        radioButton3.setChecked(this.overwrite);
        String str = this.m_path;
        if (str != null) {
            this.dirText.setText(str);
        } else {
            String str2 = this.m_temporaryPathName;
            if (str2 != null) {
                this.dirText.setText(str2);
            } else {
                TextView textView = this.dirText;
                textView.setText("<" + SelectableItem.r(R.string.action_write_to_file_select_folder) + ">");
            }
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ju
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteToFileAction.this.c0(view);
            }
        });
        b bVar = new b(button, editText, editText2);
        editText.addTextChangedListener(bVar);
        editText2.addTextChangedListener(bVar);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ku
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteToFileAction.this.d0(appCompatDialog, editText2, editText, radioButton, radioButton2, radioButton3, view);
            }
        });
        String str3 = this.m_filename;
        if (str3 != null && str3.length() > 0 && this.m_logText.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        button.setEnabled(z3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.lu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteToFileAction.this.e0(appCompatDialog, view);
            }
        });
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.mu
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                WriteToFileAction.this.f0(appCompatDialog, dialogInterface);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.nu
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WriteToFileAction.g0(editText2, magicTextPair);
            }
        };
        final MagicText.MagicTextListener magicTextListener2 = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.ou
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WriteToFileAction.h0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteToFileAction.this.i0(activity, magicTextListener, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WriteToFileAction.this.j0(activity, magicTextListener2, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(AppCompatDialog appCompatDialog, EditText editText, EditText editText2, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, View view) {
        String str = this.m_temporaryPathName;
        if (str == null && this.m_path == null) {
            ToastCompat.makeText(getContext(), (int) R.string.action_write_to_file_select_folder, 1).show();
            return;
        }
        this.m_pathName = str;
        appCompatDialog.dismiss();
        this.m_logText = editText.getText().toString();
        this.m_filename = editText2.getText().toString();
        this.m_append = radioButton.isChecked();
        this.m_prepend = radioButton2.isChecked();
        this.overwrite = radioButton3.isChecked();
        this.dirText = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(AppCompatDialog appCompatDialog, View view) {
        this.dirText = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(AppCompatDialog appCompatDialog, DialogInterface dialogInterface) {
        this.dirText = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str, String str2) {
        InputStream inputStream;
        OutputStream outputStream;
        DocumentFile fromTreeUri;
        DocumentFile findFile;
        DocumentFile createFile;
        OutputStreamWriter outputStreamWriter;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        OutputStreamWriter outputStreamWriter2;
        File file;
        File file2;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel3;
        OutputStreamWriter outputStreamWriter3 = null;
        FileChannel fileChannel4 = null;
        FileChannel fileChannel5 = null;
        FileOutputStream fileOutputStream2 = null;
        InputStream openInputStream = null;
        outputStreamWriter3 = null;
        try {
            if (this.m_path == null) {
                try {
                    fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(this.m_pathUri));
                    findFile = fromTreeUri.findFile(str);
                    createFile = fromTreeUri.createFile("application/custom", "prepend_temp.txt");
                    outputStream = getContext().getContentResolver().openOutputStream(createFile.getUri(), "wa");
                    try {
                        outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    } catch (Throwable th) {
                        th = th;
                        inputStream = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    outputStream = null;
                }
                try {
                    outputStreamWriter.write(str2);
                    outputStreamWriter.flush();
                    if (findFile == null) {
                        findFile = fromTreeUri.createFile("application/custom", str);
                    }
                    if (findFile == null) {
                        l0(str);
                    } else {
                        openInputStream = getContext().getContentResolver().openInputStream(findFile.getUri());
                        a0(openInputStream, outputStream);
                        InputStream openInputStream2 = getContext().getContentResolver().openInputStream(createFile.getUri());
                        OutputStream openOutputStream = getContext().getContentResolver().openOutputStream(findFile.getUri());
                        IOUtils.copy(openInputStream2, openOutputStream);
                        try {
                            openOutputStream.close();
                        } catch (Exception unused) {
                        }
                        try {
                            openInputStream2.close();
                        } catch (Exception unused2) {
                        }
                        createFile.delete();
                    }
                    try {
                        openInputStream.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        outputStream.close();
                    } catch (Exception unused4) {
                    }
                    outputStreamWriter.close();
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    outputStreamWriter3 = outputStreamWriter;
                    try {
                        SystemLog.logError("Could not prepend to file: " + th.toString());
                        l0(str);
                        outputStreamWriter3.close();
                    } finally {
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            outputStreamWriter3.close();
                        } catch (Exception unused7) {
                        }
                    }
                }
            }
            try {
                file = new File(this.m_path, str);
                file2 = new File(this.m_path, "TempPrepend.txt");
                fileOutputStream = new FileOutputStream(file2, true);
                try {
                    outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, "UTF-8");
                    try {
                        outputStreamWriter2.write(str2);
                        outputStreamWriter2.flush();
                        if (file.exists()) {
                            fileChannel = new FileInputStream(file).getChannel();
                            try {
                                fileChannel4 = fileOutputStream.getChannel();
                                fileChannel4.transferFrom(fileChannel, 0L, fileChannel.size());
                                file.delete();
                                fileChannel5 = fileChannel;
                                fileChannel3 = fileChannel4;
                            } catch (Throwable th4) {
                                th = th4;
                                fileChannel2 = fileChannel4;
                                fileOutputStream2 = fileOutputStream;
                                try {
                                    SystemLog.logError("Error - writing to file: " + th.getMessage(), getMacroGuid().longValue());
                                    try {
                                        outputStreamWriter2.close();
                                    } catch (Exception unused8) {
                                    }
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Exception unused9) {
                                    }
                                    try {
                                        fileChannel.close();
                                    } catch (Exception unused10) {
                                    }
                                    fileChannel2.close();
                                } catch (Throwable th5) {
                                    try {
                                        outputStreamWriter2.close();
                                    } catch (Exception unused11) {
                                    }
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Exception unused12) {
                                    }
                                    try {
                                        fileChannel.close();
                                    } catch (Exception unused13) {
                                    }
                                    try {
                                        fileChannel2.close();
                                    } catch (Exception unused14) {
                                    }
                                    throw th5;
                                }
                            }
                        } else {
                            fileChannel3 = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        fileChannel = null;
                        fileChannel2 = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileChannel = null;
                    fileChannel2 = null;
                    outputStreamWriter2 = null;
                }
            } catch (Throwable th8) {
                th = th8;
                fileChannel = null;
                fileChannel2 = null;
                outputStreamWriter2 = null;
            }
            try {
                FileUtils.copyFile(file2, file);
                file2.delete();
                try {
                    outputStreamWriter2.close();
                } catch (Exception unused15) {
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused16) {
                }
                try {
                    fileChannel5.close();
                } catch (Exception unused17) {
                }
                fileChannel3.close();
            } catch (Throwable th9) {
                th = th9;
                fileChannel2 = fileChannel3;
                fileChannel = fileChannel5;
                fileOutputStream2 = fileOutputStream;
                SystemLog.logError("Error - writing to file: " + th.getMessage(), getMacroGuid().longValue());
                outputStreamWriter2.close();
                fileOutputStream2.close();
                fileChannel.close();
                fileChannel2.close();
            }
        } catch (Exception unused18) {
        }
    }

    private void l0(String str) {
        SystemLog.logError("Error - could not write to file: " + str + ". Need to re-select path and grant access.", getMacroGuid().longValue());
        StorageAccessFrameworkHelper.requiresAccessGranted(getContext(), SelectableItem.r(R.string.write_file_failed_please_reconfigure_directory), getMacro().getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.FileOutputStream] */
    public void m0(String str, String str2, boolean z3) {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                if (this.m_path == null) {
                    DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(this.m_pathUri));
                    DocumentFile findFile = fromTreeUri.findFile(str);
                    if (z3 != 0) {
                        if (findFile != null) {
                            findFile.delete();
                        }
                        findFile = fromTreeUri.createFile("application/custom", str);
                    } else if (findFile == null) {
                        findFile = fromTreeUri.createFile("application/custom", str);
                    }
                    if (findFile == null) {
                        l0(str);
                        outputStreamWriter = null;
                    } else {
                        outputStreamWriter = new OutputStreamWriter(getContext().getContentResolver().openOutputStream(findFile.getUri(), "wa"), "UTF-8");
                    }
                    outputStreamWriter2 = outputStreamWriter;
                    fileOutputStream = null;
                } else {
                    fileOutputStream = new FileOutputStream(new File(this.m_path, str), this.m_append);
                    try {
                        outputStreamWriter2 = new OutputStreamWriter(fileOutputStream, "UTF-8");
                    } catch (Exception e4) {
                        e = e4;
                        SystemLog.logError("Error - writing to file: " + e.getMessage(), getMacroGuid().longValue());
                        outputStreamWriter2.close();
                        fileOutputStream.close();
                    }
                }
                outputStreamWriter2.write(str2);
                outputStreamWriter2.close();
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                z3 = 0;
                try {
                    outputStreamWriter2.close();
                    z3.close();
                } catch (Exception unused) {
                }
                throw th;
            }
            try {
                outputStreamWriter2.close();
                fileOutputStream.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2.close();
            z3.close();
            throw th;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_filename;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return WriteToFileActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_filename, this.m_logText};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @SuppressLint({"NewApi"})
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        String str;
        setActivity(activity);
        if (i5 == -1 && i4 == PICKER_ID) {
            Uri data = intent.getData();
            this.m_pathUri = data.toString();
            this.m_path = null;
            getContext().getContentResolver().takePersistableUriPermission(data, 3);
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), data);
            DocumentFile parentFile = fromTreeUri.getParentFile();
            StringBuilder sb = new StringBuilder();
            if (parentFile != null) {
                str = parentFile.getName();
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(RemoteSettings.FORWARD_SLASH_STRING);
            sb.append(fromTreeUri.getName());
            String sb2 = sb.toString();
            this.m_temporaryPathName = sb2;
            TextView textView = this.dirText;
            if (textView != null) {
                textView.setText(sb2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        b0();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        new a(MagicText.replaceMagicText(getContext(), this.m_filename, triggerContextInfo, getMacro()), MagicText.replaceMagicText(getContext(), this.m_logText, triggerContextInfo, getMacro()).replace("\\n", "\n")).start();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_filename = strArr[0];
            this.m_logText = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_logText);
        parcel.writeString(this.m_filename);
        parcel.writeInt(this.m_append ? 1 : 0);
        parcel.writeInt(this.m_prepend ? 1 : 0);
        parcel.writeInt(this.overwrite ? 1 : 0);
        parcel.writeString(this.m_path);
        parcel.writeString(this.m_pathUri);
        parcel.writeString(this.m_pathName);
    }

    public WriteToFileAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private WriteToFileAction() {
        this.m_append = true;
        this.m_prepend = false;
        this.overwrite = false;
        this.writeFileLock = new Object();
    }

    private WriteToFileAction(Parcel parcel) {
        super(parcel);
        this.m_append = true;
        this.m_prepend = false;
        this.overwrite = false;
        this.writeFileLock = new Object();
        this.m_logText = parcel.readString();
        this.m_filename = parcel.readString();
        this.m_append = parcel.readInt() != 0;
        this.m_prepend = parcel.readInt() != 0;
        this.overwrite = parcel.readInt() != 0;
        this.m_path = parcel.readString();
        this.m_pathUri = parcel.readString();
        this.m_pathName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2754a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2755b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2756c;

        b(Button button, EditText editText, EditText editText2) {
            this.f2754a = button;
            this.f2755b = editText;
            this.f2756c = editText2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2754a;
            if (this.f2755b.length() > 0 && this.f2756c.length() > 0) {
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
