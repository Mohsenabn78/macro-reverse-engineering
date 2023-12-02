package com.arlosoft.macrodroid.action.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.NonAppActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: SetKeyboardPieActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SetKeyboardPieActivity extends NonAppActivity {
    public static final int $stable = 8;

    /* renamed from: d  reason: collision with root package name */
    private final int f2920d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2921e = 1;

    /* renamed from: f  reason: collision with root package name */
    private final int f2922f = 2;

    /* renamed from: g  reason: collision with root package name */
    private int f2923g;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SetKeyboardPieActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    private final void j() {
        finish();
    }

    private final void k() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showInputMethodPicker();
        this.f2923g = this.f2921e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f2923g = this.f2920d;
        new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.e0
            @Override // java.lang.Runnable
            public final void run() {
                SetKeyboardPieActivity.i(SetKeyboardPieActivity.this);
            }
        }, 500L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        int i4 = this.f2923g;
        if (i4 == this.f2921e) {
            this.f2923g = this.f2922f;
        } else if (i4 == this.f2922f) {
            j();
        }
    }
}
