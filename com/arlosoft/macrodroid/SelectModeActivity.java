package com.arlosoft.macrodroid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* loaded from: classes2.dex */
public class SelectModeActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(List list, boolean z3, TriggerContextInfo triggerContextInfo, Macro macro, boolean z4, Trigger trigger, int i4, boolean z5, Stack stack, ResumeMacroInfo resumeMacroInfo, AdapterView adapterView, View view, int i5, long j4) {
        Util.setMode(this, (String) list.get(i5));
        finish();
        if (z3 && triggerContextInfo != null && macro != null && !z4) {
            macro.setTriggerThatInvoked(trigger);
            macro.invokeActions(macro.getActions(), i4, triggerContextInfo, z5, stack, resumeMacroInfo);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Stack<Integer> stack;
        super.onCreate(bundle);
        setContentView(R.layout.select_current_mode);
        setTitle(R.string.select_mode_activity_select_mode);
        ListView listView = (ListView) findViewById(R.id.select_current_mode_list);
        final boolean z3 = getIntent().getExtras().getBoolean(Constants.EXTRA_IS_TEST);
        final boolean z4 = getIntent().getExtras().getBoolean(Constants.EXTRA_BLOCK_NEXT_ACTION);
        final int i4 = getIntent().getExtras().getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
        if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            stack = Util.deserializeStack((ArrayList) getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX));
        } else {
            stack = new Stack<>();
        }
        final Stack<Integer> stack2 = stack;
        final TriggerContextInfo triggerContextInfo = (TriggerContextInfo) getIntent().getExtras().getParcelable(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        final Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getExtras().getLong(Util.EXTRA_GUID));
        if (macroByGUID == null) {
            SystemLog.logError("Could not find macro in Select Mode Actions");
            finish();
            return;
        }
        final boolean booleanExtra = getIntent().getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
        final Trigger trigger = (Trigger) getIntent().getExtras().getParcelable(Constants.EXTRA_TRIGGER_THAT_INVOKED);
        final ResumeMacroInfo resumeMacroInfo = (ResumeMacroInfo) getIntent().getExtras().getParcelable(Constants.EXTRA_RESUME_MACRO_INFO);
        final List<String> modeListFromString = Util.getModeListFromString(Settings.getModeList(this));
        listView.setAdapter((ListAdapter) new ArrayAdapter(this, 17367043, modeListFromString));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.arlosoft.macrodroid.i0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i5, long j4) {
                SelectModeActivity.this.i(modeListFromString, z4, triggerContextInfo, macroByGUID, z3, trigger, i4, booleanExtra, stack2, resumeMacroInfo, adapterView, view, i5, j4);
            }
        });
        if (!z4 && !z3) {
            macroByGUID.setTriggerThatInvoked(trigger);
            macroByGUID.invokeActions(macroByGUID.getActions(), i4, triggerContextInfo, booleanExtra, stack2, resumeMacroInfo);
        }
    }
}
