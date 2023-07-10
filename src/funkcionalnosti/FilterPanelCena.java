package funkcionalnosti;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class FilterPanelCena extends JPanel {
	public static JTextField textFieldOd;
	public static JTextField textFieldDo;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public FilterPanelCena() {
		setLayout(new MigLayout("", "[][][][grow]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("Cena OD:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblNewLabel, "flowx,cell 3 1,alignx center,aligny center");
		
		textFieldOd = new JTextField();
		textFieldOd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(textFieldOd, "cell 3 1,alignx center,aligny center");
		textFieldOd.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Cena DO:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblNewLabel_1, "flowx,cell 3 3,alignx center,aligny center");
		
		textFieldDo = new JTextField();
		textFieldDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldDo.setColumns(10);
		add(textFieldDo, "cell 3 3,alignx center,aligny center");

	}

}
