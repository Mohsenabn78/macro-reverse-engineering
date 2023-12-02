package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.StandardSystemProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.io.TempFileCreator;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.EnumSet;
import java.util.Set;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
abstract class TempFileCreator {

    /* renamed from: a  reason: collision with root package name */
    static final TempFileCreator f28045a = c();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class JavaIoCreator extends TempFileCreator {
        private JavaIoCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        File a() {
            File file = new File(StandardSystemProperty.JAVA_IO_TMPDIR.value());
            String str = System.currentTimeMillis() + "-";
            for (int i4 = 0; i4 < 10000; i4++) {
                File file2 = new File(file, str + i4);
                if (file2.mkdir()) {
                    return file2;
                }
            }
            throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + "9999)");
        }

        @Override // com.google.common.io.TempFileCreator
        File b(String str) throws IOException {
            return File.createTempFile(str, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ThrowingCreator extends TempFileCreator {
        private ThrowingCreator() {
            super();
        }

        @Override // com.google.common.io.TempFileCreator
        File a() {
            throw new IllegalStateException("Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().");
        }

        @Override // com.google.common.io.TempFileCreator
        File b(String str) throws IOException {
            throw new IOException("Guava cannot securely create temporary files or directories under SDK versions before Jelly Bean. You can create one yourself, either in the insecure default directory or in a more secure directory, such as context.getCacheDir(). For more information, see the Javadoc for Files.createTempDir().");
        }
    }

    private TempFileCreator() {
    }

    private static TempFileCreator c() {
        try {
            try {
                Class.forName("java.nio.file.Path");
                return new JavaNioCreator();
            } catch (ClassNotFoundException unused) {
                return new ThrowingCreator();
            } catch (IllegalAccessException unused2) {
                return new ThrowingCreator();
            } catch (NoSuchFieldException unused3) {
                return new ThrowingCreator();
            }
        } catch (ClassNotFoundException unused4) {
            if (((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue() < ((Integer) Class.forName("android.os.Build$VERSION_CODES").getField("JELLY_BEAN").get(null)).intValue()) {
                return new ThrowingCreator();
            }
            return new JavaIoCreator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract File a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract File b(String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: private */
    @IgnoreJRERequirement
    /* loaded from: classes5.dex */
    public static final class JavaNioCreator extends TempFileCreator {

        /* renamed from: b  reason: collision with root package name */
        private static final PermissionSupplier f28046b;

        /* renamed from: c  reason: collision with root package name */
        private static final PermissionSupplier f28047c;

        /* JADX INFO: Access modifiers changed from: private */
        @IgnoreJRERequirement
        /* loaded from: classes5.dex */
        public interface PermissionSupplier {
            FileAttribute<?> get() throws IOException;
        }

        static {
            FileSystem fileSystem;
            Set supportedFileAttributeViews;
            fileSystem = FileSystems.getDefault();
            supportedFileAttributeViews = fileSystem.supportedFileAttributeViews();
            if (supportedFileAttributeViews.contains("posix")) {
                f28046b = new PermissionSupplier() { // from class: com.google.common.io.t
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        FileAttribute i4;
                        i4 = TempFileCreator.JavaNioCreator.i();
                        return i4;
                    }
                };
                f28047c = new PermissionSupplier() { // from class: com.google.common.io.u
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        FileAttribute j4;
                        j4 = TempFileCreator.JavaNioCreator.j();
                        return j4;
                    }
                };
            } else if (supportedFileAttributeViews.contains("acl")) {
                PermissionSupplier n4 = n();
                f28047c = n4;
                f28046b = n4;
            } else {
                PermissionSupplier permissionSupplier = new PermissionSupplier() { // from class: com.google.common.io.v
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        FileAttribute k4;
                        k4 = TempFileCreator.JavaNioCreator.k();
                        return k4;
                    }
                };
                f28047c = permissionSupplier;
                f28046b = permissionSupplier;
            }
        }

        private JavaNioCreator() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute i() throws IOException {
            Set fromString;
            FileAttribute asFileAttribute;
            fromString = PosixFilePermissions.fromString("rw-------");
            asFileAttribute = PosixFilePermissions.asFileAttribute(fromString);
            return asFileAttribute;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute j() throws IOException {
            Set fromString;
            FileAttribute asFileAttribute;
            fromString = PosixFilePermissions.fromString("rwx------");
            asFileAttribute = PosixFilePermissions.asFileAttribute(fromString);
            return asFileAttribute;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute k() throws IOException {
            FileSystem fileSystem;
            StringBuilder sb = new StringBuilder();
            sb.append("unrecognized FileSystem type ");
            fileSystem = FileSystems.getDefault();
            sb.append(fileSystem);
            throw new IOException(sb.toString());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute m(IOException iOException) throws IOException {
            throw new IOException("Could not find user", iOException);
        }

        private static PermissionSupplier n() {
            FileSystem fileSystem;
            UserPrincipalLookupService userPrincipalLookupService;
            UserPrincipal lookupPrincipalByName;
            AclEntry.Builder newBuilder;
            AclEntryType aclEntryType;
            AclEntry.Builder type;
            AclEntry.Builder principal;
            AclEntry.Builder permissions;
            AclEntryFlag aclEntryFlag;
            AclEntryFlag aclEntryFlag2;
            AclEntry.Builder flags;
            AclEntry build;
            try {
                fileSystem = FileSystems.getDefault();
                userPrincipalLookupService = fileSystem.getUserPrincipalLookupService();
                lookupPrincipalByName = userPrincipalLookupService.lookupPrincipalByName(StandardSystemProperty.USER_NAME.value());
                newBuilder = AclEntry.newBuilder();
                aclEntryType = AclEntryType.ALLOW;
                type = newBuilder.setType(aclEntryType);
                principal = type.setPrincipal(lookupPrincipalByName);
                permissions = principal.setPermissions(EnumSet.allOf(AclEntryPermission.class));
                aclEntryFlag = AclEntryFlag.DIRECTORY_INHERIT;
                aclEntryFlag2 = AclEntryFlag.FILE_INHERIT;
                flags = permissions.setFlags(aclEntryFlag, aclEntryFlag2);
                build = flags.build();
                final ImmutableList of = ImmutableList.of(build);
                final FileAttribute<ImmutableList<AclEntry>> fileAttribute = new FileAttribute<ImmutableList<AclEntry>>() { // from class: com.google.common.io.TempFileCreator.JavaNioCreator.1
                    @Override // java.nio.file.attribute.FileAttribute
                    /* renamed from: a */
                    public ImmutableList<AclEntry> value() {
                        return ImmutableList.this;
                    }

                    @Override // java.nio.file.attribute.FileAttribute
                    public String name() {
                        return "acl:acl";
                    }
                };
                return new PermissionSupplier() { // from class: com.google.common.io.w
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        FileAttribute l4;
                        l4 = TempFileCreator.JavaNioCreator.l(fileAttribute);
                        return l4;
                    }
                };
            } catch (IOException e4) {
                return new PermissionSupplier() { // from class: com.google.common.io.x
                    @Override // com.google.common.io.TempFileCreator.JavaNioCreator.PermissionSupplier
                    public final FileAttribute get() {
                        FileAttribute m4;
                        m4 = TempFileCreator.JavaNioCreator.m(e4);
                        return m4;
                    }
                };
            }
        }

        @Override // com.google.common.io.TempFileCreator
        File a() {
            Path path;
            Path createTempDirectory;
            File file;
            try {
                path = Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]);
                createTempDirectory = java.nio.file.Files.createTempDirectory(path, null, f28047c.get());
                file = createTempDirectory.toFile();
                return file;
            } catch (IOException e4) {
                throw new IllegalStateException("Failed to create directory", e4);
            }
        }

        @Override // com.google.common.io.TempFileCreator
        File b(String str) throws IOException {
            Path path;
            Path createTempFile;
            File file;
            path = Paths.get(StandardSystemProperty.JAVA_IO_TMPDIR.value(), new String[0]);
            createTempFile = java.nio.file.Files.createTempFile(path, str, null, f28046b.get());
            file = createTempFile.toFile();
            return file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ FileAttribute l(FileAttribute fileAttribute) throws IOException {
            return fileAttribute;
        }
    }
}
