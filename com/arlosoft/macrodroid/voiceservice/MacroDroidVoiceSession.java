package com.arlosoft.macrodroid.voiceservice;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.HomeButtonLongPressTrigger;
import com.arlosoft.macrodroid.triggers.PowerButtonLongPressTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidVoiceSession.kt */
@StabilityInferred(parameters = 0)
@RequiresApi(23)
/* loaded from: classes3.dex */
public final class MacroDroidVoiceSession extends VoiceInteractionSession {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MacroDroidVoiceSession(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.service.voice.VoiceInteractionSession
    public void onHandleAssist(@Nullable Bundle bundle, @Nullable AssistStructure assistStructure, @Nullable AssistContent assistContent) {
        super.onHandleAssist(bundle, assistStructure, assistContent);
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof HomeButtonLongPressTrigger) || (next instanceof PowerButtonLongPressTrigger)) {
                        if (next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
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
    }

    @Override // android.service.voice.VoiceInteractionSession
    public void onPrepareShow(@Nullable Bundle bundle, int i4) {
        super.onPrepareShow(bundle, i4);
        if (bundle == null) {
            SystemLog.logError("Voice session failed - the bundle was null");
            return;
        }
        try {
            String string = bundle.getString("ACTION");
            if (string == null) {
                string = "";
            }
            if (Intrinsics.areEqual(string, "android.settings.VOICE_CONTROL_AIRPLANE_MODE")) {
                Intent intent = new Intent("android.settings.VOICE_CONTROL_AIRPLANE_MODE");
                intent.putExtra("airplane_mode_enabled", bundle.getBoolean("airplane_mode_enabled"));
                startVoiceActivity(intent);
            }
            if (Intrinsics.areEqual(string, "android.settings.VOICE_CONTROL_DO_NOT_DISTURB_MODE")) {
                Intent intent2 = new Intent("android.settings.VOICE_CONTROL_DO_NOT_DISTURB_MODE");
                intent2.putExtra("android.settings.extra.do_not_disturb_mode_enabled", bundle.getBoolean("android.settings.extra.do_not_disturb_mode_enabled"));
                intent2.putExtra("android.settings.extra.do_not_disturb_mode_minutes", bundle.getInt("android.settings.extra.do_not_disturb_mode_minutes"));
                startVoiceActivity(intent2);
            }
            if (Intrinsics.areEqual(string, "android.settings.VOICE_CONTROL_BATTERY_SAVER_MODE")) {
                Intent intent3 = new Intent("android.settings.VOICE_CONTROL_BATTERY_SAVER_MODE");
                intent3.putExtra("android.settings.extra.battery_saver_mode_enabled", bundle.getBoolean("android.settings.extra.battery_saver_mode_enabled"));
                startVoiceActivity(intent3);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                setUiEnabled(false);
            }
        } catch (Exception e4) {
            SystemLog.logError("Command failed: " + e4);
        }
    }
}
