package com.arlosoft.macrodroid.upgrade;

import android.app.Activity;
import android.content.DialogInterface;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.emailservice.EmailServiceKt;
import com.arlosoft.macrodroid.emailservice.sendgrid.SendGrid;
import com.arlosoft.macrodroid.emailservice.sendgrid.SendGridMail;
import com.arlosoft.macrodroid.emailservice.sendgrid.SendGridResponse;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.utils.sparkpostutil.EmailListener;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostEmailUtil;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostFile;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostRecipient;
import com.arlosoft.macrodroid.utils.sparkpostutil.SparkPostSender;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: UpgradeHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UpgradeHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final RemoteConfig f15889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpgradeHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<SendGridResponse, Unit> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $directToUserMessage;
        final /* synthetic */ String $emailAddress;
        final /* synthetic */ View $loadingView;
        final /* synthetic */ UpgradeHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, View view, UpgradeHelper upgradeHelper, String str, String str2) {
            super(1);
            this.$activity = activity;
            this.$loadingView = view;
            this.this$0 = upgradeHelper;
            this.$emailAddress = str;
            this.$directToUserMessage = str2;
        }

        public final void a(@NotNull SendGridResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful()) {
                ToastCompat.makeText(this.$activity.getApplicationContext(), (int) R.string.upgrade_support_request_received, 0).show();
                this.$loadingView.setVisibility(8);
                this.$activity.finish();
                return;
            }
            String errorMessage = response.getErrorMessage();
            SystemLog.logError("Request upgrade support failed: " + errorMessage);
            this.this$0.g(this.$emailAddress, this.$directToUserMessage, this.$activity, this.$loadingView);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SendGridResponse sendGridResponse) {
            a(sendGridResponse);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UpgradeHelper.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $directToUserMessage;
        final /* synthetic */ String $emailAddress;
        final /* synthetic */ View $loadingView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, Activity activity, View view) {
            super(1);
            this.$emailAddress = str;
            this.$directToUserMessage = str2;
            this.$activity = activity;
            this.$loadingView = view;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
            SystemLog.logError("Request upgrade support failed:  " + error);
            UpgradeHelper.this.g(this.$emailAddress, this.$directToUserMessage, this.$activity, this.$loadingView);
        }
    }

    @Inject
    public UpgradeHelper(@NotNull RemoteConfig remoteConfig) {
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        this.f15889a = remoteConfig;
    }

    private final void d(String str, String str2, Activity activity, View view) {
        try {
            SendGrid create = SendGrid.create(StringExtensionsKt.decrypt(EmailServiceKt.TWILIO_ENCRYPTED_KEY));
            SendGridMail sendGridMail = new SendGridMail();
            sendGridMail.addRecipient(str, null);
            sendGridMail.setFrom("support@macrodroid.com", "MacroDroid Support");
            sendGridMail.setSubject("MacroDroid Upgrade Support");
            sendGridMail.setContent(str2);
            Single observeOn = Single.fromCallable(create.send(sendGridMail)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final a aVar = new a(activity, view, this, str, str2);
            Consumer consumer = new Consumer() { // from class: com.arlosoft.macrodroid.upgrade.a
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    UpgradeHelper.e(Function1.this, obj);
                }
            };
            final b bVar = new b(str, str2, activity, view);
            observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.upgrade.b
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    UpgradeHelper.f(Function1.this, obj);
                }
            });
        } catch (Throwable th) {
            SystemLog.logError("Request upgrade support failed: " + th);
            g(str, str2, activity, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str, String str2, final Activity activity, final View view) {
        SparkPostEmailUtil.sendEmail(activity, StringExtensionsKt.decrypt(EmailServiceKt.SPARK_POST_ENCRYPTED_KEY), "MacroDroid Upgrade Support", str2, new SparkPostRecipient(str), new SparkPostSender("support@macrodroid.com", "MacroDroid support"), str2, (ArrayList<SparkPostFile>) null, "support@macrodroid.com", new EmailListener() { // from class: com.arlosoft.macrodroid.upgrade.UpgradeHelper$sendViaSparkPost$1
            @Override // com.arlosoft.macrodroid.utils.sparkpostutil.EmailListener
            public void onError(@NotNull String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SystemLog.logError("Request upgrade support failed: " + errorMessage);
                ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.upgrade_support_request_failed, 1).show();
                view.setVisibility(8);
            }

            @Override // com.arlosoft.macrodroid.utils.sparkpostutil.EmailListener
            public void onSuccess() {
                ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.upgrade_support_request_received, 0).show();
                view.setVisibility(8);
                activity.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Activity activity, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        dialogInterface.dismiss();
        activity.finish();
    }

    public final void generateSupportEmail(@NotNull String emailAddress, @NotNull Activity activity, @NotNull View loadingView) {
        String str;
        Intrinsics.checkNotNullParameter(emailAddress, "emailAddress");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        Settings.Secure.getString(activity.getContentResolver(), "android_id");
        loadingView.setVisibility(0);
        if (Intrinsics.areEqual(this.f15889a.upgradePackageName(), BillingModuleKt.SKU_PREMIUM_NEW)) {
            str = "£3.99, €4.59 or $4.99";
        } else {
            str = "£4.79, €5.49 or $5.99";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = activity.getString(R.string.problems_upgrading_full_text);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…lems_upgrading_full_text)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str, emailAddress, "6"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        d(emailAddress, format, activity, loadingView);
    }

    @NotNull
    public final RemoteConfig getRemoteConfig() {
        return this.f15889a;
    }

    public final void showActivationLimitReachedDialog(@NotNull Activity activity, @NotNull String email, @StyleRes int i4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(email, "email");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.setTitle(R.string.pro_upgrade_failed);
            builder.setMessage(R.string.max_pro_activations_reached);
            FirebaseAnalyticsEventLogger.logActivationLimitReached(email);
            builder.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    public final void showGenericErrorDialog(@NotNull Activity activity, @NotNull String email, @StyleRes int i4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(email, "email");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.setTitle(R.string.pro_upgrade_failed);
            builder.setMessage(R.string.something_went_wrong);
            builder.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    public final void showInvalidCredentialsDialog(@NotNull Activity activity, @NotNull String email, @StyleRes int i4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(email, "email");
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
            builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            builder.setTitle(R.string.pro_upgrade_failed);
            builder.setMessage(R.string.pro_activation_invalid_credentials);
            FirebaseAnalyticsEventLogger.logActivationLimitReached(email);
            builder.show();
        } catch (WindowManager.BadTokenException unused) {
        }
    }

    public final void showUpgradeSuccessDialog(@NotNull final Activity activity, @StyleRes int i4, @NotNull String id, @NotNull String serial) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(serial, "serial");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, i4);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.upgrade.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                UpgradeHelper.h(activity, dialogInterface, i5);
            }
        });
        builder.setTitle(R.string.upgrade_complete);
        builder.setMessage(R.string.thanks_for_purchasing);
        FirebaseAnalyticsEventLogger.logUpgradedViaSerial(id, serial);
        builder.show();
    }
}
