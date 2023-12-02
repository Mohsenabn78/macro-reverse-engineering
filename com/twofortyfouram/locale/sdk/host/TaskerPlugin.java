package com.twofortyfouram.locale.sdk.host;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class TaskerPlugin {
    public static final String ACTION_EDIT_EVENT = "net.dinglisch.android.tasker.ACTION_EDIT_EVENT";
    private static final String BASE_KEY = "net.dinglisch.android.tasker";
    private static final String BUNDLE_KEY_HINT_PREFIX = ".hints.";
    private static final String BUNDLE_KEY_HINT_TIMEOUT_MS = ".hints.TIMEOUT";
    public static final String BUNDLE_KEY_RELEVANT_VARIABLES = "net.dinglisch.android.tasker.RELEVANT_VARIABLES";
    private static final String EXTRAS_PREFIX = "net.dinglisch.android.tasker.extras.";
    private static final String EXTRA_HINTS_BUNDLE = "net.dinglisch.android.tasker.extras.HINTS";
    private static final String EXTRA_HOST_CAPABILITIES = "net.dinglisch.android.tasker.extras.HOST_CAPABILITIES";
    public static final int EXTRA_HOST_CAPABILITY_ALL = 126;
    public static final int EXTRA_HOST_CAPABILITY_CONDITION_RETURN_VARIABLES = 4;
    private static final int EXTRA_HOST_CAPABILITY_RELEVANT_VARIABLES = 16;
    public static final int EXTRA_HOST_CAPABILITY_REQUEST_QUERY_DATA_PASS_THROUGH = 64;
    public static final int EXTRA_HOST_CAPABILITY_SETTING_FIRE_VARIABLE_REPLACEMENT = 8;
    public static final int EXTRA_HOST_CAPABILITY_SETTING_RETURN_VARIABLES = 2;
    public static final int EXTRA_HOST_CAPABILITY_SETTING_SYNCHRONOUS_EXECUTION = 32;
    private static final String EXTRA_VARIABLES_BUNDLE = "net.dinglisch.android.tasker.extras.VARIABLES";
    private static final int FIRST_ON_FIRE_VARIABLES_TASKER_VERSION = 80;
    private static final int RANDOM_HISTORY_SIZE = 100;
    private static final String TAG = "TaskerPlugin";
    private static final String VARIABLE_NAME_END_EXPRESSION = "[\\w0-9&&[^_]]";
    public static final String VARIABLE_NAME_MAIN_PART_MATCH_EXPRESSION = "[\\w&&[^_]][\\w0-9]+[\\w0-9&&[^_]]";
    public static final String VARIABLE_NAME_MATCH_EXPRESSION = "%+[\\w&&[^_]][\\w0-9]+[\\w0-9&&[^_]]";
    private static Pattern VARIABLE_NAME_MATCH_PATTERN = null;
    private static final String VARIABLE_NAME_MID_EXPRESSION = "[\\w0-9]+";
    private static final String VARIABLE_NAME_START_EXPRESSION = "[\\w&&[^_]]";
    public static final String VARIABLE_PREFIX = "%";
    private static int[] lastRandomsSeen;
    private static int randomInsertPointer;
    private static SecureRandom sr;

    /* loaded from: classes6.dex */
    public static class Condition {
        public static boolean hostSupportsVariableReturn(Bundle bundle) {
            return TaskerPlugin.hostSupports(bundle, 4);
        }
    }

    /* loaded from: classes6.dex */
    public static class Event {
        public static final String EXTRA_REQUEST_QUERY_PASS_THROUGH_DATA = "net.dinglisch.android.tasker.extras.PASS_THROUGH_DATA";
        public static final String PASS_THROUGH_BUNDLE_MESSAGE_ID_KEY = "net.dinglisch.android.tasker.MESSAGE_ID";

        public static void addPassThroughData(Intent intent, Bundle bundle) {
            retrieveOrCreatePassThroughBundle(intent).putAll(bundle);
        }

        public static int addPassThroughMessageID(Intent intent) {
            Bundle retrieveOrCreatePassThroughBundle = retrieveOrCreatePassThroughBundle(intent);
            int positiveNonRepeatingRandomInteger = TaskerPlugin.getPositiveNonRepeatingRandomInteger();
            retrieveOrCreatePassThroughBundle.putInt("net.dinglisch.android.tasker.MESSAGE_ID", positiveNonRepeatingRandomInteger);
            return positiveNonRepeatingRandomInteger;
        }

        public static boolean hostSupportsRequestQueryDataPassThrough(Bundle bundle) {
            return TaskerPlugin.hostSupports(bundle, 64);
        }

        public static Bundle retrieveOrCreatePassThroughBundle(Intent intent) {
            if (intent.hasExtra(EXTRA_REQUEST_QUERY_PASS_THROUGH_DATA)) {
                return intent.getBundleExtra(EXTRA_REQUEST_QUERY_PASS_THROUGH_DATA);
            }
            Bundle bundle = new Bundle();
            intent.putExtra(EXTRA_REQUEST_QUERY_PASS_THROUGH_DATA, bundle);
            return bundle;
        }

        public static Bundle retrievePassThroughData(Intent intent) {
            return (Bundle) TaskerPlugin.getExtraValueSafe(intent, EXTRA_REQUEST_QUERY_PASS_THROUGH_DATA, Bundle.class, "retrievePassThroughData");
        }

        public static int retrievePassThroughMessageID(Intent intent) {
            Integer num;
            Bundle retrievePassThroughData = retrievePassThroughData(intent);
            if (retrievePassThroughData != null && (num = (Integer) TaskerPlugin.getBundleValueSafe(retrievePassThroughData, "net.dinglisch.android.tasker.MESSAGE_ID", Integer.class, "retrievePassThroughMessageID")) != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class Host {
        public static Intent addCapabilities(Intent intent, int i4) {
            return intent.putExtra(TaskerPlugin.EXTRA_HOST_CAPABILITIES, i4);
        }

        public static void addCompletionIntent(Intent intent, Intent intent2) {
            intent.putExtra("net.dinglisch.android.tasker.extras.COMPLETION_INTENT", intent2.toUri(1));
        }

        public static void addHintTimeoutMS(Intent intent, int i4) {
            getHintsBundle(intent, "addHintTimeoutMS").putInt(TaskerPlugin.BUNDLE_KEY_HINT_TIMEOUT_MS, i4);
        }

        public static void cleanHints(Bundle bundle) {
            bundle.remove(TaskerPlugin.EXTRA_HINTS_BUNDLE);
        }

        public static void cleanRelevantVariables(Bundle bundle) {
            bundle.remove(TaskerPlugin.BUNDLE_KEY_RELEVANT_VARIABLES);
        }

        public static void cleanRequestedTimeout(Bundle bundle) {
            bundle.remove("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT");
        }

        public static void cleanSettingReplaceVariables(Bundle bundle) {
            bundle.remove("net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS");
        }

        private static Bundle getHintsBundle(Intent intent, String str) {
            Bundle bundle = (Bundle) TaskerPlugin.getExtraValueSafe(intent, TaskerPlugin.EXTRA_HINTS_BUNDLE, Bundle.class, str);
            if (bundle == null) {
                Bundle bundle2 = new Bundle();
                intent.putExtra(TaskerPlugin.EXTRA_HINTS_BUNDLE, bundle2);
                return bundle2;
            }
            return bundle;
        }

        public static int getRequestedTimeoutMS(Bundle bundle) {
            return ((Integer) TaskerPlugin.getBundleValueSafe(bundle, "net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT", Integer.class, "getRequestedTimeout")).intValue();
        }

        public static int getSettingResultCode(Intent intent) {
            Integer num = (Integer) TaskerPlugin.getExtraValueSafe(intent, "net.dinglisch.android.tasker.extras.RESULT_CODE", Integer.class, "getSettingResultCode");
            if (num == null) {
                return 4;
            }
            return num.intValue();
        }

        public static String[] getSettingVariableReplaceKeys(Bundle bundle) {
            String str = (String) TaskerPlugin.getBundleValueSafe(bundle, "net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS", String.class, "getSettingVariableReplaceKeys");
            if (str != null) {
                return str.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            return null;
        }

        public static Bundle getVariablesBundle(Bundle bundle) {
            return (Bundle) TaskerPlugin.getBundleValueSafe(bundle, TaskerPlugin.EXTRA_VARIABLES_BUNDLE, Bundle.class, "getVariablesBundle");
        }

        public static boolean haveRelevantVariables(Bundle bundle) {
            return bundle.containsKey(TaskerPlugin.BUNDLE_KEY_RELEVANT_VARIABLES);
        }

        public static boolean haveRequestedTimeout(Bundle bundle) {
            return bundle.containsKey("net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT");
        }
    }

    /* loaded from: classes6.dex */
    public static class Setting {
        private static final String BUNDLE_KEY_VARIABLE_REPLACE_STRINGS = "net.dinglisch.android.tasker.extras.VARIABLE_REPLACE_KEYS";
        private static final String EXTRA_PLUGIN_COMPLETION_INTENT = "net.dinglisch.android.tasker.extras.COMPLETION_INTENT";
        private static final String EXTRA_REQUESTED_TIMEOUT = "net.dinglisch.android.tasker.extras.REQUESTED_TIMEOUT";
        public static final String EXTRA_RESULT_CODE = "net.dinglisch.android.tasker.extras.RESULT_CODE";
        public static final int REQUESTED_TIMEOUT_MS_MAX = 3599000;
        public static final int REQUESTED_TIMEOUT_MS_NEVER = 3600000;
        public static final int REQUESTED_TIMEOUT_MS_NONE = 0;
        public static final int RESULT_CODE_FAILED = 2;
        public static final int RESULT_CODE_FAILED_PLUGIN_FIRST = 10;
        public static final int RESULT_CODE_OK = -1;
        public static final int RESULT_CODE_OK_MINOR_FAILURES = 1;
        public static final int RESULT_CODE_PENDING = 3;
        public static final int RESULT_CODE_UNKNOWN = 4;
        public static final String VARNAME_ERROR_MESSAGE = "%errmsg";

        public static int getHintTimeoutMS(Bundle bundle) {
            Integer num;
            Bundle bundle2 = (Bundle) TaskerPlugin.getBundleValueSafe(bundle, TaskerPlugin.EXTRA_HINTS_BUNDLE, Bundle.class, "getHintTimeoutMS");
            if (bundle2 != null && (num = (Integer) TaskerPlugin.getBundleValueSafe(bundle2, TaskerPlugin.BUNDLE_KEY_HINT_TIMEOUT_MS, Integer.class, "getHintTimeoutMS")) != null) {
                return num.intValue();
            }
            return -1;
        }

        public static boolean hostSupportsOnFireVariableReplacement(Bundle bundle) {
            return TaskerPlugin.hostSupports(bundle, 8);
        }

        public static boolean hostSupportsSynchronousExecution(Bundle bundle) {
            return TaskerPlugin.hostSupports(bundle, 32);
        }

        public static boolean hostSupportsVariableReturn(Bundle bundle) {
            return TaskerPlugin.hostSupports(bundle, 2);
        }

        public static void requestTimeoutMS(Intent intent, int i4) {
            if (i4 < 0) {
                Log.w(TaskerPlugin.TAG, "requestTimeoutMS: ignoring negative timeout (" + i4 + ")");
                return;
            }
            if (i4 > 3599000 && i4 != 3600000) {
                Log.w(TaskerPlugin.TAG, "requestTimeoutMS: requested timeout " + i4 + " exceeds maximum, setting to max (3599000)");
                i4 = 3599000;
            }
            intent.putExtra(EXTRA_REQUESTED_TIMEOUT, i4);
        }

        public static void setVariableReplaceKeys(Bundle bundle, String[] strArr) {
            StringBuilder sb = new StringBuilder();
            if (strArr != null) {
                for (String str : strArr) {
                    if (str.contains(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                        Log.w(TaskerPlugin.TAG, "setVariableReplaceKeys: ignoring bad keyName containing space: " + str);
                    } else {
                        if (sb.length() > 0) {
                            sb.append(' ');
                        }
                        sb.append(str);
                    }
                    if (sb.length() > 0) {
                        bundle.putString(BUNDLE_KEY_VARIABLE_REPLACE_STRINGS, sb.toString());
                    }
                }
            }
        }

        public static boolean signalFinish(Context context, Intent intent, int i4, Bundle bundle) {
            Uri uri;
            String str = (String) TaskerPlugin.getExtraValueSafe(intent, EXTRA_PLUGIN_COMPLETION_INTENT, String.class, "signalFinish");
            if (str != null) {
                try {
                    uri = Uri.parse(str);
                } catch (Exception unused) {
                    Log.w(TaskerPlugin.TAG, "signalFinish: couldn't parse " + str);
                    uri = null;
                }
                if (uri != null) {
                    try {
                        Intent parseUri = Intent.parseUri(str, 1);
                        parseUri.putExtra("net.dinglisch.android.tasker.extras.RESULT_CODE", i4);
                        if (bundle != null) {
                            parseUri.putExtra(TaskerPlugin.EXTRA_VARIABLES_BUNDLE, bundle);
                        }
                        context.sendBroadcast(parseUri);
                        return true;
                    } catch (URISyntaxException unused2) {
                        Log.w(TaskerPlugin.TAG, "signalFinish: bad URI: " + uri);
                    }
                }
            }
            return false;
        }

        public static boolean hostSupportsOnFireVariableReplacement(Activity activity) {
            boolean hostSupportsOnFireVariableReplacement = hostSupportsOnFireVariableReplacement(activity.getIntent().getExtras());
            if (hostSupportsOnFireVariableReplacement) {
                return hostSupportsOnFireVariableReplacement;
            }
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity == null) {
                Log.w(TaskerPlugin.TAG, "hostSupportsOnFireVariableReplacement: null callingActivity, defaulting to false");
                return hostSupportsOnFireVariableReplacement;
            }
            String packageName = callingActivity.getPackageName();
            return packageName.startsWith(TaskerPlugin.BASE_KEY) && TaskerPlugin.getPackageVersionCode(activity.getPackageManager(), packageName) > 80;
        }
    }

    public static void addRelevantVariableList(Intent intent, String[] strArr) {
        intent.putExtra(BUNDLE_KEY_RELEVANT_VARIABLES, strArr);
    }

    public static void addVariableBundle(Bundle bundle, Bundle bundle2) {
        bundle.putBundle(EXTRA_VARIABLES_BUNDLE, bundle2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getBundleValueSafe(Bundle bundle, String str, Class<?> cls, String str2) {
        if (bundle != null && bundle.containsKey(str)) {
            Object obj = bundle.get(str);
            if (obj == null) {
                Log.w(TAG, str2 + ": " + str + ": null value");
            } else if (obj.getClass() != cls) {
                Log.w(TAG, str2 + ": " + str + ": expected " + cls.getClass().getName() + ", got " + obj.getClass().getName());
            } else {
                return obj;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object getExtraValueSafe(Intent intent, String str, Class<?> cls, String str2) {
        if (intent.hasExtra(str)) {
            return getBundleValueSafe(intent.getExtras(), str, cls, str2);
        }
        return null;
    }

    public static int getPackageVersionCode(PackageManager packageManager, String str) {
        if (packageManager == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (Exception unused) {
            Log.e(TAG, "getPackageVersionCode: exception getting package info");
            return -1;
        }
    }

    public static int getPositiveNonRepeatingRandomInteger() {
        int nextInt;
        if (sr == null) {
            sr = new SecureRandom();
            lastRandomsSeen = new int[100];
            int i4 = 0;
            while (true) {
                int[] iArr = lastRandomsSeen;
                if (i4 >= iArr.length) {
                    break;
                }
                iArr[i4] = -1;
                i4++;
            }
        }
        do {
            nextInt = sr.nextInt(Integer.MAX_VALUE);
            int[] iArr2 = lastRandomsSeen;
            int length = iArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                } else if (iArr2[i5] == nextInt) {
                    nextInt = -1;
                    continue;
                    break;
                } else {
                    i5++;
                }
            }
        } while (nextInt == -1);
        int[] iArr3 = lastRandomsSeen;
        int i6 = randomInsertPointer;
        iArr3[i6] = nextInt;
        randomInsertPointer = (i6 + 1) % iArr3.length;
        return nextInt;
    }

    public static String[] getRelevantVariableList(Bundle bundle) {
        String[] strArr = (String[]) getBundleValueSafe(bundle, BUNDLE_KEY_RELEVANT_VARIABLES, String[].class, "getRelevantVariableList");
        if (strArr == null) {
            return new String[0];
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hostSupports(Bundle bundle, int i4) {
        Integer num = (Integer) getBundleValueSafe(bundle, EXTRA_HOST_CAPABILITIES, Integer.class, "hostSupports");
        if (num != null && (num.intValue() & i4) > 0) {
            return true;
        }
        return false;
    }

    public static boolean hostSupportsRelevantVariables(Bundle bundle) {
        return hostSupports(bundle, 16);
    }

    private static boolean variableNameIsLocal(String str) {
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (Character.isUpperCase(charAt)) {
                return false;
            }
            if (Character.isDigit(charAt)) {
                i4++;
            }
        }
        if (i4 == str.length() - 1) {
            return false;
        }
        return true;
    }

    public static boolean variableNameValid(String str) {
        if (str == null) {
            return false;
        }
        if (VARIABLE_NAME_MATCH_PATTERN == null) {
            VARIABLE_NAME_MATCH_PATTERN = Pattern.compile("%+[\\w&&[^_]][\\w0-9]+[\\w0-9&&[^_]]", 0);
        }
        if (VARIABLE_NAME_MATCH_PATTERN.matcher(str).matches()) {
            if (variableNameIsLocal(str)) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("variableNameValid: name not local: ");
            sb.append(str);
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("variableNameValid: invalid name: ");
        sb2.append(str);
        return false;
    }
}
