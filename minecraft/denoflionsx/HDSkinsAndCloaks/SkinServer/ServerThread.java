package denoflionsx.HDSkinsAndCloaks.SkinServer;

public class ServerThread extends Thread {

    private boolean hasStarted = false;

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            if (!hasStarted) {
                StartServer.Start();
                hasStarted = true;
            }
        }
    }
    
    public void killThread(){
        this.interrupt();
    }
}
