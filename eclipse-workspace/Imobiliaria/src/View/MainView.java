package View;

import Controller.ClienteController;
import Controller.ImovelController;
import Controller.TransacaoController;
import Imobiliaria.cliente;
import Imobiliaria.imovel;
import Imobiliaria.Transacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainView extends JFrame {
 private ClienteController clienteController;
 private ImovelController imovelController;
 private TransacaoController transacaoController;
 
 private JTable tabelaClientes;
 private JTable tabelaImoveis;
 private JTable tabelaTransacoes;
 
 public MainView() {
     clienteController = new ClienteController();
     imovelController = new ImovelController();
     transacaoController = new TransacaoController();
     
     setTitle("Sistema de Gerenciamento de Imóveis");
     setSize(800, 600);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     
     JTabbedPane abas = new JTabbedPane();
     
     abas.addTab("Clientes", criarPainelClientes());
     
     abas.addTab("Imóveis", criarPainelImoveis());
     
     abas.addTab("Transações", criarPainelTransacoes());
     
     add(abas);
 }
 
 private JPanel criarPainelClientes() {
     JPanel painel = new JPanel(new BorderLayout());
     
     tabelaClientes = new JTable();
     JScrollPane scroll = new JScrollPane(tabelaClientes);
     painel.add(scroll, BorderLayout.CENTER);
     
     JButton btnAdicionar = new JButton("Adicionar Cliente");
     btnAdicionar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             abrirDialogoAdicionarCliente();
         }
     });
     painel.add(btnAdicionar, BorderLayout.SOUTH);
     
     carregarTabelaClientes();
     
     return painel;
 }
 
 private JPanel criarPainelImoveis() {
     JPanel painel = new JPanel(new BorderLayout());
     
     tabelaImoveis = new JTable();
     JScrollPane scroll = new JScrollPane(tabelaImoveis);
     painel.add(scroll, BorderLayout.CENTER);
     
     JButton btnAdicionar = new JButton("Adicionar Imóvel");
     btnAdicionar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             abrirDialogoAdicionarImovel();
         }
     });
     painel.add(btnAdicionar, BorderLayout.SOUTH);
     
     carregarTabelaImoveis();
     
     return painel;
 }
 
 private JPanel criarPainelTransacoes() {
     JPanel painel = new JPanel(new BorderLayout());
     
     tabelaTransacoes = new JTable();
     JScrollPane scroll = new JScrollPane(tabelaTransacoes);
     painel.add(scroll, BorderLayout.CENTER);
     
     JButton btnAdicionar = new JButton("Adicionar Transação");
     btnAdicionar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             abrirDialogoAdicionarTransacao();
         }
     });
     painel.add(btnAdicionar, BorderLayout.SOUTH);
     
     carregarTabelaTransacoes();
     
     return painel;
 }
 
 private void carregarTabelaClientes() {
     List<cliente> clientes = clienteController.listarClientes();
     String[] colunas = {"ID", "Nome", "Tipo Relacionamento", "Telefone", "Avaliação"};
     DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
     
     for (cliente c : clientes) {
         Object[] linha = {c.getIdCliente(), c.getNome(), c.getTipoRelacionamento(), c.getTelefone(), c.getAvaliacaoCliente()};
         modelo.addRow(linha);
     }
     
     tabelaClientes.setModel(modelo);
 }
 
 private void carregarTabelaImoveis() {
     List<imovel> imoveis = imovelController.listarImoveis();
     String[] colunas = {"ID", "Categoria", "Área", "Valor Sugerido", "Valor Real", "Endereço", "Bairro", "Data Construção", "Disponibilidade", "Descrição"};
     DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
     
     for (imovel i : imoveis) {
         Object[] linha = {
             i.getIdImovel(), i.getCategoria(), i.getArea(), i.getValorSugerido(),
             i.getValorReal(), i.getEndereco(), i.getBairro(),
             i.getDataConstrucao(), i.getDisponibilidade(), i.getDescricao()
         };
         modelo.addRow(linha);
     }
     
     tabelaImoveis.setModel(modelo);
 }
 
 private void carregarTabelaTransacoes() {
     List<Transacao> transacoes = transacaoController.listarTransacoes();
     String[] colunas = {"ID", "ID Imóvel", "ID Cliente", "Data Transação", "Valor", "Tipo Transação"};
     DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
     
     for (Transacao t : transacoes) {
         Object[] linha = {
             t.getIdTransacao(), t.getIdImovel(), t.getIdCliente(),
             t.getDataTransacao(), t.getValor(), t.getTipoTransacao()
         };
         modelo.addRow(linha);
     }
     
     tabelaTransacoes.setModel(modelo);
 }
 
 private void abrirDialogoAdicionarCliente() {
     JDialog dialogo = new JDialog(this, "Adicionar Cliente", true);
     dialogo.setSize(400, 300);
     dialogo.setLayout(new GridLayout(6, 2));
     
     JLabel lblNome = new JLabel("Nome:");
     JTextField txtNome = new JTextField();
     
     JLabel lblTipoRelacionamento = new JLabel("Tipo Relacionamento:");
     String[] tipos = {"inquilino", "locatário", "comprador", "vendedor"};
     JComboBox<String> cbTipoRelacionamento = new JComboBox<>(tipos);
     
     JLabel lblTelefone = new JLabel("Telefone:");
     JTextField txtTelefone = new JTextField();
     
     JLabel lblAvaliacao = new JLabel("Avaliação Cliente:");
     JTextField txtAvaliacao = new JTextField();
     
     JButton btnSalvar = new JButton("Salvar");
     JButton btnCancelar = new JButton("Cancelar");
     
     btnSalvar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             String nome = txtNome.getText();
             String tipo = (String) cbTipoRelacionamento.getSelectedItem();
             String telefone = txtTelefone.getText();
             double avaliacao;
             
             try {
                 avaliacao = Double.parseDouble(txtAvaliacao.getText());
             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(dialogo, "Avaliação inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                 return;
             }
             
             cliente cliente = new cliente();
             cliente.setNome(nome);
             cliente.setTipoRelacionamento(tipo);
             cliente.setTelefone(telefone);
             cliente.setAvaliacaoCliente(avaliacao);
             
             clienteController.adicionarCliente(cliente);
             carregarTabelaClientes();
             dialogo.dispose();
         }
     });
     
     btnCancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             dialogo.dispose();
         }
     });
     
     dialogo.add(lblNome);
     dialogo.add(txtNome);
     dialogo.add(lblTipoRelacionamento);
     dialogo.add(cbTipoRelacionamento);
     dialogo.add(lblTelefone);
     dialogo.add(txtTelefone);
     dialogo.add(lblAvaliacao);
     dialogo.add(txtAvaliacao);
     dialogo.add(btnSalvar);
     dialogo.add(btnCancelar);
     
     dialogo.setVisible(true);
 }
 
 private void abrirDialogoAdicionarImovel() {
     JDialog dialogo = new JDialog(this, "Adicionar Imóvel", true);
     dialogo.setSize(500, 500);
     dialogo.setLayout(new GridLayout(11, 2));
     
     JLabel lblCategoria = new JLabel("Categoria:");
     String[] categorias = {"casa", "apartamento", "terreno", "sala_comercial"};
     JComboBox<String> cbCategoria = new JComboBox<>(categorias);
     
     JLabel lblArea = new JLabel("Área:");
     JTextField txtArea = new JTextField();
     
     JLabel lblValorSugerido = new JLabel("Valor Sugerido:");
     JTextField txtValorSugerido = new JTextField();
     
     JLabel lblValorReal = new JLabel("Valor Real:");
     JTextField txtValorReal = new JTextField();
     
     JLabel lblEndereco = new JLabel("Endereço:");
     JTextField txtEndereco = new JTextField();
     
     JLabel lblBairro = new JLabel("Bairro:");
     JTextField txtBairro = new JTextField();
     
     JLabel lblDataConstrucao = new JLabel("Data Construção (AAAA-MM-DD):");
     JTextField txtDataConstrucao = new JTextField();
     
     JLabel lblDisponibilidade = new JLabel("Disponibilidade:");
     String[] disponibilidades = {"disponível", "vendido", "locado"};
     JComboBox<String> cbDisponibilidade = new JComboBox<>(disponibilidades);
     
     JLabel lblDescricao = new JLabel("Descrição:");
     JTextArea txtDescricao = new JTextArea();
     
     JButton btnSalvar = new JButton("Salvar");
     JButton btnCancelar = new JButton("Cancelar");
     
     btnSalvar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             String categoria = (String) cbCategoria.getSelectedItem();
             double area;
             double valorSugerido;
             Double valorReal = null;
             String endereco = txtEndereco.getText();
             String bairro = txtBairro.getText();
             java.util.Date dataConstrucao;
             String disponibilidade = (String) cbDisponibilidade.getSelectedItem();
             String descricao = txtDescricao.getText();
             
             try {
                 area = Double.parseDouble(txtArea.getText());
                 valorSugerido = Double.parseDouble(txtValorSugerido.getText());
                 String valorRealStr = txtValorReal.getText();
                 if (!valorRealStr.isEmpty()) {
                     valorReal = Double.parseDouble(valorRealStr);
                 }
                 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                 dataConstrucao = sdf.parse(txtDataConstrucao.getText());
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(dialogo, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                 return;
             }
             
             imovel imovel = new imovel();
             imovel.setCategoria(categoria);
             imovel.setArea(area);
             imovel.setValorSugerido(valorSugerido);
             imovel.setValorReal(valorReal);
             imovel.setEndereco(endereco);
             imovel.setBairro(bairro);
             imovel.setDataConstrucao(dataConstrucao);
             imovel.setDisponibilidade(disponibilidade);
             imovel.setDescricao(descricao);
             
             imovelController.adicionarImovel(imovel);
             carregarTabelaImoveis();
             dialogo.dispose();
         }
     });
     
     btnCancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             dialogo.dispose();
         }
     });
     
     dialogo.add(lblCategoria);
     dialogo.add(cbCategoria);
     dialogo.add(lblArea);
     dialogo.add(txtArea);
     dialogo.add(lblValorSugerido);
     dialogo.add(txtValorSugerido);
     dialogo.add(lblValorReal);
     dialogo.add(txtValorReal);
     dialogo.add(lblEndereco);
     dialogo.add(txtEndereco);
     dialogo.add(lblBairro);
     dialogo.add(txtBairro);
     dialogo.add(lblDataConstrucao);
     dialogo.add(txtDataConstrucao);
     dialogo.add(lblDisponibilidade);
     dialogo.add(cbDisponibilidade);
     dialogo.add(lblDescricao);
     dialogo.add(new JScrollPane(txtDescricao));
     dialogo.add(btnSalvar);
     dialogo.add(btnCancelar);
     
     dialogo.setVisible(true);
 }
 
 private void abrirDialogoAdicionarTransacao() {
     JDialog dialogo = new JDialog(this, "Adicionar Transação", true);
     dialogo.setSize(400, 400);
     dialogo.setLayout(new GridLayout(7, 2));
     
     JLabel lblIdImovel = new JLabel("ID Imóvel:");
     JTextField txtIdImovel = new JTextField();
     
     JLabel lblIdCliente = new JLabel("ID Cliente:");
     JTextField txtIdCliente = new JTextField();
     
     JLabel lblDataTransacao = new JLabel("Data Transação (AAAA-MM-DD):");
     JTextField txtDataTransacao = new JTextField();
     
     JLabel lblValor = new JLabel("Valor:");
     JTextField txtValor = new JTextField();
     
     JLabel lblTipoTransacao = new JLabel("Tipo Transação:");
     String[] tipos = {"venda", "aluguel"};
     JComboBox<String> cbTipoTransacao = new JComboBox<>(tipos);
     
     JButton btnSalvar = new JButton("Salvar");
     JButton btnCancelar = new JButton("Cancelar");
     
     btnSalvar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             int idImovel;
             int idCliente;
             java.util.Date dataTransacao;
             double valor;
             String tipoTransacao;
             
             try {
                 idImovel = Integer.parseInt(txtIdImovel.getText());
                 idCliente = Integer.parseInt(txtIdCliente.getText());
                 java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                 dataTransacao = sdf.parse(txtDataTransacao.getText());
                 valor = Double.parseDouble(txtValor.getText());
                 tipoTransacao = (String) cbTipoTransacao.getSelectedItem();
             } catch (Exception ex) {
                 JOptionPane.showMessageDialog(dialogo, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                 return;
             }
             
             Transacao transacao = new Transacao();
             transacao.setIdImovel(idImovel);
             transacao.setIdCliente(idCliente);
             transacao.setDataTransacao(dataTransacao);
             transacao.setValor(valor);
             transacao.setTipoTransacao(tipoTransacao);
             
             transacaoController.adicionarTransacao(transacao);
             carregarTabelaTransacoes();
             dialogo.dispose();
         }
     });
     
     btnCancelar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             dialogo.dispose();
         }
     });
     
     dialogo.add(lblIdImovel);
     dialogo.add(txtIdImovel);
     dialogo.add(lblIdCliente);
     dialogo.add(txtIdCliente);
     dialogo.add(lblDataTransacao);
     dialogo.add(txtDataTransacao);
     dialogo.add(lblValor);
     dialogo.add(txtValor);
     dialogo.add(lblTipoTransacao);
     dialogo.add(cbTipoTransacao);
     dialogo.add(btnSalvar);
     dialogo.add(btnCancelar);
     
     dialogo.setVisible(true);
 }
}
