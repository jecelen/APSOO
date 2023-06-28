package interfaceFront;

import javax.swing.*;

import java.awt.*;

public class ViewMenu extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private javax.swing.JPanel painel;
    private javax.swing.JButton realizarDevolucao;
    private javax.swing.JButton realizarVenda;
    private javax.swing.JSeparator separador;
    private javax.swing.JLabel tituloPagina;
	
	public ViewMenu() {
		
		setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Fujinohara Móveis");
		
		painel = new javax.swing.JPanel();
        realizarVenda = new javax.swing.JButton();
        realizarDevolucao = new javax.swing.JButton();
        tituloPagina = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        painel.setBackground(new java.awt.Color(255, 255, 255));
        painel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painel.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        realizarVenda.setBackground(new java.awt.Color(0, 204, 204));
        realizarVenda.setFont(new java.awt.Font("Roboto Light", 1, 18));
        realizarVenda.setForeground(new java.awt.Color(255, 255, 255));
        realizarVenda.setText("Realizar Venda");
        realizarVenda.setToolTipText("");
        realizarVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        realizarVenda.addActionListener(e -> {
        	
        	ViewRealizarVenda venda = new ViewRealizarVenda();;
           	
        });
       

        realizarDevolucao.setBackground(new java.awt.Color(0, 204, 204));
        realizarDevolucao.setFont(new java.awt.Font("Roboto Light", 1, 18));
        realizarDevolucao.setForeground(new java.awt.Color(255, 255, 255));
        realizarDevolucao.setText("Realizar devolução");
        realizarDevolucao.addActionListener(e -> {
        	
        	ViewRealizarDevolucao dev = new ViewRealizarDevolucao();;
           	
        });

        tituloPagina.setFont(new java.awt.Font("Roboto Light", 1, 36));
        tituloPagina.setForeground(new java.awt.Color(153, 153, 153));
        tituloPagina.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPagina.setText("Fujinohara Móveis");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloPagina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(realizarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(realizarDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(212, 212, 212))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(tituloPagina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                .addGap(84, 84, 84)
                .addComponent(realizarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(realizarDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
		
}
