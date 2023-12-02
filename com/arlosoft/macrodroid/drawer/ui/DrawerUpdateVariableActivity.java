package com.arlosoft.macrodroid.drawer.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MacroDroidVariableStore;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DrawerUpdateVariableActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DrawerUpdateVariableActivity extends MacroDroidBaseActivity {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_DICTIONARY_KEYS = "dictionary_keys";
    @NotNull
    public static final String EXTRA_VARIABLE_NAME = "var_name";

    /* compiled from: DrawerUpdateVariableActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void displayDialog(@NotNull Context context, @NotNull String variableName, @Nullable DictionaryKeys dictionaryKeys) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(variableName, "variableName");
            Intent intent = new Intent(context, DrawerUpdateVariableActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("var_name", variableName);
            intent.putExtra("dictionary_keys", dictionaryKeys);
            context.startActivity(intent);
        }
    }

    @JvmStatic
    public static final void displayDialog(@NotNull Context context, @NotNull String str, @Nullable DictionaryKeys dictionaryKeys) {
        Companion.displayDialog(context, str, dictionaryKeys);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DrawerUpdateVariableActivity this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("var_name");
        Intrinsics.checkNotNull(stringExtra);
        MacroDroidVariable variable = MacroDroidVariableStore.getInstance().getVariableByName(stringExtra);
        Intrinsics.checkNotNullExpressionValue(variable, "variable");
        VariableHelper.promptForNewValue(this, variable, (DictionaryKeys) getIntent().getParcelableExtra("dictionary_keys"), null, false, new DialogInterface.OnDismissListener() { // from class: com.arlosoft.macrodroid.drawer.ui.c1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DrawerUpdateVariableActivity.n(DrawerUpdateVariableActivity.this, dialogInterface);
            }
        });
    }
}
