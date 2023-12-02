package com.sun.mail.util;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOption;
import java.nio.channels.SocketChannel;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes6.dex */
public class WriteTimeoutSocket extends Socket {
    private final ScheduledExecutorService ses;
    private final Socket socket;
    private final int timeout;

    public WriteTimeoutSocket(Socket socket, int i4) throws IOException {
        this.socket = socket;
        this.ses = Executors.newScheduledThreadPool(1);
        this.timeout = i4;
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) throws IOException {
        this.socket.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.socket.close();
        } finally {
            this.ses.shutdownNow();
        }
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress) throws IOException {
        this.socket.connect(socketAddress, 0);
    }

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return this.socket.getChannel();
    }

    public FileDescriptor getFileDescriptor$() {
        Method declaredMethod;
        for (Class<?> cls = this.socket.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                declaredMethod = cls.getDeclaredMethod("getFileDescriptor$", new Class[0]);
            } catch (Exception unused) {
            }
            if (FileDescriptor.class.isAssignableFrom(declaredMethod.getReturnType())) {
                return (FileDescriptor) declaredMethod.invoke(this.socket, new Object[0]);
            }
            continue;
        }
        return null;
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return this.socket.getInetAddress();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() throws SocketException {
        return this.socket.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return this.socket.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return this.socket.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return this.socket.getLocalSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getOOBInline() throws SocketException {
        return this.socket.getOOBInline();
    }

    public <T> T getOption(SocketOption<T> socketOption) throws IOException {
        throw new UnsupportedOperationException("WriteTimeoutSocket.getOption");
    }

    @Override // java.net.Socket
    public synchronized OutputStream getOutputStream() throws IOException {
        return new TimeoutOutputStream(this.socket.getOutputStream(), this.ses, this.timeout);
    }

    @Override // java.net.Socket
    public int getPort() {
        return this.socket.getPort();
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() throws SocketException {
        return this.socket.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return this.socket.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() throws SocketException {
        return this.socket.getReuseAddress();
    }

    @Override // java.net.Socket
    public int getSendBufferSize() throws SocketException {
        return this.socket.getSendBufferSize();
    }

    @Override // java.net.Socket
    public int getSoLinger() throws SocketException {
        return this.socket.getSoLinger();
    }

    @Override // java.net.Socket
    public int getSoTimeout() throws SocketException {
        return this.socket.getSoTimeout();
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() throws SocketException {
        return this.socket.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public int getTrafficClass() throws SocketException {
        return this.socket.getTrafficClass();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return this.socket.isBound();
    }

    @Override // java.net.Socket
    public boolean isClosed() {
        return this.socket.isClosed();
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    @Override // java.net.Socket
    public void sendUrgentData(int i4) throws IOException {
        this.socket.sendUrgentData(i4);
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z3) throws SocketException {
        this.socket.setKeepAlive(z3);
    }

    @Override // java.net.Socket
    public void setOOBInline(boolean z3) throws SocketException {
        this.socket.setOOBInline(z3);
    }

    public <T> Socket setOption(SocketOption<T> socketOption, T t3) throws IOException {
        throw new UnsupportedOperationException("WriteTimeoutSocket.setOption");
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i4, int i5, int i6) {
        this.socket.setPerformancePreferences(i4, i5, i6);
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i4) throws SocketException {
        this.socket.setReceiveBufferSize(i4);
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z3) throws SocketException {
        this.socket.setReuseAddress(z3);
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i4) throws SocketException {
        this.socket.setSendBufferSize(i4);
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z3, int i4) throws SocketException {
        this.socket.setSoLinger(z3, i4);
    }

    @Override // java.net.Socket
    public void setSoTimeout(int i4) throws SocketException {
        this.socket.setSoTimeout(i4);
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z3) throws SocketException {
        this.socket.setTcpNoDelay(z3);
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i4) throws SocketException {
        this.socket.setTrafficClass(i4);
    }

    @Override // java.net.Socket
    public void shutdownInput() throws IOException {
        this.socket.shutdownInput();
    }

    @Override // java.net.Socket
    public void shutdownOutput() throws IOException {
        this.socket.shutdownOutput();
    }

    public Set<SocketOption<?>> supportedOptions() {
        return Collections.emptySet();
    }

    @Override // java.net.Socket
    public String toString() {
        return this.socket.toString();
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i4) throws IOException {
        this.socket.connect(socketAddress, i4);
    }

    public WriteTimeoutSocket(int i4) throws IOException {
        this(new Socket(), i4);
    }

    public WriteTimeoutSocket(InetAddress inetAddress, int i4, int i5) throws IOException {
        this(i5);
        this.socket.connect(new InetSocketAddress(inetAddress, i4));
    }

    public WriteTimeoutSocket(InetAddress inetAddress, int i4, InetAddress inetAddress2, int i5, int i6) throws IOException {
        this(i6);
        this.socket.bind(new InetSocketAddress(inetAddress2, i5));
        this.socket.connect(new InetSocketAddress(inetAddress, i4));
    }

    public WriteTimeoutSocket(String str, int i4, int i5) throws IOException {
        this(i5);
        this.socket.connect(new InetSocketAddress(str, i4));
    }

    public WriteTimeoutSocket(String str, int i4, InetAddress inetAddress, int i5, int i6) throws IOException {
        this(i6);
        this.socket.bind(new InetSocketAddress(inetAddress, i5));
        this.socket.connect(new InetSocketAddress(str, i4));
    }
}
