package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.EmptyTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: ShortcutTriggerReceiver.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nShortcutTriggerReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShortcutTriggerReceiver.kt\ncom/arlosoft/macrodroid/triggers/receivers/ShortcutTriggerReceiver\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,94:1\n125#2:95\n152#2,3:96\n107#3:99\n79#3,22:100\n*S KotlinDebug\n*F\n+ 1 ShortcutTriggerReceiver.kt\ncom/arlosoft/macrodroid/triggers/receivers/ShortcutTriggerReceiver\n*L\n36#1:95\n36#1:96,3\n48#1:99\n48#1:100,22\n*E\n"})
/* loaded from: classes3.dex */
public final class ShortcutTriggerReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_IS_ASSISTANT = "is_assistant";

    /* compiled from: ShortcutTriggerReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(ActionBlock actionBlock, Map<String, String> map) {
        Map<String, DictionaryKeys> emptyMap;
        ActionBlock cloneActionBlock$default = ActionBlock.cloneActionBlock$default(actionBlock, false, false, 2, null);
        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(new EmptyTrigger());
        cloneActionBlock$default.setIsClonedInstance(true);
        MacroStore macroStore = MacroStore.getInstance();
        Intrinsics.checkNotNull(macroStore, "null cannot be cast to non-null type com.arlosoft.macrodroid.macro.ActionBlockStore");
        macroStore.addActionBlock(cloneActionBlock$default);
        ResumeMacroInfo resumeMacroInfo = new ResumeMacroInfo(cloneActionBlock$default.getGUID(), -1, triggerContextInfo, true, new Stack(), null, new HashMap());
        if (map == null) {
            map = s.emptyMap();
        }
        emptyMap = s.emptyMap();
        cloneActionBlock$default.invokeActions((TriggerContextInfo) null, true, resumeMacroInfo, map, emptyMap, (Macro) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(@org.jetbrains.annotations.NotNull android.content.Context r22, @org.jetbrains.annotations.NotNull android.content.Intent r23) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.receivers.ShortcutTriggerReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
