package com.arlosoft.macrodroid.templatestore.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: TemplateStoreNotificationHandler.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplateStoreNotificationHandler {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f13650a;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* renamed from: b  reason: collision with root package name */
    private static int f13649b = 783459;

    /* compiled from: TemplateStoreNotificationHandler.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TemplateStoreNotificationHandler(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13650a = context;
    }

    private final void a(String str, String str2, PendingIntent pendingIntent) {
        NotificationCompat.Builder defaults = new NotificationCompat.Builder(this.f13650a, Constants.NOTIFICATION_CHANNEL_TEMPLATE_STORE_UPDATES).setSmallIcon(R.drawable.template_store_update_notification).setContentTitle(str).setContentText(str2).setContentIntent(pendingIntent).setAutoCancel(true).setPriority(2).setDefaults(-1);
        Intrinsics.checkNotNullExpressionValue(defaults, "Builder(context, Constan…cationCompat.DEFAULT_ALL)");
        NotificationManagerCompat from = NotificationManagerCompat.from(this.f13650a);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        int i4 = f13649b;
        f13649b = i4 + 1;
        from.notify(i4, defaults.build());
    }

    static /* synthetic */ void b(TemplateStoreNotificationHandler templateStoreNotificationHandler, String str, String str2, PendingIntent pendingIntent, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            pendingIntent = null;
        }
        templateStoreNotificationHandler.a(str, str2, pendingIntent);
    }

    public final void displayCommentNotification(@NotNull String macroName, int i4, @NotNull String comment, int i5) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intrinsics.checkNotNullParameter(comment, "comment");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.f13650a.getString(R.string.template_store_new_macro_comment_with_comment_text);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…omment_with_comment_text)");
        String format = String.format(string, Arrays.copyOf(new Object[]{comment}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        Intent intent = new Intent(this.f13650a, TemplateCommentsActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(TemplateCommentsActivity.EXTRA_MACRO_ID, i4);
        intent.putExtra("clear_update_subscription_id", i5);
        a(macroName, format, PendingIntent.getActivity(this.f13650a, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE));
    }

    public final void displayMacroDeletedNotification(@NotNull String macroName) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        String string = this.f13650a.getString(R.string.template_store_macro_deleted_notification);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…cro_deleted_notification)");
        b(this, macroName, string, null, 4, null);
    }

    public final void displayMacroUpdatedNotification(@NotNull String macroName, int i4, int i5) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intent intent = new Intent(this.f13650a, TemplateSearchActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(TemplateSearchActivity.EXTRA_INITIAL_SEARCH_TEXT, "id=" + i4);
        intent.putExtra("clear_update_subscription_id", i5);
        PendingIntent activity = PendingIntent.getActivity(this.f13650a, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
        String string = this.f13650a.getString(R.string.template_store_macro_updated_notification);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…cro_updated_notification)");
        a(macroName, string, activity);
    }

    public final void displayNewMacroNotification(@NotNull String username, @NotNull String macroName, int i4, int i5) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intent intent = new Intent(this.f13650a, TemplateSearchActivity.class);
        intent.setFlags(603979776);
        intent.putExtra(TemplateSearchActivity.EXTRA_INITIAL_SEARCH_TEXT, "id=" + i4);
        intent.putExtra("clear_update_subscription_id", i5);
        PendingIntent activity = PendingIntent.getActivity(this.f13650a, 0, intent, 268435456 | PendingIntentHelper.FLAG_IMMUTABLE);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.f13650a.getString(R.string.template_store_new_macro_notification_with_macro_name);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…fication_with_macro_name)");
        String format = String.format(string, Arrays.copyOf(new Object[]{macroName, activity}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        a(username, format, activity);
    }
}
