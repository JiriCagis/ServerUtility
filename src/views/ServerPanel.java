package views;

import data.ServerInfo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.ServerService;
import views.listeners.MainWindowListener;

public class ServerPanel extends javax.swing.JPanel {

    private MainWindowListener listener;
    private ServerService service;
    private ServerInfo serverInfo;

    public ServerPanel(ServerInfo serverInfo, MainWindowListener listener) {
        initComponents();
        this.serverInfo = serverInfo;
        this.listener = listener;
        this.service = ServerService.getInstance();
        registrateButtonListeners();
        serverNameLbl.setText(serverInfo.getServerName());
        
        if(serverInfo.isRun())
        {
            indicationPanel.setBackground(Color.GREEN);
            startBtn.setEnabled(false);
            
        }
        else if(service.isAvailable(serverInfo)){
            indicationPanel.setBackground(Color.YELLOW);
            stopBtn.setEnabled(false);
            restartBtn.setEnabled(false);
        }
        else{
            indicationPanel.setBackground(Color.RED);
            startBtn.setEnabled(true);
            stopBtn.setEnabled(false);
            restartBtn.setEnabled(false);   
        }
        
    }

    private void registrateButtonListeners() {
        configurateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listener.openConfigServerDialog(serverInfo);
            }
        });

        delBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                service.remove(serverInfo);
                listener.updateServers();
            }
        });

        startBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                service.startServer(serverInfo.getId());
                listener.updateServers();
            }
        });

        restartBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                service.restartServer(serverInfo.getId());
                listener.updateServers();
            }
        });

        stopBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                service.stopServer(serverInfo.getId());
                listener.updateServers();
            }
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverNameLbl = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        restartBtn = new javax.swing.JButton();
        configurateBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        indicationPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(225, 340));
        setMinimumSize(new java.awt.Dimension(225, 340));
        setPreferredSize(new java.awt.Dimension(225, 340));

        serverNameLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        serverNameLbl.setText("Server 1");

        startBtn.setBackground(new java.awt.Color(51, 204, 0));
        startBtn.setText("Start");
        startBtn.setMinimumSize(new java.awt.Dimension(238, 25));

        stopBtn.setBackground(new java.awt.Color(255, 51, 51));
        stopBtn.setText("Stop");

        restartBtn.setBackground(new java.awt.Color(204, 204, 0));
        restartBtn.setText("Restart");

        configurateBtn.setText("Configurate");

        delBtn.setText("Del");

        indicationPanel.setBackground(new java.awt.Color(102, 255, 0));
        indicationPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout indicationPanelLayout = new javax.swing.GroupLayout(indicationPanel);
        indicationPanel.setLayout(indicationPanelLayout);
        indicationPanelLayout.setHorizontalGroup(
            indicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        indicationPanelLayout.setVerticalGroup(
            indicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(configurateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(indicationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(serverNameLbl))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(stopBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(restartBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(indicationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(restartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configurateBtn)
                    .addComponent(delBtn))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        serverNameLbl.getAccessibleContext().setAccessibleName("serverNameLbl");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configurateBtn;
    private javax.swing.JButton delBtn;
    private javax.swing.JPanel indicationPanel;
    private javax.swing.JButton restartBtn;
    private javax.swing.JLabel serverNameLbl;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
}
