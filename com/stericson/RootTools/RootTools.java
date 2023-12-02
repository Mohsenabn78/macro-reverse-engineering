package com.stericson.RootTools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stericson.RootShell.RootShell;
import com.stericson.RootShell.exceptions.RootDeniedException;
import com.stericson.RootShell.execution.Command;
import com.stericson.RootShell.execution.Shell;
import com.stericson.RootTools.containers.Mount;
import com.stericson.RootTools.containers.Permissions;
import com.stericson.RootTools.containers.Symlink;
import com.stericson.RootTools.internal.Remounter;
import com.stericson.RootTools.internal.RootToolsInternalMethods;
import com.stericson.RootTools.internal.Runner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public final class RootTools {

    /* renamed from: a  reason: collision with root package name */
    private static RootToolsInternalMethods f37486a = null;
    public static boolean debugMode = false;
    public static int default_Command_Timeout = 20000;
    public static boolean handlerEnabled = true;
    public static String utilPath;

    private static final RootToolsInternalMethods a() {
        RootToolsInternalMethods rootToolsInternalMethods = f37486a;
        if (rootToolsInternalMethods == null) {
            RootToolsInternalMethods.getInstance();
            return f37486a;
        }
        return rootToolsInternalMethods;
    }

    public static boolean checkUtil(String str) {
        return a().checkUtil(str);
    }

    public static void closeAllShells() throws IOException {
        RootShell.closeAllShells();
    }

    public static void closeCustomShell() throws IOException {
        RootShell.closeCustomShell();
    }

    public static void closeShell(boolean z3) throws IOException {
        RootShell.closeShell(z3);
    }

    public static boolean copyFile(String str, String str2, boolean z3, boolean z4) {
        return a().copyFile(str, str2, z3, z4);
    }

    public static boolean deleteFileOrDirectory(String str, boolean z3) {
        return a().deleteFileOrDirectory(str, z3);
    }

    public static boolean exists(String str) {
        return exists(str, false);
    }

    public static List<String> findBinary(String str, boolean z3) {
        return RootShell.findBinary(str, z3);
    }

    public static void fixUtil(String str, String str2) {
        a().fixUtil(str, str2);
    }

    public static boolean fixUtils(String[] strArr) throws Exception {
        return a().fixUtils(strArr);
    }

    public static List<String> getBusyBoxApplets() throws Exception {
        return getBusyBoxApplets("");
    }

    public static String getBusyBoxVersion(String str) {
        return a().getBusyBoxVersion(str);
    }

    public static Shell getCustomShell(String str, int i4) throws IOException, TimeoutException, RootDeniedException {
        return RootShell.getCustomShell(str, i4);
    }

    public static Permissions getFilePermissionsSymlinks(String str) {
        return a().getFilePermissionsSymlinks(str);
    }

    public static String getInode(String str) {
        return a().getInode(str);
    }

    public static String getMountedAs(String str) throws Exception {
        return a().getMountedAs(str);
    }

    public static ArrayList<Mount> getMounts() throws Exception {
        return a().getMounts();
    }

    public static List<String> getPath() {
        return Arrays.asList(System.getenv("PATH").split(":"));
    }

    public static Shell getShell(boolean z3, int i4, Shell.ShellContext shellContext, int i5) throws IOException, TimeoutException, RootDeniedException {
        return RootShell.getShell(z3, i4, shellContext, i5);
    }

    public static long getSpace(String str) {
        return a().getSpace(str);
    }

    public static String getSymlink(String str) {
        return a().getSymlink(str);
    }

    public static ArrayList<Symlink> getSymlinks(String str) throws Exception {
        return a().getSymlinks(str);
    }

    public static String getWorkingToolbox() {
        return a().getWorkingToolbox();
    }

    public static boolean hasBinary(Context context, String str) {
        return a().isBinaryAvailable(context, str);
    }

    public static boolean hasEnoughSpaceOnSdCard(long j4) {
        return a().hasEnoughSpaceOnSdCard(j4);
    }

    public static boolean hasUtil(String str, String str2) {
        return a().hasUtil(str, str2);
    }

    public static boolean installBinary(Context context, int i4, String str, String str2) {
        return a().installBinary(context, i4, str, str2);
    }

    public static boolean isAccessGiven() {
        return RootShell.isAccessGiven(0, 3);
    }

    public static boolean isAppletAvailable(String str, String str2) {
        return a().isAppletAvailable(str, str2);
    }

    public static boolean isBusyboxAvailable() {
        return RootShell.isBusyboxAvailable();
    }

    public static boolean isNativeToolsReady(int i4, Context context) {
        return a().isNativeToolsReady(i4, context);
    }

    public static boolean isProcessRunning(String str) {
        return a().isProcessRunning(str);
    }

    public static boolean isRootAvailable() {
        return RootShell.isRootAvailable();
    }

    public static boolean islog() {
        return debugMode;
    }

    public static boolean killProcess(String str) {
        return a().killProcess(str);
    }

    public static void log(String str) {
        log(null, str, 3, null);
    }

    public static void offerBusyBox(Activity activity) {
        a().offerBusyBox(activity);
    }

    public static void offerSuperUser(Activity activity) {
        a().offerSuperUser(activity);
    }

    public static boolean remount(String str, String str2) {
        return new Remounter().remount(str, str2);
    }

    public static void restartAndroid() {
        log("Restart Android");
        killProcess("zygote");
    }

    public static void runBinary(Context context, String str, String str2) {
        new Runner(context, str, str2).start();
    }

    public static void runShellCommand(Shell shell, Command command) throws IOException {
        shell.add(command);
    }

    public static void setRim(RootToolsInternalMethods rootToolsInternalMethods) {
        f37486a = rootToolsInternalMethods;
    }

    public static boolean exists(String str, boolean z3) {
        return RootShell.exists(str, z3);
    }

    public static List<String> getBusyBoxApplets(String str) throws Exception {
        return a().getBusyBoxApplets(str);
    }

    public static String getBusyBoxVersion() {
        return getBusyBoxVersion("");
    }

    public static Shell getCustomShell(String str) throws IOException, TimeoutException, RootDeniedException {
        return getCustomShell(str, 10000);
    }

    public static Shell getShell(boolean z3, int i4, Shell.ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, i4, shellContext, 3);
    }

    public static boolean installBinary(Context context, int i4, String str) {
        return installBinary(context, i4, str, "700");
    }

    public static boolean isAccessGiven(int i4, int i5) {
        return RootShell.isAccessGiven(i4, i5);
    }

    public static boolean isAppletAvailable(String str) {
        return isAppletAvailable(str, "");
    }

    public static void log(String str, String str2) {
        log(str, str2, 3, null);
    }

    public static Intent offerBusyBox(Activity activity, int i4) {
        return a().offerBusyBox(activity, i4);
    }

    public static Intent offerSuperUser(Activity activity, int i4) {
        return a().offerSuperUser(activity, i4);
    }

    public static Shell getShell(boolean z3, Shell.ShellContext shellContext) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, 0, shellContext, 3);
    }

    public static void log(String str, int i4, Exception exc) {
        log(null, str, i4, exc);
    }

    public static Shell getShell(boolean z3, int i4) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, i4, Shell.defaultContext, 3);
    }

    public static void log(String str, String str2, int i4, Exception exc) {
        if (str2 == null || str2.equals("") || !debugMode) {
            return;
        }
        if (str == null) {
            str = Constants.TAG;
        }
        if (i4 != 2) {
            return;
        }
        Log.e(str, str2, exc);
    }

    public static Shell getShell(boolean z3) throws IOException, TimeoutException, RootDeniedException {
        return getShell(z3, 0);
    }
}
