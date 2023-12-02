package com.android.dx;

import com.koushikdutta.async.http.cache.ResponseCacheMiddleware;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes2.dex */
class AppDataDirGuesser {
    private String getPathFromThisClassLoader(ClassLoader classLoader, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(ClientCookie.PATH_ATTR);
            declaredField.setAccessible(true);
            return (String) declaredField.get(classLoader);
        } catch (ClassCastException | IllegalAccessException | NoSuchFieldException unused) {
            return processClassLoaderString(classLoader.toString());
        }
    }

    private ClassLoader guessSuitableClassLoader() {
        return AppDataDirGuesser.class.getClassLoader();
    }

    static String processClassLoaderString(String str) {
        if (str.contains("DexPathList")) {
            return processClassLoaderString43OrLater(str);
        }
        return processClassLoaderString42OrEarlier(str);
    }

    private static String processClassLoaderString42OrEarlier(String str) {
        int lastIndexOf = str.lastIndexOf(91);
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf + 1);
        }
        int indexOf = str.indexOf(93);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    private static String processClassLoaderString43OrLater(String str) {
        int indexOf = str.indexOf("DexPathList") + 11;
        if (str.length() > indexOf + 4) {
            String substring = str.substring(indexOf);
            int indexOf2 = substring.indexOf(93);
            if (substring.charAt(0) == '[' && substring.charAt(1) == '[' && indexOf2 >= 0) {
                String[] split = substring.substring(2, indexOf2).split(",");
                for (int i4 = 0; i4 < split.length; i4++) {
                    int indexOf3 = split[i4].indexOf(34);
                    int lastIndexOf = split[i4].lastIndexOf(34);
                    if (indexOf3 > 0 && indexOf3 < lastIndexOf) {
                        split[i4] = split[i4].substring(indexOf3 + 1, lastIndexOf);
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (String str2 : split) {
                    if (sb.length() > 0) {
                        sb.append(':');
                    }
                    sb.append(str2);
                }
                return sb.toString();
            }
            return str;
        }
        return str;
    }

    static String[] splitPathList(String str) {
        if (str.startsWith("dexPath=")) {
            int indexOf = str.indexOf(44);
            if (indexOf == -1) {
                str = str.substring(8);
            } else {
                str = str.substring(8, indexOf);
            }
        }
        return str.split(":");
    }

    boolean fileOrDirExists(File file) {
        return file.exists();
    }

    public File guess() {
        try {
            ClassLoader guessSuitableClassLoader = guessSuitableClassLoader();
            Class<?> cls = Class.forName("dalvik.system.PathClassLoader");
            cls.cast(guessSuitableClassLoader);
            File[] guessPath = guessPath(getPathFromThisClassLoader(guessSuitableClassLoader, cls));
            if (guessPath.length > 0) {
                return guessPath[0];
            }
            return null;
        } catch (ClassCastException | ClassNotFoundException unused) {
            return null;
        }
    }

    File[] guessPath(String str) {
        String[] splitPathList;
        int lastIndexOf;
        ArrayList arrayList = new ArrayList();
        for (String str2 : splitPathList(str)) {
            if (str2.startsWith("/data/app/") && (lastIndexOf = str2.lastIndexOf(".apk")) == str2.length() - 4) {
                int indexOf = str2.indexOf("-");
                if (indexOf != -1) {
                    lastIndexOf = indexOf;
                }
                File file = new File("/data/data/" + str2.substring(10, lastIndexOf));
                if (isWriteableDirectory(file)) {
                    File file2 = new File(file, ResponseCacheMiddleware.CACHE);
                    if ((fileOrDirExists(file2) || file2.mkdir()) && isWriteableDirectory(file2)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    boolean isWriteableDirectory(File file) {
        if (file.isDirectory() && file.canWrite()) {
            return true;
        }
        return false;
    }
}
