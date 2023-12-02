package com.arlosoft.macrodroid.googleassistant;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.receivers.ShortcutTriggerReceiver;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GoogleAssistantDispatchActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class GoogleAssistantDispatchActivity extends NonAppActivity {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f12270d = "actions.fulfillment.extra.ACTION_TOKEN";

    /* compiled from: GoogleAssistantDispatchActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void h(Uri uri) {
        String str;
        String str2 = null;
        if (uri != null) {
            str = uri.getQueryParameter("macro");
        } else {
            str = null;
        }
        if (str != null) {
            Intent intent = new Intent(this, ShortcutTriggerReceiver.class);
            intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", str);
            intent.putExtra(Util.EXTRA_GUID, 0L);
            intent.putExtra(ShortcutTriggerReceiver.EXTRA_IS_ASSISTANT, true);
            sendBroadcast(intent);
            j("http://schema.org/CompletedActionStatus");
        }
        if (uri != null) {
            str2 = uri.getQueryParameter("name");
        }
        if (str2 != null) {
            boolean z3 = false;
            Iterator<Macro> it = MacroStore.getInstance().getAllCompletedMacrosSorted(false).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Macro next = it.next();
                String name = next.getName();
                Intrinsics.checkNotNullExpressionValue(name, "macro.name");
                Locale locale = Locale.ROOT;
                String lowerCase = name.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                String lowerCase2 = str2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (lowerCase.equals(lowerCase2)) {
                    Intent intent2 = new Intent(this, EditMacroActivity.class);
                    intent2.putExtra("MacroId", next.getId());
                    startActivity(intent2);
                    j("http://schema.org/CompletedActionStatus");
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                ToastCompat.makeText((Context) this, (CharSequence) (getString(R.string.macro_not_found) + ": " + str2), 1).show();
                j("http://schema.org/FailedActionStatus");
            }
        }
    }

    private final void i(Intent intent, Intent intent2) {
        String action = intent2.getAction();
        if (action != null && action.hashCode() == -1173171990 && action.equals("android.intent.action.VIEW")) {
            h(intent.getData());
        }
    }

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            i(intent, intent2);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            i(intent, intent);
        }
        finish();
    }

    private final void j(String str) {
    }
}
