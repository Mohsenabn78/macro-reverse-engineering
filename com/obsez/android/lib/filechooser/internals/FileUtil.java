package com.obsez.android.lib.filechooser.internals;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class FileUtil {

    /* loaded from: classes6.dex */
    public static class NewFolderFilter implements InputFilter {

        /* renamed from: a  reason: collision with root package name */
        private final int f36556a;

        /* renamed from: b  reason: collision with root package name */
        private final Pattern f36557b;

        public NewFolderFilter() {
            this(255, "^[^/<>|\\\\:&;#\n\r\t?*~\u0000-\u001f]*$");
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i4, int i5, Spanned spanned, int i6, int i7) {
            if (!this.f36557b.matcher(charSequence).matches()) {
                if (!(charSequence instanceof SpannableStringBuilder)) {
                    return "";
                }
                return spanned.subSequence(i6, i7);
            }
            int length = this.f36556a - (spanned.length() - (i7 - i6));
            if (length <= 0) {
                return "";
            }
            if (length >= i5 - i4) {
                return null;
            }
            int i8 = length + i4;
            if (Character.isHighSurrogate(charSequence.charAt(i8 - 1)) && i8 - 1 == i4) {
                return "";
            }
            return charSequence.subSequence(i4, i8).toString();
        }

        public NewFolderFilter(int i4) {
            this(i4, "^[^/<>|\\\\:&;#\n\r\t?*~\u0000-\u001f]*$");
        }

        public NewFolderFilter(String str) {
            this(255, str);
        }

        public NewFolderFilter(int i4, String str) {
            this.f36556a = i4;
            this.f36557b = Pattern.compile(str);
        }
    }

    public static boolean createNewDirectory(String str) {
        return createNewDirectory(str, getCurrentDirectory());
    }

    public static void deleteFileRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteFileRecursively(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Couldn't delete \"" + file.getName() + "\" at \"" + file.getParent());
    }

    public static String getCurrentDir() {
        return new File("").getAbsolutePath();
    }

    public static File getCurrentDirectory() {
        return new File(new File("").getAbsolutePath());
    }

    public static String getExtension(File file) {
        if (file == null) {
            return null;
        }
        int lastIndexOf = file.getName().lastIndexOf(".");
        if (lastIndexOf >= 0) {
            return file.getName().substring(lastIndexOf);
        }
        return "";
    }

    public static String getExtensionWithoutDot(File file) {
        String extension = getExtension(file);
        if (extension.length() == 0) {
            return extension;
        }
        return extension.substring(1);
    }

    public static String getReadableFileSize(long j4) {
        float f4;
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        String str = " KB";
        if (j4 > 1024) {
            f4 = ((float) j4) / 1024.0f;
            if (f4 > 1024.0f) {
                f4 /= 1024.0f;
                if (f4 > 1024.0f) {
                    f4 /= 1024.0f;
                    str = " GB";
                } else {
                    str = " MB";
                }
            }
        } else {
            f4 = 0.0f;
        }
        return String.valueOf(decimalFormat.format(f4) + str);
    }

    @NonNull
    public static String getStoragePath(Context context, boolean z3) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i4 = 0; i4 < length; i4++) {
                Object obj = Array.get(invoke, i4);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z3 == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            e7.printStackTrace();
        }
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static long readSDCard(Context context, Boolean bool) {
        return readSDCard(context, bool, Boolean.FALSE);
    }

    public static boolean createNewDirectory(String str, File file) {
        File file2 = new File(file, str);
        return !file2.exists() && file2.mkdir();
    }

    public static long readSDCard(Context context, Boolean bool, Boolean bool2) {
        new DecimalFormat("0.00");
        getStoragePath(context, bool.booleanValue());
        StatFs statFs = new StatFs(getStoragePath(context, bool.booleanValue()));
        long blockSizeLong = statFs.getBlockSizeLong();
        long blockCountLong = statFs.getBlockCountLong();
        long freeBlocksLong = statFs.getFreeBlocksLong();
        if (bool2.booleanValue()) {
            blockCountLong = freeBlocksLong;
        }
        return blockCountLong * blockSizeLong;
    }
}
