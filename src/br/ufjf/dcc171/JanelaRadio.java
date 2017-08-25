package br.ufjf.dcc171;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JanelaRadio extends JFrame {
    
    private final JTextField mensagem = new JTextField("Universidade Federal de Juiz de Fora");
    private final JRadioButton rbPlano;
    private final JRadioButton rbNegrito;
    private final JRadioButton rbItalico;
    private final JRadioButton rbNI;

    public JanelaRadio() throws HeadlessException {
        super("Radio Button");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        rbPlano = new JRadioButton("Plano", true);
        rbNegrito = new JRadioButton("Negrito", false);
        rbItalico= new JRadioButton("Itálico", false);
        rbNI= new JRadioButton("Negrito e Itálico", false);
        
        
        add(mensagem);
        add(rbPlano);
        add(rbNegrito);
        add(rbItalico);
        add(rbNI);
        
        ButtonGroup bgEstilo = new ButtonGroup();
        
        bgEstilo.add(rbPlano);
        bgEstilo.add(rbNegrito);
        bgEstilo.add(rbItalico);
        bgEstilo.add(rbNI);
        
        Font fntPlano = new Font(Font.SERIF, Font.PLAIN, 14);
        Font fntNegrito = new Font(Font.SERIF, Font.BOLD, 14);
        Font fntItalico = new Font(Font.SERIF, Font.ITALIC, 14);
        Font fntNI = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 14);
        
        mensagem.setFont(fntPlano);
        
        rbPlano.addItemListener(new EstiloRadio(fntPlano));
        rbNegrito.addItemListener(new EstiloRadio(fntNegrito));
        rbItalico.addItemListener(new EstiloRadio(fntItalico));
        rbNI.addItemListener(new EstiloRadio(fntNI));
    }

    private class EstiloRadio implements ItemListener {
        private Font fonte;
        public EstiloRadio(Font fonte)
        {
            this.fonte = fonte;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            mensagem.setFont(fonte);
        }

       
    }

}
