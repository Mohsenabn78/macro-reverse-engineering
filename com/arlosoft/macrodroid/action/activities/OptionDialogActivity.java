package com.arlosoft.macrodroid.action.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.activities.OptionDialogActivity;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NonAppActivityWithPreventClash;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.InvokedByOptionDialogTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public class OptionDialogActivity extends NonAppActivityWithPreventClash {
    public static final String ACTION_BLOCK_DATA_EXTRA = "ActionBlockData";
    public static final String BUTTON_NAMES_EXTRA = "ButtonNames";
    public static final String DEFAULT_BUTTON_EXTRA = "DefaultButton";
    public static final String DEFAULT_TIMEOUT_EXTRA = "DefaultTimeout";
    public static final String MACRO_IDS_EXTRA = "MacroIds";
    public static final String PREVENT_BACK_BUTTON_EXTRA = "PreventBackButton";
    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.button_2)
    Button button2;
    @BindView(R.id.button_3)
    Button button3;

    /* renamed from: e  reason: collision with root package name */
    private long f2864e;

    /* renamed from: f  reason: collision with root package name */
    private int f2865f;

    /* renamed from: g  reason: collision with root package name */
    private int f2866g;

    /* renamed from: h  reason: collision with root package name */
    private Timer f2867h;

    /* renamed from: i  reason: collision with root package name */
    private long[] f2868i;

    /* renamed from: j  reason: collision with root package name */
    private ActionBlockData[] f2869j;

    /* renamed from: k  reason: collision with root package name */
    private TriggerContextInfo f2870k;

    /* renamed from: l  reason: collision with root package name */
    private String f2871l;

    /* renamed from: m  reason: collision with root package name */
    private String f2872m;
    @BindView(R.id.option_dialog_message)
    TextView messageView;

    /* renamed from: n  reason: collision with root package name */
    private String f2873n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2874o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f2875p;

    /* renamed from: q  reason: collision with root package name */
    private Macro f2876q;

    /* renamed from: r  reason: collision with root package name */
    private int f2877r;

    /* renamed from: s  reason: collision with root package name */
    private Stack<Integer> f2878s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2879t;

    /* renamed from: u  reason: collision with root package name */
    private Trigger f2880u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2881v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private ResumeMacroInfo f2882w;

    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2883a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2884b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f2885c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long[] f2886d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ActionBlockData[] f2887e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String[] f2888f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f2889g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ int f2890h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ TriggerContextInfo f2891i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ long f2892j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ Trigger f2893k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ int f2894l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ Stack f2895m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ boolean f2896n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ boolean f2897o;

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ ResumeMacroInfo f2898p;

        /* renamed from: q  reason: collision with root package name */
        final /* synthetic */ boolean f2899q;

        /* renamed from: r  reason: collision with root package name */
        final /* synthetic */ boolean f2900r;

        a(Context context, String str, String str2, long[] jArr, ActionBlockData[] actionBlockDataArr, String[] strArr, int i4, int i5, TriggerContextInfo triggerContextInfo, long j4, Trigger trigger, int i6, Stack stack, boolean z3, boolean z4, ResumeMacroInfo resumeMacroInfo, boolean z5, boolean z6) {
            this.f2883a = context;
            this.f2884b = str;
            this.f2885c = str2;
            this.f2886d = jArr;
            this.f2887e = actionBlockDataArr;
            this.f2888f = strArr;
            this.f2889g = i4;
            this.f2890h = i5;
            this.f2891i = triggerContextInfo;
            this.f2892j = j4;
            this.f2893k = trigger;
            this.f2894l = i6;
            this.f2895m = stack;
            this.f2896n = z3;
            this.f2897o = z4;
            this.f2898p = resumeMacroInfo;
            this.f2899q = z5;
            this.f2900r = z6;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f2883a, OptionDialogActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("Title", this.f2884b);
                intent.putExtra("Message", this.f2885c);
                intent.putExtra(OptionDialogActivity.MACRO_IDS_EXTRA, this.f2886d);
                intent.putExtra(OptionDialogActivity.ACTION_BLOCK_DATA_EXTRA, this.f2887e);
                intent.putExtra(OptionDialogActivity.BUTTON_NAMES_EXTRA, this.f2888f);
                intent.putExtra(OptionDialogActivity.DEFAULT_BUTTON_EXTRA, this.f2889g);
                intent.putExtra(OptionDialogActivity.DEFAULT_TIMEOUT_EXTRA, this.f2890h);
                intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, this.f2891i);
                intent.putExtra(Util.EXTRA_GUID, this.f2892j);
                intent.putExtra(Constants.EXTRA_TRIGGER_THAT_INVOKED, this.f2893k);
                intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, this.f2894l);
                intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, this.f2895m);
                intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, this.f2896n);
                intent.putExtra(Constants.EXTRA_IS_TEST, this.f2897o);
                intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, this.f2898p);
                intent.putExtra(Constants.EXTRA_BLOCK_NEXT_ACTION, this.f2899q);
                intent.putExtra("PreventBackButton", this.f2900r);
                this.f2883a.startActivity(intent);
            } catch (Exception unused) {
                SystemLog.logError("Failed to display option dialog");
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends OnBackPressedCallback {
        b(boolean z3) {
            super(z3);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (!OptionDialogActivity.this.f2881v) {
                OptionDialogActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        finish();
        long j4 = this.f2868i[1];
        if (j4 != 2) {
            if (j4 == 1) {
                y();
            } else {
                C(this.f2876q, j4, this.f2869j[1], this.f2870k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view) {
        finish();
        long j4 = this.f2868i[2];
        if (j4 != 2) {
            if (j4 == 1) {
                y();
            } else {
                C(this.f2876q, j4, this.f2869j[2], this.f2870k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Macro macro, long j4, ActionBlockData actionBlockData, TriggerContextInfo triggerContextInfo) {
        ActionBlock actionBlock;
        ResumeMacroInfo resumeMacroInfo;
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(j4);
        if (macroByGUID != null && macroByGUID.canInvoke(triggerContextInfo)) {
            if (macroByGUID.isActionBlock) {
                ActionBlock cloneActionBlock = ((ActionBlock) macroByGUID).cloneActionBlock(false, true);
                cloneActionBlock.setIsClonedInstance(true);
                getActionBlockStore().addActionBlock(cloneActionBlock);
                if (this.f2875p && !this.f2874o) {
                    resumeMacroInfo = new ResumeMacroInfo(macro.getGUID(), this.f2877r, triggerContextInfo, true, this.f2878s, this.f2882w, actionBlockData.getOutputVarsMap());
                } else {
                    resumeMacroInfo = null;
                }
                SystemLog.logInfo("Running action block: " + actionBlock.getName(), this.f2876q.getGUID());
                cloneActionBlock.invokeActions(triggerContextInfo, true, resumeMacroInfo, (Map<String, String>) actionBlockData.getInputVarsMap(), Collections.emptyMap(), macro);
                return;
            }
            SystemLog.logInfo("Running macro: " + this.f2876q.getName(), this.f2876q.getGUID());
            macroByGUID.setTriggerThatInvoked(InvokedByOptionDialogTrigger.getInstance());
            macroByGUID.invokeActions(triggerContextInfo);
            y();
        }
    }

    private ActionBlockStore getActionBlockStore() {
        return MacroStore.getInstance();
    }

    public static void showOptionDialog(Context context, String str, String str2, long[] jArr, ActionBlockData[] actionBlockDataArr, String[] strArr, int i4, int i5, @Nullable TriggerContextInfo triggerContextInfo, long j4, Trigger trigger, int i6, Stack<Integer> stack, boolean z3, boolean z4, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z5, boolean z6) {
        new Handler().postDelayed(new a(context, str, str2, jArr, actionBlockDataArr, strArr, i4, i5, triggerContextInfo, j4, trigger, i6, stack, z3, z4, resumeMacroInfo, z5, z6), NonAppActivityWithPreventClash.getDelayUntilNextDisplay());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Macro macro;
        if (this.f2875p && this.f2870k != null && (macro = this.f2876q) != null && !this.f2874o) {
            macro.setTriggerThatInvoked(this.f2880u);
            Macro macro2 = this.f2876q;
            macro2.invokeActions(macro2.getActions(), this.f2877r, this.f2870k, this.f2879t, this.f2878s, this.f2882w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(View view) {
        finish();
        long j4 = this.f2868i[0];
        if (j4 == 2) {
            this.f2876q.terminateMacro();
        } else if (j4 == 1) {
            y();
        } else {
            C(this.f2876q, j4, this.f2869j[0], this.f2870k);
        }
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(524288);
        getWindow().addFlags(4194304);
        setContentView(R.layout.option_dialog);
        getWindow().setLayout(-1, -2);
        ButterKnife.bind(this);
        setFinishOnTouchOutside(false);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.f2874o = getIntent().getExtras().getBoolean(Constants.EXTRA_IS_TEST);
            this.f2875p = getIntent().getExtras().getBoolean(Constants.EXTRA_BLOCK_NEXT_ACTION);
            this.f2881v = getIntent().getBooleanExtra("PreventBackButton", false);
            this.f2877r = getIntent().getExtras().getInt(Constants.EXTRA_NEXT_ACTION_INDEX);
            this.f2879t = getIntent().getBooleanExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, false);
            this.f2880u = (Trigger) getIntent().getExtras().getParcelable(Constants.EXTRA_TRIGGER_THAT_INVOKED);
            if (getIntent().hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
                this.f2878s = Util.deserializeStack((ArrayList) getIntent().getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX));
            } else {
                this.f2878s = new Stack<>();
            }
            Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(getIntent().getExtras().getLong(Util.EXTRA_GUID));
            this.f2876q = macroByGUID;
            if (macroByGUID == null) {
                SystemLog.logError("Could not find macro in Confirm Next Actions");
                finish();
                return;
            }
            String string = getIntent().getExtras().getString("Title");
            String string2 = getIntent().getExtras().getString("Message");
            this.f2868i = getIntent().getExtras().getLongArray(MACRO_IDS_EXTRA);
            Parcelable[] parcelableArray = getIntent().getExtras().getParcelableArray(ACTION_BLOCK_DATA_EXTRA);
            this.f2869j = new ActionBlockData[parcelableArray.length];
            for (int i4 = 0; i4 < parcelableArray.length; i4++) {
                this.f2869j[i4] = (ActionBlockData) parcelableArray[i4];
            }
            String[] stringArray = getIntent().getExtras().getStringArray(BUTTON_NAMES_EXTRA);
            this.f2870k = (TriggerContextInfo) getIntent().getExtras().getParcelable(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
            this.f2865f = getIntent().getIntExtra(DEFAULT_BUTTON_EXTRA, -1);
            this.f2866g = getIntent().getIntExtra(DEFAULT_TIMEOUT_EXTRA, -1);
            this.f2882w = (ResumeMacroInfo) getIntent().getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO);
            setTitle(MagicText.replaceMagicText(this, string, this.f2870k, this.f2876q));
            this.f2864e = System.currentTimeMillis();
            if (!TextUtils.isEmpty(stringArray[0]) && this.f2868i[0] != 0) {
                String replaceMagicText = MagicText.replaceMagicText(this, stringArray[0], this.f2870k, this.f2876q);
                this.f2871l = replaceMagicText;
                this.button1.setText(replaceMagicText);
                this.button1.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogActivity.this.z(view);
                    }
                });
            } else {
                this.button1.setVisibility(8);
            }
            if (!TextUtils.isEmpty(stringArray[1]) && this.f2868i[1] != 0) {
                String replaceMagicText2 = MagicText.replaceMagicText(this, stringArray[1], this.f2870k, this.f2876q);
                this.f2872m = replaceMagicText2;
                this.button2.setText(replaceMagicText2);
                this.button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogActivity.this.A(view);
                    }
                });
            } else {
                this.button2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(stringArray[2]) && this.f2868i[2] != 0) {
                String replaceMagicText3 = MagicText.replaceMagicText(this, stringArray[2], this.f2870k, this.f2876q);
                this.f2873n = replaceMagicText3;
                this.button3.setText(replaceMagicText3);
                this.button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.activities.x
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OptionDialogActivity.this.B(view);
                    }
                });
            } else {
                this.button3.setVisibility(8);
            }
            if (TextUtils.isEmpty(string2)) {
                this.messageView.setVisibility(8);
            } else {
                this.messageView.setText(Html.fromHtml(MagicText.replaceMagicText(this, string2, this.f2870k, this.f2876q).replace("\\n", "\n").replace("\n", "<br/>").replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "&nbsp;")));
            }
            setFinishOnTouchOutside(false);
            int i5 = this.f2865f;
            if (i5 > 0 && this.f2868i[i5 - 1] != 0 && !TextUtils.isEmpty(stringArray[i5 - 1])) {
                Timer timer = new Timer();
                this.f2867h = timer;
                timer.scheduleAtFixedRate(new c(this, null), 0L, 1000L);
            }
            if (!this.f2875p && !this.f2874o) {
                this.f2876q.setTriggerThatInvoked(this.f2880u);
                Macro macro = this.f2876q;
                macro.invokeActions(macro.getActions(), this.f2877r, this.f2870k, this.f2879t, this.f2878s, this.f2882w);
            }
            getOnBackPressedDispatcher().addCallback(this, new b(true));
            return;
        }
        SystemLog.logError("Failed to start OptionDialogActivity - extras are null");
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Timer timer = this.f2867h;
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        boolean f2902a;

        private c() {
            this.f2902a = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(long j4) {
            int i4 = OptionDialogActivity.this.f2865f;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        Button button = OptionDialogActivity.this.button3;
                        button.setText(OptionDialogActivity.this.f2873n + " (" + String.valueOf(OptionDialogActivity.this.f2866g - j4) + ")");
                        return;
                    }
                    return;
                }
                Button button2 = OptionDialogActivity.this.button2;
                button2.setText(OptionDialogActivity.this.f2872m + " (" + String.valueOf(OptionDialogActivity.this.f2866g - j4) + ")");
                return;
            }
            Button button3 = OptionDialogActivity.this.button1;
            button3.setText(OptionDialogActivity.this.f2871l + " (" + String.valueOf(OptionDialogActivity.this.f2866g - j4) + ")");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (OptionDialogActivity.this.f2867h != null) {
                OptionDialogActivity.this.f2867h.cancel();
            }
            int i4 = OptionDialogActivity.this.f2865f - 1;
            if (OptionDialogActivity.this.f2868i[i4] == 2) {
                OptionDialogActivity.this.f2876q.terminateMacro();
            } else if (OptionDialogActivity.this.f2868i[i4] == 1) {
                OptionDialogActivity.this.y();
            } else {
                OptionDialogActivity optionDialogActivity = OptionDialogActivity.this;
                optionDialogActivity.C(optionDialogActivity.f2876q, OptionDialogActivity.this.f2868i[i4], OptionDialogActivity.this.f2869j[i4], OptionDialogActivity.this.f2870k);
            }
            OptionDialogActivity.this.finish();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            final long currentTimeMillis = (System.currentTimeMillis() - OptionDialogActivity.this.f2864e) / 1000;
            OptionDialogActivity.this.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.y
                @Override // java.lang.Runnable
                public final void run() {
                    OptionDialogActivity.c.this.c(currentTimeMillis);
                }
            });
            if (currentTimeMillis >= OptionDialogActivity.this.f2866g && !this.f2902a) {
                this.f2902a = true;
                OptionDialogActivity.this.runOnUiThread(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        OptionDialogActivity.c.this.d();
                    }
                });
            }
        }

        /* synthetic */ c(OptionDialogActivity optionDialogActivity, a aVar) {
            this();
        }
    }
}
