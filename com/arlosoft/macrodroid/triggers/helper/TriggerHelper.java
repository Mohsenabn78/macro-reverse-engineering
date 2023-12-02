package com.arlosoft.macrodroid.triggers.helper;

import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class TriggerHelper {

    /* loaded from: classes3.dex */
    public interface TriggerInvocationHandler<T extends Trigger> {
        boolean handleTrigger(T t3, Macro macro);
    }

    public static void handleTrigger(List<Macro> list, Class cls, TriggerInvocationHandler triggerInvocationHandler) {
        for (Macro macro : list) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (!cls.isInstance(next) || !next.constraintsMet() || !triggerInvocationHandler.handleTrigger(next, macro)) {
                }
            }
        }
    }
}
