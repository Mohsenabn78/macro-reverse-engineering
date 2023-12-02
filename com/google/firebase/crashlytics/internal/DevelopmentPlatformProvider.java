package com.google.firebase.crashlytics.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class DevelopmentPlatformProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29362a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private DevelopmentPlatform f29363b = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class DevelopmentPlatform {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final String f29364a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final String f29365b;

        private DevelopmentPlatform() {
            int resourcesIdentifier = CommonUtils.getResourcesIdentifier(DevelopmentPlatformProvider.this.f29362a, "com.google.firebase.crashlytics.unity_version", "string");
            if (resourcesIdentifier == 0) {
                if (DevelopmentPlatformProvider.this.c("flutter_assets/NOTICES.Z")) {
                    this.f29364a = "Flutter";
                    this.f29365b = null;
                    Logger.getLogger().v("Development platform is: Flutter");
                    return;
                }
                this.f29364a = null;
                this.f29365b = null;
                return;
            }
            this.f29364a = "Unity";
            String string = DevelopmentPlatformProvider.this.f29362a.getResources().getString(resourcesIdentifier);
            this.f29365b = string;
            Logger logger = Logger.getLogger();
            logger.v("Unity Editor version is: " + string);
        }
    }

    public DevelopmentPlatformProvider(Context context) {
        this.f29362a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f29362a.getAssets() == null) {
            return false;
        }
        try {
            InputStream open = this.f29362a.getAssets().open(str);
            if (open != null) {
                open.close();
                return true;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private DevelopmentPlatform d() {
        if (this.f29363b == null) {
            this.f29363b = new DevelopmentPlatform();
        }
        return this.f29363b;
    }

    public static boolean isUnity(Context context) {
        if (CommonUtils.getResourcesIdentifier(context, "com.google.firebase.crashlytics.unity_version", "string") != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getDevelopmentPlatform() {
        return d().f29364a;
    }

    @Nullable
    public String getDevelopmentPlatformVersion() {
        return d().f29365b;
    }
}
