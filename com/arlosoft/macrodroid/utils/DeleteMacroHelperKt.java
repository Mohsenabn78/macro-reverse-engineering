package com.arlosoft.macrodroid.utils;

import android.content.Context;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.DisableMacroAction;
import com.arlosoft.macrodroid.action.ForceMacroRunAction;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: DeleteMacroHelper.kt */
/* loaded from: classes3.dex */
public final class DeleteMacroHelperKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeleteMacroHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Macro, CharSequence> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f16023d = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull Macro m4) {
            Intrinsics.checkNotNullParameter(m4, "m");
            return String.valueOf(m4.getName());
        }
    }

    @NotNull
    public static final String deleteMacroCheckOtherMacros(@NotNull Context context, @NotNull Macro thisMacro) {
        List take;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(thisMacro, "thisMacro");
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        ArrayList arrayList = new ArrayList();
        for (Macro macro : allCompletedMacros) {
            Iterator<Action> it = macro.getActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Action next = it.next();
                    if (next instanceof ForceMacroRunAction) {
                        ForceMacroRunAction forceMacroRunAction = (ForceMacroRunAction) next;
                        if (forceMacroRunAction.getGUID() == thisMacro.getGUID()) {
                            Macro macro2 = forceMacroRunAction.getMacro();
                            Intrinsics.checkNotNullExpressionValue(macro2, "action.macro");
                            arrayList.add(macro2);
                            break;
                        }
                    }
                    if (next instanceof DisableMacroAction) {
                        DisableMacroAction disableMacroAction = (DisableMacroAction) next;
                        if (disableMacroAction.getGUID() == thisMacro.getGUID()) {
                            Macro macro3 = disableMacroAction.getMacro();
                            Intrinsics.checkNotNullExpressionValue(macro3, "action.macro");
                            arrayList.add(macro3);
                            break;
                        }
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            take = CollectionsKt___CollectionsKt.take(arrayList, 4);
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(take, null, null, null, 0, null, a.f16023d, 31, null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = context.getString(R.string.warning_other_macros_reference_this_macro);
            String format = String.format(string + "\n\n", Arrays.copyOf(new Object[]{joinToString$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return "";
    }
}
