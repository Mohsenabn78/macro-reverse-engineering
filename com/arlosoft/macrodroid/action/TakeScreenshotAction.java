package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.provider.MediaStore;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import co.nedim.maildroidx.MaildroidX;
import co.nedim.maildroidx.MaildroidXType;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.EmailActivity;
import com.arlosoft.macrodroid.action.info.TakeScreenshotActionInfo;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.action.services.UploadPhotoService;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.SmtpServerConfig;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;
import com.arlosoft.macrodroid.utils.GPS;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class TakeScreenshotAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<TakeScreenshotAction> CREATOR = new c();
    private static final int EMAIL_ACTIVITY_REQUEST = 18434;
    private static final int SAVE_TO_DEVICE = 0;
    private static final int SEND_VIA_EMAIL = 1;
    private static final int SHARE_VIA_INTENT = 2;
    private static int s_actionCounter;
    private static ContentObserver s_contentObserver;
    private String emailBody;
    private String emailFrom;
    private String emailSubject;
    private transient boolean handeNextImageUpdate;
    private transient int hiddenMechanismCount;
    private transient TriggerContextInfo latestTriggerContextInfo;
    private String m_email;
    private final transient GmailHelper m_gmailHelper;
    private int m_mechanismOption;
    private int m_option;
    private boolean saveToJpeg;
    private transient int temporaryMechanismOption;
    private boolean useSmtpEmail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends ContentObserver {
        a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3, final Uri uri) {
            new Handler().postDelayed(new Runnable() { // from class: com.arlosoft.macrodroid.action.yp
                @Override // java.lang.Runnable
                public final void run() {
                    TakeScreenshotAction.handleImageUpdate(uri);
                }
            }, 1000L);
            super.onChange(z3, uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements MaildroidX.onCompleteCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2627a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2628b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f2629c;

        b(String str, Context context, long j4) {
            this.f2627a = str;
            this.f2628b = context;
            this.f2629c = j4;
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public long getTimeout() {
            return 15000L;
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public void onFail(String str) {
            SystemLog.logError("Failed to send photo to: " + this.f2627a + ": " + str.replace("\n", ". "), this.f2629c);
            if (Settings.getEmailNotifyFailure(this.f2628b)) {
                Util.displayNotification(this.f2628b, SelectableItem.r(R.string.action_upload_photo), String.format(SelectableItem.r(R.string.email_failed_to_x), this.f2627a), false);
            }
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public void onSuccess() {
            SystemLog.logInfo("Photo sent to: " + this.f2627a);
            if (Settings.getEmailNotifySuccess(this.f2628b)) {
                Util.displayNotification(this.f2628b, SelectableItem.r(R.string.action_upload_photo), String.format(SelectableItem.r(R.string.email_sent_to_x), this.f2627a), false);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements Parcelable.Creator<TakeScreenshotAction> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TakeScreenshotAction createFromParcel(Parcel parcel) {
            return new TakeScreenshotAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TakeScreenshotAction[] newArray(int i4) {
            return new TakeScreenshotAction[i4];
        }
    }

    /* synthetic */ TakeScreenshotAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void X() {
        GoogleAccountCredential credentials = this.m_gmailHelper.getCredentials();
        if (credentials.getSelectedAccountName() == null) {
            this.m_gmailHelper.chooseAccount(credentials, getActivity());
        } else {
            p0();
        }
    }

    private void Y() {
        p0();
    }

    private void Z() {
        if (checkActivityAlive()) {
            Activity activity = getActivity();
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
            builder.setTitle(p());
            builder.setSingleChoiceItems(c0(), this.m_mechanismOption, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.up
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    TakeScreenshotAction.this.d0(dialogInterface, i4);
                }
            });
            builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vp
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    TakeScreenshotAction.this.e0(dialogInterface, i4);
                }
            });
            AlertDialog create = builder.create();
            create.show();
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.wp
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    TakeScreenshotAction.this.f0(dialogInterface);
                }
            });
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.try_alternative_mechanism, 1).show();
        }
    }

    private String[] a0() {
        return new String[]{SelectableItem.r(R.string.gmail_account), SelectableItem.r(R.string.smtp_server)};
    }

    private String b0() {
        String str = this.emailSubject;
        if (str != null) {
            return str;
        }
        return SelectableItem.r(R.string.sharing_photo_default_email_subject);
    }

    private String[] c0() {
        return new String[]{SelectableItem.r(R.string.mechanism) + " 1", SelectableItem.r(R.string.mechanism) + " 2", SelectableItem.r(R.string.mechanism) + " 3", SelectableItem.r(R.string.mechanism) + " 4"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(DialogInterface dialogInterface, int i4) {
        this.temporaryMechanismOption = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(DialogInterface dialogInterface, int i4) {
        this.m_mechanismOption = this.temporaryMechanismOption;
        int i5 = this.m_option;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    itemComplete();
                    return;
                }
                return;
            }
            q0();
            return;
        }
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            this.saveToJpeg = true;
            ToastCompat.makeText(getContext(), (CharSequence) "Save to JPEG Enabled", 0).show();
        }
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.action_take_screenshot_save), SelectableItem.r(R.string.send_via_email), SelectableItem.r(R.string.action_take_screenshot_intent)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    public static void handleImageUpdate(Uri uri) {
        if (uri == null) {
            return;
        }
        MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action next = it.next();
                if (next instanceof TakeScreenshotAction) {
                    TakeScreenshotAction takeScreenshotAction = (TakeScreenshotAction) next;
                    if (takeScreenshotAction.getHandleNextImageUpdate()) {
                        if (takeScreenshotAction.getSaveToJpeg()) {
                            k0(uri, macroDroidApplication, takeScreenshotAction);
                        } else {
                            int option = takeScreenshotAction.getOption();
                            if (option != 1) {
                                if (option == 2) {
                                    o0(null, uri, macroDroidApplication);
                                }
                            } else {
                                n0(takeScreenshotAction.getMacro(), null, uri, macroDroidApplication, takeScreenshotAction.getEmailAddress(), takeScreenshotAction.getEmailFrom(), takeScreenshotAction.getSubject(), takeScreenshotAction.getEmailBody(), takeScreenshotAction.getUseSmtpEmail(), takeScreenshotAction.getLatestTriggerContextInfo());
                            }
                        }
                        takeScreenshotAction.setHandleNextImageUpdate(false);
                        takeScreenshotAction.setLatestTriggerContextInfo(null);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            this.useSmtpEmail = false;
            X();
            return;
        }
        this.useSmtpEmail = true;
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private static void k0(Uri uri, Context context, Action action) {
        try {
            Location location = null;
            Cursor query = MediaStore.Images.Media.query(context.getContentResolver(), uri, null);
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("title"));
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            File file = new File(context.getExternalFilesDir(null), "ScreenShots");
            File file2 = new File(file.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + string + ".jpg");
            if (!file.exists() && !file.mkdirs()) {
                Util.displayNotification(context, SelectableItem.r(R.string.action_take_screenshot_failed), SelectableItem.r(R.string.action_take_screenshot_write_error), false);
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.close();
            context.getContentResolver().delete(uri, null, null);
            LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
            List<String> providers = locationManager.getProviders(true);
            if (providers != null) {
                for (String str : providers) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                    if (lastKnownLocation != null && (location == null || lastKnownLocation.getTime() > location.getTime())) {
                        location = lastKnownLocation;
                    }
                }
            }
            if (location != null) {
                ExifInterface exifInterface = new ExifInterface(file2.getAbsolutePath());
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, GPS.convert(location.getLatitude()));
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, GPS.latitudeRef(location.getLatitude()));
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, GPS.convert(location.getLongitude()));
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, GPS.longitudeRef(location.getLongitude()));
                exifInterface.saveAttributes();
            }
        } catch (Exception e4) {
            SystemLog.logError("Take Screenshot failure: " + e4.toString(), action.getMacroGuid().longValue());
        }
    }

    private String l0() {
        File file;
        try {
            int i4 = this.m_mechanismOption;
            if (i4 != 0 && i4 != 1) {
                if (i4 != 2 && i4 != 3) {
                    file = null;
                } else {
                    file = new File("/storage/emulated/legacy", "MacroDroid/Screenshots");
                }
            } else {
                file = new File(Environment.getExternalStorageDirectory(), "MacroDroid/Screenshots");
            }
            if (!file.exists() && !file.mkdirs()) {
                Util.displayNotification(getContext(), SelectableItem.r(R.string.action_take_screenshot_failed), SelectableItem.r(R.string.action_take_screenshot_write_error), false);
                return null;
            }
            String str = file.getCanonicalPath() + RemoteSettings.FORWARD_SLASH_STRING + (new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss").format(new Date()) + ".png");
            int i5 = this.m_mechanismOption;
            if (i5 != 0 && i5 != 2) {
                if (i5 == 1 || i5 == 3) {
                    Util.runAsRoot(new String[]{"/system/bin/screencap -p " + str});
                }
            } else {
                Util.runAsNonRoot(new String[]{"/system/bin/screencap -p " + str});
            }
            return str;
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to take a screenshot: " + e4.getMessage()));
            Util.displayNotification(getContext(), SelectableItem.r(R.string.action_take_screenshot_failed), e4.getMessage(), false);
            return null;
        }
    }

    private static void m0(Context context, String str, String str2, String str3, String str4, long j4) {
        SmtpServerConfig smtpServerConfig = Settings.getSmtpServerConfig(context);
        if (!smtpServerConfig.isValid()) {
            SystemLog.logError("Failed to share photo via email to: " + str2 + ". SMTP Configuration is invalid", j4);
            return;
        }
        String lastPhotoPath = Util.getLastPhotoPath(context);
        if (lastPhotoPath == null) {
            SystemLog.logError("Failed to share photo via email to: " + str2 + ". No photo found.", j4);
            return;
        }
        MaildroidX.Builder builder = new MaildroidX.Builder().smtp(smtpServerConfig.getServerAddress()).smtpUsername(smtpServerConfig.getUsername()).smtpPassword(smtpServerConfig.getPassword()).port(smtpServerConfig.getServerPort()).isStartTLSEnabled(smtpServerConfig.getStartTlsEnabled()).type(MaildroidXType.PLAIN).to(str2);
        if (str == null) {
            str = "";
        }
        builder.from(str).subject(str3).body(str4).attachment(lastPhotoPath).onCompleteCallback(new b(str2, context, j4)).mail();
    }

    private static void n0(Macro macro, String str, Uri uri, Context context, String str2, String str3, String str4, String str5, boolean z3, TriggerContextInfo triggerContextInfo) {
        String str6;
        String replaceMagicText = MagicText.replaceMagicText(context, str2, triggerContextInfo, macro);
        String replaceMagicText2 = MagicText.replaceMagicText(context, str4, triggerContextInfo, macro);
        if (str5 != null) {
            str6 = str5;
        } else {
            str6 = "";
        }
        MagicText.replaceMagicText(context, str6, triggerContextInfo, macro);
        if (z3) {
            m0(context, MagicText.replaceMagicText(context, str3, triggerContextInfo, macro), replaceMagicText, replaceMagicText2, str5, macro.getGUID());
            return;
        }
        Intent intent = new Intent(context, UploadPhotoService.class);
        intent.putExtra(UploadService.EXTRA_UPLOAD_SITE, UploadService.UPLOAD_EMAIL);
        intent.putExtra(UploadService.EXTRA_UPLOAD_EMAIL_ADDRESS, replaceMagicText);
        intent.putExtra("Subject", str4);
        intent.putExtra("Body", str5);
        if (str != null) {
            intent.putExtra(UploadPhotoService.EXTRA_PHOTO_FILE, str);
        }
        if (uri != null) {
            intent.putExtra(UploadPhotoService.EXTRA_PHOTO_URI, uri);
        }
        context.startService(intent);
    }

    private static void o0(String str, Uri uri, Context context) {
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/png");
        if (uri == null && str != null) {
            uri = Uri.fromFile(new File(str));
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.addFlags(1);
        context.startActivity(Intent.createChooser(intent, SelectableItem.r(R.string.action_take_screenshot_share)).addFlags(268435456));
    }

    private void p0() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, EmailActivity.class);
        intent.putParcelableArrayListExtra("Trigger", this.m_macro.getTriggerList());
        intent.putExtra("From", this.emailFrom);
        intent.putExtra(EmailActivity.ADDRESS_EXTRA, this.m_email);
        intent.putExtra("Subject", b0());
        intent.putExtra("Body", this.emailBody);
        intent.putExtra(EmailActivity.SMTP_MODE_EXTRA, this.useSmtpEmail);
        intent.putExtra("Macro", getMacro());
        intent.putExtra(EmailActivity.SENDING_ATTACHMENT_EXTRA, true);
        activity.startActivityForResult(intent, EMAIL_ACTIVITY_REQUEST);
    }

    private void q0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(a0(), this.useSmtpEmail ? 1 : 0, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TakeScreenshotAction.this.h0(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.sp
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                TakeScreenshotAction.this.i0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.tp
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                TakeScreenshotAction.this.j0(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = i4;
        if (Build.VERSION.SDK_INT >= 28) {
            int i5 = this.hiddenMechanismCount + 1;
            this.hiddenMechanismCount = i5;
            if (i5 > 5) {
                new RxPermissions((FragmentActivity) getActivity()).request("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION").observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.arlosoft.macrodroid.action.xp
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        TakeScreenshotAction.this.g0((Boolean) obj);
                    }
                });
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void doDisable() {
        int i4 = s_actionCounter - 1;
        s_actionCounter = i4;
        if (i4 == 0 && s_contentObserver != null) {
            MacroDroidApplication.getInstance().getContentResolver().unregisterContentObserver(s_contentObserver);
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void doEnable() {
        if (s_actionCounter == 0) {
            s_contentObserver = new a(new Handler());
            MacroDroidApplication.getInstance().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, s_contentObserver);
        }
        s_actionCounter++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.m_option;
    }

    public String getEmailAddress() {
        return this.m_email;
    }

    public String getEmailBody() {
        return this.emailBody;
    }

    public String getEmailFrom() {
        return this.emailFrom;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (Build.VERSION.SDK_INT >= 28 && this.m_option == 0 && this.saveToJpeg) {
            return getOptions()[0] + " (JPG)";
        }
        return getOptions()[this.m_option];
    }

    public boolean getHandleNextImageUpdate() {
        return this.handeNextImageUpdate;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getIcon() {
        return R.drawable.ic_cellphone_android_white_24dp;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return TakeScreenshotActionInfo.getInstance();
    }

    public TriggerContextInfo getLatestTriggerContextInfo() {
        return this.latestTriggerContextInfo;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getName() {
        return getContext().getString(R.string.action_take_screenshot);
    }

    public int getOption() {
        return this.m_option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES"};
        }
        return new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_email, this.emailSubject, this.emailBody};
    }

    public boolean getSaveToJpeg() {
        return this.saveToJpeg;
    }

    public String getSubject() {
        return this.emailSubject;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getConfiguredName() + " (" + getExtendedDetail() + ")";
    }

    public boolean getUseSmtpEmail() {
        return this.useSmtpEmail;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1 && intent != null) {
            if (i4 == 1000) {
                if (this.m_gmailHelper.handleActivityResult(i4, i5, intent)) {
                    p0();
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
        Intent intent;
        if (Build.VERSION.SDK_INT >= 28) {
            if (Util.isMacroDroidAccessibilityEnabled(getContext())) {
                intent = new Intent(getContext(), MacroDroidAccessibilityServiceJellyBean.class);
            } else {
                intent = new Intent(getContext(), UIInteractionAccessibilityService.class);
            }
            intent.setAction(MacroDroidAccessibilityServiceJellyBean.ACTION_GLOBAL_CONTROL);
            intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 9);
            getContext().startService(intent);
            if (this.m_option != 0 || this.saveToJpeg) {
                this.handeNextImageUpdate = true;
                this.latestTriggerContextInfo = triggerContextInfo;
                return;
            }
            return;
        }
        String l02 = l0();
        int i4 = this.m_option;
        if (i4 != 1) {
            if (i4 == 2 && l02 != null) {
                o0(l02, null, getContext());
            }
        } else if (l02 != null) {
            n0(getMacro(), l02, null, getContext(), this.m_email, this.emailFrom, this.emailSubject, this.emailBody, this.useSmtpEmail, triggerContextInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresAccessibility() {
        if (Build.VERSION.SDK_INT >= 28 && !Util.isUIInteractionAccessibilityEnabled(getContext())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (Build.VERSION.SDK_INT >= 28) {
            if (this.m_option == 1) {
                q0();
                return;
            } else {
                itemComplete();
                return;
            }
        }
        Z();
    }

    public void setHandleNextImageUpdate(boolean z3) {
        this.handeNextImageUpdate = z3;
    }

    public void setLatestTriggerContextInfo(TriggerContextInfo triggerContextInfo) {
        this.latestTriggerContextInfo = triggerContextInfo;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 3) {
            this.m_email = strArr[0];
            this.emailSubject = strArr[1];
            this.emailBody = strArr[2];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_option);
        parcel.writeString(this.m_email);
        parcel.writeInt(this.m_mechanismOption);
        parcel.writeInt(this.saveToJpeg ? 1 : 0);
        parcel.writeString(this.emailSubject);
        parcel.writeString(this.emailBody);
        parcel.writeString(this.emailFrom);
        parcel.writeInt(this.useSmtpEmail ? 1 : 0);
    }

    private TakeScreenshotAction() {
        this.emailSubject = SelectableItem.r(R.string.screenshot_email_subject);
        this.hiddenMechanismCount = 0;
        this.handeNextImageUpdate = false;
        this.latestTriggerContextInfo = null;
        this.m_option = 0;
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
    }

    public TakeScreenshotAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private TakeScreenshotAction(Parcel parcel) {
        super(parcel);
        this.emailSubject = SelectableItem.r(R.string.screenshot_email_subject);
        this.hiddenMechanismCount = 0;
        this.handeNextImageUpdate = false;
        this.latestTriggerContextInfo = null;
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
        this.m_option = parcel.readInt();
        this.m_email = parcel.readString();
        this.m_mechanismOption = parcel.readInt();
        this.saveToJpeg = parcel.readInt() != 0;
        this.emailSubject = parcel.readString();
        this.emailBody = parcel.readString();
        this.emailFrom = parcel.readString();
        this.useSmtpEmail = parcel.readInt() != 0;
    }
}
