package com.arlosoft.macrodroid.common;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NonAppActivity.kt */
@StabilityInferred(parameters = 0)
@SuppressLint({"Registered"})
/* loaded from: classes3.dex */
public class NonAppActivity extends AppCompatActivity {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9990c;

    public static final boolean isActive() {
        return Companion.isActive();
    }

    public static final void setActive(boolean z3) {
        Companion.setActive(z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        f9990c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f9990c = false;
    }

    /* compiled from: NonAppActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isActive() {
            return NonAppActivity.f9990c;
        }

        public final void setActive(boolean z3) {
            NonAppActivity.f9990c = z3;
        }

        @JvmStatic
        public static /* synthetic */ void isActive$annotations() {
        }
    }
}
