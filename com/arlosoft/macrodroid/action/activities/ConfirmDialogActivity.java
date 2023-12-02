package com.arlosoft.macrodroid.action.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.ConfirmDialogActivity;
import com.arlosoft.macrodroid.action.helper.ConfirmNextHelperKt;
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
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class ConfirmDialogActivity extends NonAppActivity {

    /* renamed from: d  reason: collision with root package name */
    private Timer f2819d;

    /* renamed from: e  reason: collision with root package name */
    private Macro f2820e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {

        /* renamed from: b  reason: collision with root package name */
        private int f2822b;

        /* renamed from: d  reason: collision with root package name */
        private Button f2824d;

        /* renamed from: e  reason: collision with root package name */
        private String f2825e;

        /* renamed from: a  reason: collision with root package name */
        boolean f2821a = false;

        /* renamed from: c  reason: collision with root package name */
        private long f2823c = System.currentTimeMillis();

        public a(int i4, Button button, String str) {
            this.f2822b = 0;
            this.f2822b = i4;
            this.f2824d = button;
            this.f2825e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(long j4) {
            Button button = this.f2824d;
            button.setText(this.f2825e + " (" + String.valueOf(this.f2822b - j4) + ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            ConfirmDialogActivity.this.finish();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final long currentTimeMillis = (System.currentTimeMillis() - this.f2823c) / 1000;
            ConfirmDialogActivity.this.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.f
                @Override // java.lang.Runnable
                public final void run() {
                    ConfirmDialogActivity.a.this.c(currentTimeMillis);
                }
            });
            if (currentTimeMillis >= this.f2822b && !this.f2821a) {
                ConfirmDialogActivity.this.f2820e.terminateMacro();
                this.f2821a = true;
                ConfirmDialogActivity.this.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConfirmDialogActivity.a.this.d();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(TriggerContextInfo triggerContextInfo, boolean z3, Trigger trigger, int i4, boolean z4, Stack stack, ResumeMacroInfo resumeMacroInfo, View view) {
        Macro macro;
        finish();
        if (triggerContextInfo != null && (macro = this.f2820e) != null && !z3) {
            macro.setTriggerThatInvoked(trigger);
            Macro macro2 = this.f2820e;
            macro2.invokeActions(macro2.getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        this.f2820e.terminateMacro();
        finish();
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        Stack<Integer> stack;
        Button button;
        String str;
        super.onCreate(bundle);
        getWindow().addFlags(524288);
        getWindow().addFlags(4194304);
        setContentView(R.layout.confirm_dialog);
        getWindow().setLayout(-1, -2);
        setFinishOnTouchOutside(false);
        final boolean z3 = getIntent().getExtras().getBoolean(Constants.EXTRA_IS_TEST);
        String string = getIntent().getExtras().getString("Title");
        String string2 = getIntent().getExtras().getString("Message");
        String string3 = getIntent().getExtras().getString(Constants.POSITIVE_TEXT_EXTRA);
        String string4 = getIntent().getExtras().getString(Constants.NEGATIVE_TEXT_EXTRA);
        boolean z4 = getIntent().getExtras().getBoolean(ConfirmNextHelperKt.EXTRA_CANCEL_AFTER_TIMEOUT, false);
        int i4 = getIntent().getExtras().getInt(ConfirmNextHelperKt.EXTRA_TIMEOUT_SECONDS, 0);
        final int i5 = getIntent().getExtras().getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
        final ResumeMacroInfo resumeMacroInfo = (ResumeMacroInfo) getIntent().getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO);
        if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            stack = Util.deserializeStack((ArrayList) getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX));
        } else {
            stack = new Stack<>();
        }
        final Stack<Integer> stack2 = stack;
        final TriggerContextInfo triggerContextInfo = (TriggerContextInfo) getIntent().getExtras().getParcelable(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getExtras().getLong(Util.EXTRA_GUID));
        this.f2820e = macroByGUID;
        if (macroByGUID == null) {
            SystemLog.logError("Could not find macro in Confirm Next Actions");
            finish();
            return;
        }
        final boolean booleanExtra = getIntent().getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
        final Trigger trigger = (Trigger) getIntent().getExtras().getParcelable(Constants.EXTRA_TRIGGER_THAT_INVOKED);
        setTitle(string);
        TextView textView = (TextView) findViewById(R.id.confirmDialogMessage);
        Button button2 = (Button) findViewById(R.id.okButton);
        button2.setText(string3);
        Button button3 = (Button) findViewById(R.id.cancelButton);
        button3.setText(string4);
        if (string2 != null) {
            button = button3;
            str = string2.replace("\\n", "\n");
        } else {
            button = button3;
            str = "";
        }
        textView.setText(str);
        Button button4 = button;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmDialogActivity.this.k(triggerContextInfo, z3, trigger, i5, booleanExtra, stack2, resumeMacroInfo, view);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConfirmDialogActivity.this.l(view);
            }
        });
        setFinishOnTouchOutside(false);
        if (z4) {
            Timer timer = new Timer();
            this.f2819d = timer;
            timer.scheduleAtFixedRate(new a(i4, button4, string4), 0L, 1000L);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Timer timer = this.f2819d;
        if (timer != null) {
            timer.cancel();
        }
    }
}
