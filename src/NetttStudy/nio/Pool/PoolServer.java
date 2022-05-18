package NetttStudy.nio.Pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class PoolServer {

    ExecutorService pool = Executor.newFixedThreadPool(50);
    private Selector selector;
    //中文测试

    public static void main(String[] args) {
        PoolServer server = new PoolServer();
        server.initServer(8888);
        server.listen();
    }

    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel =ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
    }

}
