package com.arlosoft.macrodroid.common;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.BuildConfig;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.accessibility.AccessibilityServiceState;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.data.ContactGroup;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.ModeEnterExitTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.services.FingerprintAccessibilityService;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityService;
import com.arlosoft.macrodroid.triggers.services.VolumeButtonAccessibilityService;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.RootTools;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import es.dmoral.toasty.Toasty;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TimeZone;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import me.drakeet.support.toast.ToastCompat;
import net.bytebuddy.description.type.TypeDescription;
import org.jsoup.nodes.DocumentType;

/* loaded from: classes3.dex */
public class Util {
    public static final String ACTIVITY_RECOGNITION_UPDATE_RATE_INTENT = "ActivityRecognitionUpdateRateIntent";
    public static final String ADD_WEAR_TRIGGER_EXTRA = "add_wear_trigger";
    public static final String ALL_BT_DEVICES;
    public static final String ALL_BT_DEVICES_CONSTANT = "All Devices";
    public static final String ANY_BT_DEVICE;
    public static final String ANY_BT_DEVICE_CONSTANT = "Any Device";
    public static final String ANY_CONTACT_ID = "-1";
    public static final String ANY_NUMBER_ID = "-2";
    public static final String ANY_WIFI_NETWORK_ENGLISH = "Any Network";
    public static final String[] AUDIO_FILE_TYPES;
    public static final String CELL_TOWER_UPDATE_RATE_INTENT = "CellTowerUpdateRateIntent";
    public static final String DRAWABLE_ID_EXTRA = "drawableId";
    public static final String DRAWABLE_NAME_EXTRA = "drawableName";
    public static final String DRAWABLE_PACKAGE_NAME_EXTRA = "drawablePackageName";
    public static final String DRAWABLE_URI_EXTRA = "drawableUri";
    public static final String EXTRA_GUID = "guid";
    public static final String EXTRA_IS_ACTION_BLOCK = "is_action_block";
    public static final String EXTRA_MACRO_NAME = "com.arlosoft.macrodroid.MACRO_NAME";
    public static final String FADED_IMAGE_EXTRA = "fadedImage";
    public static final String FILE_EXTENSION_FILTER = "FileExtensionFilter";
    public static final String FILE_EXTENSION_FILTER2 = "FileExtensionFilter2";
    public static final String FILE_SELECTION_EXTRA = "FileSelection";
    public static final String FOLDER_EXTRA = "Folder";
    public static final String GOOGLE_MAPS_HEADING = "http://maps.google.com/maps?q=";
    public static final String ICON_TEXT_EXTRA = "iconTextExtra";
    public static final String[] IMAGE_FILE_TYPES;
    public static final String LAUNCH_FACEBOOK_EXTRA = "LaunchFacebook";
    public static final String LAUNCH_TWITTER_EXTRA = "LaunchTwitter";
    public static final String LIGHT_SENSOR_BACKGROUND_SCAN_RATE_INTENT = "LightSensorBackgroundScanRateIntent";
    public static final String LOC_UPDATE_RATE_INTENT = "LocUpdateRateIntent";
    public static final String MACRO_DROID_SYSTEM_HELPER = "/system/app/MacroDroidSystemHelper.apk";
    public static final String MACRO_DROID_SYSTEM_HELPER_4_4 = "/system/priv-app/MacroDroidSystemHelper.apk";
    public static final String MACRO_EXTRA = "Macro";
    public static final String MACRO_ID_EXTRA = "MacroId";
    public static final String MEDIA_BUTTON_MACRODROID = "MediaButtonMacroDroid";
    public static final String NON_CONTACT_ID = "-3";
    public static final String NOTIFICATION_BUTTON_EXTRA = "notificationButton";
    public static final String PATH_EXTRA = "Path";
    public static final int PERSISTENT_NOTIFICATION_ID = 7987673;
    public static final int RESULT_OK = 1;
    public static final String SELECT_APP_NAME;
    public static final Contact SELECT_CONTACT = new Contact(Contact.SELECT_CONTACT_ID, "[" + MacroDroidApplication.getInstance().getString(R.string.select_contact) + "]", Contact.SELECT_CONTACT_ID);
    public static final String SMS_MESSAGE_EXTRA = "SmsMessageExtra";
    public static final String SMS_RECEIVED_INTENT = "SmsReceviedIntent";
    public static final String SMS_SENT_INTENT = "SmsSentIntent";
    public static final int SYSTEM_HELPER_VERSION = 2;
    public static final String TITLE_EXTRA = "Title";
    public static final String TRIGGER_EXTRA = "Trigger";
    public static final String UNKNOWN_CALLER_ID = "-4";
    public static final String USE_AUDIO_FILTER_EXTRA = "AudioFilter";
    public static final String[] VIDEO_FILE_TYPES;
    public static final String WEATHER_UPDATE_RATE_INTENT = "WeatberUpdateRateIntent";
    public static final String WIDGET_TEXT_EXTRA = "widgetText";
    public static final String WIFI_BACKGROUND_SCAN_RATE_INTENT = "WifiBackgroundScanRateIntent";

    /* renamed from: a  reason: collision with root package name */
    private static Ringtone f10016a;

    /* renamed from: b  reason: collision with root package name */
    private static int f10017b;

    /* loaded from: classes3.dex */
    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f10018a;

        a(String[] strArr) {
            this.f10018a = strArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Util.runAsRoot(this.f10018a);
        }
    }

    /* loaded from: classes3.dex */
    class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SharedPreferences f10019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10020b;

        b(SharedPreferences sharedPreferences, String str) {
            this.f10019a = sharedPreferences;
            this.f10020b = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException unused) {
            }
            this.f10019a.edit().putString("timezone", this.f10020b).apply();
        }
    }

    static {
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        ANY_BT_DEVICE = companion.getInstance().getString(R.string.bluetooth_any_device);
        ALL_BT_DEVICES = companion.getInstance().getString(R.string.bluetooth_all_devices);
        AUDIO_FILE_TYPES = new String[]{"3gp", "mp4", "m4a", "aac", "flac", "mp3", "mid", "xmf", "mxmf", "rtttl", "rtx", "ota", "imy", "ogg", "wav"};
        IMAGE_FILE_TYPES = new String[]{ImageUtils.JPG_FILE_EXTENSION, "jpeg", "png", "raw", "bmp", "tif", "tiff", "gif"};
        VIDEO_FILE_TYPES = new String[]{"3g2", "3gp", "asf", "asx", "avi", "divx", "flv", "mov", "mkv", "mp4", "mpg", "rm", "srt", "swf", "vob", "wmv"};
        SELECT_APP_NAME = companion.getInstance().getString(R.string.select_app);
        f10017b = 10000000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(Context context) {
        ToastCompat.makeText(context.getApplicationContext(), (CharSequence) context.getString(R.string.could_not_get_contacts), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int B(Contact contact, Contact contact2) {
        try {
            if (contact.getName() != null && contact2.getName() != null) {
                return contact.getName().toLowerCase().compareTo(contact2.getName().toLowerCase());
            }
        } catch (Exception unused) {
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Context context) {
        ToastCompat.makeText(context.getApplicationContext(), (CharSequence) context.getString(R.string.could_not_get_contacts), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int D(Locale locale, AppInfo appInfo, AppInfo appInfo2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(appInfo.applicationName, appInfo2.applicationName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Context context) {
        ToastCompat.makeText(context.getApplicationContext(), (CharSequence) context.getString(R.string.too_many_apps_installed), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(Activity activity, DialogInterface dialogInterface, int i4) {
        activity.startActivity(new Intent(activity, UpgradeActivity2.class));
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(Context context, String str, int i4) {
        ToastCompat.makeText(context.getApplicationContext(), (CharSequence) str, i4).show();
    }

    private static void I(String[] strArr) {
        Shell shell = null;
        try {
            try {
                Command command = new Command(0, strArr);
                shell = RootTools.getShell(true, Shell.ShellContext.NORMAL);
                shell.add(command);
            } catch (Exception unused) {
                Log.w("Util", "Failed to run root command(s)");
                if (shell == null) {
                    return;
                }
            }
            try {
                shell.close();
            } catch (Exception unused2) {
            }
        } catch (Throwable th) {
            if (shell != null) {
                try {
                    shell.close();
                } catch (Exception unused3) {
                }
            }
            throw th;
        }
    }

    public static String appendAdbHackInfo(Context context, String str) {
        return str + "\n\n" + context.getString(R.string.enable_adb_instructions) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + PermissionsHelper.ADB_HACK_INFO_LINK;
    }

    public static boolean compareNumbers(String str, List<String> list) {
        if (str != null && list != null && list.size() != 0) {
            try {
                String replaceAll = str.replaceAll("[^a-zA-Z0-9.]", "");
                if (replaceAll.contains(";rn")) {
                    replaceAll = replaceAll.substring(0, replaceAll.indexOf(";rn"));
                }
                for (String str2 : list) {
                    if (str2 != null) {
                        String replaceAll2 = str2.replaceAll("[^a-zA-Z0-9.]", "");
                        if (replaceAll2.contains(";rn")) {
                            replaceAll2 = replaceAll.substring(0, replaceAll2.indexOf(";rn"));
                        }
                        if (replaceAll.length() > 8 && replaceAll2.length() > 8) {
                            if (replaceAll.substring(replaceAll.length() - 8).equals(replaceAll2.substring(replaceAll2.length() - 8))) {
                                return true;
                            }
                        }
                        if (replaceAll.equals(replaceAll2)) {
                            return true;
                        }
                    }
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Exception in util compareNumbers: " + e4.getMessage()));
            }
        }
        return false;
    }

    public static void copySocatBinary(Context context) {
        p(context, "socat");
    }

    public static Stack<Integer> deserializeStack(ArrayList<Integer> arrayList) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(arrayList);
        return stack;
    }

    public static void displayErrorDialog(Context context, String str, String str2, int i4) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, i4);
        builder.setTitle(str);
        builder.setMessage(str2).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.a1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @SuppressLint({"NewApi"})
    public static void displayNotification(Context context, String str, String str2, boolean z3, int i4, PendingIntent pendingIntent, int i5, String str3) {
        displayNotification(context, str, str2, z3, i4, pendingIntent, i5, RingtoneManager.getDefaultUri(2), 0, str3);
    }

    public static void displayUpgradeDialog(final Activity activity, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.Theme_App_Dialog);
        builder.setTitle(R.string.pro_version_required);
        builder.setMessage(str + "\n\n" + activity.getString(R.string.click_to_upgrade_to_pro)).setCancelable(false).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.u0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.v0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                Util.v(activity, dialogInterface, i4);
            }
        });
        builder.show();
    }

    public static boolean doesContactGroupExist(Context context, String str) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = ContactsContract.Groups.CONTENT_SUMMARY_URI;
            if (contentResolver.query(uri, null, "_id = '" + str + "'", null, null).getCount() <= 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ArrayList<Contact> getAllPhoneContactsWithNumbers(final Context context) {
        ArrayList<Contact> arrayList = new ArrayList<>();
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "display_name", "lookup", "data1"}, null, null, null);
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID));
                String string2 = query.getString(query.getColumnIndex("display_name"));
                String string3 = query.getString(query.getColumnIndex("lookup"));
                String string4 = query.getString(query.getColumnIndex("data1"));
                if (string4 != null) {
                    arrayList.add(new Contact(string, string2, string3, string4));
                }
            }
            query.close();
        } catch (SecurityException unused) {
            SystemLog.logError("Failed to get contacts - missing permission?");
        } catch (Exception unused2) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ToastCompat.makeText(context.getApplicationContext(), (CharSequence) context.getString(R.string.could_not_get_contacts), 0).show();
            } else {
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.common.b1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Util.x(context);
                    }
                });
            }
        }
        return arrayList;
    }

    public static final String getAnyContactString() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.any_contact) + "]";
    }

    public static final String getAnyNumberString() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.any_number) + "]";
    }

    public static List<String> getCategories(Context context) {
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        List<String> categories = Settings.getCategories(context);
        boolean z3 = false;
        for (Macro macro : allCompletedMacros) {
            String category = macro.getCategory();
            if (category != null && !categories.contains(category)) {
                categories.add(category);
                z3 = true;
            }
        }
        if (z3) {
            Settings.setCategories(context, categories);
        }
        final Locale locale = Settings.getLocale(context);
        Collections.sort(categories, new Comparator() { // from class: com.arlosoft.macrodroid.common.s0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int y3;
                y3 = Util.y(locale, (String) obj, (String) obj2);
                return y3;
            }
        });
        categories.remove(context.getString(R.string.uncategorized));
        categories.add(0, context.getString(R.string.uncategorized));
        return categories;
    }

    public static List<ContactGroup> getContactGroups(final Context context) {
        final String str;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = context.getContentResolver().query(ContactsContract.Groups.CONTENT_SUMMARY_URI, new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "title", "summ_phones"}, "deleted!='1'", null, null);
                int columnIndex = cursor.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID);
                int columnIndex2 = cursor.getColumnIndex("title");
                HashMap hashMap = new HashMap();
                while (cursor.moveToNext()) {
                    ContactGroup contactGroup = new ContactGroup();
                    contactGroup.id = cursor.getString(columnIndex);
                    contactGroup.name = cursor.getString(columnIndex2);
                    if (cursor.getInt(cursor.getColumnIndex("summ_phones")) > 0 && ((ContactGroup) hashMap.get(contactGroup.name)) == null) {
                        hashMap.put(contactGroup.name, contactGroup);
                        arrayList.add(contactGroup);
                    }
                }
            } catch (IllegalArgumentException unused) {
                cursor = context.getContentResolver().query(ContactsContract.Groups.CONTENT_SUMMARY_URI, new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "title"}, "deleted!='1'", null, null);
                int columnIndex3 = cursor.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID);
                int columnIndex4 = cursor.getColumnIndex("title");
                HashMap hashMap2 = new HashMap();
                while (cursor.moveToNext()) {
                    ContactGroup contactGroup2 = new ContactGroup();
                    contactGroup2.id = cursor.getString(columnIndex3);
                    String string = cursor.getString(columnIndex4);
                    contactGroup2.name = string;
                    if (((ContactGroup) hashMap2.get(string)) == null) {
                        hashMap2.put(contactGroup2.name, contactGroup2);
                        arrayList.add(contactGroup2);
                    }
                }
            } catch (Exception e4) {
                if (e4 instanceof SecurityException) {
                    str = "Failed to get contact groups, need permission to access contacts";
                } else {
                    str = "Failed to get contact groups, there is a problem with this device (Usually Huawei devices)";
                }
                SystemLog.logError(str + ": " + e4.toString());
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.common.d1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Util.z(context, str);
                    }
                });
                if (cursor != null) {
                }
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String getContactName(Context context, String str) {
        String str2;
        try {
            Cursor query = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
            if (query == null) {
                return null;
            }
            if (query.moveToFirst()) {
                str2 = query.getString(query.getColumnIndex("display_name"));
            } else {
                str2 = null;
            }
            if (!query.isClosed()) {
                query.close();
            }
            return str2;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static List<Contact> getContacts(Context context) {
        return getContacts(context, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.arlosoft.macrodroid.common.Contact> getContactsWithIds(final android.content.Context r12, java.util.List<java.lang.String> r13) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.Util.getContactsWithIds(android.content.Context, java.util.List):java.util.List");
    }

    @Nullable
    public static DocumentFile getDocumentFileParent(DocumentFile documentFile) {
        try {
            String path = documentFile.getUri().getPath();
            return DocumentFile.fromFile(new File(path.substring(0, path.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING))));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Drawable getDrawableFromPackage(Context context, String str, int i4) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getResourcesForApplication(packageManager.getApplicationInfo(str, 128)).getDrawable(i4);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Drawable getDrawableFromPackageWithName(Context context, String str, String str2) {
        String str3;
        Drawable drawable;
        if (str2 == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (str != null && str.equals(str2)) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
                drawable = packageManager.getResourcesForApplication(applicationInfo).getDrawable(applicationInfo.icon);
            } else {
                if (str != null) {
                    str3 = str;
                } else {
                    str3 = BuildConfig.APPLICATION_ID;
                }
                Resources resourcesForApplication = packageManager.getResourcesForApplication(packageManager.getApplicationInfo(str3, 128));
                drawable = resourcesForApplication.getDrawable(resourcesForApplication.getIdentifier(str2, "drawable", str3));
            }
            return drawable;
        } catch (Throwable th) {
            if (!TextUtils.equals(str, Constants.USER_ICON_OPTION_PACKAGE)) {
                return null;
            }
            SystemLog.logError("Failed to get image from package (" + str + ") " + th.toString());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x002f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0012 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.arlosoft.macrodroid.common.AppInfo> getInstalledAppList(final android.content.Context r8, boolean r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            r2 = 0
            java.util.List r3 = r1.getInstalledApplications(r2)     // Catch: java.lang.Exception -> L80
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Exception -> L80
        L12:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Exception -> L80
            if (r4 == 0) goto L5b
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Exception -> L80
            android.content.pm.ApplicationInfo r4 = (android.content.pm.ApplicationInfo) r4     // Catch: java.lang.Exception -> L80
            r5 = 1
            if (r9 == 0) goto L2c
            java.lang.String r6 = r4.packageName     // Catch: java.lang.Exception -> L80
            android.content.Intent r6 = r1.getLaunchIntentForPackage(r6)     // Catch: java.lang.Exception -> L80
            if (r6 == 0) goto L2a
            goto L2c
        L2a:
            r6 = 0
            goto L2d
        L2c:
            r6 = 1
        L2d:
            if (r6 == 0) goto L12
            com.arlosoft.macrodroid.common.AppInfo r6 = new com.arlosoft.macrodroid.common.AppInfo     // Catch: java.lang.Exception -> L80
            r6.<init>()     // Catch: java.lang.Exception -> L80
            java.lang.CharSequence r7 = r4.loadLabel(r1)     // Catch: java.lang.Exception -> L80
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L80
            r6.applicationName = r7     // Catch: java.lang.Exception -> L80
            java.lang.String r4 = r4.packageName     // Catch: java.lang.Exception -> L80
            r6.packageName = r4     // Catch: java.lang.Exception -> L80
            if (r9 != 0) goto L55
            android.content.pm.PackageManager r4 = r8.getPackageManager()     // Catch: java.lang.Exception -> L80
            java.lang.String r7 = r6.packageName     // Catch: java.lang.Exception -> L80
            android.content.Intent r4 = r4.getLaunchIntentForPackage(r7)     // Catch: java.lang.Exception -> L80
            if (r4 == 0) goto L51
            goto L52
        L51:
            r5 = 0
        L52:
            r6.launchable = r5     // Catch: java.lang.Exception -> L80
            goto L57
        L55:
            r6.launchable = r5     // Catch: java.lang.Exception -> L80
        L57:
            r0.add(r6)     // Catch: java.lang.Exception -> L80
            goto L12
        L5b:
            java.lang.String r9 = "android.hardware.camera"
            boolean r9 = r1.hasSystemFeature(r9)     // Catch: java.lang.Exception -> L80
            if (r9 == 0) goto L73
            com.arlosoft.macrodroid.common.AppInfo r9 = new com.arlosoft.macrodroid.common.AppInfo     // Catch: java.lang.Exception -> L80
            r9.<init>()     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "Camera"
            r9.applicationName = r1     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "com.android.camera"
            r9.packageName = r1     // Catch: java.lang.Exception -> L80
            r0.add(r9)     // Catch: java.lang.Exception -> L80
        L73:
            java.util.Locale r9 = com.arlosoft.macrodroid.settings.Settings.getLocale(r8)     // Catch: java.lang.Exception -> L80
            com.arlosoft.macrodroid.common.g1 r1 = new com.arlosoft.macrodroid.common.g1     // Catch: java.lang.Exception -> L80
            r1.<init>()     // Catch: java.lang.Exception -> L80
            java.util.Collections.sort(r0, r1)     // Catch: java.lang.Exception -> L80
            goto L95
        L80:
            r9 = move-exception
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r9)
            android.os.Handler r9 = new android.os.Handler
            android.os.Looper r1 = r8.getMainLooper()
            r9.<init>(r1)
            com.arlosoft.macrodroid.common.t0 r1 = new com.arlosoft.macrodroid.common.t0
            r1.<init>()
            r9.post(r1)
        L95:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.Util.getInstalledAppList(android.content.Context, boolean):java.util.List");
    }

    public static Uri getLastPhoto(Context context) {
        long currentTimeMillis = System.currentTimeMillis() + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "datetaken", "_data"}, null, null, "datetaken DESC");
        Uri uri = null;
        if (query == null) {
            displayNotification(context, "Share photo failed", "Could not access photos", false);
            return null;
        }
        if (query.moveToFirst()) {
            while (!query.isAfterLast() && uri == null) {
                query.getString(2);
                int i4 = query.getInt(0);
                System.currentTimeMillis();
                if (query.getLong(1) < currentTimeMillis) {
                    Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    uri = Uri.withAppendedPath(uri2, "" + i4);
                }
            }
        }
        query.close();
        return uri;
    }

    public static String getLastPhotoPath(Context context) {
        Cursor query;
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "datetaken", "_data"};
        Cursor cursor = null;
        try {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            String[] strArr2 = {String.valueOf(System.currentTimeMillis() + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)};
            query = contentResolver.query(uri, strArr, "datetaken<=?", strArr2, strArr[1] + " DESC");
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (query == null) {
                displayNotification(context, "Share photo failed", "Could not access photos", false);
                if (query != null) {
                    query.close();
                }
                return null;
            } else if (query.moveToFirst()) {
                String string = query.getString(2);
                query.close();
                return string;
            } else {
                query.close();
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String getLocalIpv4Address() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list.size() > 0) {
                for (NetworkInterface networkInterface : list) {
                    ArrayList<InetAddress> list2 = Collections.list(networkInterface.getInetAddresses());
                    if (list2.size() > 0) {
                        for (InetAddress inetAddress : list2) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                                return hostAddress;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (SocketException unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return getLocalIpv4AddressMethod2(MacroDroidApplication.getInstance());
        }
        return TypeDescription.Generic.OfWildcardType.SYMBOL;
    }

    @RequiresApi(api = 23)
    public static String getLocalIpv4AddressMethod2(Context context) {
        Network activeNetwork;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            for (LinkAddress linkAddress : connectivityManager.getLinkProperties(activeNetwork).getLinkAddresses()) {
                InetAddress address = linkAddress.getAddress();
                String hostAddress = address.getHostAddress();
                if (!address.isLoopbackAddress() && (address instanceof Inet4Address)) {
                    return hostAddress;
                }
            }
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        } catch (Exception unused) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    public static String getLocalIpv6Address() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list.size() > 0) {
                for (NetworkInterface networkInterface : list) {
                    ArrayList<InetAddress> list2 = Collections.list(networkInterface.getInetAddresses());
                    if (list2.size() > 0) {
                        for (InetAddress inetAddress : list2) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address)) {
                                int indexOf = hostAddress.indexOf("%");
                                if (indexOf > 0) {
                                    return hostAddress.substring(0, indexOf);
                                }
                                return hostAddress;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (SocketException unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return getLocalIpv6AddressMethod2(MacroDroidApplication.getInstance());
        }
        return TypeDescription.Generic.OfWildcardType.SYMBOL;
    }

    @RequiresApi(api = 23)
    public static String getLocalIpv6AddressMethod2(Context context) {
        Network activeNetwork;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            for (LinkAddress linkAddress : connectivityManager.getLinkProperties(activeNetwork).getLinkAddresses()) {
                InetAddress address = linkAddress.getAddress();
                String hostAddress = address.getHostAddress();
                if (!address.isLoopbackAddress() && (address instanceof Inet6Address)) {
                    return hostAddress;
                }
            }
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        } catch (Exception unused) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    public static List<String> getModeListFromString(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static String getModeListString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size(); i4++) {
            sb.append(list.get(i4));
            if (i4 < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static final String getNonContactString() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.non_contact) + "]";
    }

    public static List<String> getNumbersForContact(Context context, Contact contact) {
        Cursor query;
        ArrayList arrayList = new ArrayList();
        if (contact == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Get number for contact, contact is null"));
            return arrayList;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        if (contact.getLookupKey() != null) {
            try {
                query = contentResolver.query(ContactsContract.Contacts.getLookupUri(Long.parseLong(contact.getId()), contact.getLookupKey()), null, null, null, null);
            } catch (SecurityException unused) {
                PermissionsHelper.showNeedsPermission(context, "android.permission.READ_CONTACTS", context.getString(R.string.trigger_sms_sent), true, false);
                return arrayList;
            } catch (Exception e4) {
                SystemLog.logError("Failed to obtain contact number for user: " + contact.getName() + "(" + contact.getId() + ")");
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to convert contact id to long: ");
                sb.append(e4.getMessage());
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException(sb.toString()));
                try {
                    throw null;
                } catch (Exception unused2) {
                    return arrayList;
                }
            }
        } else {
            Uri uri = ContactsContract.Contacts.CONTENT_URI;
            query = contentResolver.query(uri, null, "_ID = '" + contact.getId() + "'", null, null);
        }
        if (query == null) {
            return arrayList;
        }
        try {
            if (query.moveToFirst()) {
                String string = query.getString(query.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID));
                cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = " + string, null, null);
                if (cursor == null) {
                    try {
                        query.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        cursor.close();
                    } catch (Exception unused4) {
                    }
                    return arrayList;
                }
                while (cursor.moveToNext()) {
                    arrayList.add(cursor.getString(cursor.getColumnIndex("data1")));
                }
            }
        } catch (SQLiteException unused5) {
        } catch (Throwable th) {
            try {
                query.close();
            } catch (Exception unused6) {
            }
            try {
                cursor.close();
            } catch (Exception unused7) {
            }
            throw th;
        }
        try {
            query.close();
        } catch (Exception unused8) {
        }
        try {
            cursor.close();
        } catch (Exception unused9) {
        }
        return arrayList;
    }

    public static List<String> getNumbersForContactId(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = " + str, null, null);
        } catch (SQLiteException unused) {
        } catch (Throwable th) {
            try {
                cursor.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        if (cursor == null) {
            try {
                cursor.close();
            } catch (Exception unused3) {
            }
            return arrayList;
        }
        while (cursor.moveToNext()) {
            arrayList.add(cursor.getString(cursor.getColumnIndex("data1")));
        }
        try {
            cursor.close();
        } catch (Exception unused4) {
            return arrayList;
        }
    }

    public static String getPreferredNumberForContact(Context context, Contact contact) {
        Cursor query;
        String str;
        String str2;
        String str3 = null;
        if (contact == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Get number for contact, contact is null"));
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (contact.getLookupKey() != null) {
            try {
                query = contentResolver.query(ContactsContract.Contacts.getLookupUri(Long.parseLong(contact.getId()), contact.getLookupKey()), null, null, null, null);
            } catch (SQLiteException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to query content resolver: " + e4.toString()));
                return null;
            } catch (NumberFormatException e5) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Failed to convert contact id to long: " + e5.toString()));
                return null;
            }
        } else {
            query = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, "_ID = '" + contact.getId() + "'", null, null);
        }
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex(Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID));
            Cursor query2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
            if (query2 == null) {
                return null;
            }
            str = null;
            str2 = null;
            while (query2.moveToNext()) {
                String string2 = query2.getString(query2.getColumnIndex("data1"));
                int i4 = query2.getInt(query2.getColumnIndex("data2"));
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (str2 == null) {
                                str2 = string2;
                            }
                        } else {
                            str = string2;
                        }
                    } else {
                        return string2;
                    }
                } else if (str3 == null) {
                    str3 = string2;
                }
            }
            query2.close();
        } else {
            str = null;
            str2 = null;
        }
        query.close();
        if (str3 == null) {
            if (str != null) {
                return str;
            }
            return str2;
        }
        return str3;
    }

    public static int getResId(Context context, String str) {
        if (str == null) {
            return -1;
        }
        try {
            int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            if (identifier == 0) {
                Class cls = R.drawable.class;
                if (str.startsWith(DocumentType.SYSTEM_KEY)) {
                    cls = R.drawable.class;
                    str = str.substring(6);
                }
                Field declaredField = cls.getDeclaredField(str);
                return declaredField.getInt(declaredField);
            }
            return identifier;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int getResourceIdFromName(@NonNull Context context, @NonNull String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", BuildConfig.APPLICATION_ID);
        } catch (Throwable unused) {
            SystemLog.logError("Failed to get image from resource name: " + str);
            return 0;
        }
    }

    public static List<String> getRingtoneSounds(Context context, int i4, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.add(Constants.RINGTONE_NONE);
        }
        RingtoneManager ringtoneManager = new RingtoneManager(context);
        ringtoneManager.setType(i4);
        Cursor cursor = null;
        try {
            try {
                cursor = ringtoneManager.getCursor();
                if (cursor.getCount() > 0) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(1);
                        if (string != null) {
                            arrayList.add(string);
                        }
                    }
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            try {
                cursor.close();
            } catch (Exception unused) {
                return arrayList;
            }
        } catch (Throwable th) {
            try {
                cursor.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
    }

    public static final String getUnkownCallerString() {
        return "[" + MacroDroidApplication.getInstance().getString(com.arlosoft.macrodroid.R.string.unknown_caller) + "]";
    }

    public static boolean helperFileExists() {
        return new File(MACRO_DROID_SYSTEM_HELPER_4_4).exists();
    }

    public static void inviteFriends(Activity activity) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        String format = String.format(SelectableItem.r(com.arlosoft.macrodroid.R.string.invite_friends_blurb), "https://play.google.com/store/apps/details?id=com.arlosoft.macrodroid");
        intent.putExtra("android.intent.extra.SUBJECT", SelectableItem.r(com.arlosoft.macrodroid.R.string.invite_friends_android_app_recommnedation));
        intent.putExtra("android.intent.extra.TEXT", format);
        activity.startActivity(Intent.createChooser(intent, null));
    }

    public static boolean isAccessibilityEnabled(Context context, String... strArr) {
        if (!q(context, strArr) && !r(context, strArr)) {
            return false;
        }
        return true;
    }

    public static boolean isFingerprintGestureAccessibilityEnabled(Context context) {
        if (!isAccessibilityEnabled(context, "FingerprintAccessibilityService") && !FingerprintAccessibilityService.isInitialised) {
            return false;
        }
        return true;
    }

    public static boolean isMacroDroidAccessibilityEnabled(Context context) {
        if (!isAccessibilityEnabled(context, "MacroDroidAccessibilityService", "MacroDroidAccessibilityServiceJellyBean") && !s()) {
            return false;
        }
        return true;
    }

    public static AccessibilityServiceState isMacroDroidAccessibilityEnabledWithCrashCheck(Context context) {
        boolean z3;
        if (!isAccessibilityEnabled(context, "MacroDroidAccessibilityService", "MacroDroidAccessibilityServiceJellyBean") && !s()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            return AccessibilityServiceState.DISABLED;
        }
        if (MacroDroidAccessibilityService.hasInitialised) {
            return AccessibilityServiceState.ENABLED;
        }
        return AccessibilityServiceState.ENABLED_BUT_NOT_RUNNING;
    }

    public static boolean isMacroDroidVolumeAccessibilityEnabled(Context context) {
        if (!isAccessibilityEnabled(context, "VolumeButtonAccessibilityService") && !VolumeButtonAccessibilityService.isInitialised) {
            return false;
        }
        return true;
    }

    public static boolean isMacroDroidVolumeAccessibilityEnabledWithCrashCheck(Context context) {
        if (!isAccessibilityEnabled(context, "VolumeButtonAccessibilityService") && !VolumeButtonAccessibilityService.isInitialised) {
            return false;
        }
        return true;
    }

    public static boolean isUIInteractionAccessibilityEnabled(Context context) {
        if (!isAccessibilityEnabled(context, "UIInteractionAccessibilityService") && !UIInteractionAccessibilityService.isConnected()) {
            return false;
        }
        return true;
    }

    public static AccessibilityServiceState isUIInteractionAccessibilityEnabledWithCrashCheck(Context context) {
        boolean z3;
        if (!isAccessibilityEnabled(context, "UIInteractionAccessibilityService") && !UIInteractionAccessibilityService.isConnected()) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            return AccessibilityServiceState.DISABLED;
        }
        if (UIInteractionAccessibilityService.isConnected()) {
            return AccessibilityServiceState.ENABLED;
        }
        return AccessibilityServiceState.ENABLED_BUT_NOT_RUNNING;
    }

    public static boolean isValidEmailAddress(String str) {
        try {
            new InternetAddress(str).validate();
            return true;
        } catch (NoClassDefFoundError unused) {
            return true;
        } catch (AddressException unused2) {
            return false;
        }
    }

    public static void linkifyDialogText(AlertDialog alertDialog) {
        try {
            Linkify.addLinks((TextView) alertDialog.findViewById(16908299), 15);
        } catch (Exception unused) {
        }
    }

    private static void p(Context context, String str) {
        try {
            File file = new File(context.getApplicationInfo().dataDir, str);
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    open.close();
                    file.setExecutable(true);
                    return;
                }
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Util copyAssetToDataDirectory failed: " + e4.getMessage()));
        }
    }

    public static void playRingtone(Context context, int i4, int i5, int i6) {
        stopRingtone();
        RingtoneManager ringtoneManager = new RingtoneManager(context.getApplicationContext());
        ringtoneManager.setType(i5);
        Cursor cursor = null;
        try {
            try {
                cursor = ringtoneManager.getCursor();
                f10016a = ringtoneManager.getRingtone(i4);
                try {
                    cursor.close();
                } catch (Exception unused) {
                }
                try {
                    if (f10016a != null) {
                        try {
                            f10016a.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(i6).build());
                        } catch (Exception unused2) {
                            f10016a.setStreamType(i6);
                        }
                        f10016a.play();
                        return;
                    }
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("playRingtone - s_ringtone is null"));
                } catch (NullPointerException unused3) {
                    displayNotification(context, "MacroDroid Error", "MacroDroid cannot play the ringtone due to a bug in this version of Android", false);
                }
            } catch (NullPointerException e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
                try {
                    cursor.close();
                } catch (Exception unused4) {
                }
            }
        } catch (Throwable th) {
            try {
                cursor.close();
            } catch (Exception unused5) {
            }
            throw th;
        }
    }

    private static boolean q(Context context, String... strArr) {
        int i4;
        String string;
        try {
            i4 = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Settings.SettingNotFoundException e4) {
            SystemLog.logError("Could not find accessibility enabled setting: " + e4.toString());
            i4 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i4 == 1 && (string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                String next = simpleStringSplitter.next();
                for (String str : strArr) {
                    if (next.endsWith(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean r(Context context, String... strArr) {
        Iterator<AccessibilityServiceInfo> it = ((AccessibilityManager) context.getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            AccessibilityServiceInfo next = it.next();
            next.getId();
            for (String str : strArr) {
                if (next.getId().endsWith(str)) {
                    return true;
                }
            }
        }
    }

    public static boolean removeSystemHelperApk(Context context) {
        boolean z3 = true;
        if (!new File(MACRO_DROID_SYSTEM_HELPER_4_4).exists()) {
            return true;
        }
        RootTools.debugMode = false;
        if (!RootTools.remount("/system", "rw")) {
            if (!RootToolsHelper.isAccessGiven()) {
                displayNotification(context, "Failed to remove helper apk", "This device does not appear to have root access", false);
                return false;
            }
            runAsRoot(new String[]{"mount -o rw,remount /system"});
        }
        Shell shell = null;
        try {
            Command command = new Command(0, "rm " + MACRO_DROID_SYSTEM_HELPER_4_4);
            shell = RootTools.getShell(true);
            shell.add(command);
            RootTools.closeAllShells();
            try {
                shell.close();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            if (shell != null) {
                try {
                    shell.close();
                } catch (Exception unused3) {
                }
            }
            z3 = false;
        } catch (Throwable th) {
            if (shell != null) {
                try {
                    shell.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
        try {
            RootTools.remount("/system/", TranslateLanguage.ROMANIAN);
        } catch (Exception unused5) {
        }
        return z3;
    }

    public static void runAsNonRoot(String[] strArr) {
        I(strArr);
    }

    public static void runAsRoot(String[] strArr) {
        runAsRoot(strArr, true);
    }

    public static void runAsRootInBg(String[] strArr) {
        new a(strArr).start();
    }

    private static boolean s() {
        return MacroDroidAccessibilityService.hasInitialised;
    }

    public static String sanitizeNumber(String str) {
        return str.replaceAll("[^0-9.+]", "");
    }

    public static void setMode(Context context, String str) {
        String mode = com.arlosoft.macrodroid.settings.Settings.getMode(context);
        if (mode.equals(str)) {
            SystemLog.logInfo("MacroDroid mode (" + str + ") not changed - ignoring");
            return;
        }
        SystemLog.logInfo("MacroDroid mode set to: " + str);
        com.arlosoft.macrodroid.settings.Settings.setMode(context, str);
        MacroDroidService.updateNotification(context, true, true);
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof ModeEnterExitTrigger) {
                    ModeEnterExitTrigger modeEnterExitTrigger = (ModeEnterExitTrigger) next;
                    if (!modeEnterExitTrigger.getTriggerOnAnyChange() && (!modeEnterExitTrigger.getMacroDroidModeEnabled() || !modeEnterExitTrigger.matchesMode(str))) {
                        if (modeEnterExitTrigger.getTriggerOnAnyChange() || (!modeEnterExitTrigger.getMacroDroidModeEnabled() && modeEnterExitTrigger.matchesMode(mode))) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        }
                    } else if (next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    public static void showMacroLimitReached(final Activity activity, RemoteConfig remoteConfig) {
        if (remoteConfig.shouldAutoShowUpgradeScreen()) {
            Toasty.Config.getInstance().setTextColor(-1).apply();
            Toast custom = Toasty.custom((Context) activity, (CharSequence) activity.getString(com.arlosoft.macrodroid.R.string.macro_limit_reached), (int) com.arlosoft.macrodroid.R.drawable.ic_error_outline_white_24dp, -16777216, 1, true, true);
            custom.setGravity(17, 0, 0);
            custom.show();
            UpgradeActivity2.Companion.animateInUpgradeSceen(activity);
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, com.arlosoft.macrodroid.R.style.Theme_App_Dialog);
        builder.setTitle(com.arlosoft.macrodroid.R.string.macro_limit_reached);
        builder.setMessage(String.format(activity.getString(com.arlosoft.macrodroid.R.string.you_currently_have_x_macros), Integer.valueOf(com.arlosoft.macrodroid.settings.Settings.getFreeMacros(activity)))).setCancelable(false).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.y0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        }).setPositiveButton(com.arlosoft.macrodroid.R.string.get_more_macros, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.z0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                Util.G(activity, dialogInterface, i4);
            }
        });
        builder.show();
    }

    public static void showToastOnMainThread(final Context context, final String str, final int i4) {
        new Handler(context.getApplicationContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.common.c1
            @Override // java.lang.Runnable
            public final void run() {
                Util.H(context, str, i4);
            }
        });
    }

    public static String stackTraceToString(Throwable th) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void stopRingtone() {
        Ringtone ringtone = f10016a;
        if (ringtone != null) {
            ringtone.stop();
            f10016a = null;
        }
    }

    public static boolean timeZoneChanged(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString("timezone", null);
        String str = TimeZone.getDefault().getID() + "," + TimeZone.getDefault().inDaylightTime(new Date());
        if (string != null && string.equals(str)) {
            return false;
        }
        new b(defaultSharedPreferences, str).start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Activity activity, DialogInterface dialogInterface, int i4) {
        activity.startActivity(new Intent(activity, UpgradeActivity2.class));
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Context context) {
        ToastCompat.makeText(context.getApplicationContext(), (CharSequence) context.getString(com.arlosoft.macrodroid.R.string.could_not_get_contacts), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int y(Locale locale, String str, String str2) {
        Collator collator = Collator.getInstance(locale);
        collator.setStrength(0);
        return collator.compare(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Context context, String str) {
        ToastCompat.makeText(context.getApplicationContext(), (CharSequence) str, 0).show();
    }

    @SuppressLint({"NewApi"})
    public static void displayNotification(Context context, String str, String str2, boolean z3, int i4, PendingIntent pendingIntent, int i5, Uri uri, int i6, String str3) {
        int i7 = f10017b;
        f10017b = i7 + 1;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (z3) {
                notificationManager.cancelAll();
            }
            int i8 = com.arlosoft.macrodroid.R.drawable.not_icon_setup;
            if (i4 == -1) {
                i4 = com.arlosoft.macrodroid.R.drawable.not_icon_setup;
            }
            try {
                if (context.getResources().getDrawable(i4) != null) {
                    i8 = i4;
                }
            } catch (Resources.NotFoundException unused) {
            }
            if (pendingIntent == null) {
                pendingIntent = PendingIntent.getActivity(context, 0, new Intent(), PendingIntentHelper.FLAG_IMMUTABLE);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentTitle(str).setTicker(str).setWhen(System.currentTimeMillis()).setContentText(str2).setContentIntent(pendingIntent).setSmallIcon(i8).setAutoCancel(true).setColor(i5).setStyle(new NotificationCompat.BigTextStyle().bigText(str2)).setPriority(i6).setGroup(String.valueOf(i7)).setChannelId(str3);
            if (uri != null) {
                builder.setSound(uri);
            } else {
                builder.setSound(null);
            }
            notificationManager.notify(String.valueOf(i7), i7, builder.build());
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("displayNotification exception: " + e4.getMessage()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<com.arlosoft.macrodroid.common.Contact> getContacts(final android.content.Context r11, boolean r12) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r11 != 0) goto L12
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r12 = "Util getContacts had a null context"
            r11.<init>(r12)
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r11)
            return r0
        L12:
            android.content.ContentResolver r1 = r11.getContentResolver()
            if (r1 != 0) goto L23
            java.lang.RuntimeException r11 = new java.lang.RuntimeException
            java.lang.String r12 = "Util getContacts ContentResolver was null"
            r11.<init>(r12)
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r11)
            return r0
        L23:
            java.lang.String r7 = "_id"
            java.lang.String r8 = "display_name"
            java.lang.String r9 = "lookup"
            java.lang.String r10 = "has_phone_number"
            java.lang.String[] r3 = new java.lang.String[]{r7, r8, r9, r10}
            android.net.Uri r2 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch: java.lang.Exception -> L39 java.lang.SecurityException -> L6a
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L39 java.lang.SecurityException -> L6a
            goto L70
        L39:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto L58
            android.content.Context r1 = r11.getApplicationContext()
            r2 = 2131953065(0x7f1305a9, float:1.954259E38)
            java.lang.String r11 = r11.getString(r2)
            r2 = 0
            me.drakeet.support.toast.ToastCompat r11 = me.drakeet.support.toast.ToastCompat.makeText(r1, r11, r2)
            r11.show()
            goto L6f
        L58:
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = r11.getMainLooper()
            r1.<init>(r2)
            com.arlosoft.macrodroid.common.e1 r2 = new com.arlosoft.macrodroid.common.e1
            r2.<init>()
            r1.post(r2)
            goto L6f
        L6a:
            java.lang.String r11 = "Failed to get contacts - missing permission?"
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r11)
        L6f:
            r11 = 0
        L70:
            if (r11 == 0) goto Lb6
            int r1 = r11.getCount()
            if (r1 <= 0) goto Lb3
        L78:
            boolean r1 = r11.moveToNext()
            if (r1 == 0) goto Lb3
            int r1 = r11.getColumnIndex(r7)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r1 = r11.getString(r1)     // Catch: java.lang.Exception -> Lb1
            int r2 = r11.getColumnIndex(r8)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r2 = r11.getString(r2)     // Catch: java.lang.Exception -> Lb1
            int r3 = r11.getColumnIndex(r9)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r3 = r11.getString(r3)     // Catch: java.lang.Exception -> Lb1
            if (r1 == 0) goto L78
            if (r2 == 0) goto L78
            int r4 = r11.getColumnIndex(r10)     // Catch: java.lang.Exception -> Lb1
            java.lang.String r4 = r11.getString(r4)     // Catch: java.lang.Exception -> Lb1
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> Lb1
            if (r4 <= 0) goto L78
            com.arlosoft.macrodroid.common.Contact r4 = new com.arlosoft.macrodroid.common.Contact     // Catch: java.lang.Exception -> Lb1
            r4.<init>(r1, r2, r3)     // Catch: java.lang.Exception -> Lb1
            r0.add(r4)     // Catch: java.lang.Exception -> Lb1
            goto L78
        Lb1:
            goto L78
        Lb3:
            r11.close()
        Lb6:
            if (r12 == 0) goto Lc0
            com.arlosoft.macrodroid.common.f1 r11 = new com.arlosoft.macrodroid.common.f1
            r11.<init>()
            java.util.Collections.sort(r0, r11)
        Lc0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.common.Util.getContacts(android.content.Context, boolean):java.util.List");
    }

    public static void runAsRoot(String[] strArr, boolean z3) {
        Shell shell = null;
        try {
            try {
                if (RootToolsHelper.isAccessGiven()) {
                    Command command = new Command(0, strArr);
                    shell = RootTools.getShell(true, Shell.ShellContext.SYSTEM_APP);
                    shell.add(command);
                    shell.close();
                } else if (z3) {
                    SystemLog.logError(SelectableItem.r(com.arlosoft.macrodroid.R.string.system_log_error_not_rooted), "https://www.xda-developers.com/root/");
                }
                if (shell == null) {
                    return;
                }
            } catch (Exception e4) {
                SystemLog.logError("Failed to run root command: " + e4.toString());
                if (0 == 0) {
                    return;
                }
            }
            try {
                shell.close();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    shell.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public static void displayErrorDialog(Context context, String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, com.arlosoft.macrodroid.R.style.Theme_App_Dialog);
        builder.setTitle(str);
        builder.setMessage(str2).setCancelable(true).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.common.w0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public static boolean compareNumbers(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                String replaceAll = str.replaceAll("[^0-9.]", "");
                String replaceAll2 = str2.replaceAll("[^0-9.]", "");
                if (replaceAll.length() > 8 && replaceAll2.length() > 8) {
                    if (replaceAll.substring(replaceAll.length() - 8).equals(replaceAll2.substring(replaceAll2.length() - 8))) {
                        return true;
                    }
                }
                if (replaceAll.equals(replaceAll2)) {
                    return true;
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Exception in util compareNumbers: " + e4.getMessage()));
            }
        }
        return false;
    }

    public static void displayNotification(Context context, String str, String str2, boolean z3) {
        displayNotification(context, str, str2, z3, -1, null, -3355444, Constants.NOTIFICATION_CHANNEL_INFO);
    }

    public static void displayNotification(Context context, String str, String str2, boolean z3, String str3) {
        displayNotification(context, str, str2, z3, -1, null, -3355444, str3);
    }
}
