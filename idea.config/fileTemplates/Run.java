#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} implements Runnable {


    @Override
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {

                if (!done)
                    wait();

                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        int N = 1;
        Thread t[] = new Thread[N];
        for (int i = 0; i < N; i++) {
            t[i] = new Thread(new ${NAME}());
            t[i].start();
        }
    }
}
