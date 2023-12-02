package com.arlosoft.macrodroid.variables;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshEditMacroPageEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.variables.VariableValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SetVariableReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SetVariableReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_MACRO_NAME = "com.arlosoft.macrodroid.MACRO_NAME";
    @NotNull
    public static final String EXTRA_VARIABLE_NAME = "com.arlosoft.macrodroid.VARIABLE_NAME";
    @NotNull
    public static final String EXTRA_VARIABLE_TYPE = "com.arlosoft.macrodroid.VARIABLE_TYPE";
    @NotNull
    public static final String EXTRA_VARIABLE_VALUE = "com.arlosoft.macrodroid.VARIABLE_VALUE";
    @NotNull
    public static final String TYPE_BOOLEAN = "boolean";
    @NotNull
    public static final String TYPE_DECIMAL = "decimal";
    @NotNull
    public static final String TYPE_INTEGER = "integer";
    @NotNull
    public static final String TYPE_STRING = "string";

    /* compiled from: SetVariableReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final VariableValue a(MacroDroidVariable macroDroidVariable, String str) {
        VariableValue booleanValue;
        try {
            int type = macroDroidVariable.getType();
            if (type != 0) {
                if (type != 1) {
                    if (type != 2) {
                        if (type != 3) {
                            return null;
                        }
                        booleanValue = new VariableValue.DecimalValue(Double.parseDouble(str), null, 2, null);
                    } else {
                        booleanValue = new VariableValue.StringValue(str, null, 2, null);
                    }
                } else {
                    booleanValue = new VariableValue.IntegerValue(Long.parseLong(str), null, 2, null);
                }
            } else {
                booleanValue = new VariableValue.BooleanValue(Boolean.parseBoolean(str), null, 2, null);
            }
            return booleanValue;
        } catch (Exception e4) {
            SystemLog.logError("Failed to set variable value: " + e4);
            return null;
        }
    }

    private final int b(String str) {
        switch (str.hashCode()) {
            case -891985903:
                if (str.equals("string")) {
                    return 2;
                }
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    return 0;
                }
                break;
            case 1542263633:
                if (str.equals(TYPE_DECIMAL)) {
                    return 3;
                }
                break;
            case 1958052158:
                if (str.equals("integer")) {
                    return 1;
                }
                break;
        }
        return -1;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(EXTRA_VARIABLE_NAME);
        String stringExtra2 = intent.getStringExtra(EXTRA_VARIABLE_VALUE);
        String stringExtra3 = intent.getStringExtra(EXTRA_VARIABLE_TYPE);
        String stringExtra4 = intent.getStringExtra("com.arlosoft.macrodroid.MACRO_NAME");
        SystemLog.logInfo("Set variable by intent: " + stringExtra + " = " + stringExtra2 + ", type: " + stringExtra3 + ", macro: " + stringExtra4);
        if (stringExtra != null && stringExtra2 != null && stringExtra3 != null) {
            int b4 = b(stringExtra3);
            if (b4 == -1) {
                SystemLog.logError("Invalid variable type: " + stringExtra3);
                return;
            } else if (stringExtra4 != null) {
                Macro macroByName = MacroStore.getInstance().getMacroByName(stringExtra4);
                if (macroByName != null) {
                    MacroDroidVariable localVariableByName = macroByName.getLocalVariableByName(stringExtra);
                    if (localVariableByName != null) {
                        if (localVariableByName.getType() != b4) {
                            SystemLog.logError("Attempted to set variable: " + stringExtra + " with type: " + stringExtra3 + " but it already exists with a different type");
                            return;
                        }
                        VariableValue a4 = a(localVariableByName, stringExtra2);
                        if (a4 != null) {
                            macroByName.variableUpdate(localVariableByName, a4);
                            return;
                        }
                        return;
                    }
                    MacroDroidVariable macroDroidVariable = new MacroDroidVariable(b4, stringExtra, false);
                    VariableValue a5 = a(macroDroidVariable, stringExtra2);
                    if (a5 != null) {
                        macroDroidVariable.setVariableValue(a5, true, null, null);
                        macroByName.getLocalVariables().add(macroDroidVariable);
                        MacroStore.getInstance().persistMacro(macroByName);
                        EventBusUtils.getEventBus().post(new RefreshEditMacroPageEvent());
                        return;
                    }
                    return;
                }
                SystemLog.logError("Attempted to set variable for macro: " + stringExtra4 + " which does not exist");
                return;
            } else {
                MacroDroidVariable variableByName = MacroDroidVariableStore.getInstance().getVariableByName(stringExtra);
                if (variableByName != null) {
                    if (variableByName.getType() != b4) {
                        SystemLog.logError("Attempted to set variable: " + stringExtra + " with type: " + stringExtra3 + " but it already exists with a different type");
                        return;
                    }
                    VariableValue a6 = a(variableByName, stringExtra2);
                    if (a6 != null) {
                        MacroDroidVariableStore.getInstance().variableUpdate(variableByName, a6, true, null);
                        return;
                    }
                    return;
                }
                MacroDroidVariable macroDroidVariable2 = new MacroDroidVariable(b4, stringExtra, false);
                VariableValue a7 = a(macroDroidVariable2, stringExtra2);
                if (a7 != null) {
                    macroDroidVariable2.setVariableValue(a7, true, null, null);
                    MacroDroidVariableStore.getInstance().addVariable(macroDroidVariable2);
                    return;
                }
                return;
            }
        }
        SystemLog.logError("Invalid intent to set variable");
    }
}
