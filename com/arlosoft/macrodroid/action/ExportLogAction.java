package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ExportLogActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.database.room.SystemLogEntryDao;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.NotificationUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExportLogAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ExportLogAction extends Action {
    @Nullable
    private String displayPath;
    @Nullable
    private String fileName;
    @Nullable
    private String filePath;
    private boolean needsFileReconfiguration;
    @Nullable
    private String pathUri;
    @Inject
    public transient MacroDroidRoomDatabase roomDatabase;
    @Nullable
    private transient String temporaryPathName;
    private boolean userLog;
    @Nullable
    private transient String workingFilename;
    @Nullable
    private transient String workingPathUri;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ExportLogAction> CREATOR = new Parcelable.Creator<ExportLogAction>() { // from class: com.arlosoft.macrodroid.action.ExportLogAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExportLogAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExportLogAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExportLogAction[] newArray(int i4) {
            return new ExportLogAction[i4];
        }
    };
    @NotNull
    private static final SimpleDateFormat logDateTimeFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss", Locale.getDefault());

    /* compiled from: ExportLogAction.kt */
    @SourceDebugExtension({"SMAP\nExportLogAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExportLogAction.kt\ncom/arlosoft/macrodroid/action/ExportLogAction$invokeAction$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,346:1\n1#2:347\n1855#3,2:348\n*S KotlinDebug\n*F\n+ 1 ExportLogAction.kt\ncom/arlosoft/macrodroid/action/ExportLogAction$invokeAction$1\n*L\n176#1:348,2\n*E\n"})
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $filenameToUse;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$filenameToUse = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$filenameToUse, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Object all;
            OutputStream outputStream;
            BufferedReader bufferedReader;
            String joinToString$default;
            String replace$default;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
            } catch (Exception e4) {
                Long macroGuid = ExportLogAction.this.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Exporing log failed: " + e4, macroGuid.longValue());
            }
            if (i4 != 0) {
                if (i4 == 1) {
                    outputStream = (OutputStream) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    all = obj;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                DocumentFile fromTreeUri = DocumentFile.fromTreeUri(ExportLogAction.this.getContext(), Uri.parse(ExportLogAction.this.pathUri));
                Intrinsics.checkNotNull(fromTreeUri);
                if (!fromTreeUri.canWrite()) {
                    String str = "Cannot access export directory, exportDir = " + fromTreeUri;
                    Long macroGuid2 = ExportLogAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                    SystemLog.logError(str, macroGuid2.longValue());
                    ExportLogAction.this.needsFileReconfiguration = true;
                    MacroStore.getInstance().updateMacro(ExportLogAction.this.getMacro());
                    NotificationUtils.displayFileAccessNotification(ExportLogAction.this.getContext(), ExportLogAction.this.getMacro().getName());
                } else {
                    String str2 = this.$filenameToUse;
                    Intrinsics.checkNotNull(str2);
                    DocumentFile findFile = fromTreeUri.findFile(str2);
                    if (findFile != null && findFile.exists()) {
                        findFile.delete();
                    }
                    String str3 = this.$filenameToUse;
                    Intrinsics.checkNotNull(str3);
                    DocumentFile createFile = fromTreeUri.createFile("*/*", str3);
                    ContentResolver contentResolver = ExportLogAction.this.getContext().getContentResolver();
                    Intrinsics.checkNotNull(createFile);
                    OutputStream openOutputStream = contentResolver.openOutputStream(createFile.getUri());
                    Intrinsics.checkNotNull(openOutputStream);
                    if (ExportLogAction.this.userLog) {
                        FileInputStream openFileInput = MacroDroidApplication.Companion.getInstance().openFileInput(LogAction.LOG_FILE_NAME);
                        if (openFileInput != null) {
                            DataInputStream dataInputStream = new DataInputStream(openFileInput);
                            Charset charset = Charsets.UTF_8;
                            InputStreamReader inputStreamReader = new InputStreamReader(dataInputStream, charset);
                            if (inputStreamReader instanceof BufferedReader) {
                                bufferedReader = (BufferedReader) inputStreamReader;
                            } else {
                                bufferedReader = new BufferedReader(inputStreamReader, 8192);
                            }
                            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(TextStreamsKt.readLines(bufferedReader), "\n", null, null, 0, null, null, 62, null);
                            CloseableKt.closeFinally(bufferedReader, null);
                            replace$default = kotlin.text.m.replace$default(joinToString$default, "\\\\n", "\n", false, 4, (Object) null);
                            byte[] bytes = replace$default.getBytes(charset);
                            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                            openOutputStream.write(bytes);
                        }
                    } else {
                        SystemLogEntryDao systemLogEntryDao = ExportLogAction.this.getRoomDatabase().systemLogEntryDao();
                        LogLevel logLevel = LogLevel.VERBOSE;
                        this.L$0 = openOutputStream;
                        this.label = 1;
                        all = systemLogEntryDao.getAll(logLevel, this);
                        if (all == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        outputStream = openOutputStream;
                    }
                }
                return Unit.INSTANCE;
            }
            for (SystemLogEntry systemLogEntry : (List) all) {
                byte[] bytes2 = (ExportLogAction.logDateTimeFormat.format(Boxing.boxLong(systemLogEntry.getTimeStamp())) + " - " + systemLogEntry.getLogText() + "\n").getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                outputStream.write(bytes2);
            }
            outputStream.close();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ ExportLogAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void R(String str) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.export_dialog);
        appCompatDialog.setTitle(R.string.action_export_log);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        View findViewById = appCompatDialog.findViewById(R.id.exportdialog_filename);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById2);
        final Button button = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById3);
        Button button2 = (Button) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.export_dialog_export_path);
        Intrinsics.checkNotNull(findViewById4);
        final TextView textView = (TextView) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.export_dialog_folder_chooser);
        Intrinsics.checkNotNull(findViewById5);
        Button button3 = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.fileExtension);
        Intrinsics.checkNotNull(findViewById6);
        View findViewById7 = appCompatDialog.findViewById(R.id.export_dialog_filename_magic_text_chooser);
        Intrinsics.checkNotNull(findViewById7);
        Button button4 = (Button) findViewById7;
        ((TextView) findViewById6).setText(".txt");
        boolean z7 = false;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            textView.setText(str);
        } else {
            String str2 = this.filePath;
            if (str2 != null && str2.length() != 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z4) {
                String r4 = SelectableItem.r(R.string.select_export_directory);
                textView.setText("<" + r4 + ">");
            } else {
                textView.setText(this.filePath);
            }
        }
        String str3 = this.workingFilename;
        if (str3 != null && str3.length() != 0) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (!z5) {
            editText.setText(this.workingFilename);
            editText.setSelection(editText.length());
        } else {
            String str4 = this.fileName;
            if (str4 != null) {
                editText.setText(str4);
                editText.setSelection(editText.length());
            }
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.j5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportLogAction.T(ExportLogAction.this, appCompatDialog, view);
            }
        });
        Editable text = editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "filename.text");
        if (text.length() > 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            CharSequence text2 = textView.getText();
            String r5 = SelectableItem.r(R.string.select_export_directory);
            if (!Intrinsics.areEqual(text2, "<" + r5 + ">")) {
                z7 = true;
            }
        }
        button.setEnabled(z7);
        editText.setSelection(editText.getText().length());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.ExportLogAction$displayExportDialog$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence arg0, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0046, code lost:
                if (kotlin.jvm.internal.Intrinsics.areEqual(r5, "<" + r0 + ">") == false) goto L7;
             */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onTextChanged(@org.jetbrains.annotations.NotNull java.lang.CharSequence r4, int r5, int r6, int r7) {
                /*
                    r3 = this;
                    java.lang.String r5 = "arg0"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
                    android.widget.Button r4 = r1
                    android.widget.EditText r5 = r2
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r6 = "filename.text"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                    int r5 = r5.length()
                    r6 = 1
                    r7 = 0
                    if (r5 <= 0) goto L1c
                    r5 = 1
                    goto L1d
                L1c:
                    r5 = 0
                L1d:
                    if (r5 == 0) goto L49
                    android.widget.TextView r5 = r3
                    java.lang.CharSequence r5 = r5.getText()
                    r0 = 2131955055(0x7f130d6f, float:1.9546627E38)
                    java.lang.String r0 = com.arlosoft.macrodroid.action.ExportLogAction.access$getString$s1955883606(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "<"
                    r1.append(r2)
                    r1.append(r0)
                    java.lang.String r0 = ">"
                    r1.append(r0)
                    java.lang.String r0 = r1.toString()
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
                    if (r5 != 0) goto L49
                    goto L4a
                L49:
                    r6 = 0
                L4a:
                    r4.setEnabled(r6)
                    com.arlosoft.macrodroid.action.ExportLogAction r4 = r4
                    android.widget.EditText r5 = r2
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r5 = r5.toString()
                    com.arlosoft.macrodroid.action.ExportLogAction.access$setWorkingFilename$p(r4, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ExportLogAction$displayExportDialog$2.onTextChanged(java.lang.CharSequence, int, int, int):void");
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.k5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportLogAction.U(ExportLogAction.this, editText, textView, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.l5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportLogAction.V(AppCompatDialog.this, view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.m5
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ExportLogAction.W(editText, magicTextPair);
            }
        };
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.n5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportLogAction.X(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    static /* synthetic */ void S(ExportLogAction exportLogAction, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = null;
        }
        exportLogAction.R(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(ExportLogAction this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.Y();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ExportLogAction this$0, EditText filename, TextView exportPath, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(filename, "$filename");
        Intrinsics.checkNotNullParameter(exportPath, "$exportPath");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String str = this$0.workingPathUri;
        if (str == null) {
            str = this$0.pathUri;
        }
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this$0.getContext(), Uri.parse(str));
        Intrinsics.checkNotNull(fromTreeUri);
        if (fromTreeUri.canRead() && fromTreeUri.canWrite()) {
            this$0.needsFileReconfiguration = false;
            this$0.fileName = filename.getText().toString();
            this$0.filePath = exportPath.getText().toString();
            this$0.displayPath = exportPath.getText().toString();
            String str2 = this$0.workingPathUri;
            if (str2 != null) {
                this$0.pathUri = str2;
            }
            dialog.dismiss();
            this$0.itemComplete();
            return;
        }
        ToastCompat.makeText(this$0.getContext(), (int) R.string.please_reconigiure_file_path_to_accessible_location, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(EditText filename, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(filename, "$filename");
        Intrinsics.checkNotNullParameter(pair, "pair");
        int max = Math.max(filename.getSelectionStart(), 0);
        int max2 = Math.max(filename.getSelectionEnd(), 0);
        Editable text = filename.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(Activity activity, MagicText.MagicTextListener subjectMagicTextListener, ExportLogAction this$0, View view) {
        Intrinsics.checkNotNullParameter(subjectMagicTextListener, "$subjectMagicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, subjectMagicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    private final void Y() {
        try {
            getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 0);
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.select_export_directory, 1).show();
        } catch (ActivityNotFoundException unused) {
        }
    }

    private final String[] getOptions() {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        return new String[]{companion.getInstance().getString(R.string.user_log), companion.getInstance().getString(R.string.action_clear_log_option_system_log)};
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.userLog = z3;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        String str = this.pathUri;
        if (str == null) {
            return;
        }
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), Uri.parse(str));
        if (SystemClock.elapsedRealtime() / 1000 > 90) {
            Intrinsics.checkNotNull(fromTreeUri);
            if (!fromTreeUri.canWrite()) {
                this.needsFileReconfiguration = true;
                String str2 = this.displayPath;
                SystemLog.logError("Cannot access export path: " + str2);
                NotificationUtils.displayFileAccessNotification(getContext(), getMacro().getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return !this.userLog ? 1 : 0;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.please_reconigiure_file_path_to_accessible_location);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = getOptions()[!this.userLog ? 1 : 0];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[if (userLog) 0 else 1]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ExportLogActionInfo.Companion.getInstance();
    }

    @NotNull
    public final String[] getPossibleMagicText() {
        String[] strArr = new String[1];
        String str = this.fileName;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        return strArr;
    }

    @NotNull
    public final MacroDroidRoomDatabase getRoomDatabase() {
        MacroDroidRoomDatabase macroDroidRoomDatabase = this.roomDatabase;
        if (macroDroidRoomDatabase != null) {
            return macroDroidRoomDatabase;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roomDatabase");
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        Uri uri;
        String str;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i5 == -1) {
            setActivity(activity);
            if (intent != null) {
                uri = intent.getData();
            } else {
                uri = null;
            }
            ContentResolver contentResolver = getContext().getContentResolver();
            Intrinsics.checkNotNull(uri);
            contentResolver.takePersistableUriPermission(uri, 3);
            this.workingPathUri = uri.toString();
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), uri);
            DocumentFile documentFileParent = Util.getDocumentFileParent(fromTreeUri);
            if (documentFileParent != null) {
                str = documentFileParent.getName();
            } else {
                str = "";
            }
            Intrinsics.checkNotNull(fromTreeUri);
            String str2 = str + RemoteSettings.FORWARD_SLASH_STRING + fromTreeUri.getName();
            this.temporaryPathName = str2;
            Intrinsics.checkNotNull(str2);
            startsWith$default = kotlin.text.m.startsWith$default(str2, "primary:", false, 2, null);
            if (startsWith$default) {
                String str3 = this.temporaryPathName;
                Intrinsics.checkNotNull(str3);
                String substring = str3.substring(8);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                this.temporaryPathName = substring;
            }
            R(this.temporaryPathName);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.fileName, triggerContextInfo, getMacro());
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(replaceMagicText + ".txt", null), 2, null);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        return !this.needsFileReconfiguration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        S(this, null, 1, null);
    }

    public final void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.fileName = magicText[0];
            return;
        }
        String str = this.m_classType;
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    public final void setRoomDatabase(@NotNull MacroDroidRoomDatabase macroDroidRoomDatabase) {
        Intrinsics.checkNotNullParameter(macroDroidRoomDatabase, "<set-?>");
        this.roomDatabase = macroDroidRoomDatabase;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.userLog ? 1 : 0);
        out.writeString(this.filePath);
        out.writeString(this.fileName);
        out.writeString(this.pathUri);
        out.writeString(this.displayPath);
        out.writeInt(this.needsFileReconfiguration ? 1 : 0);
    }

    public ExportLogAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private ExportLogAction() {
        init();
        this.userLog = true;
    }

    private ExportLogAction(Parcel parcel) {
        super(parcel);
        init();
        this.userLog = parcel.readInt() != 0;
        this.filePath = parcel.readString();
        this.fileName = parcel.readString();
        this.pathUri = parcel.readString();
        this.displayPath = parcel.readString();
        this.needsFileReconfiguration = parcel.readInt() != 0;
    }

    /* compiled from: ExportLogAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
