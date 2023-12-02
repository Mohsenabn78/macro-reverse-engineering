package com.twofortyfouram.locale.sdk.host.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.twofortyfouram.assertion.Assertions;
import com.twofortyfouram.locale.sdk.host.R;
import com.twofortyfouram.log.Lumberjack;
import java.util.Locale;
import net.jcip.annotations.Immutable;

@Immutable
/* loaded from: classes6.dex */
public final class Plugin implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<Plugin> CREATOR = new Parcelable.Creator<Plugin>() { // from class: com.twofortyfouram.locale.sdk.host.model.Plugin.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Plugin createFromParcel(Parcel parcel) {
            return new Plugin(PluginType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), (PluginConfiguration) parcel.readParcelable(getClass().getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Plugin[] newArray(int i4) {
            return new Plugin[i4];
        }
    };
    @NonNull
    private final String mActivityClassName;
    @NonNull
    private final PluginConfiguration mConfiguration;
    @NonNull
    private final String mPackageName;
    @NonNull
    private final String mReceiverClassName;
    @NonNull
    private final String mRegistryName;
    @NonNull
    private final PluginType mType;
    private final int mVersionCode;

    public Plugin(@NonNull PluginType pluginType, @NonNull @Size(min = 1) String str, @NonNull @Size(min = 1) String str2, @NonNull @Size(min = 1) String str3, int i4, @NonNull PluginConfiguration pluginConfiguration) {
        Assertions.assertNotNull(pluginType, "type");
        Assertions.assertNotEmpty(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Assertions.assertNotEmpty(str2, "activityClassName");
        Assertions.assertNotEmpty(str3, "receiverClassName");
        Assertions.assertNotNull(pluginConfiguration, "configuration");
        this.mType = pluginType;
        this.mPackageName = str;
        this.mActivityClassName = str2;
        this.mReceiverClassName = str3;
        this.mRegistryName = generateRegistryName(str, str2);
        this.mVersionCode = i4;
        this.mConfiguration = pluginConfiguration;
    }

    @NonNull
    public static String generateRegistryName(@NonNull String str, @NonNull String str2) {
        Assertions.assertNotEmpty(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Assertions.assertNotEmpty(str2, "activityName");
        return String.format(Locale.US, "%s:%s", str, str2);
    }

    @NonNull
    private ComponentName getComponentName() {
        return new ComponentName(getPackageName(), getActivityClassName());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Plugin.class != obj.getClass()) {
            return false;
        }
        Plugin plugin = (Plugin) obj;
        if (this.mVersionCode == plugin.mVersionCode && this.mActivityClassName.equals(plugin.mActivityClassName) && this.mConfiguration.equals(plugin.mConfiguration) && this.mPackageName.equals(plugin.mPackageName) && this.mReceiverClassName.equals(plugin.mReceiverClassName) && this.mRegistryName.equals(plugin.mRegistryName) && this.mType == plugin.mType) {
            return true;
        }
        return false;
    }

    @NonNull
    public final String getActivityClassName() {
        return this.mActivityClassName;
    }

    @Nullable
    public final Drawable getActivityIcon(@NonNull Context context) {
        Drawable defaultActivityIcon;
        Assertions.assertNotNull(context, "context");
        PackageManager packageManager = context.getPackageManager();
        try {
            defaultActivityIcon = packageManager.getActivityIcon(getComponentName());
        } catch (PackageManager.NameNotFoundException unused) {
            defaultActivityIcon = packageManager.getDefaultActivityIcon();
        }
        if (defaultActivityIcon instanceof BitmapDrawable) {
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.com_twofortyfouram_locale_sdk_host_plugin_icon_size);
            if (defaultActivityIcon.getIntrinsicHeight() != dimensionPixelSize || defaultActivityIcon.getIntrinsicWidth() != dimensionPixelSize) {
                Lumberjack.always("WARNING: Plug-in %s Activity icon size %dx%d is inappropriate for current screen resolution.  Icon should be %dx%d pixels", getActivityClassName(), Integer.valueOf(defaultActivityIcon.getIntrinsicWidth()), Integer.valueOf(defaultActivityIcon.getIntrinsicHeight()), Integer.valueOf(dimensionPixelSize), Integer.valueOf(dimensionPixelSize));
                return new BitmapDrawable(resources, Bitmap.createScaledBitmap(((BitmapDrawable) defaultActivityIcon).getBitmap(), dimensionPixelSize, dimensionPixelSize, false));
            }
            return defaultActivityIcon;
        }
        return defaultActivityIcon;
    }

    @NonNull
    public final String getActivityLabel(@NonNull Context context) {
        CharSequence charSequence;
        Assertions.assertNotNull(context, "context");
        CharSequence activityClassName = getActivityClassName();
        PackageManager packageManager = context.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(getComponentName(), 0);
            int i4 = activityInfo.labelRes;
            if (i4 == 0 && (charSequence = activityInfo.nonLocalizedLabel) != null) {
                activityClassName = charSequence;
            } else if (i4 != 0) {
                activityClassName = packageManager.getText(getPackageName(), activityInfo.labelRes, activityInfo.applicationInfo);
            }
            if (activityClassName == null || activityClassName.length() == 0) {
                activityClassName = getActivityClassName();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return activityClassName.toString();
    }

    @NonNull
    public final PluginConfiguration getConfiguration() {
        return this.mConfiguration;
    }

    @NonNull
    public final String getPackageName() {
        return this.mPackageName;
    }

    @NonNull
    public final String getReceiverClassName() {
        return this.mReceiverClassName;
    }

    @NonNull
    public final String getRegistryName() {
        return this.mRegistryName;
    }

    @NonNull
    public final PluginType getType() {
        return this.mType;
    }

    public final int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (((((((((((this.mType.hashCode() * 31) + this.mPackageName.hashCode()) * 31) + this.mActivityClassName.hashCode()) * 31) + this.mReceiverClassName.hashCode()) * 31) + this.mRegistryName.hashCode()) * 31) + this.mVersionCode) * 31) + this.mConfiguration.hashCode();
    }

    public String toString() {
        return String.format(Locale.US, "Plugin [mType=%s, mPackageName=%s, mActivityClassName=%s, mReceiverClassName=%s, mVersionCode=%s, mConfiguration=%s]", this.mType, this.mPackageName, this.mActivityClassName, this.mReceiverClassName, Integer.valueOf(this.mVersionCode), this.mConfiguration);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.mType.name());
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mActivityClassName);
        parcel.writeString(this.mReceiverClassName);
        parcel.writeInt(this.mVersionCode);
        parcel.writeParcelable(this.mConfiguration, i4);
    }
}
