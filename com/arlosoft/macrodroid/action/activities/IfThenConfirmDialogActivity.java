package com.arlosoft.macrodroid.action.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.activities.IfThenConfirmDialogActivity;
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
import com.arlosoft.macrodroid.utils.MacroListUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IfThenConfirmDialogActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class IfThenConfirmDialogActivity extends NonAppActivity {
    @NotNull
    public static final String EXTRA_QUIT_ON_BACK_PRESSED = "quit_on_back_pressed";
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Trigger f2827d;

    /* renamed from: e  reason: collision with root package name */
    private Macro f2828e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2829f;

    /* renamed from: g  reason: collision with root package name */
    private int f2830g;

    /* renamed from: h  reason: collision with root package name */
    private Stack<Integer> f2831h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2832i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ResumeMacroInfo f2833j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private TriggerContextInfo f2834k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2835l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2836m = true;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2837n;

    /* renamed from: o  reason: collision with root package name */
    private int f2838o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private Timer f2839p;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: IfThenConfirmDialogActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IfThenConfirmDialogActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends TimerTask {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final IfThenConfirmDialogActivity f2840a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f2841b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f2842c;

        /* renamed from: d  reason: collision with root package name */
        private final long f2843d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2844e;

        public a(@NotNull IfThenConfirmDialogActivity activity, @NotNull String negativeText) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(negativeText, "negativeText");
            this.f2840a = activity;
            this.f2841b = negativeText;
            this.f2842c = (TextView) activity.findViewById(R.id.cancelButton);
            this.f2843d = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(a this$0, long j4) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TextView textView = this$0.f2842c;
            String str = this$0.f2841b;
            textView.setText(str + " (" + (this$0.f2840a.f2838o - j4) + ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Timer timer = this$0.f2840a.f2839p;
            if (timer != null) {
                timer.cancel();
            }
            this$0.f2840a.finish();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final long currentTimeMillis = (System.currentTimeMillis() - this.f2843d) / 1000;
            this.f2840a.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.j
                @Override // java.lang.Runnable
                public final void run() {
                    IfThenConfirmDialogActivity.a.c(IfThenConfirmDialogActivity.a.this, currentTimeMillis);
                }
            });
            if (currentTimeMillis >= this.f2840a.f2838o && !this.f2844e) {
                this.f2844e = true;
                this.f2840a.f2836m = false;
                this.f2840a.j();
                this.f2840a.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        IfThenConfirmDialogActivity.a.d(IfThenConfirmDialogActivity.a.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        boolean z3;
        int i4;
        int i5;
        Macro macro;
        Stack<Integer> stack;
        Macro macro2 = this.f2828e;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro2 = null;
        }
        macro2.setTriggerThatInvoked(this.f2827d);
        Macro macro3 = this.f2828e;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro3 = null;
        }
        ArrayList<Action> actions = macro3.getActions();
        int i6 = this.f2830g - 1;
        Stack<Integer> stack2 = this.f2831h;
        if (stack2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
            stack2 = null;
        }
        boolean z4 = false;
        stack2.push(0);
        int endIfIndex = MacroListUtils.getEndIfIndex(actions, i6);
        int nextElseIfIndex = MacroListUtils.getNextElseIfIndex(actions, i6);
        int elseIndex = MacroListUtils.getElseIndex(actions, i6);
        if (nextElseIfIndex >= 0 && nextElseIfIndex < endIfIndex) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i5 = nextElseIfIndex;
        } else {
            if (elseIndex >= 0 && elseIndex < endIfIndex) {
                z4 = true;
            }
            if (z4) {
                i4 = elseIndex + 1;
                Stack<Integer> stack3 = this.f2831h;
                if (stack3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                    stack3 = null;
                }
                if (!stack3.isEmpty()) {
                    Stack<Integer> stack4 = this.f2831h;
                    if (stack4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                        stack4 = null;
                    }
                    stack4.pop();
                }
            } else {
                i4 = endIfIndex + 1;
            }
            i5 = i4;
        }
        if (i5 == -1) {
            FirebaseCrashlytics.getInstance().recordException(new Exception("No corresponding end if or else for an if"));
        }
        if (nextElseIfIndex == -1 && elseIndex == -1) {
            Stack<Integer> stack5 = this.f2831h;
            if (stack5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack5 = null;
            }
            if (!stack5.isEmpty()) {
                Stack<Integer> stack6 = this.f2831h;
                if (stack6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                    stack6 = null;
                }
                Integer peek = stack6.peek();
                if (peek != null && peek.intValue() == 0) {
                    Stack<Integer> stack7 = this.f2831h;
                    if (stack7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                        stack7 = null;
                    }
                    stack7.pop();
                }
            }
        }
        if (!this.f2832i) {
            Macro macro4 = this.f2828e;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            } else {
                macro = macro4;
            }
            Macro macro5 = this.f2828e;
            if (macro5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro5 = null;
            }
            ArrayList<Action> actions2 = macro5.getActions();
            TriggerContextInfo triggerContextInfo = this.f2834k;
            boolean z5 = this.f2829f;
            Stack<Integer> stack8 = this.f2831h;
            if (stack8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack = null;
            } else {
                stack = stack8;
            }
            macro.invokeActions(actions2, i5, triggerContextInfo, z5, stack, this.f2833j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(IfThenConfirmDialogActivity this$0, View view) {
        Macro macro;
        Stack<Integer> stack;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timer timer = this$0.f2839p;
        if (timer != null) {
            timer.cancel();
        }
        this$0.f2836m = false;
        Stack<Integer> stack2 = this$0.f2831h;
        if (stack2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
            stack2 = null;
        }
        if (!stack2.isEmpty()) {
            Stack<Integer> stack3 = this$0.f2831h;
            if (stack3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack3 = null;
            }
            Integer peek = stack3.peek();
            if (peek != null && peek.intValue() == 0) {
                Stack<Integer> stack4 = this$0.f2831h;
                if (stack4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                    stack4 = null;
                }
                stack4.pop();
            }
        }
        Macro macro2 = this$0.f2828e;
        if (macro2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro2 = null;
        }
        int endIfIndex = MacroListUtils.getEndIfIndex(macro2.getActions(), this$0.f2830g - 1);
        Stack<Integer> stack5 = this$0.f2831h;
        if (stack5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
            stack5 = null;
        }
        stack5.push(Integer.valueOf(endIfIndex));
        this$0.finish();
        if (!this$0.f2832i) {
            Macro macro3 = this$0.f2828e;
            if (macro3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro3 = null;
            }
            macro3.setTriggerThatInvoked(this$0.f2827d);
            Macro macro4 = this$0.f2828e;
            if (macro4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro = null;
            } else {
                macro = macro4;
            }
            Macro macro5 = this$0.f2828e;
            if (macro5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("macro");
                macro5 = null;
            }
            ArrayList<Action> actions = macro5.getActions();
            int i4 = this$0.f2830g;
            TriggerContextInfo triggerContextInfo = this$0.f2834k;
            boolean z3 = this$0.f2829f;
            Stack<Integer> stack6 = this$0.f2831h;
            if (stack6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack = null;
            } else {
                stack = stack6;
            }
            macro.invokeActions(actions, i4, triggerContextInfo, z3, stack, this$0.f2833j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(IfThenConfirmDialogActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timer timer = this$0.f2839p;
        if (timer != null) {
            timer.cancel();
        }
        this$0.f2836m = false;
        this$0.finish();
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z3;
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        Stack<Integer> stack;
        super.onCreate(bundle);
        setContentView(R.layout.confirm_dialog);
        getWindow().setLayout(-1, -2);
        setFinishOnTouchOutside(false);
        Bundle extras = getIntent().getExtras();
        ResumeMacroInfo resumeMacroInfo = null;
        if (extras != null) {
            str = extras.getString("Title");
        } else {
            str = null;
        }
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            str2 = extras2.getString("Message");
        } else {
            str2 = null;
        }
        Bundle extras3 = getIntent().getExtras();
        if (extras3 != null) {
            str3 = extras3.getString(Constants.POSITIVE_TEXT_EXTRA);
        } else {
            str3 = null;
        }
        Bundle extras4 = getIntent().getExtras();
        if (extras4 != null) {
            str4 = extras4.getString(Constants.NEGATIVE_TEXT_EXTRA);
        } else {
            str4 = null;
        }
        Intrinsics.checkNotNull(str4);
        Bundle extras5 = getIntent().getExtras();
        if (extras5 != null) {
            resumeMacroInfo = (ResumeMacroInfo) extras5.getParcelable(Constants.EXTRA_RESUME_MACRO_INFO);
        }
        this.f2833j = resumeMacroInfo;
        Bundle extras6 = getIntent().getExtras();
        if (extras6 != null) {
            z3 = extras6.getBoolean(Constants.EXTRA_IS_TEST);
        } else {
            z3 = false;
        }
        this.f2832i = z3;
        Bundle extras7 = getIntent().getExtras();
        if (extras7 != null) {
            z4 = extras7.getBoolean(EXTRA_QUIT_ON_BACK_PRESSED, false);
        } else {
            z4 = false;
        }
        this.f2835l = z4;
        Bundle extras8 = getIntent().getExtras();
        if (extras8 != null) {
            z5 = extras8.getBoolean(ConfirmNextHelperKt.EXTRA_CANCEL_AFTER_TIMEOUT);
        } else {
            z5 = false;
        }
        this.f2837n = z5;
        Bundle extras9 = getIntent().getExtras();
        if (extras9 != null) {
            i4 = extras9.getInt(ConfirmNextHelperKt.EXTRA_TIMEOUT_SECONDS);
        } else {
            i4 = 0;
        }
        this.f2838o = i4;
        View findViewById = findViewById(R.id.confirmDialogMessage);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById2);
        Button button = (Button) findViewById2;
        View findViewById3 = findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById3);
        Button button2 = (Button) findViewById3;
        setTitle(str);
        ((TextView) findViewById).setText(str2);
        Bundle extras10 = getIntent().getExtras();
        if (extras10 != null) {
            i5 = extras10.getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
        } else {
            i5 = 0;
        }
        this.f2830g = i5;
        if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            Serializable serializableExtra = getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX);
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>");
            stack = Util.deserializeStack((ArrayList) serializableExtra);
            Intrinsics.checkNotNullExpressionValue(stack, "{\n            Util.deser…ArrayList<Int>)\n        }");
        } else {
            stack = new Stack<>();
        }
        this.f2831h = stack;
        Bundle extras11 = getIntent().getExtras();
        Intrinsics.checkNotNull(extras11);
        this.f2834k = (TriggerContextInfo) extras11.getParcelable(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(extras11.getLong(Util.EXTRA_GUID));
        if (macroByGUID != null && this.f2834k != null) {
            this.f2828e = macroByGUID;
            this.f2829f = getIntent().getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
            this.f2827d = (Trigger) extras11.getParcelable(Constants.EXTRA_TRIGGER_THAT_INVOKED);
            button.setText(str3);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IfThenConfirmDialogActivity.k(IfThenConfirmDialogActivity.this, view);
                }
            });
            button2.setText(str4);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IfThenConfirmDialogActivity.l(IfThenConfirmDialogActivity.this, view);
                }
            });
            if (this.f2837n) {
                Timer timer = new Timer();
                this.f2839p = timer;
                timer.scheduleAtFixedRate(new a(this, str4), 0L, 1000L);
                return;
            }
            return;
        }
        this.f2836m = false;
        SystemLog.logError("Could not find macro/context info in Confirm Next Actions");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Timer timer = this.f2839p;
        if (timer != null) {
            timer.cancel();
        }
        if (!this.f2835l && this.f2836m) {
            j();
        }
    }
}
