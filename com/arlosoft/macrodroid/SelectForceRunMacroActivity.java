package com.arlosoft.macrodroid;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.InvokedByRunMacroTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class SelectForceRunMacroActivity extends AppCompatActivity {
    public static final String EXTRA_CATEGORY = "Category";
    public static final String EXTRA_HIDE_IF_OFF = "HideIfOff";
    public static final String EXTRA_IGNORE_CONSTRAINTS = "IgnoreConstraints";
    public static final String EXTRA_TITLE = "Title";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(List list, String str, boolean z3, ResumeMacroInfo resumeMacroInfo, AdapterView adapterView, View view, int i4, long j4) {
        finish();
        Macro macro = (Macro) list.get(i4);
        if (macro != null) {
            TriggerContextInfo triggerContextInfo = new TriggerContextInfo(str);
            macro.setTriggerContextInfo(triggerContextInfo);
            if (z3 || macro.canInvoke(triggerContextInfo, true)) {
                macro.setTriggerThatInvoked(InvokedByRunMacroTrigger.getInstance());
                macro.invokeActions(triggerContextInfo, true, resumeMacroInfo);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00df, code lost:
        if (r6.isEnabled() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e1, code lost:
        r5.remove();
     */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.SelectForceRunMacroActivity.onCreate(android.os.Bundle):void");
    }
}
