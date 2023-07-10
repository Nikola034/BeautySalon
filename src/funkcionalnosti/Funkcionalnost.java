package funkcionalnosti;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import entitetiSalona.KozmetickiSalon;
import entitetiSalona.Tretman;
import entitetiSalona.ZakazanTretman;
import korisnici.Kozmeticar;

public class Funkcionalnost {
	
	public static String dateToString(Date vreme) 
	{
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(vreme);
	}
	public static Date stringToDate(String string) 
	{
		try {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Date();
		}
	}
	
	public static void CentrirajTabelu(JTable table) 
	{
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
	}
	
	public static String PretvoriTretmane(List<Integer> obucenZaTretmane) 
	{
		StringBuilder stringBuilder = new StringBuilder("");
		for (Integer tipTretmana : obucenZaTretmane) {
			stringBuilder.append(tipTretmana.toString()).append("-");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}
	
	public static List<String> ProcitajVestineKozmeticara(List<Integer> vestine) 
	{
		List<String> lista = new ArrayList<String>();
		for (Integer id : vestine) {
			Tretman tretman = Tretman.NadjiPoID(id, KozmetickiSalon.tretmani);
			lista.add(tretman.getNaziv());
		}
		return lista;
	}
	
	public static Boolean DaLiJeSlobodan(int idKozmeticara, Date datum, String vreme) 
	{
		int sat = Integer.parseInt(vreme.split(":")[0]);
		for (ZakazanTretman zakazanTretman : KozmetickiSalon.zakazaniTretmani) {
			if(zakazanTretman.getIdKozmeticara() == idKozmeticara && zakazanTretman.getVreme().getYear() == datum.getYear() && 
					zakazanTretman.getVreme().getMonth() == datum.getMonth() && zakazanTretman.getVreme().getDate() == datum.getDate() && 
					zakazanTretman.getVreme().getHours() == sat) return false;
		}
		return true;
	}
}
