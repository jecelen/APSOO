package interfaceFront;

import javax.swing.*;

import controladoras.Controller1;

import java.util.ArrayList;
import java.awt.*;
import java.sql.SQLException;
import java.util.Enumeration;


public class ViewRealizarVenda extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton buscaCPF;
	private JScrollPane jScrollPane2;
	private JTextArea jList1;
	private JPanel jPanel2;
    private JButton cancelaVenda;
    private JTextField codProd;
    private JButton confirmaVenda;
    private JLabel cpf;
    private JTextField dadoCPF;
    private JTextField dadoNomeCli;
    private JComboBox<String> dadoPagamento;
    private JTextField descrProd;
    private JLabel entrega;
    private ButtonGroup dadoEntrega;
    private JRadioButton entregaNao;
    private JRadioButton entregaSim;
    private JPanel jPanel1;
    private JButton maisProd;
    private JLabel nomeCli;
    private JLabel pagamento;
    private JTextField qttdProd;
    private JSeparator separador;
    private JLabel tCodProd;
    private JLabel tDescricao;
    private JLabel tQtdd;
    private JLabel titulo;
    private JLabel tValor;
    private JTextField valor;
    private JLabel data;
    private ArrayList<String> itens;
    

	
	public ViewRealizarVenda(){
		
		Controller1 control = new Controller1();
		
		

		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
        titulo = new JLabel();
        tCodProd = new JLabel();
        tDescricao = new JLabel();
        tQtdd = new JLabel();
        codProd = new JTextField();
        descrProd = new JTextField();
        qttdProd = new JTextField();
        maisProd = new JButton();
        separador = new JSeparator();
        cpf = new JLabel();
        nomeCli = new JLabel();
        dadoNomeCli = new JTextField();
        entrega = new JLabel();
        dadoEntrega = new ButtonGroup(); 
        entregaSim = new JRadioButton();
        entregaNao = new JRadioButton();
        pagamento = new JLabel();
        dadoPagamento = new JComboBox<>();
        dadoCPF = new JTextField();
        buscaCPF = new JButton();
        confirmaVenda = new JButton();
        cancelaVenda = new JButton();
        valor = new JTextField();
        tValor = new JLabel();
        data = new javax.swing.JLabel();
        itens = new ArrayList<String>();
        
		setVisible(true);
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Realizar Venda");
        setBackground(new java.awt.Color(0, 153, 153));
        
        
        this.jPanel1.setBackground(new Color(255, 255, 255));
        this.jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        this.jPanel2.setBackground(new Color(255, 255, 255));
        this.jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jList1 = new JTextArea();
       /* String[] listData = { "Item 1", "Item 2", "Item 3" };*/
		jScrollPane2.setViewportView(jList1);
		this.jList1.setFont(new Font("Roboto Light", 1, 12));
		jList1.setForeground(new java.awt.Color(153, 153, 153));
        this.titulo.setFont(new Font("Roboto", 1, 24)); 
        this.titulo.setForeground(new Color(0, 204, 204));
        this.titulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.titulo.setText("Área de Vendas");

        this.tCodProd.setFont(new Font("Roboto Light", 1, 13)); 
        this.tCodProd.setForeground(new Color(102, 102, 102));
        this.tCodProd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.tCodProd.setText("Código do produto");

        this.tDescricao.setFont(new Font("Roboto Light", 1, 13)); 
        this.tDescricao.setForeground(new Color(102, 102, 102));
        this.tDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.tDescricao.setText("Descrição do produto");

        this.tQtdd.setFont(new Font("Roboto Light", 1, 13)); 
        this.tQtdd.setForeground(new Color(102, 102, 102));
        this.tQtdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.tQtdd.setText("Quantidade");
        
        this.tValor.setFont(new Font("Roboto Light", 1, 13)); 
        this.tValor.setForeground(new Color(102, 102, 102));
        this.tValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.tValor.setText("Valor Unitário");

        this.codProd.setFont(new Font("Roboto Light", 0, 14)); 
        this.codProd.setForeground(new Color(153, 153, 153));
        this.codProd.setSelectionColor(new java.awt.Color(0, 204, 204));
        
        this.valor.setFont(new Font("Roboto Light", 0, 14)); 
        this.valor.setForeground(new Color(153, 153, 153));
        this.valor.setSelectionColor(new Color(0, 204, 204));
        this.valor.setEditable(false);
        
        this.descrProd.setEditable(false);
        this.descrProd.setFont(new Font("Roboto Light", 0, 14));
        this.descrProd.setForeground(new Color(153, 153, 153));


        this.qttdProd.setFont(new Font("Roboto Light", 0, 14)); 
        this.qttdProd.setForeground(new Color(153, 153, 153));
        this.qttdProd.setSelectionColor(new Color(0, 204, 204));
        
        
        

        this.maisProd.setBackground(new Color(0, 204, 204));
        this.maisProd.setFont(new Font("Roboto Light", 1, 24)); 
        this.maisProd.setForeground(new Color(255, 255, 255));
        this.maisProd.setText("+");
        maisProd.addActionListener(e -> {
        	
        	if( control.existeProduto(Integer.parseInt( codProd.getText())) == true) { //Ver se o campo não é nulo!!!!
        		
        		int codigoProd = Integer.parseInt( codProd.getText());
        		
        		
				descrProd.setText(control.retornaNome(codigoProd)); //Retorna o nome do produto para o campo descricao
				
				this.valor.setText(control.retornaValorUnit(codigoProd));
		
        		//Parte de consultar a quantidade de um produto já encontrado 
        		
        		String qtdInput = qttdProd.getText();
        		
        		if(qtdInput.isEmpty() || Integer.parseInt(qttdProd.getText()) <=0  ) {
        			
        			JOptionPane.showMessageDialog(null, "O campo quantidade está nulo", "Erro", JOptionPane.ERROR_MESSAGE);
        		
        		}else {
        			
        			if(control.consultaEstoque(codigoProd, Integer.parseInt(qtdInput)) == true) {
        				
        				try {
        					
							control.adicionarItemVenda(codigoProd, Integer.parseInt(qtdInput)); //Parte final de adicionar ao Array
							
							JOptionPane.showMessageDialog(null, "Item Adicionado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
							
							
							String itemLista = control.retornaNome(codigoProd);
							
							itens.add(itemLista);
							String texto = String.join("\n", itens);
							jList1.setText(texto);
							
							
					       
							
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				
        			}else {
        				
        				JOptionPane.showMessageDialog(null, "A quantidade desejada ultrapassa a disponibilidade em estoque.", "Erro", JOptionPane.ERROR_MESSAGE);
        			}
        			
        		}
        		
        		
        		
        	
        	}else {
        		
        		
        		System.out.println("Não Achou"); //Produto não encontrado tela
        		JOptionPane.showMessageDialog(null, "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
        	}
        	
        	descrProd.setText(null);
    		
    		valor.setText(null);
    		
    		codProd.setText(null);
    		
    		qttdProd.setText(null);
        	
        });
        


        cpf.setFont(new Font("Roboto Light", 1, 13));
        cpf.setForeground(new Color(102, 102, 102));
        cpf.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cpf.setText("CPF do Cliente:");

        nomeCli.setFont(new Font("Roboto Light", 1, 13)); 
        nomeCli.setForeground(new Color(102, 102, 102));
        nomeCli.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nomeCli.setText("Nome do Cliente:");

        dadoNomeCli.setEditable(false);
        dadoNomeCli.setFont(new Font("Roboto Light", 0, 14)); 
        dadoNomeCli.setForeground(new Color(153, 153, 153));


        entrega.setFont(new Font("Roboto Light", 1, 13)); 
        entrega.setForeground(new Color(102, 102, 102));
        entrega.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        entrega.setText("Cliente solicitou entrega?");

        entregaSim.setFont(new Font("Roboto Light", 1, 13)); 
        entregaSim.setForeground(new java.awt.Color(102, 102, 102));
        entregaSim.setBackground(new Color(255, 255, 255));
        entregaSim.setText("Sim");


        entregaNao.setFont(new Font("Roboto Light", 1, 13)); 
        entregaNao.setForeground(new Color(102, 102, 102));
        entregaNao.setBackground(new Color(255, 255, 255));
        entregaNao.setText("Não");
        
        dadoEntrega.add(entregaSim);
        dadoEntrega.add(entregaNao);

        pagamento.setFont(new Font("Roboto Light", 1, 13)); 
        pagamento.setForeground(new java.awt.Color(102, 102, 102));
        pagamento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pagamento.setText("Selecione a forma de pagamento:");

        dadoPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Dinheiro", "PIX", "Cartão de Débito", "Cartão de Crédito", "Carnê" }));
        dadoPagamento.setToolTipText("Selecione");

        dadoCPF.setFont(new Font("Roboto Light", 0, 14));
        dadoCPF.setForeground(new java.awt.Color(153, 153, 153));
        dadoCPF.setSelectionColor(new java.awt.Color(0, 204, 204));

        buscaCPF.setBackground(new Color(0, 204, 204));
        buscaCPF.setFont(new Font("Roboto Light", 1, 13)); 
        buscaCPF.setForeground(new java.awt.Color(255, 255, 255));
        buscaCPF.setText("Buscar"); 
        buscaCPF.addActionListener(e -> {
        	
        	dadoNomeCli.setText(null);
        	
        	if( control.existeCliente(dadoCPF.getText()) == true) {
        		
        		String CPF = dadoCPF.getText();
        		
        		dadoNomeCli.setText(control.getNomeCli(CPF));
        		
        	}else {
        		
        		JOptionPane.showMessageDialog(null, "Cliente não possui cadastro.", "Erro", JOptionPane.ERROR_MESSAGE);
        	}
        	
        	
        	
        	
        	
        	
        	
        });

        confirmaVenda.setBackground(new Color(0, 204, 204));
        confirmaVenda.setFont(new java.awt.Font("Roboto Light", 1, 13)); 
        confirmaVenda.setForeground(new Color(255, 255, 255));
        confirmaVenda.setText("Confirmar venda");
        
        confirmaVenda.addActionListener(e -> {
        	
        	String resposta = null;
        	   
        	// Obtenha o botão selecionado
        	JRadioButton selectedRadioButton = null;
        	for (Enumeration<AbstractButton> buttons = dadoEntrega.getElements(); buttons.hasMoreElements();) {
        	    AbstractButton button = buttons.nextElement();

        	    if (button.isSelected()) {
        	        selectedRadioButton = (JRadioButton) button;
        	        break;
        	    }
        	}

        	if (selectedRadioButton != null) {
        	    String selectedValue = selectedRadioButton.getText();
                resposta = selectedValue;
                
                String compara = (String) this.dadoPagamento.getSelectedItem();
                
                
                if(compara.equals("Selecione")) {
                   
                	JOptionPane.showMessageDialog(null, "Opção de pagamento não selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
                
                }else {
                	
                	// Bateria de tests para evitar erros 
                	
                	if(control.diferenteDeNull() == true) {
                		
                		if(dadoNomeCli.getText().isEmpty() == false) {
                			
                			try {
        						control.realizarVenda(resposta, dadoCPF.getText());
        						JOptionPane.showMessageDialog(null, "Venda Cadastrada com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        						setVisible(false);
        						
      
        					} catch (SQLException e1) {
        						// TODO Auto-generated catch block
        						e1.printStackTrace();
        					}
                			
                		}else {
                			
                			JOptionPane.showMessageDialog(null, "Não há nenhum cliente associado a venda .", "Erro", JOptionPane.ERROR_MESSAGE);
                			
                		}
                		
                	
                		
                	}else {
                		
                		JOptionPane.showMessageDialog(null, "Não há nenhum produto cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                		
                	}
                	
                	
                }

        	} else {
        		
        		JOptionPane.showMessageDialog(null, "Opção de entrega não foi selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
        	}
        	
        	//System.out.println(resposta);
        	
        	
        	
        	
        });

        this.cancelaVenda.setBackground(new Color(255, 51, 51));
        this.cancelaVenda.setFont(new java.awt.Font("Roboto Light", 1, 13)); 
        this.cancelaVenda.setForeground(new Color(255, 255, 255));
        this.cancelaVenda.setText("Cancelar");
        this.cancelaVenda.addActionListener(e -> {
        	
        	
        	setVisible(false);
        });
        
        this.data.setFont(new Font("Roboto Light", 1, 14)); 
        this.data.setForeground(new Color(0, 0, 0));
        this.data.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        this.data.setText(control.getDateTime());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dadoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entregaSim, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entregaNao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                
                                .addComponent(cancelaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                
                                .addComponent(confirmaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(separador, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tCodProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codProd)
                                    )
                                .addGap(9,9,9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(descrProd)
                                            .addComponent(tDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                                     )) 
                                
                                .addGap(9,9,9)
                                
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(qttdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(tQtdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                
                                        .addGap(9,9,9)
                                        
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(tValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            				.addComponent(data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            				.addGap(9,9,9)
                            			
                            			.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            				.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(30,30,30)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maisProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dadoNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dadoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                		
                            
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))))
                        
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            	.addComponent(data)
                .addGap(27, 27, 27)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCodProd)
                    .addComponent(tDescricao)
                    .addComponent(tQtdd)
                    .addComponent(tValor))
                
                	.addGap(15, 15, 15)
                
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descrProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qttdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                
                .addComponent(maisProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf)
                    .addComponent(dadoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCli)
                    .addComponent(dadoNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrega)
                    .addComponent(entregaSim)
                    .addComponent(entregaNao))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagamento)
                    .addComponent(dadoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmaVenda)
                    .addComponent(cancelaVenda))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		);
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		);

     pack();

	}
}