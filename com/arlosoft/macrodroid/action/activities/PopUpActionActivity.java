package com.arlosoft.macrodroid.action.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.Spanned;
import android.widget.Toast;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.NotificationManagerCompat;
import androidx.emoji2.text.EmojiCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ToastAction;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.NonAppActivityWithPreventClash;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.utils.FileUtils;
import es.dmoral.toasty.Toasty;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PopUpActionActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nPopUpActionActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PopUpActionActivity.kt\ncom/arlosoft/macrodroid/action/activities/PopUpActionActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
/* loaded from: classes2.dex */
public final class PopUpActionActivity extends NonAppActivityWithPreventClash {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_BACKGROUND_COLOR = "background_color";
    @NotNull
    public static final String EXTRA_DISPLAY_ICON = "display_icon";
    @NotNull
    public static final String EXTRA_DO_NOT_TRIGGER = "do_not_trigger";
    @NotNull
    public static final String EXTRA_DURATION = "duration";
    @NotNull
    public static final String EXTRA_IMAGE_NAME = "image_name";
    @NotNull
    public static final String EXTRA_IMAGE_PACKAGE_NAME = "image_package_name";
    @NotNull
    public static final String EXTRA_IMAGE_RESOURCE_NAME = "image_resource_name";
    @NotNull
    public static final String EXTRA_IMAGE_URI = "image_uri";
    @NotNull
    public static final String EXTRA_MACRO_GUID = "macro_guid";
    @NotNull
    public static final String EXTRA_MESSAGE_TEXT = "message_text";
    @NotNull
    public static final String EXTRA_POSITION = "position";
    @NotNull
    public static final String EXTRA_POSITION_HORIZONTAL = "position_horizontal";
    @NotNull
    public static final String EXTRA_TEXT_COLOR = "text_color";
    @NotNull
    public static final String EXTRA_TINT_ICON = "tint_icon";

    /* compiled from: PopUpActionActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Context context, String messageText, int i4, long j4, boolean z3, boolean z4, String str, String str2, String str3, String str4, int i5, int i6, int i7, int i8) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(messageText, "$messageText");
            try {
                Intent intent = new Intent(context, PopUpActionActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(65536);
                intent.putExtra("macro_guid", j4);
                intent.putExtra(PopUpActionActivity.EXTRA_MESSAGE_TEXT, messageText);
                intent.putExtra(PopUpActionActivity.EXTRA_DISPLAY_ICON, z3);
                intent.putExtra(PopUpActionActivity.EXTRA_TINT_ICON, z4);
                intent.putExtra(PopUpActionActivity.EXTRA_IMAGE_URI, str);
                intent.putExtra(PopUpActionActivity.EXTRA_IMAGE_PACKAGE_NAME, str2);
                intent.putExtra(PopUpActionActivity.EXTRA_IMAGE_NAME, str3);
                intent.putExtra(PopUpActionActivity.EXTRA_IMAGE_RESOURCE_NAME, str4);
                intent.putExtra("duration", i4);
                intent.putExtra(PopUpActionActivity.EXTRA_POSITION, i5);
                intent.putExtra(PopUpActionActivity.EXTRA_POSITION_HORIZONTAL, i6);
                intent.putExtra("text_color", i7);
                intent.putExtra("background_color", i8);
                context.startActivity(intent);
            } catch (Exception e4) {
                SystemLog.logError("Failed to display pop up message, reverting to basic text only message: " + e4);
                ToastCompat.makeText(context.getApplicationContext(), (CharSequence) messageText, i4).show();
            }
        }

        @JvmStatic
        public final void showPopupAction(@NotNull final Context context, final long j4, @NotNull final String messageText, final boolean z3, final boolean z4, @Nullable final String str, @Nullable final String str2, @Nullable final String str3, @Nullable final String str4, final int i4, final int i5, final int i6, final int i7, final int i8) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(messageText, "messageText");
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.d0
                @Override // java.lang.Runnable
                public final void run() {
                    PopUpActionActivity.Companion.b(context, messageText, i4, j4, z3, z4, str, str2, str3, str4, i5, i6, i7, i8);
                }
            }, NonAppActivityWithPreventClash.Companion.getDelayUntilNextDisplay());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(PopUpActionActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    private final void j(Toast toast, int i4, int i5) {
        int i6;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.toast_margin);
        int i7 = 1;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    i6 = 0;
                } else {
                    i6 = 48;
                }
            } else {
                i6 = 16;
            }
        } else {
            i6 = 80;
        }
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    i7 = 0;
                } else {
                    i7 = 5;
                }
            } else {
                i7 = 3;
            }
        }
        toast.setGravity(i6 | i7, 0, dimensionPixelOffset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    private final void k(long j4, String str, boolean z3, boolean z4, String str2, String str3, String str4, String str5, int i4, int i5, int i6, int i7, int i8) {
        Drawable createFromStream;
        Toast toast = null;
        if (str2 != null) {
            try {
                createFromStream = Drawable.createFromStream(getContentResolver().openInputStream(Uri.parse(str2)), str2);
            } catch (FileNotFoundException unused) {
            }
        } else if (str3 != null && Intrinsics.areEqual(str3, Constants.USER_ICON_OPTION_PACKAGE)) {
            Bitmap decodeBitmapFromUserIconFile = FileUtils.decodeBitmapFromUserIconFile(str4);
            if (decodeBitmapFromUserIconFile != null) {
                createFromStream = new BitmapDrawable(getResources(), decodeBitmapFromUserIconFile);
            }
            createFromStream = null;
        } else {
            createFromStream = Util.getDrawableFromPackageWithName(this, str3, str5);
        }
        if (createFromStream == null) {
            createFromStream = getResources().getDrawable(R.drawable.launcher_no_border);
        }
        if (!NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            SystemLog.logError("Pop up message failed because notifications are disabled for MacroDroid.", j4);
            return;
        }
        Spanned fromHtml = Html.fromHtml(str);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(messageText)");
        try {
            CharSequence process = EmojiCompat.get().process(fromHtml);
            if (process == null) {
                process = "";
            }
            fromHtml = process;
        } catch (Exception unused2) {
        }
        Toasty.Config.getInstance().setTextColor(i7).tintIcon(z4).apply();
        if (i4 == 0) {
            toast = Toasty.custom(getApplicationContext(), (CharSequence) fromHtml, createFromStream, i8, 1, z3, true);
            j(toast, i5, i6);
            toast.show();
        } else if (i4 != 2) {
            for (int i9 = 0; i9 < 2; i9++) {
                toast = Toasty.custom(getApplicationContext(), (CharSequence) fromHtml, createFromStream, i8, 0, z3, true);
                j(toast, i5, i6);
                toast.show();
            }
        } else {
            toast = Toasty.custom(getApplicationContext(), (CharSequence) fromHtml, createFromStream, i8, 0, z3, true);
            j(toast, i5, i6);
            toast.show();
        }
        if (toast != null) {
            ToastAction.lastToast = new SoftReference<>(toast);
        }
    }

    @JvmStatic
    public static final void showPopupAction(@NotNull Context context, long j4, @NotNull String str, boolean z3, boolean z4, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i4, int i5, int i6, int i7, int i8) {
        Companion.showPopupAction(context, j4, str, z3, z4, str2, str3, str4, str5, i4, i5, i6, i7, i8);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.NonAppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        long longExtra = getIntent().getLongExtra("macro_guid", 0L);
        String stringExtra = getIntent().getStringExtra(EXTRA_MESSAGE_TEXT);
        if (stringExtra == null) {
            stringExtra = "";
        }
        k(longExtra, stringExtra, getIntent().getBooleanExtra(EXTRA_DISPLAY_ICON, false), getIntent().getBooleanExtra(EXTRA_TINT_ICON, false), getIntent().getStringExtra(EXTRA_IMAGE_URI), getIntent().getStringExtra(EXTRA_IMAGE_PACKAGE_NAME), getIntent().getStringExtra(EXTRA_IMAGE_NAME), getIntent().getStringExtra(EXTRA_IMAGE_RESOURCE_NAME), getIntent().getIntExtra("duration", 0), getIntent().getIntExtra(EXTRA_POSITION, 0), getIntent().getIntExtra(EXTRA_POSITION_HORIZONTAL, 0), getIntent().getIntExtra("text_color", 0), getIntent().getIntExtra("background_color", 0));
        new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.activities.c0
            @Override // java.lang.Runnable
            public final void run() {
                PopUpActionActivity.i(PopUpActionActivity.this);
            }
        }, 100L);
    }
}
