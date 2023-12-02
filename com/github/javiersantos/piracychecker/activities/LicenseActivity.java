package com.github.javiersantos.piracychecker.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.github.javiersantos.piracychecker.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.Nullable;

/* compiled from: LicenseActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0003J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/github/javiersantos/piracychecker/activities/LicenseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "", "h", "j", "i", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Ljava/lang/String;", "description", "", "d", "I", "colorPrimary", "e", "colorPrimaryDark", "", "f", "Z", "withLightStatusBar", "g", "layoutXML", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class LicenseActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    private String f18448c;
    @ColorRes

    /* renamed from: d  reason: collision with root package name */
    private int f18449d;
    @ColorRes

    /* renamed from: e  reason: collision with root package name */
    private int f18450e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18451f;
    @LayoutRes

    /* renamed from: g  reason: collision with root package name */
    private int f18452g;

    private final void h() {
        String str;
        int color;
        int color2;
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra(FirebaseAnalytics.Param.CONTENT);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.f18448c = str;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            color = intent2.getIntExtra("colorPrimary", ContextCompat.getColor(this, R.color.colorPrimary));
        } else {
            color = ContextCompat.getColor(this, R.color.colorPrimary);
        }
        this.f18449d = color;
        Intent intent3 = getIntent();
        if (intent3 != null) {
            color2 = intent3.getIntExtra("colorPrimaryDark", ContextCompat.getColor(this, R.color.colorPrimaryDark));
        } else {
            color2 = ContextCompat.getColor(this, R.color.colorPrimaryDark);
        }
        this.f18450e = color2;
        Intent intent4 = getIntent();
        boolean z3 = false;
        if (intent4 != null) {
            z3 = intent4.getBooleanExtra("withLightStatusBar", false);
        }
        this.f18451f = z3;
        Intent intent5 = getIntent();
        int i4 = -1;
        if (intent5 != null) {
            i4 = intent5.getIntExtra("layoutXML", -1);
        }
        this.f18452g = i4;
    }

    @SuppressLint({"InflateParams"})
    private final void i() {
        View inflate;
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mainContainer);
        LayoutInflater from = LayoutInflater.from(this);
        int i4 = this.f18452g;
        if (i4 == -1) {
            inflate = from.inflate(R.layout.activity_license_default, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.piracy_checker_description);
            if (textView != null) {
                textView.setText(this.f18448c);
            }
        } else {
            inflate = from.inflate(i4, (ViewGroup) null);
        }
        if (inflate != null && frameLayout != null) {
            frameLayout.addView(inflate);
        }
    }

    private final void j() {
        View findViewById = findViewById(R.id.toolbar);
        if (!(findViewById instanceof Toolbar)) {
            findViewById = null;
        }
        Toolbar toolbar = (Toolbar) findViewById;
        if (toolbar != null) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this, this.f18449d));
        }
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(ActivityUtilsKt.getAppName(this));
        }
        Window window = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "window");
        window.setStatusBarColor(ContextCompat.getColor(this, this.f18450e));
        Window window2 = getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window2, "window");
        View decorView = window2.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
        ActivityUtilsKt.setupLightStatusBar(decorView, this.f18451f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_license);
        h();
        j();
        i();
    }
}
