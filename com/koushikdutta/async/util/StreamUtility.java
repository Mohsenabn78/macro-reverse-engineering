package com.koushikdutta.async.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/* loaded from: classes6.dex */
public class StreamUtility {
    public static void closeQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        fastChannelCopy(Channels.newChannel(inputStream), Channels.newChannel(outputStream));
    }

    public static void eat(InputStream inputStream) throws IOException {
        do {
        } while (inputStream.read(new byte[1024]) != -1);
    }

    public static void fastChannelCopy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
        while (readableByteChannel.read(allocateDirect) != -1) {
            allocateDirect.flip();
            writableByteChannel.write(allocateDirect);
            allocateDirect.compact();
        }
        allocateDirect.flip();
        while (allocateDirect.hasRemaining()) {
            writableByteChannel.write(allocateDirect);
        }
    }

    public static String readFile(String str) throws IOException {
        return readFile(new File(str));
    }

    public static String readFileSilent(String str) {
        try {
            return readFile(new File(str));
        } catch (IOException unused) {
            return null;
        }
    }

    public static String readToEnd(InputStream inputStream) throws IOException {
        return new String(readToEndAsArray(inputStream));
    }

    public static byte[] readToEndAsArray(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = dataInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                dataInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void writeFile(File file, String str) throws IOException {
        file.getParentFile().mkdirs();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        dataOutputStream.write(str.getBytes());
        dataOutputStream.close();
    }

    public static String readFile(File file) throws IOException {
        DataInputStream dataInputStream;
        byte[] bArr = new byte[(int) file.length()];
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataInputStream.readFully(bArr);
            closeQuietly(dataInputStream);
            return new String(bArr);
        } catch (Throwable th2) {
            th = th2;
            dataInputStream2 = dataInputStream;
            closeQuietly(dataInputStream2);
            throw th;
        }
    }

    public static void writeFile(String str, String str2) throws IOException {
        writeFile(new File(str), str2);
    }
}
