package com.google.common.reflect;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import com.google.common.reflect.ClassPath;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import net.bytebuddy.dynamic.ClassFileLocator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ClassPath {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f28199b = Logger.getLogger(ClassPath.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final Splitter f28200c = Splitter.on(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).omitEmptyStrings();

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableSet<ResourceInfo> f28201a;

    /* loaded from: classes5.dex */
    public static final class ClassInfo extends ResourceInfo {

        /* renamed from: d  reason: collision with root package name */
        private final String f28202d;

        ClassInfo(File file, String str, ClassLoader classLoader) {
            super(file, str, classLoader);
            this.f28202d = ClassPath.c(str);
        }

        public String getName() {
            return this.f28202d;
        }

        public String getPackageName() {
            return Reflection.getPackageName(this.f28202d);
        }

        public String getSimpleName() {
            int lastIndexOf = this.f28202d.lastIndexOf(36);
            if (lastIndexOf != -1) {
                return CharMatcher.inRange('0', '9').trimLeadingFrom(this.f28202d.substring(lastIndexOf + 1));
            }
            String packageName = getPackageName();
            if (packageName.isEmpty()) {
                return this.f28202d;
            }
            return this.f28202d.substring(packageName.length() + 1);
        }

        public boolean isTopLevel() {
            if (this.f28202d.indexOf(36) == -1) {
                return true;
            }
            return false;
        }

        public Class<?> load() {
            try {
                return this.f28207c.loadClass(this.f28202d);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(e4);
            }
        }

        @Override // com.google.common.reflect.ClassPath.ResourceInfo
        public String toString() {
            return this.f28202d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class LocationInfo {

        /* renamed from: a  reason: collision with root package name */
        final File f28203a;

        /* renamed from: b  reason: collision with root package name */
        private final ClassLoader f28204b;

        LocationInfo(File file, ClassLoader classLoader) {
            this.f28203a = (File) Preconditions.checkNotNull(file);
            this.f28204b = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        private void b(File file, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            try {
                if (!file.exists()) {
                    return;
                }
                if (file.isDirectory()) {
                    c(file, builder);
                } else {
                    e(file, set, builder);
                }
            } catch (SecurityException e4) {
                Logger logger = ClassPath.f28199b;
                logger.warning("Cannot access " + file + ": " + e4);
            }
        }

        private void c(File file, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            HashSet hashSet = new HashSet();
            hashSet.add(file.getCanonicalFile());
            d(file, "", hashSet, builder);
        }

        private void d(File file, String str, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                ClassPath.f28199b.warning("Cannot read directory " + file);
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory()) {
                    File canonicalFile = file2.getCanonicalFile();
                    if (set.add(canonicalFile)) {
                        d(canonicalFile, str + name + RemoteSettings.FORWARD_SLASH_STRING, set, builder);
                        set.remove(canonicalFile);
                    }
                } else {
                    String str2 = str + name;
                    if (!str2.equals("META-INF/MANIFEST.MF")) {
                        builder.add((ImmutableSet.Builder<ResourceInfo>) ResourceInfo.a(file2, str2, this.f28204b));
                    }
                }
            }
        }

        private void e(File file, Set<File> set, ImmutableSet.Builder<ResourceInfo> builder) throws IOException {
            try {
                JarFile jarFile = new JarFile(file);
                try {
                    UnmodifiableIterator<File> it = ClassPath.f(file, jarFile.getManifest()).iterator();
                    while (it.hasNext()) {
                        File next = it.next();
                        if (set.add(next.getCanonicalFile())) {
                            b(next, set, builder);
                        }
                    }
                    f(jarFile, builder);
                } finally {
                    try {
                        jarFile.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException unused2) {
            }
        }

        private void f(JarFile jarFile, ImmutableSet.Builder<ResourceInfo> builder) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().equals("META-INF/MANIFEST.MF")) {
                    builder.add((ImmutableSet.Builder<ResourceInfo>) ResourceInfo.a(new File(jarFile.getName()), nextElement.getName(), this.f28204b));
                }
            }
        }

        public final File a() {
            return this.f28203a;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof LocationInfo)) {
                return false;
            }
            LocationInfo locationInfo = (LocationInfo) obj;
            if (!this.f28203a.equals(locationInfo.f28203a) || !this.f28204b.equals(locationInfo.f28204b)) {
                return false;
            }
            return true;
        }

        public ImmutableSet<ResourceInfo> g(Set<File> set) throws IOException {
            ImmutableSet.Builder<ResourceInfo> builder = ImmutableSet.builder();
            set.add(this.f28203a);
            b(this.f28203a, set, builder);
            return builder.build();
        }

        public int hashCode() {
            return this.f28203a.hashCode();
        }

        public String toString() {
            return this.f28203a.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static class ResourceInfo {

        /* renamed from: a  reason: collision with root package name */
        private final File f28205a;

        /* renamed from: b  reason: collision with root package name */
        private final String f28206b;

        /* renamed from: c  reason: collision with root package name */
        final ClassLoader f28207c;

        ResourceInfo(File file, String str, ClassLoader classLoader) {
            this.f28205a = (File) Preconditions.checkNotNull(file);
            this.f28206b = (String) Preconditions.checkNotNull(str);
            this.f28207c = (ClassLoader) Preconditions.checkNotNull(classLoader);
        }

        static ResourceInfo a(File file, String str, ClassLoader classLoader) {
            if (str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                return new ClassInfo(file, str, classLoader);
            }
            return new ResourceInfo(file, str, classLoader);
        }

        public final ByteSource asByteSource() {
            return Resources.asByteSource(url());
        }

        public final CharSource asCharSource(Charset charset) {
            return Resources.asCharSource(url(), charset);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ResourceInfo)) {
                return false;
            }
            ResourceInfo resourceInfo = (ResourceInfo) obj;
            if (!this.f28206b.equals(resourceInfo.f28206b) || this.f28207c != resourceInfo.f28207c) {
                return false;
            }
            return true;
        }

        public final String getResourceName() {
            return this.f28206b;
        }

        public int hashCode() {
            return this.f28206b.hashCode();
        }

        public String toString() {
            return this.f28206b;
        }

        public final URL url() {
            URL resource = this.f28207c.getResource(this.f28206b);
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException(this.f28206b);
        }
    }

    private ClassPath(ImmutableSet<ResourceInfo> immutableSet) {
        this.f28201a = immutableSet;
    }

    private static ImmutableList<URL> b(ClassLoader classLoader) {
        if (classLoader instanceof URLClassLoader) {
            return ImmutableList.copyOf(((URLClassLoader) classLoader).getURLs());
        }
        if (classLoader.equals(ClassLoader.getSystemClassLoader())) {
            return h();
        }
        return ImmutableList.of();
    }

    @VisibleForTesting
    static String c(String str) {
        return str.substring(0, str.length() - 6).replace('/', '.');
    }

    @VisibleForTesting
    static ImmutableMap<File, ClassLoader> d(ClassLoader classLoader) {
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        ClassLoader parent = classLoader.getParent();
        if (parent != null) {
            newLinkedHashMap.putAll(d(parent));
        }
        UnmodifiableIterator<URL> it = b(classLoader).iterator();
        while (it.hasNext()) {
            URL next = it.next();
            if (next.getProtocol().equals("file")) {
                File i4 = i(next);
                if (!newLinkedHashMap.containsKey(i4)) {
                    newLinkedHashMap.put(i4, classLoader);
                }
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @VisibleForTesting
    static URL e(File file, String str) throws MalformedURLException {
        return new URL(file.toURI().toURL(), str);
    }

    @VisibleForTesting
    static ImmutableSet<File> f(File file, @CheckForNull Manifest manifest) {
        if (manifest == null) {
            return ImmutableSet.of();
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        String value = manifest.getMainAttributes().getValue(Attributes.Name.CLASS_PATH.toString());
        if (value != null) {
            for (String str : f28200c.split(value)) {
                try {
                    URL e4 = e(file, str);
                    if (e4.getProtocol().equals("file")) {
                        builder.add((ImmutableSet.Builder) i(e4));
                    }
                } catch (MalformedURLException unused) {
                    Logger logger = f28199b;
                    logger.warning("Invalid Class-Path entry: " + str);
                }
            }
        }
        return builder.build();
    }

    public static ClassPath from(ClassLoader classLoader) throws IOException {
        ImmutableSet<LocationInfo> g4 = g(classLoader);
        HashSet hashSet = new HashSet();
        UnmodifiableIterator<LocationInfo> it = g4.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().a());
        }
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<LocationInfo> it2 = g4.iterator();
        while (it2.hasNext()) {
            builder.addAll((Iterable) it2.next().g(hashSet));
        }
        return new ClassPath(builder.build());
    }

    static ImmutableSet<LocationInfo> g(ClassLoader classLoader) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<Map.Entry<File, ClassLoader>> it = d(classLoader).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<File, ClassLoader> next = it.next();
            builder.add((ImmutableSet.Builder) new LocationInfo(next.getKey(), next.getValue()));
        }
        return builder.build();
    }

    @VisibleForTesting
    static ImmutableList<URL> h() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (String str : Splitter.on(StandardSystemProperty.PATH_SEPARATOR.value()).split(StandardSystemProperty.JAVA_CLASS_PATH.value())) {
            try {
                try {
                    builder.add((ImmutableList.Builder) new File(str).toURI().toURL());
                } catch (SecurityException unused) {
                    builder.add((ImmutableList.Builder) new URL("file", (String) null, new File(str).getAbsolutePath()));
                }
            } catch (MalformedURLException e4) {
                Logger logger = f28199b;
                Level level = Level.WARNING;
                logger.log(level, "malformed classpath entry: " + str, (Throwable) e4);
            }
        }
        return builder.build();
    }

    @VisibleForTesting
    static File i(URL url) {
        Preconditions.checkArgument(url.getProtocol().equals("file"));
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        }
    }

    public ImmutableSet<ClassInfo> getAllClasses() {
        return FluentIterable.from(this.f28201a).filter(ClassInfo.class).toSet();
    }

    public ImmutableSet<ResourceInfo> getResources() {
        return this.f28201a;
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses() {
        return FluentIterable.from(this.f28201a).filter(ClassInfo.class).filter(new Predicate() { // from class: com.google.common.reflect.a
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return ((ClassPath.ClassInfo) obj).isTopLevel();
            }
        }).toSet();
    }

    public ImmutableSet<ClassInfo> getTopLevelClassesRecursive(String str) {
        Preconditions.checkNotNull(str);
        String str2 = str + '.';
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getName().startsWith(str2)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }

    public ImmutableSet<ClassInfo> getTopLevelClasses(String str) {
        Preconditions.checkNotNull(str);
        ImmutableSet.Builder builder = ImmutableSet.builder();
        UnmodifiableIterator<ClassInfo> it = getTopLevelClasses().iterator();
        while (it.hasNext()) {
            ClassInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                builder.add((ImmutableSet.Builder) next);
            }
        }
        return builder.build();
    }
}
