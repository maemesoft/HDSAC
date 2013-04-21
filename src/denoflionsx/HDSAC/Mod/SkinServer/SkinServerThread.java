package denoflionsx.HDSAC.Mod.SkinServer;

public class SkinServerThread extends Thread {

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
}
