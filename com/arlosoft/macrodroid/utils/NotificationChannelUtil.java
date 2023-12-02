package com.arlosoft.macrodroid.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.notification.NotificationChannel;
import com.arlosoft.macrodroid.notification.NotificationChannelList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: NotificationChannelUtil.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class NotificationChannelUtil {
    @NotNull
    public static final String NOTIFICATION_CHANNELS = "NotificationChannels";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f16067a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f16068b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: NotificationChannelUtil.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NotificationChannelUtil.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<NotificationChannel, Boolean> {
        final /* synthetic */ String $channelName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(1);
            this.$channelName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull NotificationChannel it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(Intrinsics.areEqual(it.getChannelName(), this.$channelName));
        }
    }

    @Inject
    public NotificationChannelUtil(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f16067a = context;
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.f16068b = (NotificationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    private final int c(int i4) {
        if (i4 == -2) {
            return 1;
        }
        if (i4 != -1) {
            if (i4 != 0) {
                if (i4 != 1) {
                    return 5;
                }
                return 4;
            }
            return 3;
        }
        return 2;
    }

    @RequiresApi(26)
    public final void createNotificationChannel(@NotNull String channelName, int i4) {
        List plus;
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        int c4 = c(i4);
        NotificationChannelList notificationChannelList = (NotificationChannelList) MacroDroidApplication.Companion.getInstance().getCache(NOTIFICATION_CHANNELS).get(NOTIFICATION_CHANNELS, NotificationChannelList.class);
        if (notificationChannelList == null) {
            notificationChannelList = new NotificationChannelList(new ArrayList());
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends NotificationChannel>) ((Collection<? extends Object>) notificationChannelList.getNotificationChannels()), new NotificationChannel(channelName, i4));
        setNotificationChannelList(new NotificationChannelList(plus));
        this.f16068b.createNotificationChannel(new android.app.NotificationChannel(channelName, channelName, c4));
    }

    @RequiresApi(26)
    public final void deleteNotificationChannel(@NotNull String channelName) {
        List mutableList;
        List list;
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        NotificationChannelList notificationChannelList = (NotificationChannelList) MacroDroidApplication.Companion.getInstance().getCache(NOTIFICATION_CHANNELS).get(NOTIFICATION_CHANNELS, NotificationChannelList.class);
        if (notificationChannelList == null) {
            notificationChannelList = new NotificationChannelList(new ArrayList());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) notificationChannelList.getNotificationChannels());
        final a aVar = new a(channelName);
        mutableList.removeIf(new Predicate() { // from class: com.arlosoft.macrodroid.utils.t
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean b4;
                b4 = NotificationChannelUtil.b(Function1.this, obj);
                return b4;
            }
        });
        list = CollectionsKt___CollectionsKt.toList(mutableList);
        setNotificationChannelList(new NotificationChannelList(list));
        this.f16068b.deleteNotificationChannel(channelName);
    }

    @RequiresApi(26)
    public final boolean doesChannelExist(@NotNull String channelName) {
        android.app.NotificationChannel notificationChannel;
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        notificationChannel = this.f16068b.getNotificationChannel(channelName);
        if (notificationChannel != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Context getContext() {
        return this.f16067a;
    }

    @NotNull
    public final NotificationChannelList getNotificationChannelList() {
        NotificationChannelList notificationChannelList = (NotificationChannelList) MacroDroidApplication.Companion.getInstance().getCache(NOTIFICATION_CHANNELS).get(NOTIFICATION_CHANNELS, NotificationChannelList.class);
        if (notificationChannelList == null) {
            return new NotificationChannelList(new ArrayList());
        }
        return notificationChannelList;
    }

    public final void setNotificationChannelList(@NotNull NotificationChannelList notificationChannelList) {
        Intrinsics.checkNotNullParameter(notificationChannelList, "notificationChannelList");
        MacroDroidApplication.Companion.getInstance().getCache(NOTIFICATION_CHANNELS).put(NOTIFICATION_CHANNELS, notificationChannelList);
    }

    public final void setupNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            android.app.NotificationChannel notificationChannel = new android.app.NotificationChannel(Constants.NOTIFICATION_CHANNEL_PERSISTENT, this.f16067a.getString(R.string.notification_channel_persistent), 3);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            arrayList.add(notificationChannel);
            arrayList.add(new android.app.NotificationChannel(Constants.NOTIFICATION_CHANNEL_ACTION_HIGH_PRIORITY, this.f16067a.getString(R.string.notification_channel_action_high_priority), 4));
            arrayList.add(new android.app.NotificationChannel(Constants.NOTIFICATION_CHANNEL_ACTION, this.f16067a.getString(R.string.notification_channel_action), 3));
            arrayList.add(new android.app.NotificationChannel(Constants.NOTIFICATION_CHANNEL_INFO, this.f16067a.getString(R.string.notification_channel_info), 3));
            arrayList.add(new android.app.NotificationChannel(Constants.NOTIFICATION_CHANNEL_VITAL_FUNCTIONALITY, this.f16067a.getString(R.string.notification_channel_vital_functionality), 5));
            arrayList.add(new android.app.NotificationChannel(Constants.NOTIFICATION_CHANNEL_TEMPLATE_STORE_UPDATES, this.f16067a.getString(R.string.notification_channel_template_store_updates), 5));
            this.f16068b.createNotificationChannels(arrayList);
        }
    }
}
