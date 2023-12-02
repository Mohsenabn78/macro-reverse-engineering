package com.arlosoft.macrodroid.quicksettings;

import android.content.ComponentName;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.QuickSettingsTileTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.Nullable;

/* compiled from: QuickSettingsLongPressActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class QuickSettingsLongPressActivity extends NonAppActivity {
    public static final int $stable = 0;

    private final int h(ComponentName componentName) {
        boolean endsWith$default;
        boolean endsWith$default2;
        boolean endsWith$default3;
        boolean endsWith$default4;
        boolean endsWith$default5;
        boolean endsWith$default6;
        boolean endsWith$default7;
        boolean endsWith$default8;
        boolean endsWith$default9;
        boolean endsWith$default10;
        boolean endsWith$default11;
        boolean endsWith$default12;
        boolean endsWith$default13;
        boolean endsWith$default14;
        boolean endsWith$default15;
        boolean endsWith$default16;
        String className = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "callingComponentName.className");
        endsWith$default = m.endsWith$default(className, "MacroDroidTileService1", false, 2, null);
        if (endsWith$default) {
            return 1;
        }
        String className2 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className2, "callingComponentName.className");
        endsWith$default2 = m.endsWith$default(className2, "MacroDroidTileService2", false, 2, null);
        if (endsWith$default2) {
            return 2;
        }
        String className3 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className3, "callingComponentName.className");
        endsWith$default3 = m.endsWith$default(className3, "MacroDroidTileService3", false, 2, null);
        if (endsWith$default3) {
            return 3;
        }
        String className4 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className4, "callingComponentName.className");
        endsWith$default4 = m.endsWith$default(className4, "MacroDroidTileService4", false, 2, null);
        if (endsWith$default4) {
            return 4;
        }
        String className5 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className5, "callingComponentName.className");
        endsWith$default5 = m.endsWith$default(className5, "MacroDroidTileService5", false, 2, null);
        if (endsWith$default5) {
            return 5;
        }
        String className6 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className6, "callingComponentName.className");
        endsWith$default6 = m.endsWith$default(className6, "MacroDroidTileService6", false, 2, null);
        if (endsWith$default6) {
            return 6;
        }
        String className7 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className7, "callingComponentName.className");
        endsWith$default7 = m.endsWith$default(className7, "MacroDroidTileService7", false, 2, null);
        if (endsWith$default7) {
            return 7;
        }
        String className8 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className8, "callingComponentName.className");
        endsWith$default8 = m.endsWith$default(className8, "MacroDroidTileService8", false, 2, null);
        if (endsWith$default8) {
            return 8;
        }
        String className9 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className9, "callingComponentName.className");
        endsWith$default9 = m.endsWith$default(className9, "MacroDroidTileService9", false, 2, null);
        if (endsWith$default9) {
            return 9;
        }
        String className10 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className10, "callingComponentName.className");
        endsWith$default10 = m.endsWith$default(className10, "MacroDroidTileService10", false, 2, null);
        if (endsWith$default10) {
            return 10;
        }
        String className11 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className11, "callingComponentName.className");
        endsWith$default11 = m.endsWith$default(className11, "MacroDroidTileService11", false, 2, null);
        if (endsWith$default11) {
            return 11;
        }
        String className12 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className12, "callingComponentName.className");
        endsWith$default12 = m.endsWith$default(className12, "MacroDroidTileService12", false, 2, null);
        if (endsWith$default12) {
            return 12;
        }
        String className13 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className13, "callingComponentName.className");
        endsWith$default13 = m.endsWith$default(className13, "MacroDroidTileService13", false, 2, null);
        if (endsWith$default13) {
            return 13;
        }
        String className14 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className14, "callingComponentName.className");
        endsWith$default14 = m.endsWith$default(className14, "MacroDroidTileService14", false, 2, null);
        if (endsWith$default14) {
            return 14;
        }
        String className15 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className15, "callingComponentName.className");
        endsWith$default15 = m.endsWith$default(className15, "MacroDroidTileService15", false, 2, null);
        if (endsWith$default15) {
            return 15;
        }
        String className16 = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className16, "callingComponentName.className");
        endsWith$default16 = m.endsWith$default(className16, "MacroDroidTileService16", false, 2, null);
        if (!endsWith$default16) {
            return 0;
        }
        return 16;
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ArrayList arrayList = new ArrayList();
        if (getIntent().getExtras() == null) {
            SystemLog.logError("Configuration of long press quick settings failed: No extras in intent");
            finish();
            return;
        }
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        Object obj = extras.get("android.intent.extra.COMPONENT_NAME");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.ComponentName");
        int h4 = h((ComponentName) obj);
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof QuickSettingsTileTrigger) {
                    QuickSettingsTileTrigger quickSettingsTileTrigger = (QuickSettingsTileTrigger) next;
                    if (quickSettingsTileTrigger.getTileNumber() == h4 && quickSettingsTileTrigger.getToggleOption() == 2 && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        finish();
    }
}
