package com.arlosoft.macrodroid.action;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ReadFileAction;
import com.arlosoft.macrodroid.action.info.ReadFileActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasStringVariableName;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.saf.StorageAccessFrameworkHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.sdk27.coroutines.Sdk27CoroutinesListenersWithCoroutinesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReadFileAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ReadFileAction extends Action implements BlockingAction, HasStringVariableName, HasDictionaryKeys, SupportsMagicText {
    private static final int PICKER_ID_FILE = 2;
    private static final int PICKER_ID_FOLDER = 1;
    @Nullable
    private DictionaryKeys dictionaryKeys;
    @Nullable
    private transient TextView dirText;
    @Nullable
    private String filename;
    @Nullable
    private transient EditText filenameEditText;
    @Nullable
    private String pathName;
    @Nullable
    private String pathUri;
    private boolean staticFilename;
    @Nullable
    private transient TextView staticFilenameText;
    @Nullable
    private String staticFilepath;
    @Nullable
    private String staticPathUri;
    @Nullable
    private transient String temporaryPathName;
    @Nullable
    private String variableName;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient String workingVariableName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ReadFileAction> CREATOR = new Parcelable.Creator<ReadFileAction>() { // from class: com.arlosoft.macrodroid.action.ReadFileAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ReadFileAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ReadFileAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ReadFileAction[] newArray(int i4) {
            return new ReadFileAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReadFileAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ Button $okButton;
        final /* synthetic */ RadioButton $radioButtonStatic;
        final /* synthetic */ Spinner $stringVarSpinner;
        final /* synthetic */ ViewFlipper $viewFlipper;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ ReadFileAction this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ViewFlipper viewFlipper, ReadFileAction readFileAction, Button button, RadioButton radioButton, Spinner spinner, Continuation<? super a> continuation) {
            super(4, continuation);
            this.$viewFlipper = viewFlipper;
            this.this$0 = readFileAction;
            this.$okButton = button;
            this.$radioButtonStatic = radioButton;
            this.$stringVarSpinner = spinner;
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z3, @Nullable Continuation<? super Unit> continuation) {
            a aVar = new a(this.$viewFlipper, this.this$0, this.$okButton, this.$radioButtonStatic, this.$stringVarSpinner, continuation);
            aVar.Z$0 = z3;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, CompoundButton compoundButton, Boolean bool, Continuation<? super Unit> continuation) {
            return a(coroutineScope, compoundButton, bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$viewFlipper.setDisplayedChild(!this.Z$0 ? 1 : 0);
                this.this$0.f0(this.$okButton, this.$radioButtonStatic, this.$stringVarSpinner);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReadFileAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Button $okButton;
        final /* synthetic */ RadioButton $radioButtonStatic;
        final /* synthetic */ Spinner $stringVarSpinner;
        int label;
        final /* synthetic */ ReadFileAction this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadFileAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function0<Unit> {
            final /* synthetic */ Button $okButton;
            final /* synthetic */ RadioButton $radioButtonStatic;
            final /* synthetic */ Spinner $stringVarSpinner;
            final /* synthetic */ ReadFileAction this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(ReadFileAction readFileAction, Button button, RadioButton radioButton, Spinner spinner) {
                super(0);
                this.this$0 = readFileAction;
                this.$okButton = button;
                this.$radioButtonStatic = radioButton;
                this.$stringVarSpinner = spinner;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.f0(this.$okButton, this.$radioButtonStatic, this.$stringVarSpinner);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, Spinner spinner, ReadFileAction readFileAction, Button button, RadioButton radioButton, Continuation<? super b> continuation) {
            super(3, continuation);
            this.$activity = activity;
            this.$stringVarSpinner = spinner;
            this.this$0 = readFileAction;
            this.$okButton = button;
            this.$radioButtonStatic = radioButton;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ReadFileAction readFileAction, Spinner spinner, Button button, RadioButton radioButton, MacroDroidVariable macroDroidVariable) {
            readFileAction.workingVariableName = macroDroidVariable.getName();
            readFileAction.workingDictionaryKeys = null;
            readFileAction.d0(spinner, new a(readFileAction, button, radioButton, spinner));
            readFileAction.f0(button, radioButton, spinner);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: b */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new b(this.$activity, this.$stringVarSpinner, this.this$0, this.$okButton, this.$radioButtonStatic, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Activity activity = this.$activity;
                final Spinner spinner = this.$stringVarSpinner;
                final ReadFileAction readFileAction = this.this$0;
                final Button button = this.$okButton;
                final RadioButton radioButton = this.$radioButtonStatic;
                VariablesHelper.createNewVariable(activity, spinner, readFileAction, (int) R.style.Theme_App_Dialog_Action, 2, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.zf
                    @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                    public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                        ReadFileAction.b.c(ReadFileAction.this, spinner, button, radioButton, macroDroidVariable);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReadFileAction.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function0<Unit> {
        final /* synthetic */ Button $okButton;
        final /* synthetic */ RadioButton $radioButtonStatic;
        final /* synthetic */ Spinner $stringVarSpinner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Button button, RadioButton radioButton, Spinner spinner) {
            super(0);
            this.$okButton = button;
            this.$radioButtonStatic = radioButton;
            this.$stringVarSpinner = spinner;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ReadFileAction.this.f0(this.$okButton, this.$radioButtonStatic, this.$stringVarSpinner);
        }
    }

    /* compiled from: ReadFileAction.kt */
    @SourceDebugExtension({"SMAP\nReadFileAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadFileAction.kt\ncom/arlosoft/macrodroid/action/ReadFileAction$invokeAction$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,419:1\n1#2:420\n*E\n"})
    /* loaded from: classes2.dex */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TriggerContextInfo $contextInfo;
        final /* synthetic */ boolean $forceEvenIfNotEnabled;
        final /* synthetic */ boolean $isTest;
        final /* synthetic */ int $nextAction;
        final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
        final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
        Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ReadFileAction.kt */
        /* loaded from: classes2.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TriggerContextInfo $contextInfo;
            final /* synthetic */ boolean $forceEvenIfNotEnabled;
            final /* synthetic */ boolean $isTest;
            final /* synthetic */ int $nextAction;
            final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
            final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
            int label;
            final /* synthetic */ ReadFileAction this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(boolean z3, ReadFileAction readFileAction, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$isTest = z3;
                this.this$0 = readFileAction;
                this.$nextAction = i4;
                this.$contextInfo = triggerContextInfo;
                this.$forceEvenIfNotEnabled = z4;
                this.$skipEndifIndexStack = stack;
                this.$resumeMacroInfo = resumeMacroInfo;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$isTest, this.this$0, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.$isTest) {
                        this.this$0.getMacro().invokeActions(this.this$0.getMacro().getActions(), this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(TriggerContextInfo triggerContextInfo, boolean z3, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$contextInfo = triggerContextInfo;
            this.$isTest = z3;
            this.$nextAction = i4;
            this.$forceEvenIfNotEnabled = z4;
            this.$skipEndifIndexStack = stack;
            this.$resumeMacroInfo = resumeMacroInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            DocumentFile findFile;
            BufferedReader bufferedReader;
            String readText;
            List<String> emptyList;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 != 1 && i4 != 2) {
                    if (i4 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                String str = ReadFileAction.this.staticFilename ? ReadFileAction.this.staticPathUri : ReadFileAction.this.pathUri;
                ReadFileAction readFileAction = ReadFileAction.this;
                MacroDroidVariable variableByName = readFileAction.getVariableByName(readFileAction.variableName);
                if (variableByName == null) {
                    Long macroGuid = ReadFileAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                    SystemLog.logError("Error - could not read from file: " + ReadFileAction.this.variableName + " does not exist", macroGuid.longValue());
                    return Unit.INSTANCE;
                }
                String str2 = ReadFileAction.this.staticFilename ? ReadFileAction.this.staticFilepath : ReadFileAction.this.filename;
                String str3 = "";
                if (str2 == null) {
                    str2 = "";
                }
                InputStream inputStream = null;
                try {
                    try {
                        Uri parse = Uri.parse(str);
                        if (ReadFileAction.this.staticFilename) {
                            findFile = DocumentFile.fromSingleUri(ReadFileAction.this.getContext(), parse);
                        } else {
                            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(ReadFileAction.this.getContext(), parse);
                            String replaceMagicText = MagicText.replaceMagicText(ReadFileAction.this.getContext(), ReadFileAction.this.filename, this.$contextInfo, ReadFileAction.this.getMacro());
                            Intrinsics.checkNotNull(fromTreeUri);
                            findFile = fromTreeUri.findFile(replaceMagicText);
                        }
                        if (findFile == null) {
                            ReadFileAction.this.e0(str2);
                        } else {
                            InputStream openInputStream = ReadFileAction.this.getContext().getContentResolver().openInputStream(findFile.getUri());
                            if (openInputStream != null) {
                                try {
                                    InputStreamReader inputStreamReader = new InputStreamReader(openInputStream, Charsets.UTF_8);
                                    if (inputStreamReader instanceof BufferedReader) {
                                        bufferedReader = (BufferedReader) inputStreamReader;
                                    } else {
                                        bufferedReader = new BufferedReader(inputStreamReader, 8192);
                                    }
                                } catch (Exception e4) {
                                    inputStream = openInputStream;
                                    e = e4;
                                    if (e instanceof SecurityException) {
                                        ReadFileAction.this.e0(str2);
                                    }
                                    Long macroGuid2 = ReadFileAction.this.getMacroGuid();
                                    Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                                    SystemLog.logError("Error - reading from file: " + e.getMessage(), macroGuid2.longValue());
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused) {
                                        }
                                    }
                                    MainCoroutineDispatcher main = Dispatchers.getMain();
                                    a aVar = new a(this.$isTest, ReadFileAction.this, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, null);
                                    this.label = 2;
                                    if (BuildersKt.withContext(main, aVar, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    inputStream = openInputStream;
                                    th = th2;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    MainCoroutineDispatcher main2 = Dispatchers.getMain();
                                    a aVar2 = new a(this.$isTest, ReadFileAction.this, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, null);
                                    this.L$0 = th;
                                    this.label = 3;
                                    if (BuildersKt.withContext(main2, aVar2, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    throw th;
                                }
                            } else {
                                bufferedReader = null;
                            }
                            if (bufferedReader != null) {
                                try {
                                    readText = TextStreamsKt.readText(bufferedReader);
                                } catch (Throwable th3) {
                                    try {
                                        throw th3;
                                    } catch (Throwable th4) {
                                        CloseableKt.closeFinally(bufferedReader, th3);
                                        throw th4;
                                    }
                                }
                            } else {
                                readText = null;
                            }
                            CloseableKt.closeFinally(bufferedReader, null);
                            if (readText != null) {
                                str3 = readText;
                            }
                            Context context = ReadFileAction.this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            DictionaryKeys dictionaryKeys = ReadFileAction.this.dictionaryKeys;
                            if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                            }
                            ReadFileAction.this.variableUpdate(variableByName, new VariableValue.StringValue(str3, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, this.$contextInfo, ReadFileAction.this.getMacro())));
                            inputStream = openInputStream;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        MainCoroutineDispatcher main3 = Dispatchers.getMain();
                        a aVar3 = new a(this.$isTest, ReadFileAction.this, this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, null);
                        this.label = 1;
                        if (BuildersKt.withContext(main3, aVar3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ ReadFileAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void T() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.setType("*/*");
            getActivity().startActivityForResult(intent, 2);
            Context applicationContext = getContext().getApplicationContext();
            String r4 = SelectableItem.r(R.string.select_file);
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + r4 + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            String r5 = SelectableItem.r(R.string.not_supported);
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT" + r5), 0).show();
        }
    }

    private final void U() {
        try {
            getActivity().startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 1);
            Context applicationContext = getContext().getApplicationContext();
            String r4 = SelectableItem.r(R.string.action_write_to_file_select_folder);
            ToastCompat.makeText(applicationContext, (CharSequence) ("   " + r4 + "   "), 1).show();
        } catch (Exception unused) {
            Context applicationContext2 = getContext().getApplicationContext();
            String r5 = SelectableItem.r(R.string.not_supported);
            ToastCompat.makeText(applicationContext2, (CharSequence) ("ACTION_OPEN_DOCUMENT_TREE " + r5), 0).show();
        }
    }

    private final void V() {
        this.workingVariableName = this.variableName;
        this.workingDictionaryKeys = this.dictionaryKeys;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_read_from_file);
        appCompatDialog.setTitle(getName());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        final Button button = (Button) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button2 = (Button) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.selectFileButton);
        Intrinsics.checkNotNull(findViewById3);
        ImageButton imageButton = (ImageButton) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.staticFilenameRadioButton);
        Intrinsics.checkNotNull(findViewById4);
        final RadioButton radioButton = (RadioButton) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.dynamicFilenameRadioButton);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = appCompatDialog.findViewById(R.id.filename);
        Intrinsics.checkNotNull(findViewById6);
        this.filenameEditText = (EditText) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.pick_dir_button);
        Intrinsics.checkNotNull(findViewById7);
        ImageButton imageButton2 = (ImageButton) findViewById7;
        this.dirText = (TextView) appCompatDialog.findViewById(R.id.directory_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.special_text_button_filename);
        View findViewById8 = appCompatDialog.findViewById(R.id.staticFilename);
        Intrinsics.checkNotNull(findViewById8);
        this.staticFilenameText = (TextView) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.viewFlipper);
        Intrinsics.checkNotNull(findViewById9);
        ViewFlipper viewFlipper = (ViewFlipper) findViewById9;
        View findViewById10 = appCompatDialog.findViewById(R.id.stringVariableSpinner);
        Intrinsics.checkNotNull(findViewById10);
        final Spinner spinner = (Spinner) findViewById10;
        View findViewById11 = appCompatDialog.findViewById(R.id.addStringVariableButton);
        Intrinsics.checkNotNull(findViewById11);
        Button button4 = (Button) findViewById11;
        radioButton.setChecked(this.staticFilename);
        ((RadioButton) findViewById5).setChecked(!this.staticFilename);
        Sdk27CoroutinesListenersWithCoroutinesKt.onCheckedChange$default(radioButton, (CoroutineContext) null, new a(viewFlipper, this, button, radioButton, spinner, null), 1, (Object) null);
        viewFlipper.setDisplayedChild(!this.staticFilename ? 1 : 0);
        TextView textView = this.staticFilenameText;
        Intrinsics.checkNotNull(textView);
        textView.setText(this.staticFilepath);
        this.temporaryPathName = this.pathName;
        EditText editText = this.filenameEditText;
        Intrinsics.checkNotNull(editText);
        editText.setText(this.filename);
        String str = this.temporaryPathName;
        if (str != null) {
            TextView textView2 = this.dirText;
            if (textView2 != null) {
                textView2.setText(str);
            }
        } else {
            TextView textView3 = this.dirText;
            if (textView3 != null) {
                String r4 = SelectableItem.r(R.string.action_write_to_file_select_folder);
                textView3.setText("<" + r4 + ">");
            }
        }
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadFileAction.W(ReadFileAction.this, view);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.arlosoft.macrodroid.action.ReadFileAction$displayConfigurationDialog$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s3) {
                Intrinsics.checkNotNullParameter(s3, "s");
                ReadFileAction.this.f0(button, radioButton, spinner);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                Intrinsics.checkNotNullParameter(s3, "s");
            }
        };
        ViewExtensionsKt.onClick$default(button4, null, new b(activity, spinner, this, button, radioButton, null), 1, null);
        d0(spinner, new c(button, radioButton, spinner));
        EditText editText2 = this.filenameEditText;
        Intrinsics.checkNotNull(editText2);
        editText2.addTextChangedListener(textWatcher);
        TextView textView4 = this.staticFilenameText;
        Intrinsics.checkNotNull(textView4);
        textView4.addTextChangedListener(textWatcher);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.tf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadFileAction.X(ReadFileAction.this, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.uf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadFileAction.Y(ReadFileAction.this, appCompatDialog, radioButton, view);
            }
        });
        f0(button, radioButton, spinner);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadFileAction.Z(ReadFileAction.this, appCompatDialog, view);
            }
        });
        appCompatDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.wf
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ReadFileAction.a0(ReadFileAction.this, appCompatDialog, dialogInterface);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.xf
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ReadFileAction.b0(ReadFileAction.this, magicTextPair);
            }
        };
        Intrinsics.checkNotNull(button3);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadFileAction.c0(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ReadFileAction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ReadFileAction this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ReadFileAction this$0, AppCompatDialog dialog, RadioButton radioButtonStatic, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(radioButtonStatic, "$radioButtonStatic");
        if (!this$0.staticFilename && this$0.temporaryPathName == null) {
            ToastCompat.makeText(this$0.getContext(), (int) R.string.action_write_to_file_select_folder, 1).show();
            return;
        }
        this$0.pathName = this$0.temporaryPathName;
        dialog.dismiss();
        this$0.variableName = this$0.workingVariableName;
        this$0.dictionaryKeys = this$0.workingDictionaryKeys;
        if (radioButtonStatic.isChecked()) {
            TextView textView = this$0.staticFilenameText;
            Intrinsics.checkNotNull(textView);
            this$0.staticFilepath = textView.getText().toString();
        } else {
            EditText editText = this$0.filenameEditText;
            Intrinsics.checkNotNull(editText);
            this$0.filename = editText.getText().toString();
        }
        this$0.dirText = null;
        this$0.staticFilename = radioButtonStatic.isChecked();
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ReadFileAction this$0, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.dirText = null;
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ReadFileAction this$0, AppCompatDialog dialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.dirText = null;
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ReadFileAction this$0, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(pair, "pair");
        EditText editText = this$0.filenameEditText;
        Intrinsics.checkNotNull(editText);
        int max = Math.max(editText.getSelectionStart(), 0);
        EditText editText2 = this$0.filenameEditText;
        Intrinsics.checkNotNull(editText2);
        int max2 = Math.max(editText2.getSelectionEnd(), 0);
        EditText editText3 = this$0.filenameEditText;
        Intrinsics.checkNotNull(editText3);
        Editable text = editText3.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Activity activity, MagicText.MagicTextListener filenameMagicTextListener, ReadFileAction this$0, View view) {
        Intrinsics.checkNotNullParameter(filenameMagicTextListener, "$filenameMagicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, filenameMagicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(Spinner spinner, final Function0<Unit> function0) {
        String str;
        List listOf = getAllStringVariables().isEmpty() ? kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select)) : CollectionsKt__CollectionsKt.emptyList();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        String str2 = this.workingVariableName;
        if (str2 != null) {
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ReadFileAction$initialiseStringVarSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                ReadFileAction.this.workingVariableName = variable.getName();
                ReadFileAction readFileAction = ReadFileAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                readFileAction.workingDictionaryKeys = dictionaryKeys;
                function0.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(String str) {
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Error - could not read from file: " + str + ". Need to re-select path and grant access.", macroGuid.longValue());
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String r4 = SelectableItem.r(R.string.read_file_failed_please_reconfigure_directory);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.read_…se_reconfigure_directory)");
        String name = getMacro().getName();
        Intrinsics.checkNotNullExpressionValue(name, "macro.name");
        StorageAccessFrameworkHelper.requiresAccessGranted(context, r4, name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r2.workingVariableName != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r2.workingVariableName != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f0(android.widget.Button r3, android.widget.RadioButton r4, android.widget.Spinner r5) {
        /*
            r2 = this;
            boolean r4 = r4.isChecked()
            r5 = 1
            r0 = 0
            if (r4 == 0) goto L26
            android.widget.TextView r4 = r2.staticFilenameText
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.CharSequence r4 = r4.getText()
            java.lang.String r1 = "staticFilenameText!!.text"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            int r4 = r4.length()
            if (r4 <= 0) goto L1e
            r4 = 1
            goto L1f
        L1e:
            r4 = 0
        L1f:
            if (r4 == 0) goto L44
            java.lang.String r4 = r2.workingVariableName
            if (r4 == 0) goto L44
            goto L45
        L26:
            android.widget.EditText r4 = r2.filenameEditText
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            android.text.Editable r4 = r4.getText()
            java.lang.String r1 = "filenameEditText!!.text"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            int r4 = r4.length()
            if (r4 <= 0) goto L3c
            r4 = 1
            goto L3d
        L3c:
            r4 = 0
        L3d:
            if (r4 == 0) goto L44
            java.lang.String r4 = r2.workingVariableName
            if (r4 == 0) goto L44
            goto L45
        L44:
            r5 = 0
        L45:
            r3.setEnabled(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ReadFileAction.f0(android.widget.Button, android.widget.RadioButton, android.widget.Spinner):void");
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str;
        if (this.staticFilename) {
            str = this.staticFilepath;
        } else {
            str = this.filename;
        }
        String str2 = this.variableName;
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.dictionaryKeys);
        return str + " -> " + str2 + formattedDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ReadFileActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        String[] strArr = new String[1];
        String str = this.filename;
        if (str == null) {
            str = "";
        }
        strArr[0] = str;
        return strArr;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    @Nullable
    public String getVariableName() {
        return this.variableName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @SuppressLint({"NewApi"})
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        String name;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i5 == -1) {
            String str = "";
            Uri uri = null;
            if (i4 != 1) {
                if (i4 == 2) {
                    if (intent != null) {
                        uri = intent.getData();
                    }
                    this.staticPathUri = String.valueOf(uri);
                    ContentResolver contentResolver = getContext().getContentResolver();
                    Intrinsics.checkNotNull(uri);
                    contentResolver.takePersistableUriPermission(uri, 1);
                    DocumentFile fromSingleUri = DocumentFile.fromSingleUri(getContext(), uri);
                    TextView textView = this.staticFilenameText;
                    if (textView != null) {
                        if (fromSingleUri != null && (name = fromSingleUri.getName()) != null) {
                            str = name;
                        }
                        textView.setText(str);
                        return;
                    }
                    return;
                }
                return;
            }
            if (intent != null) {
                uri = intent.getData();
            }
            this.pathUri = String.valueOf(uri);
            ContentResolver contentResolver2 = getContext().getContentResolver();
            Intrinsics.checkNotNull(uri);
            contentResolver2.takePersistableUriPermission(uri, 1);
            DocumentFile fromTreeUri = DocumentFile.fromTreeUri(getContext(), uri);
            Intrinsics.checkNotNull(fromTreeUri);
            DocumentFile parentFile = fromTreeUri.getParentFile();
            if (parentFile != null) {
                str = parentFile.getName();
            }
            String str2 = str + RemoteSettings.FORWARD_SLASH_STRING + fromTreeUri.getName();
            this.temporaryPathName = str2;
            TextView textView2 = this.dirText;
            if (textView2 != null) {
                textView2.setText(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        V();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.dictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        boolean z3;
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            this.filename = magicText[0];
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariableName
    public void setVariableName(@Nullable String str) {
        this.variableName = str;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.variableName);
        out.writeParcelable(this.dictionaryKeys, i4);
        out.writeString(this.staticFilepath);
        out.writeString(this.staticPathUri);
        out.writeString(this.filename);
        out.writeString(this.pathUri);
        out.writeString(this.pathName);
        out.writeInt(this.staticFilename ? 1 : 0);
    }

    public ReadFileAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new d(triggerContextInfo, z4, i4, z3, skipEndifIndexStack, resumeMacroInfo, null), 2, null);
    }

    public ReadFileAction() {
        this.staticFilename = true;
    }

    private ReadFileAction(Parcel parcel) {
        super(parcel);
        this.staticFilename = true;
        this.variableName = parcel.readString();
        this.dictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
        this.staticFilepath = parcel.readString();
        this.staticPathUri = parcel.readString();
        this.filename = parcel.readString();
        this.pathUri = parcel.readString();
        this.pathName = parcel.readString();
        this.staticFilename = parcel.readInt() != 0;
    }

    /* compiled from: ReadFileAction.kt */
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
