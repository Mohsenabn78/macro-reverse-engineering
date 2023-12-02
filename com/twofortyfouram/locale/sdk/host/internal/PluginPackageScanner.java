package com.twofortyfouram.locale.sdk.host.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginConfiguration;
import com.twofortyfouram.locale.sdk.host.model.PluginErrorRegister;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import com.twofortyfouram.log.Lumberjack;
import com.twofortyfouram.spackle.AndroidSdkVersion;
import com.twofortyfouram.spackle.PermissionCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;
import net.jcip.annotations.ThreadSafe;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
@ThreadSafe
/* loaded from: classes6.dex */
public final class PluginPackageScanner {
    @NonNull
    private static final Comparator<ResolveInfo> PACKAGE_NAME_COMPARATOR = new PackageNameComparator();

    private PluginPackageScanner() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    private static EnumSet<PluginErrorRegister> checkPluginForErrors(@NonNull Context context, @NonNull PluginType pluginType, @NonNull ResolveInfo resolveInfo, @NonNull List<ResolveInfo> list) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotNull(resolveInfo, "activityResolveInfo");
        Assertions.assertNotNull(list, "receiverResolveInfos");
        EnumSet<PluginErrorRegister> noneOf = EnumSet.noneOf(PluginErrorRegister.class);
        if (!isTargetSdkCorrect(context, resolveInfo)) {
            Lumberjack.always("WARNING: %s targetSdkVersion is older than %s", resolveInfo.activityInfo.packageName, context.getPackageName());
        }
        if (!isInstallLocationCorrect(context, resolveInfo)) {
            noneOf.add(PluginErrorRegister.INSTALL_LOCATION_BAD);
        }
        if (!isApplicationEnabled(resolveInfo)) {
            noneOf.add(PluginErrorRegister.APPLICATION_NOT_ENABLED);
        }
        if (!isComponentEnabled(resolveInfo)) {
            noneOf.add(PluginErrorRegister.ACTIVITY_NOT_ENABLED);
        }
        if (!isComponentExported(resolveInfo)) {
            noneOf.add(PluginErrorRegister.ACTIVITY_NOT_EXPORTED);
        }
        if (!isComponentPermissionGranted(context, resolveInfo)) {
            noneOf.add(PluginErrorRegister.ACTIVITY_REQUIRES_PERMISSION);
        }
        if (1 == list.size()) {
            ResolveInfo resolveInfo2 = list.get(0);
            if (!isComponentEnabled(resolveInfo2)) {
                noneOf.add(PluginErrorRegister.RECEIVER_NOT_ENABLED);
            }
            if (!isComponentExported(resolveInfo2)) {
                noneOf.add(PluginErrorRegister.RECEIVER_NOT_EXPORTED);
            }
            if (!isComponentPermissionGranted(context, resolveInfo2)) {
                noneOf.add(PluginErrorRegister.RECEIVER_REQUIRES_PERMISSION);
            }
        } else if (2 >= list.size()) {
            noneOf.add(PluginErrorRegister.RECEIVER_DUPLICATE);
        } else {
            noneOf.add(PluginErrorRegister.MISSING_RECEIVER);
        }
        return noneOf;
    }

    @NonNull
    private static Collection<ResolveInfo> findActivities(@NonNull Context context, @NonNull PluginType pluginType, @Nullable String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(pluginType, "type");
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(pluginType.getActivityIntentAction());
        if (str != null) {
            intent.setPackage(str);
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 1);
        if (!AndroidSdkVersion.isAtLeastSdk(11) && queryIntentActivities == null) {
            queryIntentActivities = new ArrayList<>(0);
        }
        Assertions.assertNotNull(queryIntentActivities, "activities");
        Collections.sort(queryIntentActivities, PACKAGE_NAME_COMPARATOR);
        return queryIntentActivities;
    }

    @NonNull
    private static List<ResolveInfo> findReceivers(@NonNull Context context, @NonNull PluginType pluginType, @Nullable String str) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(pluginType, "type");
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(pluginType.getReceiverIntentAction());
        if (str != null) {
            intent.setPackage(str);
        }
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (!AndroidSdkVersion.isAtLeastSdk(11) && queryBroadcastReceivers == null) {
            queryBroadcastReceivers = new ArrayList<>(0);
        }
        Collections.sort(queryBroadcastReceivers, PACKAGE_NAME_COMPARATOR);
        return queryBroadcastReceivers;
    }

    private static int getVersionCode(@NonNull PackageManager packageManager, @NonNull String str) {
        PackageInfo packageInfo;
        Assertions.assertNotNull(packageManager, "packageManager");
        Assertions.assertNotNull(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        try {
            packageInfo = packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    private static boolean isApplicationEnabled(@NonNull ResolveInfo resolveInfo) {
        Assertions.assertNotNull(resolveInfo, "info");
        return resolveInfo.activityInfo.applicationInfo.enabled;
    }

    private static boolean isComponentEnabled(@NonNull ResolveInfo resolveInfo) {
        Assertions.assertNotNull(resolveInfo, "info");
        return resolveInfo.activityInfo.enabled;
    }

    private static boolean isComponentExported(@NonNull ResolveInfo resolveInfo) {
        Assertions.assertNotNull(resolveInfo, "info");
        return resolveInfo.activityInfo.exported;
    }

    private static boolean isComponentPermissionGranted(@NonNull Context context, @NonNull ResolveInfo resolveInfo) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(resolveInfo, "info");
        String str = resolveInfo.activityInfo.permission;
        if (str == null || PermissionCompat.PermissionStatus.GRANTED == PermissionCompat.getPermissionStatus(context, str)) {
            return true;
        }
        return false;
    }

    private static boolean isInstallLocationCorrect(@NonNull Context context, @NonNull ResolveInfo resolveInfo) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(resolveInfo, "resolveInfo");
        try {
            InstallLocation.getManifestInstallLocation(context, resolveInfo.activityInfo.packageName);
            return true;
        } catch (PackageManager.NameNotFoundException | IOException | XmlPullParserException unused) {
            return true;
        }
    }

    private static boolean isTargetSdkCorrect(@NonNull Context context, @NonNull ResolveInfo resolveInfo) {
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(resolveInfo, "info");
        if (resolveInfo.activityInfo.applicationInfo.targetSdkVersion < context.getApplicationInfo().targetSdkVersion) {
            return false;
        }
        return true;
    }

    @NonNull
    public static Map<String, Plugin> loadPluginMap(@NonNull Context context, @NonNull PluginType pluginType, @Nullable String str) {
        String str2;
        Assertions.assertNotNull(context, "context");
        Assertions.assertNotNull(pluginType, "type");
        SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        for (ResolveInfo resolveInfo : findActivities(context, pluginType, str)) {
            String str3 = resolveInfo.activityInfo.packageName;
            int versionCode = getVersionCode(context.getPackageManager(), str3);
            List<ResolveInfo> findReceivers = findReceivers(context, pluginType, str3);
            Lumberjack.always("Found plug-in %s with package: %s, Activity: %s, BroadcastReceiver: %s, versionCode: %d", pluginType, str3, resolveInfo, findReceivers, Integer.valueOf(versionCode));
            checkPluginForErrors(context, pluginType, resolveInfo, findReceivers);
            String generateRegistryName = Plugin.generateRegistryName(str3, resolveInfo.activityInfo.name);
            String str4 = resolveInfo.activityInfo.name;
            if (findReceivers.size() > 0) {
                str2 = findReceivers.get(0).activityInfo.name;
            } else {
                str2 = TypeDescription.Generic.OfWildcardType.SYMBOL;
            }
            Plugin plugin = new Plugin(pluginType, str3, str4, str2, versionCode, new PluginConfiguration(PluginCharacteristics.isBackwardsCompatibilityEnabled(pluginType, generateRegistryName), PluginCharacteristics.isRequiresConnectivity(pluginType, generateRegistryName), PluginCharacteristics.isDisruptsConnectivity(pluginType, generateRegistryName), PluginCharacteristics.isBuggy(pluginType, generateRegistryName), PluginCharacteristics.isDrainsBattery(pluginType, generateRegistryName), PluginCharacteristics.isBlacklisted(pluginType, generateRegistryName), PluginCharacteristics.getBuiltInAlternative(pluginType, generateRegistryName)));
            hashMap.put(plugin.getRegistryName(), plugin);
        }
        SystemClock.elapsedRealtime();
        return hashMap;
    }
}
