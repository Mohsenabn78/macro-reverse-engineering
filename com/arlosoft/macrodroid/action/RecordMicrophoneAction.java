package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.RecordMicrophoneActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.HasAndroid10FilePathIssues;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.saf.StorageAccessFrameworkHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class RecordMicrophoneAction extends Action implements SupportsMagicText, HasAndroid10FilePathIssues {
    private static final int CANCEL_RECORDING = -2;
    private static final int PICKER_ID_SAF = 9876;
    public static final String RECORDINGS_DIRECTORY = "MacroDroid/Recordings";
    private static final int RECORDING_FORMAT_3GPP = 0;
    private static final int RECORDING_FORMAT_AAC = 2;
    private static final int RECORDING_FORMAT_MPEG4 = 1;
    private static final int RECORD_UNTIL_CANCELLED = -1;
    private static final int SOURCE_CAMCORDER = 1;
    private static final int SOURCE_MIC_STANDARD = 0;
    private static final int SOURCE_UNPROCESSED = 2;
    private static MediaRecorder s_mediaRecorder;
    private static PendingIntent s_pendingIntent;
    private static PowerManager.WakeLock s_wakeLock;
    private String customFilename;
    private transient TextView dirText;
    private String m_path;
    private String m_recordTimeString;
    private int m_recordingFormat;
    private int m_secondsToRecordFor;
    private String pathName;
    private String pathUri;
    private int source;
    private transient String temporaryPathName;
    private static final int[] s_recordTimes = {30, 60, 120, 300, 600, 3000, 6000, -1, -2};
    private static final String[] s_recordingOptions = {"3GPP", "MPEG4", "AAC"};
    private static boolean s_recordingInProgress = false;
    private static final Object s_recordingLock = new Object();
    public static final Parcelable.Creator<RecordMicrophoneAction> CREATOR = new b();

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<RecordMicrophoneAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RecordMicrophoneAction createFromParcel(Parcel parcel) {
            return new RecordMicrophoneAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RecordMicrophoneAction[] newArray(int i4) {
            return new RecordMicrophoneAction[i4];
        }
    }

    /* synthetic */ RecordMicrophoneAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void W() {
        String str;
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && (str = this.pathUri) != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", str);
            }
            getActivity().startActivityForResult(intent, PICKER_ID_SAF);
            Context applicationContext = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + SelectableItem.r(R.string.action_write_to_file_select_folder) + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT_TREE " + SelectableItem.r(R.string.not_supported)), 0).show();
        }
    }

    private void X() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_format);
        builder.setSingleChoiceItems(s_recordingOptions, this.m_recordingFormat, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                RecordMicrophoneAction.this.b0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                RecordMicrophoneAction.this.c0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void Y() {
        int i4;
        if (Build.VERSION.SDK_INT >= 30) {
            this.m_path = null;
        }
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_set_path);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        this.temporaryPathName = this.pathName;
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        ImageButton imageButton = (ImageButton) appCompatDialog.findViewById(R.id.pick_dir_button);
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.default_filename_radio_button);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.custom_filename_radio_button);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.custom_filename_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.filename_magic_text_button);
        final ViewGroup viewGroup = (ViewGroup) appCompatDialog.findViewById(R.id.customFilenameLayout);
        TextView textView = (TextView) appCompatDialog.findViewById(R.id.fileExtension);
        TextView textView2 = (TextView) appCompatDialog.findViewById(R.id.directory_text);
        this.dirText = textView2;
        String str = this.m_path;
        if (str != null) {
            textView2.setText(str);
        } else {
            String str2 = this.temporaryPathName;
            if (str2 != null) {
                textView2.setText(str2);
            } else {
                textView2.setText("<" + SelectableItem.r(R.string.action_write_to_file_select_folder) + ">");
            }
        }
        if (this.customFilename == null) {
            radioButton.setChecked(true);
        } else {
            radioButton2.setChecked(true);
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordMicrophoneAction.this.d0(view);
            }
        });
        if (this.customFilename != null) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        String str3 = this.customFilename;
        if (str3 == null) {
            str3 = "";
        }
        editText.setText(str3);
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.sg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                RecordMicrophoneAction.e0(viewGroup, button, editText, compoundButton, z3);
            }
        });
        editText.addTextChangedListener(new a(button, radioButton, editText));
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.tg
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                RecordMicrophoneAction.f0(editText, magicTextPair);
            }
        };
        int i5 = this.m_recordingFormat;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    textView.setText(".aac");
                }
            } else {
                textView.setText(".mp4");
            }
        } else {
            textView.setText(".3gp");
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ug
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordMicrophoneAction.this.g0(activity, magicTextListener, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordMicrophoneAction.this.h0(radioButton2, editText, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordMicrophoneAction.this.i0(appCompatDialog, view);
            }
        });
        appCompatDialog.show();
    }

    private void Z() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_option);
        builder.setSingleChoiceItems(a0(), this.source, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ng
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                RecordMicrophoneAction.this.j0(dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.og
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                RecordMicrophoneAction.this.k0(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private String[] a0() {
        return new String[]{SelectableItem.r(R.string.action_record_microphone_source_standard), SelectableItem.r(R.string.action_record_microphone_source_camcorder), SelectableItem.r(R.string.action_record_microphone_source_unprocessed)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface, int i4) {
        this.m_recordingFormat = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(DialogInterface dialogInterface, int i4) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(ViewGroup viewGroup, Button button, EditText editText, CompoundButton compoundButton, boolean z3) {
        int i4;
        boolean z4 = false;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        button.setEnabled((!z3 || editText.getText().length() > 0) ? true : true);
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
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.seconds_30), SelectableItem.r(R.string.minute_1), SelectableItem.r(R.string.minutes_2), SelectableItem.r(R.string.minutes_5), SelectableItem.r(R.string.minutes_10), SelectableItem.r(R.string.minutes_30), SelectableItem.r(R.string.minutes_60), SelectableItem.r(R.string.action_record_microphone_until_cancelled), SelectableItem.r(R.string.action_record_microphone_cancel_recording)};
    }

    private String getPath() {
        String str = this.m_path;
        if (str != null) {
            return str;
        }
        return new File(Environment.getExternalStorageDirectory(), RECORDINGS_DIRECTORY).getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(RadioButton radioButton, EditText editText, AppCompatDialog appCompatDialog, View view) {
        String str = this.temporaryPathName;
        if (str == null && this.m_path == null) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.action_write_to_file_select_folder, 1).show();
            return;
        }
        this.pathName = str;
        if (radioButton.isChecked()) {
            this.customFilename = editText.getText().toString();
        } else {
            this.customFilename = null;
        }
        appCompatDialog.dismiss();
        this.m_path = null;
        this.dirText = null;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(AppCompatDialog appCompatDialog, View view) {
        this.dirText = null;
        appCompatDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface, int i4) {
        this.source = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(DialogInterface dialogInterface, int i4) {
        X();
    }

    private void l0(String str) {
        SystemLog.logError("Error - could not write to file: " + str + ". Need to re-select path and grant access.", getMacroGuid().longValue());
        StorageAccessFrameworkHelper.requiresAccessGranted(getContext(), SelectableItem.r(R.string.please_reconfigure_record_microphone_action_to_set_new_file_path), getMacro().getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01a7 A[Catch: Exception -> 0x01d6, all -> 0x025d, TryCatch #4 {Exception -> 0x01d6, blocks: (B:38:0x00df, B:40:0x0100, B:42:0x0111, B:58:0x0192, B:60:0x01a7, B:62:0x01ab, B:63:0x01b0, B:49:0x0149, B:51:0x0153, B:52:0x0157, B:54:0x016b, B:56:0x0173, B:57:0x0177), top: B:86:0x00df, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m0(com.arlosoft.macrodroid.triggers.TriggerContextInfo r11) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.RecordMicrophoneAction.m0(com.arlosoft.macrodroid.triggers.TriggerContextInfo):void");
    }

    public static void stopRecording() {
        synchronized (s_recordingLock) {
            if (s_recordingInProgress) {
                try {
                    s_mediaRecorder.stop();
                    s_mediaRecorder.reset();
                    s_mediaRecorder.release();
                    s_pendingIntent = null;
                    s_recordingInProgress = false;
                    s_wakeLock.release();
                } catch (Exception e4) {
                    Log.e("STOP RECORDING", "Exception trying to stop audio recording: " + e4.getMessage());
                    if (s_wakeLock.isHeld()) {
                        s_wakeLock.release();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_recordTimeString = getOptions()[i4];
        this.m_secondsToRecordFor = s_recordTimes[i4];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean canRunWhenInvalid() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doDisable() {
        stopRecording();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        int i4 = 0;
        while (true) {
            int[] iArr = s_recordTimes;
            if (i4 >= iArr.length) {
                return 0;
            }
            if (this.m_secondsToRecordFor == iArr[i4]) {
                return i4;
            }
            i4++;
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.requires_file_path_reconfiguration_android_10_plus);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return getOptions()[getCheckedItemIndex()];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return RecordMicrophoneActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT < 30) {
            return new String[]{"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        return new String[]{"android.permission.RECORD_AUDIO"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.customFilename};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " (" + getExtendedDetail() + ")";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        String str;
        if (i4 == PICKER_ID_SAF && i5 == -1) {
            Uri data = intent.getData();
            this.pathUri = data.toString();
            getContext().getContentResolver().takePersistableUriPermission(data, 3);
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
            TextView textView = this.dirText;
            if (textView != null) {
                textView.setText(sb2);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.RECORD_AUDIO") != 0) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.RECORD_AUDIO", SelectableItem.r(R.string.action_record_microphone), true, false);
        } else if (this.m_secondsToRecordFor == -2) {
            if (s_pendingIntent != null) {
                ((AlarmManager) getContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(s_pendingIntent);
                s_pendingIntent = null;
            }
            stopRecording();
        } else {
            m0(triggerContextInfo);
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasAndroid10FilePathIssues
    public boolean isBrokenOnAndroid10() {
        if (Build.VERSION.SDK_INT < 30 || this.m_path == null) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return !isBrokenOnAndroid10();
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void kill() {
        stopRecording();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return SelectableItem.r(R.string.action_record_microphone_select_rec_time);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresScheduleExactAlarm() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_secondsToRecordFor == -2) {
            itemComplete();
        } else {
            Z();
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.customFilename = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_secondsToRecordFor);
        parcel.writeString(this.m_recordTimeString);
        parcel.writeInt(this.m_recordingFormat);
        parcel.writeString(this.m_path);
        parcel.writeInt(this.source);
        parcel.writeString(this.customFilename);
        parcel.writeString(this.pathUri);
        parcel.writeString(this.pathName);
    }

    public RecordMicrophoneAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private RecordMicrophoneAction() {
        this.m_path = null;
        if (s_wakeLock == null) {
            s_wakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:recordmicrophoneaction");
        }
        this.m_recordTimeString = getOptions()[0];
        this.m_secondsToRecordFor = s_recordTimes[0];
    }

    private RecordMicrophoneAction(Parcel parcel) {
        super(parcel);
        this.m_secondsToRecordFor = parcel.readInt();
        this.m_recordTimeString = parcel.readString();
        this.m_recordingFormat = parcel.readInt();
        this.m_path = parcel.readString();
        this.source = parcel.readInt();
        this.customFilename = parcel.readString();
        this.pathUri = parcel.readString();
        this.pathName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2442a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RadioButton f2443b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditText f2444c;

        a(Button button, RadioButton radioButton, EditText editText) {
            this.f2442a = button;
            this.f2443b = radioButton;
            this.f2444c = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2442a;
            if (!this.f2443b.isChecked() && this.f2444c.getText().length() <= 0) {
                z3 = false;
            } else {
                z3 = true;
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
