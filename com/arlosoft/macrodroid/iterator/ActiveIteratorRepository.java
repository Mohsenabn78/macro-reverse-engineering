package com.arlosoft.macrodroid.iterator;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.IterateDictionaryAction;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActiveIteratorRepository.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ActiveIteratorRepository {
    @NotNull
    public static final ActiveIteratorRepository INSTANCE = new ActiveIteratorRepository();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Macro, Stack<IterateDictionaryAction>> f12581a = new HashMap<>();
    public static final int $stable = 8;

    private ActiveIteratorRepository() {
    }

    @JvmStatic
    public static final void addActiveIterator(@NotNull Macro macro, @NotNull IterateDictionaryAction action) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(action, "action");
        HashMap<Macro, Stack<IterateDictionaryAction>> hashMap = f12581a;
        if (hashMap.get(macro) == null) {
            hashMap.put(macro, new Stack<>());
        }
        Stack<IterateDictionaryAction> stack = hashMap.get(macro);
        if (stack != null) {
            stack.push(action);
        }
    }

    @JvmStatic
    public static final void clearMacro(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        f12581a.remove(macro);
    }

    @JvmStatic
    @Nullable
    public static final IterateDictionaryAction getActiveIterator(@Nullable Macro macro) {
        if (macro == null) {
            return null;
        }
        try {
            Stack<IterateDictionaryAction> stack = f12581a.get(macro);
            if (stack == null) {
                return null;
            }
            return stack.peek();
        } catch (EmptyStackException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final void removeActiveIterator(@NotNull Macro macro, @NotNull IterateDictionaryAction action) {
        IterateDictionaryAction iterateDictionaryAction;
        Stack<IterateDictionaryAction> stack;
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(action, "action");
        try {
            HashMap<Macro, Stack<IterateDictionaryAction>> hashMap = f12581a;
            Stack<IterateDictionaryAction> stack2 = hashMap.get(macro);
            if (stack2 != null) {
                iterateDictionaryAction = stack2.peek();
            } else {
                iterateDictionaryAction = null;
            }
            if (Intrinsics.areEqual(iterateDictionaryAction, action) && (stack = hashMap.get(macro)) != null) {
                stack.pop();
            }
        } catch (EmptyStackException unused) {
        }
    }
}
