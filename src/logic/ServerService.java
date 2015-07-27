package logic;

import data.ServerInfo;
import data.XmlParser;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.synchronize.SynchronizeManager;
import logic.synchronize.SynchronizeManagerImpl;

public class ServerService {

    private static ServerService serverService;
    private List<ServerInfo> serversInfo;
    private final File outFile = new File("configuration.xml");
    private SynchronizeManager synchronizeManager;

    private ServerService() {
        serversInfo = XmlParser.parse(outFile);
        synchronizeManager = new SynchronizeManagerImpl();
    }

    public static ServerService getInstance() {
        if (serverService == null) {
            serverService = new ServerService();
        }
        return serverService;
    }

    public ServerInfo createNewServerInfo() {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setId(serversInfo.size());
        serversInfo.add(serverInfo);
        return serverInfo;
    }

    public void remove(ServerInfo serverInfo) {
        serversInfo.remove(serverInfo);
    }

    public void update(ServerInfo serverInfo) {
        for (int i = 0; i < serversInfo.size(); i++) {
            if (serversInfo.get(i).getId() == serverInfo.getId()) {
                serversInfo.set(i, serverInfo);
            }
        }
    }

     public List<ServerInfo> getServersInfo() {
        return serversInfo;
    }
    public void startServer(ServerInfo serverInfo) {
        serverInfo.setRun(true);
        try {
            Runtime.getRuntime().exec("cmd /C start "+serverInfo.getStartScript());
        } catch (IOException ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopServer(ServerInfo serverInfo) {
        serverInfo.setRun(false);
        try {
            Runtime.getRuntime().exec("cmd /c start "+serverInfo.getStopScript());
        } catch (IOException ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void restartServer(ServerInfo serverInfo) {
        try {
            Runtime.getRuntime().exec("cmd /c start "+serverInfo.getRestartScript());
        } catch (IOException ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isAvailable(ServerInfo info) { 
        File startScript = new File(info.getStartScript());
        File restartScript = new File(info.getRestartScript());
        File stopScript = new File(info.getStopScript());
        File sourceFolder = new File(info.getSourceFolder());
        File targetFolder = new File(info.getTargetFolder());
        
        return true;
//        return (startScript.isFile() && restartScript.isFile() && stopScript.isFile() && 
//                (info.isAutomaticSynchnize() ? (sourceFolder.isDirectory() && targetFolder.isDirectory()) : true));
    } 
    
    public void saveState(){
        XmlParser.save(serversInfo, outFile);
    }
}
