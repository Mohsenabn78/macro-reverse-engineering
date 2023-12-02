package com.google.android.material.color;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class DynamicColors {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f23385a = {R.attr.dynamicColorThemeOverlay};

    /* renamed from: b  reason: collision with root package name */
    private static final DeviceSupportCondition f23386b;
    @SuppressLint({"PrivateApi"})

    /* renamed from: c  reason: collision with root package name */
    private static final DeviceSupportCondition f23387c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, DeviceSupportCondition> f23388d;

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, DeviceSupportCondition> f23389e;

    /* renamed from: f  reason: collision with root package name */
    private static final Precondition f23390f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface DeviceSupportCondition {
        boolean isSupported();
    }

    /* loaded from: classes5.dex */
    public interface Precondition {
        boolean shouldApplyDynamicColors(@NonNull Activity activity, @StyleRes int i4);
    }

    static {
        DeviceSupportCondition deviceSupportCondition = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.1
            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean isSupported() {
                return true;
            }
        };
        f23386b = deviceSupportCondition;
        DeviceSupportCondition deviceSupportCondition2 = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.2

            /* renamed from: a  reason: collision with root package name */
            private Long f23391a;

            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean isSupported() {
                if (this.f23391a == null) {
                    try {
                        Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                        declaredMethod.setAccessible(true);
                        this.f23391a = Long.valueOf(((Long) declaredMethod.invoke(null, "ro.build.version.oneui")).longValue());
                    } catch (Exception unused) {
                        this.f23391a = -1L;
                    }
                }
                if (this.f23391a.longValue() < 40100) {
                    return false;
                }
                return true;
            }
        };
        f23387c = deviceSupportCondition2;
        HashMap hashMap = new HashMap();
        hashMap.put("oppo", deviceSupportCondition);
        hashMap.put("realme", deviceSupportCondition);
        hashMap.put("oneplus", deviceSupportCondition);
        hashMap.put("vivo", deviceSupportCondition);
        hashMap.put("xiaomi", deviceSupportCondition);
        hashMap.put("motorola", deviceSupportCondition);
        hashMap.put("itel", deviceSupportCondition);
        hashMap.put("tecno mobile limited", deviceSupportCondition);
        hashMap.put("infinix mobility limited", deviceSupportCondition);
        hashMap.put("hmd global", deviceSupportCondition);
        hashMap.put("sharp", deviceSupportCondition);
        hashMap.put("sony", deviceSupportCondition);
        hashMap.put("tcl", deviceSupportCondition);
        hashMap.put("lenovo", deviceSupportCondition);
        hashMap.put("lge", deviceSupportCondition);
        hashMap.put("google", deviceSupportCondition);
        hashMap.put("robolectric", deviceSupportCondition);
        hashMap.put("samsung", deviceSupportCondition2);
        f23388d = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", deviceSupportCondition);
        hashMap2.put("jio", deviceSupportCondition);
        f23389e = Collections.unmodifiableMap(hashMap2);
        f23390f = new Precondition() { // from class: com.google.android.material.color.DynamicColors.3
            @Override // com.google.android.material.color.DynamicColors.Precondition
            public boolean shouldApplyDynamicColors(@NonNull Activity activity, int i4) {
                return true;
            }
        };
    }

    private DynamicColors() {
    }

    public static void applyIfAvailable(@NonNull Activity activity) {
        applyIfAvailable(activity, 0);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application) {
        applyToActivitiesIfAvailable(application, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(@NonNull Activity activity, @StyleRes int i4, @NonNull Precondition precondition) {
        if (!isDynamicColorAvailable()) {
            return;
        }
        if (i4 == 0) {
            i4 = c(activity);
        }
        if (i4 != 0 && precondition.shouldApplyDynamicColors(activity, i4)) {
            activity.setTheme(i4);
        }
    }

    private static int c(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f23385a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @ChecksSdkIntAtLeast(api = 31)
    @SuppressLint({"DefaultLocale"})
    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        DeviceSupportCondition deviceSupportCondition = f23388d.get(Build.MANUFACTURER.toLowerCase());
        if (deviceSupportCondition == null) {
            deviceSupportCondition = f23389e.get(Build.BRAND.toLowerCase());
        }
        if (deviceSupportCondition == null || !deviceSupportCondition.isSupported()) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    public static void applyIfAvailable(@NonNull Activity activity, @StyleRes int i4) {
        b(activity, i4, f23390f);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @StyleRes int i4) {
        applyToActivitiesIfAvailable(application, i4, f23390f);
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @StyleRes int i4) {
        if (isDynamicColorAvailable()) {
            if (i4 == 0) {
                i4 = c(context);
            }
            return i4 == 0 ? context : new ContextThemeWrapper(context, i4);
        }
        return context;
    }

    public static void applyIfAvailable(@NonNull Activity activity, @NonNull Precondition precondition) {
        b(activity, 0, precondition);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @NonNull Precondition precondition) {
        applyToActivitiesIfAvailable(application, 0, precondition);
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @StyleRes int i4, @NonNull Precondition precondition) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(i4, precondition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final int f23392a;

        /* renamed from: b  reason: collision with root package name */
        private final Precondition f23393b;

        DynamicColorsActivityLifecycleCallbacks(@StyleRes int i4, @NonNull Precondition precondition) {
            this.f23392a = i4;
            this.f23393b = precondition;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            DynamicColors.b(activity, this.f23392a, this.f23393b);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
