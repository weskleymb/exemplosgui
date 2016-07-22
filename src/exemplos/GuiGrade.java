package exemplos;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.*;

public class GuiGrade extends JPanel {

    private JPanel pnPrincipal, pnTable;
    private JButton btRemover, btAdicionar;
    private JScrollPane scrollTable;
    private JTable table;
    private JLabel lbNumero, lbTotal, lbProduto;
    private JLabel lbPrecoUnitario, lbQuantidade;
    private JTextField tfNumero, tfTotal, tfProduto;
    private JTextField tfPrecoUnitario, tfQuantidade;
    
    DecimalFormat df = new DecimalFormat("#,###.00");
    
    public GuiGrade() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbProduto = new JLabel("Produto");
        lbQuantidade = new JLabel("Quantidade");
        lbPrecoUnitario = new JLabel("Preço Unitário");
        lbNumero = new JLabel("Número do Pedido:");
        lbTotal = new JLabel("Total do Pedido:");
        tfProduto = new JTextField();
        tfPrecoUnitario = new JTextField();
        tfQuantidade = new JTextField();
        tfNumero = new JTextField();
        tfTotal = new JTextField();
        btAdicionar = new JButton("Adicionar");
        btRemover = new JButton("Remover");
        scrollTable = new JScrollPane();
        pnPrincipal = new JPanel();
        pnTable = new JPanel(new BorderLayout());
        pnTable.setBorder(new TitledBorder("Itens do Pedido"));
        
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Produto", "Qtd", "P. Unit.", "Total"}, 0) {
            public boolean isCellEditable(int row, int col) {
                if (col == 3) {
                    return false;
                }
                return true;
            }
        };
        
        table = new JTable(model);
        
        DefaultTableCellRenderer alinharDireita = new DefaultTableCellRenderer();
        alinharDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        
        table.getColumnModel().getColumn(1).setCellRenderer(alinharDireita);
        table.getColumnModel().getColumn(2).setCellRenderer(alinharDireita);
        table.getColumnModel().getColumn(3).setCellRenderer(alinharDireita);
        
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollTable.setViewportView(table);
        pnTable.add(scrollTable);
        
        pnPrincipal.setLayout(null);
        
        lbProduto.setBounds(15, 40, 100, 25);
        lbQuantidade.setBounds(225, 40, 100, 25);
        lbPrecoUnitario.setBounds(310, 40, 100, 25);
        lbNumero.setBounds(15, 10, 120, 25);
        lbTotal.setBounds(278, 360, 100, 25);
        tfProduto.setBounds(15, 65, 200, 25);
        tfQuantidade.setBounds(225, 65, 50, 25);
        tfPrecoUnitario.setBounds(310, 65, 80, 25);
        tfNumero.setBounds(130, 10, 50, 25);
        tfTotal.setBounds(375, 360, 100, 25);
        btAdicionar.setBounds(15, 100, 100, 22);
        btRemover.setBounds(125, 100, 100, 22);
        pnTable.setBounds(10, 130, 470, 230);
        pnPrincipal.setBounds(0, 0, 500, 400);
        
        tfTotal.setEnabled(false);
        tfTotal.setHorizontalAlignment(JTextField.RIGHT);
        
        pnPrincipal.add(lbNumero);
        pnPrincipal.add(lbTotal);
        pnPrincipal.add(lbProduto);
        pnPrincipal.add(lbQuantidade);
        pnPrincipal.add(lbPrecoUnitario);
        pnPrincipal.add(tfNumero);
        pnPrincipal.add(tfTotal);
        pnPrincipal.add(tfProduto);
        pnPrincipal.add(tfQuantidade);
        pnPrincipal.add(tfPrecoUnitario);
        pnPrincipal.add(btAdicionar);
        pnPrincipal.add(btRemover);
        pnPrincipal.add(pnTable);
                
        add(pnPrincipal);
    }

    private void definirEventos() {
    
    }
    
}
