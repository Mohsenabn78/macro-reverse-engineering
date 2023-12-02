package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes5.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new RemoteMessageCreator();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.Field(id = 2)

    /* renamed from: a  reason: collision with root package name */
    Bundle f31681a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f31682b;

    /* renamed from: c  reason: collision with root package name */
    private Notification f31683c;

    /* loaded from: classes5.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Bundle f31684a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, String> f31685b;

        public Builder(@NonNull String str) {
            Bundle bundle = new Bundle();
            this.f31684a = bundle;
            this.f31685b = new ArrayMap();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(Constants.MessagePayloadKeys.TO, str);
                return;
            }
            throw new IllegalArgumentException("Invalid to: " + str);
        }

        @NonNull
        public Builder addData(@NonNull String str, @Nullable String str2) {
            this.f31685b.put(str, str2);
            return this;
        }

        @NonNull
        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : this.f31685b.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            bundle.putAll(this.f31684a);
            this.f31684a.remove("from");
            return new RemoteMessage(bundle);
        }

        @NonNull
        public Builder clearData() {
            this.f31685b.clear();
            return this;
        }

        @Nullable
        public String getCollapseKey() {
            return this.f31684a.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        }

        @NonNull
        public Map<String, String> getData() {
            return this.f31685b;
        }

        @NonNull
        public String getMessageId() {
            return this.f31684a.getString(Constants.MessagePayloadKeys.MSGID, "");
        }

        @Nullable
        public String getMessageType() {
            return this.f31684a.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        }

        @IntRange(from = 0, to = 86400)
        public int getTtl() {
            return Integer.parseInt(this.f31684a.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE, "0"));
        }

        @NonNull
        public Builder setCollapseKey(@Nullable String str) {
            this.f31684a.putString(Constants.MessagePayloadKeys.COLLAPSE_KEY, str);
            return this;
        }

        @NonNull
        public Builder setData(@NonNull Map<String, String> map) {
            this.f31685b.clear();
            this.f31685b.putAll(map);
            return this;
        }

        @NonNull
        public Builder setMessageId(@NonNull String str) {
            this.f31684a.putString(Constants.MessagePayloadKeys.MSGID, str);
            return this;
        }

        @NonNull
        public Builder setMessageType(@Nullable String str) {
            this.f31684a.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, str);
            return this;
        }

        @NonNull
        @ShowFirstParty
        public Builder setRawData(byte[] bArr) {
            this.f31684a.putByteArray(Constants.MessagePayloadKeys.RAW_DATA, bArr);
            return this;
        }

        @NonNull
        public Builder setTtl(@IntRange(from = 0, to = 86400) int i4) {
            this.f31684a.putString(Constants.MessagePayloadKeys.TTL, String.valueOf(i4));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface MessagePriority {
    }

    /* loaded from: classes5.dex */
    public static class Notification {

        /* renamed from: a  reason: collision with root package name */
        private final String f31686a;

        /* renamed from: b  reason: collision with root package name */
        private final String f31687b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f31688c;

        /* renamed from: d  reason: collision with root package name */
        private final String f31689d;

        /* renamed from: e  reason: collision with root package name */
        private final String f31690e;

        /* renamed from: f  reason: collision with root package name */
        private final String[] f31691f;

        /* renamed from: g  reason: collision with root package name */
        private final String f31692g;

        /* renamed from: h  reason: collision with root package name */
        private final String f31693h;

        /* renamed from: i  reason: collision with root package name */
        private final String f31694i;

        /* renamed from: j  reason: collision with root package name */
        private final String f31695j;

        /* renamed from: k  reason: collision with root package name */
        private final String f31696k;

        /* renamed from: l  reason: collision with root package name */
        private final String f31697l;

        /* renamed from: m  reason: collision with root package name */
        private final String f31698m;

        /* renamed from: n  reason: collision with root package name */
        private final Uri f31699n;

        /* renamed from: o  reason: collision with root package name */
        private final String f31700o;

        /* renamed from: p  reason: collision with root package name */
        private final Integer f31701p;

        /* renamed from: q  reason: collision with root package name */
        private final Integer f31702q;

        /* renamed from: r  reason: collision with root package name */
        private final Integer f31703r;

        /* renamed from: s  reason: collision with root package name */
        private final int[] f31704s;

        /* renamed from: t  reason: collision with root package name */
        private final Long f31705t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f31706u;

        /* renamed from: v  reason: collision with root package name */
        private final boolean f31707v;

        /* renamed from: w  reason: collision with root package name */
        private final boolean f31708w;

        /* renamed from: x  reason: collision with root package name */
        private final boolean f31709x;

        /* renamed from: y  reason: collision with root package name */
        private final boolean f31710y;

        /* renamed from: z  reason: collision with root package name */
        private final long[] f31711z;

        private static String[] a(NotificationParams notificationParams, String str) {
            Object[] localizationArgsForKey = notificationParams.getLocalizationArgsForKey(str);
            if (localizationArgsForKey == null) {
                return null;
            }
            String[] strArr = new String[localizationArgsForKey.length];
            for (int i4 = 0; i4 < localizationArgsForKey.length; i4++) {
                strArr[i4] = String.valueOf(localizationArgsForKey[i4]);
            }
            return strArr;
        }

        @Nullable
        public String getBody() {
            return this.f31689d;
        }

        @Nullable
        public String[] getBodyLocalizationArgs() {
            return this.f31691f;
        }

        @Nullable
        public String getBodyLocalizationKey() {
            return this.f31690e;
        }

        @Nullable
        public String getChannelId() {
            return this.f31698m;
        }

        @Nullable
        public String getClickAction() {
            return this.f31697l;
        }

        @Nullable
        public String getColor() {
            return this.f31696k;
        }

        public boolean getDefaultLightSettings() {
            return this.f31710y;
        }

        public boolean getDefaultSound() {
            return this.f31708w;
        }

        public boolean getDefaultVibrateSettings() {
            return this.f31709x;
        }

        @Nullable
        public Long getEventTime() {
            return this.f31705t;
        }

        @Nullable
        public String getIcon() {
            return this.f31692g;
        }

        @Nullable
        public Uri getImageUrl() {
            String str = this.f31693h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        @Nullable
        public int[] getLightSettings() {
            return this.f31704s;
        }

        @Nullable
        public Uri getLink() {
            return this.f31699n;
        }

        public boolean getLocalOnly() {
            return this.f31707v;
        }

        @Nullable
        public Integer getNotificationCount() {
            return this.f31703r;
        }

        @Nullable
        public Integer getNotificationPriority() {
            return this.f31701p;
        }

        @Nullable
        public String getSound() {
            return this.f31694i;
        }

        public boolean getSticky() {
            return this.f31706u;
        }

        @Nullable
        public String getTag() {
            return this.f31695j;
        }

        @Nullable
        public String getTicker() {
            return this.f31700o;
        }

        @Nullable
        public String getTitle() {
            return this.f31686a;
        }

        @Nullable
        public String[] getTitleLocalizationArgs() {
            return this.f31688c;
        }

        @Nullable
        public String getTitleLocalizationKey() {
            return this.f31687b;
        }

        @Nullable
        public long[] getVibrateTimings() {
            return this.f31711z;
        }

        @Nullable
        public Integer getVisibility() {
            return this.f31702q;
        }

        private Notification(NotificationParams notificationParams) {
            this.f31686a = notificationParams.getString(Constants.MessageNotificationKeys.TITLE);
            this.f31687b = notificationParams.getLocalizationResourceForKey(Constants.MessageNotificationKeys.TITLE);
            this.f31688c = a(notificationParams, Constants.MessageNotificationKeys.TITLE);
            this.f31689d = notificationParams.getString(Constants.MessageNotificationKeys.BODY);
            this.f31690e = notificationParams.getLocalizationResourceForKey(Constants.MessageNotificationKeys.BODY);
            this.f31691f = a(notificationParams, Constants.MessageNotificationKeys.BODY);
            this.f31692g = notificationParams.getString(Constants.MessageNotificationKeys.ICON);
            this.f31694i = notificationParams.getSoundResourceName();
            this.f31695j = notificationParams.getString(Constants.MessageNotificationKeys.TAG);
            this.f31696k = notificationParams.getString(Constants.MessageNotificationKeys.COLOR);
            this.f31697l = notificationParams.getString(Constants.MessageNotificationKeys.CLICK_ACTION);
            this.f31698m = notificationParams.getString(Constants.MessageNotificationKeys.CHANNEL);
            this.f31699n = notificationParams.getLink();
            this.f31693h = notificationParams.getString(Constants.MessageNotificationKeys.IMAGE_URL);
            this.f31700o = notificationParams.getString(Constants.MessageNotificationKeys.TICKER);
            this.f31701p = notificationParams.getInteger(Constants.MessageNotificationKeys.NOTIFICATION_PRIORITY);
            this.f31702q = notificationParams.getInteger(Constants.MessageNotificationKeys.VISIBILITY);
            this.f31703r = notificationParams.getInteger(Constants.MessageNotificationKeys.NOTIFICATION_COUNT);
            this.f31706u = notificationParams.getBoolean(Constants.MessageNotificationKeys.STICKY);
            this.f31707v = notificationParams.getBoolean(Constants.MessageNotificationKeys.LOCAL_ONLY);
            this.f31708w = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_SOUND);
            this.f31709x = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_VIBRATE_TIMINGS);
            this.f31710y = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_LIGHT_SETTINGS);
            this.f31705t = notificationParams.getLong(Constants.MessageNotificationKeys.EVENT_TIME);
            this.f31704s = notificationParams.b();
            this.f31711z = notificationParams.getVibrateTimings();
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f31681a = bundle;
    }

    private int b(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        if ("normal".equals(str)) {
            return 2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Intent intent) {
        intent.putExtras(this.f31681a);
    }

    @Nullable
    public String getCollapseKey() {
        return this.f31681a.getString(Constants.MessagePayloadKeys.COLLAPSE_KEY);
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.f31682b == null) {
            this.f31682b = Constants.MessagePayloadKeys.extractDeveloperDefinedPayload(this.f31681a);
        }
        return this.f31682b;
    }

    @Nullable
    public String getFrom() {
        return this.f31681a.getString("from");
    }

    @Nullable
    public String getMessageId() {
        String string = this.f31681a.getString(Constants.MessagePayloadKeys.MSGID);
        if (string == null) {
            return this.f31681a.getString(Constants.MessagePayloadKeys.MSGID_SERVER);
        }
        return string;
    }

    @Nullable
    public String getMessageType() {
        return this.f31681a.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
    }

    @Nullable
    public Notification getNotification() {
        if (this.f31683c == null && NotificationParams.isNotification(this.f31681a)) {
            this.f31683c = new Notification(new NotificationParams(this.f31681a));
        }
        return this.f31683c;
    }

    public int getOriginalPriority() {
        String string = this.f31681a.getString(Constants.MessagePayloadKeys.ORIGINAL_PRIORITY);
        if (string == null) {
            string = this.f31681a.getString(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return b(string);
    }

    public int getPriority() {
        String string = this.f31681a.getString(Constants.MessagePayloadKeys.DELIVERED_PRIORITY);
        if (string == null) {
            if ("1".equals(this.f31681a.getString(Constants.MessagePayloadKeys.PRIORITY_REDUCED_V19))) {
                return 2;
            }
            string = this.f31681a.getString(Constants.MessagePayloadKeys.PRIORITY_V19);
        }
        return b(string);
    }

    @Nullable
    @ShowFirstParty
    public byte[] getRawData() {
        return this.f31681a.getByteArray(Constants.MessagePayloadKeys.RAW_DATA);
    }

    @Nullable
    public String getSenderId() {
        return this.f31681a.getString(Constants.MessagePayloadKeys.SENDER_ID);
    }

    public long getSentTime() {
        Object obj = this.f31681a.get(Constants.MessagePayloadKeys.SENT_TIME);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                Log.w(Constants.TAG, "Invalid sent time: " + obj);
                return 0L;
            }
        }
        return 0L;
    }

    @Nullable
    public String getTo() {
        return this.f31681a.getString(Constants.MessagePayloadKeys.TO);
    }

    public int getTtl() {
        Object obj = this.f31681a.get(Constants.MessagePayloadKeys.TTL);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                Log.w(Constants.TAG, "Invalid TTL: " + obj);
                return 0;
            }
        }
        return 0;
    }

    @KeepForSdk
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.f31681a);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        RemoteMessageCreator.a(this, parcel, i4);
    }
}
