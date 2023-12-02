package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ShellScriptActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.helper.HelperCommonFunctionality;
import com.arlosoft.macrodroid.helper.HelperResultHandler;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.RootTools;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DelicateCoroutinesApi;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShellScriptAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nShellScriptAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShellScriptAction.kt\ncom/arlosoft/macrodroid/action/ShellScriptAction\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,564:1\n37#2,2:565\n*S KotlinDebug\n*F\n+ 1 ShellScriptAction.kt\ncom/arlosoft/macrodroid/action/ShellScriptAction\n*L\n280#1:565,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ShellScriptAction extends Action implements SupportsMagicText, HasVariable, BlockingAction, HasDictionaryKeys {
    @Nullable
    private static Shell nonRootShell;
    @Nullable
    private static Shell rootShell;
    private static int s_actionCounter;
    private boolean blockNextAction;
    @Nullable
    private transient Command currentCommand;
    @Inject
    public transient HelperResultHandler helperResultHandler;
    private transient long lastTerminateTimestamp;
    private boolean m_nonRoot;
    @NotNull
    private String m_script;
    @Nullable
    private MacroDroidVariable m_variableToSaveResponse;
    private int timeoutSeconds;
    private boolean useHelper;
    @Nullable
    private DictionaryKeys varDictionaryKeys;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient MacroDroidVariable workingVariable;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull
    private static final int[] TIMEOUT_VALUE_SECONDS = {5, 10, 30, 60, 120, 300, 600, 1200, 1800, 3600};
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShellScriptAction> CREATOR = new Parcelable.Creator<ShellScriptAction>() { // from class: com.arlosoft.macrodroid.action.ShellScriptAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShellScriptAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShellScriptAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ShellScriptAction[] newArray(int i4) {
            return new ShellScriptAction[i4];
        }
    };

    public /* synthetic */ ShellScriptAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void R(final Spinner spinner) {
        List listOf;
        String str;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.dont_save_output_in_variable));
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        String str2 = null;
        if (getVariable() != null) {
            MacroDroidVariable variable = getVariable();
            if (variable != null) {
                str2 = variable.getName();
            }
            str = str2 + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        } else {
            str = null;
        }
        VariableHelper.configureStringVarSpinner(activity, R.style.Theme_App_Dialog_Action, this, spinner, macro, listOf, str, true, null, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ShellScriptAction$configureStringVarSpinner$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ShellScriptAction.this.workingVariable = null;
                ShellScriptAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable2, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable2, "variable");
                spinner.setEnabled(true);
                spinner.setAlpha(1.0f);
                ShellScriptAction.this.workingVariable = variable2;
                ShellScriptAction shellScriptAction = ShellScriptAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                shellScriptAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
    }

    private final void S() {
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logVerbose("Creating non-root shell", macroGuid.longValue());
        try {
            nonRootShell = RootTools.getShell(false, 600000, Shell.ShellContext.NORMAL);
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            SystemLog.logVerbose("Created non-root shell", macroGuid2.longValue());
        } catch (Exception e4) {
            Long macroGuid3 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
            SystemLog.logError("Failed to create non-root shell: " + e4, macroGuid3.longValue());
        }
    }

    private final void T() {
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logVerbose("Creating root shell", macroGuid.longValue());
        try {
            rootShell = RootTools.getShell(true, 600000, Shell.ShellContext.SYSTEM_APP);
            Long macroGuid2 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
            SystemLog.logVerbose("Created root shell", macroGuid2.longValue());
        } catch (Exception unused) {
        }
    }

    private final String[] U() {
        String r4 = SelectableItem.r(R.string.seconds_5);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.seconds_5)");
        String r5 = SelectableItem.r(R.string.seconds_10);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.seconds_10)");
        String r6 = SelectableItem.r(R.string.seconds_30);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.seconds_30)");
        String r7 = SelectableItem.r(R.string.minute_1);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.minute_1)");
        String r8 = SelectableItem.r(R.string.minutes_2);
        Intrinsics.checkNotNullExpressionValue(r8, "getString(R.string.minutes_2)");
        String r9 = SelectableItem.r(R.string.minutes_5);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(R.string.minutes_5)");
        String r10 = SelectableItem.r(R.string.minutes_10);
        Intrinsics.checkNotNullExpressionValue(r10, "getString(R.string.minutes_10)");
        String r11 = SelectableItem.r(R.string.minutes_20);
        Intrinsics.checkNotNullExpressionValue(r11, "getString(R.string.minutes_20)");
        String r12 = SelectableItem.r(R.string.minutes_30);
        Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.minutes_30)");
        String r13 = SelectableItem.r(R.string.minutes_60);
        Intrinsics.checkNotNullExpressionValue(r13, "getString(R.string.minutes_60)");
        return new String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(ShellScriptAction this$0, CheckBox checkBox, EditText editText, AppCompatDialog dialog, RadioButton radioButton, CheckBox checkBox2, Spinner spinner, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.m_variableToSaveResponse = this$0.workingVariable;
        this$0.varDictionaryKeys = this$0.workingDictionaryKeys;
        this$0.useHelper = checkBox.isChecked();
        Intrinsics.checkNotNull(editText);
        this$0.m_script = editText.getText().toString();
        dialog.dismiss();
        Intrinsics.checkNotNull(radioButton);
        this$0.m_nonRoot = radioButton.isChecked();
        Intrinsics.checkNotNull(checkBox2);
        this$0.blockNextAction = checkBox2.isChecked();
        int[] iArr = TIMEOUT_VALUE_SECONDS;
        Intrinsics.checkNotNull(spinner);
        this$0.timeoutSeconds = iArr[spinner.getSelectedItemPosition()];
        this$0.itemComplete();
        if (this$0.requiresNewHelperFile(ApplicationChecker.getMacroDroidHelperVersionCode())) {
            PermissionsHelper.showNeedsNewHelperFileDialog(activity, false, false, this$0.getConfiguredName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(EditText editText, MagicText.MagicTextPair pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Intrinsics.checkNotNull(editText);
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = pair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Activity activity, MagicText.MagicTextListener magicTextListener, ShellScriptAction this$0, View view) {
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MagicText.displaySelectionDialog(activity, magicTextListener, this$0.getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
        if (r0.isClosed != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x006e, code lost:
        if (r0.isClosed != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Z(java.lang.String r15, com.arlosoft.macrodroid.action.ShellScriptAction r16, boolean r17, int r18, com.arlosoft.macrodroid.triggers.TriggerContextInfo r19, boolean r20, java.util.Stack r21, com.arlosoft.macrodroid.data.ResumeMacroInfo r22) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ShellScriptAction.Z(java.lang.String, com.arlosoft.macrodroid.action.ShellScriptAction, boolean, int, com.arlosoft.macrodroid.triggers.TriggerContextInfo, boolean, java.util.Stack, com.arlosoft.macrodroid.data.ResumeMacroInfo):void");
    }

    @DelicateCoroutinesApi
    private final void a0(String str, TriggerContextInfo triggerContextInfo, int i4, boolean z3, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, boolean z4) {
        if (ApplicationChecker.isMacroDroidNewHelperInstalled()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String name = getMacro().getName();
            Intrinsics.checkNotNullExpressionValue(name, "macro.name");
            int sendShellScriptCommand = HelperSystemCommands.sendShellScriptCommand(context, str, this.timeoutSeconds, !this.m_nonRoot, name);
            if (!this.blockNextAction && !z4) {
                getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, stack, resumeMacroInfo);
            }
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new ShellScriptAction$invokeActionViaHelper$1(this, sendShellScriptCommand, triggerContextInfo, z4, i4, z3, stack, resumeMacroInfo, null), 3, null);
            return;
        }
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Shell Script action is configured to use the helper file, but the helper file is not installed. Please see: https://macrodroidforum.com/index.php?threads/macrodroid-helper-apk.1/", macroGuid.longValue());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        String name2 = getName();
        Intrinsics.checkNotNullExpressionValue(name2, "name");
        HelperCommonFunctionality.showMissingHelperFileNotification(context2, name2, "1.7");
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean allowConfigurationWithoutHelperFile() {
        return true;
    }

    public final void cancelShellCommand() {
        Command command = this.currentCommand;
        if (command != null) {
            command.terminate();
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doDisable() {
        try {
            int i4 = s_actionCounter - 1;
            s_actionCounter = i4;
            if (i4 == 0) {
                Shell shell = rootShell;
                if (shell != null) {
                    Intrinsics.checkNotNull(shell);
                    if (!shell.isClosed) {
                        Shell shell2 = rootShell;
                        Intrinsics.checkNotNull(shell2);
                        shell2.close();
                    }
                }
                Shell shell3 = nonRootShell;
                if (shell3 != null) {
                    Intrinsics.checkNotNull(shell3);
                    if (!shell3.isClosed) {
                        Shell shell4 = nonRootShell;
                        Intrinsics.checkNotNull(shell4);
                        shell4.close();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void doEnable() {
        try {
            if (s_actionCounter == 0) {
                S();
                T();
            }
            s_actionCounter++;
        } catch (Exception unused) {
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return this.m_script;
    }

    @NotNull
    public final HelperResultHandler getHelperResultHandler() {
        HelperResultHandler helperResultHandler = this.helperResultHandler;
        if (helperResultHandler != null) {
            return helperResultHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helperResultHandler");
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo shellScriptActionInfo = ShellScriptActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(shellScriptActionInfo, "getInstance()");
        return shellScriptActionInfo;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.m_script};
    }

    public final int getRootLevel() {
        return 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@Nullable TriggerContextInfo triggerContextInfo) {
        String name = getName();
        String g4 = g(this.m_script, triggerContextInfo);
        return name + " '" + g4 + "'";
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    @Nullable
    public MacroDroidVariable getVariable() {
        return this.m_variableToSaveResponse;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_shell_script);
        appCompatDialog.setTitle(R.string.action_shell_script);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window);
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        Window window2 = appCompatDialog.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(layoutParams);
        this.workingVariable = this.m_variableToSaveResponse;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.dialog_shell_script_text);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.dialog_shell_script_magic_text_button);
        View findViewById = appCompatDialog.findViewById(R.id.dialog_shell_script_variable_spinner);
        Intrinsics.checkNotNull(findViewById);
        Spinner spinner = (Spinner) findViewById;
        RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.root_only);
        final RadioButton radioButton2 = (RadioButton) appCompatDialog.findViewById(R.id.non_rooted);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.blockActionsCheckbox);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.timeoutSpinner);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.helperFileCheckBox);
        Intrinsics.checkNotNull(checkBox2);
        checkBox2.setChecked(this.useHelper);
        int length = TIMEOUT_VALUE_SECONDS.length;
        int i4 = 0;
        while (true) {
            if (i4 < length) {
                int i5 = length;
                if (this.timeoutSeconds == TIMEOUT_VALUE_SECONDS[i4]) {
                    break;
                }
                i4++;
                length = i5;
            } else {
                i4 = 0;
                break;
            }
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, (int) R.layout.simple_spinner_item, U());
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        }
        if (spinner2 != null) {
            spinner2.setSelection(0, false);
        }
        if (spinner2 != null) {
            spinner2.setSelection(i4);
        }
        appCompatDialog.dismiss();
        if (radioButton != null) {
            radioButton.setChecked(!this.m_nonRoot);
        }
        if (radioButton2 != null) {
            radioButton2.setChecked(this.m_nonRoot);
        }
        if (checkBox != null) {
            checkBox.setChecked(this.blockNextAction);
        }
        R(spinner);
        String str = this.m_script;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            if (editText != null) {
                editText.setText(this.m_script);
            }
            if (editText != null) {
                editText.setSelection(editText.length());
            }
            if (button != null) {
                button.setEnabled(true);
            }
        } else if (button != null) {
            button.setEnabled(false);
        }
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.action.ShellScriptAction$handleItemSelected$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(@NotNull Editable s3) {
                    boolean z4;
                    Intrinsics.checkNotNullParameter(s3, "s");
                    Button button4 = button;
                    if (button4 != null) {
                        if (editText.getText().length() > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        button4.setEnabled(z4);
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@NotNull CharSequence s3, int i6, int i7, int i8) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@NotNull CharSequence s3, int i6, int i7, int i8) {
                    Intrinsics.checkNotNullParameter(s3, "s");
                }
            });
        }
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pn
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShellScriptAction.V(ShellScriptAction.this, checkBox2, editText, appCompatDialog, radioButton2, checkBox, spinner2, activity, view);
                }
            });
        }
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qn
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShellScriptAction.W(AppCompatDialog.this, view);
                }
            });
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.rn
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ShellScriptAction.X(editText, magicTextPair);
            }
        };
        Intrinsics.checkNotNull(button3);
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShellScriptAction.Y(activity, magicTextListener, this, view);
            }
        });
        appCompatDialog.show();
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        String replace$default;
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_script, triggerContextInfo, getMacro());
        Intrinsics.checkNotNullExpressionValue(replaceMagicText, "replaceMagicText(context…ript, contextInfo, macro)");
        replace$default = kotlin.text.m.replace$default(replaceMagicText, "\\n", "\n", false, 4, (Object) null);
        if (this.useHelper) {
            a0(replace$default, triggerContextInfo, i4, z3, skipEndifIndexStack, resumeMacroInfo, z4);
        } else {
            invokeActionStandard(replace$default, triggerContextInfo, i4, z3, skipEndifIndexStack, resumeMacroInfo, z4);
        }
    }

    public final void invokeActionStandard(@NotNull final String script, @Nullable final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NotNull final Stack<Integer> skipEndifIndexStack, @Nullable final ResumeMacroInfo resumeMacroInfo, final boolean z4) {
        Intrinsics.checkNotNullParameter(script, "script");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        new Thread(new Runnable() { // from class: com.arlosoft.macrodroid.action.on
            @Override // java.lang.Runnable
            public final void run() {
                ShellScriptAction.Z(script, this, z4, i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
            }
        }).start();
        if (!this.blockNextAction && !z4) {
            getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isRootOnly() {
        return !this.m_nonRoot;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public Pair<Integer, String> requiresNewHelperFileVersion() {
        if (this.useHelper) {
            return new Pair<>(7, "1.7");
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    public final void setHelperResultHandler(@NotNull HelperResultHandler helperResultHandler) {
        Intrinsics.checkNotNullParameter(helperResultHandler, "<set-?>");
        this.helperResultHandler = helperResultHandler;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 1) {
            this.m_script = magicText[0];
            return;
        }
        String str = this.m_classType;
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void testActionWithPermissionCheck(@Nullable TriggerContextInfo triggerContextInfo) {
        if (checkAllPermissions()) {
            Intrinsics.checkNotNull(triggerContextInfo);
            invokeAction(triggerContextInfo, 0, true, new Stack<>(), null, true);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.m_script);
        out.writeParcelable(this.m_variableToSaveResponse, i4);
        out.writeInt(this.m_nonRoot ? 1 : 0);
        out.writeInt(this.blockNextAction ? 1 : 0);
        out.writeInt(this.timeoutSeconds);
        out.writeInt(this.useHelper ? 1 : 0);
        out.writeParcelable(this.varDictionaryKeys, i4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShellScriptAction(@Nullable Activity activity, @NotNull Macro macro) {
        this();
        Intrinsics.checkNotNullParameter(macro, "macro");
        setActivity(activity);
        this.m_macro = macro;
    }

    private ShellScriptAction() {
        this.m_script = "";
        init();
        this.timeoutSeconds = 600;
    }

    private ShellScriptAction(Parcel parcel) {
        super(parcel);
        this.m_script = "";
        init();
        String readString = parcel.readString();
        this.m_script = readString != null ? readString : "";
        this.m_variableToSaveResponse = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_nonRoot = parcel.readInt() != 0;
        this.blockNextAction = parcel.readInt() != 0;
        this.timeoutSeconds = parcel.readInt();
        this.useHelper = parcel.readInt() != 0;
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: ShellScriptAction.kt */
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
