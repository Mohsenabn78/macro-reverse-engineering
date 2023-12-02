package com.arlosoft.macrodroid.triggers.activities;

import android.os.Bundle;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.MediaButtonPressedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MediaButtonLongPressActivity extends NonAppActivity {
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof MediaButtonPressedTrigger) && ((MediaButtonPressedTrigger) next).getOption().equals(MediaButtonPressedTrigger.LONG_PRESS) && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                            break;
                        }
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Macro macro2 = (Macro) it2.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
        }
        finish();
    }
}
