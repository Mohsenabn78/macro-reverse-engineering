package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class VersionUtil {
    public static final String VERSION_FILE = "VERSION.txt";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f17907b = Pattern.compile("[-_./;:]");

    /* renamed from: a  reason: collision with root package name */
    private final Version f17908a;

    /* JADX INFO: Access modifiers changed from: protected */
    public VersionUtil() {
        Version version;
        try {
            version = versionFor(getClass());
        } catch (Exception unused) {
            PrintStream printStream = System.err;
            printStream.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
            version = null;
        }
        this.f17908a = version == null ? Version.unknownVersion() : version;
    }

    protected static int a(String str) {
        String str2 = str.toString();
        int length = str2.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str2.charAt(i5);
            if (charAt > '9' || charAt < '0') {
                break;
            }
            i4 = (i4 * 10) + (charAt - '0');
        }
        return i4;
    }

    public static Version mavenVersionFor(ClassLoader classLoader, String str, String str2) {
        InputStream resourceAsStream = classLoader.getResourceAsStream("META-INF/maven/" + str.replaceAll("\\.", RemoteSettings.FORWARD_SLASH_STRING) + RemoteSettings.FORWARD_SLASH_STRING + str2 + "/pom.properties");
        if (resourceAsStream != null) {
            try {
                try {
                    Properties properties = new Properties();
                    properties.load(resourceAsStream);
                    Version parseVersion = parseVersion(properties.getProperty("version"), properties.getProperty("groupId"), properties.getProperty("artifactId"));
                    try {
                        resourceAsStream.close();
                    } catch (IOException unused) {
                    }
                    return parseVersion;
                } catch (IOException unused2) {
                    resourceAsStream.close();
                } catch (Throwable th) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (IOException unused4) {
            }
        }
        return Version.unknownVersion();
    }

    @Deprecated
    public static Version parseVersion(String str) {
        return parseVersion(str, null, null);
    }

    public static Version versionFor(Class<?> cls) {
        String str;
        String str2;
        Version version = null;
        try {
            InputStream resourceAsStream = cls.getResourceAsStream(VERSION_FILE);
            if (resourceAsStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str2 = bufferedReader.readLine();
                    if (str2 != null) {
                        str2 = str2.trim();
                        str = bufferedReader.readLine();
                        if (str != null) {
                            str = str.trim();
                        }
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                    str2 = null;
                }
                version = parseVersion(readLine, str2, str);
                try {
                    resourceAsStream.close();
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            }
        } catch (IOException unused) {
        }
        if (version == null) {
            return Version.unknownVersion();
        }
        return version;
    }

    public Version version() {
        return this.f17908a;
    }

    public static Version parseVersion(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        String[] split = f17907b.split(trim);
        return new Version(a(split[0]), split.length > 1 ? a(split[1]) : 0, split.length > 2 ? a(split[2]) : 0, split.length > 3 ? split[3] : null, str2, str3);
    }
}
