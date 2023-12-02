package com.arlosoft.macrodroid.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.clipboard.ClipboardReadActivity;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.ClipboardChangeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClipboardReadActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ClipboardReadActivity extends NonAppActivity {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_DO_NOT_TRIGGER = "do_not_trigger";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f9761d;

    /* compiled from: ClipboardReadActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isActive() {
            return ClipboardReadActivity.f9761d;
        }

        public final void setActive(boolean z3) {
            ClipboardReadActivity.f9761d = z3;
        }

        @JvmStatic
        public final void startIfRequired(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!isActive() && ClipboardChangeTrigger.getActiveTriggerCounter() > 0) {
                setActive(true);
                Intent intent = new Intent(context, ClipboardReadActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(65536);
                context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ClipboardReadActivity this$0) {
        ClipData.Item itemAt;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Object systemService = this$0.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ClipData primaryClip = ((ClipboardManager) systemService).getPrimaryClip();
            String str = "";
            if (primaryClip != null && (itemAt = primaryClip.getItemAt(0)) != null) {
                str = itemAt.coerceToText(this$0).toString();
            }
            if (!this$0.getIntent().getBooleanExtra("do_not_trigger", false)) {
                if (!Intrinsics.areEqual(ClipboardDataStore.getClipboardText(), str)) {
                    ClipboardDataStore.setClipboardText(str);
                    ArrayList arrayList = new ArrayList();
                    for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                        Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                        while (it.hasNext()) {
                            Trigger next = it.next();
                            if (next instanceof ClipboardChangeTrigger) {
                                String regexPattern = WildCardHelper.getRegexPattern(MagicText.replaceMagicText(this$0, ((ClipboardChangeTrigger) next).getText(), null, macro), ((ClipboardChangeTrigger) next).isEnableRegex(), ((ClipboardChangeTrigger) next).isIgnoreCase());
                                if (TextUtils.isEmpty(((ClipboardChangeTrigger) next).getText()) || WildCardHelper.matches(str, regexPattern, ((ClipboardChangeTrigger) next).isEnableRegex(), ((ClipboardChangeTrigger) next).isIgnoreCase())) {
                                    if (next.constraintsMet()) {
                                        macro.setTriggerThatInvoked(next);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Macro macro2 = (Macro) it2.next();
                        macro2.invokeActions(macro2.getTriggerContextInfo());
                    }
                }
            } else {
                ClipboardDataStore.setClipboardText(str);
            }
            this$0.finish();
        } catch (Exception unused) {
        }
        f9761d = false;
    }

    @JvmStatic
    public static final void startIfRequired(@NotNull Context context) {
        Companion.startIfRequired(context);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        new Handler().postDelayed(new Runnable() { // from class: x.a
            @Override // java.lang.Runnable
            public final void run() {
                ClipboardReadActivity.i(ClipboardReadActivity.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f9761d = false;
    }
}
