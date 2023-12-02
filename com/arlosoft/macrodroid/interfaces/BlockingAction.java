package com.arlosoft.macrodroid.interfaces;

import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Stack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BlockingAction.kt */
/* loaded from: classes3.dex */
public interface BlockingAction {

    /* compiled from: BlockingAction.kt */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void invokeAction$default(BlockingAction blockingAction, TriggerContextInfo triggerContextInfo, int i4, boolean z3, Stack stack, ResumeMacroInfo resumeMacroInfo, boolean z4, int i5, Object obj) {
            boolean z5;
            if (obj == null) {
                if ((i5 & 32) != 0) {
                    z5 = false;
                } else {
                    z5 = z4;
                }
                blockingAction.invokeAction(triggerContextInfo, i4, z3, stack, resumeMacroInfo, z5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeAction");
        }
    }

    void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> stack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4);
}
