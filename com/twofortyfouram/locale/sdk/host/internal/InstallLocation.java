package com.twofortyfouram.locale.sdk.host.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import java.io.IOException;
import net.jcip.annotations.ThreadSafe;
import org.xmlpull.v1.XmlPullParserException;

@ThreadSafe
/* loaded from: classes6.dex */
public enum InstallLocation {
    auto,
    internalOnly,
    preferExternal,
    MISSING,
    UNKNOWN;
    
    @SuppressLint({"InlinedApi"})
    static final int MANIFEST_INSTALL_LOCATION_AUTO = 0;
    @SuppressLint({"InlinedApi"})
    static final int MANIFEST_INSTALL_LOCATION_INTERNAL_ONLY = 1;
    @SuppressLint({"InlinedApi"})
    static final int MANIFEST_INSTALL_LOCATION_PREFER_EXTERNAL = 2;

    @NonNull
    static InstallLocation getInstallLocation(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return UNKNOWN;
                }
                return preferExternal;
            }
            return internalOnly;
        }
        return auto;
    }

    @NonNull
    private static InstallLocation getInstallLocationLegacy(@NonNull Context context, @NonNull String str) throws PackageManager.NameNotFoundException, XmlPullParserException, IOException {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        XmlResourceParser openXmlResourceParser = context.createPackageContext(str, 4).getAssets().openXmlResourceParser("AndroidManifest.xml");
        try {
            for (int eventType = openXmlResourceParser.getEventType(); 1 != eventType; eventType = openXmlResourceParser.nextToken()) {
                if (eventType == 2 && openXmlResourceParser.getName().matches("manifest")) {
                    for (int i4 = 0; i4 < openXmlResourceParser.getAttributeCount(); i4++) {
                        if (openXmlResourceParser.getAttributeName(i4).matches("installLocation")) {
                            return getInstallLocation(Integer.parseInt(openXmlResourceParser.getAttributeValue(i4)));
                        }
                    }
                    continue;
                }
            }
            return MISSING;
        } finally {
            openXmlResourceParser.close();
        }
    }

    @NonNull
    @TargetApi(21)
    private static InstallLocation getInstallLocationLollipop(@NonNull Context context, @NonNull String str) throws PackageManager.NameNotFoundException {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        return getInstallLocation(context.getPackageManager().getPackageInfo(str, 0).installLocation);
    }

    @NonNull
    public static InstallLocation getManifestInstallLocation(@NonNull Context context, @NonNull String str) throws PackageManager.NameNotFoundException, XmlPullParserException, IOException {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        if (AndroidSdkVersion.isAtLeastSdk(21)) {
            return getInstallLocationLollipop(context, str);
        }
        return getInstallLocationLegacy(context, str);
    }
}
