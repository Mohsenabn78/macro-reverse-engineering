package com.arlosoft.macrodroid.action.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes2.dex */
public class MessageDialogActivity extends NonAppActivity {
    public static final String MESSAGE_EXTRA = "Message";
    public static final String PREVENT_BACK_BUTTON_EXTRA = "PreventBackButton";
    public static final String RESOURCE_ID = "ResourceId";
    public static final String RESOURCE_NAME = "ResourceName";
    public static final String SUBJECT_EXTRA = "Subject";
    public static final String USE_HTML = "UseHtml";

    /* renamed from: d  reason: collision with root package name */
    private boolean f2862d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends OnBackPressedCallback {
        a(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (!MessageDialogActivity.this.f2862d) {
                MessageDialogActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(boolean z3, TriggerContextInfo triggerContextInfo, Macro macro, boolean z4, Trigger trigger, int i4, boolean z5, Stack stack, ResumeMacroInfo resumeMacroInfo, View view) {
        finish();
        if (z3 && triggerContextInfo != null && macro != null && !z4) {
            macro.setTriggerThatInvoked(trigger);
            macro.invokeActions(macro.getActions(), i4, triggerContextInfo, z5, stack, resumeMacroInfo);
        }
    }

    private void k(Intent intent) {
        Stack<Integer> stack;
        if (intent.getExtras() != null) {
            this.f2862d = intent.getExtras().getBoolean("PreventBackButton");
            final boolean z3 = intent.getExtras().getBoolean(Constants.EXTRA_IS_TEST);
            final boolean z4 = intent.getExtras().getBoolean(Constants.EXTRA_BLOCK_NEXT_ACTION);
            boolean booleanExtra = intent.getBooleanExtra(USE_HTML, true);
            final int i4 = intent.getExtras().getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
            if (intent.hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
                stack = Util.deserializeStack((ArrayList) intent.getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX));
            } else {
                stack = new Stack<>();
            }
            final Stack<Integer> stack2 = stack;
            final TriggerContextInfo triggerContextInfo = (TriggerContextInfo) intent.getExtras().getParcelable(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
            final Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(intent.getExtras().getLong(Util.EXTRA_GUID));
            if (macroByGUID == null) {
                SystemLog.logError("Could not find macro in Confirm Next Actions");
                finish();
                return;
            }
            final boolean booleanExtra2 = intent.getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
            final Trigger trigger = (Trigger) intent.getExtras().getParcelable(Constants.EXTRA_TRIGGER_THAT_INVOKED);
            final ResumeMacroInfo resumeMacroInfo = (ResumeMacroInfo) intent.getExtras().getParcelable(Constants.EXTRA_RESUME_MACRO_INFO);
            ((Button) findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageDialogActivity.this.j(z4, triggerContextInfo, macroByGUID, z3, trigger, i4, booleanExtra2, stack2, resumeMacroInfo, view);
                }
            });
            if (!z4 && !z3) {
                macroByGUID.setTriggerThatInvoked(trigger);
                macroByGUID.invokeActions(macroByGUID.getActions(), i4, triggerContextInfo, booleanExtra2, stack2, resumeMacroInfo);
            }
            getOnBackPressedDispatcher().addCallback(this, new a(true));
            String string = intent.getExtras().getString("Subject");
            String string2 = intent.getExtras().getString("Message");
            TextView textView = (TextView) findViewById(R.id.message_dialog_message);
            setTitle(string);
            if (booleanExtra) {
                textView.setText(Html.fromHtml(string2));
            } else {
                textView.setText(string2);
            }
            Linkify.addLinks(textView, 1);
            setFinishOnTouchOutside(false);
            return;
        }
        finish();
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.message_dialog);
        if (!getResources().getBoolean(R.bool.is_tablet)) {
            getWindow().setLayout(-1, -2);
        }
        getWindow().addFlags(524288);
        k(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
    }
}
