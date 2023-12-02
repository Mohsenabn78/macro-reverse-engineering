package com.arlosoft.macrodroid.action;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.stericson.RootShell.execution.Command;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: ShellScriptAction.kt */
/* loaded from: classes2.dex */
public final class ShellScriptAction$invokeActionStandard$runnable$1$1 extends Command {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final StringBuilder f2588n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ Ref.BooleanRef f2589o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ ShellScriptAction f2590p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ boolean f2591q;

    /* renamed from: r  reason: collision with root package name */
    final /* synthetic */ int f2592r;

    /* renamed from: s  reason: collision with root package name */
    final /* synthetic */ TriggerContextInfo f2593s;

    /* renamed from: t  reason: collision with root package name */
    final /* synthetic */ boolean f2594t;

    /* renamed from: u  reason: collision with root package name */
    final /* synthetic */ Stack<Integer> f2595u;

    /* renamed from: v  reason: collision with root package name */
    final /* synthetic */ ResumeMacroInfo f2596v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellScriptAction$invokeActionStandard$runnable$1$1(Ref.BooleanRef booleanRef, ShellScriptAction shellScriptAction, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, int i5, Object[] objArr) {
        super(0, i5, (String[]) objArr);
        this.f2589o = booleanRef;
        this.f2590p = shellScriptAction;
        this.f2591q = z3;
        this.f2592r = i4;
        this.f2593s = triggerContextInfo;
        this.f2594t = z4;
        this.f2595u = stack;
        this.f2596v = resumeMacroInfo;
        this.f2588n = new StringBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ShellScriptAction this$0, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
        boolean z5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
        z5 = this$0.blockNextAction;
        if (z5 && !z3) {
            this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z4, skipEndifIndexStack, resumeMacroInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ShellScriptAction this$0, boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack skipEndifIndexStack, ResumeMacroInfo resumeMacroInfo) {
        boolean z5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "$skipEndifIndexStack");
        z5 = this$0.blockNextAction;
        if (z5 && !z3) {
            this$0.getMacro().invokeActions(this$0.getMacro().getActions(), i4, triggerContextInfo, z4, skipEndifIndexStack, resumeMacroInfo);
        }
    }

    @Override // com.stericson.RootShell.execution.Command
    public void commandCompleted(int i4, int i5) {
        MacroDroidVariable macroDroidVariable;
        MacroDroidVariable macroDroidVariable2;
        MacroDroidVariable macroDroidVariable3;
        DictionaryKeys dictionaryKeys;
        List<String> emptyList;
        super.commandCompleted(i4, i5);
        macroDroidVariable = this.f2590p.m_variableToSaveResponse;
        if (macroDroidVariable != null) {
            ShellScriptAction shellScriptAction = this.f2590p;
            macroDroidVariable2 = shellScriptAction.m_variableToSaveResponse;
            Intrinsics.checkNotNull(macroDroidVariable2);
            MacroDroidVariable variableByName = shellScriptAction.getVariableByName(macroDroidVariable2.getName());
            if (variableByName == null) {
                macroDroidVariable3 = this.f2590p.m_variableToSaveResponse;
                Intrinsics.checkNotNull(macroDroidVariable3);
                Long macroGuid = this.f2590p.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logError("Failed to save command line output to variable: " + macroDroidVariable3.getName() + " not found", macroGuid.longValue());
            } else {
                Context context = this.f2590p.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                dictionaryKeys = this.f2590p.varDictionaryKeys;
                if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList<String> applyMagicTextToDictionaryKeys = VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, this.f2593s, this.f2590p.getMacro());
                String sb = this.f2588n.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "shellOutput.toString()");
                this.f2590p.variableUpdate(variableByName, new VariableValue.StringValue(sb, applyMagicTextToDictionaryKeys));
            }
        }
        Handler handler = new Handler(Looper.getMainLooper());
        final ShellScriptAction shellScriptAction2 = this.f2590p;
        final boolean z3 = this.f2591q;
        final int i6 = this.f2592r;
        final TriggerContextInfo triggerContextInfo = this.f2593s;
        final boolean z4 = this.f2594t;
        final Stack<Integer> stack = this.f2595u;
        final ResumeMacroInfo resumeMacroInfo = this.f2596v;
        handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.tn
            @Override // java.lang.Runnable
            public final void run() {
                ShellScriptAction$invokeActionStandard$runnable$1$1.k(ShellScriptAction.this, z3, i6, triggerContextInfo, z4, stack, resumeMacroInfo);
            }
        });
    }

    @Override // com.stericson.RootShell.execution.Command
    public void commandOutput(int i4, @NotNull String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        super.commandOutput(i4, line);
        Ref.BooleanRef booleanRef = this.f2589o;
        if (!booleanRef.element) {
            this.f2588n.append("\n");
        } else {
            booleanRef.element = false;
        }
        this.f2588n.append(line);
    }

    @Override // com.stericson.RootShell.execution.Command
    public void commandTerminated(int i4, @NotNull String reason) {
        long j4;
        Intrinsics.checkNotNullParameter(reason, "reason");
        long currentTimeMillis = System.currentTimeMillis();
        j4 = this.f2590p.lastTerminateTimestamp;
        if (currentTimeMillis > j4 + 1000) {
            String str = "Shell script terminated. Reason: " + reason;
            Long macroGuid = this.f2590p.getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError(str, macroGuid.longValue());
            Handler handler = new Handler(Looper.getMainLooper());
            final ShellScriptAction shellScriptAction = this.f2590p;
            final boolean z3 = this.f2591q;
            final int i5 = this.f2592r;
            final TriggerContextInfo triggerContextInfo = this.f2593s;
            final boolean z4 = this.f2594t;
            final Stack<Integer> stack = this.f2595u;
            final ResumeMacroInfo resumeMacroInfo = this.f2596v;
            handler.post(new Runnable() { // from class: com.arlosoft.macrodroid.action.un
                @Override // java.lang.Runnable
                public final void run() {
                    ShellScriptAction$invokeActionStandard$runnable$1$1.l(ShellScriptAction.this, z3, i5, triggerContextInfo, z4, stack, resumeMacroInfo);
                }
            });
            this.f2590p.lastTerminateTimestamp = currentTimeMillis;
        }
    }

    @NotNull
    public final StringBuilder getShellOutput() {
        return this.f2588n;
    }
}
