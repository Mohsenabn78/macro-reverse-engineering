package com.arlosoft.macrodroid;

import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.NonAppActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.triggers.receivers.InvokeMacroReceiver;
import com.arlosoft.macrodroid.triggers.receivers.ShortcutTriggerReceiver;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShortcutDispatchActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ShortcutDispatchActivity extends NonAppActivity {
    public static final int $stable = 0;

    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("com.arlosoft.macrodroid.MACRO_NAME");
        long longExtra = getIntent().getLongExtra(Util.EXTRA_GUID, 0L);
        String stringExtra2 = getIntent().getStringExtra(InvokeMacroReceiver.EXTRA_ACTION_BLOCK_PARAMS);
        String stringExtra3 = getIntent().getStringExtra(InvokeMacroReceiver.EXTRA_ACTION_BLOCK_VALUES);
        boolean booleanExtra = getIntent().getBooleanExtra(Util.EXTRA_IS_ACTION_BLOCK, false);
        Intent intent = new Intent(this, ShortcutTriggerReceiver.class);
        intent.putExtra("com.arlosoft.macrodroid.MACRO_NAME", stringExtra);
        intent.putExtra(Util.EXTRA_GUID, longExtra);
        intent.putExtra(Util.EXTRA_IS_ACTION_BLOCK, booleanExtra);
        intent.putExtra(InvokeMacroReceiver.EXTRA_ACTION_BLOCK_PARAMS, stringExtra2);
        intent.putExtra(InvokeMacroReceiver.EXTRA_ACTION_BLOCK_VALUES, stringExtra3);
        sendBroadcast(intent);
        finish();
    }
}
