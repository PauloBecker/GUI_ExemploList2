

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ExemploList2 implements   ActionListener {
	JList<String> jlist; 
	DefaultListModel<String> listModel;
	JTextField txt;

	public ExemploList2 () {
		JFrame frame = new JFrame("Exemplo 2 JList");
		frame.setSize(340, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);

		listModel = new DefaultListModel<String>();
		jlist = new JList<String>(listModel);
		JScrollPane scroll = new JScrollPane(jlist);
		frame.add(scroll, BorderLayout.CENTER);		

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		txt = new JTextField(20);
		panel.add(txt);
		JButton button = new JButton("Adicionar");
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel, BorderLayout.NORTH);

		button = new JButton("Remover");
		button.addActionListener(this);		
		frame.add(button,BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Adicionar")) {
			if(!txt.getText().equalsIgnoreCase("")) {
				listModel.addElement(txt.getText());
				txt.setText("");
			}
		}else if(e.getActionCommand().equalsIgnoreCase("Remover")) {
			int indices[] = jlist.getSelectedIndices();
			for(int i = indices.length-1 ;i>=0 ;i-- ) 
				listModel.remove(indices[i]);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ExemploList2();
			}
		});
	}
}
