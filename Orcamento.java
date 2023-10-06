import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrcamentoApp extends JFrame {

    private JTextArea orcamentoArea;

    public OrcamentoApp() {
        // Configurar a janela principal
        setTitle("Sistema de Orçamento e Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Painel para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Área de texto para exibir o orçamento
        orcamentoArea = new JTextArea();
        panel.add(new JScrollPane(orcamentoArea), BorderLayout.CENTER);

        // Botão para cadastrar venda
        JButton cadastrarVendaButton = new JButton("Cadastrar Venda");
        cadastrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode implementar a lógica para cadastrar uma venda
                // e adicionar as informações ao orçamento
                // Por exemplo:
                String produto = JOptionPane.showInputDialog("Nome do Produto:");
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do Produto:"));
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
                double total = preco * quantidade;
                adicionarItemAoOrcamento(produto, preco, quantidade, total);
            }
        });
        panel.add(cadastrarVendaButton, BorderLayout.SOUTH);

        // Botão para imprimir orçamento
        JButton imprimirOrcamentoButton = new JButton("Imprimir Orçamento");
        imprimirOrcamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode implementar a lógica para imprimir o orçamento
                imprimirOrcamento();
            }
        });
        panel.add(imprimirOrcamentoButton, BorderLayout.NORTH);

        // Adicionar o painel à janela principal
        add(panel);

        // Exibir a janela
        setVisible(true);
    }

    private void adicionarItemAoOrcamento(String produto, double preco, int quantidade, double total) {
        // Adicione as informações da venda à área de texto de orçamento
        String item = produto + " - Preço: $" + preco + " x " + quantidade + " = $" + total + "\n";
        orcamentoArea.append(item);
    }

    private void imprimirOrcamento() {
        // Aqui você pode implementar a lógica de impressão do orçamento
        // Você pode usar uma biblioteca de impressão Java ou gerar um arquivo PDF, por exemplo.
        // Por simplicidade, vamos apenas exibir o conteúdo na área de texto.
        JOptionPane.showMessageDialog(this, "Orçamento:\n" + orcamentoArea.getText(), "Impressão de Orçamento", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OrcamentoApp();
            }
        });
    }
}