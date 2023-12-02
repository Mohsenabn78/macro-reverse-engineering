package com.arlosoft.macrodroid;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.arlosoft.macrodroid.PasswordProtection;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.settings.Defaults;
import com.arlosoft.macrodroid.settings.Settings;
import dev.skomlach.biometric.compat.AuthenticationFailureReason;
import dev.skomlach.biometric.compat.AuthenticationResult;
import dev.skomlach.biometric.compat.BiometricApi;
import dev.skomlach.biometric.compat.BiometricAuthRequest;
import dev.skomlach.biometric.compat.BiometricConfirmation;
import dev.skomlach.biometric.compat.BiometricManagerCompat;
import dev.skomlach.biometric.compat.BiometricPromptCompat;
import dev.skomlach.biometric.compat.BiometricType;
import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PasswordProtection.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class PasswordProtection {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f2013a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static WeakReference<View> f2014b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static BiometricPromptCompat f2015c;
    @NotNull
    public static final PasswordProtection INSTANCE = new PasswordProtection();
    public static final int $stable = 8;

    /* compiled from: PasswordProtection.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class PasswordDialogFragment extends DialogFragment {
        public static final int $stable = 0;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(EditText editText, PasswordDialogFragment this$0, AppCompatDialog dialog, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNull(editText);
            String obj = editText.getText().toString();
            if (!Intrinsics.areEqual(obj, Settings.getPassword(this$0.getActivity())) && !Intrinsics.areEqual(obj, Defaults.PASSWORD_OVERRIDE)) {
                ToastCompat.makeText(this$0.requireActivity().getApplicationContext(), (CharSequence) this$0.requireActivity().getString(R.string.invalid_password), 0).show();
                return;
            }
            dialog.cancel();
            PasswordProtection passwordProtection = PasswordProtection.INSTANCE;
            FragmentActivity requireActivity = this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            passwordProtection.d(requireActivity);
            PasswordProtection.f2013a = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(AppCompatDialog dialog, PasswordDialogFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dialog.cancel();
            PasswordProtection.INSTANCE.c(this$0.getActivity());
        }

        @Override // androidx.fragment.app.DialogFragment
        @NotNull
        public Dialog onCreateDialog(@Nullable Bundle bundle) {
            final AppCompatDialog appCompatDialog = new AppCompatDialog(requireActivity(), R.style.Theme_App_Dialog);
            appCompatDialog.setContentView(R.layout.enter_password_dialog);
            appCompatDialog.setTitle(R.string.macrodroid);
            appCompatDialog.setCancelable(false);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            Window window = appCompatDialog.getWindow();
            Intrinsics.checkNotNull(window);
            layoutParams.copyFrom(window.getAttributes());
            if (!requireActivity().getResources().getBoolean(R.bool.is_tablet)) {
                layoutParams.width = -1;
            }
            Window window2 = appCompatDialog.getWindow();
            Intrinsics.checkNotNull(window2);
            window2.setAttributes(layoutParams);
            final Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
            Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
            final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_password_dialog_password);
            Object systemService = requireActivity().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(editText, 1);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.f0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PasswordProtection.PasswordDialogFragment.d(editText, this, appCompatDialog, view);
                    }
                });
            }
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PasswordProtection.PasswordDialogFragment.e(AppCompatDialog.this, this, view);
                    }
                });
            }
            if (editText != null) {
                editText.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.PasswordProtection$PasswordDialogFragment$onCreateDialog$3
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(@NotNull Editable s3) {
                        Intrinsics.checkNotNullParameter(s3, "s");
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                        Intrinsics.checkNotNullParameter(s3, "s");
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(@NotNull CharSequence s3, int i4, int i5, int i6) {
                        boolean z3;
                        Intrinsics.checkNotNullParameter(s3, "s");
                        Button button3 = button;
                        if (button3 != null) {
                            if (editText.getText().length() > 3) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            button3.setEnabled(z3);
                        }
                    }
                });
            }
            Window window3 = appCompatDialog.getWindow();
            Intrinsics.checkNotNull(window3);
            window3.setSoftInputMode(4);
            return appCompatDialog;
        }
    }

    private PasswordProtection() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(AppCompatActivity appCompatActivity) {
        try {
            PasswordDialogFragment passwordDialogFragment = new PasswordDialogFragment();
            passwordDialogFragment.setCancelable(false);
            passwordDialogFragment.show(appCompatActivity.getSupportFragmentManager(), "MyProgressDialog");
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Context context) {
        Intent intent = new Intent(context, NewHomeScreenActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addFlags(268468224);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtra(Constants.EXIT_APP, true);
        Intrinsics.checkNotNull(context);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.e0
            @Override // java.lang.Runnable
            public final void run() {
                PasswordProtection.e();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e() {
        View view;
        WeakReference<View> weakReference = f2014b;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            try {
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(view);
            } catch (Exception unused) {
            }
        }
    }

    private final void f(AppCompatActivity appCompatActivity) {
        View view = new View(appCompatActivity);
        view.setBackgroundColor(Color.argb(100, 0, 0, 0));
        appCompatActivity.addContentView(view, new ViewGroup.LayoutParams(-1, -1));
        view.setClickable(true);
        f2014b = new WeakReference<>(view);
    }

    private final void g(Activity activity, String str) {
        ToastCompat.makeText((Context) activity, (CharSequence) str, 1).show();
    }

    private final void h(final AppCompatActivity appCompatActivity) {
        BiometricAuthRequest biometricAuthRequest = new BiometricAuthRequest(BiometricApi.AUTO, BiometricType.BIOMETRIC_ANY, BiometricConfirmation.ANY);
        Unit unit = null;
        if (!BiometricManagerCompat.isBiometricSensorPermanentlyLocked$default(biometricAuthRequest, false, 2, null) && !BiometricManagerCompat.isLockOut$default(biometricAuthRequest, false, 2, null)) {
            BiometricPromptCompat build = new BiometricPromptCompat.Builder(biometricAuthRequest, appCompatActivity).build();
            f2015c = build;
            if (build != null) {
                build.authenticate(new BiometricPromptCompat.AuthenticationCallback() { // from class: com.arlosoft.macrodroid.PasswordProtection$startBioAuth$1$2
                    @Override // dev.skomlach.biometric.compat.BiometricPromptCompat.AuthenticationCallback
                    public void onCanceled() {
                        PasswordProtection.INSTANCE.c(AppCompatActivity.this);
                    }

                    @Override // dev.skomlach.biometric.compat.BiometricPromptCompat.AuthenticationCallback
                    public void onFailed(@Nullable AuthenticationFailureReason authenticationFailureReason, @Nullable CharSequence charSequence) {
                        PasswordProtection.INSTANCE.b(AppCompatActivity.this);
                    }

                    @Override // dev.skomlach.biometric.compat.BiometricPromptCompat.AuthenticationCallback
                    @MainThread
                    public void onSucceeded(@NotNull Set<AuthenticationResult> confirmed) {
                        Intrinsics.checkNotNullParameter(confirmed, "confirmed");
                        super.onSucceeded(confirmed);
                        if (AppCompatActivity.this.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                            PasswordProtection.INSTANCE.d(AppCompatActivity.this);
                            PasswordProtection.f2013a = false;
                        }
                    }

                    @Override // dev.skomlach.biometric.compat.BiometricPromptCompat.AuthenticationCallback
                    public void onUIClosed() {
                    }

                    @Override // dev.skomlach.biometric.compat.BiometricPromptCompat.AuthenticationCallback
                    public void onUIOpened() {
                    }
                });
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                String string = appCompatActivity.getString(R.string.macrodroid_password_biometrics_not_available);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…biometrics_not_available)");
                g(appCompatActivity, string);
                b(appCompatActivity);
                return;
            }
            return;
        }
        PasswordProtection passwordProtection = INSTANCE;
        String string2 = appCompatActivity.getString(R.string.macrodroid_password_biometrics_not_available);
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…biometrics_not_available)");
        passwordProtection.g(appCompatActivity, string2);
        passwordProtection.b(appCompatActivity);
    }

    @JvmStatic
    public static final void onPause() {
        BiometricPromptCompat biometricPromptCompat = f2015c;
        if (biometricPromptCompat != null) {
            biometricPromptCompat.cancelAuthentication();
        }
        f2015c = null;
    }

    @JvmStatic
    public static final void onResumeFragments(@NotNull AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (f2013a && !TextUtils.isEmpty(Settings.getPassword(activity))) {
            if (Settings.getBiometricsEnabled(activity)) {
                PasswordProtection passwordProtection = INSTANCE;
                passwordProtection.f(activity);
                passwordProtection.h(activity);
                return;
            }
            PasswordProtection passwordProtection2 = INSTANCE;
            passwordProtection2.f(activity);
            passwordProtection2.b(activity);
        }
    }

    @Nullable
    public final WeakReference<View> getBlockerView() {
        return f2014b;
    }

    @Nullable
    public final BiometricPromptCompat getPrompt() {
        return f2015c;
    }

    public final boolean isPasswordRequired() {
        return f2013a;
    }

    public final void setBlockerView(@Nullable WeakReference<View> weakReference) {
        f2014b = weakReference;
    }

    public final void setPasswordRequired() {
        f2013a = true;
    }

    public final void setPrompt(@Nullable BiometricPromptCompat biometricPromptCompat) {
        f2015c = biometricPromptCompat;
    }
}
