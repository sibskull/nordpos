/**
 *
 * NORD POS is a fork of Openbravo POS.
 *
 * Copyright (C) 2009-2013 Nord Trading Ltd. <http://www.nordpos.com>
 *
 * This file is part of NORD POS.
 *
 * NORD POS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * NORD POS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * NORD POS. If not, see <http://www.gnu.org/licenses/>.
 */
package com.openbravo.pos.config;

import com.openbravo.data.user.DirtyManager;
import java.awt.Component;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;

/**
 *
 * @author Andrey Svininykh <svininykh@gmail.com>
 * @version NORD POS 3
 */
public class JPanelConfigServer extends javax.swing.JPanel implements PanelConfig {

    private final DirtyManager dirty = new DirtyManager();

    String[] startupFlag = {
        "disable",
        "enable"};

    public JPanelConfigServer() {

        initComponents();

        jtxtServletWebAppPort.getDocument().addDocumentListener(dirty);
        jtxtServletWebAppPort.getDocument().addDocumentListener(dirty);
        jcboServletWebAppStartUpFlag.addActionListener(dirty);
    }

    @Override
    public boolean hasChanged() {
        return dirty.isDirty();
    }

    @Override
    public Component getConfigComponent() {
        return this;
    }

    @Override
    public String getPanelConfigName() {
        return AppLocal.getIntString("Label.Servers");
    }

    @Override
    public void loadProperties(AppConfig config) {
        if (config.getProperty("server.webapp.startup") != null && config.getProperty("server.webapp.startup").equals("enable")) {
            jcboServletWebAppStartUpFlag.setSelectedItem("enable");
        } else {
            jcboServletWebAppStartUpFlag.setSelectedItem("disable");
        }

        if (config.getProperty("server.database.startup") != null && config.getProperty("server.database.startup").equals("enable")) {
            jcboEmbeddedDatabaseStartUpFlag.setSelectedItem("enable");
        } else {
            jcboEmbeddedDatabaseStartUpFlag.setSelectedItem("disable");
        }

        jTxtServletWebAppContext.setText(config.getProperty("server.webapp.context"));
        jtxtServletWebAppPort.setText(config.getProperty("server.webapp.port"));
        dirty.setDirty(false);
    }

    @Override
    public void saveProperties(AppConfig config) {
        config.setProperty("server.webapp.startup", jcboServletWebAppStartUpFlag.getSelectedItem().toString());
        config.setProperty("server.webapp.port", jtxtServletWebAppPort.getText());
        config.setProperty("server.webapp.context", jTxtServletWebAppContext.getText());
        config.setProperty("server.database.startup", jcboEmbeddedDatabaseStartUpFlag.getSelectedItem().toString());
        dirty.setDirty(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrefix = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtServletWebAppContext = new javax.swing.JTextField();
        jtxtServletWebAppPort = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jcboServletWebAppStartUpFlag = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jPanelPrefix1 = new javax.swing.JPanel();
        jcboEmbeddedDatabaseStartUpFlag = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();

        jPanelPrefix.setBorder(javax.swing.BorderFactory.createTitledBorder(AppLocal.getIntString("Label.WebAppsServer"))); // NOI18N

        jLabel1.setText(AppLocal.getIntString("label.ServerWebApps.context")); // NOI18N

        jLabel18.setText(AppLocal.getIntString("label.ServerWebApps.port")); // NOI18N

        jcboServletWebAppStartUpFlag.setModel(new javax.swing.DefaultComboBoxModel(startupFlag));

        jLabel19.setText(AppLocal.getIntString("label.ServerWebApps.startup")); // NOI18N

        javax.swing.GroupLayout jPanelPrefixLayout = new javax.swing.GroupLayout(jPanelPrefix);
        jPanelPrefix.setLayout(jPanelPrefixLayout);
        jPanelPrefixLayout.setHorizontalGroup(
            jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrefixLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addGroup(jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcboServletWebAppStartUpFlag, 0, 165, Short.MAX_VALUE)
                    .addComponent(jTxtServletWebAppContext, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jtxtServletWebAppPort))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanelPrefixLayout.setVerticalGroup(
            jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrefixLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jcboServletWebAppStartUpFlag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jtxtServletWebAppPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelPrefixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jTxtServletWebAppContext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPrefix1.setBorder(javax.swing.BorderFactory.createTitledBorder(AppLocal.getIntString("Label.DatabaseServer"))); // NOI18N

        jcboEmbeddedDatabaseStartUpFlag.setModel(new javax.swing.DefaultComboBoxModel(startupFlag));

        jLabel21.setText(AppLocal.getIntString("label.ServerWebApps.startup")); // NOI18N

        javax.swing.GroupLayout jPanelPrefix1Layout = new javax.swing.GroupLayout(jPanelPrefix1);
        jPanelPrefix1.setLayout(jPanelPrefix1Layout);
        jPanelPrefix1Layout.setHorizontalGroup(
            jPanelPrefix1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrefix1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21)
                .addGap(7, 7, 7)
                .addComponent(jcboEmbeddedDatabaseStartUpFlag, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        jPanelPrefix1Layout.setVerticalGroup(
            jPanelPrefix1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrefix1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelPrefix1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jcboEmbeddedDatabaseStartUpFlag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelPrefix1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelPrefix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanelPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrefix1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanelPrefix;
    private javax.swing.JPanel jPanelPrefix1;
    private javax.swing.JTextField jTxtServletWebAppContext;
    private javax.swing.JComboBox jcboEmbeddedDatabaseStartUpFlag;
    private javax.swing.JComboBox jcboServletWebAppStartUpFlag;
    private javax.swing.JTextField jtxtServletWebAppPort;
    // End of variables declaration//GEN-END:variables

}