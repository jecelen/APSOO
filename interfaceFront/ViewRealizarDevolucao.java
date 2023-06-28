package interfaceFront;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controladoras.ControladorDevolucao;

import java.util.ArrayList;
import java.awt.*;
import java.sql.SQLException;
import java.util.Enumeration;

public class ViewRealizarDevolucao extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	private JPanel painel;
	private JLabel cpf;
	private JTextField dCPF;
	private JButton buscaCPF;
	private JTextField nomeCliente;
	private JLabel codProd;
	private JTextField dCodProd;
	private JButton buscaProd;
	private JTextField dDescrProd;
	private JLabel descrProd;
	private JButton confirmaDev;
	private JButton cancela;
	private JTextField dMotivo;
	private JLabel motivo;
	private JLabel tituloDev;
	private JCheckBox apto;
	private JTable vendasRetornadas;
	private JSeparator jSeparator1;
	private JScrollPane jScrollPane1;
	private JLabel data;
	private DefaultTableModel model;
	private JRadioButton vendaSelecionada;
	
	
	
	
	 public ViewRealizarDevolucao() {
		 
		 ControladorDevolucao contro2 = new ControladorDevolucao();
		 
		 
		 
		 	setVisible(true);
			
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setTitle("Realizar Devolução");
	        setBackground(new java.awt.Color(255, 255, 255));
	        
	        data = new javax.swing.JLabel();
	        painel = new javax.swing.JPanel();
	        cpf = new javax.swing.JLabel();
	        dCPF = new javax.swing.JTextField();
	        buscaCPF = new javax.swing.JButton();
	        nomeCliente = new javax.swing.JTextField();
	        jSeparator1 = new javax.swing.JSeparator();
	        codProd = new javax.swing.JLabel();
	        buscaProd = new javax.swing.JButton();
	        dCodProd = new javax.swing.JTextField();
	        descrProd = new javax.swing.JLabel();
	        dDescrProd = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        
	        dMotivo = new javax.swing.JTextField();
	        motivo = new javax.swing.JLabel();
	        apto = new javax.swing.JCheckBox();
	        cancela = new javax.swing.JButton();
	        confirmaDev = new javax.swing.JButton();
	        tituloDev = new javax.swing.JLabel();
	        model = new DefaultTableModel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setBackground(new java.awt.Color(255, 255, 255));

	        painel.setBackground(new java.awt.Color(255, 255, 255));
	        painel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
	        painel.setMaximumSize(new java.awt.Dimension(500, 500));
	      
	        cpf.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
	        cpf.setText("CPF do cliente");

	        dCPF.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
	        dCPF.setToolTipText("");
	       

	        buscaCPF.setBackground(new java.awt.Color(0, 204, 204));
	        buscaCPF.setForeground(new java.awt.Color(255, 255, 255));
	        buscaCPF.setText("🔍");
	        buscaCPF.setToolTipText("");
	        

	        nomeCliente.setEditable(false);
	        nomeCliente.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N

	        codProd.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
	        codProd.setText("Código do produto");

	        buscaProd.setBackground(new java.awt.Color(0, 204, 204));
	        buscaProd.setForeground(new java.awt.Color(255, 255, 255));
	        buscaProd.setText("🔍");
	        buscaProd.setToolTipText("");

	        dCodProd.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
	        dCodProd.setToolTipText("");
	       

	        descrProd.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
	        descrProd.setText("Descrição do produto");

	        dDescrProd.setEditable(false);
	        dDescrProd.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
	        dDescrProd.setToolTipText("");
	        
	        this.data.setFont(new Font("Roboto Light", 1, 14)); 
	        this.data.setForeground(new Color(0, 0, 0));
	        this.data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	        this.data.setText(contro2.getDateTime());
	        
	        
	        buscaCPF.addActionListener(e -> { //Parte de busca do Cliente
        		
	        	if(contro2.existeCliente(dCPF.getText())) {
	        		
	        		nomeCliente.setText(contro2.getNomeCli(dCPF.getText()));
	        		
	        		
	        	}else {
	        		
	        		JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
	        	}
	        	
	        	
	        });
	        
	        buscaProd.addActionListener(e -> {
	        	
	        	int codProdInt = 0;
	        	
	        	
                if(contro2.existeProduto(Integer.parseInt(dCodProd.getText()))){
                	
                	
                	
                	 codProdInt = Integer.parseInt(dCodProd.getText());
              
         			 
                	this.dDescrProd.setText(contro2.retornaNome(codProdInt));
        			
        		}else {
        			
        			JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        		}
                
                
                if(nomeCliente.getText().isEmpty() == false) {
                	
                	if(this.dDescrProd.getText().isEmpty() == false) {
                		
                		try {
							contro2.existeVendasCliente(codProdInt, dCPF.getText() );
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                		
                	}else {
                		
                		JOptionPane.showMessageDialog(null, "Produto não foi pesquisado", "Erro", JOptionPane.ERROR_MESSAGE);
                	}
                	
                }else {
                	
                	JOptionPane.showMessageDialog(null, "Cliente não foi pesquisado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
	        	
	        	
	        });

	        model.addColumn("Venda");
	        model.addColumn("Data");
	        model.addColumn("Quantidade adquirida");
	        
	        vendasRetornadas = new JTable(model);
	        vendasRetornadas.setFont(new java.awt.Font("Roboto Light", 1, 12)); 
	        vendasRetornadas.setForeground(new java.awt.Color(153, 153, 153));
	      
	       
	        model.addRow(new Object[]{"Valor 1", "Valor 2"});
	        model.addRow(new Object[]{"Valor 3", "Valor 4"});
	        model.addRow(new Object[]{"Valor 5", "Valor 6"});
	        
	        vendasRetornadas.getSelectedRow();
	        //String nome = "nome";
	        

	      
	       /* for(int i =0; i < 3; i++ ) {
	        	
	        	
	        }*/
	        /*vendasRetornadas.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null},
	             	{null, 1, contro2.getDateTime(), nome}
	            },
	            new String [] {
	                "Selecione", "Venda", "Data", "Quantidade adquirida"
	            }
	        ) {
	            
				
				private static final long serialVersionUID = 1L;
				
				Class[] types = new Class [] {
	                java.lang.Boolean.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
	            };
	            boolean[] canEdit = new boolean [] {
	                true, false, false, false
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });*/
	        //vendasRetornadas.setToolTipText("");
	        vendasRetornadas.setSelectionBackground(new java.awt.Color(0, 204, 204));
	        vendasRetornadas.setBackground(new java.awt.Color(255, 255, 255));
	        jScrollPane1.setViewportView(vendasRetornadas);

	        dMotivo.setFont(new java.awt.Font("Roboto Light", 0, 12));

	        motivo.setFont(new java.awt.Font("Roboto Light", 0, 12)); 
	        motivo.setText("Motivo da devolução");

	        apto.setFont(new java.awt.Font("Roboto Light", 0, 12)); 
	        apto.setText("Produto apto a voltar ao estoque");
	        apto.setBackground(new java.awt.Color(255,255,255));

	        cancela.setBackground(new java.awt.Color(255, 0, 51));
	        cancela.setFont(new java.awt.Font("Roboto Light", 1, 12)); 
	        cancela.setForeground(new java.awt.Color(255, 255, 255));
	        cancela.setText("Cancelar");
	        

	        confirmaDev.setBackground(new java.awt.Color(0, 204, 204));
	        confirmaDev.setFont(new java.awt.Font("Roboto Light", 1, 12)); 
	        confirmaDev.setForeground(new java.awt.Color(255, 255, 255));
	        confirmaDev.setText("Confirmar devolução");

	        tituloDev.setFont(new java.awt.Font("Roboto Light", 1, 36)); 
	        tituloDev.setForeground(new java.awt.Color(0, 204, 204));
	        tituloDev.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        tituloDev.setText("Devolução");

	        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
	        painel.setLayout(painelLayout);
	        painelLayout.setHorizontalGroup(
	            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(painelLayout.createSequentialGroup()
	                .addGap(46, 46, 46)
	                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(painelLayout.createSequentialGroup()
	                        .addComponent(cpf)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(dCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(buscaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
	                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addGroup(painelLayout.createSequentialGroup()
	                                .addGap(0, 0, Short.MAX_VALUE)
	                                .addComponent(cancela, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(confirmaDev, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
	                            .addComponent(dMotivo, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
	                            .addComponent(nomeCliente, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGap(14,14,14)
	                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelLayout.createSequentialGroup()
	                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(codProd, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGroup(painelLayout.createSequentialGroup()
	                                        .addComponent(dCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                        .addComponent(buscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                                .addGap(18, 18, 18)
	                                
	                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(dDescrProd)
	                                    .addGroup(painelLayout.createSequentialGroup()
	                                        .addComponent(descrProd)
	                                        .addGap(0, 0, Short.MAX_VALUE)))))
	                        .addGap(46, 46, 46))
	                    .addGroup(painelLayout.createSequentialGroup()
	                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(apto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(motivo))
	                        .addGap(0, 0, Short.MAX_VALUE))))
	            .addComponent(tituloDev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        painelLayout.setVerticalGroup(
	            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(painelLayout.createSequentialGroup()
	            	
	            	.addComponent(data)
	                .addGap(20, 20, 20)
	                .addComponent(tituloDev)
	                .addGap(50, 50, 50)
	                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cpf)
	                    .addComponent(dCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(buscaCPF))
	                .addGap(9,9,9)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(27, 27, 27)
	                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(codProd)
	                    .addComponent(descrProd))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(dCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(buscaProd)
	                    .addComponent(dDescrProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(37, 37, 37)
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(41, 41, 41)
	                .addComponent(motivo)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(dMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(30, 30, 30)
	                .addComponent(apto)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
	                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(cancela)
	                    .addComponent(confirmaDev))
	                .addGap(16, 16, 16))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                
	                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                
	                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	
	 }
}