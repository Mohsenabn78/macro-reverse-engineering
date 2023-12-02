package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ConnectivityCheckActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.google.android.material.textfield.TextInputLayout;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectivityCheckAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ConnectivityCheckAction extends Action implements HasVariable, SupportsMagicText, BlockingAction, HasDictionaryKeys {
    private boolean blockActions;
    @NotNull
    private String site;
    private int timeout;
    @Nullable
    private DictionaryKeys varDictionaryKeys;
    @Nullable
    private MacroDroidVariable variable;
    @Nullable
    private transient DictionaryKeys workingDictionaryKeys;
    @Nullable
    private transient MacroDroidVariable workingVariable;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ConnectivityCheckAction> CREATOR = new Parcelable.Creator<ConnectivityCheckAction>() { // from class: com.arlosoft.macrodroid.action.ConnectivityCheckAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ConnectivityCheckAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConnectivityCheckAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ConnectivityCheckAction[] newArray(int i4) {
            return new ConnectivityCheckAction[i4];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConnectivityCheckAction.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        final /* synthetic */ TriggerContextInfo $contextInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(TriggerContextInfo triggerContextInfo) {
            super(1);
            this.$contextInfo = triggerContextInfo;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean connected) {
            ConnectivityCheckAction connectivityCheckAction = ConnectivityCheckAction.this;
            Intrinsics.checkNotNullExpressionValue(connected, "connected");
            connectivityCheckAction.h0(connected.booleanValue(), this.$contextInfo);
            if (ConnectivityCheckAction.this.getMacro().isExcludedFromLog()) {
                return;
            }
            String str = "Connected to " + ConnectivityCheckAction.this.site + ": " + connected;
            Long macroGuid = ConnectivityCheckAction.this.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logInfo(str, macroGuid.longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConnectivityCheckAction.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ TriggerContextInfo $contextInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(TriggerContextInfo triggerContextInfo) {
            super(1);
            this.$contextInfo = triggerContextInfo;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (!ConnectivityCheckAction.this.getMacro().isExcludedFromLog()) {
                if ((th instanceof UnknownHostException) || (th instanceof TimeoutException)) {
                    Long macroGuid = ConnectivityCheckAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                    SystemLog.logInfo("Could not connect to: " + ConnectivityCheckAction.this.site, macroGuid.longValue());
                } else {
                    Long macroGuid2 = ConnectivityCheckAction.this.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                    SystemLog.logError("Connectivity check failure: " + th.getMessage(), macroGuid2.longValue());
                }
            }
            ConnectivityCheckAction.this.h0(false, this.$contextInfo);
        }
    }

    public /* synthetic */ ConnectivityCheckAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final ConnectivityCheckAction this$0, final Spinner booleanVariableSpinner, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        VariablesHelper.createNewVariable(this$0.getActivity(), booleanVariableSpinner, this$0, this$0.getDialogTheme(), 0, new VariablesHelper.VariableCreatedListener() { // from class: com.arlosoft.macrodroid.action.j4
            @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
            public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                ConnectivityCheckAction.X(ConnectivityCheckAction.this, booleanVariableSpinner, macroDroidVariable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(final ConnectivityCheckAction this$0, Spinner booleanVariableSpinner, MacroDroidVariable macroDroidVariable) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        this$0.workingVariable = macroDroidVariable;
        this$0.workingDictionaryKeys = null;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        VariableHelper.configureBooleanVarSpinner(activity, R.style.Theme_App_Dialog_Action, this$0, booleanVariableSpinner, this$0.getMacro(), true, listOf, macroDroidVariable.getName(), "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ConnectivityCheckAction$handleItemSelected$1$1$1
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ConnectivityCheckAction.this.workingVariable = null;
                ConnectivityCheckAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                ConnectivityCheckAction.this.workingVariable = variable;
                ConnectivityCheckAction connectivityCheckAction = ConnectivityCheckAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                connectivityCheckAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditText urlText, MagicText.MagicTextPair magicTextPair) {
        Intrinsics.checkNotNullParameter(urlText, "$urlText");
        int max = Math.max(urlText.getSelectionStart(), 0);
        int max2 = Math.max(urlText.getSelectionEnd(), 0);
        Editable text = urlText.getText();
        Intrinsics.checkNotNull(text);
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(ConnectivityCheckAction this$0, MagicText.MagicTextListener magicTextListener, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(magicTextListener, "$magicTextListener");
        MagicText.displaySelectionDialog(this$0.getActivity(), magicTextListener, this$0.getMacro(), R.style.Theme_App_Dialog_Action_SmallText, this$0.isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(EditText urlText, EditText timeoutMs, Spinner booleanVariableSpinner, String noBooleanVarsConfigured, ConnectivityCheckAction this$0, CheckBox blockActionsCheckbox, AppCompatDialog dialog, View view) {
        boolean z3;
        Intrinsics.checkNotNullParameter(urlText, "$urlText");
        Intrinsics.checkNotNullParameter(timeoutMs, "$timeoutMs");
        Intrinsics.checkNotNullParameter(booleanVariableSpinner, "$booleanVariableSpinner");
        Intrinsics.checkNotNullParameter(noBooleanVarsConfigured, "$noBooleanVarsConfigured");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(blockActionsCheckbox, "$blockActionsCheckbox");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Editable text = urlText.getText();
        Intrinsics.checkNotNull(text);
        boolean z4 = true;
        if (text.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            Editable text2 = timeoutMs.getText();
            Intrinsics.checkNotNull(text2);
            if (text2.length() != 0) {
                z4 = false;
            }
            if (!z4 && booleanVariableSpinner.getAdapter().getCount() != 0 && !Intrinsics.areEqual(booleanVariableSpinner.getSelectedItem(), noBooleanVarsConfigured)) {
                if (this$0.workingVariable == null) {
                    ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.action_set_variable_select, 0).show();
                    return;
                }
                this$0.site = urlText.getText().toString();
                this$0.timeout = Integer.parseInt(timeoutMs.getText().toString());
                this$0.blockActions = blockActionsCheckbox.isChecked();
                this$0.variable = this$0.workingVariable;
                this$0.varDictionaryKeys = this$0.workingDictionaryKeys;
                dialog.dismiss();
                this$0.itemComplete();
                return;
            }
        }
        ToastCompat.makeText(this$0.getActivity().getApplicationContext(), (int) R.string.invalid_value, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource c0(ConnectivityCheckAction this$0, TriggerContextInfo triggerContextInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return Single.just(Boolean.valueOf(this$0.g0(triggerContextInfo)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(ConnectivityCheckAction this$0, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack skipToEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skipToEndifIndexStack, "$skipToEndifIndexStack");
        if (this$0.blockActions && !z3) {
            this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z4, skipToEndifIndexStack, resumeMacroInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean g0(com.arlosoft.macrodroid.triggers.TriggerContextInfo r6) {
        /*
            r5 = this;
            java.lang.String r0 = "http://"
            android.content.Context r1 = r5.getContext()
            java.lang.String r2 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            r2 = 0
            if (r1 == 0) goto La9
            boolean r1 = r1.isConnected()
            if (r1 == 0) goto La9
            android.content.Context r1 = r5.getContext()     // Catch: java.lang.Exception -> L83
            java.lang.String r3 = r5.site     // Catch: java.lang.Exception -> L83
            com.arlosoft.macrodroid.macro.Macro r4 = r5.getMacro()     // Catch: java.lang.Exception -> L83
            java.lang.String r6 = com.arlosoft.macrodroid.common.MagicText.replaceMagicText(r1, r3, r6, r2, r4)     // Catch: java.lang.Exception -> L83
            java.lang.String r1 = "siteToUse"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch: java.lang.Exception -> L83
            r1 = 0
            r3 = 2
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r6, r0, r2, r3, r1)     // Catch: java.lang.Exception -> L83
            if (r4 != 0) goto L59
            java.lang.String r4 = "https://"
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r6, r4, r2, r3, r1)     // Catch: java.lang.Exception -> L83
            if (r1 == 0) goto L44
            goto L59
        L44:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L83
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L83
            r3.<init>()     // Catch: java.lang.Exception -> L83
            r3.append(r0)     // Catch: java.lang.Exception -> L83
            r3.append(r6)     // Catch: java.lang.Exception -> L83
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Exception -> L83
            r1.<init>(r6)     // Catch: java.lang.Exception -> L83
            goto L5e
        L59:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L83
            r1.<init>(r6)     // Catch: java.lang.Exception -> L83
        L5e:
            java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Exception -> L83
            java.lang.String r0 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r0)     // Catch: java.lang.Exception -> L83
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Exception -> L83
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "close"
            r6.setRequestProperty(r0, r1)     // Catch: java.lang.Exception -> L83
            int r0 = r5.timeout     // Catch: java.lang.Exception -> L83
            r6.setConnectTimeout(r0)     // Catch: java.lang.Exception -> L83
            r6.connect()     // Catch: java.lang.Exception -> L83
            int r6 = r6.getResponseCode()     // Catch: java.lang.Exception -> L83
            r0 = 200(0xc8, float:2.8E-43)
            if (r6 != r0) goto La9
            r6 = 1
            r2 = 1
            goto La9
        L83:
            r6 = move-exception
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Connectivity check failure: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.Long r0 = r5.getMacroGuid()
            java.lang.String r1 = "macroGuid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            long r0 = r0.longValue()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r6, r0)
        La9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ConnectivityCheckAction.g0(com.arlosoft.macrodroid.triggers.TriggerContextInfo):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(boolean z3, TriggerContextInfo triggerContextInfo) {
        String str;
        List<String> emptyList;
        MacroDroidVariable macroDroidVariable = this.variable;
        String str2 = null;
        if (macroDroidVariable != null) {
            str = macroDroidVariable.getName();
        } else {
            str = null;
        }
        MacroDroidVariable variableByName = getVariableByName(str);
        if (variableByName == null) {
            MacroDroidVariable macroDroidVariable2 = this.variable;
            if (macroDroidVariable2 != null) {
                str2 = macroDroidVariable2.getName();
            }
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Connectivity check action variable not found " + str2, macroGuid.longValue());
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.varDictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        variableUpdate(variableByName, new VariableValue.BooleanValue(z3, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro())));
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    @Nullable
    public DictionaryKeys getDictionaryKeys() {
        return this.varDictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str;
        String str2 = this.site;
        MacroDroidVariable macroDroidVariable = this.variable;
        if (macroDroidVariable != null) {
            str = macroDroidVariable.getName();
        } else {
            str = null;
        }
        return str2 + " -> " + str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ConnectivityCheckActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.site};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    @Nullable
    public MacroDroidVariable getVariable() {
        return this.variable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        WindowManager.LayoutParams layoutParams;
        List listOf;
        final Spinner spinner;
        List listOf2;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_connectivity_check);
        appCompatDialog.setTitle(R.string.action_connectivity_check);
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        Window window = appCompatDialog.getWindow();
        String str = null;
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        layoutParams2.copyFrom(layoutParams);
        layoutParams2.width = -1;
        Window window2 = appCompatDialog.getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams2);
        }
        View findViewById = appCompatDialog.findViewById(R.id.timeoutMsTextInput);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.urlText);
        Intrinsics.checkNotNull(findViewById2);
        final EditText editText = (EditText) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.timeoutMs);
        Intrinsics.checkNotNull(findViewById3);
        final EditText editText2 = (EditText) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.blockActionsCheckbox);
        Intrinsics.checkNotNull(findViewById4);
        final CheckBox checkBox = (CheckBox) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.addVariableButton);
        Intrinsics.checkNotNull(findViewById5);
        View findViewById6 = appCompatDialog.findViewById(R.id.booleanVariableSpinner);
        Intrinsics.checkNotNull(findViewById6);
        final Spinner spinner2 = (Spinner) findViewById6;
        View findViewById7 = appCompatDialog.findViewById(R.id.urlMagicTextButton);
        Intrinsics.checkNotNull(findViewById7);
        Button button = (Button) findViewById7;
        View findViewById8 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById8);
        Button button2 = (Button) findViewById8;
        View findViewById9 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById9);
        Button button3 = (Button) findViewById9;
        String string = getContext().getString(R.string.timeout);
        String string2 = getContext().getString(R.string.milliseconds_capital);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.milliseconds_capital)");
        String lowerCase = string2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        ((TextInputLayout) findViewById).setHint(string + " (" + lowerCase + ")");
        editText.setText(this.site);
        editText2.setText(String.valueOf(this.timeout));
        checkBox.setChecked(this.blockActions);
        ((Button) findViewById5).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.e4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectivityCheckAction.W(ConnectivityCheckAction.this, spinner2, view);
            }
        });
        this.workingVariable = this.variable;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        listOf = kotlin.collections.e.listOf(SelectableItem.r(R.string.action_set_variable_select));
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        MacroDroidVariable macroDroidVariable = this.variable;
        if (macroDroidVariable != null) {
            if (macroDroidVariable != null) {
                str = macroDroidVariable.getName();
            }
            str = str + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        }
        VariableHelper.configureBooleanVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner2, macro, true, listOf, str, "", true, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.ConnectivityCheckAction$handleItemSelected$2
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i4, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                ConnectivityCheckAction.this.workingVariable = null;
                ConnectivityCheckAction.this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                ConnectivityCheckAction.this.workingVariable = variable;
                ConnectivityCheckAction connectivityCheckAction = ConnectivityCheckAction.this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                connectivityCheckAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
        final String string3 = getContext().getString(R.string.no_boolean_variables_configured);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…ean_variables_configured)");
        if (spinner2.getCount() == 0) {
            Activity activity3 = getActivity();
            listOf2 = kotlin.collections.e.listOf(string3);
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity3, (int) R.layout.simple_spinner_item, listOf2);
            arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner = spinner2;
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        } else {
            spinner = spinner2;
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.f4
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ConnectivityCheckAction.Y(editText, magicTextPair);
            }
        };
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectivityCheckAction.Z(ConnectivityCheckAction.this, magicTextListener, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectivityCheckAction.a0(editText, editText2, spinner, string3, this, checkBox, appCompatDialog, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.i4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConnectivityCheckAction.b0(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0005, code lost:
        if (r5.length == 1) goto L5;
     */
    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setPossibleMagicText(@org.jetbrains.annotations.Nullable java.lang.String[] r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L8
            int r1 = r5.length
            r2 = 1
            if (r1 != r2) goto L8
            goto L9
        L8:
            r2 = 0
        L9:
            if (r2 == 0) goto L10
            r5 = r5[r0]
            r4.site = r5
            goto L34
        L10:
            com.google.firebase.crashlytics.FirebaseCrashlytics r5 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = r4.m_classType
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SetPossibleMagicText incorrect array length ("
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = ")"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r5.recordException(r0)
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ConnectivityCheckAction.setPossibleMagicText(java.lang.String[]):void");
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void testActionWithPermissionCheck(@Nullable TriggerContextInfo triggerContextInfo) {
        if (checkAllPermissions()) {
            invokeAction(triggerContextInfo, 0, true, new Stack<>(), null, true);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.site);
        out.writeInt(this.timeout);
        out.writeParcelable(this.variable, i4);
        out.writeInt(this.blockActions ? 1 : 0);
        out.writeParcelable(this.varDictionaryKeys, i4);
    }

    public ConnectivityCheckAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NotNull final Stack<Integer> skipToEndifIndexStack, @Nullable final ResumeMacroInfo resumeMacroInfo, final boolean z4) {
        Intrinsics.checkNotNullParameter(skipToEndifIndexStack, "skipToEndifIndexStack");
        Single doFinally = Single.defer(new Callable() { // from class: com.arlosoft.macrodroid.action.a4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                SingleSource c02;
                c02 = ConnectivityCheckAction.c0(ConnectivityCheckAction.this, triggerContextInfo);
                return c02;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new io.reactivex.functions.Action() { // from class: com.arlosoft.macrodroid.action.b4
            @Override // io.reactivex.functions.Action
            public final void run() {
                ConnectivityCheckAction.d0(ConnectivityCheckAction.this, z4, i4, triggerContextInfo, z3, skipToEndifIndexStack, resumeMacroInfo);
            }
        });
        final a aVar = new a(triggerContextInfo);
        Consumer consumer = new Consumer() { // from class: com.arlosoft.macrodroid.action.c4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConnectivityCheckAction.e0(Function1.this, obj);
            }
        };
        final b bVar = new b(triggerContextInfo);
        doFinally.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.action.d4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConnectivityCheckAction.f0(Function1.this, obj);
            }
        });
        if (this.blockActions || z4) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipToEndifIndexStack, resumeMacroInfo);
    }

    public ConnectivityCheckAction() {
        this.site = "www.google.com";
        this.timeout = 3000;
        this.blockActions = true;
    }

    private ConnectivityCheckAction(Parcel parcel) {
        super(parcel);
        this.site = "www.google.com";
        this.timeout = 3000;
        this.blockActions = true;
        String readString = parcel.readString();
        this.site = readString == null ? "" : readString;
        this.timeout = parcel.readInt();
        this.variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.blockActions = parcel.readInt() != 0;
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: ConnectivityCheckAction.kt */
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
