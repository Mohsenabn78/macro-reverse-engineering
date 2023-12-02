package com.arlosoft.macrodroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ActivityUtils {
    public static Context updateResources(Context context, Activity activity) {
        Locale locale = MacroDroidApplication.Companion.getLocale();
        if (locale != null) {
            Locale.setDefault(locale);
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            configuration.setLocale(locale);
            Context createConfigurationContext = context.createConfigurationContext(configuration);
            activity.applyOverrideConfiguration(configuration);
            return createConfigurationContext;
        }
        return context;
    }
}
