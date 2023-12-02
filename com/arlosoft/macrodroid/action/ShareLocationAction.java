package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import co.nedim.maildroidx.MaildroidX;
import co.nedim.maildroidx.MaildroidXType;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.EmailActivity;
import com.arlosoft.macrodroid.action.info.ShareLocationActionInfo;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.action.services.UploadLocationService;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.action.sms.SMSOutputService2;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.calendar.CalendarArrayAdapter;
import com.arlosoft.macrodroid.calendar.CalendarInfo;
import com.arlosoft.macrodroid.common.CalendarHelper;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.SmtpServerConfig;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.IncomingCallTrigger;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ShareLocationAction extends Action implements TwitterOutput.TwitterAuthListener, HasVariable, GoogleApiClient.OnConnectionFailedListener, LocationListener, SupportsMagicText {
    private static final int CALENDAR_OUTPUT = 4;
    public static final Parcelable.Creator<ShareLocationAction> CREATOR = new g();
    private static final float DESIRED_ACCURACY_METERS = 30.0f;
    private static final int EMAIL_ACTIVITY_REQUEST = 18434;
    private static final int EMAIL_OUTPUT = 3;
    private static final int FACEBOOK_OUTPUT = 1;
    private static final int MAX_LOCATION_OBTAIN_PERIOD_MS = 45000;
    private static final int MAX_TIME_DIFF_MS = 120000;
    public static final int SMS_OUTPUT = 0;
    private static final String TIMEOUT_INTENT = "Timeout";
    private static final int TWITTER_OUTPUT = 2;
    private static final int VARIABLE_OUTPUT = 5;
    private static GoogleApiClient s_googleApiClient;
    private String emailBody;
    private String emailFrom;
    private String emailSubject;
    private final transient android.location.LocationListener locationListenerGPS;
    private final transient android.location.LocationListener locationListenerNetwork;
    private String m_calendarId;
    private String m_email;
    private final transient GmailHelper m_gmailHelper;
    private transient LocationManager m_locationManager;
    private transient Location m_networkLocation;
    private boolean m_oldVariableFormat;
    private int m_outputChannel;
    private int m_simId;
    private Contact m_smsContact;
    private String m_smsNumber;
    private transient PendingIntent m_timeoutPendingIntent;
    private transient TimeOutReceiver m_timeoutReceiver;
    private transient TriggerContextInfo m_triggerContextInfo;
    private transient boolean m_usingGPS;
    private MacroDroidVariable m_variable;
    private transient PowerManager.WakeLock m_wakelock;
    private boolean useSmtpEmail;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class TimeOutReceiver extends BroadcastReceiver {
        protected TimeOutReceiver() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r5, android.content.Intent r6) {
            /*
                r4 = this;
                com.google.android.gms.common.api.GoogleApiClient r5 = com.arlosoft.macrodroid.action.ShareLocationAction.p0()
                if (r5 == 0) goto L11
                com.google.android.gms.location.FusedLocationProviderApi r5 = com.google.android.gms.location.LocationServices.FusedLocationApi     // Catch: java.lang.Exception -> L11
                com.google.android.gms.common.api.GoogleApiClient r6 = com.arlosoft.macrodroid.action.ShareLocationAction.p0()     // Catch: java.lang.Exception -> L11
                com.arlosoft.macrodroid.action.ShareLocationAction r0 = com.arlosoft.macrodroid.action.ShareLocationAction.this     // Catch: java.lang.Exception -> L11
                r5.removeLocationUpdates(r6, r0)     // Catch: java.lang.Exception -> L11
            L11:
                r5 = 1
                r6 = 0
                com.arlosoft.macrodroid.action.ShareLocationAction r0 = com.arlosoft.macrodroid.action.ShareLocationAction.this     // Catch: java.lang.Exception -> L27
                android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L27
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L27
                java.lang.String r1 = "location_mode"
                int r0 = android.provider.Settings.Secure.getInt(r0, r1)     // Catch: java.lang.Exception -> L27
                if (r0 != r5) goto L28
                r0 = 1
                goto L29
            L27:
            L28:
                r0 = 0
            L29:
                if (r0 != 0) goto L4c
                com.arlosoft.macrodroid.action.ShareLocationAction r1 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                android.location.Location r1 = com.arlosoft.macrodroid.action.ShareLocationAction.q0(r1)
                if (r1 == 0) goto L4c
                com.arlosoft.macrodroid.action.ShareLocationAction r5 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                android.location.Location r6 = com.arlosoft.macrodroid.action.ShareLocationAction.q0(r5)
                com.arlosoft.macrodroid.action.ShareLocationAction.s0(r5, r6)
                com.arlosoft.macrodroid.action.ShareLocationAction r5 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                java.lang.Long r5 = r5.getMacroGuid()
                long r5 = r5.longValue()
                java.lang.String r0 = "Share Location TIMEOUT (Using network location)"
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logWarning(r0, r5)
                goto La2
            L4c:
                com.arlosoft.macrodroid.action.ShareLocationAction r1 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                android.content.Context r1 = r1.getContext()
                android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r1)
                java.lang.String r2 = "preferences:share_location_notify_failure"
                boolean r5 = r1.getBoolean(r2, r5)
                if (r5 == 0) goto L81
                com.arlosoft.macrodroid.action.ShareLocationAction r5 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                android.content.Context r5 = r5.getContext()
                com.arlosoft.macrodroid.action.ShareLocationAction r1 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                android.content.Context r1 = r1.getContext()
                r2 = 2131952290(0x7f1302a2, float:1.9541019E38)
                java.lang.String r1 = r1.getString(r2)
                com.arlosoft.macrodroid.action.ShareLocationAction r2 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                android.content.Context r2 = r2.getContext()
                r3 = 2131952289(0x7f1302a1, float:1.9541017E38)
                java.lang.String r2 = r2.getString(r3)
                com.arlosoft.macrodroid.common.Util.displayNotification(r5, r1, r2, r6)
            L81:
                if (r0 == 0) goto L93
                com.arlosoft.macrodroid.action.ShareLocationAction r5 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                java.lang.Long r5 = r5.getMacroGuid()
                long r5 = r5.longValue()
                java.lang.String r0 = "Share Location TIMEOUT (No fix available - Sensors only mode set cannot use network info)"
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logWarning(r0, r5)
                goto La2
            L93:
                com.arlosoft.macrodroid.action.ShareLocationAction r5 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                java.lang.Long r5 = r5.getMacroGuid()
                long r5 = r5.longValue()
                java.lang.String r0 = "Share Location TIMEOUT (No fix available)"
                com.arlosoft.macrodroid.logging.systemlog.SystemLog.logWarning(r0, r5)
            La2:
                com.arlosoft.macrodroid.action.ShareLocationAction r5 = com.arlosoft.macrodroid.action.ShareLocationAction.this
                com.arlosoft.macrodroid.action.ShareLocationAction.t0(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.ShareLocationAction.TimeOutReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements MaildroidX.onCompleteCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2571a;

        c(String str) {
            this.f2571a = str;
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public long getTimeout() {
            return 15000L;
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public void onFail(String str) {
            SystemLog.logError("Failed to send location to: " + this.f2571a + ": " + str.replace("\n", ". "), ShareLocationAction.this.getMacroGuid().longValue());
            if (Settings.getEmailNotifyFailure(ShareLocationAction.this.getContext())) {
                Util.displayNotification(ShareLocationAction.this.getContext(), SelectableItem.r(R.string.action_share_location), String.format(SelectableItem.r(R.string.email_failed_to_x), this.f2571a), false);
            }
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public void onSuccess() {
            SystemLog.logInfo("Location sent to: " + this.f2571a);
            if (Settings.getEmailNotifySuccess(ShareLocationAction.this.getContext())) {
                Util.displayNotification(ShareLocationAction.this.getContext(), SelectableItem.r(R.string.action_share_location), String.format(SelectableItem.r(R.string.email_sent_to_x), this.f2571a), false);
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements Parcelable.Creator<ShareLocationAction> {
        g() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ShareLocationAction createFromParcel(Parcel parcel) {
            return new ShareLocationAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ShareLocationAction[] newArray(int i4) {
            return new ShareLocationAction[i4];
        }
    }

    /* synthetic */ ShareLocationAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private synchronized void A0() {
        if (s_googleApiClient == null) {
            GoogleApiClient build = new GoogleApiClient.Builder(getContext()).addApi(LocationServices.API).addOnConnectionFailedListener(this).build();
            s_googleApiClient = build;
            build.connect();
        }
    }

    private void A1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(H0(), this.useSmtpEmail ? 1 : 0, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.nn
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ShareLocationAction.this.l1(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.mm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ShareLocationAction.this.m1(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.nm
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ShareLocationAction.this.n1(dialogInterface);
            }
        });
    }

    @RequiresApi(api = 22)
    private void B0() {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        try {
            activeSubscriptionInfoList = ((SubscriptionManager) getContext().getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 1) {
                F0(activeSubscriptionInfoList);
            }
            itemComplete();
        } catch (SecurityException unused) {
            itemComplete();
        }
    }

    private synchronized void B1() {
        try {
            int i4 = Settings.Secure.getInt(getContext().getContentResolver(), "location_mode");
            String str = "";
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            str = "High Accuracy";
                        }
                    } else {
                        str = "Battery Saving";
                    }
                } else {
                    str = "Sensors Only";
                }
            } else {
                str = "Off";
            }
            SystemLog.logInfo("Location Mode = " + str, getMacroGuid().longValue());
        } catch (Settings.SettingNotFoundException unused) {
        }
        LocationManager locationManager = (LocationManager) getContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
        this.m_locationManager = locationManager;
        this.m_usingGPS = locationManager.isProviderEnabled("gps");
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.ACCESS_COARSE_LOCATION", getName(), true, false);
            return;
        }
        try {
            this.m_locationManager.requestLocationUpdates("network", 0L, 0.0f, this.locationListenerNetwork);
        } catch (Exception unused2) {
            SystemLog.logWarning("Network Provider not available");
        }
        try {
            this.m_locationManager.requestLocationUpdates("gps", 0L, 0.0f, this.locationListenerGPS);
        } catch (Exception unused3) {
            SystemLog.logInfo("GPS Provider not available", getMacroGuid().longValue());
        }
    }

    private void C0() {
        GoogleAccountCredential credentials = this.m_gmailHelper.getCredentials();
        if (credentials.getSelectedAccountName() == null) {
            this.m_gmailHelper.chooseAccount(credentials, getActivity());
        } else {
            q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1() {
        PowerManager.WakeLock wakeLock = this.m_wakelock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.m_wakelock.release();
            }
            this.m_wakelock = null;
        }
        AlarmManager alarmManager = (AlarmManager) MacroDroidApplication.getInstance().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = this.m_timeoutPendingIntent;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
        if (this.m_locationManager == null) {
            this.m_locationManager = (LocationManager) getContext().getSystemService(FirebaseAnalytics.Param.LOCATION);
        }
        try {
            this.m_locationManager.removeUpdates(this.locationListenerGPS);
            this.m_locationManager.removeUpdates(this.locationListenerNetwork);
        } catch (SecurityException unused) {
        }
        try {
            MacroDroidApplication.getInstance().unregisterReceiver(this.m_timeoutReceiver);
        } catch (IllegalArgumentException unused2) {
        }
    }

    private void D0() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, EmailActivity.class);
        intent.putParcelableArrayListExtra("Trigger", this.m_macro.getTriggerList());
        intent.putExtra("From", this.emailFrom);
        intent.putExtra(EmailActivity.ADDRESS_EXTRA, this.m_email);
        intent.putExtra("Subject", I0());
        intent.putExtra("Body", this.emailBody);
        intent.putExtra(EmailActivity.SMTP_MODE_EXTRA, this.useSmtpEmail);
        intent.putExtra(EmailActivity.HIDE_MESSAGE_TEXT_EXTRA, true);
        intent.putExtra("Macro", getMacro());
        intent.putExtra(EmailActivity.SENDING_ATTACHMENT_EXTRA, true);
        activity.startActivityForResult(intent, EMAIL_ACTIVITY_REQUEST);
    }

    private void E0() {
        int i4 = 0;
        String[] strArr = {SelectableItem.r(R.string.select_contact), SelectableItem.r(R.string.select_number)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(getContext().getString(R.string.select_option));
        if (this.m_smsNumber != null) {
            i4 = 1;
        }
        builder.setSingleChoiceItems(strArr, i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShareLocationAction.this.L0(dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.getListView().setFastScrollEnabled(true);
    }

    @RequiresApi(api = 22)
    private void F0(final List<SubscriptionInfo> list) {
        int simSlotIndex;
        CharSequence displayName;
        CharSequence carrierName;
        int subscriptionId;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        for (SubscriptionInfo subscriptionInfo : list) {
            StringBuilder sb = new StringBuilder();
            simSlotIndex = subscriptionInfo.getSimSlotIndex();
            sb.append(simSlotIndex + 1);
            sb.append(" : ");
            displayName = subscriptionInfo.getDisplayName();
            sb.append((Object) displayName);
            sb.append(" - ");
            carrierName = subscriptionInfo.getCarrierName();
            sb.append((Object) carrierName);
            arrayList.add(sb.toString());
            subscriptionId = subscriptionInfo.getSubscriptionId();
            if (subscriptionId == this.m_simId) {
                i4 = i5;
            }
            i5++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.sim_card);
        builder.setSingleChoiceItems((String[]) arrayList.toArray(new String[0]), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.dn
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ShareLocationAction.this.P0(dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.en
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ShareLocationAction.this.Q0(list, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.fn
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ShareLocationAction.this.R0(dialogInterface);
            }
        });
    }

    private void G0() {
        if (Build.VERSION.SDK_INT < 22) {
            itemComplete();
        } else {
            new RxPermissions((FragmentActivity) getActivity()).request("android.permission.READ_PHONE_STATE").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.action.cn
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    ShareLocationAction.this.S0((Boolean) obj);
                }
            });
        }
    }

    private String[] H0() {
        return new String[]{SelectableItem.r(R.string.gmail_account), SelectableItem.r(R.string.smtp_server)};
    }

    private String I0() {
        String str = this.emailSubject;
        if (str != null) {
            return str;
        }
        return SelectableItem.r(R.string.action_share_location);
    }

    private String[] J0() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_sms), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_facebook), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_twitter), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_email), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_calendar), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_variable)};
    }

    private String[] K0() {
        return new String[]{MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_sms), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_twitter), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_email), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_calendar), MacroDroidApplication.getInstance().getString(R.string.action_share_location_option_variable)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            r1();
        } else {
            s1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(DialogInterface dialogInterface, int i4) {
        int i5;
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            i5 = 0;
        } else {
            i5 = checkedItemPosition + 1;
        }
        this.m_outputChannel = i5;
        B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(List list, DialogInterface dialogInterface, int i4) {
        int subscriptionId;
        subscriptionId = ((SubscriptionInfo) list.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition())).getSubscriptionId();
        this.m_simId = subscriptionId;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(EditText editText, RadioButton radioButton, AppCompatDialog appCompatDialog, View view) {
        if (getMacro().findLocalVariableByName(editText.getText().toString()) != null) {
            z1();
            return;
        }
        MacroDroidVariable macroDroidVariable = new MacroDroidVariable(2, editText.getText().toString(), radioButton.isChecked());
        addVariable(macroDroidVariable);
        this.m_variable = macroDroidVariable;
        appCompatDialog.cancel();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(DialogInterface dialogInterface, int i4) {
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0(EditText editText, DialogInterface dialogInterface, int i4) {
        this.m_email = editText.getText().toString();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(List list, DialogInterface dialogInterface, int i4) {
        this.m_smsContact = (Contact) list.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(DialogInterface dialogInterface, int i4) {
        this.m_smsNumber = null;
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(EditText editText, AppCompatDialog appCompatDialog, View view) {
        this.m_smsNumber = editText.getText().toString();
        appCompatDialog.dismiss();
        G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f1(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), true, true, true, R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            E0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(List list, DialogInterface dialogInterface, int i4) {
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition > 0) {
            this.m_variable = (MacroDroidVariable) list.get(checkedItemPosition - 1);
            itemComplete();
            return;
        }
        o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(DialogInterface dialogInterface, int i4) {
        boolean z3;
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_oldVariableFormat = z3;
        u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m1(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            this.useSmtpEmail = false;
            C0();
            return;
        }
        this.useSmtpEmail = true;
        D0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n1(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private void o1() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.enter_new_variable_name_dialog);
        appCompatDialog.setTitle(R.string.action_share_location_new_variable);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_new_variable_name_dialog_variable_name);
        final RadioButton radioButton = (RadioButton) appCompatDialog.findViewById(R.id.radio_button_local);
        button.setEnabled(false);
        editText.addTextChangedListener(new f(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.xm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareLocationAction.this.T0(editText, radioButton, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ym
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        appCompatDialog.show();
    }

    private void p1() {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT >= 23) {
            checkSelfPermission = getContext().checkSelfPermission("android.permission.READ_CALENDAR");
            if (checkSelfPermission != 0) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{"android.permission.READ_CALENDAR"}, 34);
                return;
            }
        }
        Pair<String, List<CalendarInfo>> allCalendars = CalendarInfo.getAllCalendars(getContext());
        String str = allCalendars.first;
        List<CalendarInfo> list = allCalendars.second;
        if (list.size() == 0) {
            ToastCompat.makeText(getContext().getApplicationContext(), (CharSequence) getContext().getString(R.string.action_add_calendar_event_no_calendars), 1).show();
            return;
        }
        if (this.m_calendarId == null) {
            this.m_calendarId = str;
        }
        int i4 = 0;
        while (true) {
            if (i4 < list.size()) {
                if (list.get(i4).id.equals(this.m_calendarId)) {
                    break;
                }
                i4++;
            } else {
                i4 = 0;
                break;
            }
        }
        Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(getContext().getString(R.string.action_share_location_send_select_calendar));
        Spinner spinner = new Spinner(activity);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
        if (list.size() >= 1) {
            spinner.setVisibility(0);
            CalendarArrayAdapter calendarArrayAdapter = new CalendarArrayAdapter(activity, list);
            calendarArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter((SpinnerAdapter) calendarArrayAdapter);
            spinner.setSelection(i4);
        }
        spinner.setOnItemSelectedListener(new e(list));
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.om
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShareLocationAction.this.V0(dialogInterface, i5);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.pm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShareLocationAction.W0(dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.setView(spinner, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, 0);
        create.show();
    }

    private void q1() {
        final Activity activity = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(getContext().getString(R.string.action_share_location_send_via_email));
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        Button button = new Button(activity);
        button.setText("...");
        button.setPadding(0, 0, 0, 0);
        button.setTextColor(ContextCompat.getColor(activity, R.color.default_text_color_inverse));
        ViewCompat.setBackgroundTintList(button, ColorStateList.valueOf(ContextCompat.getColor(activity, R.color.actions_accent)));
        final EditText editText = new EditText(new ContextThemeWrapper(activity, m()));
        editText.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.alert_dialog_input_min_width));
        editText.setInputType(32);
        editText.setHint(getContext().getString(R.string.action_share_location_enter_email));
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin);
        String str = this.m_email;
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.length());
        }
        editText.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);
        linearLayout.addView(button);
        button.getLayoutParams().width = activity.getResources().getDimensionPixelSize(R.dimen.special_text_button_width);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.hn
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ShareLocationAction.this.X0(editText, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.in
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ShareLocationAction.Y0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
        layoutParams2.copyFrom(create.getWindow().getAttributes());
        layoutParams2.width = -1;
        create.getWindow().setAttributes(layoutParams2);
        create.setView(linearLayout, dimensionPixelOffset, dimensionPixelSize, dimensionPixelOffset, 0);
        create.show();
        Button button2 = create.getButton(-1);
        button2.setEnabled(Util.isValidEmailAddress(editText.getText().toString()));
        editText.addTextChangedListener(new d(button2));
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.jn
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ShareLocationAction.Z0(editText, magicTextPair);
            }
        };
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.kn
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareLocationAction.this.a1(activity, magicTextListener, view);
            }
        });
    }

    private void r1() {
        Activity activity = getActivity();
        final List<Contact> contacts = Util.getContacts(activity);
        boolean z3 = true;
        boolean z4 = true;
        for (Trigger trigger : s()) {
            if (!(trigger instanceof IncomingSMSTrigger)) {
                z3 = false;
            }
            if (!(trigger instanceof IncomingCallTrigger)) {
                z4 = false;
            }
        }
        if (z3) {
            contacts.add(0, new Contact(Contact.INCOMING_CONTACT_ID, getContext().getString(R.string.select_incoming_sms_num), Contact.INCOMING_CONTACT_ID));
        } else if (z4) {
            contacts.add(0, new Contact(Contact.INCOMING_CONTACT_ID, getContext().getString(R.string.select_incoming_call_num), Contact.INCOMING_CONTACT_ID));
        }
        Contact[] contactArr = new Contact[contacts.size()];
        contacts.toArray(contactArr);
        int size = contacts.size();
        String[] strArr = new String[size];
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            strArr[i5] = contactArr[i5].getName();
            Contact contact = this.m_smsContact;
            if (contact != null && contact.getName().equals(strArr[i5])) {
                i4 = i5;
            }
        }
        if (this.m_smsContact == null && contacts.size() > 0) {
            this.m_smsContact = contacts.get(0);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
        builder.setTitle(getContext().getString(R.string.select_contact));
        builder.setSingleChoiceItems(strArr, i4, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.zm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ShareLocationAction.this.b1(contacts, dialogInterface, i6);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.an
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ShareLocationAction.this.c1(dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.getListView().setFastScrollEnabled(true);
    }

    private void s1() {
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.dialog_sms_number);
        appCompatDialog.setTitle(R.string.select_number);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.sms_number);
        editText.setText(this.m_smsNumber);
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareLocationAction.this.d1(editText, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.tm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.um
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                ShareLocationAction.f1(editText, magicTextPair);
            }
        };
        ((Button) appCompatDialog.findViewById(R.id.magic_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vm
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareLocationAction.this.g1(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    private void t1() {
        new RxPermissions((FragmentActivity) getActivity()).request("android.permission.SEND_SMS").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.action.mn
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ShareLocationAction.this.h1((Boolean) obj);
            }
        });
    }

    private void u1() {
        final ArrayList<MacroDroidVariable> allInputStringVariables = getAllInputStringVariables();
        String[] strArr = new String[allInputStringVariables.size() + 1];
        int i4 = 0;
        strArr[0] = SelectableItem.r(R.string.new_variable);
        int i5 = 0;
        while (i4 < allInputStringVariables.size()) {
            int i6 = i4 + 1;
            strArr[i6] = allInputStringVariables.get(i4).getName();
            MacroDroidVariable macroDroidVariable = this.m_variable;
            if (macroDroidVariable != null && macroDroidVariable.getName().equals(strArr[i6])) {
                i5 = i6;
            }
            i4 = i6;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.action_set_variable_select);
        builder.setSingleChoiceItems(strArr, i5, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                ShareLocationAction.this.i1(allInputStringVariables, dialogInterface, i7);
            }
        });
        builder.create().show();
    }

    private void v1() {
        String[] strArr = {SelectableItem.r(R.string.lat_lon), SelectableItem.r(R.string.google_maps_link)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.select_format);
        builder.setSingleChoiceItems(strArr, 1 ^ (this.m_oldVariableFormat ? 1 : 0), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ln
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ShareLocationAction.this.j1(dialogInterface, i4);
            }
        });
        builder.create().show();
    }

    private void w1(String str, String str2, String str3, String str4) {
        SmtpServerConfig smtpServerConfig = com.arlosoft.macrodroid.settings.Settings.getSmtpServerConfig(getContext());
        if (!smtpServerConfig.isValid()) {
            SystemLog.logError("Failed to share location via email to: " + this.m_email + ". SMTP Configuration is invalid", getMacroGuid().longValue());
            return;
        }
        MaildroidX.Builder builder = new MaildroidX.Builder().smtp(smtpServerConfig.getServerAddress()).smtpUsername(smtpServerConfig.getUsername()).smtpPassword(smtpServerConfig.getPassword()).port(smtpServerConfig.getServerPort()).isStartTLSEnabled(smtpServerConfig.getStartTlsEnabled()).type(MaildroidXType.PLAIN).to(str2);
        if (str == null) {
            str = "";
        }
        builder.from(str).subject(str3).body(str4).onCompleteCallback(new c(str2)).mail();
    }

    private void x1(Location location) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.#######", decimalFormatSymbols);
        String str = Util.GOOGLE_MAPS_HEADING + location.getLatitude() + "," + location.getLongitude() + "&center=" + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
        if (this.m_smsNumber != null) {
            SMSOutputService2.sendMessage(getContext(), str, MagicText.replaceMagicText(getContext().getApplicationContext(), this.m_smsNumber, this.m_triggerContextInfo, getMacro()), false, 1, this.m_simId);
            return;
        }
        Contact contact = this.m_smsContact;
        if (contact != null && contact.getId() != null && contact.getId().equals(Contact.INCOMING_CONTACT_ID)) {
            TriggerContextInfo triggerContextInfo = this.m_triggerContextInfo;
            if (triggerContextInfo != null && triggerContextInfo.getIncomingSMSData() != null) {
                contact.setNumber(this.m_triggerContextInfo.getIncomingSMSData().getFromNumber());
            } else {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("m_triggerContextInfo is invalid in ShareLocationAction"));
            }
        }
        SMSOutputService2.sendMessage(getContext(), str, contact, null, false, 1, this.m_simId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(Location location) {
        String str;
        Date date = new Date(location.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SystemLog.logInfo("Share location obtained: " + simpleDateFormat.format((Object) date) + " provider=" + location.getProvider() + ", Accuracy = " + location.getAccuracy(), getMacroGuid().longValue());
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.#######", decimalFormatSymbols);
        int i4 = this.m_outputChannel;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5 && this.m_variable != null) {
                                if (this.m_oldVariableFormat) {
                                    str = location.getLatitude() + "," + location.getLongitude();
                                } else {
                                    str = Util.GOOGLE_MAPS_HEADING + location.getLatitude() + "," + location.getLongitude() + "&center=" + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
                                }
                                MacroDroidVariable variableByName = getVariableByName(this.m_variable.getName());
                                if (variableByName != null) {
                                    variableUpdate(variableByName, new VariableValue.StringValue(str, null));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (ContextCompat.checkSelfPermission(getContext(), "android.permission.WRITE_CALENDAR") != 0) {
                            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.WRITE_CALENDAR", getContext().getString(R.string.action_share_location), true, false);
                            return;
                        } else {
                            CalendarHelper.addToCalendar(getContext(), this.m_calendarId, getContext().getString(R.string.action_share_location_location) + ": " + location.getLatitude() + "," + location.getLongitude(), Util.GOOGLE_MAPS_HEADING + location.getLatitude() + "," + location.getLongitude() + "&center=" + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude()), System.currentTimeMillis() - 10000, 0L, false, 1);
                            return;
                        }
                    }
                    String replaceMagicText = MagicText.replaceMagicText(getContext().getApplicationContext(), this.m_email, this.m_triggerContextInfo, getMacro());
                    String str2 = Util.GOOGLE_MAPS_HEADING + location.getLatitude() + "," + location.getLongitude() + "&center=" + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
                    if (this.useSmtpEmail) {
                        w1(MagicText.replaceMagicText(getContext(), this.emailFrom, this.m_triggerContextInfo, getMacro()), replaceMagicText, MagicText.replaceMagicText(getContext(), I0(), this.m_triggerContextInfo, getMacro()), str2);
                        return;
                    }
                    Intent intent = new Intent(getContext(), UploadLocationService.class);
                    intent.putExtra(UploadService.EXTRA_UPLOAD_SITE, UploadService.UPLOAD_EMAIL);
                    intent.putExtra(UploadLocationService.EXTRA_LOCATION_MESSAGE, str2);
                    intent.putExtra(UploadService.EXTRA_UPLOAD_EMAIL_ADDRESS, replaceMagicText);
                    getContext().startService(intent);
                    return;
                }
                String str3 = DateFormat.getDateFormat(getContext()).format(new Date()) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + DateFormat.getTimeFormat(getContext()).format(new Date()) + " - " + Util.GOOGLE_MAPS_HEADING + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
                Intent intent2 = new Intent(getContext(), UploadLocationService.class);
                intent2.putExtra(UploadService.EXTRA_UPLOAD_SITE, UploadService.UPLOAD_TWITTER);
                intent2.putExtra(UploadLocationService.EXTRA_LOCATION_MESSAGE, str3);
                getContext().startService(intent2);
                return;
            }
            String str4 = getContext().getString(R.string.action_share_location_facebook_message) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Util.GOOGLE_MAPS_HEADING + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
            Intent intent3 = new Intent(getContext(), UploadLocationService.class);
            intent3.putExtra(UploadService.EXTRA_UPLOAD_SITE, UploadService.UPLOAD_FACEBOOK);
            intent3.putExtra(UploadLocationService.EXTRA_LOCATION_MESSAGE, str4);
            getContext().startService(intent3);
        } else if (ContextCompat.checkSelfPermission(getContext(), "android.permission.SEND_SMS") != 0) {
            SystemLog.logError("Share location failed - needs SMS permission", getMacroGuid().longValue());
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.SEND_SMS", null, true, false);
        } else {
            x1(location);
        }
    }

    private void z1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Variables);
        builder.setTitle(R.string.variable_creation_failed);
        builder.setMessage(R.string.variable_already_exists);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.bn
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        boolean z3 = true;
        if (this.m_outputChannel != 0 || this.m_smsNumber != null) {
            return true;
        }
        Contact contact = this.m_smsContact;
        if (contact != null && (contact.getName().equals(Contact.getIncomingSmsContactName()) || this.m_smsContact.getId() == Contact.INCOMING_CONTACT_ID || this.m_smsContact.getId() == Contact.LAST_NUMBER_CALLED_CONTACT_ID)) {
            return true;
        }
        Contact contact2 = this.m_smsContact;
        if (contact2 != null && contact2.getName().equals(Contact.getIncomingCallNumContactName())) {
            return true;
        }
        List<Contact> contacts = Util.getContacts(getContext());
        if (this.m_smsContact != null) {
            for (Contact contact3 : contacts) {
                if (contact3.getName().equals(this.m_smsContact.getName())) {
                    this.m_smsContact = contact3;
                    break;
                }
            }
        }
        z3 = false;
        if (!z3) {
            this.m_smsContact = new Contact(Contact.SELECT_CONTACT_ID, Contact.getSelectContactString(), Contact.INCOMING_CONTACT_ID);
        }
        return z3;
    }

    @Override // com.arlosoft.macrodroid.action.Action
    protected void doEnable() {
        A0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_outputChannel;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        MacroDroidVariable macroDroidVariable;
        int i4 = this.m_outputChannel;
        if (i4 == 0) {
            if (this.m_smsNumber != null) {
                return getContext().getString(R.string.action_share_location_send_to) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_smsNumber;
            } else if (this.m_smsContact == null) {
                return "";
            } else {
                return getContext().getString(R.string.action_share_location_send_to) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_smsContact.getName();
            }
        } else if (i4 == 3 && this.m_email != null) {
            return getContext().getString(R.string.action_share_location_send_to) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.m_email;
        } else if (i4 == 5 && (macroDroidVariable = this.m_variable) != null) {
            return macroDroidVariable.getName();
        } else {
            if (i4 != 4) {
                return "";
            }
            return SelectableItem.r(R.string.action_share_location_option_calendar);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ShareLocationActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_CONTACTS", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_email, this.m_smsNumber};
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    public MacroDroidVariable getVariable() {
        return this.m_variable;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1 && intent != null) {
            if (i4 == 1000) {
                if (this.m_gmailHelper.handleActivityResult(i4, i5, intent)) {
                    q1();
                }
            } else if (i4 == EMAIL_ACTIVITY_REQUEST) {
                this.emailFrom = intent.getExtras().getString("From");
                this.m_email = intent.getExtras().getString(EmailActivity.ADDRESS_EXTRA);
                this.emailBody = intent.getExtras().getString("Body");
                this.emailSubject = intent.getExtras().getString("Subject");
                itemComplete();
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:sharelocationaction");
        this.m_wakelock = newWakeLock;
        newWakeLock.acquire();
        this.m_networkLocation = null;
        this.m_triggerContextInfo = triggerContextInfo;
        B1();
        AlarmManager alarmManager = (AlarmManager) MacroDroidApplication.getInstance().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = this.m_timeoutPendingIntent;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
        MacroDroidApplication.getInstance().registerReceiver(this.m_timeoutReceiver, new IntentFilter(TIMEOUT_INTENT));
        this.m_timeoutPendingIntent = PendingIntent.getBroadcast(MacroDroidApplication.getInstance(), 0, new Intent(TIMEOUT_INTENT), 134217728 | PendingIntentHelper.FLAG_IMMUTABLE);
        alarmManager.set(0, System.currentTimeMillis() + 45000, this.m_timeoutPendingIntent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if (this.m_outputChannel != 0 || this.m_smsNumber != null) {
            return true;
        }
        Contact contact = this.m_smsContact;
        if (contact == null) {
            return false;
        }
        if (contact.getId().equals(Contact.INCOMING_CONTACT_ID) && !this.m_macro.hasOnlyTrigger(IncomingSMSTrigger.class) && !this.m_macro.hasOnlyTrigger(IncomingCallTrigger.class)) {
            return false;
        }
        return !this.m_smsContact.getId().equals(Contact.SELECT_CONTACT_ID);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void kill() {
        C1();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    protected AlertDialog l() {
        int i4 = this.m_outputChannel;
        if (i4 >= 1) {
            i4--;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(K0(), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.lm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShareLocationAction.this.M0(dialogInterface, i5);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wm
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                ShareLocationAction.this.N0(dialogInterface, i5);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.gn
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ShareLocationAction.this.O0(dialogInterface);
            }
        });
        return create;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return J0();
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        SystemLog.logError("Connection to Google Play services failed", getMacroGuid().longValue());
        C1();
    }

    @Override // com.google.android.gms.location.LocationListener
    public synchronized void onLocationChanged(Location location) {
        SystemLog.logInfo("Found fused location - sharing now", getMacroGuid().longValue());
        y1(location);
        C1();
        try {
            LocationServices.FusedLocationApi.removeLocationUpdates(s_googleApiClient, this);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.action_share_location_select_output);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Activity activity = getActivity();
        int i4 = this.m_outputChannel;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                v1();
                                return;
                            }
                            return;
                        }
                        p1();
                        return;
                    }
                    A1();
                    return;
                } else if (!TwitterOutput.isTwitterAccountConfigured(activity)) {
                    TwitterOutput.setupTwitter(activity, this);
                    return;
                } else {
                    itemComplete();
                    return;
                }
            } else if (com.arlosoft.macrodroid.settings.Settings.getFacebookAuthToken(getContext()) != null) {
                itemComplete();
                return;
            } else {
                return;
            }
        }
        t1();
    }

    public void setOutputChannel(int i4) {
        this.m_outputChannel = i4;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_email = strArr[0];
            this.m_smsNumber = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    public void setSMSIncomingContact() {
        this.m_smsContact = new Contact(Contact.INCOMING_CONTACT_ID, SelectableItem.r(R.string.select_incoming_sms_num), Contact.INCOMING_CONTACT_ID);
    }

    @Override // com.arlosoft.macrodroid.action.outputservices.TwitterOutput.TwitterAuthListener
    public void twitterAuthOK() {
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_outputChannel);
        parcel.writeParcelable(this.m_smsContact, i4);
        parcel.writeString(this.m_smsNumber);
        parcel.writeString(this.m_email);
        parcel.writeString(this.m_calendarId);
        parcel.writeParcelable(this.m_variable, i4);
        parcel.writeInt(this.m_oldVariableFormat ? 1 : 0);
        parcel.writeInt(this.m_simId);
        parcel.writeString(this.emailSubject);
        parcel.writeString(this.emailBody);
        parcel.writeString(this.emailFrom);
        parcel.writeInt(this.useSmtpEmail ? 1 : 0);
    }

    public ShareLocationAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ShareLocationAction() {
        this.m_timeoutReceiver = new TimeOutReceiver();
        this.locationListenerGPS = new a();
        this.locationListenerNetwork = new b();
        this.m_outputChannel = 0;
        this.m_email = "";
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
    }

    private ShareLocationAction(Parcel parcel) {
        super(parcel);
        this.m_timeoutReceiver = new TimeOutReceiver();
        this.locationListenerGPS = new a();
        this.locationListenerNetwork = new b();
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
        this.m_outputChannel = parcel.readInt();
        this.m_smsContact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_smsNumber = parcel.readString();
        this.m_email = parcel.readString();
        this.m_calendarId = parcel.readString();
        this.m_variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_oldVariableFormat = parcel.readInt() != 0;
        this.m_simId = parcel.readInt();
        this.emailSubject = parcel.readString();
        this.emailBody = parcel.readString();
        this.emailFrom = parcel.readString();
        this.useSmtpEmail = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements android.location.LocationListener {
        a() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            SystemLog.logInfo("Found GPS location - sharing now", ShareLocationAction.this.getMacroGuid().longValue());
            ShareLocationAction.this.y1(location);
            ShareLocationAction.this.C1();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
        }
    }

    /* loaded from: classes2.dex */
    class b implements android.location.LocationListener {
        b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            long abs = Math.abs(System.currentTimeMillis() - location.getTime());
            if (abs > 120000) {
                SystemLog.logError("Rejecting network fix as it is too old: " + (abs / 1000) + "s", ShareLocationAction.this.getMacroGuid().longValue());
            } else if (ShareLocationAction.this.m_usingGPS) {
                if (location.hasAccuracy() && location.getAccuracy() < 30.0f) {
                    SystemLog.logInfo("Found accurate network based location - sharing now", ShareLocationAction.this.getMacroGuid().longValue());
                    ShareLocationAction.this.y1(location);
                    ShareLocationAction.this.C1();
                    return;
                }
                SystemLog.logInfo("Found network based location - storing", ShareLocationAction.this.getMacroGuid().longValue());
                ShareLocationAction.this.m_networkLocation = location;
            } else {
                SystemLog.logInfo("Found network location - sharing now", ShareLocationAction.this.getMacroGuid().longValue());
                ShareLocationAction.this.y1(location);
                ShareLocationAction.this.C1();
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f2575a;

        e(List list) {
            this.f2575a = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            ShareLocationAction.this.m_calendarId = ((CalendarInfo) this.f2575a.get(i4)).id;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y0(DialogInterface dialogInterface, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2573a;

        d(Button button) {
            this.f2573a = button;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2573a;
            if (!editable.toString().contains("[") && !Util.isValidEmailAddress(editable.toString())) {
                z3 = false;
            } else {
                z3 = true;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2577a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2578b;

        f(Button button, EditText editText) {
            this.f2577a = button;
            this.f2578b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2577a;
            if (this.f2578b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
