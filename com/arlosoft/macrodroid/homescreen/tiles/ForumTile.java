package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.ForumActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ForumTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ForumTile extends HomeScreenTile {
    @NotNull
    public static final String NEW_FORUM_URL = "https://www.macrodroidforum.com";
    @NotNull
    public static final String OLD_FORUM_URL = "https://www.tapatalk.com/groups/macrodroid";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12464c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f12465d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12466e;

    /* renamed from: f  reason: collision with root package name */
    private final long f12467f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12468g;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ForumTile.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ForumTile.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ForumTile.this.c(ForumTile.NEW_FORUM_URL, true);
        }
    }

    public ForumTile(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12464c = activity;
        String string = activity.getString(R.string.forum);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.forum)");
        this.f12465d = string;
        this.f12466e = R.drawable.ic_forum_white_48dp;
        this.f12467f = 5L;
        this.f12468g = ContextCompat.getColor(activity, R.color.forum_primary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str, boolean z3) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(this.f12464c, R.color.forum_primary));
        builder.addDefaultShareMenuItem();
        builder.setShowTitle(false);
        builder.setExitAnimations(this.f12464c, 17432576, 17432577);
        if (z3) {
            builder.addMenuItem(this.f12464c.getString(R.string.open_legacy_forum), PendingIntent.getActivity(this.f12464c, 100, new Intent("android.intent.action.VIEW", Uri.parse(OLD_FORUM_URL)), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE));
        }
        CustomTabsIntent build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        try {
            try {
                build.launchUrl(this.f12464c, Uri.parse(str));
            } catch (Throwable unused) {
                this.f12464c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Throwable unused2) {
            this.f12464c.startActivity(new Intent(this.f12464c, ForumActivity.class));
        }
    }

    private final void d(final Function0<Unit> function0) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this.f12464c, R.style.Theme_App_Dialog_Template);
        appCompatDialog.setContentView(R.layout.dialog_forum);
        appCompatDialog.setTitle(R.string.forum);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = appCompatDialog.findViewById(R.id.warningText);
        Intrinsics.checkNotNull(findViewById3);
        Linkify.addLinks((TextView) findViewById3, 1);
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.tiles.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForumTile.e(ForumTile.this, function0, appCompatDialog, view);
            }
        });
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.homescreen.tiles.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForumTile.f(AppCompatDialog.this, view);
            }
        });
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ForumTile this$0, Function0 acceptedCallback, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(acceptedCallback, "$acceptedCallback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Settings.setHasAcceptedUserGeneratedContentPolicy(this$0.f12464c, true);
        acceptedCallback.invoke();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @NotNull
    public final Activity getActivity() {
        return this.f12464c;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12468g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12466e;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12467f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12465d;
    }

    public final boolean isFirstInstall() {
        try {
            if (this.f12464c.getPackageManager().getPackageInfo(this.f12464c.getPackageName(), 0).firstInstallTime == this.f12464c.getPackageManager().getPackageInfo(this.f12464c.getPackageName(), 0).lastUpdateTime) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        if (Settings.getHasShownForumWarning(this.f12464c)) {
            c(NEW_FORUM_URL, true);
            return;
        }
        Settings.setHasShownForumWarning(this.f12464c, true);
        d(new a());
    }
}
