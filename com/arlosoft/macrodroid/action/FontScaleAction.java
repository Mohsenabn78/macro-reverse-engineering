package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.FontScaleActionInfo;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.interfaces.HasDictionaryKeys;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FontScaleAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFontScaleAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FontScaleAction.kt\ncom/arlosoft/macrodroid/action/FontScaleAction\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,207:1\n262#2,2:208\n262#2,2:210\n*S KotlinDebug\n*F\n+ 1 FontScaleAction.kt\ncom/arlosoft/macrodroid/action/FontScaleAction\n*L\n161#1:208,2\n162#1:210,2\n*E\n"})
/* loaded from: classes2.dex */
public final class FontScaleAction extends Action implements HasVariable, HasDictionaryKeys {
    private int scalePercent;
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
    public static final Parcelable.Creator<FontScaleAction> CREATOR = new Parcelable.Creator<FontScaleAction>() { // from class: com.arlosoft.macrodroid.action.FontScaleAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FontScaleAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FontScaleAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FontScaleAction[] newArray(int i4) {
            return new FontScaleAction[i4];
        }
    };

    /* compiled from: FontScaleAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $scaleAsFloat;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f4, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$scaleAsFloat = f4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$scaleAsFloat, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            try {
                Settings.System.putFloat(FontScaleAction.this.getContext().getContentResolver(), "font_scale", this.$scaleAsFloat);
            } catch (Exception e4) {
                Long macroGuid = FontScaleAction.this.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Could not set font_scale: " + e4, macroGuid.longValue());
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ FontScaleAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(FontScaleAction this$0, SeekBar seekBar, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(seekBar, "$seekBar");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.scalePercent = seekBar.getProgress() + 50;
        this$0.itemComplete();
        dialog.dismiss();
        this$0.variable = this$0.workingVariable;
        this$0.varDictionaryKeys = this$0.workingDictionaryKeys;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
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
        MacroDroidVariable macroDroidVariable = this.variable;
        if (macroDroidVariable == null) {
            int i4 = this.scalePercent;
            return i4 + "%";
        }
        if (macroDroidVariable != null) {
            str = macroDroidVariable.getName();
        } else {
            str = null;
        }
        String formattedDictionaryKeys = VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        return str + formattedDictionaryKeys + "%";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return FontScaleActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    @Nullable
    public MacroDroidVariable getVariable() {
        return this.variable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        int i4;
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_font_scale);
        appCompatDialog.setTitle(R.string.action_font_scale);
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        View findViewById = appCompatDialog.findViewById(R.id.seekBar);
        Intrinsics.checkNotNull(findViewById);
        final SeekBar seekBar = (SeekBar) findViewById;
        View findViewById2 = appCompatDialog.findViewById(R.id.percentText);
        Intrinsics.checkNotNull(findViewById2);
        final TextView textView = (TextView) findViewById2;
        View findViewById3 = appCompatDialog.findViewById(R.id.variablesSpinner);
        Intrinsics.checkNotNull(findViewById3);
        Spinner spinner = (Spinner) findViewById3;
        View findViewById4 = appCompatDialog.findViewById(R.id.barLayout);
        Intrinsics.checkNotNull(findViewById4);
        final ViewGroup viewGroup = (ViewGroup) findViewById4;
        View findViewById5 = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById5);
        Button button = (Button) findViewById5;
        View findViewById6 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById6);
        Button button2 = (Button) findViewById6;
        seekBar.setProgress(this.scalePercent - 50);
        this.workingVariable = this.variable;
        this.workingDictionaryKeys = this.varDictionaryKeys;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.arlosoft.macrodroid.action.FontScaleAction$handleItemSelected$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(@NotNull SeekBar seekBar2, int i5, boolean z4) {
                Intrinsics.checkNotNullParameter(seekBar2, "seekBar");
                TextView textView2 = textView;
                textView2.setText((seekBar2.getProgress() + 50) + "%");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(@Nullable SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(@Nullable SeekBar seekBar2) {
            }
        });
        textView.setText(this.scalePercent + "%");
        ArrayList arrayList = new ArrayList();
        String r4 = SelectableItem.r(R.string.use_slider_value);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.use_slider_value)");
        arrayList.add(r4);
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        Macro macro = getMacro();
        MacroDroidVariable macroDroidVariable = this.variable;
        String str = null;
        if (macroDroidVariable != null) {
            if (macroDroidVariable != null) {
                str = macroDroidVariable.getName();
            }
            str = str + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys);
        }
        VariableHelper.configureNumberVarSpinner(activity2, R.style.Theme_App_Dialog_Action, this, spinner, macro, arrayList, str, "", false, new VariableHelper.VariableSelectedListener() { // from class: com.arlosoft.macrodroid.action.FontScaleAction$handleItemSelected$2
            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void customItemSelected(int i5, @NotNull String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                viewGroup.setVisibility(0);
                textView.setVisibility(0);
                this.workingVariable = null;
                this.workingDictionaryKeys = null;
            }

            @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
            public void variableSelected(@NotNull MacroDroidVariable variable, @Nullable List<String> list) {
                DictionaryKeys dictionaryKeys;
                Intrinsics.checkNotNullParameter(variable, "variable");
                viewGroup.setVisibility(8);
                textView.setVisibility(8);
                this.workingVariable = variable;
                FontScaleAction fontScaleAction = this;
                if (list != null) {
                    dictionaryKeys = new DictionaryKeys(list);
                } else {
                    dictionaryKeys = null;
                }
                fontScaleAction.workingDictionaryKeys = dictionaryKeys;
            }
        });
        boolean z4 = true;
        if (this.workingVariable == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i5 = 8;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        viewGroup.setVisibility(i4);
        if (this.workingVariable != null) {
            z4 = false;
        }
        if (z4) {
            i5 = 0;
        }
        textView.setVisibility(i5);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.g7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FontScaleAction.O(FontScaleAction.this, seekBar, appCompatDialog, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.h7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FontScaleAction.P(AppCompatDialog.this, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        float max;
        MacroDroidVariable macroDroidVariable = this.variable;
        String str = null;
        if (macroDroidVariable == null) {
            max = this.scalePercent;
        } else {
            Intrinsics.checkNotNull(macroDroidVariable);
            MacroDroidVariable variableByName = getVariableByName(macroDroidVariable.getName());
            if (variableByName != null) {
                Long longValue = variableByName.getLongValue(this.varDictionaryKeys);
                if (longValue != null) {
                    float longValue2 = (float) longValue.longValue();
                    if (longValue2 < 50.0f) {
                        Long macroGuid = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logWarning("Variable value below minimum, pinning font scale to 50%", macroGuid.longValue());
                    }
                    if (longValue2 > 150.0f) {
                        Long macroGuid2 = getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                        SystemLog.logWarning("Variable value above maximum, pinning font scale to 150%", macroGuid2.longValue());
                    }
                    max = Math.max(50.0f, Math.min(150.0f, longValue2));
                } else {
                    MacroDroidVariable macroDroidVariable2 = this.variable;
                    if (macroDroidVariable2 != null) {
                        str = macroDroidVariable2.getName();
                    }
                    Long macroGuid3 = getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid3, "macroGuid");
                    SystemLog.logError("Could not set font_scale, variable does not exist: " + str + VariableHelper.getFormattedDictionaryKeys(this.varDictionaryKeys), macroGuid3.longValue());
                    return;
                }
            } else {
                MacroDroidVariable macroDroidVariable3 = this.variable;
                if (macroDroidVariable3 != null) {
                    str = macroDroidVariable3.getName();
                }
                Long macroGuid4 = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid4, "macroGuid");
                SystemLog.logError("Could not set font_scale, variable does not exist: " + str, macroGuid4.longValue());
                return;
            }
        }
        float f4 = max / 100.0f;
        try {
            Settings.System.putFloat(getContext().getContentResolver(), "font_scale", f4 - 0.001f);
        } catch (Exception e4) {
            Long macroGuid5 = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid5, "macroGuid");
            SystemLog.logError("Could not set font_scale: " + e4, macroGuid5.longValue());
        }
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new a(f4, null), 3, null);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresWriteSettings() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasDictionaryKeys
    public void setDictionaryKeys(@Nullable DictionaryKeys dictionaryKeys) {
        this.varDictionaryKeys = dictionaryKeys;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.scalePercent);
        out.writeParcelable(this.variable, i4);
        out.writeParcelable(this.varDictionaryKeys, i4);
    }

    public FontScaleAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FontScaleAction() {
        this.scalePercent = 100;
    }

    private FontScaleAction(Parcel parcel) {
        super(parcel);
        this.scalePercent = 100;
        this.scalePercent = parcel.readInt();
        this.variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: FontScaleAction.kt */
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
